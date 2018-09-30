package com.cindata.housekeeper.web.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class HouseInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HouseInfoExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("ORDER_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("ORDER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(BigDecimal value) {
            addCriterion("ORDER_ID =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(BigDecimal value) {
            addCriterion("ORDER_ID <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(BigDecimal value) {
            addCriterion("ORDER_ID >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ORDER_ID >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(BigDecimal value) {
            addCriterion("ORDER_ID <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ORDER_ID <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<BigDecimal> values) {
            addCriterion("ORDER_ID in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<BigDecimal> values) {
            addCriterion("ORDER_ID not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORDER_ID between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORDER_ID not between", value1, value2, "orderId");
            return (Criteria) this;
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

        public Criteria andBuildingIdIsNull() {
            addCriterion("BUILDING_ID is null");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIsNotNull() {
            addCriterion("BUILDING_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingIdEqualTo(BigDecimal value) {
            addCriterion("BUILDING_ID =", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotEqualTo(BigDecimal value) {
            addCriterion("BUILDING_ID <>", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdGreaterThan(BigDecimal value) {
            addCriterion("BUILDING_ID >", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BUILDING_ID >=", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLessThan(BigDecimal value) {
            addCriterion("BUILDING_ID <", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BUILDING_ID <=", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIn(List<BigDecimal> values) {
            addCriterion("BUILDING_ID in", values, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotIn(List<BigDecimal> values) {
            addCriterion("BUILDING_ID not in", values, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUILDING_ID between", value1, value2, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BUILDING_ID not between", value1, value2, "buildingId");
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

        public Criteria andUnitIdIsNull() {
            addCriterion("UNIT_ID is null");
            return (Criteria) this;
        }

        public Criteria andUnitIdIsNotNull() {
            addCriterion("UNIT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUnitIdEqualTo(BigDecimal value) {
            addCriterion("UNIT_ID =", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotEqualTo(BigDecimal value) {
            addCriterion("UNIT_ID <>", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdGreaterThan(BigDecimal value) {
            addCriterion("UNIT_ID >", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("UNIT_ID >=", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdLessThan(BigDecimal value) {
            addCriterion("UNIT_ID <", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("UNIT_ID <=", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdIn(List<BigDecimal> values) {
            addCriterion("UNIT_ID in", values, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotIn(List<BigDecimal> values) {
            addCriterion("UNIT_ID not in", values, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UNIT_ID between", value1, value2, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UNIT_ID not between", value1, value2, "unitId");
            return (Criteria) this;
        }

        public Criteria andStreetIdIsNull() {
            addCriterion("STREET_ID is null");
            return (Criteria) this;
        }

        public Criteria andStreetIdIsNotNull() {
            addCriterion("STREET_ID is not null");
            return (Criteria) this;
        }

        public Criteria andStreetIdEqualTo(BigDecimal value) {
            addCriterion("STREET_ID =", value, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdNotEqualTo(BigDecimal value) {
            addCriterion("STREET_ID <>", value, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdGreaterThan(BigDecimal value) {
            addCriterion("STREET_ID >", value, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STREET_ID >=", value, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdLessThan(BigDecimal value) {
            addCriterion("STREET_ID <", value, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STREET_ID <=", value, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdIn(List<BigDecimal> values) {
            addCriterion("STREET_ID in", values, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdNotIn(List<BigDecimal> values) {
            addCriterion("STREET_ID not in", values, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STREET_ID between", value1, value2, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STREET_ID not between", value1, value2, "streetId");
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

        public Criteria andSqmpriceIsNull() {
            addCriterion("SQMPRICE is null");
            return (Criteria) this;
        }

        public Criteria andSqmpriceIsNotNull() {
            addCriterion("SQMPRICE is not null");
            return (Criteria) this;
        }

        public Criteria andSqmpriceEqualTo(Long value) {
            addCriterion("SQMPRICE =", value, "sqmprice");
            return (Criteria) this;
        }

        public Criteria andSqmpriceNotEqualTo(Long value) {
            addCriterion("SQMPRICE <>", value, "sqmprice");
            return (Criteria) this;
        }

        public Criteria andSqmpriceGreaterThan(Long value) {
            addCriterion("SQMPRICE >", value, "sqmprice");
            return (Criteria) this;
        }

        public Criteria andSqmpriceGreaterThanOrEqualTo(Long value) {
            addCriterion("SQMPRICE >=", value, "sqmprice");
            return (Criteria) this;
        }

        public Criteria andSqmpriceLessThan(Long value) {
            addCriterion("SQMPRICE <", value, "sqmprice");
            return (Criteria) this;
        }

        public Criteria andSqmpriceLessThanOrEqualTo(Long value) {
            addCriterion("SQMPRICE <=", value, "sqmprice");
            return (Criteria) this;
        }

        public Criteria andSqmpriceIn(List<Long> values) {
            addCriterion("SQMPRICE in", values, "sqmprice");
            return (Criteria) this;
        }

        public Criteria andSqmpriceNotIn(List<Long> values) {
            addCriterion("SQMPRICE not in", values, "sqmprice");
            return (Criteria) this;
        }

        public Criteria andSqmpriceBetween(Long value1, Long value2) {
            addCriterion("SQMPRICE between", value1, value2, "sqmprice");
            return (Criteria) this;
        }

        public Criteria andSqmpriceNotBetween(Long value1, Long value2) {
            addCriterion("SQMPRICE not between", value1, value2, "sqmprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceIsNull() {
            addCriterion("TOTALPRICE is null");
            return (Criteria) this;
        }

        public Criteria andTotalpriceIsNotNull() {
            addCriterion("TOTALPRICE is not null");
            return (Criteria) this;
        }

        public Criteria andTotalpriceEqualTo(Long value) {
            addCriterion("TOTALPRICE =", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceNotEqualTo(Long value) {
            addCriterion("TOTALPRICE <>", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceGreaterThan(Long value) {
            addCriterion("TOTALPRICE >", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceGreaterThanOrEqualTo(Long value) {
            addCriterion("TOTALPRICE >=", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceLessThan(Long value) {
            addCriterion("TOTALPRICE <", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceLessThanOrEqualTo(Long value) {
            addCriterion("TOTALPRICE <=", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceIn(List<Long> values) {
            addCriterion("TOTALPRICE in", values, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceNotIn(List<Long> values) {
            addCriterion("TOTALPRICE not in", values, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceBetween(Long value1, Long value2) {
            addCriterion("TOTALPRICE between", value1, value2, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceNotBetween(Long value1, Long value2) {
            addCriterion("TOTALPRICE not between", value1, value2, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTimeoflistingIsNull() {
            addCriterion("TIMEOFLISTING is null");
            return (Criteria) this;
        }

        public Criteria andTimeoflistingIsNotNull() {
            addCriterion("TIMEOFLISTING is not null");
            return (Criteria) this;
        }

        public Criteria andTimeoflistingEqualTo(Date value) {
            addCriterionForJDBCDate("TIMEOFLISTING =", value, "timeoflisting");
            return (Criteria) this;
        }

        public Criteria andTimeoflistingNotEqualTo(Date value) {
            addCriterionForJDBCDate("TIMEOFLISTING <>", value, "timeoflisting");
            return (Criteria) this;
        }

        public Criteria andTimeoflistingGreaterThan(Date value) {
            addCriterionForJDBCDate("TIMEOFLISTING >", value, "timeoflisting");
            return (Criteria) this;
        }

        public Criteria andTimeoflistingGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TIMEOFLISTING >=", value, "timeoflisting");
            return (Criteria) this;
        }

        public Criteria andTimeoflistingLessThan(Date value) {
            addCriterionForJDBCDate("TIMEOFLISTING <", value, "timeoflisting");
            return (Criteria) this;
        }

        public Criteria andTimeoflistingLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TIMEOFLISTING <=", value, "timeoflisting");
            return (Criteria) this;
        }

        public Criteria andTimeoflistingIn(List<Date> values) {
            addCriterionForJDBCDate("TIMEOFLISTING in", values, "timeoflisting");
            return (Criteria) this;
        }

        public Criteria andTimeoflistingNotIn(List<Date> values) {
            addCriterionForJDBCDate("TIMEOFLISTING not in", values, "timeoflisting");
            return (Criteria) this;
        }

        public Criteria andTimeoflistingBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TIMEOFLISTING between", value1, value2, "timeoflisting");
            return (Criteria) this;
        }

        public Criteria andTimeoflistingNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TIMEOFLISTING not between", value1, value2, "timeoflisting");
            return (Criteria) this;
        }

        public Criteria andDatasourceIsNull() {
            addCriterion("DATASOURCE is null");
            return (Criteria) this;
        }

        public Criteria andDatasourceIsNotNull() {
            addCriterion("DATASOURCE is not null");
            return (Criteria) this;
        }

        public Criteria andDatasourceEqualTo(String value) {
            addCriterion("DATASOURCE =", value, "datasource");
            return (Criteria) this;
        }

        public Criteria andDatasourceNotEqualTo(String value) {
            addCriterion("DATASOURCE <>", value, "datasource");
            return (Criteria) this;
        }

        public Criteria andDatasourceGreaterThan(String value) {
            addCriterion("DATASOURCE >", value, "datasource");
            return (Criteria) this;
        }

        public Criteria andDatasourceGreaterThanOrEqualTo(String value) {
            addCriterion("DATASOURCE >=", value, "datasource");
            return (Criteria) this;
        }

        public Criteria andDatasourceLessThan(String value) {
            addCriterion("DATASOURCE <", value, "datasource");
            return (Criteria) this;
        }

        public Criteria andDatasourceLessThanOrEqualTo(String value) {
            addCriterion("DATASOURCE <=", value, "datasource");
            return (Criteria) this;
        }

        public Criteria andDatasourceLike(String value) {
            addCriterion("DATASOURCE like", value, "datasource");
            return (Criteria) this;
        }

        public Criteria andDatasourceNotLike(String value) {
            addCriterion("DATASOURCE not like", value, "datasource");
            return (Criteria) this;
        }

        public Criteria andDatasourceIn(List<String> values) {
            addCriterion("DATASOURCE in", values, "datasource");
            return (Criteria) this;
        }

        public Criteria andDatasourceNotIn(List<String> values) {
            addCriterion("DATASOURCE not in", values, "datasource");
            return (Criteria) this;
        }

        public Criteria andDatasourceBetween(String value1, String value2) {
            addCriterion("DATASOURCE between", value1, value2, "datasource");
            return (Criteria) this;
        }

        public Criteria andDatasourceNotBetween(String value1, String value2) {
            addCriterion("DATASOURCE not between", value1, value2, "datasource");
            return (Criteria) this;
        }

        public Criteria andContactpersonIsNull() {
            addCriterion("CONTACTPERSON is null");
            return (Criteria) this;
        }

        public Criteria andContactpersonIsNotNull() {
            addCriterion("CONTACTPERSON is not null");
            return (Criteria) this;
        }

        public Criteria andContactpersonEqualTo(String value) {
            addCriterion("CONTACTPERSON =", value, "contactperson");
            return (Criteria) this;
        }

        public Criteria andContactpersonNotEqualTo(String value) {
            addCriterion("CONTACTPERSON <>", value, "contactperson");
            return (Criteria) this;
        }

        public Criteria andContactpersonGreaterThan(String value) {
            addCriterion("CONTACTPERSON >", value, "contactperson");
            return (Criteria) this;
        }

        public Criteria andContactpersonGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACTPERSON >=", value, "contactperson");
            return (Criteria) this;
        }

        public Criteria andContactpersonLessThan(String value) {
            addCriterion("CONTACTPERSON <", value, "contactperson");
            return (Criteria) this;
        }

        public Criteria andContactpersonLessThanOrEqualTo(String value) {
            addCriterion("CONTACTPERSON <=", value, "contactperson");
            return (Criteria) this;
        }

        public Criteria andContactpersonLike(String value) {
            addCriterion("CONTACTPERSON like", value, "contactperson");
            return (Criteria) this;
        }

        public Criteria andContactpersonNotLike(String value) {
            addCriterion("CONTACTPERSON not like", value, "contactperson");
            return (Criteria) this;
        }

        public Criteria andContactpersonIn(List<String> values) {
            addCriterion("CONTACTPERSON in", values, "contactperson");
            return (Criteria) this;
        }

        public Criteria andContactpersonNotIn(List<String> values) {
            addCriterion("CONTACTPERSON not in", values, "contactperson");
            return (Criteria) this;
        }

        public Criteria andContactpersonBetween(String value1, String value2) {
            addCriterion("CONTACTPERSON between", value1, value2, "contactperson");
            return (Criteria) this;
        }

        public Criteria andContactpersonNotBetween(String value1, String value2) {
            addCriterion("CONTACTPERSON not between", value1, value2, "contactperson");
            return (Criteria) this;
        }

        public Criteria andAgencycompanyIsNull() {
            addCriterion("AGENCYCOMPANY is null");
            return (Criteria) this;
        }

        public Criteria andAgencycompanyIsNotNull() {
            addCriterion("AGENCYCOMPANY is not null");
            return (Criteria) this;
        }

        public Criteria andAgencycompanyEqualTo(String value) {
            addCriterion("AGENCYCOMPANY =", value, "agencycompany");
            return (Criteria) this;
        }

        public Criteria andAgencycompanyNotEqualTo(String value) {
            addCriterion("AGENCYCOMPANY <>", value, "agencycompany");
            return (Criteria) this;
        }

        public Criteria andAgencycompanyGreaterThan(String value) {
            addCriterion("AGENCYCOMPANY >", value, "agencycompany");
            return (Criteria) this;
        }

        public Criteria andAgencycompanyGreaterThanOrEqualTo(String value) {
            addCriterion("AGENCYCOMPANY >=", value, "agencycompany");
            return (Criteria) this;
        }

        public Criteria andAgencycompanyLessThan(String value) {
            addCriterion("AGENCYCOMPANY <", value, "agencycompany");
            return (Criteria) this;
        }

        public Criteria andAgencycompanyLessThanOrEqualTo(String value) {
            addCriterion("AGENCYCOMPANY <=", value, "agencycompany");
            return (Criteria) this;
        }

        public Criteria andAgencycompanyLike(String value) {
            addCriterion("AGENCYCOMPANY like", value, "agencycompany");
            return (Criteria) this;
        }

        public Criteria andAgencycompanyNotLike(String value) {
            addCriterion("AGENCYCOMPANY not like", value, "agencycompany");
            return (Criteria) this;
        }

        public Criteria andAgencycompanyIn(List<String> values) {
            addCriterion("AGENCYCOMPANY in", values, "agencycompany");
            return (Criteria) this;
        }

        public Criteria andAgencycompanyNotIn(List<String> values) {
            addCriterion("AGENCYCOMPANY not in", values, "agencycompany");
            return (Criteria) this;
        }

        public Criteria andAgencycompanyBetween(String value1, String value2) {
            addCriterion("AGENCYCOMPANY between", value1, value2, "agencycompany");
            return (Criteria) this;
        }

        public Criteria andAgencycompanyNotBetween(String value1, String value2) {
            addCriterion("AGENCYCOMPANY not between", value1, value2, "agencycompany");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("TELEPHONE is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("TELEPHONE is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("TELEPHONE =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("TELEPHONE <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("TELEPHONE >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("TELEPHONE >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("TELEPHONE <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("TELEPHONE <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("TELEPHONE like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("TELEPHONE not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("TELEPHONE in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("TELEPHONE not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("TELEPHONE between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("TELEPHONE not between", value1, value2, "telephone");
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

        public Criteria andFloortypeIsNull() {
            addCriterion("FLOORTYPE is null");
            return (Criteria) this;
        }

        public Criteria andFloortypeIsNotNull() {
            addCriterion("FLOORTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFloortypeEqualTo(String value) {
            addCriterion("FLOORTYPE =", value, "floortype");
            return (Criteria) this;
        }

        public Criteria andFloortypeNotEqualTo(String value) {
            addCriterion("FLOORTYPE <>", value, "floortype");
            return (Criteria) this;
        }

        public Criteria andFloortypeGreaterThan(String value) {
            addCriterion("FLOORTYPE >", value, "floortype");
            return (Criteria) this;
        }

        public Criteria andFloortypeGreaterThanOrEqualTo(String value) {
            addCriterion("FLOORTYPE >=", value, "floortype");
            return (Criteria) this;
        }

        public Criteria andFloortypeLessThan(String value) {
            addCriterion("FLOORTYPE <", value, "floortype");
            return (Criteria) this;
        }

        public Criteria andFloortypeLessThanOrEqualTo(String value) {
            addCriterion("FLOORTYPE <=", value, "floortype");
            return (Criteria) this;
        }

        public Criteria andFloortypeLike(String value) {
            addCriterion("FLOORTYPE like", value, "floortype");
            return (Criteria) this;
        }

        public Criteria andFloortypeNotLike(String value) {
            addCriterion("FLOORTYPE not like", value, "floortype");
            return (Criteria) this;
        }

        public Criteria andFloortypeIn(List<String> values) {
            addCriterion("FLOORTYPE in", values, "floortype");
            return (Criteria) this;
        }

        public Criteria andFloortypeNotIn(List<String> values) {
            addCriterion("FLOORTYPE not in", values, "floortype");
            return (Criteria) this;
        }

        public Criteria andFloortypeBetween(String value1, String value2) {
            addCriterion("FLOORTYPE between", value1, value2, "floortype");
            return (Criteria) this;
        }

        public Criteria andFloortypeNotBetween(String value1, String value2) {
            addCriterion("FLOORTYPE not between", value1, value2, "floortype");
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

        public Criteria andArchitectureperiodIsNull() {
            addCriterion("ARCHITECTUREPERIOD is null");
            return (Criteria) this;
        }

        public Criteria andArchitectureperiodIsNotNull() {
            addCriterion("ARCHITECTUREPERIOD is not null");
            return (Criteria) this;
        }

        public Criteria andArchitectureperiodEqualTo(String value) {
            addCriterion("ARCHITECTUREPERIOD =", value, "architectureperiod");
            return (Criteria) this;
        }

        public Criteria andArchitectureperiodNotEqualTo(String value) {
            addCriterion("ARCHITECTUREPERIOD <>", value, "architectureperiod");
            return (Criteria) this;
        }

        public Criteria andArchitectureperiodGreaterThan(String value) {
            addCriterion("ARCHITECTUREPERIOD >", value, "architectureperiod");
            return (Criteria) this;
        }

        public Criteria andArchitectureperiodGreaterThanOrEqualTo(String value) {
            addCriterion("ARCHITECTUREPERIOD >=", value, "architectureperiod");
            return (Criteria) this;
        }

        public Criteria andArchitectureperiodLessThan(String value) {
            addCriterion("ARCHITECTUREPERIOD <", value, "architectureperiod");
            return (Criteria) this;
        }

        public Criteria andArchitectureperiodLessThanOrEqualTo(String value) {
            addCriterion("ARCHITECTUREPERIOD <=", value, "architectureperiod");
            return (Criteria) this;
        }

        public Criteria andArchitectureperiodLike(String value) {
            addCriterion("ARCHITECTUREPERIOD like", value, "architectureperiod");
            return (Criteria) this;
        }

        public Criteria andArchitectureperiodNotLike(String value) {
            addCriterion("ARCHITECTUREPERIOD not like", value, "architectureperiod");
            return (Criteria) this;
        }

        public Criteria andArchitectureperiodIn(List<String> values) {
            addCriterion("ARCHITECTUREPERIOD in", values, "architectureperiod");
            return (Criteria) this;
        }

        public Criteria andArchitectureperiodNotIn(List<String> values) {
            addCriterion("ARCHITECTUREPERIOD not in", values, "architectureperiod");
            return (Criteria) this;
        }

        public Criteria andArchitectureperiodBetween(String value1, String value2) {
            addCriterion("ARCHITECTUREPERIOD between", value1, value2, "architectureperiod");
            return (Criteria) this;
        }

        public Criteria andArchitectureperiodNotBetween(String value1, String value2) {
            addCriterion("ARCHITECTUREPERIOD not between", value1, value2, "architectureperiod");
            return (Criteria) this;
        }

        public Criteria andDoneperiodIsNull() {
            addCriterion("DONEPERIOD is null");
            return (Criteria) this;
        }

        public Criteria andDoneperiodIsNotNull() {
            addCriterion("DONEPERIOD is not null");
            return (Criteria) this;
        }

        public Criteria andDoneperiodEqualTo(String value) {
            addCriterion("DONEPERIOD =", value, "doneperiod");
            return (Criteria) this;
        }

        public Criteria andDoneperiodNotEqualTo(String value) {
            addCriterion("DONEPERIOD <>", value, "doneperiod");
            return (Criteria) this;
        }

        public Criteria andDoneperiodGreaterThan(String value) {
            addCriterion("DONEPERIOD >", value, "doneperiod");
            return (Criteria) this;
        }

        public Criteria andDoneperiodGreaterThanOrEqualTo(String value) {
            addCriterion("DONEPERIOD >=", value, "doneperiod");
            return (Criteria) this;
        }

        public Criteria andDoneperiodLessThan(String value) {
            addCriterion("DONEPERIOD <", value, "doneperiod");
            return (Criteria) this;
        }

        public Criteria andDoneperiodLessThanOrEqualTo(String value) {
            addCriterion("DONEPERIOD <=", value, "doneperiod");
            return (Criteria) this;
        }

        public Criteria andDoneperiodLike(String value) {
            addCriterion("DONEPERIOD like", value, "doneperiod");
            return (Criteria) this;
        }

        public Criteria andDoneperiodNotLike(String value) {
            addCriterion("DONEPERIOD not like", value, "doneperiod");
            return (Criteria) this;
        }

        public Criteria andDoneperiodIn(List<String> values) {
            addCriterion("DONEPERIOD in", values, "doneperiod");
            return (Criteria) this;
        }

        public Criteria andDoneperiodNotIn(List<String> values) {
            addCriterion("DONEPERIOD not in", values, "doneperiod");
            return (Criteria) this;
        }

        public Criteria andDoneperiodBetween(String value1, String value2) {
            addCriterion("DONEPERIOD between", value1, value2, "doneperiod");
            return (Criteria) this;
        }

        public Criteria andDoneperiodNotBetween(String value1, String value2) {
            addCriterion("DONEPERIOD not between", value1, value2, "doneperiod");
            return (Criteria) this;
        }

        public Criteria andAbhorFactorIsNull() {
            addCriterion("ABHOR_FACTOR is null");
            return (Criteria) this;
        }

        public Criteria andAbhorFactorIsNotNull() {
            addCriterion("ABHOR_FACTOR is not null");
            return (Criteria) this;
        }

        public Criteria andAbhorFactorEqualTo(String value) {
            addCriterion("ABHOR_FACTOR =", value, "abhorFactor");
            return (Criteria) this;
        }

        public Criteria andAbhorFactorNotEqualTo(String value) {
            addCriterion("ABHOR_FACTOR <>", value, "abhorFactor");
            return (Criteria) this;
        }

        public Criteria andAbhorFactorGreaterThan(String value) {
            addCriterion("ABHOR_FACTOR >", value, "abhorFactor");
            return (Criteria) this;
        }

        public Criteria andAbhorFactorGreaterThanOrEqualTo(String value) {
            addCriterion("ABHOR_FACTOR >=", value, "abhorFactor");
            return (Criteria) this;
        }

        public Criteria andAbhorFactorLessThan(String value) {
            addCriterion("ABHOR_FACTOR <", value, "abhorFactor");
            return (Criteria) this;
        }

        public Criteria andAbhorFactorLessThanOrEqualTo(String value) {
            addCriterion("ABHOR_FACTOR <=", value, "abhorFactor");
            return (Criteria) this;
        }

        public Criteria andAbhorFactorLike(String value) {
            addCriterion("ABHOR_FACTOR like", value, "abhorFactor");
            return (Criteria) this;
        }

        public Criteria andAbhorFactorNotLike(String value) {
            addCriterion("ABHOR_FACTOR not like", value, "abhorFactor");
            return (Criteria) this;
        }

        public Criteria andAbhorFactorIn(List<String> values) {
            addCriterion("ABHOR_FACTOR in", values, "abhorFactor");
            return (Criteria) this;
        }

        public Criteria andAbhorFactorNotIn(List<String> values) {
            addCriterion("ABHOR_FACTOR not in", values, "abhorFactor");
            return (Criteria) this;
        }

        public Criteria andAbhorFactorBetween(String value1, String value2) {
            addCriterion("ABHOR_FACTOR between", value1, value2, "abhorFactor");
            return (Criteria) this;
        }

        public Criteria andAbhorFactorNotBetween(String value1, String value2) {
            addCriterion("ABHOR_FACTOR not between", value1, value2, "abhorFactor");
            return (Criteria) this;
        }

        public Criteria andHousePropertyIsNull() {
            addCriterion("HOUSE_PROPERTY is null");
            return (Criteria) this;
        }

        public Criteria andHousePropertyIsNotNull() {
            addCriterion("HOUSE_PROPERTY is not null");
            return (Criteria) this;
        }

        public Criteria andHousePropertyEqualTo(String value) {
            addCriterion("HOUSE_PROPERTY =", value, "houseProperty");
            return (Criteria) this;
        }

        public Criteria andHousePropertyNotEqualTo(String value) {
            addCriterion("HOUSE_PROPERTY <>", value, "houseProperty");
            return (Criteria) this;
        }

        public Criteria andHousePropertyGreaterThan(String value) {
            addCriterion("HOUSE_PROPERTY >", value, "houseProperty");
            return (Criteria) this;
        }

        public Criteria andHousePropertyGreaterThanOrEqualTo(String value) {
            addCriterion("HOUSE_PROPERTY >=", value, "houseProperty");
            return (Criteria) this;
        }

        public Criteria andHousePropertyLessThan(String value) {
            addCriterion("HOUSE_PROPERTY <", value, "houseProperty");
            return (Criteria) this;
        }

        public Criteria andHousePropertyLessThanOrEqualTo(String value) {
            addCriterion("HOUSE_PROPERTY <=", value, "houseProperty");
            return (Criteria) this;
        }

        public Criteria andHousePropertyLike(String value) {
            addCriterion("HOUSE_PROPERTY like", value, "houseProperty");
            return (Criteria) this;
        }

        public Criteria andHousePropertyNotLike(String value) {
            addCriterion("HOUSE_PROPERTY not like", value, "houseProperty");
            return (Criteria) this;
        }

        public Criteria andHousePropertyIn(List<String> values) {
            addCriterion("HOUSE_PROPERTY in", values, "houseProperty");
            return (Criteria) this;
        }

        public Criteria andHousePropertyNotIn(List<String> values) {
            addCriterion("HOUSE_PROPERTY not in", values, "houseProperty");
            return (Criteria) this;
        }

        public Criteria andHousePropertyBetween(String value1, String value2) {
            addCriterion("HOUSE_PROPERTY between", value1, value2, "houseProperty");
            return (Criteria) this;
        }

        public Criteria andHousePropertyNotBetween(String value1, String value2) {
            addCriterion("HOUSE_PROPERTY not between", value1, value2, "houseProperty");
            return (Criteria) this;
        }

        public Criteria andCaseSourceIsNull() {
            addCriterion("CASE_SOURCE is null");
            return (Criteria) this;
        }

        public Criteria andCaseSourceIsNotNull() {
            addCriterion("CASE_SOURCE is not null");
            return (Criteria) this;
        }

        public Criteria andCaseSourceEqualTo(String value) {
            addCriterion("CASE_SOURCE =", value, "caseSource");
            return (Criteria) this;
        }

        public Criteria andCaseSourceNotEqualTo(String value) {
            addCriterion("CASE_SOURCE <>", value, "caseSource");
            return (Criteria) this;
        }

        public Criteria andCaseSourceGreaterThan(String value) {
            addCriterion("CASE_SOURCE >", value, "caseSource");
            return (Criteria) this;
        }

        public Criteria andCaseSourceGreaterThanOrEqualTo(String value) {
            addCriterion("CASE_SOURCE >=", value, "caseSource");
            return (Criteria) this;
        }

        public Criteria andCaseSourceLessThan(String value) {
            addCriterion("CASE_SOURCE <", value, "caseSource");
            return (Criteria) this;
        }

        public Criteria andCaseSourceLessThanOrEqualTo(String value) {
            addCriterion("CASE_SOURCE <=", value, "caseSource");
            return (Criteria) this;
        }

        public Criteria andCaseSourceLike(String value) {
            addCriterion("CASE_SOURCE like", value, "caseSource");
            return (Criteria) this;
        }

        public Criteria andCaseSourceNotLike(String value) {
            addCriterion("CASE_SOURCE not like", value, "caseSource");
            return (Criteria) this;
        }

        public Criteria andCaseSourceIn(List<String> values) {
            addCriterion("CASE_SOURCE in", values, "caseSource");
            return (Criteria) this;
        }

        public Criteria andCaseSourceNotIn(List<String> values) {
            addCriterion("CASE_SOURCE not in", values, "caseSource");
            return (Criteria) this;
        }

        public Criteria andCaseSourceBetween(String value1, String value2) {
            addCriterion("CASE_SOURCE between", value1, value2, "caseSource");
            return (Criteria) this;
        }

        public Criteria andCaseSourceNotBetween(String value1, String value2) {
            addCriterion("CASE_SOURCE not between", value1, value2, "caseSource");
            return (Criteria) this;
        }

        public Criteria andPlanarstructureIsNull() {
            addCriterion("PLANARSTRUCTURE is null");
            return (Criteria) this;
        }

        public Criteria andPlanarstructureIsNotNull() {
            addCriterion("PLANARSTRUCTURE is not null");
            return (Criteria) this;
        }

        public Criteria andPlanarstructureEqualTo(String value) {
            addCriterion("PLANARSTRUCTURE =", value, "planarstructure");
            return (Criteria) this;
        }

        public Criteria andPlanarstructureNotEqualTo(String value) {
            addCriterion("PLANARSTRUCTURE <>", value, "planarstructure");
            return (Criteria) this;
        }

        public Criteria andPlanarstructureGreaterThan(String value) {
            addCriterion("PLANARSTRUCTURE >", value, "planarstructure");
            return (Criteria) this;
        }

        public Criteria andPlanarstructureGreaterThanOrEqualTo(String value) {
            addCriterion("PLANARSTRUCTURE >=", value, "planarstructure");
            return (Criteria) this;
        }

        public Criteria andPlanarstructureLessThan(String value) {
            addCriterion("PLANARSTRUCTURE <", value, "planarstructure");
            return (Criteria) this;
        }

        public Criteria andPlanarstructureLessThanOrEqualTo(String value) {
            addCriterion("PLANARSTRUCTURE <=", value, "planarstructure");
            return (Criteria) this;
        }

        public Criteria andPlanarstructureLike(String value) {
            addCriterion("PLANARSTRUCTURE like", value, "planarstructure");
            return (Criteria) this;
        }

        public Criteria andPlanarstructureNotLike(String value) {
            addCriterion("PLANARSTRUCTURE not like", value, "planarstructure");
            return (Criteria) this;
        }

        public Criteria andPlanarstructureIn(List<String> values) {
            addCriterion("PLANARSTRUCTURE in", values, "planarstructure");
            return (Criteria) this;
        }

        public Criteria andPlanarstructureNotIn(List<String> values) {
            addCriterion("PLANARSTRUCTURE not in", values, "planarstructure");
            return (Criteria) this;
        }

        public Criteria andPlanarstructureBetween(String value1, String value2) {
            addCriterion("PLANARSTRUCTURE between", value1, value2, "planarstructure");
            return (Criteria) this;
        }

        public Criteria andPlanarstructureNotBetween(String value1, String value2) {
            addCriterion("PLANARSTRUCTURE not between", value1, value2, "planarstructure");
            return (Criteria) this;
        }

        public Criteria andFloorsOccuppiedIsNull() {
            addCriterion("FLOORS_OCCUPPIED is null");
            return (Criteria) this;
        }

        public Criteria andFloorsOccuppiedIsNotNull() {
            addCriterion("FLOORS_OCCUPPIED is not null");
            return (Criteria) this;
        }

        public Criteria andFloorsOccuppiedEqualTo(Short value) {
            addCriterion("FLOORS_OCCUPPIED =", value, "floorsOccuppied");
            return (Criteria) this;
        }

        public Criteria andFloorsOccuppiedNotEqualTo(Short value) {
            addCriterion("FLOORS_OCCUPPIED <>", value, "floorsOccuppied");
            return (Criteria) this;
        }

        public Criteria andFloorsOccuppiedGreaterThan(Short value) {
            addCriterion("FLOORS_OCCUPPIED >", value, "floorsOccuppied");
            return (Criteria) this;
        }

        public Criteria andFloorsOccuppiedGreaterThanOrEqualTo(Short value) {
            addCriterion("FLOORS_OCCUPPIED >=", value, "floorsOccuppied");
            return (Criteria) this;
        }

        public Criteria andFloorsOccuppiedLessThan(Short value) {
            addCriterion("FLOORS_OCCUPPIED <", value, "floorsOccuppied");
            return (Criteria) this;
        }

        public Criteria andFloorsOccuppiedLessThanOrEqualTo(Short value) {
            addCriterion("FLOORS_OCCUPPIED <=", value, "floorsOccuppied");
            return (Criteria) this;
        }

        public Criteria andFloorsOccuppiedIn(List<Short> values) {
            addCriterion("FLOORS_OCCUPPIED in", values, "floorsOccuppied");
            return (Criteria) this;
        }

        public Criteria andFloorsOccuppiedNotIn(List<Short> values) {
            addCriterion("FLOORS_OCCUPPIED not in", values, "floorsOccuppied");
            return (Criteria) this;
        }

        public Criteria andFloorsOccuppiedBetween(Short value1, Short value2) {
            addCriterion("FLOORS_OCCUPPIED between", value1, value2, "floorsOccuppied");
            return (Criteria) this;
        }

        public Criteria andFloorsOccuppiedNotBetween(Short value1, Short value2) {
            addCriterion("FLOORS_OCCUPPIED not between", value1, value2, "floorsOccuppied");
            return (Criteria) this;
        }

        public Criteria andFloorStartIsNull() {
            addCriterion("FLOOR_START is null");
            return (Criteria) this;
        }

        public Criteria andFloorStartIsNotNull() {
            addCriterion("FLOOR_START is not null");
            return (Criteria) this;
        }

        public Criteria andFloorStartEqualTo(Short value) {
            addCriterion("FLOOR_START =", value, "floorStart");
            return (Criteria) this;
        }

        public Criteria andFloorStartNotEqualTo(Short value) {
            addCriterion("FLOOR_START <>", value, "floorStart");
            return (Criteria) this;
        }

        public Criteria andFloorStartGreaterThan(Short value) {
            addCriterion("FLOOR_START >", value, "floorStart");
            return (Criteria) this;
        }

        public Criteria andFloorStartGreaterThanOrEqualTo(Short value) {
            addCriterion("FLOOR_START >=", value, "floorStart");
            return (Criteria) this;
        }

        public Criteria andFloorStartLessThan(Short value) {
            addCriterion("FLOOR_START <", value, "floorStart");
            return (Criteria) this;
        }

        public Criteria andFloorStartLessThanOrEqualTo(Short value) {
            addCriterion("FLOOR_START <=", value, "floorStart");
            return (Criteria) this;
        }

        public Criteria andFloorStartIn(List<Short> values) {
            addCriterion("FLOOR_START in", values, "floorStart");
            return (Criteria) this;
        }

        public Criteria andFloorStartNotIn(List<Short> values) {
            addCriterion("FLOOR_START not in", values, "floorStart");
            return (Criteria) this;
        }

        public Criteria andFloorStartBetween(Short value1, Short value2) {
            addCriterion("FLOOR_START between", value1, value2, "floorStart");
            return (Criteria) this;
        }

        public Criteria andFloorStartNotBetween(Short value1, Short value2) {
            addCriterion("FLOOR_START not between", value1, value2, "floorStart");
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

        public Criteria andSupportingserviceIsNull() {
            addCriterion("SUPPORTINGSERVICE is null");
            return (Criteria) this;
        }

        public Criteria andSupportingserviceIsNotNull() {
            addCriterion("SUPPORTINGSERVICE is not null");
            return (Criteria) this;
        }

        public Criteria andSupportingserviceEqualTo(String value) {
            addCriterion("SUPPORTINGSERVICE =", value, "supportingservice");
            return (Criteria) this;
        }

        public Criteria andSupportingserviceNotEqualTo(String value) {
            addCriterion("SUPPORTINGSERVICE <>", value, "supportingservice");
            return (Criteria) this;
        }

        public Criteria andSupportingserviceGreaterThan(String value) {
            addCriterion("SUPPORTINGSERVICE >", value, "supportingservice");
            return (Criteria) this;
        }

        public Criteria andSupportingserviceGreaterThanOrEqualTo(String value) {
            addCriterion("SUPPORTINGSERVICE >=", value, "supportingservice");
            return (Criteria) this;
        }

        public Criteria andSupportingserviceLessThan(String value) {
            addCriterion("SUPPORTINGSERVICE <", value, "supportingservice");
            return (Criteria) this;
        }

        public Criteria andSupportingserviceLessThanOrEqualTo(String value) {
            addCriterion("SUPPORTINGSERVICE <=", value, "supportingservice");
            return (Criteria) this;
        }

        public Criteria andSupportingserviceLike(String value) {
            addCriterion("SUPPORTINGSERVICE like", value, "supportingservice");
            return (Criteria) this;
        }

        public Criteria andSupportingserviceNotLike(String value) {
            addCriterion("SUPPORTINGSERVICE not like", value, "supportingservice");
            return (Criteria) this;
        }

        public Criteria andSupportingserviceIn(List<String> values) {
            addCriterion("SUPPORTINGSERVICE in", values, "supportingservice");
            return (Criteria) this;
        }

        public Criteria andSupportingserviceNotIn(List<String> values) {
            addCriterion("SUPPORTINGSERVICE not in", values, "supportingservice");
            return (Criteria) this;
        }

        public Criteria andSupportingserviceBetween(String value1, String value2) {
            addCriterion("SUPPORTINGSERVICE between", value1, value2, "supportingservice");
            return (Criteria) this;
        }

        public Criteria andSupportingserviceNotBetween(String value1, String value2) {
            addCriterion("SUPPORTINGSERVICE not between", value1, value2, "supportingservice");
            return (Criteria) this;
        }

        public Criteria andGoodFactorIsNull() {
            addCriterion("GOOD_FACTOR is null");
            return (Criteria) this;
        }

        public Criteria andGoodFactorIsNotNull() {
            addCriterion("GOOD_FACTOR is not null");
            return (Criteria) this;
        }

        public Criteria andGoodFactorEqualTo(String value) {
            addCriterion("GOOD_FACTOR =", value, "goodFactor");
            return (Criteria) this;
        }

        public Criteria andGoodFactorNotEqualTo(String value) {
            addCriterion("GOOD_FACTOR <>", value, "goodFactor");
            return (Criteria) this;
        }

        public Criteria andGoodFactorGreaterThan(String value) {
            addCriterion("GOOD_FACTOR >", value, "goodFactor");
            return (Criteria) this;
        }

        public Criteria andGoodFactorGreaterThanOrEqualTo(String value) {
            addCriterion("GOOD_FACTOR >=", value, "goodFactor");
            return (Criteria) this;
        }

        public Criteria andGoodFactorLessThan(String value) {
            addCriterion("GOOD_FACTOR <", value, "goodFactor");
            return (Criteria) this;
        }

        public Criteria andGoodFactorLessThanOrEqualTo(String value) {
            addCriterion("GOOD_FACTOR <=", value, "goodFactor");
            return (Criteria) this;
        }

        public Criteria andGoodFactorLike(String value) {
            addCriterion("GOOD_FACTOR like", value, "goodFactor");
            return (Criteria) this;
        }

        public Criteria andGoodFactorNotLike(String value) {
            addCriterion("GOOD_FACTOR not like", value, "goodFactor");
            return (Criteria) this;
        }

        public Criteria andGoodFactorIn(List<String> values) {
            addCriterion("GOOD_FACTOR in", values, "goodFactor");
            return (Criteria) this;
        }

        public Criteria andGoodFactorNotIn(List<String> values) {
            addCriterion("GOOD_FACTOR not in", values, "goodFactor");
            return (Criteria) this;
        }

        public Criteria andGoodFactorBetween(String value1, String value2) {
            addCriterion("GOOD_FACTOR between", value1, value2, "goodFactor");
            return (Criteria) this;
        }

        public Criteria andGoodFactorNotBetween(String value1, String value2) {
            addCriterion("GOOD_FACTOR not between", value1, value2, "goodFactor");
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

        public Criteria andUpdateNumIsNull() {
            addCriterion("UPDATE_NUM is null");
            return (Criteria) this;
        }

        public Criteria andUpdateNumIsNotNull() {
            addCriterion("UPDATE_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateNumEqualTo(Short value) {
            addCriterion("UPDATE_NUM =", value, "updateNum");
            return (Criteria) this;
        }

        public Criteria andUpdateNumNotEqualTo(Short value) {
            addCriterion("UPDATE_NUM <>", value, "updateNum");
            return (Criteria) this;
        }

        public Criteria andUpdateNumGreaterThan(Short value) {
            addCriterion("UPDATE_NUM >", value, "updateNum");
            return (Criteria) this;
        }

        public Criteria andUpdateNumGreaterThanOrEqualTo(Short value) {
            addCriterion("UPDATE_NUM >=", value, "updateNum");
            return (Criteria) this;
        }

        public Criteria andUpdateNumLessThan(Short value) {
            addCriterion("UPDATE_NUM <", value, "updateNum");
            return (Criteria) this;
        }

        public Criteria andUpdateNumLessThanOrEqualTo(Short value) {
            addCriterion("UPDATE_NUM <=", value, "updateNum");
            return (Criteria) this;
        }

        public Criteria andUpdateNumIn(List<Short> values) {
            addCriterion("UPDATE_NUM in", values, "updateNum");
            return (Criteria) this;
        }

        public Criteria andUpdateNumNotIn(List<Short> values) {
            addCriterion("UPDATE_NUM not in", values, "updateNum");
            return (Criteria) this;
        }

        public Criteria andUpdateNumBetween(Short value1, Short value2) {
            addCriterion("UPDATE_NUM between", value1, value2, "updateNum");
            return (Criteria) this;
        }

        public Criteria andUpdateNumNotBetween(Short value1, Short value2) {
            addCriterion("UPDATE_NUM not between", value1, value2, "updateNum");
            return (Criteria) this;
        }

        public Criteria andHouseNameIsNull() {
            addCriterion("HOUSE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andHouseNameIsNotNull() {
            addCriterion("HOUSE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andHouseNameEqualTo(String value) {
            addCriterion("HOUSE_NAME =", value, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameNotEqualTo(String value) {
            addCriterion("HOUSE_NAME <>", value, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameGreaterThan(String value) {
            addCriterion("HOUSE_NAME >", value, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameGreaterThanOrEqualTo(String value) {
            addCriterion("HOUSE_NAME >=", value, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameLessThan(String value) {
            addCriterion("HOUSE_NAME <", value, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameLessThanOrEqualTo(String value) {
            addCriterion("HOUSE_NAME <=", value, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameLike(String value) {
            addCriterion("HOUSE_NAME like", value, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameNotLike(String value) {
            addCriterion("HOUSE_NAME not like", value, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameIn(List<String> values) {
            addCriterion("HOUSE_NAME in", values, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameNotIn(List<String> values) {
            addCriterion("HOUSE_NAME not in", values, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameBetween(String value1, String value2) {
            addCriterion("HOUSE_NAME between", value1, value2, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameNotBetween(String value1, String value2) {
            addCriterion("HOUSE_NAME not between", value1, value2, "houseName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameIsNull() {
            addCriterion("BUILDING_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBuildingNameIsNotNull() {
            addCriterion("BUILDING_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingNameEqualTo(String value) {
            addCriterion("BUILDING_NAME =", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameNotEqualTo(String value) {
            addCriterion("BUILDING_NAME <>", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameGreaterThan(String value) {
            addCriterion("BUILDING_NAME >", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameGreaterThanOrEqualTo(String value) {
            addCriterion("BUILDING_NAME >=", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameLessThan(String value) {
            addCriterion("BUILDING_NAME <", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameLessThanOrEqualTo(String value) {
            addCriterion("BUILDING_NAME <=", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameLike(String value) {
            addCriterion("BUILDING_NAME like", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameNotLike(String value) {
            addCriterion("BUILDING_NAME not like", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameIn(List<String> values) {
            addCriterion("BUILDING_NAME in", values, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameNotIn(List<String> values) {
            addCriterion("BUILDING_NAME not in", values, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameBetween(String value1, String value2) {
            addCriterion("BUILDING_NAME between", value1, value2, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameNotBetween(String value1, String value2) {
            addCriterion("BUILDING_NAME not between", value1, value2, "buildingName");
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

        public Criteria andUnitNameIsNull() {
            addCriterion("UNIT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUnitNameIsNotNull() {
            addCriterion("UNIT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUnitNameEqualTo(String value) {
            addCriterion("UNIT_NAME =", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotEqualTo(String value) {
            addCriterion("UNIT_NAME <>", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameGreaterThan(String value) {
            addCriterion("UNIT_NAME >", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameGreaterThanOrEqualTo(String value) {
            addCriterion("UNIT_NAME >=", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLessThan(String value) {
            addCriterion("UNIT_NAME <", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLessThanOrEqualTo(String value) {
            addCriterion("UNIT_NAME <=", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLike(String value) {
            addCriterion("UNIT_NAME like", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotLike(String value) {
            addCriterion("UNIT_NAME not like", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameIn(List<String> values) {
            addCriterion("UNIT_NAME in", values, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotIn(List<String> values) {
            addCriterion("UNIT_NAME not in", values, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameBetween(String value1, String value2) {
            addCriterion("UNIT_NAME between", value1, value2, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotBetween(String value1, String value2) {
            addCriterion("UNIT_NAME not between", value1, value2, "unitName");
            return (Criteria) this;
        }

        public Criteria andStreetNameIsNull() {
            addCriterion("STREET_NAME is null");
            return (Criteria) this;
        }

        public Criteria andStreetNameIsNotNull() {
            addCriterion("STREET_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andStreetNameEqualTo(String value) {
            addCriterion("STREET_NAME =", value, "streetName");
            return (Criteria) this;
        }

        public Criteria andStreetNameNotEqualTo(String value) {
            addCriterion("STREET_NAME <>", value, "streetName");
            return (Criteria) this;
        }

        public Criteria andStreetNameGreaterThan(String value) {
            addCriterion("STREET_NAME >", value, "streetName");
            return (Criteria) this;
        }

        public Criteria andStreetNameGreaterThanOrEqualTo(String value) {
            addCriterion("STREET_NAME >=", value, "streetName");
            return (Criteria) this;
        }

        public Criteria andStreetNameLessThan(String value) {
            addCriterion("STREET_NAME <", value, "streetName");
            return (Criteria) this;
        }

        public Criteria andStreetNameLessThanOrEqualTo(String value) {
            addCriterion("STREET_NAME <=", value, "streetName");
            return (Criteria) this;
        }

        public Criteria andStreetNameLike(String value) {
            addCriterion("STREET_NAME like", value, "streetName");
            return (Criteria) this;
        }

        public Criteria andStreetNameNotLike(String value) {
            addCriterion("STREET_NAME not like", value, "streetName");
            return (Criteria) this;
        }

        public Criteria andStreetNameIn(List<String> values) {
            addCriterion("STREET_NAME in", values, "streetName");
            return (Criteria) this;
        }

        public Criteria andStreetNameNotIn(List<String> values) {
            addCriterion("STREET_NAME not in", values, "streetName");
            return (Criteria) this;
        }

        public Criteria andStreetNameBetween(String value1, String value2) {
            addCriterion("STREET_NAME between", value1, value2, "streetName");
            return (Criteria) this;
        }

        public Criteria andStreetNameNotBetween(String value1, String value2) {
            addCriterion("STREET_NAME not between", value1, value2, "streetName");
            return (Criteria) this;
        }

        public Criteria andPrecinctidIsNull() {
            addCriterion("PRECINCTID is null");
            return (Criteria) this;
        }

        public Criteria andPrecinctidIsNotNull() {
            addCriterion("PRECINCTID is not null");
            return (Criteria) this;
        }

        public Criteria andPrecinctidEqualTo(Long value) {
            addCriterion("PRECINCTID =", value, "precinctid");
            return (Criteria) this;
        }

        public Criteria andPrecinctidNotEqualTo(Long value) {
            addCriterion("PRECINCTID <>", value, "precinctid");
            return (Criteria) this;
        }

        public Criteria andPrecinctidGreaterThan(Long value) {
            addCriterion("PRECINCTID >", value, "precinctid");
            return (Criteria) this;
        }

        public Criteria andPrecinctidGreaterThanOrEqualTo(Long value) {
            addCriterion("PRECINCTID >=", value, "precinctid");
            return (Criteria) this;
        }

        public Criteria andPrecinctidLessThan(Long value) {
            addCriterion("PRECINCTID <", value, "precinctid");
            return (Criteria) this;
        }

        public Criteria andPrecinctidLessThanOrEqualTo(Long value) {
            addCriterion("PRECINCTID <=", value, "precinctid");
            return (Criteria) this;
        }

        public Criteria andPrecinctidIn(List<Long> values) {
            addCriterion("PRECINCTID in", values, "precinctid");
            return (Criteria) this;
        }

        public Criteria andPrecinctidNotIn(List<Long> values) {
            addCriterion("PRECINCTID not in", values, "precinctid");
            return (Criteria) this;
        }

        public Criteria andPrecinctidBetween(Long value1, Long value2) {
            addCriterion("PRECINCTID between", value1, value2, "precinctid");
            return (Criteria) this;
        }

        public Criteria andPrecinctidNotBetween(Long value1, Long value2) {
            addCriterion("PRECINCTID not between", value1, value2, "precinctid");
            return (Criteria) this;
        }

        public Criteria andPrecinctnameIsNull() {
            addCriterion("PRECINCTNAME is null");
            return (Criteria) this;
        }

        public Criteria andPrecinctnameIsNotNull() {
            addCriterion("PRECINCTNAME is not null");
            return (Criteria) this;
        }

        public Criteria andPrecinctnameEqualTo(String value) {
            addCriterion("PRECINCTNAME =", value, "precinctname");
            return (Criteria) this;
        }

        public Criteria andPrecinctnameNotEqualTo(String value) {
            addCriterion("PRECINCTNAME <>", value, "precinctname");
            return (Criteria) this;
        }

        public Criteria andPrecinctnameGreaterThan(String value) {
            addCriterion("PRECINCTNAME >", value, "precinctname");
            return (Criteria) this;
        }

        public Criteria andPrecinctnameGreaterThanOrEqualTo(String value) {
            addCriterion("PRECINCTNAME >=", value, "precinctname");
            return (Criteria) this;
        }

        public Criteria andPrecinctnameLessThan(String value) {
            addCriterion("PRECINCTNAME <", value, "precinctname");
            return (Criteria) this;
        }

        public Criteria andPrecinctnameLessThanOrEqualTo(String value) {
            addCriterion("PRECINCTNAME <=", value, "precinctname");
            return (Criteria) this;
        }

        public Criteria andPrecinctnameLike(String value) {
            addCriterion("PRECINCTNAME like", value, "precinctname");
            return (Criteria) this;
        }

        public Criteria andPrecinctnameNotLike(String value) {
            addCriterion("PRECINCTNAME not like", value, "precinctname");
            return (Criteria) this;
        }

        public Criteria andPrecinctnameIn(List<String> values) {
            addCriterion("PRECINCTNAME in", values, "precinctname");
            return (Criteria) this;
        }

        public Criteria andPrecinctnameNotIn(List<String> values) {
            addCriterion("PRECINCTNAME not in", values, "precinctname");
            return (Criteria) this;
        }

        public Criteria andPrecinctnameBetween(String value1, String value2) {
            addCriterion("PRECINCTNAME between", value1, value2, "precinctname");
            return (Criteria) this;
        }

        public Criteria andPrecinctnameNotBetween(String value1, String value2) {
            addCriterion("PRECINCTNAME not between", value1, value2, "precinctname");
            return (Criteria) this;
        }

        public Criteria andDistrictidIsNull() {
            addCriterion("DISTRICTID is null");
            return (Criteria) this;
        }

        public Criteria andDistrictidIsNotNull() {
            addCriterion("DISTRICTID is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictidEqualTo(Long value) {
            addCriterion("DISTRICTID =", value, "districtid");
            return (Criteria) this;
        }

        public Criteria andDistrictidNotEqualTo(Long value) {
            addCriterion("DISTRICTID <>", value, "districtid");
            return (Criteria) this;
        }

        public Criteria andDistrictidGreaterThan(Long value) {
            addCriterion("DISTRICTID >", value, "districtid");
            return (Criteria) this;
        }

        public Criteria andDistrictidGreaterThanOrEqualTo(Long value) {
            addCriterion("DISTRICTID >=", value, "districtid");
            return (Criteria) this;
        }

        public Criteria andDistrictidLessThan(Long value) {
            addCriterion("DISTRICTID <", value, "districtid");
            return (Criteria) this;
        }

        public Criteria andDistrictidLessThanOrEqualTo(Long value) {
            addCriterion("DISTRICTID <=", value, "districtid");
            return (Criteria) this;
        }

        public Criteria andDistrictidIn(List<Long> values) {
            addCriterion("DISTRICTID in", values, "districtid");
            return (Criteria) this;
        }

        public Criteria andDistrictidNotIn(List<Long> values) {
            addCriterion("DISTRICTID not in", values, "districtid");
            return (Criteria) this;
        }

        public Criteria andDistrictidBetween(Long value1, Long value2) {
            addCriterion("DISTRICTID between", value1, value2, "districtid");
            return (Criteria) this;
        }

        public Criteria andDistrictidNotBetween(Long value1, Long value2) {
            addCriterion("DISTRICTID not between", value1, value2, "districtid");
            return (Criteria) this;
        }

        public Criteria andDistrictnameIsNull() {
            addCriterion("DISTRICTNAME is null");
            return (Criteria) this;
        }

        public Criteria andDistrictnameIsNotNull() {
            addCriterion("DISTRICTNAME is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictnameEqualTo(String value) {
            addCriterion("DISTRICTNAME =", value, "districtname");
            return (Criteria) this;
        }

        public Criteria andDistrictnameNotEqualTo(String value) {
            addCriterion("DISTRICTNAME <>", value, "districtname");
            return (Criteria) this;
        }

        public Criteria andDistrictnameGreaterThan(String value) {
            addCriterion("DISTRICTNAME >", value, "districtname");
            return (Criteria) this;
        }

        public Criteria andDistrictnameGreaterThanOrEqualTo(String value) {
            addCriterion("DISTRICTNAME >=", value, "districtname");
            return (Criteria) this;
        }

        public Criteria andDistrictnameLessThan(String value) {
            addCriterion("DISTRICTNAME <", value, "districtname");
            return (Criteria) this;
        }

        public Criteria andDistrictnameLessThanOrEqualTo(String value) {
            addCriterion("DISTRICTNAME <=", value, "districtname");
            return (Criteria) this;
        }

        public Criteria andDistrictnameLike(String value) {
            addCriterion("DISTRICTNAME like", value, "districtname");
            return (Criteria) this;
        }

        public Criteria andDistrictnameNotLike(String value) {
            addCriterion("DISTRICTNAME not like", value, "districtname");
            return (Criteria) this;
        }

        public Criteria andDistrictnameIn(List<String> values) {
            addCriterion("DISTRICTNAME in", values, "districtname");
            return (Criteria) this;
        }

        public Criteria andDistrictnameNotIn(List<String> values) {
            addCriterion("DISTRICTNAME not in", values, "districtname");
            return (Criteria) this;
        }

        public Criteria andDistrictnameBetween(String value1, String value2) {
            addCriterion("DISTRICTNAME between", value1, value2, "districtname");
            return (Criteria) this;
        }

        public Criteria andDistrictnameNotBetween(String value1, String value2) {
            addCriterion("DISTRICTNAME not between", value1, value2, "districtname");
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

        public Criteria andUserNameIsNull() {
            addCriterion("USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("USER_NAME =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("USER_NAME <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("USER_NAME >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NAME >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("USER_NAME <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("USER_NAME <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("USER_NAME like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("USER_NAME not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("USER_NAME in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("USER_NAME not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("USER_NAME between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("USER_NAME not between", value1, value2, "userName");
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

        public Criteria andIfagencyIsNull() {
            addCriterion("IFAGENCY is null");
            return (Criteria) this;
        }

        public Criteria andIfagencyIsNotNull() {
            addCriterion("IFAGENCY is not null");
            return (Criteria) this;
        }

        public Criteria andIfagencyEqualTo(String value) {
            addCriterion("IFAGENCY =", value, "ifagency");
            return (Criteria) this;
        }

        public Criteria andIfagencyNotEqualTo(String value) {
            addCriterion("IFAGENCY <>", value, "ifagency");
            return (Criteria) this;
        }

        public Criteria andIfagencyGreaterThan(String value) {
            addCriterion("IFAGENCY >", value, "ifagency");
            return (Criteria) this;
        }

        public Criteria andIfagencyGreaterThanOrEqualTo(String value) {
            addCriterion("IFAGENCY >=", value, "ifagency");
            return (Criteria) this;
        }

        public Criteria andIfagencyLessThan(String value) {
            addCriterion("IFAGENCY <", value, "ifagency");
            return (Criteria) this;
        }

        public Criteria andIfagencyLessThanOrEqualTo(String value) {
            addCriterion("IFAGENCY <=", value, "ifagency");
            return (Criteria) this;
        }

        public Criteria andIfagencyLike(String value) {
            addCriterion("IFAGENCY like", value, "ifagency");
            return (Criteria) this;
        }

        public Criteria andIfagencyNotLike(String value) {
            addCriterion("IFAGENCY not like", value, "ifagency");
            return (Criteria) this;
        }

        public Criteria andIfagencyIn(List<String> values) {
            addCriterion("IFAGENCY in", values, "ifagency");
            return (Criteria) this;
        }

        public Criteria andIfagencyNotIn(List<String> values) {
            addCriterion("IFAGENCY not in", values, "ifagency");
            return (Criteria) this;
        }

        public Criteria andIfagencyBetween(String value1, String value2) {
            addCriterion("IFAGENCY between", value1, value2, "ifagency");
            return (Criteria) this;
        }

        public Criteria andIfagencyNotBetween(String value1, String value2) {
            addCriterion("IFAGENCY not between", value1, value2, "ifagency");
            return (Criteria) this;
        }

        public Criteria andStoreIsNull() {
            addCriterion("STORE is null");
            return (Criteria) this;
        }

        public Criteria andStoreIsNotNull() {
            addCriterion("STORE is not null");
            return (Criteria) this;
        }

        public Criteria andStoreEqualTo(String value) {
            addCriterion("STORE =", value, "store");
            return (Criteria) this;
        }

        public Criteria andStoreNotEqualTo(String value) {
            addCriterion("STORE <>", value, "store");
            return (Criteria) this;
        }

        public Criteria andStoreGreaterThan(String value) {
            addCriterion("STORE >", value, "store");
            return (Criteria) this;
        }

        public Criteria andStoreGreaterThanOrEqualTo(String value) {
            addCriterion("STORE >=", value, "store");
            return (Criteria) this;
        }

        public Criteria andStoreLessThan(String value) {
            addCriterion("STORE <", value, "store");
            return (Criteria) this;
        }

        public Criteria andStoreLessThanOrEqualTo(String value) {
            addCriterion("STORE <=", value, "store");
            return (Criteria) this;
        }

        public Criteria andStoreLike(String value) {
            addCriterion("STORE like", value, "store");
            return (Criteria) this;
        }

        public Criteria andStoreNotLike(String value) {
            addCriterion("STORE not like", value, "store");
            return (Criteria) this;
        }

        public Criteria andStoreIn(List<String> values) {
            addCriterion("STORE in", values, "store");
            return (Criteria) this;
        }

        public Criteria andStoreNotIn(List<String> values) {
            addCriterion("STORE not in", values, "store");
            return (Criteria) this;
        }

        public Criteria andStoreBetween(String value1, String value2) {
            addCriterion("STORE between", value1, value2, "store");
            return (Criteria) this;
        }

        public Criteria andStoreNotBetween(String value1, String value2) {
            addCriterion("STORE not between", value1, value2, "store");
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

        public Criteria andSchoolIsNull() {
            addCriterion("SCHOOL is null");
            return (Criteria) this;
        }

        public Criteria andSchoolIsNotNull() {
            addCriterion("SCHOOL is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolEqualTo(String value) {
            addCriterion("SCHOOL =", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotEqualTo(String value) {
            addCriterion("SCHOOL <>", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThan(String value) {
            addCriterion("SCHOOL >", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("SCHOOL >=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThan(String value) {
            addCriterion("SCHOOL <", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThanOrEqualTo(String value) {
            addCriterion("SCHOOL <=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLike(String value) {
            addCriterion("SCHOOL like", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotLike(String value) {
            addCriterion("SCHOOL not like", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolIn(List<String> values) {
            addCriterion("SCHOOL in", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotIn(List<String> values) {
            addCriterion("SCHOOL not in", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolBetween(String value1, String value2) {
            addCriterion("SCHOOL between", value1, value2, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotBetween(String value1, String value2) {
            addCriterion("SCHOOL not between", value1, value2, "school");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("TITLE is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("TITLE =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("TITLE <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("TITLE >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("TITLE <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("TITLE <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("TITLE like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("TITLE not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("TITLE in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("TITLE not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("TITLE between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("TITLE not between", value1, value2, "title");
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

        public Criteria andStrOrderIsNull() {
            addCriterion("STR_ORDER is null");
            return (Criteria) this;
        }

        public Criteria andStrOrderIsNotNull() {
            addCriterion("STR_ORDER is not null");
            return (Criteria) this;
        }

        public Criteria andStrOrderEqualTo(String value) {
            addCriterion("STR_ORDER =", value, "strOrder");
            return (Criteria) this;
        }

        public Criteria andStrOrderNotEqualTo(String value) {
            addCriterion("STR_ORDER <>", value, "strOrder");
            return (Criteria) this;
        }

        public Criteria andStrOrderGreaterThan(String value) {
            addCriterion("STR_ORDER >", value, "strOrder");
            return (Criteria) this;
        }

        public Criteria andStrOrderGreaterThanOrEqualTo(String value) {
            addCriterion("STR_ORDER >=", value, "strOrder");
            return (Criteria) this;
        }

        public Criteria andStrOrderLessThan(String value) {
            addCriterion("STR_ORDER <", value, "strOrder");
            return (Criteria) this;
        }

        public Criteria andStrOrderLessThanOrEqualTo(String value) {
            addCriterion("STR_ORDER <=", value, "strOrder");
            return (Criteria) this;
        }

        public Criteria andStrOrderLike(String value) {
            addCriterion("STR_ORDER like", value, "strOrder");
            return (Criteria) this;
        }

        public Criteria andStrOrderNotLike(String value) {
            addCriterion("STR_ORDER not like", value, "strOrder");
            return (Criteria) this;
        }

        public Criteria andStrOrderIn(List<String> values) {
            addCriterion("STR_ORDER in", values, "strOrder");
            return (Criteria) this;
        }

        public Criteria andStrOrderNotIn(List<String> values) {
            addCriterion("STR_ORDER not in", values, "strOrder");
            return (Criteria) this;
        }

        public Criteria andStrOrderBetween(String value1, String value2) {
            addCriterion("STR_ORDER between", value1, value2, "strOrder");
            return (Criteria) this;
        }

        public Criteria andStrOrderNotBetween(String value1, String value2) {
            addCriterion("STR_ORDER not between", value1, value2, "strOrder");
            return (Criteria) this;
        }

        public Criteria andHousepictureIsNull() {
            addCriterion("HOUSEPICTURE is null");
            return (Criteria) this;
        }

        public Criteria andHousepictureIsNotNull() {
            addCriterion("HOUSEPICTURE is not null");
            return (Criteria) this;
        }

        public Criteria andHousepictureEqualTo(String value) {
            addCriterion("HOUSEPICTURE =", value, "housepicture");
            return (Criteria) this;
        }

        public Criteria andHousepictureNotEqualTo(String value) {
            addCriterion("HOUSEPICTURE <>", value, "housepicture");
            return (Criteria) this;
        }

        public Criteria andHousepictureGreaterThan(String value) {
            addCriterion("HOUSEPICTURE >", value, "housepicture");
            return (Criteria) this;
        }

        public Criteria andHousepictureGreaterThanOrEqualTo(String value) {
            addCriterion("HOUSEPICTURE >=", value, "housepicture");
            return (Criteria) this;
        }

        public Criteria andHousepictureLessThan(String value) {
            addCriterion("HOUSEPICTURE <", value, "housepicture");
            return (Criteria) this;
        }

        public Criteria andHousepictureLessThanOrEqualTo(String value) {
            addCriterion("HOUSEPICTURE <=", value, "housepicture");
            return (Criteria) this;
        }

        public Criteria andHousepictureLike(String value) {
            addCriterion("HOUSEPICTURE like", value, "housepicture");
            return (Criteria) this;
        }

        public Criteria andHousepictureNotLike(String value) {
            addCriterion("HOUSEPICTURE not like", value, "housepicture");
            return (Criteria) this;
        }

        public Criteria andHousepictureIn(List<String> values) {
            addCriterion("HOUSEPICTURE in", values, "housepicture");
            return (Criteria) this;
        }

        public Criteria andHousepictureNotIn(List<String> values) {
            addCriterion("HOUSEPICTURE not in", values, "housepicture");
            return (Criteria) this;
        }

        public Criteria andHousepictureBetween(String value1, String value2) {
            addCriterion("HOUSEPICTURE between", value1, value2, "housepicture");
            return (Criteria) this;
        }

        public Criteria andHousepictureNotBetween(String value1, String value2) {
            addCriterion("HOUSEPICTURE not between", value1, value2, "housepicture");
            return (Criteria) this;
        }

        public Criteria andIsrealIsNull() {
            addCriterion("ISREAL is null");
            return (Criteria) this;
        }

        public Criteria andIsrealIsNotNull() {
            addCriterion("ISREAL is not null");
            return (Criteria) this;
        }

        public Criteria andIsrealEqualTo(String value) {
            addCriterion("ISREAL =", value, "isreal");
            return (Criteria) this;
        }

        public Criteria andIsrealNotEqualTo(String value) {
            addCriterion("ISREAL <>", value, "isreal");
            return (Criteria) this;
        }

        public Criteria andIsrealGreaterThan(String value) {
            addCriterion("ISREAL >", value, "isreal");
            return (Criteria) this;
        }

        public Criteria andIsrealGreaterThanOrEqualTo(String value) {
            addCriterion("ISREAL >=", value, "isreal");
            return (Criteria) this;
        }

        public Criteria andIsrealLessThan(String value) {
            addCriterion("ISREAL <", value, "isreal");
            return (Criteria) this;
        }

        public Criteria andIsrealLessThanOrEqualTo(String value) {
            addCriterion("ISREAL <=", value, "isreal");
            return (Criteria) this;
        }

        public Criteria andIsrealLike(String value) {
            addCriterion("ISREAL like", value, "isreal");
            return (Criteria) this;
        }

        public Criteria andIsrealNotLike(String value) {
            addCriterion("ISREAL not like", value, "isreal");
            return (Criteria) this;
        }

        public Criteria andIsrealIn(List<String> values) {
            addCriterion("ISREAL in", values, "isreal");
            return (Criteria) this;
        }

        public Criteria andIsrealNotIn(List<String> values) {
            addCriterion("ISREAL not in", values, "isreal");
            return (Criteria) this;
        }

        public Criteria andIsrealBetween(String value1, String value2) {
            addCriterion("ISREAL between", value1, value2, "isreal");
            return (Criteria) this;
        }

        public Criteria andIsrealNotBetween(String value1, String value2) {
            addCriterion("ISREAL not between", value1, value2, "isreal");
            return (Criteria) this;
        }

        public Criteria andSourceurlIsNull() {
            addCriterion("SOURCEURL is null");
            return (Criteria) this;
        }

        public Criteria andSourceurlIsNotNull() {
            addCriterion("SOURCEURL is not null");
            return (Criteria) this;
        }

        public Criteria andSourceurlEqualTo(String value) {
            addCriterion("SOURCEURL =", value, "sourceurl");
            return (Criteria) this;
        }

        public Criteria andSourceurlNotEqualTo(String value) {
            addCriterion("SOURCEURL <>", value, "sourceurl");
            return (Criteria) this;
        }

        public Criteria andSourceurlGreaterThan(String value) {
            addCriterion("SOURCEURL >", value, "sourceurl");
            return (Criteria) this;
        }

        public Criteria andSourceurlGreaterThanOrEqualTo(String value) {
            addCriterion("SOURCEURL >=", value, "sourceurl");
            return (Criteria) this;
        }

        public Criteria andSourceurlLessThan(String value) {
            addCriterion("SOURCEURL <", value, "sourceurl");
            return (Criteria) this;
        }

        public Criteria andSourceurlLessThanOrEqualTo(String value) {
            addCriterion("SOURCEURL <=", value, "sourceurl");
            return (Criteria) this;
        }

        public Criteria andSourceurlLike(String value) {
            addCriterion("SOURCEURL like", value, "sourceurl");
            return (Criteria) this;
        }

        public Criteria andSourceurlNotLike(String value) {
            addCriterion("SOURCEURL not like", value, "sourceurl");
            return (Criteria) this;
        }

        public Criteria andSourceurlIn(List<String> values) {
            addCriterion("SOURCEURL in", values, "sourceurl");
            return (Criteria) this;
        }

        public Criteria andSourceurlNotIn(List<String> values) {
            addCriterion("SOURCEURL not in", values, "sourceurl");
            return (Criteria) this;
        }

        public Criteria andSourceurlBetween(String value1, String value2) {
            addCriterion("SOURCEURL between", value1, value2, "sourceurl");
            return (Criteria) this;
        }

        public Criteria andSourceurlNotBetween(String value1, String value2) {
            addCriterion("SOURCEURL not between", value1, value2, "sourceurl");
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

        public Criteria andIsSaleIsNull() {
            addCriterion("IS_SALE is null");
            return (Criteria) this;
        }

        public Criteria andIsSaleIsNotNull() {
            addCriterion("IS_SALE is not null");
            return (Criteria) this;
        }

        public Criteria andIsSaleEqualTo(BigDecimal value) {
            addCriterion("IS_SALE =", value, "isSale");
            return (Criteria) this;
        }

        public Criteria andIsSaleNotEqualTo(BigDecimal value) {
            addCriterion("IS_SALE <>", value, "isSale");
            return (Criteria) this;
        }

        public Criteria andIsSaleGreaterThan(BigDecimal value) {
            addCriterion("IS_SALE >", value, "isSale");
            return (Criteria) this;
        }

        public Criteria andIsSaleGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("IS_SALE >=", value, "isSale");
            return (Criteria) this;
        }

        public Criteria andIsSaleLessThan(BigDecimal value) {
            addCriterion("IS_SALE <", value, "isSale");
            return (Criteria) this;
        }

        public Criteria andIsSaleLessThanOrEqualTo(BigDecimal value) {
            addCriterion("IS_SALE <=", value, "isSale");
            return (Criteria) this;
        }

        public Criteria andIsSaleIn(List<BigDecimal> values) {
            addCriterion("IS_SALE in", values, "isSale");
            return (Criteria) this;
        }

        public Criteria andIsSaleNotIn(List<BigDecimal> values) {
            addCriterion("IS_SALE not in", values, "isSale");
            return (Criteria) this;
        }

        public Criteria andIsSaleBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IS_SALE between", value1, value2, "isSale");
            return (Criteria) this;
        }

        public Criteria andIsSaleNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IS_SALE not between", value1, value2, "isSale");
            return (Criteria) this;
        }

        public Criteria andIsRentIsNull() {
            addCriterion("IS_RENT is null");
            return (Criteria) this;
        }

        public Criteria andIsRentIsNotNull() {
            addCriterion("IS_RENT is not null");
            return (Criteria) this;
        }

        public Criteria andIsRentEqualTo(BigDecimal value) {
            addCriterion("IS_RENT =", value, "isRent");
            return (Criteria) this;
        }

        public Criteria andIsRentNotEqualTo(BigDecimal value) {
            addCriterion("IS_RENT <>", value, "isRent");
            return (Criteria) this;
        }

        public Criteria andIsRentGreaterThan(BigDecimal value) {
            addCriterion("IS_RENT >", value, "isRent");
            return (Criteria) this;
        }

        public Criteria andIsRentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("IS_RENT >=", value, "isRent");
            return (Criteria) this;
        }

        public Criteria andIsRentLessThan(BigDecimal value) {
            addCriterion("IS_RENT <", value, "isRent");
            return (Criteria) this;
        }

        public Criteria andIsRentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("IS_RENT <=", value, "isRent");
            return (Criteria) this;
        }

        public Criteria andIsRentIn(List<BigDecimal> values) {
            addCriterion("IS_RENT in", values, "isRent");
            return (Criteria) this;
        }

        public Criteria andIsRentNotIn(List<BigDecimal> values) {
            addCriterion("IS_RENT not in", values, "isRent");
            return (Criteria) this;
        }

        public Criteria andIsRentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IS_RENT between", value1, value2, "isRent");
            return (Criteria) this;
        }

        public Criteria andIsRentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IS_RENT not between", value1, value2, "isRent");
            return (Criteria) this;
        }

        public Criteria andIsDealIsNull() {
            addCriterion("IS_DEAL is null");
            return (Criteria) this;
        }

        public Criteria andIsDealIsNotNull() {
            addCriterion("IS_DEAL is not null");
            return (Criteria) this;
        }

        public Criteria andIsDealEqualTo(BigDecimal value) {
            addCriterion("IS_DEAL =", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealNotEqualTo(BigDecimal value) {
            addCriterion("IS_DEAL <>", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealGreaterThan(BigDecimal value) {
            addCriterion("IS_DEAL >", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("IS_DEAL >=", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealLessThan(BigDecimal value) {
            addCriterion("IS_DEAL <", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealLessThanOrEqualTo(BigDecimal value) {
            addCriterion("IS_DEAL <=", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealIn(List<BigDecimal> values) {
            addCriterion("IS_DEAL in", values, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealNotIn(List<BigDecimal> values) {
            addCriterion("IS_DEAL not in", values, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IS_DEAL between", value1, value2, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IS_DEAL not between", value1, value2, "isDeal");
            return (Criteria) this;
        }

        public Criteria andRentTotalpriceIsNull() {
            addCriterion("RENT_TOTALPRICE is null");
            return (Criteria) this;
        }

        public Criteria andRentTotalpriceIsNotNull() {
            addCriterion("RENT_TOTALPRICE is not null");
            return (Criteria) this;
        }

        public Criteria andRentTotalpriceEqualTo(Long value) {
            addCriterion("RENT_TOTALPRICE =", value, "rentTotalprice");
            return (Criteria) this;
        }

        public Criteria andRentTotalpriceNotEqualTo(Long value) {
            addCriterion("RENT_TOTALPRICE <>", value, "rentTotalprice");
            return (Criteria) this;
        }

        public Criteria andRentTotalpriceGreaterThan(Long value) {
            addCriterion("RENT_TOTALPRICE >", value, "rentTotalprice");
            return (Criteria) this;
        }

        public Criteria andRentTotalpriceGreaterThanOrEqualTo(Long value) {
            addCriterion("RENT_TOTALPRICE >=", value, "rentTotalprice");
            return (Criteria) this;
        }

        public Criteria andRentTotalpriceLessThan(Long value) {
            addCriterion("RENT_TOTALPRICE <", value, "rentTotalprice");
            return (Criteria) this;
        }

        public Criteria andRentTotalpriceLessThanOrEqualTo(Long value) {
            addCriterion("RENT_TOTALPRICE <=", value, "rentTotalprice");
            return (Criteria) this;
        }

        public Criteria andRentTotalpriceIn(List<Long> values) {
            addCriterion("RENT_TOTALPRICE in", values, "rentTotalprice");
            return (Criteria) this;
        }

        public Criteria andRentTotalpriceNotIn(List<Long> values) {
            addCriterion("RENT_TOTALPRICE not in", values, "rentTotalprice");
            return (Criteria) this;
        }

        public Criteria andRentTotalpriceBetween(Long value1, Long value2) {
            addCriterion("RENT_TOTALPRICE between", value1, value2, "rentTotalprice");
            return (Criteria) this;
        }

        public Criteria andRentTotalpriceNotBetween(Long value1, Long value2) {
            addCriterion("RENT_TOTALPRICE not between", value1, value2, "rentTotalprice");
            return (Criteria) this;
        }

        public Criteria andRentSqmpriceIsNull() {
            addCriterion("RENT_SQMPRICE is null");
            return (Criteria) this;
        }

        public Criteria andRentSqmpriceIsNotNull() {
            addCriterion("RENT_SQMPRICE is not null");
            return (Criteria) this;
        }

        public Criteria andRentSqmpriceEqualTo(Long value) {
            addCriterion("RENT_SQMPRICE =", value, "rentSqmprice");
            return (Criteria) this;
        }

        public Criteria andRentSqmpriceNotEqualTo(Long value) {
            addCriterion("RENT_SQMPRICE <>", value, "rentSqmprice");
            return (Criteria) this;
        }

        public Criteria andRentSqmpriceGreaterThan(Long value) {
            addCriterion("RENT_SQMPRICE >", value, "rentSqmprice");
            return (Criteria) this;
        }

        public Criteria andRentSqmpriceGreaterThanOrEqualTo(Long value) {
            addCriterion("RENT_SQMPRICE >=", value, "rentSqmprice");
            return (Criteria) this;
        }

        public Criteria andRentSqmpriceLessThan(Long value) {
            addCriterion("RENT_SQMPRICE <", value, "rentSqmprice");
            return (Criteria) this;
        }

        public Criteria andRentSqmpriceLessThanOrEqualTo(Long value) {
            addCriterion("RENT_SQMPRICE <=", value, "rentSqmprice");
            return (Criteria) this;
        }

        public Criteria andRentSqmpriceIn(List<Long> values) {
            addCriterion("RENT_SQMPRICE in", values, "rentSqmprice");
            return (Criteria) this;
        }

        public Criteria andRentSqmpriceNotIn(List<Long> values) {
            addCriterion("RENT_SQMPRICE not in", values, "rentSqmprice");
            return (Criteria) this;
        }

        public Criteria andRentSqmpriceBetween(Long value1, Long value2) {
            addCriterion("RENT_SQMPRICE between", value1, value2, "rentSqmprice");
            return (Criteria) this;
        }

        public Criteria andRentSqmpriceNotBetween(Long value1, Long value2) {
            addCriterion("RENT_SQMPRICE not between", value1, value2, "rentSqmprice");
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

        public Criteria andDealTimeIsNull() {
            addCriterion("DEAL_TIME is null");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNotNull() {
            addCriterion("DEAL_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andDealTimeEqualTo(Date value) {
            addCriterionForJDBCDate("DEAL_TIME =", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("DEAL_TIME <>", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("DEAL_TIME >", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("DEAL_TIME >=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThan(Date value) {
            addCriterionForJDBCDate("DEAL_TIME <", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("DEAL_TIME <=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeIn(List<Date> values) {
            addCriterionForJDBCDate("DEAL_TIME in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("DEAL_TIME not in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("DEAL_TIME between", value1, value2, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("DEAL_TIME not between", value1, value2, "dealTime");
            return (Criteria) this;
        }

        public Criteria andLeaseholdWayIsNull() {
            addCriterion("LEASEHOLD_WAY is null");
            return (Criteria) this;
        }

        public Criteria andLeaseholdWayIsNotNull() {
            addCriterion("LEASEHOLD_WAY is not null");
            return (Criteria) this;
        }

        public Criteria andLeaseholdWayEqualTo(String value) {
            addCriterion("LEASEHOLD_WAY =", value, "leaseholdWay");
            return (Criteria) this;
        }

        public Criteria andLeaseholdWayNotEqualTo(String value) {
            addCriterion("LEASEHOLD_WAY <>", value, "leaseholdWay");
            return (Criteria) this;
        }

        public Criteria andLeaseholdWayGreaterThan(String value) {
            addCriterion("LEASEHOLD_WAY >", value, "leaseholdWay");
            return (Criteria) this;
        }

        public Criteria andLeaseholdWayGreaterThanOrEqualTo(String value) {
            addCriterion("LEASEHOLD_WAY >=", value, "leaseholdWay");
            return (Criteria) this;
        }

        public Criteria andLeaseholdWayLessThan(String value) {
            addCriterion("LEASEHOLD_WAY <", value, "leaseholdWay");
            return (Criteria) this;
        }

        public Criteria andLeaseholdWayLessThanOrEqualTo(String value) {
            addCriterion("LEASEHOLD_WAY <=", value, "leaseholdWay");
            return (Criteria) this;
        }

        public Criteria andLeaseholdWayLike(String value) {
            addCriterion("LEASEHOLD_WAY like", value, "leaseholdWay");
            return (Criteria) this;
        }

        public Criteria andLeaseholdWayNotLike(String value) {
            addCriterion("LEASEHOLD_WAY not like", value, "leaseholdWay");
            return (Criteria) this;
        }

        public Criteria andLeaseholdWayIn(List<String> values) {
            addCriterion("LEASEHOLD_WAY in", values, "leaseholdWay");
            return (Criteria) this;
        }

        public Criteria andLeaseholdWayNotIn(List<String> values) {
            addCriterion("LEASEHOLD_WAY not in", values, "leaseholdWay");
            return (Criteria) this;
        }

        public Criteria andLeaseholdWayBetween(String value1, String value2) {
            addCriterion("LEASEHOLD_WAY between", value1, value2, "leaseholdWay");
            return (Criteria) this;
        }

        public Criteria andLeaseholdWayNotBetween(String value1, String value2) {
            addCriterion("LEASEHOLD_WAY not between", value1, value2, "leaseholdWay");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNull() {
            addCriterion("STORE_ID is null");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNotNull() {
            addCriterion("STORE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andStoreIdEqualTo(String value) {
            addCriterion("STORE_ID =", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotEqualTo(String value) {
            addCriterion("STORE_ID <>", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThan(String value) {
            addCriterion("STORE_ID >", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThanOrEqualTo(String value) {
            addCriterion("STORE_ID >=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThan(String value) {
            addCriterion("STORE_ID <", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThanOrEqualTo(String value) {
            addCriterion("STORE_ID <=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLike(String value) {
            addCriterion("STORE_ID like", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotLike(String value) {
            addCriterion("STORE_ID not like", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdIn(List<String> values) {
            addCriterion("STORE_ID in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotIn(List<String> values) {
            addCriterion("STORE_ID not in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdBetween(String value1, String value2) {
            addCriterion("STORE_ID between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotBetween(String value1, String value2) {
            addCriterion("STORE_ID not between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andAgentIdIsNull() {
            addCriterion("AGENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andAgentIdIsNotNull() {
            addCriterion("AGENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAgentIdEqualTo(String value) {
            addCriterion("AGENT_ID =", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotEqualTo(String value) {
            addCriterion("AGENT_ID <>", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdGreaterThan(String value) {
            addCriterion("AGENT_ID >", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdGreaterThanOrEqualTo(String value) {
            addCriterion("AGENT_ID >=", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdLessThan(String value) {
            addCriterion("AGENT_ID <", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdLessThanOrEqualTo(String value) {
            addCriterion("AGENT_ID <=", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdLike(String value) {
            addCriterion("AGENT_ID like", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotLike(String value) {
            addCriterion("AGENT_ID not like", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdIn(List<String> values) {
            addCriterion("AGENT_ID in", values, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotIn(List<String> values) {
            addCriterion("AGENT_ID not in", values, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdBetween(String value1, String value2) {
            addCriterion("AGENT_ID between", value1, value2, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotBetween(String value1, String value2) {
            addCriterion("AGENT_ID not between", value1, value2, "agentId");
            return (Criteria) this;
        }

        public Criteria andRangeXysIsNull() {
            addCriterion("RANGE_XYS is null");
            return (Criteria) this;
        }

        public Criteria andRangeXysIsNotNull() {
            addCriterion("RANGE_XYS is not null");
            return (Criteria) this;
        }

        public Criteria andRangeXysEqualTo(String value) {
            addCriterion("RANGE_XYS =", value, "rangeXys");
            return (Criteria) this;
        }

        public Criteria andRangeXysNotEqualTo(String value) {
            addCriterion("RANGE_XYS <>", value, "rangeXys");
            return (Criteria) this;
        }

        public Criteria andRangeXysGreaterThan(String value) {
            addCriterion("RANGE_XYS >", value, "rangeXys");
            return (Criteria) this;
        }

        public Criteria andRangeXysGreaterThanOrEqualTo(String value) {
            addCriterion("RANGE_XYS >=", value, "rangeXys");
            return (Criteria) this;
        }

        public Criteria andRangeXysLessThan(String value) {
            addCriterion("RANGE_XYS <", value, "rangeXys");
            return (Criteria) this;
        }

        public Criteria andRangeXysLessThanOrEqualTo(String value) {
            addCriterion("RANGE_XYS <=", value, "rangeXys");
            return (Criteria) this;
        }

        public Criteria andRangeXysLike(String value) {
            addCriterion("RANGE_XYS like", value, "rangeXys");
            return (Criteria) this;
        }

        public Criteria andRangeXysNotLike(String value) {
            addCriterion("RANGE_XYS not like", value, "rangeXys");
            return (Criteria) this;
        }

        public Criteria andRangeXysIn(List<String> values) {
            addCriterion("RANGE_XYS in", values, "rangeXys");
            return (Criteria) this;
        }

        public Criteria andRangeXysNotIn(List<String> values) {
            addCriterion("RANGE_XYS not in", values, "rangeXys");
            return (Criteria) this;
        }

        public Criteria andRangeXysBetween(String value1, String value2) {
            addCriterion("RANGE_XYS between", value1, value2, "rangeXys");
            return (Criteria) this;
        }

        public Criteria andRangeXysNotBetween(String value1, String value2) {
            addCriterion("RANGE_XYS not between", value1, value2, "rangeXys");
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
    }

    /**
     */
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