package com.cindata.housekeeper.web.model;

import com.cindata.housekeeper.core.common.tools.StringUtil;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 
 */
public class Market implements Serializable {
    private List<CityMarket> cityMarketList = new ArrayList<CityMarket>();
    private List<DistrictMarket> districtMarketList = new ArrayList<DistrictMarket>();
    private List<CommunityMarket> communityMarketList = new ArrayList<CommunityMarket>();

    private Double maxPrice ;
    private Double minPrice;
    private Double risePercent;
    private Double nowPercent;
    private String date;
    private String cityName;
    private String districtName;
    private String communityName;

    public List<CityMarket> getCityMarketList() {
        return cityMarketList;
    }

    public void setCityMarketList(List<CityMarket> cityMarketList) {
        this.cityMarketList = cityMarketList;
    }

    public List<DistrictMarket> getDistrictMarketList() {
        return districtMarketList;
    }

    public void setDistrictMarketList(List<DistrictMarket> districtMarketList) {
        this.districtMarketList = districtMarketList;
    }

    public List<CommunityMarket> getCommunityMarketList() {
        return communityMarketList;
    }

    public void setCommunityMarketList(List<CommunityMarket> communityMarketList) {
        this.communityMarketList = communityMarketList;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Double getRisePercent() {
        return risePercent;
    }

    public void setRisePercent(Double risePercent) {
        BigDecimal b = StringUtil.parseBigDecimal(risePercent,null);
        if(b!=null){
            this.risePercent = b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();

        }
    }

    public Double getNowPercent() {
        return nowPercent;
    }

    public void setNowPercent(Double nowPercent) {
        this.nowPercent = nowPercent;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }
}