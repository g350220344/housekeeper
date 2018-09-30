package com.cindata.housekeeper.web.model;

import java.math.BigDecimal;
import java.sql.Date;

public class CityTotleMarket {

	private int ascCount;
	private int descCount;
	private double ascTotle;
	private double descTotle;
	private int cityCount;
	private Date date;
	private BigDecimal AscRange;
	private BigDecimal DescRange;
	private int year;
	private int month;
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getAscCount() {
		return ascCount;
	}
	public void setAscCount(int ascCount) {
		this.ascCount = ascCount;
	}
	public int getDescCount() {
		return descCount;
	}
	public void setDescCount(int descCount) {
		this.descCount = descCount;
	}
	public double getAscTotle() {
		return ascTotle;
	}
	public void setAscTotle(double ascTotle) {
		this.ascTotle = ascTotle;
	}
	public double getDescTotle() {
		return descTotle;
	}
	public void setDescTotle(double descTotle) {
		this.descTotle = descTotle;
	}
	public BigDecimal getAscRange() {
		return AscRange;
	}
	public void setAscRange(BigDecimal ascRange) {
		AscRange = ascRange;
	}
	public BigDecimal getDescRange() {
		return DescRange;
	}
	public void setDescRange(BigDecimal descRange) {
		DescRange = descRange;
	}
	public int getCityCount() {
		return cityCount;
	}
	public void setCityCount(int cityCount) {
		this.cityCount = cityCount;
	}
}
