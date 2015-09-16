package com.yisisoftware.entity;


//用户信息
public class EntityUser {
	private int id;
	private long account;//限手机号
	private String pwd;
	private String name;
	private String createDate;
	private String lastLoginTime;
	private int type=1;//1，普通2.管理员
	private int statue=1;//0，停用1，可用2，
	
	
	public EntityUser() {
		super();
	}
	public EntityUser( long account, String pwd, String name,
			String createDate, String lastLoginTime,int type,int statue) {
		super();
		this.account = account;
		this.pwd = pwd;
		this.name = name;
		this.createDate = createDate;
		this.lastLoginTime = lastLoginTime;
		this.type = type;
		this.statue = statue;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getAccount() {
		return account;
	}
	public void setAccount(long account) {
		this.account = account;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getStatue() {
		return statue;
	}
	public void setStatue(int statue) {
		this.statue = statue;
	}
	
	
}
