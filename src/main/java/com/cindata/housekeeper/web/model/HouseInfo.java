package com.cindata.housekeeper.web.model;


import com.cindata.housekeeper.core.common.tools.StringUtil;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HouseInfo {
    private BigDecimal orderId;

    private BigDecimal houseId;

    private BigDecimal buildingId;

    private BigDecimal communityId;

    private BigDecimal unitId;

    private BigDecimal streetId;

    private BigDecimal cityId;

    private String userId;

    private String buildyear;

    private String doorNum;

    private Short isfirst;

    private Long totalfloor;

    private Long currentfloor;

    private String aspect;

    private BigDecimal buildingsquare;

    private BigDecimal livingsquare;

    private String property;

    private String decoratelevel;

    private String floorplantype;

    private Short roomcount;

    private Short loungecount;

    private Short bathroomcount;

    private Short kitchencount;

    private Short balconycount;

    private Long sqmprice;

    private Long totalprice;

    private Date timeoflisting;

    private String datasource;

    private String contactperson;

    private String agencycompany;

    private String telephone;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private String remark;

    private String floortype;

    private String iflift;

    private String architectureperiod;

    private String doneperiod;

    private String abhorFactor;

    private String houseProperty;

    private String caseSource;

    private String planarstructure;

    private Short floorsOccuppied;

    private Short floorStart;

    private String communitytype;

    private String buildingtype;

    private String supportingservice;

    private String goodFactor;

    private Date createdDt;

    private String status;

    private String dealPerson;

    private Date updateDate;

    private Short updateNum;

    private String houseName;

    private String buildingName;

    private String communityName;

    private String unitName;

    private String streetName;

    private Long precinctid;

    private String precinctname;

    private Long districtid;

    private String districtname;

    private String cityName;

    private String userName;

    private String address;

    private String ifagency;

    private String store;

    private Integer parkingNum;

    private Integer totalhouseholdcount;

    private String communitydescription;

    private Integer buildingarea;

    private Integer livingyear;

    private Integer upfloor;

    private Integer gardenarea;

    private Integer underarea;

    private Integer garagenum;

    private Integer occupancy;

    private String school;

    private String title;

    private Integer pmfee;

    private Integer greeningrate;

    private Integer plotratio;

    private String strOrder;

    private String housepicture;

    private String isreal;

    private String sourceurl;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    private String reserve4;

    private String reserve5;

    private String reserve6;

    private BigDecimal isSale;

    private BigDecimal isRent;

    private BigDecimal isDeal;

    private Long rentTotalprice;

    private Long rentSqmprice;

    private String roomTypeImg;

    private Date dealTime;

    private String leaseholdWay;

    private String storeId;

    private String agentId;

    private String rangeXys;
    
    private Double addAccessHouseYesterdayi;

    
    private String nickname;
    private String sex;
    private String headUrl;

    private BigDecimal assessSalePrice;
    private BigDecimal assessSaleTotalPrice;
    private BigDecimal assessRentPrice;
    private Date assessTime;
    private BigDecimal maxSalePrice;
    private BigDecimal minSalePrice;
    private BigDecimal maxSaleTotalPrice;
    private BigDecimal minSaleTotalPrice;
    private BigDecimal maxRentPrice;
    private BigDecimal minRentPrice;

    private String aspectName;
    private String floorplanName;


    public Double getAddAccessHouseYesterdayi() {
		return addAccessHouseYesterdayi;
	}

	public void setAddAccessHouseYesterdayi(Double addAccessHouseYesterdayi) {
		this.addAccessHouseYesterdayi = addAccessHouseYesterdayi;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

	public BigDecimal getOrderId() {
        return orderId;
    }

    public void setOrderId(BigDecimal orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getHouseId() {
        return houseId;
    }

    public void setHouseId(BigDecimal houseId) {
        this.houseId = houseId;
    }

    public BigDecimal getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(BigDecimal buildingId) {
        this.buildingId = buildingId;
    }

    public BigDecimal getCommunityId() {
        return communityId;
    }

    public void setCommunityId(BigDecimal communityId) {
        this.communityId = communityId;
    }

    public BigDecimal getUnitId() {
        return unitId;
    }

    public void setUnitId(BigDecimal unitId) {
        this.unitId = unitId;
    }

    public BigDecimal getStreetId() {
        return streetId;
    }

    public void setStreetId(BigDecimal streetId) {
        this.streetId = streetId;
    }

    public BigDecimal getCityId() {
        return cityId;
    }

    public void setCityId(BigDecimal cityId) {
        this.cityId = cityId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getBuildyear() {
        return buildyear;
    }

    public void setBuildyear(String buildyear) {
        this.buildyear = buildyear == null ? null : buildyear.trim();
    }

    public String getDoorNum() {
        return doorNum;
    }

    public void setDoorNum(String doorNum) {
        this.doorNum = doorNum == null ? null : doorNum.trim();
    }

    public Short getIsfirst() {
        return isfirst;
    }

    public void setIsfirst(Short isfirst) {
        this.isfirst = isfirst;
    }

    public Long getTotalfloor() {
        return totalfloor;
    }

    public void setTotalfloor(Long totalfloor) {
        this.totalfloor = totalfloor;
    }

    public Long getCurrentfloor() {
        return currentfloor;
    }

    public void setCurrentfloor(Long currentfloor) {
        this.currentfloor = currentfloor;
    }

    public String getAspect() {
        return aspect;
    }

    public void setAspect(String aspect) {
        this.aspect = aspect == null ? null : aspect.trim();
    }

    public BigDecimal getBuildingsquare() {
        return buildingsquare;
    }

    public void setBuildingsquare(BigDecimal buildingsquare) {
        this.buildingsquare = buildingsquare;
    }

    public BigDecimal getLivingsquare() {
        return livingsquare;
    }

    public void setLivingsquare(BigDecimal livingsquare) {
        this.livingsquare = livingsquare;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property == null ? null : property.trim();
    }

    public String getDecoratelevel() {
        return decoratelevel;
    }

    public void setDecoratelevel(String decoratelevel) {
        this.decoratelevel = decoratelevel == null ? null : decoratelevel.trim();
    }

    public String getFloorplantype() {
        return floorplantype;
    }

    public void setFloorplantype(String floorplantype) {
        this.floorplantype = floorplantype == null ? null : floorplantype.trim();
    }

    public Short getRoomcount() {
        return roomcount;
    }

    public void setRoomcount(Short roomcount) {
        this.roomcount = roomcount;
    }

    public Short getLoungecount() {
        return loungecount;
    }

    public void setLoungecount(Short loungecount) {
        this.loungecount = loungecount;
    }

    public Short getBathroomcount() {
        return bathroomcount;
    }

    public void setBathroomcount(Short bathroomcount) {
        this.bathroomcount = bathroomcount;
    }

    public Short getKitchencount() {
        return kitchencount;
    }

    public void setKitchencount(Short kitchencount) {
        this.kitchencount = kitchencount;
    }

    public Short getBalconycount() {
        return balconycount;
    }

    public void setBalconycount(Short balconycount) {
        this.balconycount = balconycount;
    }

    public Long getSqmprice() {
        return sqmprice;
    }

    public void setSqmprice(Long sqmprice) {
        this.sqmprice = sqmprice;
    }

    public Long getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Long totalprice) {
        this.totalprice = totalprice;
    }

    public Date getTimeoflisting() {
        return timeoflisting;
    }
    public void setTimeoflisting(String timeoflisting) {
    	SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" ); 
    	Date timeDate = null;
    	try { 
    		timeDate = sdf.parse(timeoflisting); 
    	} catch (Exception e) { 
    		e.printStackTrace(); 
    	}
        this.timeoflisting = timeDate;
    }

    public String getDatasource() {
        return datasource;
    }

    public void setDatasource(String datasource) {
        this.datasource = datasource == null ? null : datasource.trim();
    }

    public String getContactperson() {
        return contactperson;
    }

    public void setContactperson(String contactperson) {
        this.contactperson = contactperson == null ? null : contactperson.trim();
    }

    public String getAgencycompany() {
        return agencycompany;
    }

    public void setAgencycompany(String agencycompany) {
        this.agencycompany = agencycompany == null ? null : agencycompany.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getFloortype() {
        return floortype;
    }

    public void setFloortype(String floortype) {
        this.floortype = floortype == null ? null : floortype.trim();
    }

    public String getIflift() {
        return iflift;
    }

    public void setIflift(String iflift) {
        this.iflift = iflift == null ? null : iflift.trim();
    }

    public String getArchitectureperiod() {
        return architectureperiod;
    }

    public void setArchitectureperiod(String architectureperiod) {
        this.architectureperiod = architectureperiod == null ? null : architectureperiod.trim();
    }

    public String getDoneperiod() {
        return doneperiod;
    }

    public void setDoneperiod(String doneperiod) {
        this.doneperiod = doneperiod == null ? null : doneperiod.trim();
    }

    public String getAbhorFactor() {
        return abhorFactor;
    }

    public void setAbhorFactor(String abhorFactor) {
        this.abhorFactor = abhorFactor == null ? null : abhorFactor.trim();
    }

    public String getHouseProperty() {
        return houseProperty;
    }

    public void setHouseProperty(String houseProperty) {
        this.houseProperty = houseProperty == null ? null : houseProperty.trim();
    }

    public String getCaseSource() {
        return caseSource;
    }

    public void setCaseSource(String caseSource) {
        this.caseSource = caseSource == null ? null : caseSource.trim();
    }

    public String getPlanarstructure() {
        return planarstructure;
    }

    public void setPlanarstructure(String planarstructure) {
        this.planarstructure = planarstructure == null ? null : planarstructure.trim();
    }

    public Short getFloorsOccuppied() {
        return floorsOccuppied;
    }

    public void setFloorsOccuppied(Short floorsOccuppied) {
        this.floorsOccuppied = floorsOccuppied;
    }

    public Short getFloorStart() {
        return floorStart;
    }

    public void setFloorStart(Short floorStart) {
        this.floorStart = floorStart;
    }

    public String getCommunitytype() {
        return communitytype;
    }

    public void setCommunitytype(String communitytype) {
        this.communitytype = communitytype == null ? null : communitytype.trim();
    }

    public String getBuildingtype() {
        return buildingtype;
    }

    public void setBuildingtype(String buildingtype) {
        this.buildingtype = buildingtype == null ? null : buildingtype.trim();
    }

    public String getSupportingservice() {
        return supportingservice;
    }

    public void setSupportingservice(String supportingservice) {
        this.supportingservice = supportingservice == null ? null : supportingservice.trim();
    }

    public String getGoodFactor() {
        return goodFactor;
    }

    public void setGoodFactor(String goodFactor) {
        this.goodFactor = goodFactor == null ? null : goodFactor.trim();
    }

    public Date getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
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

    public Short getUpdateNum() {
        return updateNum;
    }

    public void setUpdateNum(Short updateNum) {
        this.updateNum = updateNum;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName == null ? null : houseName.trim();
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName == null ? null : buildingName.trim();
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName == null ? null : communityName.trim();
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName == null ? null : streetName.trim();
    }

    public Long getPrecinctid() {
        return precinctid;
    }

    public void setPrecinctid(Long precinctid) {
        this.precinctid = precinctid;
    }

    public String getPrecinctname() {
        return precinctname;
    }

    public void setPrecinctname(String precinctname) {
        this.precinctname = precinctname == null ? null : precinctname.trim();
    }

    public Long getDistrictid() {
        return districtid;
    }

    public void setDistrictid(Long districtid) {
        this.districtid = districtid;
    }

    public String getDistrictname() {
        return districtname;
    }

    public void setDistrictname(String districtname) {
        this.districtname = districtname == null ? null : districtname.trim();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getIfagency() {
        return ifagency;
    }

    public void setIfagency(String ifagency) {
        this.ifagency = ifagency == null ? null : ifagency.trim();
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store == null ? null : store.trim();
    }

    public Integer getParkingNum() {
        return parkingNum;
    }

    public void setParkingNum(Integer parkingNum) {
        this.parkingNum = parkingNum;
    }

    public Integer getTotalhouseholdcount() {
        return totalhouseholdcount;
    }

    public void setTotalhouseholdcount(Integer totalhouseholdcount) {
        this.totalhouseholdcount = totalhouseholdcount;
    }

    public String getCommunitydescription() {
        return communitydescription;
    }

    public void setCommunitydescription(String communitydescription) {
        this.communitydescription = communitydescription == null ? null : communitydescription.trim();
    }

    public Integer getBuildingarea() {
        return buildingarea;
    }

    public void setBuildingarea(Integer buildingarea) {
        this.buildingarea = buildingarea;
    }

    public Integer getLivingyear() {
        return livingyear;
    }

    public void setLivingyear(Integer livingyear) {
        this.livingyear = livingyear;
    }

    public Integer getUpfloor() {
        return upfloor;
    }

    public void setUpfloor(Integer upfloor) {
        this.upfloor = upfloor;
    }

    public Integer getGardenarea() {
        return gardenarea;
    }

    public void setGardenarea(Integer gardenarea) {
        this.gardenarea = gardenarea;
    }

    public Integer getUnderarea() {
        return underarea;
    }

    public void setUnderarea(Integer underarea) {
        this.underarea = underarea;
    }

    public Integer getGaragenum() {
        return garagenum;
    }

    public void setGaragenum(Integer garagenum) {
        this.garagenum = garagenum;
    }

    public Integer getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(Integer occupancy) {
        this.occupancy = occupancy;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getPmfee() {
        return pmfee;
    }

    public void setPmfee(Integer pmfee) {
        this.pmfee = pmfee;
    }

    public Integer getGreeningrate() {
        return greeningrate;
    }

    public void setGreeningrate(Integer greeningrate) {
        this.greeningrate = greeningrate;
    }

    public Integer getPlotratio() {
        return plotratio;
    }

    public void setPlotratio(Integer plotratio) {
        this.plotratio = plotratio;
    }

    public String getStrOrder() {
        return strOrder;
    }

    public void setStrOrder(String strOrder) {
        this.strOrder = strOrder == null ? null : strOrder.trim();
    }

    public String getHousepicture() {
        return housepicture;
    }

    public void setHousepicture(String housepicture) {
        this.housepicture = housepicture == null ? null : housepicture.trim();
    }

    public String getIsreal() {
        return isreal;
    }

    public void setIsreal(String isreal) {
        this.isreal = isreal == null ? null : isreal.trim();
    }

    public String getSourceurl() {
        return sourceurl;
    }

    public void setSourceurl(String sourceurl) {
        this.sourceurl = sourceurl == null ? null : sourceurl.trim();
    }

    public String getReserve1() {
        return reserve1;
    }

    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1 == null ? null : reserve1.trim();
    }

    public String getReserve2() {
        return reserve2;
    }

    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2 == null ? null : reserve2.trim();
    }

    public String getReserve3() {
        return reserve3;
    }

    public void setReserve3(String reserve3) {
        this.reserve3 = reserve3 == null ? null : reserve3.trim();
    }

    public String getReserve4() {
        return reserve4;
    }

    public void setReserve4(String reserve4) {
        this.reserve4 = reserve4 == null ? null : reserve4.trim();
    }

    public String getReserve5() {
        return reserve5;
    }

    public void setReserve5(String reserve5) {
        this.reserve5 = reserve5 == null ? null : reserve5.trim();
    }

    public String getReserve6() {
        return reserve6;
    }

    public void setReserve6(String reserve6) {
        this.reserve6 = reserve6 == null ? null : reserve6.trim();
    }

    public BigDecimal getIsSale() {
        return isSale;
    }

    public void setIsSale(BigDecimal isSale) {
        this.isSale = isSale;
    }

    public BigDecimal getIsRent() {
        return isRent;
    }

    public void setIsRent(BigDecimal isRent) {
        this.isRent = isRent;
    }

    public BigDecimal getIsDeal() {
        return isDeal;
    }

    public void setIsDeal(BigDecimal isDeal) {
        this.isDeal = isDeal;
    }

    public Long getRentTotalprice() {
        return rentTotalprice;
    }

    public void setRentTotalprice(Long rentTotalprice) {
        this.rentTotalprice = rentTotalprice;
    }

    public Long getRentSqmprice() {
        return rentSqmprice;
    }

    public void setRentSqmprice(Long rentSqmprice) {
        this.rentSqmprice = rentSqmprice;
    }

    public String getRoomTypeImg() {
        return roomTypeImg;
    }

    public void setRoomTypeImg(String roomTypeImg) {
        this.roomTypeImg = roomTypeImg == null ? null : roomTypeImg.trim();
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public String getLeaseholdWay() {
        return leaseholdWay;
    }

    public void setLeaseholdWay(String leaseholdWay) {
        this.leaseholdWay = leaseholdWay == null ? null : leaseholdWay.trim();
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId == null ? null : storeId.trim();
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId == null ? null : agentId.trim();
    }

    public String getRangeXys() {
        return rangeXys;
    }

    public void setRangeXys(String rangeXys) {
        this.rangeXys = rangeXys == null ? null : rangeXys.trim();
    }
    
    
    public String getTimeoflistingString() {
        return StringUtil.dateFormat(timeoflisting, "yyyy-MM-dd HH:mm:ss", null);
    }
    public String getDealTimeString() {
        return StringUtil.dateFormat(dealTime, "yyyy-MM-dd HH:mm:ss", null);
    }
    public String getUpdateDateString() {
        return StringUtil.dateFormat(updateDate, "yyyy-MM-dd HH:mm:ss", null);
    }
    public String getCreatedDtString() {
        return StringUtil.dateFormat(createdDt, "yyyy-MM-dd HH:mm:ss", null);
    }

    public void setTimeoflisting(Date timeoflisting) {
        this.timeoflisting = timeoflisting;
    }

    public BigDecimal getAssessSalePrice() {
        return assessSalePrice;
    }

    public void setAssessSalePrice(BigDecimal assessSalePrice) {
        this.assessSalePrice = assessSalePrice;
    }

    public BigDecimal getAssessRentPrice() {
        return assessRentPrice;
    }

    public void setAssessRentPrice(BigDecimal assessRentPrice) {
        this.assessRentPrice = assessRentPrice;
    }

    public Date getAssessTime() {
        return assessTime;
    }

    public void setAssessTime(Date assessTime) {
        this.assessTime = assessTime;
    }

    public BigDecimal getMaxSalePrice() {
        return maxSalePrice;
    }

    public void setMaxSalePrice(BigDecimal maxSalePrice) {
        this.maxSalePrice = maxSalePrice;
    }

    public BigDecimal getMinSalePrice() {
        return minSalePrice;
    }

    public void setMinSalePrice(BigDecimal minSalePrice) {
        this.minSalePrice = minSalePrice;
    }

    public BigDecimal getAssessSaleTotalPrice() {
        return assessSaleTotalPrice;
    }

    public void setAssessSaleTotalPrice(BigDecimal assessSaleTotalPrice) {
        BigDecimal b = StringUtil.parseBigDecimal(assessSaleTotalPrice,new BigDecimal(0)).divide(new BigDecimal(10000));
        this.assessSaleTotalPrice = b.setScale(2,BigDecimal.ROUND_HALF_UP);

    }

    public BigDecimal getMaxSaleTotalPrice() {
        return maxSaleTotalPrice;
    }

    public void setMaxSaleTotalPrice(BigDecimal maxSaleTotalPrice) {
        this.maxSaleTotalPrice = maxSaleTotalPrice;
    }

    public BigDecimal getMinSaleTotalPrice() {
        return minSaleTotalPrice;
    }

    public void setMinSaleTotalPrice(BigDecimal minSaleTotalPrice) {
        this.minSaleTotalPrice = minSaleTotalPrice;
    }

    public BigDecimal getMaxRentPrice() {
        return maxRentPrice;
    }

    public void setMaxRentPrice(BigDecimal maxRentPrice) {
        this.maxRentPrice = maxRentPrice;
    }

    public BigDecimal getMinRentPrice() {
        return minRentPrice;
    }

    public void setMinRentPrice(BigDecimal minRentPrice) {
        this.minRentPrice = minRentPrice;
    }

    public String getAspectName() {
        return aspectName;
    }

    public void setAspectName(String aspectName) {
        this.aspectName = aspectName;
    }

    public String getFloorplanName() {
        return floorplanName;
    }

    public void setFloorplanName(String floorplanName) {
        this.floorplanName = floorplanName;
    }
}