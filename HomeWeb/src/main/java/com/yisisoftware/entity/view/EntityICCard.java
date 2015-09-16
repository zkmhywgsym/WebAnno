package com.yisisoftware.entity.view;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "APP_ICInfo")
public class EntityICCard implements Serializable{
//	orderId,customName,carNum,material,weightTime,phoneNum,operator,scanTime,pic1,pic2,pic3,remarks
	private int id;
	//显示数据
	private String icCardId;//IC卡号/派车单号
	private String bangId;//磅单号(单据编号),唯一
	private String customName;//客户
	private String carNum;//车牌号
	private String weightTime;//过磅时间
	private String material;//物料
	private String sendWeight;//发货净重
	private String remarks;//备注
	//修改数据
	private String phoneNum;//手持号
	private String loader;//操作员
	private long loadTime;//操作时间
	//上传数据
	private byte[] pic1;//车辆拍照
	private byte[] pic2;//车辆拍照
	private byte[] pic3;//车辆拍照
	private String pic1Name;
	private String pic2Name;
	private String pic3Name;
	private double longitude;//经度坐标
	private double latitude;//纬度坐标
	private String locationType;//wf,gps,cl
	
	public EntityICCard() {
		
	}

	public EntityICCard(int id, String icCardId, String bangId,
			String customName, String carNum, String weightTime,
			String material, String sendWeight, String remarks,
			String phoneNum, String loader, long loadTime, byte[] pic1,
			byte[] pic2, byte[] pic3, double longitude, double latitude,
			String locationType) {
		super();
		this.id = id;
		this.icCardId = icCardId;
		this.bangId = bangId;
		this.customName = customName;
		this.carNum = carNum;
		this.weightTime = weightTime;
		this.material = material;
		this.sendWeight = sendWeight;
		this.remarks = remarks;
		this.phoneNum = phoneNum;
		this.loader = loader;
		this.loadTime = loadTime;
		this.pic1 = pic1;
		this.pic2 = pic2;
		this.pic3 = pic3;
		this.longitude = longitude;
		this.latitude = latitude;
		this.locationType = locationType;
	}

	
	public String getPic1Name() {
		return pic1Name;
	}

	public void setPic1Name(String pic1Name) {
		this.pic1Name = pic1Name;
	}

	public String getPic2Name() {
		return pic2Name;
	}

	public void setPic2Name(String pic2Name) {
		this.pic2Name = pic2Name;
	}

	public String getPic3Name() {
		return pic3Name;
	}

	public void setPic3Name(String pic3Name) {
		this.pic3Name = pic3Name;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getIcCardId() {
		return icCardId;
	}

	public void setIcCardId(String icCardId) {
		this.icCardId = icCardId;
	}


	public String getBangId() {
		return bangId;
	}

	public void setBangId(String bangId) {
		this.bangId = bangId;
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

	public String getWeightTime() {
		return weightTime;
	}

	public void setWeightTime(String weightTime) {
		this.weightTime = weightTime;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getSendWeight() {
		return sendWeight;
	}

	public void setSendWeight(String sendWeight) {
		this.sendWeight = sendWeight;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}


	public String getLoader() {
		return loader;
	}

	public void setLoader(String loader) {
		this.loader = loader;
	}

	
	public long getLoadTime() {
		return loadTime;
	}

	public void setLoadTime(long loadTime) {
		this.loadTime = loadTime;
	}

	public byte[] getPic1() {
		return pic1;
	}

	public void setPic1(byte[] pic1) {
		this.pic1 = pic1;
	}

	public byte[] getPic2() {
		return pic2;
	}

	public void setPic2(byte[] pic2) {
		this.pic2 = pic2;
	}

	public byte[] getPic3() {
		return pic3;
	}

	public void setPic3(byte[] pic3) {
		this.pic3 = pic3;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	
	
}
