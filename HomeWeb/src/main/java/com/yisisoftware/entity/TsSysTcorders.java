package com.yisisoftware.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 销售合同  从中可获得合理亏吨.
 *  @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TS_SysTCOrders")
public class TsSysTcorders implements java.io.Serializable {

	// Fields

	private String id;
	private String contractBillNo;
	private String handBillNo;
	private String ybillNo;
	private String contractType;
	private String supply;
	private String customer;
	private String send;
	private String receive;
	private String billType;
	private Integer qctype;
	private Integer trafficType;
	private Double tcharge;
	private Double loseNum;
	private String myBalanceMethod;
	private String soBalanceMethod;
	private String signDepartMent;
	private String signUser;
	private Timestamp signDate;
	private String createUser;
	private Timestamp createDate;
	private String modifyUser;
	private Timestamp modifyDate;
	private String aduitUser;
	private Timestamp aduitDate;
	private Timestamp startDate;
	private Timestamp stopDate;
	private String stopUser;
	private Timestamp voidDate;
	private Integer status;
	private Integer isUse;
	private Boolean isDel;
	private String currentPath;
	private String currentStepId;
	private String currentStepName;
	private String currentStepUserList;
	private String hasOperatedUserList;
	private String attpath;
	private String memo;

	// Constructors

	/** default constructor */
	public TsSysTcorders() {
	}

	/** full constructor */
	public TsSysTcorders(String contractBillNo, String handBillNo,
			String ybillNo, String contractType, String supply,
			String customer, String send, String receive, String billType,
			Integer qctype, Integer trafficType, Double tcharge,
			Double loseNum, String myBalanceMethod, String soBalanceMethod,
			String signDepartMent, String signUser, Timestamp signDate,
			String createUser, Timestamp createDate, String modifyUser,
			Timestamp modifyDate, String aduitUser, Timestamp aduitDate,
			Timestamp startDate, Timestamp stopDate, String stopUser,
			Timestamp voidDate, Integer status, Integer isUse, Boolean isDel,
			String currentPath, String currentStepId, String currentStepName,
			String currentStepUserList, String hasOperatedUserList,
			String attpath, String memo) {
		this.contractBillNo = contractBillNo;
		this.handBillNo = handBillNo;
		this.ybillNo = ybillNo;
		this.contractType = contractType;
		this.supply = supply;
		this.customer = customer;
		this.send = send;
		this.receive = receive;
		this.billType = billType;
		this.qctype = qctype;
		this.trafficType = trafficType;
		this.tcharge = tcharge;
		this.loseNum = loseNum;
		this.myBalanceMethod = myBalanceMethod;
		this.soBalanceMethod = soBalanceMethod;
		this.signDepartMent = signDepartMent;
		this.signUser = signUser;
		this.signDate = signDate;
		this.createUser = createUser;
		this.createDate = createDate;
		this.modifyUser = modifyUser;
		this.modifyDate = modifyDate;
		this.aduitUser = aduitUser;
		this.aduitDate = aduitDate;
		this.startDate = startDate;
		this.stopDate = stopDate;
		this.stopUser = stopUser;
		this.voidDate = voidDate;
		this.status = status;
		this.isUse = isUse;
		this.isDel = isDel;
		this.currentPath = currentPath;
		this.currentStepId = currentStepId;
		this.currentStepName = currentStepName;
		this.currentStepUserList = currentStepUserList;
		this.hasOperatedUserList = hasOperatedUserList;
		this.attpath = attpath;
		this.memo = memo;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ID", unique = true, nullable = false, length = 50)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "ContractBillNo", length = 50)
	public String getContractBillNo() {
		return this.contractBillNo;
	}

	public void setContractBillNo(String contractBillNo) {
		this.contractBillNo = contractBillNo;
	}

	@Column(name = "HandBillNo", length = 50)
	public String getHandBillNo() {
		return this.handBillNo;
	}

	public void setHandBillNo(String handBillNo) {
		this.handBillNo = handBillNo;
	}

	@Column(name = "YBillNo")
	public String getYbillNo() {
		return this.ybillNo;
	}

	public void setYbillNo(String ybillNo) {
		this.ybillNo = ybillNo;
	}

	@Column(name = "ContractType", length = 50)
	public String getContractType() {
		return this.contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	@Column(name = "Supply", length = 50)
	public String getSupply() {
		return this.supply;
	}

	public void setSupply(String supply) {
		this.supply = supply;
	}

	@Column(name = "Customer", length = 50)
	public String getCustomer() {
		return this.customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	@Column(name = "Send", length = 50)
	public String getSend() {
		return this.send;
	}

	public void setSend(String send) {
		this.send = send;
	}

	@Column(name = "Receive", length = 50)
	public String getReceive() {
		return this.receive;
	}

	public void setReceive(String receive) {
		this.receive = receive;
	}

	@Column(name = "BillType")
	public String getBillType() {
		return this.billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	@Column(name = "QCType")
	public Integer getQctype() {
		return this.qctype;
	}

	public void setQctype(Integer qctype) {
		this.qctype = qctype;
	}

	@Column(name = "TrafficType")
	public Integer getTrafficType() {
		return this.trafficType;
	}

	public void setTrafficType(Integer trafficType) {
		this.trafficType = trafficType;
	}

	@Column(name = "TCharge", precision = 18)
	public Double getTcharge() {
		return this.tcharge;
	}

	public void setTcharge(Double tcharge) {
		this.tcharge = tcharge;
	}

	@Column(name = "LoseNum", precision = 18, scale = 3)
	public Double getLoseNum() {
		return this.loseNum;
	}

	public void setLoseNum(Double loseNum) {
		this.loseNum = loseNum;
	}

	@Column(name = "MyBalanceMethod")
	public String getMyBalanceMethod() {
		return this.myBalanceMethod;
	}

	public void setMyBalanceMethod(String myBalanceMethod) {
		this.myBalanceMethod = myBalanceMethod;
	}

	@Column(name = "SoBalanceMethod")
	public String getSoBalanceMethod() {
		return this.soBalanceMethod;
	}

	public void setSoBalanceMethod(String soBalanceMethod) {
		this.soBalanceMethod = soBalanceMethod;
	}

	@Column(name = "SignDepartMent", length = 50)
	public String getSignDepartMent() {
		return this.signDepartMent;
	}

	public void setSignDepartMent(String signDepartMent) {
		this.signDepartMent = signDepartMent;
	}

	@Column(name = "SignUser", length = 50)
	public String getSignUser() {
		return this.signUser;
	}

	public void setSignUser(String signUser) {
		this.signUser = signUser;
	}

	@Column(name = "SignDate", length = 23)
	public Timestamp getSignDate() {
		return this.signDate;
	}

	public void setSignDate(Timestamp signDate) {
		this.signDate = signDate;
	}

	@Column(name = "CreateUser", length = 50)
	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Column(name = "CreateDate", length = 23)
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Column(name = "ModifyUser", length = 50)
	public String getModifyUser() {
		return this.modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	@Column(name = "ModifyDate", length = 23)
	public Timestamp getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Column(name = "AduitUser", length = 50)
	public String getAduitUser() {
		return this.aduitUser;
	}

	public void setAduitUser(String aduitUser) {
		this.aduitUser = aduitUser;
	}

	@Column(name = "AduitDate", length = 23)
	public Timestamp getAduitDate() {
		return this.aduitDate;
	}

	public void setAduitDate(Timestamp aduitDate) {
		this.aduitDate = aduitDate;
	}

	@Column(name = "StartDate", length = 23)
	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	@Column(name = "StopDate", length = 23)
	public Timestamp getStopDate() {
		return this.stopDate;
	}

	public void setStopDate(Timestamp stopDate) {
		this.stopDate = stopDate;
	}

	@Column(name = "StopUser", length = 50)
	public String getStopUser() {
		return this.stopUser;
	}

	public void setStopUser(String stopUser) {
		this.stopUser = stopUser;
	}

	@Column(name = "VoidDate", length = 23)
	public Timestamp getVoidDate() {
		return this.voidDate;
	}

	public void setVoidDate(Timestamp voidDate) {
		this.voidDate = voidDate;
	}

	@Column(name = "Status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "IsUse")
	public Integer getIsUse() {
		return this.isUse;
	}

	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}

	@Column(name = "IsDel")
	public Boolean getIsDel() {
		return this.isDel;
	}

	public void setIsDel(Boolean isDel) {
		this.isDel = isDel;
	}

	@Column(name = "CurrentPath", length = 200)
	public String getCurrentPath() {
		return this.currentPath;
	}

	public void setCurrentPath(String currentPath) {
		this.currentPath = currentPath;
	}

	@Column(name = "CurrentStepID", length = 50)
	public String getCurrentStepId() {
		return this.currentStepId;
	}

	public void setCurrentStepId(String currentStepId) {
		this.currentStepId = currentStepId;
	}

	@Column(name = "CurrentStepName", length = 2000)
	public String getCurrentStepName() {
		return this.currentStepName;
	}

	public void setCurrentStepName(String currentStepName) {
		this.currentStepName = currentStepName;
	}

	@Column(name = "CurrentStepUserList", length = 2000)
	public String getCurrentStepUserList() {
		return this.currentStepUserList;
	}

	public void setCurrentStepUserList(String currentStepUserList) {
		this.currentStepUserList = currentStepUserList;
	}

	@Column(name = "HasOperatedUserList", length = 2000)
	public String getHasOperatedUserList() {
		return this.hasOperatedUserList;
	}

	public void setHasOperatedUserList(String hasOperatedUserList) {
		this.hasOperatedUserList = hasOperatedUserList;
	}

	@Column(name = "ATTPath", length = 200)
	public String getAttpath() {
		return this.attpath;
	}

	public void setAttpath(String attpath) {
		this.attpath = attpath;
	}

	@Column(name = "Memo", length = 300)
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}