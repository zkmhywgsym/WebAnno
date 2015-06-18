package com.eosine.entity.base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户信息
 */
@Entity
@Table(name = "userInfo")
public class UserInfo implements java.io.Serializable {

	// Fields

	/**
	 * 主键id 自增长
	 */
	private Long id;
	/**
	 * 创建时间
	 */
	private Date createdatetime;
	/**
	 * 修改时间
	 */
	private Date updatedatetime;
	/**
	 * 最后登录时间时间
	 */
	private Date lastLoginTime;
	/**
	 * 移动电话
	 */
	private String mobilePhone;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 车牌号
	 */
	private String plates;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedatetime() {
		return createdatetime;
	}
	public void setCreatedatetime(Date createdatetime) {
		this.createdatetime = createdatetime;
	}
	public Date getUpdatedatetime() {
		return updatedatetime;
	}
	public void setUpdatedatetime(Date updatedatetime) {
		this.updatedatetime = updatedatetime;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlates() {
		return plates;
	}
	public void setPlates(String plates) {
		this.plates = plates;
	}
	
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", createdatetime=" + createdatetime
				+ ", updatedatetime=" + updatedatetime + ", lastLoginTime="
				+ lastLoginTime + ", mobilePhone=" + mobilePhone
				+ ", password=" + password + ", name=" + name + ", plates="
				+ plates + "]";
	}

}