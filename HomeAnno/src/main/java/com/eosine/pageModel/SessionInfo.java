package com.eosine.pageModel;

import java.io.Serializable;
/**
 * session中存放数据
 * 
 * @author Administrator
 *
 */
public class SessionInfo implements Serializable {

	/**
	 * 用户id
	 */
	private Long userId;
	
	/**
	 * 用户登录名
	 */
	private String userName;
	
	/**
	 * 用户使用数据库
	 */
	private String userDB;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserDB() {
		return userDB;
	}

	public void setUserDB(String userDB) {
		this.userDB = userDB;
	}
	
	
}
