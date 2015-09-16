package com.yisisoftware.entity.view;

import java.io.Serializable;

public class IcPicInfo implements Serializable {

	private Long time;
	private String picName;
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	public String getPicName() {
		return picName;
	}
	public void setPicName(String picName) {
		this.picName = picName;
	}
	
}
