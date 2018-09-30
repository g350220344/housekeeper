package com.cindata.housekeeper.web.model;

import java.math.BigDecimal;
import java.util.Date;

public class DistrictInfo {
    private Long districtId;

    private String districtName;

    private Long cityId;

    private String ciytName;

    private Long provinceId;

    private String provinceName;

    private String status;

    private String dealPerson;

    private Date updateDate;

    private Date createdDt;

    private String dataSource;

    private String description;

    private BigDecimal orderId;

    private String strOrder;

    private String dataOrgType;

    private String isCity;

    private BigDecimal lng;

    private BigDecimal lat;

    private DistrictMarket districtMarket;

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName == null ? null : districtName.trim();
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCiytName() {
        return ciytName;
    }

    public void setCiytName(String ciytName) {
        this.ciytName = ciytName == null ? null : ciytName.trim();
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getDealPerson() {
        return dealPerson;
    }

    public void setDealPerson(String dealPerson) {
        this.dealPerson = dealPerson == null ? null : dealPerson.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource == null ? null : dataSource.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public BigDecimal getOrderId() {
        return orderId;
    }

    public void setOrderId(BigDecimal orderId) {
        this.orderId = orderId;
    }

    public String getStrOrder() {
        return strOrder;
    }

    public void setStrOrder(String strOrder) {
        this.strOrder = strOrder == null ? null : strOrder.trim();
    }

    public String getDataOrgType() {
        return dataOrgType;
    }

    public void setDataOrgType(String dataOrgType) {
        this.dataOrgType = dataOrgType == null ? null : dataOrgType.trim();
    }

    public String getIsCity() {
        return isCity;
    }

    public void setIsCity(String isCity) {
        this.isCity = isCity == null ? null : isCity.trim();
    }

    public DistrictMarket getDistrictMarket() {
        return districtMarket;
    }

    public void setDistrictMarket(DistrictMarket districtMarket) {
        this.districtMarket = districtMarket;
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }
}