package com.eosine.controller.base;

import org.apache.log4j.Logger;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eosine.controller.BaseController;
import com.eosine.entity.base.UserInfo;
import com.eosine.pageModel.Json;
import com.eosine.pageModel.SessionInfo;
import com.eosine.service.base.UserInfoServiceI;
import com.eosine.util.base.ConfigUtil;
import com.eosine.util.base.HqlFilter;

/**
 * 用户控制器
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/userController")
public class UserController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserInfoServiceI userInfoService;

	/**
	 * 用户注册
	 * 
	 * @param user
	 * 				用户对象
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/reg")
	public String reg(UserInfo user){
		
		String result="exists";	//设置返回状态 true ,false,exists
		try {
			//首先判断是否输入车号
			if(StringUtils.isEmpty(user.getPlates()) || StringUtils.isEmpty(user.getMobilePhone())){
				//车牌号或手机号为空时，禁止注册
				result = "false";
			}else{
				HqlFilter hqlFilter = new HqlFilter();
				hqlFilter.addFilter("QUERY_t#mobilePhone_S_EQ",user.getMobilePhone());
				List<UserInfo> list = userInfoService.findByFilter(hqlFilter);
				if(list.size() > 0){	//如果手机号注册过
					result = "exists";
				}else{
					user.setCreatedatetime(new Date());
					userInfoService.save(user);
					result ="true";
				}
			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return result;
		}
		
	}
	
	@ResponseBody
	@RequestMapping("/login")
	public Map<String, String> userLogin(String loginName,String loginPwd,HttpSession session){
		Map<String, String> map = new HashMap<>();
		
		try {
			if(StringUtils.isNotEmpty(loginName) && StringUtils.isNotEmpty(loginPwd)){
				HqlFilter hqlFilter = new HqlFilter();
				hqlFilter.addFilter("QUERY_t#mobilePhone_S_EQ", loginName);
				hqlFilter.addFilter("QUERY_t#password_S_EQ", loginPwd);
				
				List<UserInfo> list= this.userInfoService.findByFilter(hqlFilter);
				if(list != null && list.size() > 0){
					SessionInfo sessionInfo = new SessionInfo();
					sessionInfo.setUserId(list.get(0).getId());
					session.setAttribute(ConfigUtil.getSessionInfoName(), sessionInfo);
					//登录成功
					map.put("loginStatus", "success");
				}else{
					//登录失败
					map.put("loginStatus", "userOrPwdErr");
				}
			}else{
				//未输入用户名或密码
				map.put("loginStatus", "other");
			}
		} catch (Exception e) {
			// 登录异常 发生未知异常时返回
			//logger.error("系统出现异常："+e);
			map.put("loginStatus", "other");
		}finally{
			return map;
		}
		
	}
	
	
	@ResponseBody
	@RequestMapping("/passWordReset")
	public String passWordReset(String mobilePhone, String password){
		String result = "false";
		try {
			if(StringUtils.isNotEmpty(mobilePhone) && StringUtils.isNotEmpty(password)){
				HqlFilter hqlFilter = new HqlFilter();
				hqlFilter.addFilter("QUERY_t#mobilePhone_S_EQ", mobilePhone);
				UserInfo userInfo = this.userInfoService.getByFilter(hqlFilter);
				if(userInfo != null){
					userInfo.setPassword(password);
					this.userInfoService.update(userInfo);
					result = "true";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return result;
		}
	}
}
