package com.yisisoftware.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "APP_HandheldMachineInfo")
public class HandheldMachineInfo implements Serializable {

	/**
	 * 主键 自增长
	 */
	private int id;
	
	/**
	 * 设备名称
	 */
	private String name;
	
	/**
	 * 设备号
	 */
	private String deviceId;
	
	/**
	 * 所有者
	 */
	private String owner;
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	
}
