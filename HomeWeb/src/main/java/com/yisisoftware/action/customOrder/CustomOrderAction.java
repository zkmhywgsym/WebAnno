package com.yisisoftware.action.customOrder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yisisoftware.action.base.BaseAction;
import com.yisisoftware.entity.EntityOrder;
import com.yisisoftware.entity.TsSysTcorders;
import com.yisisoftware.entity.WbCustomerReceipt;
import com.yisisoftware.entity.WbWeight;
import com.yisisoftware.exception.DoubleSubmitException;
import com.yisisoftware.exception.ParmException;
import com.yisisoftware.service.business.inventory.TsSysTcordersServiceI;
import com.yisisoftware.service.business.inventory.WbWeightInfoServiceI;
import com.yisisoftware.service.business.statistics.EntityOrderServiceI;
import com.yisisoftware.service.business.statistics.WbCustomerReceiptServiceI;
import com.yisisoftware.util.base.Constant;
import com.yisisoftware.util.base.HqlFilter;
@Controller
public class CustomOrderAction extends BaseAction {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CustomOrderAction.class);

	@Autowired
	private EntityOrderServiceI entityOrderService;
	@Autowired
	private WbWeightInfoServiceI wbWeightInfo;
	@Autowired
	private TsSysTcordersServiceI tsSysTcordersService;
	@Autowired
	private WbCustomerReceiptServiceI wbCustomerReceiptService;
	

	public void add(){
		String orderStr=getRequest().getParameter("order");
		EntityOrder order=null;
		if(!StringUtils.isEmpty(orderStr)){
			order=JSON.parseObject(orderStr,EntityOrder.class);
		}
		String result = "";
		try {
			
			entityOrderService.save(order);
			result = "true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result ="false";
		}finally{
			Map<String, String>res=new HashMap<String, String>();
			res.put("result", result);
			writeJson(res);
		}
	}
	
	/**
	 * 查询表单
	 * 
	 * @return	
	 */
	public void query(){
		String orderId=getRequest().getParameter("orderId");
		String sql = "select a.BillNO as billNo,b.Name as customer,c.Name as cars,d.Name as material , a.suttle as suttle from WB_Weight as a "
				+ "LEFT OUTER JOIN WB_Customer as b on Customer = b.Id "
				+ "LEFT OUTER JOIN WB_Cars as c on a.cars = c.id "
				+ "LEFT JOIN WB_Material as d on a.Material = d.Id where 1=1 ";
		if(StringUtils.isNotEmpty(orderId)){
			sql+=" and a.BillNO = '"+orderId+"'";
			List<Object[]> list = this.entityOrderService.findBySql(sql);
			if(!list.isEmpty()){
				Map<String, Object> map = new HashMap<>();
				map.put("billNo", list.get(0)[0]);
				map.put("customer", list.get(0)[1]);
				map.put("cars", list.get(0)[2]);
				map.put("material", list.get(0)[3]);
				map.put("suttle", list.get(0)[4]);
				writeJson(map);
			}
		}
	}
	
	public boolean isNum(String str){
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
	}
	
	public void modify(){
		Map<String, Object> _bakMap = new HashMap<>();
		try {
			String orderStr=getRequest().getParameter("order");
			if(!StringUtils.isEmpty(orderStr)){
				JSONObject jobj = JSON.parseObject(orderStr);
				String billnos = jobj.getString("billNo");	//获得过磅单号
				String realSends = jobj.getString("realSend"); //获得实收数量
				String reciveTimes = jobj.getString("reciveTime"); //获得验收时间
				String recivers = jobj.getString("reciver"); //获得验收人
				String remarks = jobj.getString("remarks"); //获得备注信息
				String _tmpSql = "select count(*) from WB_CustomerReceipt where WeightBillNO ='"+billnos+"'";
				List<Object> countList_tmp = this.entityOrderService.findBySql(_tmpSql);
				Integer _count = Integer.valueOf(String.valueOf(countList_tmp.get(0)));
				if(_count !=0){
					throw new DoubleSubmitException("重复提交");
				}
				if(!isNum(realSends)){
					throw new ParmException("包含非数字字符");
				}
				if(StringUtils.isEmpty(billnos)){
					throw new ParmException("过磅单号为空");
				}
				//根据过榜单号 获得基本过磅信息
				HqlFilter hqlFilter = new HqlFilter();
				hqlFilter.addFilter("QUERY_t#billNo_S_EQ", billnos);
				WbWeight weight = this.wbWeightInfo.getByFilter(hqlFilter);
				//获得运输单价
				Double ysPrice = 0D;
				//weight.getReservationChar5()==null || weight.getReservationChar5()=="" ?"":weight.getReservationChar5()
				String _t_sql = "";
				if(StringUtils.isNotEmpty(weight.getReservationChar5())){
					_t_sql = weight.getReservationChar5();
				}
				String _ysSql = "select ttprice from TS_SysTCOrdersDetail where contractBillNo='"+_t_sql +"'";
				List _yslist = this.entityOrderService.findBySql(_ysSql);
				if(_yslist.size()>0){
					ysPrice = Double.valueOf(String.valueOf(_yslist.get(0)));
				}
				
				Double yfsuttle = weight.getSuttle();	//获得原发重
				Double suttle = Double.valueOf(realSends);
				
				WbCustomerReceipt wr = new WbCustomerReceipt();
//				wr.setBillNo(getNewHZbillNo(Constant.HZD_TABLE_TYPE));  	//设置单据编号
//				this.wbCustomerReceiptService.save(wr);
//				
				wr.setBillNo(getNewHZbillNo(Constant.HZD_TABLE_TYPE));  	//设置单据编号
				wr.setWeightBillNo(billnos);	//设置过磅单号
				wr.setContractBillNo(weight.getContractBillNo()); 	//设置合同编号
				wr.setCars(weight.getCars());	//设置车牌号
				wr.setCustomer(weight.getCustomer());  //设置客户
				wr.setMaterial(weight.getMaterial()); 	//设置物料
				wr.setReceive(weight.getReceive());  //设置发货单位
				wr.setLightDate(weight.getLightDate());  //设置轻车时间
				wr.setWeightDate(weight.getWeightDate());  //设置实发时间
				wr.setGross(weight.getGross());  //设置实发毛重
				wr.setTare(weight.getTare());  	//设置实发皮重
				wr.setSuttle(weight.getSuttle());  //设置实发净重
				wr.setReservationChar1(reciveTimes);   //实收时间
				wr.setYfsuttle(Double.valueOf(realSends));  //设置实收净重
				wr.setCutWeight(suttle-yfsuttle);   //设置扣吨  
				Double _poor = (double) ((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(reciveTimes).getTime() - weight.getWeightDate().getTime())/(60*1000));
				wr.setReservationList1(String.valueOf(convert(_poor,2)));		//设置耗时
				wr.setLoadCars(weight.getReservationChar5());  //设置运输合同
				wr.setPrice(weight.getPrice());  	//设置单价
				wr.setCharge(convert(weight.getPrice()*weight.getSuttle(),3));	//设置金额
				if(ysPrice !=0D){
					//运输单价不为0时
					wr.setReservationNums1(convert(ysPrice*Double.valueOf(realSends), 3)); //设置应结金额
				}
				wr.setReservationNums2(convert(weight.getPrice()*(suttle-yfsuttle), 3));   //设置亏吨扣款
				if(ysPrice !=0D){
					//运输单价不为0时
					wr.setTrafficPrice(convert(ysPrice, 3));  //设置销售单价
				}
				if(ysPrice !=0D){
					//运输单价不为0时
					wr.setTrafficCharge(convert(ysPrice*Double.valueOf(realSends), 3)-convert(weight.getPrice()*(suttle-yfsuttle), 3));		//设置运输金额
				}
				wr.setOutDbuser(weight.getOutDbuser()); 	//设置过磅人
				wr.setReservationList2(recivers);		//设置验收人
				wr.setMemo(remarks);	//设置备注
//				writeJson(wr);
				this.wbCustomerReceiptService.save(wr);
				_bakMap.put("status", "1");	//返回正常
			}
		} catch (ParmException e) {
			//参数错误
			_bakMap.put("status", "2");	
		} catch (DoubleSubmitException e) {
			// 重复提交
			_bakMap.put("status", "4");	
		} catch (NumberFormatException e) {
			// 内部错误
			_bakMap.put("status", "3");	
		} catch (Exception e){
			//内部错误
			_bakMap.put("status", "3");	
		}finally{
			writeJson(_bakMap);
		}
		
	}
	
	/**
	 * 保留2位小数
	 * @param d	格式化源数据
	 * @param num 保留的位数
	 * @return
	 */
	public Double convert(Double value,int num){
	  int t=1;
	  for(int i = 0;i<num;i++){
		  t = t*10;
	  }
	  long   l1   =   Math.round(value*t);   //四舍五入  
      double   ret   =   l1/100.0;       //注意：使用   100.0   而不是   100  
      return   ret;   
	}
	
	/**
	 * 获得新的回执单编号
	 * @param type 表类型
	 * @return
	 */
	public String getNewHZbillNo(String type){
		String billno = "";
		//获得编码规则
		String codeSql = "select DocType,NumberMode,DocHead from TS_SysDocNo where DocName='"+type+"'";
		List<Object[]> codeList = this.entityOrderService.findBySql(codeSql);
		String qz = codeList.get(0)[0].toString(); //获得前缀
		String mi = codeList.get(0)[1].toString(); //获得中间  yyyyMMdd
		String hz = codeList.get(0)[2].toString(); //获得后缀
		SimpleDateFormat sf = new SimpleDateFormat(mi);
		String datefm = sf.format(new Date()); //获得日期格式化字段
		//获得最后一条回执记录编号
		String hzSql = "select top 1 billno from WB_CustomerReceipt order by id desc";
		List<Object> hzList = this.entityOrderService.findBySql(hzSql);
		if(hzList == null || hzList.size() ==0){
			//回执表中没有记录时
			billno = qz+datefm+hz;
		}else{
			String tmpBillNO = String.valueOf(hzList.get(0));
			String k = StringUtils.replace(tmpBillNO, qz+datefm, "");
			Long num = Long.valueOf(StringUtils.substring(tmpBillNO, (qz+datefm).length()));
			billno = qz+datefm+backZero(hz.length()-String.valueOf(num++).length())+String.valueOf(num++);
		}
		return billno;
	}
	
	public String backZero(int lo){
		String str = "";
		for(int i=0;i<lo;i++){
			str+="0";
		}
		return str;
	}
}
