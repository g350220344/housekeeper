package com.cindata.housekeeper.web.model;

import com.cindata.housekeeper.core.common.tools.PubDictValue;
import com.cindata.housekeeper.core.common.tools.StringUtil;

import java.math.BigDecimal;
import java.sql.Timestamp;



public class ApplyCommunityInfo {
    private String pictureUrlList;//小区图片列表

    private String roomTypePic;//户型图

    private String dayId;

    private Double supplyThanAll;//报盘率：供给量/总户数

    private Long communityId;//小区id

    private Long cityId;//城市id

    private Long districtId;//行政区id

    private Long companyId;//公司id

    private String propertymanagementcompany;//物业公司

    private String communityname;//小区名称

    private String detailaddress;//详细地址

    private String scale;//楼盘规模

    private BigDecimal buildingdensity;//建筑密度

    private BigDecimal plotratio;//容积率

    private BigDecimal greeningrate;//绿化率

    private BigDecimal coveringarea;//占地面积

    private BigDecimal buildingarea;//建筑面积

    private BigDecimal totalhouseholdcount;//总户数

    private String distancefromtradingname;//商圈名称

    private String linePosition;//环线位置

    private String communityscope;//小区规模

    private Integer totalbuildingcount;//总楼幢数

    private String buildingtype;//建筑类别

    private String pmgrade;//物业档次

    private String mainhousetype;//主力户型

    private String centralheating;//集中供暖

    private String centralhotwater;//集中热水

    private Short isNewCommunity;//是否虚拟

    private String iflift;//是否有电梯

    private String communityType;//小区类型

    private Long parkingNum;//车位配比率

    private String buildingform;//建筑形式

    private String buildinUse;//建筑形式

    private String remark;//备注

    private BigDecimal isdeleted;//逻辑删除(1:无效 0:有效)

    private Timestamp createdDt;//创建时间

    private String status;//处理状态

    private String dealPerson;//操作人

    private Timestamp updateDate;//更新时间

    private String dataSource;//数据来源

    private Long orderId;//流水号

    private String strOrder;//批次号

    private String dataOrgType;//数据来源类型

    private String isnew;//是否是新房源

    private String buildyear;//建成年份

    private String pmfee;//物业费

    private String carparkrate;//停车费

    private String streetId;//道路ID

    private String developerId;//开发商ID

    private BigDecimal longitude;//经度

    private BigDecimal latitude;//纬度

    private Integer result;
    private String msg;
    private Integer ranking;
    private String baiduMapUrl;
    private String pictureurl;
    private String buidingPic;//楼栋坐落图

    private BigDecimal salesqmprice;
    private BigDecimal renttotalprice;
    private String supplynumsale;
    private String supplynumrent;
    private String saledealcount;
    private String rentdealcount;

    private String streetNumName;
    private String streetName;

    private Double linkrate;//单价环比

    private String developername;//开发商
    private String companyname;//物业公司

    private BigDecimal communityScore;//评分

    private BigDecimal saleSqmPriceLinkRelativeRatio;//上月环比

    public Double getLinkrate() {
        return linkrate;
    }

    public void setLinkrate(Double linkrate) {
        this.linkrate = linkrate;
    }

    public String getBaiduMapUrl() {
        return baiduMapUrl == null ? "" : baiduMapUrl;
    }

    public void setBaiduMapUrl(String baiduMapUrl) {
        this.baiduMapUrl = baiduMapUrl;
    }

    public Integer getRanking() {
        return ranking == null ? 0 : ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Integer getResult() {
        return result == null ? 0 : result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getMsg() {
        return msg == null ? "" : msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    private String districtName;

    private String cityName;

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getPropertymanagementcompany() {
        return propertymanagementcompany == null ? "" : propertymanagementcompany;
    }

    public void setPropertymanagementcompany(String propertymanagementcompany) {
        this.propertymanagementcompany = propertymanagementcompany;
    }

    public String getCommunityname() {
        return communityname;
    }

    public void setCommunityname(String communityname) {
        this.communityname = communityname == null ? null : communityname.trim();
    }

    public String getDetailaddress() {
        if(this.streetName != null && !this.streetName.isEmpty()){
            return this.streetName + this.streetNumName + "号";
        }
        return detailaddress == null ? "" : detailaddress;
    }

    public void setDetailaddress(String detailaddress) {
        this.detailaddress = detailaddress == null ? null : detailaddress.trim();
    }

    public String getScale() {
        return scale == null ? "" : scale;
    }

    public void setScale(String scale) {
        this.scale = scale == null ? null : scale.trim();
    }

    public BigDecimal getBuildingdensity() {
        return buildingdensity == null ? new BigDecimal(0) : buildingdensity;
    }

    public void setBuildingdensity(BigDecimal buildingdensity) {
        this.buildingdensity = buildingdensity;
    }

    public BigDecimal getPlotratio() {
        return plotratio == null ? new BigDecimal(0) : plotratio;
    }

    public void setPlotratio(BigDecimal plotratio) {
        this.plotratio = plotratio;
    }

    public BigDecimal getGreeningrate() {
        return greeningrate == null ? new BigDecimal(0) : greeningrate;
    }

    public void setGreeningrate(BigDecimal greeningrate) {
        this.greeningrate = greeningrate;
    }

    public BigDecimal getCoveringarea() {
        return coveringarea == null ? new BigDecimal(0) : coveringarea;
    }

    public void setCoveringarea(BigDecimal coveringarea) {
        this.coveringarea = coveringarea;
    }

    public BigDecimal getBuildingarea() {
        return buildingarea == null ? new BigDecimal(0) : buildingarea;
    }

    public void setBuildingarea(BigDecimal buildingarea) {
        this.buildingarea = buildingarea;
    }

    public BigDecimal getTotalhouseholdcount() {
        return totalhouseholdcount == null ? new BigDecimal(0) : totalhouseholdcount;
    }

    public void setTotalhouseholdcount(BigDecimal totalhouseholdcount) {
        this.totalhouseholdcount = totalhouseholdcount;
    }

    public String getDistancefromtradingname() {
        return distancefromtradingname == null ? "" : distancefromtradingname;
    }

    public void setDistancefromtradingname(String distancefromtradingname) {
        this.distancefromtradingname = distancefromtradingname == null ? null : distancefromtradingname.trim();
    }

    public String getLinePosition() {
        return linePosition == null ? "" : linePosition;
    }

    public void setLinePosition(String linePosition) {
        this.linePosition = linePosition == null ? null : linePosition.trim();
    }

    public String getCommunityscope() {
        return communityscope == null ? "" : communityscope;
    }

    public void setCommunityscope(String communityscope) {
        this.communityscope = communityscope == null ? null : communityscope.trim();
    }

    public Integer getTotalbuildingcount() {
        if(totalbuildingcount!= null && totalbuildingcount<0)
            return totalbuildingcount = 0;
        return totalbuildingcount == null ? 0 : totalbuildingcount;
    }

    public void setTotalbuildingcount(Integer totalbuildingcount) {
        this.totalbuildingcount = totalbuildingcount;
    }

    public String getBuildingtype() {
        String ret = "";
        if(buildingtype != null && StringUtil.parseInt(buildingtype, 0) > 0){
            ret = buildingtype;
        }
        return ret;
    }

    public void setBuildingtype(String buildingtype) {
        this.buildingtype = buildingtype == null ? null : buildingtype.trim();
    }

    public String getPmgrade() {
        return pmgrade == null ? "" : pmgrade;
    }

    public void setPmgrade(String pmgrade) {
        this.pmgrade = pmgrade == null ? null : pmgrade.trim();
    }

    public String getMainhousetype() {
        if(mainhousetype!= null && "-1".equals(mainhousetype))
            return mainhousetype = "";
        return mainhousetype == null ? "" : mainhousetype;
    }

    public void setMainhousetype(String mainhousetype) {
        this.mainhousetype = mainhousetype == null ? null : mainhousetype.trim();
    }

    public String getCentralheating() {
        return centralheating == null ? "" : centralheating;
    }

    public void setCentralheating(String centralheating) {
        this.centralheating = centralheating == null ? null : centralheating.trim();
    }

    public String getCentralhotwater() {
        return centralhotwater == null ? "" : centralhotwater;
    }

    public void setCentralhotwater(String centralhotwater) {
        this.centralhotwater = centralhotwater == null ? null : centralhotwater.trim();
    }

    public Short getIsNewCommunity() {
        return isNewCommunity == null ? 0 : isNewCommunity;
    }

    public void setIsNewCommunity(Short isNewCommunity) {
        this.isNewCommunity = isNewCommunity;
    }

    public String getIflift() {
        return iflift == null ? "" : iflift;
    }

    public void setIflift(String iflift) {
        this.iflift = iflift == null ? null : iflift.trim();
    }

    public String getCommunityType() {
        if(communityType!=null && !"".equals(communityType))
            return PubDictValue.getPurposeNameByCode(communityType);
        else
            return communityType == null ? "" : communityType;
    }

    public void setCommunityType(String communityType) {
        this.communityType = communityType == null ? null : communityType.trim();
    }

    public Long getParkingNum() {
        return parkingNum == null ? 0l : parkingNum;
    }

    public void setParkingNum(Long parkingNum) {
        this.parkingNum = parkingNum;
    }

    public String getBuildingform() {
        return buildingform == null ? "" : buildingform;
    }

    public void setBuildingform(String buildingform) {
        this.buildingform = buildingform == null ? null : buildingform.trim();
    }

    public String getBuildinUse() {
        return buildinUse == null ? "" : buildinUse;
    }

    public void setBuildinUse(String buildinUse) {
        this.buildinUse = buildinUse == null ? null : buildinUse.trim();
    }

    public String getRemark() {
        return remark == null ? "" : remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public BigDecimal getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(BigDecimal isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Timestamp getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(Timestamp createdDt) {
        this.createdDt = createdDt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getDealPerson() {
        return dealPerson == null ? "" : dealPerson;
    }

    public void setDealPerson(String dealPerson) {
        this.dealPerson = dealPerson == null ? null : dealPerson.trim();
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public String getDataSource() {
        return dataSource == null ? "" : dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource == null ? null : dataSource.trim();
    }

    public Long getOrderId() {
//        return orderId;
        return 0l;
    }

    public void setOrderId(Long orderId) {
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

    public String getIsnew() {
        return isnew;
    }

    public void setIsnew(String isnew) {
        this.isnew = isnew == null ? null : isnew.trim();
    }

    public String getBuildyear() {
        return buildyear == null ? "" : buildyear;
    }

    public void setBuildyear(String buildyear) {
        this.buildyear = buildyear == null ? null : buildyear.trim();
    }

    public String getPmfee() {
        return pmfee == null ? "" : pmfee;
    }

    public void setPmfee(String pmfee) {
        this.pmfee = pmfee == null ? null : pmfee.trim();
    }

    public String getCarparkrate() {
        return carparkrate == null ? "" : carparkrate;
    }

    public void setCarparkrate(String carparkrate) {
        this.carparkrate = carparkrate == null ? null : carparkrate.trim();
    }

    public String getStreetId() {
        return streetId;
    }

    public void setStreetId(String streetId) {
        this.streetId = streetId == null ? null : streetId.trim();
    }

    public String getDeveloperId() {
        return developerId == null ? "" : developerId;
    }

    public void setDeveloperId(String developerId) {
        this.developerId = developerId == null ? null : developerId.trim();
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

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName == null ? null : districtName.trim();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public String getPictureurl() {
        return pictureurl;
    }

    public void setPictureurl(String pictureurl) {
        this.pictureurl = pictureurl;
    }

    public BigDecimal getSalesqmprice() {
        return salesqmprice;
    }

    public void setSalesqmprice(BigDecimal salesqmprice) {
        this.salesqmprice = salesqmprice;
    }

    public BigDecimal getRenttotalprice() {
        return renttotalprice;
    }

    public void setRenttotalprice(BigDecimal renttotalprice) {
        this.renttotalprice = renttotalprice;
    }

    public String getSupplynumsale() {
        return supplynumsale;
    }

    public void setSupplynumsale(String supplynumsale) {
        this.supplynumsale = supplynumsale;
    }

    public String getSupplynumrent() {
        return supplynumrent;
    }

    public void setSupplynumrent(String supplynumrent) {
        this.supplynumrent = supplynumrent;
    }

    public String getSaledealcount() {
        return saledealcount;
    }

    public void setSaledealcount(String saledealcount) {
        this.saledealcount = saledealcount;
    }

    public String getRentdealcount() {
        return rentdealcount;
    }

    public void setRentdealcount(String rentdealcount) {
        this.rentdealcount = rentdealcount;
    }

    public String getStreetNumName() {
        return streetNumName;
    }

    public void setStreetNumName(String streetNumName) {
        this.streetNumName = streetNumName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Double getSupplyThanAll() {
        return supplyThanAll;
    }

    public void setSupplyThanAll(Double supplyThanAll) {
        this.supplyThanAll = supplyThanAll;
    }

    public void setSupplyThanAllBySupply(Integer supply) {
        if(supply != null && supply > 0 && this.totalhouseholdcount != null && totalhouseholdcount.intValue() > 0){
            this.supplyThanAll = StringUtil.parseDouble(supply, 0.0)/totalhouseholdcount.doubleValue();
        }
    }

    public String getBuidingPic() {
        if(StringUtil.isNotNullOrEmpty(buidingPic)){
            return "/" + buidingPic;
        }
        return buidingPic;
    }

    public void setBuidingPic(String buidingPic) {
        this.buidingPic = buidingPic;
    }

    public String getDayId() {
        return dayId;
    }

    public void setDayId(String dayId) {
        this.dayId = dayId;
    }

    public String getRoomTypePic() {
        return roomTypePic;
    }

    public void setRoomTypePic(String roomTypePic) {
        this.roomTypePic = roomTypePic;
    }

    public String getPictureUrlList() {
        return pictureUrlList;
    }

    public void setPictureUrlList(String pictureUrlList) {
        this.pictureUrlList = pictureUrlList;
    }

    public String getDevelopername() {
        return developername;
    }

    public void setDevelopername(String developername) {
        this.developername = developername;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public BigDecimal getCommunityScore() {
        return communityScore;
    }

    public void setCommunityScore(BigDecimal communityScore) {
        this.communityScore = communityScore;
    }

    public BigDecimal getSaleSqmPriceLinkRelativeRatio() {
        return saleSqmPriceLinkRelativeRatio;
    }

    public void setSaleSqmPriceLinkRelativeRatio(BigDecimal saleSqmPriceLinkRelativeRatio) {
        this.saleSqmPriceLinkRelativeRatio = saleSqmPriceLinkRelativeRatio;
    }
}