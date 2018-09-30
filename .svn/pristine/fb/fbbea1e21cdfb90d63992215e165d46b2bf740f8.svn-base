package com.cindata.housekeeper.wx.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class WxUserInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WxUserInfoExample() {
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

        public Criteria andMobileIsNull() {
            addCriterion("MOBILE is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("MOBILE is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(BigDecimal value) {
            addCriterion("MOBILE =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(BigDecimal value) {
            addCriterion("MOBILE <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(BigDecimal value) {
            addCriterion("MOBILE >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MOBILE >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(BigDecimal value) {
            addCriterion("MOBILE <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MOBILE <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<BigDecimal> values) {
            addCriterion("MOBILE in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<BigDecimal> values) {
            addCriterion("MOBILE not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MOBILE between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MOBILE not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andBindIsNull() {
            addCriterion("BIND is null");
            return (Criteria) this;
        }

        public Criteria andBindIsNotNull() {
            addCriterion("BIND is not null");
            return (Criteria) this;
        }

        public Criteria andBindEqualTo(BigDecimal value) {
            addCriterion("BIND =", value, "bind");
            return (Criteria) this;
        }

        public Criteria andBindNotEqualTo(BigDecimal value) {
            addCriterion("BIND <>", value, "bind");
            return (Criteria) this;
        }

        public Criteria andBindGreaterThan(BigDecimal value) {
            addCriterion("BIND >", value, "bind");
            return (Criteria) this;
        }

        public Criteria andBindGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BIND >=", value, "bind");
            return (Criteria) this;
        }

        public Criteria andBindLessThan(BigDecimal value) {
            addCriterion("BIND <", value, "bind");
            return (Criteria) this;
        }

        public Criteria andBindLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BIND <=", value, "bind");
            return (Criteria) this;
        }

        public Criteria andBindIn(List<BigDecimal> values) {
            addCriterion("BIND in", values, "bind");
            return (Criteria) this;
        }

        public Criteria andBindNotIn(List<BigDecimal> values) {
            addCriterion("BIND not in", values, "bind");
            return (Criteria) this;
        }

        public Criteria andBindBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BIND between", value1, value2, "bind");
            return (Criteria) this;
        }

        public Criteria andBindNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BIND not between", value1, value2, "bind");
            return (Criteria) this;
        }

        public Criteria andWxNameIsNull() {
            addCriterion("WX_NAME is null");
            return (Criteria) this;
        }

        public Criteria andWxNameIsNotNull() {
            addCriterion("WX_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andWxNameEqualTo(String value) {
            addCriterion("WX_NAME =", value, "wxName");
            return (Criteria) this;
        }

        public Criteria andWxNameNotEqualTo(String value) {
            addCriterion("WX_NAME <>", value, "wxName");
            return (Criteria) this;
        }

        public Criteria andWxNameGreaterThan(String value) {
            addCriterion("WX_NAME >", value, "wxName");
            return (Criteria) this;
        }

        public Criteria andWxNameGreaterThanOrEqualTo(String value) {
            addCriterion("WX_NAME >=", value, "wxName");
            return (Criteria) this;
        }

        public Criteria andWxNameLessThan(String value) {
            addCriterion("WX_NAME <", value, "wxName");
            return (Criteria) this;
        }

        public Criteria andWxNameLessThanOrEqualTo(String value) {
            addCriterion("WX_NAME <=", value, "wxName");
            return (Criteria) this;
        }

        public Criteria andWxNameLike(String value) {
            addCriterion("WX_NAME like", value, "wxName");
            return (Criteria) this;
        }

        public Criteria andWxNameNotLike(String value) {
            addCriterion("WX_NAME not like", value, "wxName");
            return (Criteria) this;
        }

        public Criteria andWxNameIn(List<String> values) {
            addCriterion("WX_NAME in", values, "wxName");
            return (Criteria) this;
        }

        public Criteria andWxNameNotIn(List<String> values) {
            addCriterion("WX_NAME not in", values, "wxName");
            return (Criteria) this;
        }

        public Criteria andWxNameBetween(String value1, String value2) {
            addCriterion("WX_NAME between", value1, value2, "wxName");
            return (Criteria) this;
        }

        public Criteria andWxNameNotBetween(String value1, String value2) {
            addCriterion("WX_NAME not between", value1, value2, "wxName");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNull() {
            addCriterion("LAST_LOGIN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNotNull() {
            addCriterion("LAST_LOGIN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeEqualTo(Date value) {
            addCriterionForJDBCDate("LAST_LOGIN_TIME =", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("LAST_LOGIN_TIME <>", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("LAST_LOGIN_TIME >", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("LAST_LOGIN_TIME >=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThan(Date value) {
            addCriterionForJDBCDate("LAST_LOGIN_TIME <", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("LAST_LOGIN_TIME <=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIn(List<Date> values) {
            addCriterionForJDBCDate("LAST_LOGIN_TIME in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("LAST_LOGIN_TIME not in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("LAST_LOGIN_TIME between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("LAST_LOGIN_TIME not between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andHeadUrlIsNull() {
            addCriterion("HEAD_URL is null");
            return (Criteria) this;
        }

        public Criteria andHeadUrlIsNotNull() {
            addCriterion("HEAD_URL is not null");
            return (Criteria) this;
        }

        public Criteria andHeadUrlEqualTo(String value) {
            addCriterion("HEAD_URL =", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlNotEqualTo(String value) {
            addCriterion("HEAD_URL <>", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlGreaterThan(String value) {
            addCriterion("HEAD_URL >", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlGreaterThanOrEqualTo(String value) {
            addCriterion("HEAD_URL >=", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlLessThan(String value) {
            addCriterion("HEAD_URL <", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlLessThanOrEqualTo(String value) {
            addCriterion("HEAD_URL <=", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlLike(String value) {
            addCriterion("HEAD_URL like", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlNotLike(String value) {
            addCriterion("HEAD_URL not like", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlIn(List<String> values) {
            addCriterion("HEAD_URL in", values, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlNotIn(List<String> values) {
            addCriterion("HEAD_URL not in", values, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlBetween(String value1, String value2) {
            addCriterion("HEAD_URL between", value1, value2, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlNotBetween(String value1, String value2) {
            addCriterion("HEAD_URL not between", value1, value2, "headUrl");
            return (Criteria) this;
        }

        public Criteria andWxOpenidIsNull() {
            addCriterion("WX_OPENID is null");
            return (Criteria) this;
        }

        public Criteria andWxOpenidIsNotNull() {
            addCriterion("WX_OPENID is not null");
            return (Criteria) this;
        }

        public Criteria andWxOpenidEqualTo(String value) {
            addCriterion("WX_OPENID =", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidNotEqualTo(String value) {
            addCriterion("WX_OPENID <>", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidGreaterThan(String value) {
            addCriterion("WX_OPENID >", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("WX_OPENID >=", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidLessThan(String value) {
            addCriterion("WX_OPENID <", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidLessThanOrEqualTo(String value) {
            addCriterion("WX_OPENID <=", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidLike(String value) {
            addCriterion("WX_OPENID like", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidNotLike(String value) {
            addCriterion("WX_OPENID not like", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidIn(List<String> values) {
            addCriterion("WX_OPENID in", values, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidNotIn(List<String> values) {
            addCriterion("WX_OPENID not in", values, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidBetween(String value1, String value2) {
            addCriterion("WX_OPENID between", value1, value2, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidNotBetween(String value1, String value2) {
            addCriterion("WX_OPENID not between", value1, value2, "wxOpenid");
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

        public Criteria andCountryNameIsNull() {
            addCriterion("COUNTRY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCountryNameIsNotNull() {
            addCriterion("COUNTRY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCountryNameEqualTo(String value) {
            addCriterion("COUNTRY_NAME =", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameNotEqualTo(String value) {
            addCriterion("COUNTRY_NAME <>", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameGreaterThan(String value) {
            addCriterion("COUNTRY_NAME >", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameGreaterThanOrEqualTo(String value) {
            addCriterion("COUNTRY_NAME >=", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameLessThan(String value) {
            addCriterion("COUNTRY_NAME <", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameLessThanOrEqualTo(String value) {
            addCriterion("COUNTRY_NAME <=", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameLike(String value) {
            addCriterion("COUNTRY_NAME like", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameNotLike(String value) {
            addCriterion("COUNTRY_NAME not like", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameIn(List<String> values) {
            addCriterion("COUNTRY_NAME in", values, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameNotIn(List<String> values) {
            addCriterion("COUNTRY_NAME not in", values, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameBetween(String value1, String value2) {
            addCriterion("COUNTRY_NAME between", value1, value2, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameNotBetween(String value1, String value2) {
            addCriterion("COUNTRY_NAME not between", value1, value2, "countryName");
            return (Criteria) this;
        }

        public Criteria andRegIpIsNull() {
            addCriterion("REG_IP is null");
            return (Criteria) this;
        }

        public Criteria andRegIpIsNotNull() {
            addCriterion("REG_IP is not null");
            return (Criteria) this;
        }

        public Criteria andRegIpEqualTo(String value) {
            addCriterion("REG_IP =", value, "regIp");
            return (Criteria) this;
        }

        public Criteria andRegIpNotEqualTo(String value) {
            addCriterion("REG_IP <>", value, "regIp");
            return (Criteria) this;
        }

        public Criteria andRegIpGreaterThan(String value) {
            addCriterion("REG_IP >", value, "regIp");
            return (Criteria) this;
        }

        public Criteria andRegIpGreaterThanOrEqualTo(String value) {
            addCriterion("REG_IP >=", value, "regIp");
            return (Criteria) this;
        }

        public Criteria andRegIpLessThan(String value) {
            addCriterion("REG_IP <", value, "regIp");
            return (Criteria) this;
        }

        public Criteria andRegIpLessThanOrEqualTo(String value) {
            addCriterion("REG_IP <=", value, "regIp");
            return (Criteria) this;
        }

        public Criteria andRegIpLike(String value) {
            addCriterion("REG_IP like", value, "regIp");
            return (Criteria) this;
        }

        public Criteria andRegIpNotLike(String value) {
            addCriterion("REG_IP not like", value, "regIp");
            return (Criteria) this;
        }

        public Criteria andRegIpIn(List<String> values) {
            addCriterion("REG_IP in", values, "regIp");
            return (Criteria) this;
        }

        public Criteria andRegIpNotIn(List<String> values) {
            addCriterion("REG_IP not in", values, "regIp");
            return (Criteria) this;
        }

        public Criteria andRegIpBetween(String value1, String value2) {
            addCriterion("REG_IP between", value1, value2, "regIp");
            return (Criteria) this;
        }

        public Criteria andRegIpNotBetween(String value1, String value2) {
            addCriterion("REG_IP not between", value1, value2, "regIp");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(BigDecimal value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(BigDecimal value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(BigDecimal value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(BigDecimal value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<BigDecimal> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<BigDecimal> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNull() {
            addCriterion("NICKNAME is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("NICKNAME is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("NICKNAME =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("NICKNAME <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("NICKNAME >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("NICKNAME >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("NICKNAME <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("NICKNAME <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("NICKNAME like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("NICKNAME not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("NICKNAME in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("NICKNAME not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("NICKNAME between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("NICKNAME not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNull() {
            addCriterion("REALNAME is null");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNotNull() {
            addCriterion("REALNAME is not null");
            return (Criteria) this;
        }

        public Criteria andRealnameEqualTo(String value) {
            addCriterion("REALNAME =", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotEqualTo(String value) {
            addCriterion("REALNAME <>", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThan(String value) {
            addCriterion("REALNAME >", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThanOrEqualTo(String value) {
            addCriterion("REALNAME >=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThan(String value) {
            addCriterion("REALNAME <", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThanOrEqualTo(String value) {
            addCriterion("REALNAME <=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLike(String value) {
            addCriterion("REALNAME like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotLike(String value) {
            addCriterion("REALNAME not like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameIn(List<String> values) {
            addCriterion("REALNAME in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotIn(List<String> values) {
            addCriterion("REALNAME not in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameBetween(String value1, String value2) {
            addCriterion("REALNAME between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotBetween(String value1, String value2) {
            addCriterion("REALNAME not between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("SEX is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("SEX is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(BigDecimal value) {
            addCriterion("SEX =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(BigDecimal value) {
            addCriterion("SEX <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(BigDecimal value) {
            addCriterion("SEX >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SEX >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(BigDecimal value) {
            addCriterion("SEX <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SEX <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<BigDecimal> values) {
            addCriterion("SEX in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<BigDecimal> values) {
            addCriterion("SEX not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SEX between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SEX not between", value1, value2, "sex");
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

        public Criteria andDistrictIdEqualTo(BigDecimal value) {
            addCriterion("DISTRICT_ID =", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotEqualTo(BigDecimal value) {
            addCriterion("DISTRICT_ID <>", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdGreaterThan(BigDecimal value) {
            addCriterion("DISTRICT_ID >", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DISTRICT_ID >=", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdLessThan(BigDecimal value) {
            addCriterion("DISTRICT_ID <", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DISTRICT_ID <=", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdIn(List<BigDecimal> values) {
            addCriterion("DISTRICT_ID in", values, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotIn(List<BigDecimal> values) {
            addCriterion("DISTRICT_ID not in", values, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DISTRICT_ID between", value1, value2, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotBetween(BigDecimal value1, BigDecimal value2) {
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

        public Criteria andSmsMonthIsNull() {
            addCriterion("SMS_MONTH is null");
            return (Criteria) this;
        }

        public Criteria andSmsMonthIsNotNull() {
            addCriterion("SMS_MONTH is not null");
            return (Criteria) this;
        }

        public Criteria andSmsMonthEqualTo(BigDecimal value) {
            addCriterion("SMS_MONTH =", value, "smsMonth");
            return (Criteria) this;
        }

        public Criteria andSmsMonthNotEqualTo(BigDecimal value) {
            addCriterion("SMS_MONTH <>", value, "smsMonth");
            return (Criteria) this;
        }

        public Criteria andSmsMonthGreaterThan(BigDecimal value) {
            addCriterion("SMS_MONTH >", value, "smsMonth");
            return (Criteria) this;
        }

        public Criteria andSmsMonthGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SMS_MONTH >=", value, "smsMonth");
            return (Criteria) this;
        }

        public Criteria andSmsMonthLessThan(BigDecimal value) {
            addCriterion("SMS_MONTH <", value, "smsMonth");
            return (Criteria) this;
        }

        public Criteria andSmsMonthLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SMS_MONTH <=", value, "smsMonth");
            return (Criteria) this;
        }

        public Criteria andSmsMonthIn(List<BigDecimal> values) {
            addCriterion("SMS_MONTH in", values, "smsMonth");
            return (Criteria) this;
        }

        public Criteria andSmsMonthNotIn(List<BigDecimal> values) {
            addCriterion("SMS_MONTH not in", values, "smsMonth");
            return (Criteria) this;
        }

        public Criteria andSmsMonthBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SMS_MONTH between", value1, value2, "smsMonth");
            return (Criteria) this;
        }

        public Criteria andSmsMonthNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SMS_MONTH not between", value1, value2, "smsMonth");
            return (Criteria) this;
        }

        public Criteria andMessageMonthIsNull() {
            addCriterion("MESSAGE_MONTH is null");
            return (Criteria) this;
        }

        public Criteria andMessageMonthIsNotNull() {
            addCriterion("MESSAGE_MONTH is not null");
            return (Criteria) this;
        }

        public Criteria andMessageMonthEqualTo(BigDecimal value) {
            addCriterion("MESSAGE_MONTH =", value, "messageMonth");
            return (Criteria) this;
        }

        public Criteria andMessageMonthNotEqualTo(BigDecimal value) {
            addCriterion("MESSAGE_MONTH <>", value, "messageMonth");
            return (Criteria) this;
        }

        public Criteria andMessageMonthGreaterThan(BigDecimal value) {
            addCriterion("MESSAGE_MONTH >", value, "messageMonth");
            return (Criteria) this;
        }

        public Criteria andMessageMonthGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MESSAGE_MONTH >=", value, "messageMonth");
            return (Criteria) this;
        }

        public Criteria andMessageMonthLessThan(BigDecimal value) {
            addCriterion("MESSAGE_MONTH <", value, "messageMonth");
            return (Criteria) this;
        }

        public Criteria andMessageMonthLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MESSAGE_MONTH <=", value, "messageMonth");
            return (Criteria) this;
        }

        public Criteria andMessageMonthIn(List<BigDecimal> values) {
            addCriterion("MESSAGE_MONTH in", values, "messageMonth");
            return (Criteria) this;
        }

        public Criteria andMessageMonthNotIn(List<BigDecimal> values) {
            addCriterion("MESSAGE_MONTH not in", values, "messageMonth");
            return (Criteria) this;
        }

        public Criteria andMessageMonthBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MESSAGE_MONTH between", value1, value2, "messageMonth");
            return (Criteria) this;
        }

        public Criteria andMessageMonthNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MESSAGE_MONTH not between", value1, value2, "messageMonth");
            return (Criteria) this;
        }

        public Criteria andSmsRentIsNull() {
            addCriterion("SMS_RENT is null");
            return (Criteria) this;
        }

        public Criteria andSmsRentIsNotNull() {
            addCriterion("SMS_RENT is not null");
            return (Criteria) this;
        }

        public Criteria andSmsRentEqualTo(BigDecimal value) {
            addCriterion("SMS_RENT =", value, "smsRent");
            return (Criteria) this;
        }

        public Criteria andSmsRentNotEqualTo(BigDecimal value) {
            addCriterion("SMS_RENT <>", value, "smsRent");
            return (Criteria) this;
        }

        public Criteria andSmsRentGreaterThan(BigDecimal value) {
            addCriterion("SMS_RENT >", value, "smsRent");
            return (Criteria) this;
        }

        public Criteria andSmsRentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SMS_RENT >=", value, "smsRent");
            return (Criteria) this;
        }

        public Criteria andSmsRentLessThan(BigDecimal value) {
            addCriterion("SMS_RENT <", value, "smsRent");
            return (Criteria) this;
        }

        public Criteria andSmsRentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SMS_RENT <=", value, "smsRent");
            return (Criteria) this;
        }

        public Criteria andSmsRentIn(List<BigDecimal> values) {
            addCriterion("SMS_RENT in", values, "smsRent");
            return (Criteria) this;
        }

        public Criteria andSmsRentNotIn(List<BigDecimal> values) {
            addCriterion("SMS_RENT not in", values, "smsRent");
            return (Criteria) this;
        }

        public Criteria andSmsRentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SMS_RENT between", value1, value2, "smsRent");
            return (Criteria) this;
        }

        public Criteria andSmsRentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SMS_RENT not between", value1, value2, "smsRent");
            return (Criteria) this;
        }

        public Criteria andMessageRentIsNull() {
            addCriterion("MESSAGE_RENT is null");
            return (Criteria) this;
        }

        public Criteria andMessageRentIsNotNull() {
            addCriterion("MESSAGE_RENT is not null");
            return (Criteria) this;
        }

        public Criteria andMessageRentEqualTo(BigDecimal value) {
            addCriterion("MESSAGE_RENT =", value, "messageRent");
            return (Criteria) this;
        }

        public Criteria andMessageRentNotEqualTo(BigDecimal value) {
            addCriterion("MESSAGE_RENT <>", value, "messageRent");
            return (Criteria) this;
        }

        public Criteria andMessageRentGreaterThan(BigDecimal value) {
            addCriterion("MESSAGE_RENT >", value, "messageRent");
            return (Criteria) this;
        }

        public Criteria andMessageRentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MESSAGE_RENT >=", value, "messageRent");
            return (Criteria) this;
        }

        public Criteria andMessageRentLessThan(BigDecimal value) {
            addCriterion("MESSAGE_RENT <", value, "messageRent");
            return (Criteria) this;
        }

        public Criteria andMessageRentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MESSAGE_RENT <=", value, "messageRent");
            return (Criteria) this;
        }

        public Criteria andMessageRentIn(List<BigDecimal> values) {
            addCriterion("MESSAGE_RENT in", values, "messageRent");
            return (Criteria) this;
        }

        public Criteria andMessageRentNotIn(List<BigDecimal> values) {
            addCriterion("MESSAGE_RENT not in", values, "messageRent");
            return (Criteria) this;
        }

        public Criteria andMessageRentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MESSAGE_RENT between", value1, value2, "messageRent");
            return (Criteria) this;
        }

        public Criteria andMessageRentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MESSAGE_RENT not between", value1, value2, "messageRent");
            return (Criteria) this;
        }

        public Criteria andSmsPriceIsNull() {
            addCriterion("SMS_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andSmsPriceIsNotNull() {
            addCriterion("SMS_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andSmsPriceEqualTo(BigDecimal value) {
            addCriterion("SMS_PRICE =", value, "smsPrice");
            return (Criteria) this;
        }

        public Criteria andSmsPriceNotEqualTo(BigDecimal value) {
            addCriterion("SMS_PRICE <>", value, "smsPrice");
            return (Criteria) this;
        }

        public Criteria andSmsPriceGreaterThan(BigDecimal value) {
            addCriterion("SMS_PRICE >", value, "smsPrice");
            return (Criteria) this;
        }

        public Criteria andSmsPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SMS_PRICE >=", value, "smsPrice");
            return (Criteria) this;
        }

        public Criteria andSmsPriceLessThan(BigDecimal value) {
            addCriterion("SMS_PRICE <", value, "smsPrice");
            return (Criteria) this;
        }

        public Criteria andSmsPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SMS_PRICE <=", value, "smsPrice");
            return (Criteria) this;
        }

        public Criteria andSmsPriceIn(List<BigDecimal> values) {
            addCriterion("SMS_PRICE in", values, "smsPrice");
            return (Criteria) this;
        }

        public Criteria andSmsPriceNotIn(List<BigDecimal> values) {
            addCriterion("SMS_PRICE not in", values, "smsPrice");
            return (Criteria) this;
        }

        public Criteria andSmsPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SMS_PRICE between", value1, value2, "smsPrice");
            return (Criteria) this;
        }

        public Criteria andSmsPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SMS_PRICE not between", value1, value2, "smsPrice");
            return (Criteria) this;
        }

        public Criteria andMessagePriceIsNull() {
            addCriterion("MESSAGE_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andMessagePriceIsNotNull() {
            addCriterion("MESSAGE_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andMessagePriceEqualTo(BigDecimal value) {
            addCriterion("MESSAGE_PRICE =", value, "messagePrice");
            return (Criteria) this;
        }

        public Criteria andMessagePriceNotEqualTo(BigDecimal value) {
            addCriterion("MESSAGE_PRICE <>", value, "messagePrice");
            return (Criteria) this;
        }

        public Criteria andMessagePriceGreaterThan(BigDecimal value) {
            addCriterion("MESSAGE_PRICE >", value, "messagePrice");
            return (Criteria) this;
        }

        public Criteria andMessagePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MESSAGE_PRICE >=", value, "messagePrice");
            return (Criteria) this;
        }

        public Criteria andMessagePriceLessThan(BigDecimal value) {
            addCriterion("MESSAGE_PRICE <", value, "messagePrice");
            return (Criteria) this;
        }

        public Criteria andMessagePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MESSAGE_PRICE <=", value, "messagePrice");
            return (Criteria) this;
        }

        public Criteria andMessagePriceIn(List<BigDecimal> values) {
            addCriterion("MESSAGE_PRICE in", values, "messagePrice");
            return (Criteria) this;
        }

        public Criteria andMessagePriceNotIn(List<BigDecimal> values) {
            addCriterion("MESSAGE_PRICE not in", values, "messagePrice");
            return (Criteria) this;
        }

        public Criteria andMessagePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MESSAGE_PRICE between", value1, value2, "messagePrice");
            return (Criteria) this;
        }

        public Criteria andMessagePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MESSAGE_PRICE not between", value1, value2, "messagePrice");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterionForJDBCDate("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATE_TIME not between", value1, value2, "createTime");
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