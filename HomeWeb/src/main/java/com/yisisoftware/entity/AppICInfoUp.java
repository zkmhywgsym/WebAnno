package com.yisisoftware.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class AppICInfoUp implements Serializable {

	/**
	 * 主键自增长
	 */
	private Long id;
	/**
	 * 榜单号
	 */
	private String billNO;
	/**
	 * 车号主键
	 */
	private String cars;
	
	/**
	 * 物料
	 */
	private String Material;
	/**
	 * 抓拍时间
	 */
	private Date picTime;
	/**
	 * 图片路径
	 */
	private String picPath;
	/**
	 * 装车人员
	 */
	private String zcUser;
	/**
	 *  手持机号
	 */
	private String phoneNum;
	/**
	 * 抓拍顺序
	 */
	private Integer picOrder;
	/**
	 * 派车单号
	 */
	private String pcBillNO;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBillNO() {
		return billNO;
	}
	public void setBillNO(String billNO) {
		this.billNO = billNO;
	}
	public String getCars() {
		return cars;
	}
	public void setCars(String cars) {
		this.cars = cars;
	}
	public String getMaterial() {
		return Material;
	}
	public void setMaterial(String material) {
		Material = material;
	}
	public Date getPicTime() {
		return picTime;
	}
	public void setPicTime(Date picTime) {
		this.picTime = picTime;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public String getZcUser() {
		return zcUser;
	}
	public void setZcUser(String zcUser) {
		this.zcUser = zcUser;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public Integer getPicOrder() {
		return picOrder;
	}
	public void setPicOrder(Integer picOrder) {
		this.picOrder = picOrder;
	}
	public String getPcBillNO() {
		return pcBillNO;
	}
	public void setPcBillNO(String pcBillNO) {
		this.pcBillNO = pcBillNO;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((Material == null) ? 0 : Material.hashCode());
		result = prime * result + ((billNO == null) ? 0 : billNO.hashCode());
		result = prime * result + ((cars == null) ? 0 : cars.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((pcBillNO == null) ? 0 : pcBillNO.hashCode());
		result = prime * result
				+ ((phoneNum == null) ? 0 : phoneNum.hashCode());
		result = prime * result
				+ ((picOrder == null) ? 0 : picOrder.hashCode());
		result = prime * result + ((picPath == null) ? 0 : picPath.hashCode());
		result = prime * result + ((picTime == null) ? 0 : picTime.hashCode());
		result = prime * result + ((zcUser == null) ? 0 : zcUser.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppICInfoUp other = (AppICInfoUp) obj;
		if (Material == null) {
			if (other.Material != null)
				return false;
		} else if (!Material.equals(other.Material))
			return false;
		if (billNO == null) {
			if (other.billNO != null)
				return false;
		} else if (!billNO.equals(other.billNO))
			return false;
		if (cars == null) {
			if (other.cars != null)
				return false;
		} else if (!cars.equals(other.cars))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pcBillNO == null) {
			if (other.pcBillNO != null)
				return false;
		} else if (!pcBillNO.equals(other.pcBillNO))
			return false;
		if (phoneNum == null) {
			if (other.phoneNum != null)
				return false;
		} else if (!phoneNum.equals(other.phoneNum))
			return false;
		if (picOrder == null) {
			if (other.picOrder != null)
				return false;
		} else if (!picOrder.equals(other.picOrder))
			return false;
		if (picPath == null) {
			if (other.picPath != null)
				return false;
		} else if (!picPath.equals(other.picPath))
			return false;
		if (picTime == null) {
			if (other.picTime != null)
				return false;
		} else if (!picTime.equals(other.picTime))
			return false;
		if (zcUser == null) {
			if (other.zcUser != null)
				return false;
		} else if (!zcUser.equals(other.zcUser))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AppICInfoUp [id=" + id + ", billNO=" + billNO + ", cars="
				+ cars + ", Material=" + Material + ", picTime=" + picTime
				+ ", picPath=" + picPath + ", zcUser=" + zcUser + ", phoneNum="
				+ phoneNum + ", picOrder=" + picOrder + ", pcBillNO="
				+ pcBillNO + "]";
	}
	
	
}
