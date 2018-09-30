package com.cindata.housekeeper.wx.model;

import java.math.BigDecimal;
import java.util.Date;

public class WxSelectLease {
	private String cycle;
	
	private Date leaseTime;
	
	private String leaseName;
	
	private String money;
	
	private int term;
	
	private String monthPrice;

	public WxSelectLease(WxSelectLeaseList wxSelectLeaseList) {
		this.cycle = wxSelectLeaseList.getCycle();
		this.leaseTime = wxSelectLeaseList.getLeaseTime();
		this.leaseName = wxSelectLeaseList.getLeaseName();
		this.money = wxSelectLeaseList.getMoney()+"";
		this.term = wxSelectLeaseList.getTerm();
		//this.monthPrice = wxSelectLeaseList;
		this.state = wxSelectLeaseList.getState();
		//this.lv = lv;
		this.nextTime = wxSelectLeaseList.getNextTime();
	}

	public WxSelectLease(String cycle, Date leaseTime, String leaseName, String money, int term, String monthPrice, String state, BigDecimal lv, Date nextTime) {
		this.cycle = cycle;
		this.leaseTime = leaseTime;
		this.leaseName = leaseName;
		this.money = money;
		this.term = term;
		this.monthPrice = monthPrice;
		this.state = state;
		this.lv = lv;
		this.nextTime = nextTime;
	}

	public Date getNextTime() {
		return nextTime;
	}

	public void setNextTime(Date nextTime) {
		this.nextTime = nextTime;
	}

	private String state;
	
	private BigDecimal lv;

	private Date nextTime;
	
	public String getCycle() {
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	public Date getLeaseTime() {
		return leaseTime;
	}

	public void setLeaseTime(Date leaseTime) {
		this.leaseTime = leaseTime;
	}

	public String getLeaseName() {
		return leaseName;
	}

	public void setLeaseName(String leaseName) {
		this.leaseName = leaseName;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getMonthPrice() {
		return monthPrice;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public void setMonthPrice(String monthPrice) {
		this.monthPrice = monthPrice;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public BigDecimal getLv() {
		return lv;
	}

	public void setLv(BigDecimal lv) {
		this.lv = lv;
	}


}
