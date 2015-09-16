package com.yisisoftware.entity.view;

import java.io.Serializable;
import java.util.Date;

/**
 * 二维码信息
 * 
 * @author Administrator
 *
 */
public class QrInfo implements Serializable {

	/**
	 * 单号
	 */
	private String billno;
	/**
	 * 客户名称
	 */
	private String customerName;
	/**
	 * 车牌号
	 */
	private String carsName;
	/**
	 * 采区
	 */
	private String storeName;
	/**
	 * 物料名称
	 */
	private String materialName;
	/**
	 *  毛重
	 */
	private Double gross;
	/**
	 *  皮重
	 */
	private Double tare;
	/**
	 *  净重
	 */
	private Double suttle;
	/**
	 *  重车时间
	 */
	private Date weightDate;
	/**
	 *  矿点
	 */
	private String reservationListName3;
	/**
	 *  开票方
	 */
	private String receiveName;
	public String getBillno() {
		return billno;
	}
	public void setBillno(String billno) {
		this.billno = billno;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCarsName() {
		return carsName;
	}
	public void setCarsName(String carsName) {
		this.carsName = carsName;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public Double getGross() {
		return gross;
	}
	public void setGross(Double gross) {
		this.gross = gross;
	}
	public Double getTare() {
		return tare;
	}
	public void setTare(Double tare) {
		this.tare = tare;
	}
	public Double getSuttle() {
		return suttle;
	}
	public void setSuttle(Double suttle) {
		this.suttle = suttle;
	}
	public Date getWeightDate() {
		return weightDate;
	}
	public void setWeightDate(Date weightDate) {
		this.weightDate = weightDate;
	}
	public String getReservationListName3() {
		return reservationListName3;
	}
	public void setReservationListName3(String reservationListName3) {
		this.reservationListName3 = reservationListName3;
	}
	public String getReceiveName() {
		return receiveName;
	}
	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}
	
}
