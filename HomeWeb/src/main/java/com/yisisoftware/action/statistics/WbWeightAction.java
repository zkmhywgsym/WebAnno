package com.yisisoftware.action.statistics;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.yisisoftware.action.base.BaseAction;
import com.yisisoftware.databaseUtils.DatabaseHolder;
import com.yisisoftware.entity.LoginUser;
import com.yisisoftware.entity.UserInfo;
import com.yisisoftware.entity.view.QrInfo;
import com.yisisoftware.entity.view.WbWeightView;
import com.yisisoftware.service.business.statistics.WbWeightServiceI;
import com.yisisoftware.service.user.UserInfoServiceI;
import com.yisisoftware.service.user.UserServiceI;
import com.yisisoftware.util.base.Constant;
import com.yisisoftware.util.base.HqlFilter;
import com.yisisoftware.view.WbWeight;

/**
 * 出入库统计分析
 * 
 * @author Administrator
 * 
 */
@Controller
public class WbWeightAction extends BaseAction {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WbWeightAction.class);

	@Autowired
	private WbWeightServiceI WbWeightService;
	/**
	 * 用户信息服务
	 */
	@Autowired
	private UserServiceI userService;
	/**
	 * 用户信息服务
	 */
	@Autowired
	private UserInfoServiceI userInfoService;
	/**
	 * 统计
	 * 
	 * @throws ParseException
	 */
	public void statistics() throws ParseException {

		String type = this.getRequest().getParameter("type");
		String sql = "";

		List<WbWeightView> backList = new ArrayList<>();

		if (StringUtils.isNotEmpty(type)) {
			HqlFilter hqlFilter = new HqlFilter();
			// 当type为-1时显示全部数据
			if ("-1".equals(type)) {
				List<WbWeightView> typeList3 = new ArrayList<>();
				List<WbWeightView> typeList1 = new ArrayList<>();
				sql = "select convert(char(10),lightDate,120) as time,sum(suttle) as weight,type from WB_Weight "
						+ "where type=3 AND  convert(char(10),lightDate,120) > DATEADD(day,-8,getdate()) "
						+ "group by convert(char(10),lightDate,120),type order by convert(char(10),lightDate,120) desc";
				typeList3 = findWbWeightViewListByType(sql);
				backList.addAll(typeList3);
				sql = "select convert(char(10),weightDate,120) as time,sum(suttle) as weight,type from WB_Weight "
						+ "where type=0 AND  convert(char(10),weightDate,120) > DATEADD(day,-8,getdate()) "
						+ "group by convert(char(10),weightDate,120),type order by convert(char(10),weightDate,120) desc";
				typeList1 = findWbWeightViewListByType(sql);
				backList.addAll(typeList1);
			}
			if (String.valueOf(Constant.TYPE_RUKU).equals(type)) {
				// 入库查询
				sql = "select convert(char(10),lightDate,120) as time,sum(suttle) as weight,type from WB_Weight "
						+ "where type=3 AND  convert(char(10),lightDate,120) > DATEADD(day,-8,getdate()) "
						+ "group by convert(char(10),lightDate,120),type order by convert(char(10),lightDate,120) desc";
				backList = findWbWeightViewListByType(sql);
			}
			if (String.valueOf(Constant.TYPE_CHUKU).equals(type)) {
				// 出库查询
				sql = "select convert(char(10),weightDate,120) as time,sum(suttle) as weight,type from WB_Weight "
						+ "where type=0 AND  convert(char(10),weightDate,120) > DATEADD(day,-8,getdate()) "
						+ "group by convert(char(10),weightDate,120),type order by convert(char(10),weightDate,120) desc";
				backList = findWbWeightViewListByType(sql);
			}
		}

		writeJson(backList);
	}

	/**
	 * 根据类型 获得出入库信息列表
	 * 
	 * @param sql
	 *            查询语句
	 * 
	 * @return 返回 WbWeightView 列表
	 */
	private List<WbWeightView> findWbWeightViewListByType(String sql) {
		List<WbWeightView> backList = new ArrayList<>();
		DatabaseHolder.getInstance().setDataBaseSource(
				DatabaseHolder.getDbKeys(1).toString());
		List<Object[]> list = this.WbWeightService.findBySql(sql);
		if (StringUtils.isNotEmpty(sql)) {
			for (Object[] w : list) {
				WbWeightView wbWeightView = new WbWeightView();
				wbWeightView.setTime(w[0].toString());
				wbWeightView.setWeight(Double.valueOf(w[1].toString()));
				wbWeightView.setType(Short.valueOf(w[2].toString()));
				backList.add(wbWeightView);
			}
		}

		return backList;
	}

	/**
	 * 获得二维码信息
	 */
	public void getInfoQR() {
		String cars = this.getRequest().getParameter("cars");
		String account = this.getRequest().getParameter("account");
		String pwd = this.getRequest().getParameter("pwd");
		String carNum = getCars(account, pwd);
		if(StringUtils.isNotBlank(carNum)){
			cars=carNum;
		}
		String sql = "select billno,CustomerName,CarsName,StoreName,MaterialName,"
				+ "Gross,Tare,Suttle,WeightDate,ReservationListName3,ReceiveName from VWB_Weight"
				+ " where 1=1";
		// 添加当日时间限制
		SimpleDateFormat ssf = new SimpleDateFormat("yyyy-MM-dd");
		// sql+=
		// " and convert( varchar(32), WeightDate, 20 )  like '"+ssf.format(new
		// Date())+"'%";

		List<QrInfo> bakList = new ArrayList<>();
		try {
			if (StringUtils.isNotEmpty(cars)) {
				sql += " and CarsName='" + cars + "'";
				List<Object[]> list = this.WbWeightService.findBySql(sql);
				for (int i = 0; i < list.size(); i++) {
					QrInfo q = new QrInfo();
					if (list.get(0)[0] != null) {
						q.setBillno(String.valueOf(list.get(0)[0]));
					}
					if (list.get(0)[1] != null) {
						q.setCustomerName(String.valueOf(list.get(0)[1]));
					}
					if (list.get(0)[2] != null) {
						q.setCarsName(String.valueOf(list.get(0)[2]));
					}
					if (list.get(0)[3] != null) {
						q.setStoreName(String.valueOf(list.get(0)[3]));
					}
					if (list.get(0)[4] != null) {
						q.setMaterialName(String.valueOf(list.get(0)[4]));
					}
					if (list.get(0)[5] != null) {
						q.setGross(Double.valueOf(String.valueOf(list.get(0)[5])));
					}
					if (list.get(0)[6] != null) {
						q.setTare(Double.valueOf(String.valueOf(list.get(0)[6])));
					}
					if (list.get(0)[7] != null) {
						q.setSuttle(Double.valueOf(String.valueOf(list.get(0)[7])));
					}
					if (list.get(0)[8] != null) {
						q.setWeightDate(new SimpleDateFormat(
								"yyyy-MM-dd HH:mm:ss").parse(String
								.valueOf(list.get(0)[8])));
					}
					if (list.get(0)[9] != null) {
						q.setReservationListName3(String.valueOf(list.get(0)[9]));
					}
					if (list.get(0)[10] != null) {
						q.setReceiveName(String.valueOf(list.get(0)[10]));
					}
					bakList.add(q);
				}
			}
		} catch (NumberFormatException e) {
		} catch (ParseException e) {
		} finally {
			writeJson(bakList);
			// System.out.println(bakList);
		}
	}

	// 获取车号
	private String getCars(String account, String pwd) {
		HqlFilter hqlFilter = new HqlFilter();
		hqlFilter.addFilter("QUERY_t#adminUserName_S_EQ", account);
		hqlFilter.addFilter("QUERY_t#adminPassWord_S_EQ", pwd);

		List<LoginUser> list = userService.findByFilter(hqlFilter);
		if(list==null||list.isEmpty()){
			return "";
		}
		UserInfo userInfo=userInfoService.getInfoByName(list.get(0).getAdminUserName());
		if(userInfo==null){
			return "";
		}else{
			return userInfo.getCarNum();
		}
	}
}
