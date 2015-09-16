package com.yisisoftware.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 单据
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "WB_Weight")
public class EntityOrder implements Serializable {
	
	/**
	 * 主键id自增长 
	 */
	private Long id;
	
	/**
	 * 单据编号
	 */
	private String billNo;
	
	/**
	 * 客户名称
	 */
	private String customer;
	
	/**
	 * 车号
	 */
	private String cars;
	
	/**
	 * 物料
	 */
	private String material;
	
	/**
	 *  实发净重
	 */
	private Float suttle;
	
//	/**
//	 * 实收数量
//	 */
//	private Float realSend;
//	
//	/**
//	 * 验收时间
//	 */
//	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
//	private Date reciveTime;
//	
//	/**
//	 * 验收人
//	 */
//	private String reciver;
//	
//	/**
//	 * 备注 
//	 */
//	private String remarks;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}



	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getCars() {
		return cars;
	}

	public void setCars(String cars) {
		this.cars = cars;
	}

	public Float getSuttle() {
		return suttle;
	}

	public void setSuttle(Float suttle) {
		this.suttle = suttle;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	

}
