package com.cindata.housekeeper.wx.model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

public class WxRentInfo {
	private String id;

	@NotBlank(message = "houseId不能为空")
	private String houseId;

	@NotBlank(message = "userId不能为空")
	private String userId;

	@NotBlank(message = "leaseName不能为空")
	private String leaseName;

	@NotBlank(message = "mobile不能为空")
	private String mobile;

	@NotNull(message = "cycle(收租周期)不能为空")
    @Range(min = 1, max = 3, message = "cycle只能为1,2,3")
	private BigDecimal cycle;

	@NotNull(message = "money(租金)不能为空")
	private BigDecimal money;

	@NotNull(message = "term(租期(月))不能为空")
	private BigDecimal term;

	@NotNull(message = "leaseTime(租房时间)不能为空")
	private Date leaseTime;

	@NotNull(message = "state(状态(0:租约未到期,1:租约已到期2:删除租约))不能为空")
	@Range(min = 0, max = 2, message = "state只能为0,1,2")
	private BigDecimal state;
	
	private BigDecimal deposit;
	
	
	
	
	
	
	private BigDecimal resultrentPrice;

	private Date nextMonth;

	private String rentOfReturn;

	private String cycleName;

	private BigDecimal grandToal;

	private int resultFactdiff;

	private String rentStatus;

	public String getRentStatus() {
		return rentStatus;
	}

	public void setRentStatus(String rentStatus) {
		this.rentStatus = rentStatus;
	}

	public int getResultFactdiff() {
		return resultFactdiff;
	}

	public void setResultFactdiff(int resultFactdiff) {
		this.resultFactdiff = resultFactdiff;
	}

	public BigDecimal getGrandToal() {
		return grandToal;
	}

	public void setGrandToal(BigDecimal grandToal) {
		this.grandToal = grandToal;
	}

	public String getCycleName() {
		return cycleName;
	}

	public void setCycleName(String cycleName) {
		this.cycleName = cycleName;
	}

	public String getRentOfReturn() {
		return rentOfReturn;
	}

	public void setRentOfReturn(String rentOfReturn) {
		this.rentOfReturn = rentOfReturn;
	}

	public Date getNextMonth() {
		return nextMonth;
	}

	public void setNextMonth(Date nextMonth) {
		this.nextMonth = nextMonth;
	}

	public BigDecimal getResultrentPrice() {
		return resultrentPrice;
	}

	public void setResultrentPrice(BigDecimal resultrentPrice) {
		this.resultrentPrice = resultrentPrice;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getHouseId() {
		return houseId;
	}

	public void setHouseId(String houseId) {
		this.houseId = houseId == null ? null : houseId.trim();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	public String getLeaseName() {
		return leaseName;
	}

	public void setLeaseName(String leaseName) {
		this.leaseName = leaseName == null ? null : leaseName.trim();
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}

	public BigDecimal getCycle() {
		return cycle;
	}

	public void setCycle(BigDecimal cycle) {
		this.cycle = cycle;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public BigDecimal getTerm() {
		return term;
	}

	public void setTerm(BigDecimal term) {
		this.term = term;
	}

	public Date getLeaseTime() {
		return leaseTime;
	}

	public void setLeaseTime(Date leaseTime) {
		this.leaseTime = leaseTime;
	}

	public BigDecimal getDeposit() {
		return deposit;
	}

	public void setDeposit(BigDecimal deposit) {
		this.deposit = deposit;
	}

	public BigDecimal getState() {
		return state;
	}

	public void setState(BigDecimal state) {
		this.state = state;
	}
}