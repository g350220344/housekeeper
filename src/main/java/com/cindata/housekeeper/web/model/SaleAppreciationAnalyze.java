package com.cindata.housekeeper.web.model;

import java.math.BigDecimal;

public class SaleAppreciationAnalyze {

	private String salefirstYearManagerResult; //出售第一年收益
	private BigDecimal saleFen; //出售评分
	private double SaleSqmPriceOnYear_on_YearBasis; //房价涨跌率
	private String rentfirstYearManagerResult;//出租第一年收益
	private String salefiveTotalManageResult;//出售五年总收益
	private String rentfiveTotalManageResult;//出租五年总收益
	private BigDecimal rentFen;//出租评分
	private BigDecimal saleAvgDay;//出售成交平均天数
	private int rentAvgDay;//出租成交平均天数
	private String 	financingIncome;//理财年利率
	private String rent_year_rant;//租金回报年收益
	private String resultCompare;//比较出售五年总收益出租五年总收益
	private BigDecimal MaxSalePrice;
    private BigDecimal MinSalePrice;
    private BigDecimal MaxRentPrice;
    private BigDecimal MinRentPrice;
    private BigDecimal compareValue;
    private String compareValueResult;
	
	
    
    
	
	public String getCompareValueResult() {
		return compareValueResult;
	}
	public void setCompareValueResult(String compareValueResult) {
		this.compareValueResult = compareValueResult;
	}
	public BigDecimal getCompareValue() {
		return compareValue;
	}
	public void setCompareValue(BigDecimal compareValue) {
		this.compareValue = compareValue;
	}
	public BigDecimal getMaxSalePrice() {
		return MaxSalePrice;
	}
	public void setMaxSalePrice(BigDecimal maxSalePrice) {
		MaxSalePrice = maxSalePrice;
	}
	public BigDecimal getMinSalePrice() {
		return MinSalePrice;
	}
	public void setMinSalePrice(BigDecimal minSalePrice) {
		MinSalePrice = minSalePrice;
	}
	public BigDecimal getMaxRentPrice() {
		return MaxRentPrice;
	}
	public void setMaxRentPrice(BigDecimal maxRentPrice) {
		MaxRentPrice = maxRentPrice;
	}
	public BigDecimal getMinRentPrice() {
		return MinRentPrice;
	}
	public void setMinRentPrice(BigDecimal minRentPrice) {
		MinRentPrice = minRentPrice;
	}
	public String getSalefirstYearManagerResult() {
		return salefirstYearManagerResult;
	}
	public void setSalefirstYearManagerResult(String salefirstYearManagerResult) {
		this.salefirstYearManagerResult = salefirstYearManagerResult;
	}
	public BigDecimal getSaleFen() {
		return saleFen;
	}
	public void setSaleFen(BigDecimal saleFen) {
		this.saleFen = saleFen;
	}
    
	
	public double getSaleSqmPriceOnYear_on_YearBasis() {
		return SaleSqmPriceOnYear_on_YearBasis;
	}
	public void setSaleSqmPriceOnYear_on_YearBasis(double saleSqmPriceOnYear_on_YearBasis) {
		SaleSqmPriceOnYear_on_YearBasis = saleSqmPriceOnYear_on_YearBasis;
	}
	public String getRentfirstYearManagerResult() {
		return rentfirstYearManagerResult;
	}
	public void setRentfirstYearManagerResult(String rentfirstYearManagerResult) {
		this.rentfirstYearManagerResult = rentfirstYearManagerResult;
	}
	public String getSalefiveTotalManageResult() {
		return salefiveTotalManageResult;
	}
	public void setSalefiveTotalManageResult(String salefiveTotalManageResult) {
		this.salefiveTotalManageResult = salefiveTotalManageResult;
	}
	public String getRentfiveTotalManageResult() {
		return rentfiveTotalManageResult;
	}
	public void setRentfiveTotalManageResult(String rentfiveTotalManageResult) {
		this.rentfiveTotalManageResult = rentfiveTotalManageResult;
	}
	public BigDecimal getRentFen() {
		return rentFen;
	}
	public void setRentFen(BigDecimal rentFen) {
		this.rentFen = rentFen;
	}
	public BigDecimal getSaleAvgDay() {
		return saleAvgDay;
	}
	public void setSaleAvgDay(BigDecimal saleAvgDay) {
		this.saleAvgDay = saleAvgDay;
	}
	public int getRentAvgDay() {
		return rentAvgDay;
	}
	public void setRentAvgDay(int rentAvgDay) {
		this.rentAvgDay = rentAvgDay;
	}
	public String getFinancingIncome() {
		return financingIncome;
	}
	public void setFinancingIncome(String financingIncome) {
		this.financingIncome = financingIncome;
	}
    
	public String getRent_year_rant() {
		return rent_year_rant;
	}
	public void setRent_year_rant(String rent_year_rant) {
		this.rent_year_rant = rent_year_rant;
	}
	public String getResultCompare() {
		return resultCompare;
	}
	public void setResultCompare(String resultCompare) {
		this.resultCompare = resultCompare;
	}
	
   
	
	
	
	
	
}
