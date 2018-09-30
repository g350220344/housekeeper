package com.cindata.housekeeper.wx.model;

import java.math.BigDecimal;
import java.util.Set;

public class HouseAvmInfo {

	
	private BigDecimal totalAppreciation; //房产总升值
	
	private Double appreciationPercent;//房产升值率
	
	private BigDecimal totalLoan;//房产总贷款
	
	private BigDecimal totalRent;//房产总租金收益
	
	private BigDecimal appreciation;//房产增值额
	
	private BigDecimal loanPrice;//月供支出
	
	private BigDecimal rentPrice;//租金收益
	
	private BigDecimal assessSaleTotalPrice;//房产估值
	
	private BigDecimal totalPrice;//房产总估值
	
	private BigDecimal sortPercent;//房产总值占比
	
	private String totalAppreciationResult;//最终房产升值
	
	private String cycleResult;
	
	private Integer month;
	
	private String cityName;
	
	private String communityName;
	
	private Integer cityCount;
	
	private Integer houseCount;
	
	private Set listCity;
	
	 
    private String distinctName;
    private String address;
    private BigDecimal buildingsquare;
    
    

	public String getDistinctName() {
		return distinctName;
	}

	public void setDistinctName(String distinctName) {
		this.distinctName = distinctName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigDecimal getBuildingsquare() {
		return buildingsquare;
	}

	public void setBuildingsquare(BigDecimal buildingsquare) {
		this.buildingsquare = buildingsquare;
	}

	public Set getListCity() {
		return listCity;
	}

	public void setListCity(Set listCity) {
		this.listCity = listCity;
	}

	public int getCityCount() {
		return cityCount;
	}

	public void setCityCount(int cityCount) {
		this.cityCount = cityCount;
	}

	public int getHouseCount() {
		return houseCount;
	}

	public void setHouseCount(int houseCount) {
		this.houseCount = houseCount;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public String getCycleResult() {
		return cycleResult;
	}

	public void setCycleResult(String cycleResult) {
		this.cycleResult = cycleResult;
	}

	public String getTotalAppreciationResult() {
		return totalAppreciationResult;
	}

	public void setTotalAppreciationResult(String totalAppreciationResult) {
		this.totalAppreciationResult = totalAppreciationResult;
	}

	public BigDecimal getSortPercent() {
		return sortPercent;
	}

	public void setSortPercent(BigDecimal sortPercent) {
		this.sortPercent = sortPercent;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public BigDecimal getAssessSaleTotalPrice() {
		return assessSaleTotalPrice;
	}

	public void setAssessSaleTotalPrice(BigDecimal assessSaleTotalPrice) {
		this.assessSaleTotalPrice = assessSaleTotalPrice;
	}

	public BigDecimal getAppreciation() {
		return appreciation;
	}

	public void setAppreciation(BigDecimal appreciation) {
		this.appreciation = appreciation;
	}

	public BigDecimal getLoanPrice() {
		return loanPrice;
	}

	public void setLoanPrice(BigDecimal loanPrice) {
		this.loanPrice = loanPrice;
	}

	public BigDecimal getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(BigDecimal rentPrice) {
		this.rentPrice = rentPrice;
	}

	public BigDecimal getTotalAppreciation() {
		return totalAppreciation;
	}

	public void setTotalAppreciation(BigDecimal totalAppreciation) {
		this.totalAppreciation = totalAppreciation;
	}

	public Double getAppreciationPercent() {
		return appreciationPercent;
	}

	public void setAppreciationPercent(Double appreciationPercent) {
		this.appreciationPercent = appreciationPercent;
	}

	public BigDecimal getTotalLoan() {
		return totalLoan;
	}

	public void setTotalLoan(BigDecimal totalLoan) {
		this.totalLoan = totalLoan;
	}

	public BigDecimal getTotalRent() {
		return totalRent;
	}

	public void setTotalRent(BigDecimal totalRent) {
		this.totalRent = totalRent;
	}

	@Override
	public String toString() {
		return "HouseAvmInfo [totalAppreciation=" + totalAppreciation + ", appreciationPercent=" + appreciationPercent
				+ ", totalLoan=" + totalLoan + ", totalRent=" + totalRent + ", appreciation=" + appreciation
				+ ", loanPrice=" + loanPrice + ", rentPrice=" + rentPrice + ", assessSaleTotalPrice="
				+ assessSaleTotalPrice + ", totalPrice=" + totalPrice + ", sortPercent=" + sortPercent
				+ ", totalAppreciationResult=" + totalAppreciationResult + ", cycleResult=" + cycleResult + ", month="
				+ month + ", cityName=" + cityName + ", communityName=" + communityName + "]";
	}



	

	
	

	

	

	
	
	
}
