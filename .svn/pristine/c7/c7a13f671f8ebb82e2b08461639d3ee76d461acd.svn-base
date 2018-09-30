package com.cindata.housekeeper.web.model;

import com.cindata.housekeeper.core.common.tools.StringUtil;

import java.math.BigDecimal;
import java.util.Date;

public class UserInfo {
    private String id;

    private String mobile;

    private String password;

    private String nickname;

    private String realname;

    private String sex;

    private String headUrl;

    private BigDecimal cityId;

    private String cityName;

    private BigDecimal districtId;

    private String districtName;

    private BigDecimal companyId;

    private String companyName;

    private BigDecimal storeId;

    private String storeName;

    private BigDecimal storeCityId;

    private BigDecimal storeDistrictId;

    private String storeAddress;

    private String state;

    private Date regTime;

    private Date updateTime;

    private Date expiryTime;

    private String regIp;

    private String weixin2code;

    private String businessCard;

    private String introducer;

    private Date lastLoginTime;

    private int houseCount;

    private BigDecimal housePrice ;

    private int changeCount;

    private BigDecimal changePrice;

    private String groupId;

    private BigDecimal regType;

    private String countryName;

    private String provinceName;

    private String wxOpenid;

    private BigDecimal userType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl == null ? null : headUrl.trim();
    }

    public BigDecimal getCityId() {
        return cityId;
    }

    public void setCityId(BigDecimal cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public BigDecimal getDistrictId() {
        return districtId;
    }

    public void setDistrictId(BigDecimal districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName == null ? null : districtName.trim();
    }

    public BigDecimal getCompanyId() {
        return companyId;
    }

    public void setCompanyId(BigDecimal companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public BigDecimal getStoreId() {
        return storeId;
    }

    public void setStoreId(BigDecimal storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public BigDecimal getStoreCityId() {
        return storeCityId;
    }

    public void setStoreCityId(BigDecimal storeCityId) {
        this.storeCityId = storeCityId;
    }

    public BigDecimal getStoreDistrictId() {
        return storeDistrictId;
    }

    public void setStoreDistrictId(BigDecimal storeDistrictId) {
        this.storeDistrictId = storeDistrictId;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress == null ? null : storeAddress.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(Date expiryTime) {
        this.expiryTime = expiryTime;
    }

    public String getRegIp() {
        return regIp;
    }

    public void setRegIp(String regIp) {
        this.regIp = regIp == null ? null : regIp.trim();
    }

    public String getWeixin2code() {
        return weixin2code;
    }

    public void setWeixin2code(String weixin2code) {
        this.weixin2code = weixin2code == null ? null : weixin2code.trim();
    }

    public String getBusinessCard() {
        return businessCard;
    }

    public void setBusinessCard(String businessCard) {
        this.businessCard = businessCard == null ? null : businessCard.trim();
    }

    public String getIntroducer() {
        return introducer;
    }

    public void setIntroducer(String introducer) {
        this.introducer = introducer == null ? null : introducer.trim();
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public int getHouseCount() {
        return houseCount;
    }

    public void setHouseCount(int houseCount) {
        this.houseCount = houseCount;
    }

    public BigDecimal getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(BigDecimal housePrice) {
        BigDecimal b = StringUtil.parseBigDecimal(housePrice,new BigDecimal(0)).divide(new BigDecimal(10000));
        this.housePrice = b.setScale(2,BigDecimal.ROUND_HALF_UP);
    }

    public int getChangeCount() {
        return changeCount;
    }

    public void setChangeCount(int changeCount) {
        this.changeCount = changeCount;
    }

    public BigDecimal getChangePrice() {
        return changePrice;
    }

    public void setChangePrice(BigDecimal changePrice) {
        /*BigDecimal b = StringUtil.parseBigDecimal(changePrice,new BigDecimal(0)).divide(new BigDecimal(10000));
        this.changePrice = b.setScale(2,BigDecimal.ROUND_HALF_UP);*/
        this.changePrice = changePrice;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getWxOpenid() {
        return wxOpenid;
    }

    public void setWxOpenid(String wxOpenid) {
        this.wxOpenid = wxOpenid;
    }

    public BigDecimal getUserType() {
        return userType;
    }

    public void setUserType(BigDecimal userType) {
        this.userType = userType;
    }

    public BigDecimal getRegType() {
        return regType;
    }

    public void setRegType(BigDecimal regType) {
        this.regType = regType;
    }
}