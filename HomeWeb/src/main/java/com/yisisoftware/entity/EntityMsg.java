package com.yisisoftware.entity;

import java.io.File;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//提交后台数据
@SuppressWarnings("serial")
@Entity
@Table(name = "APP_MSG")
public class EntityMsg implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String imei;
	private String cardJson;
	private double longitude;
	private double latitude;
	private String locationType;//wf,gps,cl
	private long optTime;
	
	public EntityMsg() {
		super();
	}

	public EntityMsg(int id, String name, String imei, String cardJson,
			double longitude, double latitude, String locationType,
			long optTime) {
		super();
		this.id = id;
		this.name = name;
		this.imei = imei;
		this.cardJson = cardJson;
		this.longitude = longitude;
		this.latitude = latitude;
		this.locationType = locationType;
		this.optTime = optTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getCardJson() {
		return cardJson;
	}

	public void setCardJson(String cardJson) {
		this.cardJson = cardJson;
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

	public long getOptTime() {
		return optTime;
	}

	public void setOptTime(long optTime) {
		this.optTime = optTime;
	}
	
}
