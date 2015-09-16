package com.yisisoftware.action.location;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.yisisoftware.action.base.BaseAction;
import com.yisisoftware.databaseUtils.DatabaseHolder;
import com.yisisoftware.entity.AppICInfoUp;
import com.yisisoftware.entity.MapPoint;
import com.yisisoftware.entity.WorkSpace;
import com.yisisoftware.entity.view.EntityICCard;
import com.yisisoftware.entity.view.IcPicInfo;
import com.yisisoftware.service.business.inventory.WbCarsServiceI;
import com.yisisoftware.service.business.inventory.WbMaterialServiceI;
import com.yisisoftware.service.location.AppICInfoUpServiceI;
import com.yisisoftware.service.location.IICInfoServiceI;
import com.yisisoftware.service.location.ILocationServiceI;
import com.yisisoftware.service.location.IWorkSpaceServiceI;
import com.yisisoftware.util.base.ConfigUtil;
import com.yisisoftware.util.base.HqlFilter;
import com.yisisoftware.util.base.IcComparator;
import com.yisisoftware.view.WbCars;
import com.yisisoftware.view.WbMaterial;

@Controller
public class MsgAction extends BaseAction {
	private String imagePath;
	private Logger logger=Logger.getLogger(getClass());
	private MapPoint point;
	@Autowired
	private ILocationServiceI locationService;
	@Autowired
	private IICInfoServiceI icInfoService;
	@Autowired
	private IWorkSpaceServiceI workSpaceService;
	@Autowired
	private WbCarsServiceI WbCarsService;
	@Autowired
	private WbMaterialServiceI WbMaterialService;
	@Autowired
	private AppICInfoUpServiceI appICInfoUpService;
	
	public void saveICInfo() {
		Map<String, String> map_bak = new HashMap<>();
		try {
			imagePath=ServletActionContext.getServletContext().getRealPath("/")+"image";
			DateFormat df = new SimpleDateFormat("yyyyMMdd");
			imagePath=ConfigUtil.get("imagePath")+File.separator+df.format(new Date());
//			Calendar cal=Calendar.getInstance(Locale.CHINA);
			logger.info("开始提交IC卡信息");
			String json=getRequest().getParameter("ICjson");
			System.out.println(json);
			EntityICCard ic=null;
			if(!StringUtils.isEmpty(json)){
				ic=JSON.parseObject(json,EntityICCard.class);
			}
			if(ic==null){
				logger.info("提交信息中IC卡信息为空");
				Map<String, String> map = new HashMap<>();
				map.put("result", "false");
				writeJson(map);
				return;
			}
//			imagePath=imagePath+File.separator+ic.getLoader()+cal.get(Calendar.YEAR)+cal.get(Calendar.MONTH)+cal.get(Calendar.DAY_OF_MONTH);
			icInfoService.saveFile(imagePath,ic);
			ic.setPic1Name(imagePath+File.separator+ic.getPic1Name());
			ic.setPic2Name(imagePath+File.separator+ic.getPic2Name());
			ic.setPic3Name(imagePath+File.separator+ic.getPic3Name());
			ic.setPic1(null);
			ic.setPic2(null);
			ic.setPic3(null);
			AppICInfoUp au = new AppICInfoUp();
			copyBeanForEntityIcCard(ic, au);
//			//传递车号
//			HqlFilter hqlFiltera= new HqlFilter();
//			hqlFiltera.addFilter("QUERY_t#name_S_EQ", ic.getCarNum());
//			WbCars wcar = this.WbCarsService.getByFilter(hqlFiltera);
			au.setCars(ic.getCarNum());
//			//传递物料
//			HqlFilter hqlfilterb = new HqlFilter();
//			hqlfilterb.addFilter("QUERY_t#name_S_EQ", ic.getMaterial());
//			WbMaterial wmial = this.WbMaterialService.getByFilter(hqlfilterb);
			au.setMaterial(ic.getMaterial());
			//ic类中的图片信息排序存储到list中
			List<IcPicInfo> rlist = icToList(ic);
			//删除旧数据
			HqlFilter fr = new HqlFilter();
			fr.addFilter("QUERY_t#billNO_S_EQ", ic.getBangId());
			List<AppICInfoUp> tmp_appUpList = this.appICInfoUpService.findByFilter(fr);
			for(AppICInfoUp tu : tmp_appUpList){
				this.appICInfoUpService.delete(tu);
			}
			for(int j=0;j<rlist.size();j++){
				AppICInfoUp aut = new AppICInfoUp();
				BeanUtils.copyProperties(au, aut);
				Date picDateT = new SimpleDateFormat("yyyyMMddHHmmss").parse(rlist.get(j).getTime().toString());
				aut.setPicPath(rlist.get(j).getPicName());
				aut.setPicTime(picDateT);
				aut.setPicOrder(Integer.valueOf(j));
				this.appICInfoUpService.save(aut);
			}
			map_bak.put("result", "true");
		} catch (BeansException e) {
			map_bak.put("result", "false");
		} catch (ParseException e) {
			map_bak.put("result", "false");
		}finally{
			writeJson(map_bak);
		}
		
	}
	private List<IcPicInfo> icToList(EntityICCard ic) {
		List<IcPicInfo> r = new ArrayList<>();
		if(StringUtils.isNotEmpty(ic.getPic1Name())){
			IcPicInfo icInfo = icPicToMap(ic.getPic1Name());
			r.add(icInfo);
		}
		if(StringUtils.isNotEmpty(ic.getPic2Name())){
			IcPicInfo icInfo = icPicToMap(ic.getPic2Name());
			r.add(icInfo);
		}
		if(StringUtils.isNotEmpty(ic.getPic3Name())){
			IcPicInfo icInfo = icPicToMap(ic.getPic3Name());
			r.add(icInfo);
		}
		IcComparator iccom = new IcComparator();
		Collections.sort(r, iccom);
		return r;
	}
	
	private IcPicInfo icPicToMap(String pic1Name) {
		IcPicInfo icInfoTmp = new IcPicInfo();
		String picName = StringUtils.substringAfterLast(pic1Name, "\\");
		String time = StringUtils.substring(picName,picName.length()-18, picName.length()-4);	//e_0120150720142158.jpg
		icInfoTmp.setPicName(pic1Name);
		icInfoTmp.setTime(Long.valueOf(time));
		return icInfoTmp;
	}
	private void copyBeanForEntityIcCard(EntityICCard src,AppICInfoUp tobean){
		tobean.setBillNO(src.getBangId()); //磅单号
		tobean.setZcUser(src.getLoader()); //装车人员
		tobean.setPhoneNum(src.getPhoneNum()); //手持机号
		tobean.setPcBillNO(src.getIcCardId()); //派车单号
	}
	
	public void getMapPoint(){
		point=null;
		HqlFilter hqlFilter2 = new HqlFilter();
		hqlFilter2.addOrder("desc");
		hqlFilter2.addSort("time");
		String hql = "from MapPoint t";
		DatabaseHolder.getInstance().setDataBaseSource(DatabaseHolder.getDbKeys(0).toString());
		List<MapPoint>  points = locationService.find(hql+hqlFilter2.getWhereAndOrderHql());
		if (points!=null&&!points.isEmpty()) {
			point=points.get(0);
		}else{
			point=new MapPoint(0, 114.21892734521,29.575429778924, new Date(), "15034010946", "e_01", "wf");
		}
		writeJson(point);
	}
	public void getAllPoints(){
		String hql = "from MapPoint t";
		DatabaseHolder.getInstance().setDataBaseSource(DatabaseHolder.getDbKeys(0).toString());
		List<MapPoint>  points = locationService.find();
		writeJson(points);
	}
	public void drawMap(){
		List result=new ArrayList();
		DatabaseHolder.getInstance().setDataBaseSource(DatabaseHolder.getDbKeys(0).toString());
		List<WorkSpace> list=workSpaceService.find();
		for (WorkSpace workSpace : list) {
			Map<String, Object> work=new HashMap<String, Object>();
			work.put("work",workSpace);
			String[] sonNames=workSpace.getSons().split(",");
			List<MapPoint> sons=new ArrayList<MapPoint>();
			for (String sName : sonNames) {
				HqlFilter hqlFilter = new HqlFilter();
				hqlFilter.addFilter("QUERY_t#name_S_EQ", sName);
				List<MapPoint> ss=locationService.findByFilter(hqlFilter);
				sons.add(ss.get(0));
			}
			work.put("sons",sons);
			result.add(work);
		}
		writeJson(result);
	}
	
	
	public MapPoint getPoint() {
		return point;
	}

	public void setPoint(MapPoint point) {
		this.point = point;
	}
	
}
