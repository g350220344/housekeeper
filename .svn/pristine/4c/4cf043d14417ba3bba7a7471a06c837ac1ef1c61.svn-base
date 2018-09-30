package com.cindata.housekeeper.web.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author
 */
public class HouseAvmLog implements Serializable {
    private BigDecimal houseId;

    private BigDecimal assessSalePrice;

    private Date assessTime;

    private BigDecimal assessRentPrice;

    private static final long serialVersionUID = 1L;

    public BigDecimal getHouseId() {
        return houseId;
    }

    public void setHouseId(BigDecimal houseId) {
        this.houseId = houseId;
    }

    public BigDecimal getAssessSalePrice() {
        return assessSalePrice;
    }

    public void setAssessSalePrice(BigDecimal assessSalePrice) {
        this.assessSalePrice = assessSalePrice;
    }

    public Date getAssessTime() {
        return assessTime;
    }

    public void setAssessTime(Date assessTime) {
        this.assessTime = assessTime;
    }

    public BigDecimal getAssessRentPrice() {
        return assessRentPrice;
    }

    public void setAssessRentPrice(BigDecimal assessRentPrice) {
        this.assessRentPrice = assessRentPrice;
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
        HouseAvmLog other = (HouseAvmLog) that;
        return (this.getHouseId() == null ? other.getHouseId() == null : this.getHouseId().equals(other.getHouseId()))
                && (this.getAssessSalePrice() == null ? other.getAssessSalePrice() == null : this.getAssessSalePrice().equals(other.getAssessSalePrice()))
                && (this.getAssessTime() == null ? other.getAssessTime() == null : this.getAssessTime().equals(other.getAssessTime()))
                && (this.getAssessRentPrice() == null ? other.getAssessRentPrice() == null : this.getAssessRentPrice().equals(other.getAssessRentPrice()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getHouseId() == null) ? 0 : getHouseId().hashCode());
        result = prime * result + ((getAssessSalePrice() == null) ? 0 : getAssessSalePrice().hashCode());
        result = prime * result + ((getAssessTime() == null) ? 0 : getAssessTime().hashCode());
        result = prime * result + ((getAssessRentPrice() == null) ? 0 : getAssessRentPrice().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", houseId=").append(houseId);
        sb.append(", assessSalePrice=").append(assessSalePrice);
        sb.append(", assessTime=").append(assessTime);
        sb.append(", assessRentPrice=").append(assessRentPrice);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}