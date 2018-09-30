package com.cindata.housekeeper.web.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 
 */
public class DistrictMarket implements Serializable {
    private Long districtId;

    private Long cityId;

    private String districtName;

    private BigDecimal salesqmprice;

    private BigDecimal rentsqmprice;

    private String purpose;

    private String houserentpricerate;

    private String averageannualreturn;

    private String salerate;

    private String linkrate;

    private BigDecimal saletotalprice;

    private BigDecimal renttotalprice;

    private BigDecimal salesquare;

    private BigDecimal rentsquare;

    private Date dayId;

    private Long supplyNum;

    private String salerateRent;

    private String linkrateRent;

    private Long saleDealCount;

    private Long rentDealCount;

    private Long supplyNumRent;

    private BigDecimal rentalPriceRatio;

    private BigDecimal deChemicalCycle;

    private BigDecimal priceDiscountRate;

    private Long similarHousesCount;

    private Long dealSaleTotalPrice;

    private Long dealSaleSqmPrice;

    private Long dealSaleSquare;

    private static final long serialVersionUID = 1L;

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public BigDecimal getSalesqmprice() {
        return salesqmprice;
    }

    public void setSalesqmprice(BigDecimal salesqmprice) {
        this.salesqmprice = salesqmprice;
    }

    public BigDecimal getRentsqmprice() {
        return rentsqmprice;
    }

    public void setRentsqmprice(BigDecimal rentsqmprice) {
        this.rentsqmprice = rentsqmprice;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getHouserentpricerate() {
        return houserentpricerate;
    }

    public void setHouserentpricerate(String houserentpricerate) {
        this.houserentpricerate = houserentpricerate;
    }

    public String getAverageannualreturn() {
        return averageannualreturn;
    }

    public void setAverageannualreturn(String averageannualreturn) {
        this.averageannualreturn = averageannualreturn;
    }

    public String getSalerate() {
        return salerate;
    }

    public void setSalerate(String salerate) {
        this.salerate = salerate;
    }

    public String getLinkrate() {
        return linkrate;
    }

    public void setLinkrate(String linkrate) {
        this.linkrate = linkrate;
    }

    public BigDecimal getSaletotalprice() {
        return saletotalprice;
    }

    public void setSaletotalprice(BigDecimal saletotalprice) {
        this.saletotalprice = saletotalprice;
    }

    public BigDecimal getRenttotalprice() {
        return renttotalprice;
    }

    public void setRenttotalprice(BigDecimal renttotalprice) {
        this.renttotalprice = renttotalprice;
    }

    public BigDecimal getSalesquare() {
        return salesquare;
    }

    public void setSalesquare(BigDecimal salesquare) {
        this.salesquare = salesquare;
    }

    public BigDecimal getRentsquare() {
        return rentsquare;
    }

    public void setRentsquare(BigDecimal rentsquare) {
        this.rentsquare = rentsquare;
    }

    public Date getDayId() {
        return dayId;
    }

    public void setDayId(Date dayId) {
        this.dayId = dayId;
    }

    public Long getSupplyNum() {
        return supplyNum;
    }

    public void setSupplyNum(Long supplyNum) {
        this.supplyNum = supplyNum;
    }

    public String getSalerateRent() {
        return salerateRent;
    }

    public void setSalerateRent(String salerateRent) {
        this.salerateRent = salerateRent;
    }

    public String getLinkrateRent() {
        return linkrateRent;
    }

    public void setLinkrateRent(String linkrateRent) {
        this.linkrateRent = linkrateRent;
    }

    public Long getSaleDealCount() {
        return saleDealCount;
    }

    public void setSaleDealCount(Long saleDealCount) {
        this.saleDealCount = saleDealCount;
    }

    public Long getRentDealCount() {
        return rentDealCount;
    }

    public void setRentDealCount(Long rentDealCount) {
        this.rentDealCount = rentDealCount;
    }

    public Long getSupplyNumRent() {
        return supplyNumRent;
    }

    public void setSupplyNumRent(Long supplyNumRent) {
        this.supplyNumRent = supplyNumRent;
    }

    public BigDecimal getRentalPriceRatio() {
        return rentalPriceRatio;
    }

    public void setRentalPriceRatio(BigDecimal rentalPriceRatio) {
        this.rentalPriceRatio = rentalPriceRatio;
    }

    public BigDecimal getDeChemicalCycle() {
        return deChemicalCycle;
    }

    public void setDeChemicalCycle(BigDecimal deChemicalCycle) {
        this.deChemicalCycle = deChemicalCycle;
    }

    public BigDecimal getPriceDiscountRate() {
        return priceDiscountRate;
    }

    public void setPriceDiscountRate(BigDecimal priceDiscountRate) {
        this.priceDiscountRate = priceDiscountRate;
    }

    public Long getSimilarHousesCount() {
        return similarHousesCount;
    }

    public void setSimilarHousesCount(Long similarHousesCount) {
        this.similarHousesCount = similarHousesCount;
    }

    public Long getDealSaleTotalPrice() {
        return dealSaleTotalPrice;
    }

    public void setDealSaleTotalPrice(Long dealSaleTotalPrice) {
        this.dealSaleTotalPrice = dealSaleTotalPrice;
    }

    public Long getDealSaleSqmPrice() {
        return dealSaleSqmPrice;
    }

    public void setDealSaleSqmPrice(Long dealSaleSqmPrice) {
        this.dealSaleSqmPrice = dealSaleSqmPrice;
    }

    public Long getDealSaleSquare() {
        return dealSaleSquare;
    }

    public void setDealSaleSquare(Long dealSaleSquare) {
        this.dealSaleSquare = dealSaleSquare;
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
        DistrictMarket other = (DistrictMarket) that;
        return (this.getDistrictId() == null ? other.getDistrictId() == null : this.getDistrictId().equals(other.getDistrictId()))
            && (this.getCityId() == null ? other.getCityId() == null : this.getCityId().equals(other.getCityId()))
            && (this.getDistrictName() == null ? other.getDistrictName() == null : this.getDistrictName().equals(other.getDistrictName()))
            && (this.getSalesqmprice() == null ? other.getSalesqmprice() == null : this.getSalesqmprice().equals(other.getSalesqmprice()))
            && (this.getRentsqmprice() == null ? other.getRentsqmprice() == null : this.getRentsqmprice().equals(other.getRentsqmprice()))
            && (this.getPurpose() == null ? other.getPurpose() == null : this.getPurpose().equals(other.getPurpose()))
            && (this.getHouserentpricerate() == null ? other.getHouserentpricerate() == null : this.getHouserentpricerate().equals(other.getHouserentpricerate()))
            && (this.getAverageannualreturn() == null ? other.getAverageannualreturn() == null : this.getAverageannualreturn().equals(other.getAverageannualreturn()))
            && (this.getSalerate() == null ? other.getSalerate() == null : this.getSalerate().equals(other.getSalerate()))
            && (this.getLinkrate() == null ? other.getLinkrate() == null : this.getLinkrate().equals(other.getLinkrate()))
            && (this.getSaletotalprice() == null ? other.getSaletotalprice() == null : this.getSaletotalprice().equals(other.getSaletotalprice()))
            && (this.getRenttotalprice() == null ? other.getRenttotalprice() == null : this.getRenttotalprice().equals(other.getRenttotalprice()))
            && (this.getSalesquare() == null ? other.getSalesquare() == null : this.getSalesquare().equals(other.getSalesquare()))
            && (this.getRentsquare() == null ? other.getRentsquare() == null : this.getRentsquare().equals(other.getRentsquare()))
            && (this.getDayId() == null ? other.getDayId() == null : this.getDayId().equals(other.getDayId()))
            && (this.getSupplyNum() == null ? other.getSupplyNum() == null : this.getSupplyNum().equals(other.getSupplyNum()))
            && (this.getSalerateRent() == null ? other.getSalerateRent() == null : this.getSalerateRent().equals(other.getSalerateRent()))
            && (this.getLinkrateRent() == null ? other.getLinkrateRent() == null : this.getLinkrateRent().equals(other.getLinkrateRent()))
            && (this.getSaleDealCount() == null ? other.getSaleDealCount() == null : this.getSaleDealCount().equals(other.getSaleDealCount()))
            && (this.getRentDealCount() == null ? other.getRentDealCount() == null : this.getRentDealCount().equals(other.getRentDealCount()))
            && (this.getSupplyNumRent() == null ? other.getSupplyNumRent() == null : this.getSupplyNumRent().equals(other.getSupplyNumRent()))
            && (this.getRentalPriceRatio() == null ? other.getRentalPriceRatio() == null : this.getRentalPriceRatio().equals(other.getRentalPriceRatio()))
            && (this.getDeChemicalCycle() == null ? other.getDeChemicalCycle() == null : this.getDeChemicalCycle().equals(other.getDeChemicalCycle()))
            && (this.getPriceDiscountRate() == null ? other.getPriceDiscountRate() == null : this.getPriceDiscountRate().equals(other.getPriceDiscountRate()))
            && (this.getSimilarHousesCount() == null ? other.getSimilarHousesCount() == null : this.getSimilarHousesCount().equals(other.getSimilarHousesCount()))
            && (this.getDealSaleTotalPrice() == null ? other.getDealSaleTotalPrice() == null : this.getDealSaleTotalPrice().equals(other.getDealSaleTotalPrice()))
            && (this.getDealSaleSqmPrice() == null ? other.getDealSaleSqmPrice() == null : this.getDealSaleSqmPrice().equals(other.getDealSaleSqmPrice()))
            && (this.getDealSaleSquare() == null ? other.getDealSaleSquare() == null : this.getDealSaleSquare().equals(other.getDealSaleSquare()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDistrictId() == null) ? 0 : getDistrictId().hashCode());
        result = prime * result + ((getCityId() == null) ? 0 : getCityId().hashCode());
        result = prime * result + ((getDistrictName() == null) ? 0 : getDistrictName().hashCode());
        result = prime * result + ((getSalesqmprice() == null) ? 0 : getSalesqmprice().hashCode());
        result = prime * result + ((getRentsqmprice() == null) ? 0 : getRentsqmprice().hashCode());
        result = prime * result + ((getPurpose() == null) ? 0 : getPurpose().hashCode());
        result = prime * result + ((getHouserentpricerate() == null) ? 0 : getHouserentpricerate().hashCode());
        result = prime * result + ((getAverageannualreturn() == null) ? 0 : getAverageannualreturn().hashCode());
        result = prime * result + ((getSalerate() == null) ? 0 : getSalerate().hashCode());
        result = prime * result + ((getLinkrate() == null) ? 0 : getLinkrate().hashCode());
        result = prime * result + ((getSaletotalprice() == null) ? 0 : getSaletotalprice().hashCode());
        result = prime * result + ((getRenttotalprice() == null) ? 0 : getRenttotalprice().hashCode());
        result = prime * result + ((getSalesquare() == null) ? 0 : getSalesquare().hashCode());
        result = prime * result + ((getRentsquare() == null) ? 0 : getRentsquare().hashCode());
        result = prime * result + ((getDayId() == null) ? 0 : getDayId().hashCode());
        result = prime * result + ((getSupplyNum() == null) ? 0 : getSupplyNum().hashCode());
        result = prime * result + ((getSalerateRent() == null) ? 0 : getSalerateRent().hashCode());
        result = prime * result + ((getLinkrateRent() == null) ? 0 : getLinkrateRent().hashCode());
        result = prime * result + ((getSaleDealCount() == null) ? 0 : getSaleDealCount().hashCode());
        result = prime * result + ((getRentDealCount() == null) ? 0 : getRentDealCount().hashCode());
        result = prime * result + ((getSupplyNumRent() == null) ? 0 : getSupplyNumRent().hashCode());
        result = prime * result + ((getRentalPriceRatio() == null) ? 0 : getRentalPriceRatio().hashCode());
        result = prime * result + ((getDeChemicalCycle() == null) ? 0 : getDeChemicalCycle().hashCode());
        result = prime * result + ((getPriceDiscountRate() == null) ? 0 : getPriceDiscountRate().hashCode());
        result = prime * result + ((getSimilarHousesCount() == null) ? 0 : getSimilarHousesCount().hashCode());
        result = prime * result + ((getDealSaleTotalPrice() == null) ? 0 : getDealSaleTotalPrice().hashCode());
        result = prime * result + ((getDealSaleSqmPrice() == null) ? 0 : getDealSaleSqmPrice().hashCode());
        result = prime * result + ((getDealSaleSquare() == null) ? 0 : getDealSaleSquare().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", districtId=").append(districtId);
        sb.append(", cityId=").append(cityId);
        sb.append(", districtName=").append(districtName);
        sb.append(", salesqmprice=").append(salesqmprice);
        sb.append(", rentsqmprice=").append(rentsqmprice);
        sb.append(", purpose=").append(purpose);
        sb.append(", houserentpricerate=").append(houserentpricerate);
        sb.append(", averageannualreturn=").append(averageannualreturn);
        sb.append(", salerate=").append(salerate);
        sb.append(", linkrate=").append(linkrate);
        sb.append(", saletotalprice=").append(saletotalprice);
        sb.append(", renttotalprice=").append(renttotalprice);
        sb.append(", salesquare=").append(salesquare);
        sb.append(", rentsquare=").append(rentsquare);
        sb.append(", dayId=").append(dayId);
        sb.append(", supplyNum=").append(supplyNum);
        sb.append(", salerateRent=").append(salerateRent);
        sb.append(", linkrateRent=").append(linkrateRent);
        sb.append(", saleDealCount=").append(saleDealCount);
        sb.append(", rentDealCount=").append(rentDealCount);
        sb.append(", supplyNumRent=").append(supplyNumRent);
        sb.append(", rentalPriceRatio=").append(rentalPriceRatio);
        sb.append(", deChemicalCycle=").append(deChemicalCycle);
        sb.append(", priceDiscountRate=").append(priceDiscountRate);
        sb.append(", similarHousesCount=").append(similarHousesCount);
        sb.append(", dealSaleTotalPrice=").append(dealSaleTotalPrice);
        sb.append(", dealSaleSqmPrice=").append(dealSaleSqmPrice);
        sb.append(", dealSaleSquare=").append(dealSaleSquare);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}