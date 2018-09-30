package com.cindata.housekeeper.wx.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class WxHouseInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WxHouseInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andHouseIdIsNull() {
            addCriterion("HOUSE_ID is null");
            return (Criteria) this;
        }

        public Criteria andHouseIdIsNotNull() {
            addCriterion("HOUSE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andHouseIdEqualTo(BigDecimal value) {
            addCriterion("HOUSE_ID =", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdNotEqualTo(BigDecimal value) {
            addCriterion("HOUSE_ID <>", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdGreaterThan(BigDecimal value) {
            addCriterion("HOUSE_ID >", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HOUSE_ID >=", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdLessThan(BigDecimal value) {
            addCriterion("HOUSE_ID <", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HOUSE_ID <=", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdIn(List<BigDecimal> values) {
            addCriterion("HOUSE_ID in", values, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdNotIn(List<BigDecimal> values) {
            addCriterion("HOUSE_ID not in", values, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOUSE_ID between", value1, value2, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOUSE_ID not between", value1, value2, "houseId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdIsNull() {
            addCriterion("COMMUNITY_ID is null");
            return (Criteria) this;
        }

        public Criteria andCommunityIdIsNotNull() {
            addCriterion("COMMUNITY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityIdEqualTo(BigDecimal value) {
            addCriterion("COMMUNITY_ID =", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdNotEqualTo(BigDecimal value) {
            addCriterion("COMMUNITY_ID <>", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdGreaterThan(BigDecimal value) {
            addCriterion("COMMUNITY_ID >", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COMMUNITY_ID >=", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdLessThan(BigDecimal value) {
            addCriterion("COMMUNITY_ID <", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COMMUNITY_ID <=", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdIn(List<BigDecimal> values) {
            addCriterion("COMMUNITY_ID in", values, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdNotIn(List<BigDecimal> values) {
            addCriterion("COMMUNITY_ID not in", values, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COMMUNITY_ID between", value1, value2, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COMMUNITY_ID not between", value1, value2, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityNameIsNull() {
            addCriterion("COMMUNITY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCommunityNameIsNotNull() {
            addCriterion("COMMUNITY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityNameEqualTo(String value) {
            addCriterion("COMMUNITY_NAME =", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameNotEqualTo(String value) {
            addCriterion("COMMUNITY_NAME <>", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameGreaterThan(String value) {
            addCriterion("COMMUNITY_NAME >", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameGreaterThanOrEqualTo(String value) {
            addCriterion("COMMUNITY_NAME >=", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameLessThan(String value) {
            addCriterion("COMMUNITY_NAME <", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameLessThanOrEqualTo(String value) {
            addCriterion("COMMUNITY_NAME <=", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameLike(String value) {
            addCriterion("COMMUNITY_NAME like", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameNotLike(String value) {
            addCriterion("COMMUNITY_NAME not like", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameIn(List<String> values) {
            addCriterion("COMMUNITY_NAME in", values, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameNotIn(List<String> values) {
            addCriterion("COMMUNITY_NAME not in", values, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameBetween(String value1, String value2) {
            addCriterion("COMMUNITY_NAME between", value1, value2, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameNotBetween(String value1, String value2) {
            addCriterion("COMMUNITY_NAME not between", value1, value2, "communityName");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNull() {
            addCriterion("CITY_ID is null");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNotNull() {
            addCriterion("CITY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCityIdEqualTo(BigDecimal value) {
            addCriterion("CITY_ID =", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotEqualTo(BigDecimal value) {
            addCriterion("CITY_ID <>", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThan(BigDecimal value) {
            addCriterion("CITY_ID >", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CITY_ID >=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThan(BigDecimal value) {
            addCriterion("CITY_ID <", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CITY_ID <=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdIn(List<BigDecimal> values) {
            addCriterion("CITY_ID in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotIn(List<BigDecimal> values) {
            addCriterion("CITY_ID not in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CITY_ID between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CITY_ID not between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityNameIsNull() {
            addCriterion("CITY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCityNameIsNotNull() {
            addCriterion("CITY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCityNameEqualTo(String value) {
            addCriterion("CITY_NAME =", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotEqualTo(String value) {
            addCriterion("CITY_NAME <>", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameGreaterThan(String value) {
            addCriterion("CITY_NAME >", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameGreaterThanOrEqualTo(String value) {
            addCriterion("CITY_NAME >=", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLessThan(String value) {
            addCriterion("CITY_NAME <", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLessThanOrEqualTo(String value) {
            addCriterion("CITY_NAME <=", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLike(String value) {
            addCriterion("CITY_NAME like", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotLike(String value) {
            addCriterion("CITY_NAME not like", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameIn(List<String> values) {
            addCriterion("CITY_NAME in", values, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotIn(List<String> values) {
            addCriterion("CITY_NAME not in", values, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameBetween(String value1, String value2) {
            addCriterion("CITY_NAME between", value1, value2, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotBetween(String value1, String value2) {
            addCriterion("CITY_NAME not between", value1, value2, "cityName");
            return (Criteria) this;
        }

        public Criteria andDistrictIdIsNull() {
            addCriterion("DISTRICT_ID is null");
            return (Criteria) this;
        }

        public Criteria andDistrictIdIsNotNull() {
            addCriterion("DISTRICT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictIdEqualTo(Long value) {
            addCriterion("DISTRICT_ID =", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotEqualTo(Long value) {
            addCriterion("DISTRICT_ID <>", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdGreaterThan(Long value) {
            addCriterion("DISTRICT_ID >", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdGreaterThanOrEqualTo(Long value) {
            addCriterion("DISTRICT_ID >=", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdLessThan(Long value) {
            addCriterion("DISTRICT_ID <", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdLessThanOrEqualTo(Long value) {
            addCriterion("DISTRICT_ID <=", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdIn(List<Long> values) {
            addCriterion("DISTRICT_ID in", values, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotIn(List<Long> values) {
            addCriterion("DISTRICT_ID not in", values, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdBetween(Long value1, Long value2) {
            addCriterion("DISTRICT_ID between", value1, value2, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotBetween(Long value1, Long value2) {
            addCriterion("DISTRICT_ID not between", value1, value2, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictNameIsNull() {
            addCriterion("DISTRICT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDistrictNameIsNotNull() {
            addCriterion("DISTRICT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictNameEqualTo(String value) {
            addCriterion("DISTRICT_NAME =", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameNotEqualTo(String value) {
            addCriterion("DISTRICT_NAME <>", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameGreaterThan(String value) {
            addCriterion("DISTRICT_NAME >", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameGreaterThanOrEqualTo(String value) {
            addCriterion("DISTRICT_NAME >=", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameLessThan(String value) {
            addCriterion("DISTRICT_NAME <", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameLessThanOrEqualTo(String value) {
            addCriterion("DISTRICT_NAME <=", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameLike(String value) {
            addCriterion("DISTRICT_NAME like", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameNotLike(String value) {
            addCriterion("DISTRICT_NAME not like", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameIn(List<String> values) {
            addCriterion("DISTRICT_NAME in", values, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameNotIn(List<String> values) {
            addCriterion("DISTRICT_NAME not in", values, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameBetween(String value1, String value2) {
            addCriterion("DISTRICT_NAME between", value1, value2, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameNotBetween(String value1, String value2) {
            addCriterion("DISTRICT_NAME not between", value1, value2, "districtName");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIsNull() {
            addCriterion("PROVINCE_ID is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIsNotNull() {
            addCriterion("PROVINCE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceIdEqualTo(BigDecimal value) {
            addCriterion("PROVINCE_ID =", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotEqualTo(BigDecimal value) {
            addCriterion("PROVINCE_ID <>", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdGreaterThan(BigDecimal value) {
            addCriterion("PROVINCE_ID >", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROVINCE_ID >=", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLessThan(BigDecimal value) {
            addCriterion("PROVINCE_ID <", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROVINCE_ID <=", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIn(List<BigDecimal> values) {
            addCriterion("PROVINCE_ID in", values, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotIn(List<BigDecimal> values) {
            addCriterion("PROVINCE_ID not in", values, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROVINCE_ID between", value1, value2, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROVINCE_ID not between", value1, value2, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceNameIsNull() {
            addCriterion("PROVINCE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andProvinceNameIsNotNull() {
            addCriterion("PROVINCE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceNameEqualTo(String value) {
            addCriterion("PROVINCE_NAME =", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotEqualTo(String value) {
            addCriterion("PROVINCE_NAME <>", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameGreaterThan(String value) {
            addCriterion("PROVINCE_NAME >", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameGreaterThanOrEqualTo(String value) {
            addCriterion("PROVINCE_NAME >=", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameLessThan(String value) {
            addCriterion("PROVINCE_NAME <", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameLessThanOrEqualTo(String value) {
            addCriterion("PROVINCE_NAME <=", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameLike(String value) {
            addCriterion("PROVINCE_NAME like", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotLike(String value) {
            addCriterion("PROVINCE_NAME not like", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameIn(List<String> values) {
            addCriterion("PROVINCE_NAME in", values, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotIn(List<String> values) {
            addCriterion("PROVINCE_NAME not in", values, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameBetween(String value1, String value2) {
            addCriterion("PROVINCE_NAME between", value1, value2, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotBetween(String value1, String value2) {
            addCriterion("PROVINCE_NAME not between", value1, value2, "provinceName");
            return (Criteria) this;
        }

        public Criteria andBuildingNumIsNull() {
            addCriterion("BUILDING_NUM is null");
            return (Criteria) this;
        }

        public Criteria andBuildingNumIsNotNull() {
            addCriterion("BUILDING_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingNumEqualTo(BigDecimal value) {
            addCriterion("BUILDING_NUM =", value, "buildingNum");
            return (Criteria) this;
        }

        public Criteria andBuildingNumNotEqualTo(BigDecimal value) {
            addCriterion("BUILDING_NUM <>", value, "buildingNum");
            return (Criteria) this;
        }

        public Criteria andBuildingNumGreaterThan(BigDecimal value) {
            addCriterion("BUILDING_NUM >", value, "buildingNum");
            return (Criteria) this;
        }

        public Criteria andBuildingNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BUILDING_NUM >=", value, "buildingNum");
            return (Criteria) this;
        }

        public Criteria andBuildingNumLessThan(BigDecimal value) {
            addCriterion("BUILDING_NUM <", value, "buildingNum");
            return (Criteria) this;
        }

        public Criteria andBuildingNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BUILDING_NUM <=", value, "buildingNum");
            return (Criteria) this;
        }

        public Criteria andBuildingNumIn(List<BigDecimal> values) {
            addCriterion("BUILDING_NUM in", values, "buildingNum");
            return (Criteria) this;
        }

        public Criteria andBuildingNumNotIn(List<BigDecimal> values) {
            addCriterion("BUILDING_NUM not in", values, "buildingNum");
            return (Criteria) this;
        }

        public Criteria andBuildingNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUILDING_NUM between", value1, value2, "buildingNum");
            return (Criteria) this;
        }

        public Criteria andBuildingNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUILDING_NUM not between", value1, value2, "buildingNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumIsNull() {
            addCriterion("UNIT_NUM is null");
            return (Criteria) this;
        }

        public Criteria andUnitNumIsNotNull() {
            addCriterion("UNIT_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andUnitNumEqualTo(BigDecimal value) {
            addCriterion("UNIT_NUM =", value, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumNotEqualTo(BigDecimal value) {
            addCriterion("UNIT_NUM <>", value, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumGreaterThan(BigDecimal value) {
            addCriterion("UNIT_NUM >", value, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("UNIT_NUM >=", value, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumLessThan(BigDecimal value) {
            addCriterion("UNIT_NUM <", value, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("UNIT_NUM <=", value, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumIn(List<BigDecimal> values) {
            addCriterion("UNIT_NUM in", values, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumNotIn(List<BigDecimal> values) {
            addCriterion("UNIT_NUM not in", values, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UNIT_NUM between", value1, value2, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UNIT_NUM not between", value1, value2, "unitNum");
            return (Criteria) this;
        }

        public Criteria andDoorNumIsNull() {
            addCriterion("DOOR_NUM is null");
            return (Criteria) this;
        }

        public Criteria andDoorNumIsNotNull() {
            addCriterion("DOOR_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andDoorNumEqualTo(String value) {
            addCriterion("DOOR_NUM =", value, "doorNum");
            return (Criteria) this;
        }

        public Criteria andDoorNumNotEqualTo(String value) {
            addCriterion("DOOR_NUM <>", value, "doorNum");
            return (Criteria) this;
        }

        public Criteria andDoorNumGreaterThan(String value) {
            addCriterion("DOOR_NUM >", value, "doorNum");
            return (Criteria) this;
        }

        public Criteria andDoorNumGreaterThanOrEqualTo(String value) {
            addCriterion("DOOR_NUM >=", value, "doorNum");
            return (Criteria) this;
        }

        public Criteria andDoorNumLessThan(String value) {
            addCriterion("DOOR_NUM <", value, "doorNum");
            return (Criteria) this;
        }

        public Criteria andDoorNumLessThanOrEqualTo(String value) {
            addCriterion("DOOR_NUM <=", value, "doorNum");
            return (Criteria) this;
        }

        public Criteria andDoorNumLike(String value) {
            addCriterion("DOOR_NUM like", value, "doorNum");
            return (Criteria) this;
        }

        public Criteria andDoorNumNotLike(String value) {
            addCriterion("DOOR_NUM not like", value, "doorNum");
            return (Criteria) this;
        }

        public Criteria andDoorNumIn(List<String> values) {
            addCriterion("DOOR_NUM in", values, "doorNum");
            return (Criteria) this;
        }

        public Criteria andDoorNumNotIn(List<String> values) {
            addCriterion("DOOR_NUM not in", values, "doorNum");
            return (Criteria) this;
        }

        public Criteria andDoorNumBetween(String value1, String value2) {
            addCriterion("DOOR_NUM between", value1, value2, "doorNum");
            return (Criteria) this;
        }

        public Criteria andDoorNumNotBetween(String value1, String value2) {
            addCriterion("DOOR_NUM not between", value1, value2, "doorNum");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("ADDRESS =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("ADDRESS <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("ADDRESS >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("ADDRESS <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("ADDRESS like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("ADDRESS not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("ADDRESS in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("ADDRESS not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("ADDRESS between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("ADDRESS not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andBuildyearIsNull() {
            addCriterion("BUILDYEAR is null");
            return (Criteria) this;
        }

        public Criteria andBuildyearIsNotNull() {
            addCriterion("BUILDYEAR is not null");
            return (Criteria) this;
        }

        public Criteria andBuildyearEqualTo(String value) {
            addCriterion("BUILDYEAR =", value, "buildyear");
            return (Criteria) this;
        }

        public Criteria andBuildyearNotEqualTo(String value) {
            addCriterion("BUILDYEAR <>", value, "buildyear");
            return (Criteria) this;
        }

        public Criteria andBuildyearGreaterThan(String value) {
            addCriterion("BUILDYEAR >", value, "buildyear");
            return (Criteria) this;
        }

        public Criteria andBuildyearGreaterThanOrEqualTo(String value) {
            addCriterion("BUILDYEAR >=", value, "buildyear");
            return (Criteria) this;
        }

        public Criteria andBuildyearLessThan(String value) {
            addCriterion("BUILDYEAR <", value, "buildyear");
            return (Criteria) this;
        }

        public Criteria andBuildyearLessThanOrEqualTo(String value) {
            addCriterion("BUILDYEAR <=", value, "buildyear");
            return (Criteria) this;
        }

        public Criteria andBuildyearLike(String value) {
            addCriterion("BUILDYEAR like", value, "buildyear");
            return (Criteria) this;
        }

        public Criteria andBuildyearNotLike(String value) {
            addCriterion("BUILDYEAR not like", value, "buildyear");
            return (Criteria) this;
        }

        public Criteria andBuildyearIn(List<String> values) {
            addCriterion("BUILDYEAR in", values, "buildyear");
            return (Criteria) this;
        }

        public Criteria andBuildyearNotIn(List<String> values) {
            addCriterion("BUILDYEAR not in", values, "buildyear");
            return (Criteria) this;
        }

        public Criteria andBuildyearBetween(String value1, String value2) {
            addCriterion("BUILDYEAR between", value1, value2, "buildyear");
            return (Criteria) this;
        }

        public Criteria andBuildyearNotBetween(String value1, String value2) {
            addCriterion("BUILDYEAR not between", value1, value2, "buildyear");
            return (Criteria) this;
        }

        public Criteria andIsfirstIsNull() {
            addCriterion("ISFIRST is null");
            return (Criteria) this;
        }

        public Criteria andIsfirstIsNotNull() {
            addCriterion("ISFIRST is not null");
            return (Criteria) this;
        }

        public Criteria andIsfirstEqualTo(Short value) {
            addCriterion("ISFIRST =", value, "isfirst");
            return (Criteria) this;
        }

        public Criteria andIsfirstNotEqualTo(Short value) {
            addCriterion("ISFIRST <>", value, "isfirst");
            return (Criteria) this;
        }

        public Criteria andIsfirstGreaterThan(Short value) {
            addCriterion("ISFIRST >", value, "isfirst");
            return (Criteria) this;
        }

        public Criteria andIsfirstGreaterThanOrEqualTo(Short value) {
            addCriterion("ISFIRST >=", value, "isfirst");
            return (Criteria) this;
        }

        public Criteria andIsfirstLessThan(Short value) {
            addCriterion("ISFIRST <", value, "isfirst");
            return (Criteria) this;
        }

        public Criteria andIsfirstLessThanOrEqualTo(Short value) {
            addCriterion("ISFIRST <=", value, "isfirst");
            return (Criteria) this;
        }

        public Criteria andIsfirstIn(List<Short> values) {
            addCriterion("ISFIRST in", values, "isfirst");
            return (Criteria) this;
        }

        public Criteria andIsfirstNotIn(List<Short> values) {
            addCriterion("ISFIRST not in", values, "isfirst");
            return (Criteria) this;
        }

        public Criteria andIsfirstBetween(Short value1, Short value2) {
            addCriterion("ISFIRST between", value1, value2, "isfirst");
            return (Criteria) this;
        }

        public Criteria andIsfirstNotBetween(Short value1, Short value2) {
            addCriterion("ISFIRST not between", value1, value2, "isfirst");
            return (Criteria) this;
        }

        public Criteria andTotalfloorIsNull() {
            addCriterion("TOTALFLOOR is null");
            return (Criteria) this;
        }

        public Criteria andTotalfloorIsNotNull() {
            addCriterion("TOTALFLOOR is not null");
            return (Criteria) this;
        }

        public Criteria andTotalfloorEqualTo(Long value) {
            addCriterion("TOTALFLOOR =", value, "totalfloor");
            return (Criteria) this;
        }

        public Criteria andTotalfloorNotEqualTo(Long value) {
            addCriterion("TOTALFLOOR <>", value, "totalfloor");
            return (Criteria) this;
        }

        public Criteria andTotalfloorGreaterThan(Long value) {
            addCriterion("TOTALFLOOR >", value, "totalfloor");
            return (Criteria) this;
        }

        public Criteria andTotalfloorGreaterThanOrEqualTo(Long value) {
            addCriterion("TOTALFLOOR >=", value, "totalfloor");
            return (Criteria) this;
        }

        public Criteria andTotalfloorLessThan(Long value) {
            addCriterion("TOTALFLOOR <", value, "totalfloor");
            return (Criteria) this;
        }

        public Criteria andTotalfloorLessThanOrEqualTo(Long value) {
            addCriterion("TOTALFLOOR <=", value, "totalfloor");
            return (Criteria) this;
        }

        public Criteria andTotalfloorIn(List<Long> values) {
            addCriterion("TOTALFLOOR in", values, "totalfloor");
            return (Criteria) this;
        }

        public Criteria andTotalfloorNotIn(List<Long> values) {
            addCriterion("TOTALFLOOR not in", values, "totalfloor");
            return (Criteria) this;
        }

        public Criteria andTotalfloorBetween(Long value1, Long value2) {
            addCriterion("TOTALFLOOR between", value1, value2, "totalfloor");
            return (Criteria) this;
        }

        public Criteria andTotalfloorNotBetween(Long value1, Long value2) {
            addCriterion("TOTALFLOOR not between", value1, value2, "totalfloor");
            return (Criteria) this;
        }

        public Criteria andCurrentfloorIsNull() {
            addCriterion("CURRENTFLOOR is null");
            return (Criteria) this;
        }

        public Criteria andCurrentfloorIsNotNull() {
            addCriterion("CURRENTFLOOR is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentfloorEqualTo(Long value) {
            addCriterion("CURRENTFLOOR =", value, "currentfloor");
            return (Criteria) this;
        }

        public Criteria andCurrentfloorNotEqualTo(Long value) {
            addCriterion("CURRENTFLOOR <>", value, "currentfloor");
            return (Criteria) this;
        }

        public Criteria andCurrentfloorGreaterThan(Long value) {
            addCriterion("CURRENTFLOOR >", value, "currentfloor");
            return (Criteria) this;
        }

        public Criteria andCurrentfloorGreaterThanOrEqualTo(Long value) {
            addCriterion("CURRENTFLOOR >=", value, "currentfloor");
            return (Criteria) this;
        }

        public Criteria andCurrentfloorLessThan(Long value) {
            addCriterion("CURRENTFLOOR <", value, "currentfloor");
            return (Criteria) this;
        }

        public Criteria andCurrentfloorLessThanOrEqualTo(Long value) {
            addCriterion("CURRENTFLOOR <=", value, "currentfloor");
            return (Criteria) this;
        }

        public Criteria andCurrentfloorIn(List<Long> values) {
            addCriterion("CURRENTFLOOR in", values, "currentfloor");
            return (Criteria) this;
        }

        public Criteria andCurrentfloorNotIn(List<Long> values) {
            addCriterion("CURRENTFLOOR not in", values, "currentfloor");
            return (Criteria) this;
        }

        public Criteria andCurrentfloorBetween(Long value1, Long value2) {
            addCriterion("CURRENTFLOOR between", value1, value2, "currentfloor");
            return (Criteria) this;
        }

        public Criteria andCurrentfloorNotBetween(Long value1, Long value2) {
            addCriterion("CURRENTFLOOR not between", value1, value2, "currentfloor");
            return (Criteria) this;
        }

        public Criteria andAspectIsNull() {
            addCriterion("ASPECT is null");
            return (Criteria) this;
        }

        public Criteria andAspectIsNotNull() {
            addCriterion("ASPECT is not null");
            return (Criteria) this;
        }

        public Criteria andAspectEqualTo(String value) {
            addCriterion("ASPECT =", value, "aspect");
            return (Criteria) this;
        }

        public Criteria andAspectNotEqualTo(String value) {
            addCriterion("ASPECT <>", value, "aspect");
            return (Criteria) this;
        }

        public Criteria andAspectGreaterThan(String value) {
            addCriterion("ASPECT >", value, "aspect");
            return (Criteria) this;
        }

        public Criteria andAspectGreaterThanOrEqualTo(String value) {
            addCriterion("ASPECT >=", value, "aspect");
            return (Criteria) this;
        }

        public Criteria andAspectLessThan(String value) {
            addCriterion("ASPECT <", value, "aspect");
            return (Criteria) this;
        }

        public Criteria andAspectLessThanOrEqualTo(String value) {
            addCriterion("ASPECT <=", value, "aspect");
            return (Criteria) this;
        }

        public Criteria andAspectLike(String value) {
            addCriterion("ASPECT like", value, "aspect");
            return (Criteria) this;
        }

        public Criteria andAspectNotLike(String value) {
            addCriterion("ASPECT not like", value, "aspect");
            return (Criteria) this;
        }

        public Criteria andAspectIn(List<String> values) {
            addCriterion("ASPECT in", values, "aspect");
            return (Criteria) this;
        }

        public Criteria andAspectNotIn(List<String> values) {
            addCriterion("ASPECT not in", values, "aspect");
            return (Criteria) this;
        }

        public Criteria andAspectBetween(String value1, String value2) {
            addCriterion("ASPECT between", value1, value2, "aspect");
            return (Criteria) this;
        }

        public Criteria andAspectNotBetween(String value1, String value2) {
            addCriterion("ASPECT not between", value1, value2, "aspect");
            return (Criteria) this;
        }

        public Criteria andBuildingsquareIsNull() {
            addCriterion("BUILDINGSQUARE is null");
            return (Criteria) this;
        }

        public Criteria andBuildingsquareIsNotNull() {
            addCriterion("BUILDINGSQUARE is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingsquareEqualTo(BigDecimal value) {
            addCriterion("BUILDINGSQUARE =", value, "buildingsquare");
            return (Criteria) this;
        }

        public Criteria andBuildingsquareNotEqualTo(BigDecimal value) {
            addCriterion("BUILDINGSQUARE <>", value, "buildingsquare");
            return (Criteria) this;
        }

        public Criteria andBuildingsquareGreaterThan(BigDecimal value) {
            addCriterion("BUILDINGSQUARE >", value, "buildingsquare");
            return (Criteria) this;
        }

        public Criteria andBuildingsquareGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BUILDINGSQUARE >=", value, "buildingsquare");
            return (Criteria) this;
        }

        public Criteria andBuildingsquareLessThan(BigDecimal value) {
            addCriterion("BUILDINGSQUARE <", value, "buildingsquare");
            return (Criteria) this;
        }

        public Criteria andBuildingsquareLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BUILDINGSQUARE <=", value, "buildingsquare");
            return (Criteria) this;
        }

        public Criteria andBuildingsquareIn(List<BigDecimal> values) {
            addCriterion("BUILDINGSQUARE in", values, "buildingsquare");
            return (Criteria) this;
        }

        public Criteria andBuildingsquareNotIn(List<BigDecimal> values) {
            addCriterion("BUILDINGSQUARE not in", values, "buildingsquare");
            return (Criteria) this;
        }

        public Criteria andBuildingsquareBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUILDINGSQUARE between", value1, value2, "buildingsquare");
            return (Criteria) this;
        }

        public Criteria andBuildingsquareNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUILDINGSQUARE not between", value1, value2, "buildingsquare");
            return (Criteria) this;
        }

        public Criteria andLivingsquareIsNull() {
            addCriterion("LIVINGSQUARE is null");
            return (Criteria) this;
        }

        public Criteria andLivingsquareIsNotNull() {
            addCriterion("LIVINGSQUARE is not null");
            return (Criteria) this;
        }

        public Criteria andLivingsquareEqualTo(BigDecimal value) {
            addCriterion("LIVINGSQUARE =", value, "livingsquare");
            return (Criteria) this;
        }

        public Criteria andLivingsquareNotEqualTo(BigDecimal value) {
            addCriterion("LIVINGSQUARE <>", value, "livingsquare");
            return (Criteria) this;
        }

        public Criteria andLivingsquareGreaterThan(BigDecimal value) {
            addCriterion("LIVINGSQUARE >", value, "livingsquare");
            return (Criteria) this;
        }

        public Criteria andLivingsquareGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LIVINGSQUARE >=", value, "livingsquare");
            return (Criteria) this;
        }

        public Criteria andLivingsquareLessThan(BigDecimal value) {
            addCriterion("LIVINGSQUARE <", value, "livingsquare");
            return (Criteria) this;
        }

        public Criteria andLivingsquareLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LIVINGSQUARE <=", value, "livingsquare");
            return (Criteria) this;
        }

        public Criteria andLivingsquareIn(List<BigDecimal> values) {
            addCriterion("LIVINGSQUARE in", values, "livingsquare");
            return (Criteria) this;
        }

        public Criteria andLivingsquareNotIn(List<BigDecimal> values) {
            addCriterion("LIVINGSQUARE not in", values, "livingsquare");
            return (Criteria) this;
        }

        public Criteria andLivingsquareBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LIVINGSQUARE between", value1, value2, "livingsquare");
            return (Criteria) this;
        }

        public Criteria andLivingsquareNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LIVINGSQUARE not between", value1, value2, "livingsquare");
            return (Criteria) this;
        }

        public Criteria andPropertyIsNull() {
            addCriterion("PROPERTY is null");
            return (Criteria) this;
        }

        public Criteria andPropertyIsNotNull() {
            addCriterion("PROPERTY is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyEqualTo(String value) {
            addCriterion("PROPERTY =", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotEqualTo(String value) {
            addCriterion("PROPERTY <>", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyGreaterThan(String value) {
            addCriterion("PROPERTY >", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyGreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY >=", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyLessThan(String value) {
            addCriterion("PROPERTY <", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyLessThanOrEqualTo(String value) {
            addCriterion("PROPERTY <=", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyLike(String value) {
            addCriterion("PROPERTY like", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotLike(String value) {
            addCriterion("PROPERTY not like", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyIn(List<String> values) {
            addCriterion("PROPERTY in", values, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotIn(List<String> values) {
            addCriterion("PROPERTY not in", values, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyBetween(String value1, String value2) {
            addCriterion("PROPERTY between", value1, value2, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotBetween(String value1, String value2) {
            addCriterion("PROPERTY not between", value1, value2, "property");
            return (Criteria) this;
        }

        public Criteria andDecoratelevelIsNull() {
            addCriterion("DECORATELEVEL is null");
            return (Criteria) this;
        }

        public Criteria andDecoratelevelIsNotNull() {
            addCriterion("DECORATELEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andDecoratelevelEqualTo(String value) {
            addCriterion("DECORATELEVEL =", value, "decoratelevel");
            return (Criteria) this;
        }

        public Criteria andDecoratelevelNotEqualTo(String value) {
            addCriterion("DECORATELEVEL <>", value, "decoratelevel");
            return (Criteria) this;
        }

        public Criteria andDecoratelevelGreaterThan(String value) {
            addCriterion("DECORATELEVEL >", value, "decoratelevel");
            return (Criteria) this;
        }

        public Criteria andDecoratelevelGreaterThanOrEqualTo(String value) {
            addCriterion("DECORATELEVEL >=", value, "decoratelevel");
            return (Criteria) this;
        }

        public Criteria andDecoratelevelLessThan(String value) {
            addCriterion("DECORATELEVEL <", value, "decoratelevel");
            return (Criteria) this;
        }

        public Criteria andDecoratelevelLessThanOrEqualTo(String value) {
            addCriterion("DECORATELEVEL <=", value, "decoratelevel");
            return (Criteria) this;
        }

        public Criteria andDecoratelevelLike(String value) {
            addCriterion("DECORATELEVEL like", value, "decoratelevel");
            return (Criteria) this;
        }

        public Criteria andDecoratelevelNotLike(String value) {
            addCriterion("DECORATELEVEL not like", value, "decoratelevel");
            return (Criteria) this;
        }

        public Criteria andDecoratelevelIn(List<String> values) {
            addCriterion("DECORATELEVEL in", values, "decoratelevel");
            return (Criteria) this;
        }

        public Criteria andDecoratelevelNotIn(List<String> values) {
            addCriterion("DECORATELEVEL not in", values, "decoratelevel");
            return (Criteria) this;
        }

        public Criteria andDecoratelevelBetween(String value1, String value2) {
            addCriterion("DECORATELEVEL between", value1, value2, "decoratelevel");
            return (Criteria) this;
        }

        public Criteria andDecoratelevelNotBetween(String value1, String value2) {
            addCriterion("DECORATELEVEL not between", value1, value2, "decoratelevel");
            return (Criteria) this;
        }

        public Criteria andFloorplantypeIsNull() {
            addCriterion("FLOORPLANTYPE is null");
            return (Criteria) this;
        }

        public Criteria andFloorplantypeIsNotNull() {
            addCriterion("FLOORPLANTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFloorplantypeEqualTo(String value) {
            addCriterion("FLOORPLANTYPE =", value, "floorplantype");
            return (Criteria) this;
        }

        public Criteria andFloorplantypeNotEqualTo(String value) {
            addCriterion("FLOORPLANTYPE <>", value, "floorplantype");
            return (Criteria) this;
        }

        public Criteria andFloorplantypeGreaterThan(String value) {
            addCriterion("FLOORPLANTYPE >", value, "floorplantype");
            return (Criteria) this;
        }

        public Criteria andFloorplantypeGreaterThanOrEqualTo(String value) {
            addCriterion("FLOORPLANTYPE >=", value, "floorplantype");
            return (Criteria) this;
        }

        public Criteria andFloorplantypeLessThan(String value) {
            addCriterion("FLOORPLANTYPE <", value, "floorplantype");
            return (Criteria) this;
        }

        public Criteria andFloorplantypeLessThanOrEqualTo(String value) {
            addCriterion("FLOORPLANTYPE <=", value, "floorplantype");
            return (Criteria) this;
        }

        public Criteria andFloorplantypeLike(String value) {
            addCriterion("FLOORPLANTYPE like", value, "floorplantype");
            return (Criteria) this;
        }

        public Criteria andFloorplantypeNotLike(String value) {
            addCriterion("FLOORPLANTYPE not like", value, "floorplantype");
            return (Criteria) this;
        }

        public Criteria andFloorplantypeIn(List<String> values) {
            addCriterion("FLOORPLANTYPE in", values, "floorplantype");
            return (Criteria) this;
        }

        public Criteria andFloorplantypeNotIn(List<String> values) {
            addCriterion("FLOORPLANTYPE not in", values, "floorplantype");
            return (Criteria) this;
        }

        public Criteria andFloorplantypeBetween(String value1, String value2) {
            addCriterion("FLOORPLANTYPE between", value1, value2, "floorplantype");
            return (Criteria) this;
        }

        public Criteria andFloorplantypeNotBetween(String value1, String value2) {
            addCriterion("FLOORPLANTYPE not between", value1, value2, "floorplantype");
            return (Criteria) this;
        }

        public Criteria andRoomcountIsNull() {
            addCriterion("ROOMCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andRoomcountIsNotNull() {
            addCriterion("ROOMCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andRoomcountEqualTo(Short value) {
            addCriterion("ROOMCOUNT =", value, "roomcount");
            return (Criteria) this;
        }

        public Criteria andRoomcountNotEqualTo(Short value) {
            addCriterion("ROOMCOUNT <>", value, "roomcount");
            return (Criteria) this;
        }

        public Criteria andRoomcountGreaterThan(Short value) {
            addCriterion("ROOMCOUNT >", value, "roomcount");
            return (Criteria) this;
        }

        public Criteria andRoomcountGreaterThanOrEqualTo(Short value) {
            addCriterion("ROOMCOUNT >=", value, "roomcount");
            return (Criteria) this;
        }

        public Criteria andRoomcountLessThan(Short value) {
            addCriterion("ROOMCOUNT <", value, "roomcount");
            return (Criteria) this;
        }

        public Criteria andRoomcountLessThanOrEqualTo(Short value) {
            addCriterion("ROOMCOUNT <=", value, "roomcount");
            return (Criteria) this;
        }

        public Criteria andRoomcountIn(List<Short> values) {
            addCriterion("ROOMCOUNT in", values, "roomcount");
            return (Criteria) this;
        }

        public Criteria andRoomcountNotIn(List<Short> values) {
            addCriterion("ROOMCOUNT not in", values, "roomcount");
            return (Criteria) this;
        }

        public Criteria andRoomcountBetween(Short value1, Short value2) {
            addCriterion("ROOMCOUNT between", value1, value2, "roomcount");
            return (Criteria) this;
        }

        public Criteria andRoomcountNotBetween(Short value1, Short value2) {
            addCriterion("ROOMCOUNT not between", value1, value2, "roomcount");
            return (Criteria) this;
        }

        public Criteria andLoungecountIsNull() {
            addCriterion("LOUNGECOUNT is null");
            return (Criteria) this;
        }

        public Criteria andLoungecountIsNotNull() {
            addCriterion("LOUNGECOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andLoungecountEqualTo(Short value) {
            addCriterion("LOUNGECOUNT =", value, "loungecount");
            return (Criteria) this;
        }

        public Criteria andLoungecountNotEqualTo(Short value) {
            addCriterion("LOUNGECOUNT <>", value, "loungecount");
            return (Criteria) this;
        }

        public Criteria andLoungecountGreaterThan(Short value) {
            addCriterion("LOUNGECOUNT >", value, "loungecount");
            return (Criteria) this;
        }

        public Criteria andLoungecountGreaterThanOrEqualTo(Short value) {
            addCriterion("LOUNGECOUNT >=", value, "loungecount");
            return (Criteria) this;
        }

        public Criteria andLoungecountLessThan(Short value) {
            addCriterion("LOUNGECOUNT <", value, "loungecount");
            return (Criteria) this;
        }

        public Criteria andLoungecountLessThanOrEqualTo(Short value) {
            addCriterion("LOUNGECOUNT <=", value, "loungecount");
            return (Criteria) this;
        }

        public Criteria andLoungecountIn(List<Short> values) {
            addCriterion("LOUNGECOUNT in", values, "loungecount");
            return (Criteria) this;
        }

        public Criteria andLoungecountNotIn(List<Short> values) {
            addCriterion("LOUNGECOUNT not in", values, "loungecount");
            return (Criteria) this;
        }

        public Criteria andLoungecountBetween(Short value1, Short value2) {
            addCriterion("LOUNGECOUNT between", value1, value2, "loungecount");
            return (Criteria) this;
        }

        public Criteria andLoungecountNotBetween(Short value1, Short value2) {
            addCriterion("LOUNGECOUNT not between", value1, value2, "loungecount");
            return (Criteria) this;
        }

        public Criteria andBathroomcountIsNull() {
            addCriterion("BATHROOMCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andBathroomcountIsNotNull() {
            addCriterion("BATHROOMCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andBathroomcountEqualTo(Short value) {
            addCriterion("BATHROOMCOUNT =", value, "bathroomcount");
            return (Criteria) this;
        }

        public Criteria andBathroomcountNotEqualTo(Short value) {
            addCriterion("BATHROOMCOUNT <>", value, "bathroomcount");
            return (Criteria) this;
        }

        public Criteria andBathroomcountGreaterThan(Short value) {
            addCriterion("BATHROOMCOUNT >", value, "bathroomcount");
            return (Criteria) this;
        }

        public Criteria andBathroomcountGreaterThanOrEqualTo(Short value) {
            addCriterion("BATHROOMCOUNT >=", value, "bathroomcount");
            return (Criteria) this;
        }

        public Criteria andBathroomcountLessThan(Short value) {
            addCriterion("BATHROOMCOUNT <", value, "bathroomcount");
            return (Criteria) this;
        }

        public Criteria andBathroomcountLessThanOrEqualTo(Short value) {
            addCriterion("BATHROOMCOUNT <=", value, "bathroomcount");
            return (Criteria) this;
        }

        public Criteria andBathroomcountIn(List<Short> values) {
            addCriterion("BATHROOMCOUNT in", values, "bathroomcount");
            return (Criteria) this;
        }

        public Criteria andBathroomcountNotIn(List<Short> values) {
            addCriterion("BATHROOMCOUNT not in", values, "bathroomcount");
            return (Criteria) this;
        }

        public Criteria andBathroomcountBetween(Short value1, Short value2) {
            addCriterion("BATHROOMCOUNT between", value1, value2, "bathroomcount");
            return (Criteria) this;
        }

        public Criteria andBathroomcountNotBetween(Short value1, Short value2) {
            addCriterion("BATHROOMCOUNT not between", value1, value2, "bathroomcount");
            return (Criteria) this;
        }

        public Criteria andKitchencountIsNull() {
            addCriterion("KITCHENCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andKitchencountIsNotNull() {
            addCriterion("KITCHENCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andKitchencountEqualTo(Short value) {
            addCriterion("KITCHENCOUNT =", value, "kitchencount");
            return (Criteria) this;
        }

        public Criteria andKitchencountNotEqualTo(Short value) {
            addCriterion("KITCHENCOUNT <>", value, "kitchencount");
            return (Criteria) this;
        }

        public Criteria andKitchencountGreaterThan(Short value) {
            addCriterion("KITCHENCOUNT >", value, "kitchencount");
            return (Criteria) this;
        }

        public Criteria andKitchencountGreaterThanOrEqualTo(Short value) {
            addCriterion("KITCHENCOUNT >=", value, "kitchencount");
            return (Criteria) this;
        }

        public Criteria andKitchencountLessThan(Short value) {
            addCriterion("KITCHENCOUNT <", value, "kitchencount");
            return (Criteria) this;
        }

        public Criteria andKitchencountLessThanOrEqualTo(Short value) {
            addCriterion("KITCHENCOUNT <=", value, "kitchencount");
            return (Criteria) this;
        }

        public Criteria andKitchencountIn(List<Short> values) {
            addCriterion("KITCHENCOUNT in", values, "kitchencount");
            return (Criteria) this;
        }

        public Criteria andKitchencountNotIn(List<Short> values) {
            addCriterion("KITCHENCOUNT not in", values, "kitchencount");
            return (Criteria) this;
        }

        public Criteria andKitchencountBetween(Short value1, Short value2) {
            addCriterion("KITCHENCOUNT between", value1, value2, "kitchencount");
            return (Criteria) this;
        }

        public Criteria andKitchencountNotBetween(Short value1, Short value2) {
            addCriterion("KITCHENCOUNT not between", value1, value2, "kitchencount");
            return (Criteria) this;
        }

        public Criteria andBalconycountIsNull() {
            addCriterion("BALCONYCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andBalconycountIsNotNull() {
            addCriterion("BALCONYCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andBalconycountEqualTo(Short value) {
            addCriterion("BALCONYCOUNT =", value, "balconycount");
            return (Criteria) this;
        }

        public Criteria andBalconycountNotEqualTo(Short value) {
            addCriterion("BALCONYCOUNT <>", value, "balconycount");
            return (Criteria) this;
        }

        public Criteria andBalconycountGreaterThan(Short value) {
            addCriterion("BALCONYCOUNT >", value, "balconycount");
            return (Criteria) this;
        }

        public Criteria andBalconycountGreaterThanOrEqualTo(Short value) {
            addCriterion("BALCONYCOUNT >=", value, "balconycount");
            return (Criteria) this;
        }

        public Criteria andBalconycountLessThan(Short value) {
            addCriterion("BALCONYCOUNT <", value, "balconycount");
            return (Criteria) this;
        }

        public Criteria andBalconycountLessThanOrEqualTo(Short value) {
            addCriterion("BALCONYCOUNT <=", value, "balconycount");
            return (Criteria) this;
        }

        public Criteria andBalconycountIn(List<Short> values) {
            addCriterion("BALCONYCOUNT in", values, "balconycount");
            return (Criteria) this;
        }

        public Criteria andBalconycountNotIn(List<Short> values) {
            addCriterion("BALCONYCOUNT not in", values, "balconycount");
            return (Criteria) this;
        }

        public Criteria andBalconycountBetween(Short value1, Short value2) {
            addCriterion("BALCONYCOUNT between", value1, value2, "balconycount");
            return (Criteria) this;
        }

        public Criteria andBalconycountNotBetween(Short value1, Short value2) {
            addCriterion("BALCONYCOUNT not between", value1, value2, "balconycount");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("LONGITUDE is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("LONGITUDE is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(BigDecimal value) {
            addCriterion("LONGITUDE =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(BigDecimal value) {
            addCriterion("LONGITUDE <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(BigDecimal value) {
            addCriterion("LONGITUDE >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LONGITUDE >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(BigDecimal value) {
            addCriterion("LONGITUDE <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LONGITUDE <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<BigDecimal> values) {
            addCriterion("LONGITUDE in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<BigDecimal> values) {
            addCriterion("LONGITUDE not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LONGITUDE between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LONGITUDE not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("LATITUDE is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("LATITUDE is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(BigDecimal value) {
            addCriterion("LATITUDE =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(BigDecimal value) {
            addCriterion("LATITUDE <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(BigDecimal value) {
            addCriterion("LATITUDE >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LATITUDE >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(BigDecimal value) {
            addCriterion("LATITUDE <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LATITUDE <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<BigDecimal> values) {
            addCriterion("LATITUDE in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<BigDecimal> values) {
            addCriterion("LATITUDE not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LATITUDE between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LATITUDE not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andIfliftIsNull() {
            addCriterion("IFLIFT is null");
            return (Criteria) this;
        }

        public Criteria andIfliftIsNotNull() {
            addCriterion("IFLIFT is not null");
            return (Criteria) this;
        }

        public Criteria andIfliftEqualTo(String value) {
            addCriterion("IFLIFT =", value, "iflift");
            return (Criteria) this;
        }

        public Criteria andIfliftNotEqualTo(String value) {
            addCriterion("IFLIFT <>", value, "iflift");
            return (Criteria) this;
        }

        public Criteria andIfliftGreaterThan(String value) {
            addCriterion("IFLIFT >", value, "iflift");
            return (Criteria) this;
        }

        public Criteria andIfliftGreaterThanOrEqualTo(String value) {
            addCriterion("IFLIFT >=", value, "iflift");
            return (Criteria) this;
        }

        public Criteria andIfliftLessThan(String value) {
            addCriterion("IFLIFT <", value, "iflift");
            return (Criteria) this;
        }

        public Criteria andIfliftLessThanOrEqualTo(String value) {
            addCriterion("IFLIFT <=", value, "iflift");
            return (Criteria) this;
        }

        public Criteria andIfliftLike(String value) {
            addCriterion("IFLIFT like", value, "iflift");
            return (Criteria) this;
        }

        public Criteria andIfliftNotLike(String value) {
            addCriterion("IFLIFT not like", value, "iflift");
            return (Criteria) this;
        }

        public Criteria andIfliftIn(List<String> values) {
            addCriterion("IFLIFT in", values, "iflift");
            return (Criteria) this;
        }

        public Criteria andIfliftNotIn(List<String> values) {
            addCriterion("IFLIFT not in", values, "iflift");
            return (Criteria) this;
        }

        public Criteria andIfliftBetween(String value1, String value2) {
            addCriterion("IFLIFT between", value1, value2, "iflift");
            return (Criteria) this;
        }

        public Criteria andIfliftNotBetween(String value1, String value2) {
            addCriterion("IFLIFT not between", value1, value2, "iflift");
            return (Criteria) this;
        }

        public Criteria andCommunitytypeIsNull() {
            addCriterion("COMMUNITYTYPE is null");
            return (Criteria) this;
        }

        public Criteria andCommunitytypeIsNotNull() {
            addCriterion("COMMUNITYTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCommunitytypeEqualTo(String value) {
            addCriterion("COMMUNITYTYPE =", value, "communitytype");
            return (Criteria) this;
        }

        public Criteria andCommunitytypeNotEqualTo(String value) {
            addCriterion("COMMUNITYTYPE <>", value, "communitytype");
            return (Criteria) this;
        }

        public Criteria andCommunitytypeGreaterThan(String value) {
            addCriterion("COMMUNITYTYPE >", value, "communitytype");
            return (Criteria) this;
        }

        public Criteria andCommunitytypeGreaterThanOrEqualTo(String value) {
            addCriterion("COMMUNITYTYPE >=", value, "communitytype");
            return (Criteria) this;
        }

        public Criteria andCommunitytypeLessThan(String value) {
            addCriterion("COMMUNITYTYPE <", value, "communitytype");
            return (Criteria) this;
        }

        public Criteria andCommunitytypeLessThanOrEqualTo(String value) {
            addCriterion("COMMUNITYTYPE <=", value, "communitytype");
            return (Criteria) this;
        }

        public Criteria andCommunitytypeLike(String value) {
            addCriterion("COMMUNITYTYPE like", value, "communitytype");
            return (Criteria) this;
        }

        public Criteria andCommunitytypeNotLike(String value) {
            addCriterion("COMMUNITYTYPE not like", value, "communitytype");
            return (Criteria) this;
        }

        public Criteria andCommunitytypeIn(List<String> values) {
            addCriterion("COMMUNITYTYPE in", values, "communitytype");
            return (Criteria) this;
        }

        public Criteria andCommunitytypeNotIn(List<String> values) {
            addCriterion("COMMUNITYTYPE not in", values, "communitytype");
            return (Criteria) this;
        }

        public Criteria andCommunitytypeBetween(String value1, String value2) {
            addCriterion("COMMUNITYTYPE between", value1, value2, "communitytype");
            return (Criteria) this;
        }

        public Criteria andCommunitytypeNotBetween(String value1, String value2) {
            addCriterion("COMMUNITYTYPE not between", value1, value2, "communitytype");
            return (Criteria) this;
        }

        public Criteria andBuildingtypeIsNull() {
            addCriterion("BUILDINGTYPE is null");
            return (Criteria) this;
        }

        public Criteria andBuildingtypeIsNotNull() {
            addCriterion("BUILDINGTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingtypeEqualTo(String value) {
            addCriterion("BUILDINGTYPE =", value, "buildingtype");
            return (Criteria) this;
        }

        public Criteria andBuildingtypeNotEqualTo(String value) {
            addCriterion("BUILDINGTYPE <>", value, "buildingtype");
            return (Criteria) this;
        }

        public Criteria andBuildingtypeGreaterThan(String value) {
            addCriterion("BUILDINGTYPE >", value, "buildingtype");
            return (Criteria) this;
        }

        public Criteria andBuildingtypeGreaterThanOrEqualTo(String value) {
            addCriterion("BUILDINGTYPE >=", value, "buildingtype");
            return (Criteria) this;
        }

        public Criteria andBuildingtypeLessThan(String value) {
            addCriterion("BUILDINGTYPE <", value, "buildingtype");
            return (Criteria) this;
        }

        public Criteria andBuildingtypeLessThanOrEqualTo(String value) {
            addCriterion("BUILDINGTYPE <=", value, "buildingtype");
            return (Criteria) this;
        }

        public Criteria andBuildingtypeLike(String value) {
            addCriterion("BUILDINGTYPE like", value, "buildingtype");
            return (Criteria) this;
        }

        public Criteria andBuildingtypeNotLike(String value) {
            addCriterion("BUILDINGTYPE not like", value, "buildingtype");
            return (Criteria) this;
        }

        public Criteria andBuildingtypeIn(List<String> values) {
            addCriterion("BUILDINGTYPE in", values, "buildingtype");
            return (Criteria) this;
        }

        public Criteria andBuildingtypeNotIn(List<String> values) {
            addCriterion("BUILDINGTYPE not in", values, "buildingtype");
            return (Criteria) this;
        }

        public Criteria andBuildingtypeBetween(String value1, String value2) {
            addCriterion("BUILDINGTYPE between", value1, value2, "buildingtype");
            return (Criteria) this;
        }

        public Criteria andBuildingtypeNotBetween(String value1, String value2) {
            addCriterion("BUILDINGTYPE not between", value1, value2, "buildingtype");
            return (Criteria) this;
        }

        public Criteria andCreatedDtIsNull() {
            addCriterion("CREATED_DT is null");
            return (Criteria) this;
        }

        public Criteria andCreatedDtIsNotNull() {
            addCriterion("CREATED_DT is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedDtEqualTo(Date value) {
            addCriterionForJDBCDate("CREATED_DT =", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtNotEqualTo(Date value) {
            addCriterionForJDBCDate("CREATED_DT <>", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtGreaterThan(Date value) {
            addCriterionForJDBCDate("CREATED_DT >", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATED_DT >=", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtLessThan(Date value) {
            addCriterionForJDBCDate("CREATED_DT <", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATED_DT <=", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtIn(List<Date> values) {
            addCriterionForJDBCDate("CREATED_DT in", values, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtNotIn(List<Date> values) {
            addCriterionForJDBCDate("CREATED_DT not in", values, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATED_DT between", value1, value2, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATED_DT not between", value1, value2, "createdDt");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andDealPersonIsNull() {
            addCriterion("DEAL_PERSON is null");
            return (Criteria) this;
        }

        public Criteria andDealPersonIsNotNull() {
            addCriterion("DEAL_PERSON is not null");
            return (Criteria) this;
        }

        public Criteria andDealPersonEqualTo(String value) {
            addCriterion("DEAL_PERSON =", value, "dealPerson");
            return (Criteria) this;
        }

        public Criteria andDealPersonNotEqualTo(String value) {
            addCriterion("DEAL_PERSON <>", value, "dealPerson");
            return (Criteria) this;
        }

        public Criteria andDealPersonGreaterThan(String value) {
            addCriterion("DEAL_PERSON >", value, "dealPerson");
            return (Criteria) this;
        }

        public Criteria andDealPersonGreaterThanOrEqualTo(String value) {
            addCriterion("DEAL_PERSON >=", value, "dealPerson");
            return (Criteria) this;
        }

        public Criteria andDealPersonLessThan(String value) {
            addCriterion("DEAL_PERSON <", value, "dealPerson");
            return (Criteria) this;
        }

        public Criteria andDealPersonLessThanOrEqualTo(String value) {
            addCriterion("DEAL_PERSON <=", value, "dealPerson");
            return (Criteria) this;
        }

        public Criteria andDealPersonLike(String value) {
            addCriterion("DEAL_PERSON like", value, "dealPerson");
            return (Criteria) this;
        }

        public Criteria andDealPersonNotLike(String value) {
            addCriterion("DEAL_PERSON not like", value, "dealPerson");
            return (Criteria) this;
        }

        public Criteria andDealPersonIn(List<String> values) {
            addCriterion("DEAL_PERSON in", values, "dealPerson");
            return (Criteria) this;
        }

        public Criteria andDealPersonNotIn(List<String> values) {
            addCriterion("DEAL_PERSON not in", values, "dealPerson");
            return (Criteria) this;
        }

        public Criteria andDealPersonBetween(String value1, String value2) {
            addCriterion("DEAL_PERSON between", value1, value2, "dealPerson");
            return (Criteria) this;
        }

        public Criteria andDealPersonNotBetween(String value1, String value2) {
            addCriterion("DEAL_PERSON not between", value1, value2, "dealPerson");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("UPDATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("UPDATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_DATE =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_DATE <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("UPDATE_DATE >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_DATE >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterionForJDBCDate("UPDATE_DATE <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_DATE <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterionForJDBCDate("UPDATE_DATE in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("UPDATE_DATE not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPDATE_DATE between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPDATE_DATE not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andParkingNumIsNull() {
            addCriterion("PARKING_NUM is null");
            return (Criteria) this;
        }

        public Criteria andParkingNumIsNotNull() {
            addCriterion("PARKING_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andParkingNumEqualTo(Integer value) {
            addCriterion("PARKING_NUM =", value, "parkingNum");
            return (Criteria) this;
        }

        public Criteria andParkingNumNotEqualTo(Integer value) {
            addCriterion("PARKING_NUM <>", value, "parkingNum");
            return (Criteria) this;
        }

        public Criteria andParkingNumGreaterThan(Integer value) {
            addCriterion("PARKING_NUM >", value, "parkingNum");
            return (Criteria) this;
        }

        public Criteria andParkingNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("PARKING_NUM >=", value, "parkingNum");
            return (Criteria) this;
        }

        public Criteria andParkingNumLessThan(Integer value) {
            addCriterion("PARKING_NUM <", value, "parkingNum");
            return (Criteria) this;
        }

        public Criteria andParkingNumLessThanOrEqualTo(Integer value) {
            addCriterion("PARKING_NUM <=", value, "parkingNum");
            return (Criteria) this;
        }

        public Criteria andParkingNumIn(List<Integer> values) {
            addCriterion("PARKING_NUM in", values, "parkingNum");
            return (Criteria) this;
        }

        public Criteria andParkingNumNotIn(List<Integer> values) {
            addCriterion("PARKING_NUM not in", values, "parkingNum");
            return (Criteria) this;
        }

        public Criteria andParkingNumBetween(Integer value1, Integer value2) {
            addCriterion("PARKING_NUM between", value1, value2, "parkingNum");
            return (Criteria) this;
        }

        public Criteria andParkingNumNotBetween(Integer value1, Integer value2) {
            addCriterion("PARKING_NUM not between", value1, value2, "parkingNum");
            return (Criteria) this;
        }

        public Criteria andTotalhouseholdcountIsNull() {
            addCriterion("TOTALHOUSEHOLDCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andTotalhouseholdcountIsNotNull() {
            addCriterion("TOTALHOUSEHOLDCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andTotalhouseholdcountEqualTo(Integer value) {
            addCriterion("TOTALHOUSEHOLDCOUNT =", value, "totalhouseholdcount");
            return (Criteria) this;
        }

        public Criteria andTotalhouseholdcountNotEqualTo(Integer value) {
            addCriterion("TOTALHOUSEHOLDCOUNT <>", value, "totalhouseholdcount");
            return (Criteria) this;
        }

        public Criteria andTotalhouseholdcountGreaterThan(Integer value) {
            addCriterion("TOTALHOUSEHOLDCOUNT >", value, "totalhouseholdcount");
            return (Criteria) this;
        }

        public Criteria andTotalhouseholdcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("TOTALHOUSEHOLDCOUNT >=", value, "totalhouseholdcount");
            return (Criteria) this;
        }

        public Criteria andTotalhouseholdcountLessThan(Integer value) {
            addCriterion("TOTALHOUSEHOLDCOUNT <", value, "totalhouseholdcount");
            return (Criteria) this;
        }

        public Criteria andTotalhouseholdcountLessThanOrEqualTo(Integer value) {
            addCriterion("TOTALHOUSEHOLDCOUNT <=", value, "totalhouseholdcount");
            return (Criteria) this;
        }

        public Criteria andTotalhouseholdcountIn(List<Integer> values) {
            addCriterion("TOTALHOUSEHOLDCOUNT in", values, "totalhouseholdcount");
            return (Criteria) this;
        }

        public Criteria andTotalhouseholdcountNotIn(List<Integer> values) {
            addCriterion("TOTALHOUSEHOLDCOUNT not in", values, "totalhouseholdcount");
            return (Criteria) this;
        }

        public Criteria andTotalhouseholdcountBetween(Integer value1, Integer value2) {
            addCriterion("TOTALHOUSEHOLDCOUNT between", value1, value2, "totalhouseholdcount");
            return (Criteria) this;
        }

        public Criteria andTotalhouseholdcountNotBetween(Integer value1, Integer value2) {
            addCriterion("TOTALHOUSEHOLDCOUNT not between", value1, value2, "totalhouseholdcount");
            return (Criteria) this;
        }

        public Criteria andCommunitydescriptionIsNull() {
            addCriterion("COMMUNITYDESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andCommunitydescriptionIsNotNull() {
            addCriterion("COMMUNITYDESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andCommunitydescriptionEqualTo(String value) {
            addCriterion("COMMUNITYDESCRIPTION =", value, "communitydescription");
            return (Criteria) this;
        }

        public Criteria andCommunitydescriptionNotEqualTo(String value) {
            addCriterion("COMMUNITYDESCRIPTION <>", value, "communitydescription");
            return (Criteria) this;
        }

        public Criteria andCommunitydescriptionGreaterThan(String value) {
            addCriterion("COMMUNITYDESCRIPTION >", value, "communitydescription");
            return (Criteria) this;
        }

        public Criteria andCommunitydescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("COMMUNITYDESCRIPTION >=", value, "communitydescription");
            return (Criteria) this;
        }

        public Criteria andCommunitydescriptionLessThan(String value) {
            addCriterion("COMMUNITYDESCRIPTION <", value, "communitydescription");
            return (Criteria) this;
        }

        public Criteria andCommunitydescriptionLessThanOrEqualTo(String value) {
            addCriterion("COMMUNITYDESCRIPTION <=", value, "communitydescription");
            return (Criteria) this;
        }

        public Criteria andCommunitydescriptionLike(String value) {
            addCriterion("COMMUNITYDESCRIPTION like", value, "communitydescription");
            return (Criteria) this;
        }

        public Criteria andCommunitydescriptionNotLike(String value) {
            addCriterion("COMMUNITYDESCRIPTION not like", value, "communitydescription");
            return (Criteria) this;
        }

        public Criteria andCommunitydescriptionIn(List<String> values) {
            addCriterion("COMMUNITYDESCRIPTION in", values, "communitydescription");
            return (Criteria) this;
        }

        public Criteria andCommunitydescriptionNotIn(List<String> values) {
            addCriterion("COMMUNITYDESCRIPTION not in", values, "communitydescription");
            return (Criteria) this;
        }

        public Criteria andCommunitydescriptionBetween(String value1, String value2) {
            addCriterion("COMMUNITYDESCRIPTION between", value1, value2, "communitydescription");
            return (Criteria) this;
        }

        public Criteria andCommunitydescriptionNotBetween(String value1, String value2) {
            addCriterion("COMMUNITYDESCRIPTION not between", value1, value2, "communitydescription");
            return (Criteria) this;
        }

        public Criteria andBuildingareaIsNull() {
            addCriterion("BUILDINGAREA is null");
            return (Criteria) this;
        }

        public Criteria andBuildingareaIsNotNull() {
            addCriterion("BUILDINGAREA is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingareaEqualTo(Integer value) {
            addCriterion("BUILDINGAREA =", value, "buildingarea");
            return (Criteria) this;
        }

        public Criteria andBuildingareaNotEqualTo(Integer value) {
            addCriterion("BUILDINGAREA <>", value, "buildingarea");
            return (Criteria) this;
        }

        public Criteria andBuildingareaGreaterThan(Integer value) {
            addCriterion("BUILDINGAREA >", value, "buildingarea");
            return (Criteria) this;
        }

        public Criteria andBuildingareaGreaterThanOrEqualTo(Integer value) {
            addCriterion("BUILDINGAREA >=", value, "buildingarea");
            return (Criteria) this;
        }

        public Criteria andBuildingareaLessThan(Integer value) {
            addCriterion("BUILDINGAREA <", value, "buildingarea");
            return (Criteria) this;
        }

        public Criteria andBuildingareaLessThanOrEqualTo(Integer value) {
            addCriterion("BUILDINGAREA <=", value, "buildingarea");
            return (Criteria) this;
        }

        public Criteria andBuildingareaIn(List<Integer> values) {
            addCriterion("BUILDINGAREA in", values, "buildingarea");
            return (Criteria) this;
        }

        public Criteria andBuildingareaNotIn(List<Integer> values) {
            addCriterion("BUILDINGAREA not in", values, "buildingarea");
            return (Criteria) this;
        }

        public Criteria andBuildingareaBetween(Integer value1, Integer value2) {
            addCriterion("BUILDINGAREA between", value1, value2, "buildingarea");
            return (Criteria) this;
        }

        public Criteria andBuildingareaNotBetween(Integer value1, Integer value2) {
            addCriterion("BUILDINGAREA not between", value1, value2, "buildingarea");
            return (Criteria) this;
        }

        public Criteria andLivingyearIsNull() {
            addCriterion("LIVINGYEAR is null");
            return (Criteria) this;
        }

        public Criteria andLivingyearIsNotNull() {
            addCriterion("LIVINGYEAR is not null");
            return (Criteria) this;
        }

        public Criteria andLivingyearEqualTo(Integer value) {
            addCriterion("LIVINGYEAR =", value, "livingyear");
            return (Criteria) this;
        }

        public Criteria andLivingyearNotEqualTo(Integer value) {
            addCriterion("LIVINGYEAR <>", value, "livingyear");
            return (Criteria) this;
        }

        public Criteria andLivingyearGreaterThan(Integer value) {
            addCriterion("LIVINGYEAR >", value, "livingyear");
            return (Criteria) this;
        }

        public Criteria andLivingyearGreaterThanOrEqualTo(Integer value) {
            addCriterion("LIVINGYEAR >=", value, "livingyear");
            return (Criteria) this;
        }

        public Criteria andLivingyearLessThan(Integer value) {
            addCriterion("LIVINGYEAR <", value, "livingyear");
            return (Criteria) this;
        }

        public Criteria andLivingyearLessThanOrEqualTo(Integer value) {
            addCriterion("LIVINGYEAR <=", value, "livingyear");
            return (Criteria) this;
        }

        public Criteria andLivingyearIn(List<Integer> values) {
            addCriterion("LIVINGYEAR in", values, "livingyear");
            return (Criteria) this;
        }

        public Criteria andLivingyearNotIn(List<Integer> values) {
            addCriterion("LIVINGYEAR not in", values, "livingyear");
            return (Criteria) this;
        }

        public Criteria andLivingyearBetween(Integer value1, Integer value2) {
            addCriterion("LIVINGYEAR between", value1, value2, "livingyear");
            return (Criteria) this;
        }

        public Criteria andLivingyearNotBetween(Integer value1, Integer value2) {
            addCriterion("LIVINGYEAR not between", value1, value2, "livingyear");
            return (Criteria) this;
        }

        public Criteria andUpfloorIsNull() {
            addCriterion("UPFLOOR is null");
            return (Criteria) this;
        }

        public Criteria andUpfloorIsNotNull() {
            addCriterion("UPFLOOR is not null");
            return (Criteria) this;
        }

        public Criteria andUpfloorEqualTo(Integer value) {
            addCriterion("UPFLOOR =", value, "upfloor");
            return (Criteria) this;
        }

        public Criteria andUpfloorNotEqualTo(Integer value) {
            addCriterion("UPFLOOR <>", value, "upfloor");
            return (Criteria) this;
        }

        public Criteria andUpfloorGreaterThan(Integer value) {
            addCriterion("UPFLOOR >", value, "upfloor");
            return (Criteria) this;
        }

        public Criteria andUpfloorGreaterThanOrEqualTo(Integer value) {
            addCriterion("UPFLOOR >=", value, "upfloor");
            return (Criteria) this;
        }

        public Criteria andUpfloorLessThan(Integer value) {
            addCriterion("UPFLOOR <", value, "upfloor");
            return (Criteria) this;
        }

        public Criteria andUpfloorLessThanOrEqualTo(Integer value) {
            addCriterion("UPFLOOR <=", value, "upfloor");
            return (Criteria) this;
        }

        public Criteria andUpfloorIn(List<Integer> values) {
            addCriterion("UPFLOOR in", values, "upfloor");
            return (Criteria) this;
        }

        public Criteria andUpfloorNotIn(List<Integer> values) {
            addCriterion("UPFLOOR not in", values, "upfloor");
            return (Criteria) this;
        }

        public Criteria andUpfloorBetween(Integer value1, Integer value2) {
            addCriterion("UPFLOOR between", value1, value2, "upfloor");
            return (Criteria) this;
        }

        public Criteria andUpfloorNotBetween(Integer value1, Integer value2) {
            addCriterion("UPFLOOR not between", value1, value2, "upfloor");
            return (Criteria) this;
        }

        public Criteria andGardenareaIsNull() {
            addCriterion("GARDENAREA is null");
            return (Criteria) this;
        }

        public Criteria andGardenareaIsNotNull() {
            addCriterion("GARDENAREA is not null");
            return (Criteria) this;
        }

        public Criteria andGardenareaEqualTo(Integer value) {
            addCriterion("GARDENAREA =", value, "gardenarea");
            return (Criteria) this;
        }

        public Criteria andGardenareaNotEqualTo(Integer value) {
            addCriterion("GARDENAREA <>", value, "gardenarea");
            return (Criteria) this;
        }

        public Criteria andGardenareaGreaterThan(Integer value) {
            addCriterion("GARDENAREA >", value, "gardenarea");
            return (Criteria) this;
        }

        public Criteria andGardenareaGreaterThanOrEqualTo(Integer value) {
            addCriterion("GARDENAREA >=", value, "gardenarea");
            return (Criteria) this;
        }

        public Criteria andGardenareaLessThan(Integer value) {
            addCriterion("GARDENAREA <", value, "gardenarea");
            return (Criteria) this;
        }

        public Criteria andGardenareaLessThanOrEqualTo(Integer value) {
            addCriterion("GARDENAREA <=", value, "gardenarea");
            return (Criteria) this;
        }

        public Criteria andGardenareaIn(List<Integer> values) {
            addCriterion("GARDENAREA in", values, "gardenarea");
            return (Criteria) this;
        }

        public Criteria andGardenareaNotIn(List<Integer> values) {
            addCriterion("GARDENAREA not in", values, "gardenarea");
            return (Criteria) this;
        }

        public Criteria andGardenareaBetween(Integer value1, Integer value2) {
            addCriterion("GARDENAREA between", value1, value2, "gardenarea");
            return (Criteria) this;
        }

        public Criteria andGardenareaNotBetween(Integer value1, Integer value2) {
            addCriterion("GARDENAREA not between", value1, value2, "gardenarea");
            return (Criteria) this;
        }

        public Criteria andUnderareaIsNull() {
            addCriterion("UNDERAREA is null");
            return (Criteria) this;
        }

        public Criteria andUnderareaIsNotNull() {
            addCriterion("UNDERAREA is not null");
            return (Criteria) this;
        }

        public Criteria andUnderareaEqualTo(Integer value) {
            addCriterion("UNDERAREA =", value, "underarea");
            return (Criteria) this;
        }

        public Criteria andUnderareaNotEqualTo(Integer value) {
            addCriterion("UNDERAREA <>", value, "underarea");
            return (Criteria) this;
        }

        public Criteria andUnderareaGreaterThan(Integer value) {
            addCriterion("UNDERAREA >", value, "underarea");
            return (Criteria) this;
        }

        public Criteria andUnderareaGreaterThanOrEqualTo(Integer value) {
            addCriterion("UNDERAREA >=", value, "underarea");
            return (Criteria) this;
        }

        public Criteria andUnderareaLessThan(Integer value) {
            addCriterion("UNDERAREA <", value, "underarea");
            return (Criteria) this;
        }

        public Criteria andUnderareaLessThanOrEqualTo(Integer value) {
            addCriterion("UNDERAREA <=", value, "underarea");
            return (Criteria) this;
        }

        public Criteria andUnderareaIn(List<Integer> values) {
            addCriterion("UNDERAREA in", values, "underarea");
            return (Criteria) this;
        }

        public Criteria andUnderareaNotIn(List<Integer> values) {
            addCriterion("UNDERAREA not in", values, "underarea");
            return (Criteria) this;
        }

        public Criteria andUnderareaBetween(Integer value1, Integer value2) {
            addCriterion("UNDERAREA between", value1, value2, "underarea");
            return (Criteria) this;
        }

        public Criteria andUnderareaNotBetween(Integer value1, Integer value2) {
            addCriterion("UNDERAREA not between", value1, value2, "underarea");
            return (Criteria) this;
        }

        public Criteria andGaragenumIsNull() {
            addCriterion("GARAGENUM is null");
            return (Criteria) this;
        }

        public Criteria andGaragenumIsNotNull() {
            addCriterion("GARAGENUM is not null");
            return (Criteria) this;
        }

        public Criteria andGaragenumEqualTo(Integer value) {
            addCriterion("GARAGENUM =", value, "garagenum");
            return (Criteria) this;
        }

        public Criteria andGaragenumNotEqualTo(Integer value) {
            addCriterion("GARAGENUM <>", value, "garagenum");
            return (Criteria) this;
        }

        public Criteria andGaragenumGreaterThan(Integer value) {
            addCriterion("GARAGENUM >", value, "garagenum");
            return (Criteria) this;
        }

        public Criteria andGaragenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("GARAGENUM >=", value, "garagenum");
            return (Criteria) this;
        }

        public Criteria andGaragenumLessThan(Integer value) {
            addCriterion("GARAGENUM <", value, "garagenum");
            return (Criteria) this;
        }

        public Criteria andGaragenumLessThanOrEqualTo(Integer value) {
            addCriterion("GARAGENUM <=", value, "garagenum");
            return (Criteria) this;
        }

        public Criteria andGaragenumIn(List<Integer> values) {
            addCriterion("GARAGENUM in", values, "garagenum");
            return (Criteria) this;
        }

        public Criteria andGaragenumNotIn(List<Integer> values) {
            addCriterion("GARAGENUM not in", values, "garagenum");
            return (Criteria) this;
        }

        public Criteria andGaragenumBetween(Integer value1, Integer value2) {
            addCriterion("GARAGENUM between", value1, value2, "garagenum");
            return (Criteria) this;
        }

        public Criteria andGaragenumNotBetween(Integer value1, Integer value2) {
            addCriterion("GARAGENUM not between", value1, value2, "garagenum");
            return (Criteria) this;
        }

        public Criteria andOccupancyIsNull() {
            addCriterion("OCCUPANCY is null");
            return (Criteria) this;
        }

        public Criteria andOccupancyIsNotNull() {
            addCriterion("OCCUPANCY is not null");
            return (Criteria) this;
        }

        public Criteria andOccupancyEqualTo(Integer value) {
            addCriterion("OCCUPANCY =", value, "occupancy");
            return (Criteria) this;
        }

        public Criteria andOccupancyNotEqualTo(Integer value) {
            addCriterion("OCCUPANCY <>", value, "occupancy");
            return (Criteria) this;
        }

        public Criteria andOccupancyGreaterThan(Integer value) {
            addCriterion("OCCUPANCY >", value, "occupancy");
            return (Criteria) this;
        }

        public Criteria andOccupancyGreaterThanOrEqualTo(Integer value) {
            addCriterion("OCCUPANCY >=", value, "occupancy");
            return (Criteria) this;
        }

        public Criteria andOccupancyLessThan(Integer value) {
            addCriterion("OCCUPANCY <", value, "occupancy");
            return (Criteria) this;
        }

        public Criteria andOccupancyLessThanOrEqualTo(Integer value) {
            addCriterion("OCCUPANCY <=", value, "occupancy");
            return (Criteria) this;
        }

        public Criteria andOccupancyIn(List<Integer> values) {
            addCriterion("OCCUPANCY in", values, "occupancy");
            return (Criteria) this;
        }

        public Criteria andOccupancyNotIn(List<Integer> values) {
            addCriterion("OCCUPANCY not in", values, "occupancy");
            return (Criteria) this;
        }

        public Criteria andOccupancyBetween(Integer value1, Integer value2) {
            addCriterion("OCCUPANCY between", value1, value2, "occupancy");
            return (Criteria) this;
        }

        public Criteria andOccupancyNotBetween(Integer value1, Integer value2) {
            addCriterion("OCCUPANCY not between", value1, value2, "occupancy");
            return (Criteria) this;
        }

        public Criteria andPmfeeIsNull() {
            addCriterion("PMFEE is null");
            return (Criteria) this;
        }

        public Criteria andPmfeeIsNotNull() {
            addCriterion("PMFEE is not null");
            return (Criteria) this;
        }

        public Criteria andPmfeeEqualTo(Integer value) {
            addCriterion("PMFEE =", value, "pmfee");
            return (Criteria) this;
        }

        public Criteria andPmfeeNotEqualTo(Integer value) {
            addCriterion("PMFEE <>", value, "pmfee");
            return (Criteria) this;
        }

        public Criteria andPmfeeGreaterThan(Integer value) {
            addCriterion("PMFEE >", value, "pmfee");
            return (Criteria) this;
        }

        public Criteria andPmfeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("PMFEE >=", value, "pmfee");
            return (Criteria) this;
        }

        public Criteria andPmfeeLessThan(Integer value) {
            addCriterion("PMFEE <", value, "pmfee");
            return (Criteria) this;
        }

        public Criteria andPmfeeLessThanOrEqualTo(Integer value) {
            addCriterion("PMFEE <=", value, "pmfee");
            return (Criteria) this;
        }

        public Criteria andPmfeeIn(List<Integer> values) {
            addCriterion("PMFEE in", values, "pmfee");
            return (Criteria) this;
        }

        public Criteria andPmfeeNotIn(List<Integer> values) {
            addCriterion("PMFEE not in", values, "pmfee");
            return (Criteria) this;
        }

        public Criteria andPmfeeBetween(Integer value1, Integer value2) {
            addCriterion("PMFEE between", value1, value2, "pmfee");
            return (Criteria) this;
        }

        public Criteria andPmfeeNotBetween(Integer value1, Integer value2) {
            addCriterion("PMFEE not between", value1, value2, "pmfee");
            return (Criteria) this;
        }

        public Criteria andGreeningrateIsNull() {
            addCriterion("GREENINGRATE is null");
            return (Criteria) this;
        }

        public Criteria andGreeningrateIsNotNull() {
            addCriterion("GREENINGRATE is not null");
            return (Criteria) this;
        }

        public Criteria andGreeningrateEqualTo(Integer value) {
            addCriterion("GREENINGRATE =", value, "greeningrate");
            return (Criteria) this;
        }

        public Criteria andGreeningrateNotEqualTo(Integer value) {
            addCriterion("GREENINGRATE <>", value, "greeningrate");
            return (Criteria) this;
        }

        public Criteria andGreeningrateGreaterThan(Integer value) {
            addCriterion("GREENINGRATE >", value, "greeningrate");
            return (Criteria) this;
        }

        public Criteria andGreeningrateGreaterThanOrEqualTo(Integer value) {
            addCriterion("GREENINGRATE >=", value, "greeningrate");
            return (Criteria) this;
        }

        public Criteria andGreeningrateLessThan(Integer value) {
            addCriterion("GREENINGRATE <", value, "greeningrate");
            return (Criteria) this;
        }

        public Criteria andGreeningrateLessThanOrEqualTo(Integer value) {
            addCriterion("GREENINGRATE <=", value, "greeningrate");
            return (Criteria) this;
        }

        public Criteria andGreeningrateIn(List<Integer> values) {
            addCriterion("GREENINGRATE in", values, "greeningrate");
            return (Criteria) this;
        }

        public Criteria andGreeningrateNotIn(List<Integer> values) {
            addCriterion("GREENINGRATE not in", values, "greeningrate");
            return (Criteria) this;
        }

        public Criteria andGreeningrateBetween(Integer value1, Integer value2) {
            addCriterion("GREENINGRATE between", value1, value2, "greeningrate");
            return (Criteria) this;
        }

        public Criteria andGreeningrateNotBetween(Integer value1, Integer value2) {
            addCriterion("GREENINGRATE not between", value1, value2, "greeningrate");
            return (Criteria) this;
        }

        public Criteria andPlotratioIsNull() {
            addCriterion("PLOTRATIO is null");
            return (Criteria) this;
        }

        public Criteria andPlotratioIsNotNull() {
            addCriterion("PLOTRATIO is not null");
            return (Criteria) this;
        }

        public Criteria andPlotratioEqualTo(Integer value) {
            addCriterion("PLOTRATIO =", value, "plotratio");
            return (Criteria) this;
        }

        public Criteria andPlotratioNotEqualTo(Integer value) {
            addCriterion("PLOTRATIO <>", value, "plotratio");
            return (Criteria) this;
        }

        public Criteria andPlotratioGreaterThan(Integer value) {
            addCriterion("PLOTRATIO >", value, "plotratio");
            return (Criteria) this;
        }

        public Criteria andPlotratioGreaterThanOrEqualTo(Integer value) {
            addCriterion("PLOTRATIO >=", value, "plotratio");
            return (Criteria) this;
        }

        public Criteria andPlotratioLessThan(Integer value) {
            addCriterion("PLOTRATIO <", value, "plotratio");
            return (Criteria) this;
        }

        public Criteria andPlotratioLessThanOrEqualTo(Integer value) {
            addCriterion("PLOTRATIO <=", value, "plotratio");
            return (Criteria) this;
        }

        public Criteria andPlotratioIn(List<Integer> values) {
            addCriterion("PLOTRATIO in", values, "plotratio");
            return (Criteria) this;
        }

        public Criteria andPlotratioNotIn(List<Integer> values) {
            addCriterion("PLOTRATIO not in", values, "plotratio");
            return (Criteria) this;
        }

        public Criteria andPlotratioBetween(Integer value1, Integer value2) {
            addCriterion("PLOTRATIO between", value1, value2, "plotratio");
            return (Criteria) this;
        }

        public Criteria andPlotratioNotBetween(Integer value1, Integer value2) {
            addCriterion("PLOTRATIO not between", value1, value2, "plotratio");
            return (Criteria) this;
        }

        public Criteria andRoomTypeImgIsNull() {
            addCriterion("ROOM_TYPE_IMG is null");
            return (Criteria) this;
        }

        public Criteria andRoomTypeImgIsNotNull() {
            addCriterion("ROOM_TYPE_IMG is not null");
            return (Criteria) this;
        }

        public Criteria andRoomTypeImgEqualTo(String value) {
            addCriterion("ROOM_TYPE_IMG =", value, "roomTypeImg");
            return (Criteria) this;
        }

        public Criteria andRoomTypeImgNotEqualTo(String value) {
            addCriterion("ROOM_TYPE_IMG <>", value, "roomTypeImg");
            return (Criteria) this;
        }

        public Criteria andRoomTypeImgGreaterThan(String value) {
            addCriterion("ROOM_TYPE_IMG >", value, "roomTypeImg");
            return (Criteria) this;
        }

        public Criteria andRoomTypeImgGreaterThanOrEqualTo(String value) {
            addCriterion("ROOM_TYPE_IMG >=", value, "roomTypeImg");
            return (Criteria) this;
        }

        public Criteria andRoomTypeImgLessThan(String value) {
            addCriterion("ROOM_TYPE_IMG <", value, "roomTypeImg");
            return (Criteria) this;
        }

        public Criteria andRoomTypeImgLessThanOrEqualTo(String value) {
            addCriterion("ROOM_TYPE_IMG <=", value, "roomTypeImg");
            return (Criteria) this;
        }

        public Criteria andRoomTypeImgLike(String value) {
            addCriterion("ROOM_TYPE_IMG like", value, "roomTypeImg");
            return (Criteria) this;
        }

        public Criteria andRoomTypeImgNotLike(String value) {
            addCriterion("ROOM_TYPE_IMG not like", value, "roomTypeImg");
            return (Criteria) this;
        }

        public Criteria andRoomTypeImgIn(List<String> values) {
            addCriterion("ROOM_TYPE_IMG in", values, "roomTypeImg");
            return (Criteria) this;
        }

        public Criteria andRoomTypeImgNotIn(List<String> values) {
            addCriterion("ROOM_TYPE_IMG not in", values, "roomTypeImg");
            return (Criteria) this;
        }

        public Criteria andRoomTypeImgBetween(String value1, String value2) {
            addCriterion("ROOM_TYPE_IMG between", value1, value2, "roomTypeImg");
            return (Criteria) this;
        }

        public Criteria andRoomTypeImgNotBetween(String value1, String value2) {
            addCriterion("ROOM_TYPE_IMG not between", value1, value2, "roomTypeImg");
            return (Criteria) this;
        }

        public Criteria andAssessSalePriceIsNull() {
            addCriterion("ASSESS_SALE_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andAssessSalePriceIsNotNull() {
            addCriterion("ASSESS_SALE_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andAssessSalePriceEqualTo(BigDecimal value) {
            addCriterion("ASSESS_SALE_PRICE =", value, "assessSalePrice");
            return (Criteria) this;
        }

        public Criteria andAssessSalePriceNotEqualTo(BigDecimal value) {
            addCriterion("ASSESS_SALE_PRICE <>", value, "assessSalePrice");
            return (Criteria) this;
        }

        public Criteria andAssessSalePriceGreaterThan(BigDecimal value) {
            addCriterion("ASSESS_SALE_PRICE >", value, "assessSalePrice");
            return (Criteria) this;
        }

        public Criteria andAssessSalePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ASSESS_SALE_PRICE >=", value, "assessSalePrice");
            return (Criteria) this;
        }

        public Criteria andAssessSalePriceLessThan(BigDecimal value) {
            addCriterion("ASSESS_SALE_PRICE <", value, "assessSalePrice");
            return (Criteria) this;
        }

        public Criteria andAssessSalePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ASSESS_SALE_PRICE <=", value, "assessSalePrice");
            return (Criteria) this;
        }

        public Criteria andAssessSalePriceIn(List<BigDecimal> values) {
            addCriterion("ASSESS_SALE_PRICE in", values, "assessSalePrice");
            return (Criteria) this;
        }

        public Criteria andAssessSalePriceNotIn(List<BigDecimal> values) {
            addCriterion("ASSESS_SALE_PRICE not in", values, "assessSalePrice");
            return (Criteria) this;
        }

        public Criteria andAssessSalePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ASSESS_SALE_PRICE between", value1, value2, "assessSalePrice");
            return (Criteria) this;
        }

        public Criteria andAssessSalePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ASSESS_SALE_PRICE not between", value1, value2, "assessSalePrice");
            return (Criteria) this;
        }

        public Criteria andAssessRentPriceIsNull() {
            addCriterion("ASSESS_RENT_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andAssessRentPriceIsNotNull() {
            addCriterion("ASSESS_RENT_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andAssessRentPriceEqualTo(BigDecimal value) {
            addCriterion("ASSESS_RENT_PRICE =", value, "assessRentPrice");
            return (Criteria) this;
        }

        public Criteria andAssessRentPriceNotEqualTo(BigDecimal value) {
            addCriterion("ASSESS_RENT_PRICE <>", value, "assessRentPrice");
            return (Criteria) this;
        }

        public Criteria andAssessRentPriceGreaterThan(BigDecimal value) {
            addCriterion("ASSESS_RENT_PRICE >", value, "assessRentPrice");
            return (Criteria) this;
        }

        public Criteria andAssessRentPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ASSESS_RENT_PRICE >=", value, "assessRentPrice");
            return (Criteria) this;
        }

        public Criteria andAssessRentPriceLessThan(BigDecimal value) {
            addCriterion("ASSESS_RENT_PRICE <", value, "assessRentPrice");
            return (Criteria) this;
        }

        public Criteria andAssessRentPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ASSESS_RENT_PRICE <=", value, "assessRentPrice");
            return (Criteria) this;
        }

        public Criteria andAssessRentPriceIn(List<BigDecimal> values) {
            addCriterion("ASSESS_RENT_PRICE in", values, "assessRentPrice");
            return (Criteria) this;
        }

        public Criteria andAssessRentPriceNotIn(List<BigDecimal> values) {
            addCriterion("ASSESS_RENT_PRICE not in", values, "assessRentPrice");
            return (Criteria) this;
        }

        public Criteria andAssessRentPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ASSESS_RENT_PRICE between", value1, value2, "assessRentPrice");
            return (Criteria) this;
        }

        public Criteria andAssessRentPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ASSESS_RENT_PRICE not between", value1, value2, "assessRentPrice");
            return (Criteria) this;
        }

        public Criteria andAssessTimeIsNull() {
            addCriterion("ASSESS_TIME is null");
            return (Criteria) this;
        }

        public Criteria andAssessTimeIsNotNull() {
            addCriterion("ASSESS_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andAssessTimeEqualTo(Date value) {
            addCriterionForJDBCDate("ASSESS_TIME =", value, "assessTime");
            return (Criteria) this;
        }

        public Criteria andAssessTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("ASSESS_TIME <>", value, "assessTime");
            return (Criteria) this;
        }

        public Criteria andAssessTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("ASSESS_TIME >", value, "assessTime");
            return (Criteria) this;
        }

        public Criteria andAssessTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ASSESS_TIME >=", value, "assessTime");
            return (Criteria) this;
        }

        public Criteria andAssessTimeLessThan(Date value) {
            addCriterionForJDBCDate("ASSESS_TIME <", value, "assessTime");
            return (Criteria) this;
        }

        public Criteria andAssessTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ASSESS_TIME <=", value, "assessTime");
            return (Criteria) this;
        }

        public Criteria andAssessTimeIn(List<Date> values) {
            addCriterionForJDBCDate("ASSESS_TIME in", values, "assessTime");
            return (Criteria) this;
        }

        public Criteria andAssessTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("ASSESS_TIME not in", values, "assessTime");
            return (Criteria) this;
        }

        public Criteria andAssessTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ASSESS_TIME between", value1, value2, "assessTime");
            return (Criteria) this;
        }

        public Criteria andAssessTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ASSESS_TIME not between", value1, value2, "assessTime");
            return (Criteria) this;
        }

        public Criteria andMaxSalePriceIsNull() {
            addCriterion("MAX_SALE_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andMaxSalePriceIsNotNull() {
            addCriterion("MAX_SALE_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andMaxSalePriceEqualTo(BigDecimal value) {
            addCriterion("MAX_SALE_PRICE =", value, "maxSalePrice");
            return (Criteria) this;
        }

        public Criteria andMaxSalePriceNotEqualTo(BigDecimal value) {
            addCriterion("MAX_SALE_PRICE <>", value, "maxSalePrice");
            return (Criteria) this;
        }

        public Criteria andMaxSalePriceGreaterThan(BigDecimal value) {
            addCriterion("MAX_SALE_PRICE >", value, "maxSalePrice");
            return (Criteria) this;
        }

        public Criteria andMaxSalePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MAX_SALE_PRICE >=", value, "maxSalePrice");
            return (Criteria) this;
        }

        public Criteria andMaxSalePriceLessThan(BigDecimal value) {
            addCriterion("MAX_SALE_PRICE <", value, "maxSalePrice");
            return (Criteria) this;
        }

        public Criteria andMaxSalePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MAX_SALE_PRICE <=", value, "maxSalePrice");
            return (Criteria) this;
        }

        public Criteria andMaxSalePriceIn(List<BigDecimal> values) {
            addCriterion("MAX_SALE_PRICE in", values, "maxSalePrice");
            return (Criteria) this;
        }

        public Criteria andMaxSalePriceNotIn(List<BigDecimal> values) {
            addCriterion("MAX_SALE_PRICE not in", values, "maxSalePrice");
            return (Criteria) this;
        }

        public Criteria andMaxSalePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MAX_SALE_PRICE between", value1, value2, "maxSalePrice");
            return (Criteria) this;
        }

        public Criteria andMaxSalePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MAX_SALE_PRICE not between", value1, value2, "maxSalePrice");
            return (Criteria) this;
        }

        public Criteria andMinSalePriceIsNull() {
            addCriterion("MIN_SALE_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andMinSalePriceIsNotNull() {
            addCriterion("MIN_SALE_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andMinSalePriceEqualTo(BigDecimal value) {
            addCriterion("MIN_SALE_PRICE =", value, "minSalePrice");
            return (Criteria) this;
        }

        public Criteria andMinSalePriceNotEqualTo(BigDecimal value) {
            addCriterion("MIN_SALE_PRICE <>", value, "minSalePrice");
            return (Criteria) this;
        }

        public Criteria andMinSalePriceGreaterThan(BigDecimal value) {
            addCriterion("MIN_SALE_PRICE >", value, "minSalePrice");
            return (Criteria) this;
        }

        public Criteria andMinSalePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MIN_SALE_PRICE >=", value, "minSalePrice");
            return (Criteria) this;
        }

        public Criteria andMinSalePriceLessThan(BigDecimal value) {
            addCriterion("MIN_SALE_PRICE <", value, "minSalePrice");
            return (Criteria) this;
        }

        public Criteria andMinSalePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MIN_SALE_PRICE <=", value, "minSalePrice");
            return (Criteria) this;
        }

        public Criteria andMinSalePriceIn(List<BigDecimal> values) {
            addCriterion("MIN_SALE_PRICE in", values, "minSalePrice");
            return (Criteria) this;
        }

        public Criteria andMinSalePriceNotIn(List<BigDecimal> values) {
            addCriterion("MIN_SALE_PRICE not in", values, "minSalePrice");
            return (Criteria) this;
        }

        public Criteria andMinSalePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MIN_SALE_PRICE between", value1, value2, "minSalePrice");
            return (Criteria) this;
        }

        public Criteria andMinSalePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MIN_SALE_PRICE not between", value1, value2, "minSalePrice");
            return (Criteria) this;
        }

        public Criteria andMaxRentPriceIsNull() {
            addCriterion("MAX_RENT_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andMaxRentPriceIsNotNull() {
            addCriterion("MAX_RENT_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andMaxRentPriceEqualTo(BigDecimal value) {
            addCriterion("MAX_RENT_PRICE =", value, "maxRentPrice");
            return (Criteria) this;
        }

        public Criteria andMaxRentPriceNotEqualTo(BigDecimal value) {
            addCriterion("MAX_RENT_PRICE <>", value, "maxRentPrice");
            return (Criteria) this;
        }

        public Criteria andMaxRentPriceGreaterThan(BigDecimal value) {
            addCriterion("MAX_RENT_PRICE >", value, "maxRentPrice");
            return (Criteria) this;
        }

        public Criteria andMaxRentPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MAX_RENT_PRICE >=", value, "maxRentPrice");
            return (Criteria) this;
        }

        public Criteria andMaxRentPriceLessThan(BigDecimal value) {
            addCriterion("MAX_RENT_PRICE <", value, "maxRentPrice");
            return (Criteria) this;
        }

        public Criteria andMaxRentPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MAX_RENT_PRICE <=", value, "maxRentPrice");
            return (Criteria) this;
        }

        public Criteria andMaxRentPriceIn(List<BigDecimal> values) {
            addCriterion("MAX_RENT_PRICE in", values, "maxRentPrice");
            return (Criteria) this;
        }

        public Criteria andMaxRentPriceNotIn(List<BigDecimal> values) {
            addCriterion("MAX_RENT_PRICE not in", values, "maxRentPrice");
            return (Criteria) this;
        }

        public Criteria andMaxRentPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MAX_RENT_PRICE between", value1, value2, "maxRentPrice");
            return (Criteria) this;
        }

        public Criteria andMaxRentPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MAX_RENT_PRICE not between", value1, value2, "maxRentPrice");
            return (Criteria) this;
        }

        public Criteria andMinRentPriceIsNull() {
            addCriterion("MIN_RENT_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andMinRentPriceIsNotNull() {
            addCriterion("MIN_RENT_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andMinRentPriceEqualTo(BigDecimal value) {
            addCriterion("MIN_RENT_PRICE =", value, "minRentPrice");
            return (Criteria) this;
        }

        public Criteria andMinRentPriceNotEqualTo(BigDecimal value) {
            addCriterion("MIN_RENT_PRICE <>", value, "minRentPrice");
            return (Criteria) this;
        }

        public Criteria andMinRentPriceGreaterThan(BigDecimal value) {
            addCriterion("MIN_RENT_PRICE >", value, "minRentPrice");
            return (Criteria) this;
        }

        public Criteria andMinRentPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MIN_RENT_PRICE >=", value, "minRentPrice");
            return (Criteria) this;
        }

        public Criteria andMinRentPriceLessThan(BigDecimal value) {
            addCriterion("MIN_RENT_PRICE <", value, "minRentPrice");
            return (Criteria) this;
        }

        public Criteria andMinRentPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MIN_RENT_PRICE <=", value, "minRentPrice");
            return (Criteria) this;
        }

        public Criteria andMinRentPriceIn(List<BigDecimal> values) {
            addCriterion("MIN_RENT_PRICE in", values, "minRentPrice");
            return (Criteria) this;
        }

        public Criteria andMinRentPriceNotIn(List<BigDecimal> values) {
            addCriterion("MIN_RENT_PRICE not in", values, "minRentPrice");
            return (Criteria) this;
        }

        public Criteria andMinRentPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MIN_RENT_PRICE between", value1, value2, "minRentPrice");
            return (Criteria) this;
        }

        public Criteria andMinRentPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MIN_RENT_PRICE not between", value1, value2, "minRentPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceIsNull() {
            addCriterion("BUY_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andBuyPriceIsNotNull() {
            addCriterion("BUY_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andBuyPriceEqualTo(BigDecimal value) {
            addCriterion("BUY_PRICE =", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceNotEqualTo(BigDecimal value) {
            addCriterion("BUY_PRICE <>", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceGreaterThan(BigDecimal value) {
            addCriterion("BUY_PRICE >", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BUY_PRICE >=", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceLessThan(BigDecimal value) {
            addCriterion("BUY_PRICE <", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BUY_PRICE <=", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceIn(List<BigDecimal> values) {
            addCriterion("BUY_PRICE in", values, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceNotIn(List<BigDecimal> values) {
            addCriterion("BUY_PRICE not in", values, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUY_PRICE between", value1, value2, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUY_PRICE not between", value1, value2, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyTimeIsNull() {
            addCriterion("BUY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andBuyTimeIsNotNull() {
            addCriterion("BUY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andBuyTimeEqualTo(Date value) {
            addCriterionForJDBCDate("BUY_TIME =", value, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("BUY_TIME <>", value, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("BUY_TIME >", value, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BUY_TIME >=", value, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeLessThan(Date value) {
            addCriterionForJDBCDate("BUY_TIME <", value, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BUY_TIME <=", value, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeIn(List<Date> values) {
            addCriterionForJDBCDate("BUY_TIME in", values, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("BUY_TIME not in", values, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BUY_TIME between", value1, value2, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BUY_TIME not between", value1, value2, "buyTime");
            return (Criteria) this;
        }

        public Criteria andReserve1IsNull() {
            addCriterion("RESERVE1 is null");
            return (Criteria) this;
        }

        public Criteria andReserve1IsNotNull() {
            addCriterion("RESERVE1 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve1EqualTo(String value) {
            addCriterion("RESERVE1 =", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1NotEqualTo(String value) {
            addCriterion("RESERVE1 <>", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1GreaterThan(String value) {
            addCriterion("RESERVE1 >", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1GreaterThanOrEqualTo(String value) {
            addCriterion("RESERVE1 >=", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1LessThan(String value) {
            addCriterion("RESERVE1 <", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1LessThanOrEqualTo(String value) {
            addCriterion("RESERVE1 <=", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1Like(String value) {
            addCriterion("RESERVE1 like", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1NotLike(String value) {
            addCriterion("RESERVE1 not like", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1In(List<String> values) {
            addCriterion("RESERVE1 in", values, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1NotIn(List<String> values) {
            addCriterion("RESERVE1 not in", values, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1Between(String value1, String value2) {
            addCriterion("RESERVE1 between", value1, value2, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1NotBetween(String value1, String value2) {
            addCriterion("RESERVE1 not between", value1, value2, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve2IsNull() {
            addCriterion("RESERVE2 is null");
            return (Criteria) this;
        }

        public Criteria andReserve2IsNotNull() {
            addCriterion("RESERVE2 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve2EqualTo(String value) {
            addCriterion("RESERVE2 =", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2NotEqualTo(String value) {
            addCriterion("RESERVE2 <>", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2GreaterThan(String value) {
            addCriterion("RESERVE2 >", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2GreaterThanOrEqualTo(String value) {
            addCriterion("RESERVE2 >=", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2LessThan(String value) {
            addCriterion("RESERVE2 <", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2LessThanOrEqualTo(String value) {
            addCriterion("RESERVE2 <=", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2Like(String value) {
            addCriterion("RESERVE2 like", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2NotLike(String value) {
            addCriterion("RESERVE2 not like", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2In(List<String> values) {
            addCriterion("RESERVE2 in", values, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2NotIn(List<String> values) {
            addCriterion("RESERVE2 not in", values, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2Between(String value1, String value2) {
            addCriterion("RESERVE2 between", value1, value2, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2NotBetween(String value1, String value2) {
            addCriterion("RESERVE2 not between", value1, value2, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve3IsNull() {
            addCriterion("RESERVE3 is null");
            return (Criteria) this;
        }

        public Criteria andReserve3IsNotNull() {
            addCriterion("RESERVE3 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve3EqualTo(String value) {
            addCriterion("RESERVE3 =", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3NotEqualTo(String value) {
            addCriterion("RESERVE3 <>", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3GreaterThan(String value) {
            addCriterion("RESERVE3 >", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3GreaterThanOrEqualTo(String value) {
            addCriterion("RESERVE3 >=", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3LessThan(String value) {
            addCriterion("RESERVE3 <", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3LessThanOrEqualTo(String value) {
            addCriterion("RESERVE3 <=", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3Like(String value) {
            addCriterion("RESERVE3 like", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3NotLike(String value) {
            addCriterion("RESERVE3 not like", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3In(List<String> values) {
            addCriterion("RESERVE3 in", values, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3NotIn(List<String> values) {
            addCriterion("RESERVE3 not in", values, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3Between(String value1, String value2) {
            addCriterion("RESERVE3 between", value1, value2, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3NotBetween(String value1, String value2) {
            addCriterion("RESERVE3 not between", value1, value2, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve4IsNull() {
            addCriterion("RESERVE4 is null");
            return (Criteria) this;
        }

        public Criteria andReserve4IsNotNull() {
            addCriterion("RESERVE4 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve4EqualTo(String value) {
            addCriterion("RESERVE4 =", value, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4NotEqualTo(String value) {
            addCriterion("RESERVE4 <>", value, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4GreaterThan(String value) {
            addCriterion("RESERVE4 >", value, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4GreaterThanOrEqualTo(String value) {
            addCriterion("RESERVE4 >=", value, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4LessThan(String value) {
            addCriterion("RESERVE4 <", value, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4LessThanOrEqualTo(String value) {
            addCriterion("RESERVE4 <=", value, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4Like(String value) {
            addCriterion("RESERVE4 like", value, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4NotLike(String value) {
            addCriterion("RESERVE4 not like", value, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4In(List<String> values) {
            addCriterion("RESERVE4 in", values, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4NotIn(List<String> values) {
            addCriterion("RESERVE4 not in", values, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4Between(String value1, String value2) {
            addCriterion("RESERVE4 between", value1, value2, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve4NotBetween(String value1, String value2) {
            addCriterion("RESERVE4 not between", value1, value2, "reserve4");
            return (Criteria) this;
        }

        public Criteria andReserve5IsNull() {
            addCriterion("RESERVE5 is null");
            return (Criteria) this;
        }

        public Criteria andReserve5IsNotNull() {
            addCriterion("RESERVE5 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve5EqualTo(String value) {
            addCriterion("RESERVE5 =", value, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5NotEqualTo(String value) {
            addCriterion("RESERVE5 <>", value, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5GreaterThan(String value) {
            addCriterion("RESERVE5 >", value, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5GreaterThanOrEqualTo(String value) {
            addCriterion("RESERVE5 >=", value, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5LessThan(String value) {
            addCriterion("RESERVE5 <", value, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5LessThanOrEqualTo(String value) {
            addCriterion("RESERVE5 <=", value, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5Like(String value) {
            addCriterion("RESERVE5 like", value, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5NotLike(String value) {
            addCriterion("RESERVE5 not like", value, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5In(List<String> values) {
            addCriterion("RESERVE5 in", values, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5NotIn(List<String> values) {
            addCriterion("RESERVE5 not in", values, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5Between(String value1, String value2) {
            addCriterion("RESERVE5 between", value1, value2, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve5NotBetween(String value1, String value2) {
            addCriterion("RESERVE5 not between", value1, value2, "reserve5");
            return (Criteria) this;
        }

        public Criteria andReserve6IsNull() {
            addCriterion("RESERVE6 is null");
            return (Criteria) this;
        }

        public Criteria andReserve6IsNotNull() {
            addCriterion("RESERVE6 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve6EqualTo(String value) {
            addCriterion("RESERVE6 =", value, "reserve6");
            return (Criteria) this;
        }

        public Criteria andReserve6NotEqualTo(String value) {
            addCriterion("RESERVE6 <>", value, "reserve6");
            return (Criteria) this;
        }

        public Criteria andReserve6GreaterThan(String value) {
            addCriterion("RESERVE6 >", value, "reserve6");
            return (Criteria) this;
        }

        public Criteria andReserve6GreaterThanOrEqualTo(String value) {
            addCriterion("RESERVE6 >=", value, "reserve6");
            return (Criteria) this;
        }

        public Criteria andReserve6LessThan(String value) {
            addCriterion("RESERVE6 <", value, "reserve6");
            return (Criteria) this;
        }

        public Criteria andReserve6LessThanOrEqualTo(String value) {
            addCriterion("RESERVE6 <=", value, "reserve6");
            return (Criteria) this;
        }

        public Criteria andReserve6Like(String value) {
            addCriterion("RESERVE6 like", value, "reserve6");
            return (Criteria) this;
        }

        public Criteria andReserve6NotLike(String value) {
            addCriterion("RESERVE6 not like", value, "reserve6");
            return (Criteria) this;
        }

        public Criteria andReserve6In(List<String> values) {
            addCriterion("RESERVE6 in", values, "reserve6");
            return (Criteria) this;
        }

        public Criteria andReserve6NotIn(List<String> values) {
            addCriterion("RESERVE6 not in", values, "reserve6");
            return (Criteria) this;
        }

        public Criteria andReserve6Between(String value1, String value2) {
            addCriterion("RESERVE6 between", value1, value2, "reserve6");
            return (Criteria) this;
        }

        public Criteria andReserve6NotBetween(String value1, String value2) {
            addCriterion("RESERVE6 not between", value1, value2, "reserve6");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("USER_ID like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("USER_ID not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andIssaleIsNull() {
            addCriterion("ISSALE is null");
            return (Criteria) this;
        }

        public Criteria andIssaleIsNotNull() {
            addCriterion("ISSALE is not null");
            return (Criteria) this;
        }

        public Criteria andIssaleEqualTo(BigDecimal value) {
            addCriterion("ISSALE =", value, "issale");
            return (Criteria) this;
        }

        public Criteria andIssaleNotEqualTo(BigDecimal value) {
            addCriterion("ISSALE <>", value, "issale");
            return (Criteria) this;
        }

        public Criteria andIssaleGreaterThan(BigDecimal value) {
            addCriterion("ISSALE >", value, "issale");
            return (Criteria) this;
        }

        public Criteria andIssaleGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ISSALE >=", value, "issale");
            return (Criteria) this;
        }

        public Criteria andIssaleLessThan(BigDecimal value) {
            addCriterion("ISSALE <", value, "issale");
            return (Criteria) this;
        }

        public Criteria andIssaleLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ISSALE <=", value, "issale");
            return (Criteria) this;
        }

        public Criteria andIssaleIn(List<BigDecimal> values) {
            addCriterion("ISSALE in", values, "issale");
            return (Criteria) this;
        }

        public Criteria andIssaleNotIn(List<BigDecimal> values) {
            addCriterion("ISSALE not in", values, "issale");
            return (Criteria) this;
        }

        public Criteria andIssaleBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ISSALE between", value1, value2, "issale");
            return (Criteria) this;
        }

        public Criteria andIssaleNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ISSALE not between", value1, value2, "issale");
            return (Criteria) this;
        }

        public Criteria andIsrentIsNull() {
            addCriterion("ISRENT is null");
            return (Criteria) this;
        }

        public Criteria andIsrentIsNotNull() {
            addCriterion("ISRENT is not null");
            return (Criteria) this;
        }

        public Criteria andIsrentEqualTo(BigDecimal value) {
            addCriterion("ISRENT =", value, "isrent");
            return (Criteria) this;
        }

        public Criteria andIsrentNotEqualTo(BigDecimal value) {
            addCriterion("ISRENT <>", value, "isrent");
            return (Criteria) this;
        }

        public Criteria andIsrentGreaterThan(BigDecimal value) {
            addCriterion("ISRENT >", value, "isrent");
            return (Criteria) this;
        }

        public Criteria andIsrentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ISRENT >=", value, "isrent");
            return (Criteria) this;
        }

        public Criteria andIsrentLessThan(BigDecimal value) {
            addCriterion("ISRENT <", value, "isrent");
            return (Criteria) this;
        }

        public Criteria andIsrentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ISRENT <=", value, "isrent");
            return (Criteria) this;
        }

        public Criteria andIsrentIn(List<BigDecimal> values) {
            addCriterion("ISRENT in", values, "isrent");
            return (Criteria) this;
        }

        public Criteria andIsrentNotIn(List<BigDecimal> values) {
            addCriterion("ISRENT not in", values, "isrent");
            return (Criteria) this;
        }

        public Criteria andIsrentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ISRENT between", value1, value2, "isrent");
            return (Criteria) this;
        }

        public Criteria andIsrentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ISRENT not between", value1, value2, "isrent");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}