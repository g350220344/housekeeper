package com.cindata.housekeeper.web.model;

import java.math.BigDecimal;
import java.util.Date;

public class LoanInfo {
    private String loanid;

    private Date loanApplyTime;

    private String loanUsername;

    private String productname;

    private String cityid;

    private String cityname;

    private BigDecimal applymoney;

    private String username;

    private String sex;

    private String telephone;

    private String status;

    private String groupid;

    public String getLoanid() {
        return loanid;
    }

    public void setLoanid(String loanid) {
        this.loanid = loanid == null ? null : loanid.trim();
    }

    public Date getLoanApplyTime() {
        return loanApplyTime;
    }

    public void setLoanApplyTime(Date loanApplyTime) {
        this.loanApplyTime = loanApplyTime;
    }

    public String getLoanUsername() {
        return loanUsername;
    }

    public void setLoanUsername(String loanUsername) {
        this.loanUsername = loanUsername == null ? null : loanUsername.trim();
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid == null ? null : cityid.trim();
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname == null ? null : cityname.trim();
    }

    public BigDecimal getApplymoney() {
        return applymoney;
    }

    public void setApplymoney(BigDecimal applymoney) {
        this.applymoney = applymoney;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid == null ? null : groupid.trim();
    }
}