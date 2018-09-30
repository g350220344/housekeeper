package com.cindata.housekeeper.web.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author
 */
public class HouseChangeLog implements Serializable {
    private String statementid;

    private String userid;

    private BigDecimal houseid;

    private BigDecimal accessHousePrice;

    private BigDecimal havePrice;

    private BigDecimal houseBudget;

    private String changeWay;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date accessTime;

    private BigDecimal totlePrice;

    private BigDecimal intentionalMaxArea;

    private BigDecimal intentionalMinArea;

    private String districtId;

    private Long cityId;

    private static final long serialVersionUID = 1L;

    public String getStatementid() {
        return statementid;
    }

    public void setStatementid(String statementid) {
        this.statementid = statementid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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
        this.changeWay = changeWay;
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

    public BigDecimal getIntentionalMaxArea() {
        return intentionalMaxArea;
    }

    public void setIntentionalMaxArea(BigDecimal intentionalMaxArea) {
        this.intentionalMaxArea = intentionalMaxArea;
    }

    public BigDecimal getIntentionalMinArea() {
        return intentionalMinArea;
    }

    public void setIntentionalMinArea(BigDecimal intentionalMinArea) {
        this.intentionalMinArea = intentionalMinArea;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        HouseChangeLog other = (HouseChangeLog) that;
        return (this.getStatementid() == null ? other.getStatementid() == null : this.getStatementid().equals(other.getStatementid()))
                && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
                && (this.getHouseid() == null ? other.getHouseid() == null : this.getHouseid().equals(other.getHouseid()))
                && (this.getAccessHousePrice() == null ? other.getAccessHousePrice() == null : this.getAccessHousePrice().equals(other.getAccessHousePrice()))
                && (this.getHavePrice() == null ? other.getHavePrice() == null : this.getHavePrice().equals(other.getHavePrice()))
                && (this.getHouseBudget() == null ? other.getHouseBudget() == null : this.getHouseBudget().equals(other.getHouseBudget()))
                && (this.getChangeWay() == null ? other.getChangeWay() == null : this.getChangeWay().equals(other.getChangeWay()))
                && (this.getAccessTime() == null ? other.getAccessTime() == null : this.getAccessTime().equals(other.getAccessTime()))
                && (this.getTotlePrice() == null ? other.getTotlePrice() == null : this.getTotlePrice().equals(other.getTotlePrice()))
                && (this.getIntentionalMaxArea() == null ? other.getIntentionalMaxArea() == null : this.getIntentionalMaxArea().equals(other.getIntentionalMaxArea()))
                && (this.getIntentionalMinArea() == null ? other.getIntentionalMinArea() == null : this.getIntentionalMinArea().equals(other.getIntentionalMinArea()))
                && (this.getDistrictId() == null ? other.getDistrictId() == null : this.getDistrictId().equals(other.getDistrictId()))
                && (this.getCityId() == null ? other.getCityId() == null : this.getCityId().equals(other.getCityId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStatementid() == null) ? 0 : getStatementid().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getHouseid() == null) ? 0 : getHouseid().hashCode());
        result = prime * result + ((getAccessHousePrice() == null) ? 0 : getAccessHousePrice().hashCode());
        result = prime * result + ((getHavePrice() == null) ? 0 : getHavePrice().hashCode());
        result = prime * result + ((getHouseBudget() == null) ? 0 : getHouseBudget().hashCode());
        result = prime * result + ((getChangeWay() == null) ? 0 : getChangeWay().hashCode());
        result = prime * result + ((getAccessTime() == null) ? 0 : getAccessTime().hashCode());
        result = prime * result + ((getTotlePrice() == null) ? 0 : getTotlePrice().hashCode());
        result = prime * result + ((getIntentionalMaxArea() == null) ? 0 : getIntentionalMaxArea().hashCode());
        result = prime * result + ((getIntentionalMinArea() == null) ? 0 : getIntentionalMinArea().hashCode());
        result = prime * result + ((getDistrictId() == null) ? 0 : getDistrictId().hashCode());
        result = prime * result + ((getCityId() == null) ? 0 : getCityId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", statementid=").append(statementid);
        sb.append(", userid=").append(userid);
        sb.append(", houseid=").append(houseid);
        sb.append(", accessHousePrice=").append(accessHousePrice);
        sb.append(", havePrice=").append(havePrice);
        sb.append(", houseBudget=").append(houseBudget);
        sb.append(", changeWay=").append(changeWay);
        sb.append(", accessTime=").append(accessTime);
        sb.append(", totlePrice=").append(totlePrice);
        sb.append(", intentionalMaxArea=").append(intentionalMaxArea);
        sb.append(", intentionalMinArea=").append(intentionalMinArea);
        sb.append(", districtId=").append(districtId);
        sb.append(", cityId=").append(cityId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}