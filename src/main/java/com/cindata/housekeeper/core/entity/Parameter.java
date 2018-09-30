package com.cindata.housekeeper.core.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


public class Parameter {

	
	private Integer page;
	private Integer rows;
	private BigDecimal maxSalePrice;//单价最高价
	private BigDecimal minSalePrice;//单价最低价
	private Long districtId;
	private List districtIdList;
	private long inMinArea;//最小面积
	private long inMaxArea;//最大面积
	private String provinceName;
	private String cityName;
	private String districtName;
	private Date assessTime;//评估时间
	private Long changeTotalPrice;//总价格
	private String changeWay;//置换模式
	private long houseBudget;//预算价格
	private long havePrice;//现有资金
	private Long housePrice;//房屋估价
	private Integer houseId;
	private String intentionArea;
	private Long sqmprice;
	private String updateDate;
	private String userId;
	private Long totalprice;
	private String spId;
	private String spKey;
	private Long cityId;
	private Long provinceId;
	private Long communityId;

    private String communityName;
    private Date month;
    private String aspect;//朝向
    private BigDecimal square;//面积
    private String buildyear;//建成年代
    private Short floor;//当前层
    private String floorplantype;//户型
    private Double lng;//经度
    private Double lat;//纬度
    private Integer range;//范围
    private String purpose;//户型
	private Date startDate;
	private Date endDate;
    private String status; //贷款处理状态
	private String groupId;//机构id
    private String id;
	private Integer type;
	private Integer topNum;

	private Integer end_no;
	private Integer start_no;

	private String orderByClause;
    private String groupName;
    private String realname;
    private String username;
    private String name;
    private BigDecimal dr;
    
    private Date update;
    private String telephone;
    private String tempId;
    
	private String cityCode;
	private String communityIds;
    
    
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTempId() {
		return tempId;
	}

	public void setTempId(String tempId) {
		this.tempId = tempId;
	}

	public Date getUpdate() {
		return update;
	}

	public void setUpdate(Date update) {
		this.update = update;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getDr() {
		return dr;
	}

	public void setDr(BigDecimal dr) {
		this.dr = dr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
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

	public Long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	public long getInMinArea() {
		return inMinArea;
	}

	public void setInMinArea(long inMinArea) {
		this.inMinArea = inMinArea;
	}

	public long getInMaxArea() {
		return inMaxArea;
	}

	public void setInMaxArea(long inMaxArea) {
		this.inMaxArea = inMaxArea;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Date getAssessTime() {
		return assessTime;
	}

	public void setAssessTime(Date assessTime) {
		this.assessTime = assessTime;
	}

	public Long getChangeTotalPrice() {
		return changeTotalPrice;
	}

	public void setChangeTotalPrice(Long changeTotalPrice) {
		this.changeTotalPrice = changeTotalPrice;
	}

	public String getChangeWay() {
		return changeWay;
	}

	public void setChangeWay(String changeWay) {
		this.changeWay = changeWay;
	}

	public long getHouseBudget() {
		return houseBudget;
	}

	public void setHouseBudget(long houseBudget) {
		this.houseBudget = houseBudget;
	}

	public long getHavePrice() {
		return havePrice;
	}

	public void setHavePrice(long havePrice) {
		this.havePrice = havePrice;
	}

	public Long getHousePrice() {
		return housePrice;
	}

	public void setHousePrice(Long housePrice) {
		this.housePrice = housePrice;
	}

	public Integer getHouseId() {
		return houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	public String getIntentionArea() {
		return intentionArea;
	}

	public void setIntentionArea(String intentionArea) {
		this.intentionArea = intentionArea;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public Long getSqmprice() {
		return sqmprice;
	}

	public void setSqmprice(Long sqmprice) {
		this.sqmprice = sqmprice;
	}

	public void setTotalprice(Long totalprice) {
		this.totalprice = totalprice;
	}



	public long getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(long totalprice) {
		this.totalprice = totalprice;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getCommunityId() {
		return communityId;
	}

	public void setCommunityId(Long communityId) {
		this.communityId = communityId;
	}

	public String getSpId() {
		return spId;
	}

	public void setSpId(String spId) {
		this.spId = spId;
	}

	public String getSpKey() {
		return spKey;
	}

	public void setSpKey(String spKey) {
		this.spKey = spKey;
	}

	public Date getMonth() {
		return month;
	}

	public void setMonth(Date month) {
		this.month = month;
	}

	public BigDecimal getSquare() {
		return square;
	}

	public void setSquare(BigDecimal square) {
		this.square = square;
	}

    public String getAspect() {
        return aspect;
    }

    public void setAspect(String aspect) {
        this.aspect = aspect;
    }

    public String getBuildyear() {
        return buildyear;
    }

    public void setBuildyear(String buildyear) {
        this.buildyear = buildyear;
    }

    public Short getFloor() {
        return floor;
    }

    public void setFloor(Short floor) {
        this.floor = floor;
    }

    public String getFloorplantype() {
        return floorplantype;
    }

    public void setFloorplantype(String floorplantype) {
        this.floorplantype = floorplantype;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }



	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List getDistrictIdList() {
		return districtIdList;
	}

	public void setDistrictIdList(List districtIdList) {
		this.districtIdList = districtIdList;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getTopNum() {
		return topNum;
	}

	public void setTopNum(Integer topNum) {
		this.topNum = topNum;
	}

	public Integer getEnd_no() {
		return end_no;
	}

	public void setEnd_no(Integer end_no) {
		this.end_no = end_no;
	}

	public Integer getStart_no() {
		return start_no;
	}

	public void setStart_no(Integer start_no) {
		this.start_no = start_no;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCommunityIds() {
		return communityIds;
	}

	public void setCommunityIds(String communityIds) {
		this.communityIds = communityIds;
	}
}
