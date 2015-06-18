package com.eosine.entity.business.view;

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
public class EntityOrderView implements Serializable {
	
	/**
	 * 主键id自增长 
	 */
	private Long id;
	
	/**
	 * 单据编号
	 */
	private String orderId;
	
	/**
	 * 客户名称
	 */
	private String customName;
	
	/**
	 * 车号
	 */
	private String carNum;
	
	/**
	 * 物料
	 */
	private String material;
	
	/**
	 *  实发净重
	 */
	private Float realRecive;
	
	/**
	 * 实收数量
	 */
	private Float realSend;
	
	
	/**
	 * 验收人
	 */
	private String reciver;
	
	/**
	 * 备注 
	 */
	private String remarks;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCustomName() {
		return customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Float getRealRecive() {
		return realRecive;
	}

	public void setRealRecive(Float realRecive) {
		this.realRecive = realRecive;
	}

	public Float getRealSend() {
		return realSend;
	}

	public void setRealSend(Float realSend) {
		this.realSend = realSend;
	}

	public String getReciver() {
		return reciver;
	}

	public void setReciver(String reciver) {
		this.reciver = reciver;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "EntityOrder [id=" + id + ", orderId=" + orderId
				+ ", customName=" + customName + ", carNum=" + carNum
				+ ", material=" + material + ", realRecive=" + realRecive
				+ ", realSend=" + realSend 
				+ ", reciver=" + reciver + ", remarks=" + remarks + "]";
	}

}
