package com.cindata.housekeeper.web.model;

import java.math.BigDecimal;
import java.util.Date;

public class ChangeHomeInfo {
    private String statementid;

    private String userid;

    private BigDecimal houseid;

    private BigDecimal accessHousePrice;

    private BigDecimal havePrice;

    private BigDecimal houseBudget;

    private String changeWay;

    private Date accessTime;

    private BigDecimal totlePrice;

    private String cityName;

    private String provinceName;

    private Integer intentionalMaxArea;

    private Integer intentionalMinArea;

    public String getStatementid() {
        return statementid;
    }

    public void setStatementid(String statementid) {
        this.statementid = statementid == null ? null : statementid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public BigDecimal getHouseid() {
        return houseid;
    }

    public void setHouseid(BigDecimal houseid) {
        this.houseid = houseid;
    }

    public BigDecimal getAccessHousePrice() {
        return accessHousePrice;
    }

    public void setAccessHousePrice(BigDecimal accessHousePrice) {
        this.accessHousePrice = accessHousePrice;
    }

    public BigDecimal getHavePrice() {
        return havePrice;
    }

    public void setHavePrice(BigDecimal havePrice) {
        this.havePrice = havePrice;
    }

    public BigDecimal getHouseBudget() {
        return houseBudget;
    }

    public void setHouseBudget(BigDecimal houseBudget) {
        this.houseBudget = houseBudget;
    }

    public String getChangeWay() {
        return changeWay;
    }

    public void setChangeWay(String changeWay) {
        this.changeWay = changeWay == null ? null : changeWay.trim();
    }

    public Date getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(Date accessTime) {
        this.accessTime = accessTime;
    }

    public BigDecimal getTotlePrice() {
        return totlePrice;
    }

    public void setTotlePrice(BigDecimal totlePrice) {
        this.totlePrice = totlePrice;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    public Integer getIntentionalMaxArea() {
        return intentionalMaxArea;
    }

    public void setIntentionalMaxArea(Integer intentionalMaxArea) {
        this.intentionalMaxArea = intentionalMaxArea;
    }

    public Integer getIntentionalMinArea() {
        return intentionalMinArea;
    }

    public void setIntentionalMinArea(Integer intentionalMinArea) {
        this.intentionalMinArea = intentionalMinArea ;
    }
}