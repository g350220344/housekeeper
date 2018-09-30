package com.cindata.housekeeper.web.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class RentTrend {

	private String communityName;//小区名称
	private String purpose;//户型
	private BigDecimal rentsqmprice;//租金
	private BigDecimal salesqmprice;//出售单价
	private Timestamp dayId;
	private String date;//时间

	public String getCommunityName() {
		return communityName;
	}
	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public BigDecimal getRentsqmprice() {
		return rentsqmprice;
	}
	public void setRentsqmprice(BigDecimal rentsqmprice) {
		this.rentsqmprice = rentsqmprice;
	}
	public BigDecimal getSalesqmprice() {
		return salesqmprice;
	}
	public void setSalesqmprice(BigDecimal salesqmprice) {
		this.salesqmprice = salesqmprice;
	}
	public Timestamp getDayId() {
		return dayId;
	}
	public void setDayId(Timestamp dayId) {
		this.dayId = dayId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
