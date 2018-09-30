package com.cindata.housekeeper.web.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ChangeHomeInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChangeHomeInfoExample() {
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

        public Criteria andStatementidIsNull() {
            addCriterion("STATEMENTID is null");
            return (Criteria) this;
        }

        public Criteria andStatementidIsNotNull() {
            addCriterion("STATEMENTID is not null");
            return (Criteria) this;
        }

        public Criteria andStatementidEqualTo(String value) {
            addCriterion("STATEMENTID =", value, "statementid");
            return (Criteria) this;
        }

        public Criteria andStatementidNotEqualTo(String value) {
            addCriterion("STATEMENTID <>", value, "statementid");
            return (Criteria) this;
        }

        public Criteria andStatementidGreaterThan(String value) {
            addCriterion("STATEMENTID >", value, "statementid");
            return (Criteria) this;
        }

        public Criteria andStatementidGreaterThanOrEqualTo(String value) {
            addCriterion("STATEMENTID >=", value, "statementid");
            return (Criteria) this;
        }

        public Criteria andStatementidLessThan(String value) {
            addCriterion("STATEMENTID <", value, "statementid");
            return (Criteria) this;
        }

        public Criteria andStatementidLessThanOrEqualTo(String value) {
            addCriterion("STATEMENTID <=", value, "statementid");
            return (Criteria) this;
        }

        public Criteria andStatementidLike(String value) {
            addCriterion("STATEMENTID like", value, "statementid");
            return (Criteria) this;
        }

        public Criteria andStatementidNotLike(String value) {
            addCriterion("STATEMENTID not like", value, "statementid");
            return (Criteria) this;
        }

        public Criteria andStatementidIn(List<String> values) {
            addCriterion("STATEMENTID in", values, "statementid");
            return (Criteria) this;
        }

        public Criteria andStatementidNotIn(List<String> values) {
            addCriterion("STATEMENTID not in", values, "statementid");
            return (Criteria) this;
        }

        public Criteria andStatementidBetween(String value1, String value2) {
            addCriterion("STATEMENTID between", value1, value2, "statementid");
            return (Criteria) this;
        }

        public Criteria andStatementidNotBetween(String value1, String value2) {
            addCriterion("STATEMENTID not between", value1, value2, "statementid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("USERID is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("USERID is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("USERID =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("USERID <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("USERID >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("USERID >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("USERID <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("USERID <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("USERID like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("USERID not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("USERID in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("USERID not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("USERID between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("USERID not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andHouseidIsNull() {
            addCriterion("HOUSEID is null");
            return (Criteria) this;
        }

        public Criteria andHouseidIsNotNull() {
            addCriterion("HOUSEID is not null");
            return (Criteria) this;
        }

        public Criteria andHouseidEqualTo(BigDecimal value) {
            addCriterion("HOUSEID =", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidNotEqualTo(BigDecimal value) {
            addCriterion("HOUSEID <>", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidGreaterThan(BigDecimal value) {
            addCriterion("HOUSEID >", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HOUSEID >=", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidLessThan(BigDecimal value) {
            addCriterion("HOUSEID <", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HOUSEID <=", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidIn(List<BigDecimal> values) {
            addCriterion("HOUSEID in", values, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidNotIn(List<BigDecimal> values) {
            addCriterion("HOUSEID not in", values, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOUSEID between", value1, value2, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOUSEID not between", value1, value2, "houseid");
            return (Criteria) this;
        }

        public Criteria andAccessHousePriceIsNull() {
            addCriterion("ACCESS_HOUSE_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andAccessHousePriceIsNotNull() {
            addCriterion("ACCESS_HOUSE_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andAccessHousePriceEqualTo(BigDecimal value) {
            addCriterion("ACCESS_HOUSE_PRICE =", value, "accessHousePrice");
            return (Criteria) this;
        }

        public Criteria andAccessHousePriceNotEqualTo(BigDecimal value) {
            addCriterion("ACCESS_HOUSE_PRICE <>", value, "accessHousePrice");
            return (Criteria) this;
        }

        public Criteria andAccessHousePriceGreaterThan(BigDecimal value) {
            addCriterion("ACCESS_HOUSE_PRICE >", value, "accessHousePrice");
            return (Criteria) this;
        }

        public Criteria andAccessHousePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ACCESS_HOUSE_PRICE >=", value, "accessHousePrice");
            return (Criteria) this;
        }

        public Criteria andAccessHousePriceLessThan(BigDecimal value) {
            addCriterion("ACCESS_HOUSE_PRICE <", value, "accessHousePrice");
            return (Criteria) this;
        }

        public Criteria andAccessHousePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ACCESS_HOUSE_PRICE <=", value, "accessHousePrice");
            return (Criteria) this;
        }

        public Criteria andAccessHousePriceIn(List<BigDecimal> values) {
            addCriterion("ACCESS_HOUSE_PRICE in", values, "accessHousePrice");
            return (Criteria) this;
        }

        public Criteria andAccessHousePriceNotIn(List<BigDecimal> values) {
            addCriterion("ACCESS_HOUSE_PRICE not in", values, "accessHousePrice");
            return (Criteria) this;
        }

        public Criteria andAccessHousePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACCESS_HOUSE_PRICE between", value1, value2, "accessHousePrice");
            return (Criteria) this;
        }

        public Criteria andAccessHousePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACCESS_HOUSE_PRICE not between", value1, value2, "accessHousePrice");
            return (Criteria) this;
        }

        public Criteria andHavePriceIsNull() {
            addCriterion("HAVE_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andHavePriceIsNotNull() {
            addCriterion("HAVE_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andHavePriceEqualTo(String value) {
            addCriterion("HAVE_PRICE =", value, "havePrice");
            return (Criteria) this;
        }

        public Criteria andHavePriceNotEqualTo(String value) {
            addCriterion("HAVE_PRICE <>", value, "havePrice");
            return (Criteria) this;
        }

        public Criteria andHavePriceGreaterThan(String value) {
            addCriterion("HAVE_PRICE >", value, "havePrice");
            return (Criteria) this;
        }

        public Criteria andHavePriceGreaterThanOrEqualTo(String value) {
            addCriterion("HAVE_PRICE >=", value, "havePrice");
            return (Criteria) this;
        }

        public Criteria andHavePriceLessThan(String value) {
            addCriterion("HAVE_PRICE <", value, "havePrice");
            return (Criteria) this;
        }

        public Criteria andHavePriceLessThanOrEqualTo(String value) {
            addCriterion("HAVE_PRICE <=", value, "havePrice");
            return (Criteria) this;
        }

        public Criteria andHavePriceLike(String value) {
            addCriterion("HAVE_PRICE like", value, "havePrice");
            return (Criteria) this;
        }

        public Criteria andHavePriceNotLike(String value) {
            addCriterion("HAVE_PRICE not like", value, "havePrice");
            return (Criteria) this;
        }

        public Criteria andHavePriceIn(List<String> values) {
            addCriterion("HAVE_PRICE in", values, "havePrice");
            return (Criteria) this;
        }

        public Criteria andHavePriceNotIn(List<String> values) {
            addCriterion("HAVE_PRICE not in", values, "havePrice");
            return (Criteria) this;
        }

        public Criteria andHavePriceBetween(String value1, String value2) {
            addCriterion("HAVE_PRICE between", value1, value2, "havePrice");
            return (Criteria) this;
        }

        public Criteria andHavePriceNotBetween(String value1, String value2) {
            addCriterion("HAVE_PRICE not between", value1, value2, "havePrice");
            return (Criteria) this;
        }

        public Criteria andHouseBudgetIsNull() {
            addCriterion("HOUSE_BUDGET is null");
            return (Criteria) this;
        }

        public Criteria andHouseBudgetIsNotNull() {
            addCriterion("HOUSE_BUDGET is not null");
            return (Criteria) this;
        }

        public Criteria andHouseBudgetEqualTo(String value) {
            addCriterion("HOUSE_BUDGET =", value, "houseBudget");
            return (Criteria) this;
        }

        public Criteria andHouseBudgetNotEqualTo(String value) {
            addCriterion("HOUSE_BUDGET <>", value, "houseBudget");
            return (Criteria) this;
        }

        public Criteria andHouseBudgetGreaterThan(String value) {
            addCriterion("HOUSE_BUDGET >", value, "houseBudget");
            return (Criteria) this;
        }

        public Criteria andHouseBudgetGreaterThanOrEqualTo(String value) {
            addCriterion("HOUSE_BUDGET >=", value, "houseBudget");
            return (Criteria) this;
        }

        public Criteria andHouseBudgetLessThan(String value) {
            addCriterion("HOUSE_BUDGET <", value, "houseBudget");
            return (Criteria) this;
        }

        public Criteria andHouseBudgetLessThanOrEqualTo(String value) {
            addCriterion("HOUSE_BUDGET <=", value, "houseBudget");
            return (Criteria) this;
        }

        public Criteria andHouseBudgetLike(String value) {
            addCriterion("HOUSE_BUDGET like", value, "houseBudget");
            return (Criteria) this;
        }

        public Criteria andHouseBudgetNotLike(String value) {
            addCriterion("HOUSE_BUDGET not like", value, "houseBudget");
            return (Criteria) this;
        }

        public Criteria andHouseBudgetIn(List<String> values) {
            addCriterion("HOUSE_BUDGET in", values, "houseBudget");
            return (Criteria) this;
        }

        public Criteria andHouseBudgetNotIn(List<String> values) {
            addCriterion("HOUSE_BUDGET not in", values, "houseBudget");
            return (Criteria) this;
        }

        public Criteria andHouseBudgetBetween(String value1, String value2) {
            addCriterion("HOUSE_BUDGET between", value1, value2, "houseBudget");
            return (Criteria) this;
        }

        public Criteria andHouseBudgetNotBetween(String value1, String value2) {
            addCriterion("HOUSE_BUDGET not between", value1, value2, "houseBudget");
            return (Criteria) this;
        }

        public Criteria andChangeWayIsNull() {
            addCriterion("CHANGE_WAY is null");
            return (Criteria) this;
        }

        public Criteria andChangeWayIsNotNull() {
            addCriterion("CHANGE_WAY is not null");
            return (Criteria) this;
        }

        public Criteria andChangeWayEqualTo(String value) {
            addCriterion("CHANGE_WAY =", value, "changeWay");
            return (Criteria) this;
        }

        public Criteria andChangeWayNotEqualTo(String value) {
            addCriterion("CHANGE_WAY <>", value, "changeWay");
            return (Criteria) this;
        }

        public Criteria andChangeWayGreaterThan(String value) {
            addCriterion("CHANGE_WAY >", value, "changeWay");
            return (Criteria) this;
        }

        public Criteria andChangeWayGreaterThanOrEqualTo(String value) {
            addCriterion("CHANGE_WAY >=", value, "changeWay");
            return (Criteria) this;
        }

        public Criteria andChangeWayLessThan(String value) {
            addCriterion("CHANGE_WAY <", value, "changeWay");
            return (Criteria) this;
        }

        public Criteria andChangeWayLessThanOrEqualTo(String value) {
            addCriterion("CHANGE_WAY <=", value, "changeWay");
            return (Criteria) this;
        }

        public Criteria andChangeWayLike(String value) {
            addCriterion("CHANGE_WAY like", value, "changeWay");
            return (Criteria) this;
        }

        public Criteria andChangeWayNotLike(String value) {
            addCriterion("CHANGE_WAY not like", value, "changeWay");
            return (Criteria) this;
        }

        public Criteria andChangeWayIn(List<String> values) {
            addCriterion("CHANGE_WAY in", values, "changeWay");
            return (Criteria) this;
        }

        public Criteria andChangeWayNotIn(List<String> values) {
            addCriterion("CHANGE_WAY not in", values, "changeWay");
            return (Criteria) this;
        }

        public Criteria andChangeWayBetween(String value1, String value2) {
            addCriterion("CHANGE_WAY between", value1, value2, "changeWay");
            return (Criteria) this;
        }

        public Criteria andChangeWayNotBetween(String value1, String value2) {
            addCriterion("CHANGE_WAY not between", value1, value2, "changeWay");
            return (Criteria) this;
        }

        public Criteria andAccessTimeIsNull() {
            addCriterion("ACCESS_TIME is null");
            return (Criteria) this;
        }

        public Criteria andAccessTimeIsNotNull() {
            addCriterion("ACCESS_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andAccessTimeEqualTo(Date value) {
            addCriterionForJDBCDate("ACCESS_TIME =", value, "accessTime");
            return (Criteria) this;
        }

        public Criteria andAccessTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("ACCESS_TIME <>", value, "accessTime");
            return (Criteria) this;
        }

        public Criteria andAccessTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("ACCESS_TIME >", value, "accessTime");
            return (Criteria) this;
        }

        public Criteria andAccessTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ACCESS_TIME >=", value, "accessTime");
            return (Criteria) this;
        }

        public Criteria andAccessTimeLessThan(Date value) {
            addCriterionForJDBCDate("ACCESS_TIME <", value, "accessTime");
            return (Criteria) this;
        }

        public Criteria andAccessTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ACCESS_TIME <=", value, "accessTime");
            return (Criteria) this;
        }

        public Criteria andAccessTimeIn(List<Date> values) {
            addCriterionForJDBCDate("ACCESS_TIME in", values, "accessTime");
            return (Criteria) this;
        }

        public Criteria andAccessTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("ACCESS_TIME not in", values, "accessTime");
            return (Criteria) this;
        }

        public Criteria andAccessTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ACCESS_TIME between", value1, value2, "accessTime");
            return (Criteria) this;
        }

        public Criteria andAccessTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ACCESS_TIME not between", value1, value2, "accessTime");
            return (Criteria) this;
        }

        public Criteria andTotlePriceIsNull() {
            addCriterion("TOTLE_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andTotlePriceIsNotNull() {
            addCriterion("TOTLE_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andTotlePriceEqualTo(BigDecimal value) {
            addCriterion("TOTLE_PRICE =", value, "totlePrice");
            return (Criteria) this;
        }

        public Criteria andTotlePriceNotEqualTo(BigDecimal value) {
            addCriterion("TOTLE_PRICE <>", value, "totlePrice");
            return (Criteria) this;
        }

        public Criteria andTotlePriceGreaterThan(BigDecimal value) {
            addCriterion("TOTLE_PRICE >", value, "totlePrice");
            return (Criteria) this;
        }

        public Criteria andTotlePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTLE_PRICE >=", value, "totlePrice");
            return (Criteria) this;
        }

        public Criteria andTotlePriceLessThan(BigDecimal value) {
            addCriterion("TOTLE_PRICE <", value, "totlePrice");
            return (Criteria) this;
        }

        public Criteria andTotlePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTLE_PRICE <=", value, "totlePrice");
            return (Criteria) this;
        }

        public Criteria andTotlePriceIn(List<BigDecimal> values) {
            addCriterion("TOTLE_PRICE in", values, "totlePrice");
            return (Criteria) this;
        }

        public Criteria andTotlePriceNotIn(List<BigDecimal> values) {
            addCriterion("TOTLE_PRICE not in", values, "totlePrice");
            return (Criteria) this;
        }

        public Criteria andTotlePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTLE_PRICE between", value1, value2, "totlePrice");
            return (Criteria) this;
        }

        public Criteria andTotlePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTLE_PRICE not between", value1, value2, "totlePrice");
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

        public Criteria andIntentionalMaxAreaIsNull() {
            addCriterion("INTENTIONAL_MAX_AREA is null");
            return (Criteria) this;
        }

        public Criteria andIntentionalMaxAreaIsNotNull() {
            addCriterion("INTENTIONAL_MAX_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andIntentionalMaxAreaEqualTo(String value) {
            addCriterion("INTENTIONAL_MAX_AREA =", value, "intentionalMaxArea");
            return (Criteria) this;
        }

        public Criteria andIntentionalMaxAreaNotEqualTo(String value) {
            addCriterion("INTENTIONAL_MAX_AREA <>", value, "intentionalMaxArea");
            return (Criteria) this;
        }

        public Criteria andIntentionalMaxAreaGreaterThan(String value) {
            addCriterion("INTENTIONAL_MAX_AREA >", value, "intentionalMaxArea");
            return (Criteria) this;
        }

        public Criteria andIntentionalMaxAreaGreaterThanOrEqualTo(String value) {
            addCriterion("INTENTIONAL_MAX_AREA >=", value, "intentionalMaxArea");
            return (Criteria) this;
        }

        public Criteria andIntentionalMaxAreaLessThan(String value) {
            addCriterion("INTENTIONAL_MAX_AREA <", value, "intentionalMaxArea");
            return (Criteria) this;
        }

        public Criteria andIntentionalMaxAreaLessThanOrEqualTo(String value) {
            addCriterion("INTENTIONAL_MAX_AREA <=", value, "intentionalMaxArea");
            return (Criteria) this;
        }

        public Criteria andIntentionalMaxAreaLike(String value) {
            addCriterion("INTENTIONAL_MAX_AREA like", value, "intentionalMaxArea");
            return (Criteria) this;
        }

        public Criteria andIntentionalMaxAreaNotLike(String value) {
            addCriterion("INTENTIONAL_MAX_AREA not like", value, "intentionalMaxArea");
            return (Criteria) this;
        }

        public Criteria andIntentionalMaxAreaIn(List<String> values) {
            addCriterion("INTENTIONAL_MAX_AREA in", values, "intentionalMaxArea");
            return (Criteria) this;
        }

        public Criteria andIntentionalMaxAreaNotIn(List<String> values) {
            addCriterion("INTENTIONAL_MAX_AREA not in", values, "intentionalMaxArea");
            return (Criteria) this;
        }

        public Criteria andIntentionalMaxAreaBetween(String value1, String value2) {
            addCriterion("INTENTIONAL_MAX_AREA between", value1, value2, "intentionalMaxArea");
            return (Criteria) this;
        }

        public Criteria andIntentionalMaxAreaNotBetween(String value1, String value2) {
            addCriterion("INTENTIONAL_MAX_AREA not between", value1, value2, "intentionalMaxArea");
            return (Criteria) this;
        }

        public Criteria andIntentionalMinAreaIsNull() {
            addCriterion("INTENTIONAL_MIN_AREA is null");
            return (Criteria) this;
        }

        public Criteria andIntentionalMinAreaIsNotNull() {
            addCriterion("INTENTIONAL_MIN_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andIntentionalMinAreaEqualTo(String value) {
            addCriterion("INTENTIONAL_MIN_AREA =", value, "intentionalMinArea");
            return (Criteria) this;
        }

        public Criteria andIntentionalMinAreaNotEqualTo(String value) {
            addCriterion("INTENTIONAL_MIN_AREA <>", value, "intentionalMinArea");
            return (Criteria) this;
        }

        public Criteria andIntentionalMinAreaGreaterThan(String value) {
            addCriterion("INTENTIONAL_MIN_AREA >", value, "intentionalMinArea");
            return (Criteria) this;
        }

        public Criteria andIntentionalMinAreaGreaterThanOrEqualTo(String value) {
            addCriterion("INTENTIONAL_MIN_AREA >=", value, "intentionalMinArea");
            return (Criteria) this;
        }

        public Criteria andIntentionalMinAreaLessThan(String value) {
            addCriterion("INTENTIONAL_MIN_AREA <", value, "intentionalMinArea");
            return (Criteria) this;
        }

        public Criteria andIntentionalMinAreaLessThanOrEqualTo(String value) {
            addCriterion("INTENTIONAL_MIN_AREA <=", value, "intentionalMinArea");
            return (Criteria) this;
        }

        public Criteria andIntentionalMinAreaLike(String value) {
            addCriterion("INTENTIONAL_MIN_AREA like", value, "intentionalMinArea");
            return (Criteria) this;
        }

        public Criteria andIntentionalMinAreaNotLike(String value) {
            addCriterion("INTENTIONAL_MIN_AREA not like", value, "intentionalMinArea");
            return (Criteria) this;
        }

        public Criteria andIntentionalMinAreaIn(List<String> values) {
            addCriterion("INTENTIONAL_MIN_AREA in", values, "intentionalMinArea");
            return (Criteria) this;
        }

        public Criteria andIntentionalMinAreaNotIn(List<String> values) {
            addCriterion("INTENTIONAL_MIN_AREA not in", values, "intentionalMinArea");
            return (Criteria) this;
        }

        public Criteria andIntentionalMinAreaBetween(String value1, String value2) {
            addCriterion("INTENTIONAL_MIN_AREA between", value1, value2, "intentionalMinArea");
            return (Criteria) this;
        }

        public Criteria andIntentionalMinAreaNotBetween(String value1, String value2) {
            addCriterion("INTENTIONAL_MIN_AREA not between", value1, value2, "intentionalMinArea");
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