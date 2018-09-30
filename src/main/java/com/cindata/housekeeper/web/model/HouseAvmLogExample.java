package com.cindata.housekeeper.web.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class HouseAvmLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HouseAvmLogExample() {
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