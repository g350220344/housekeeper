package com.cindata.housekeeper.wx.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class WxPaymentLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WxPaymentLogExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("ORDER_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("ORDER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("ORDER_ID =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("ORDER_ID <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("ORDER_ID >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_ID >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("ORDER_ID <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("ORDER_ID <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("ORDER_ID like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("ORDER_ID not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("ORDER_ID in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("ORDER_ID not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("ORDER_ID between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("ORDER_ID not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNull() {
            addCriterion("GOODS_ID is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("GOODS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(BigDecimal value) {
            addCriterion("GOODS_ID =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(BigDecimal value) {
            addCriterion("GOODS_ID <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(BigDecimal value) {
            addCriterion("GOODS_ID >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("GOODS_ID >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(BigDecimal value) {
            addCriterion("GOODS_ID <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("GOODS_ID <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<BigDecimal> values) {
            addCriterion("GOODS_ID in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<BigDecimal> values) {
            addCriterion("GOODS_ID not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GOODS_ID between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GOODS_ID not between", value1, value2, "goodsId");
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

        public Criteria andStatusEqualTo(BigDecimal value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(BigDecimal value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(BigDecimal value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(BigDecimal value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<BigDecimal> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<BigDecimal> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andPutDataIsNull() {
            addCriterion("PUT_DATA is null");
            return (Criteria) this;
        }

        public Criteria andPutDataIsNotNull() {
            addCriterion("PUT_DATA is not null");
            return (Criteria) this;
        }

        public Criteria andPutDataEqualTo(String value) {
            addCriterion("PUT_DATA =", value, "putData");
            return (Criteria) this;
        }

        public Criteria andPutDataNotEqualTo(String value) {
            addCriterion("PUT_DATA <>", value, "putData");
            return (Criteria) this;
        }

        public Criteria andPutDataGreaterThan(String value) {
            addCriterion("PUT_DATA >", value, "putData");
            return (Criteria) this;
        }

        public Criteria andPutDataGreaterThanOrEqualTo(String value) {
            addCriterion("PUT_DATA >=", value, "putData");
            return (Criteria) this;
        }

        public Criteria andPutDataLessThan(String value) {
            addCriterion("PUT_DATA <", value, "putData");
            return (Criteria) this;
        }

        public Criteria andPutDataLessThanOrEqualTo(String value) {
            addCriterion("PUT_DATA <=", value, "putData");
            return (Criteria) this;
        }

        public Criteria andPutDataLike(String value) {
            addCriterion("PUT_DATA like", value, "putData");
            return (Criteria) this;
        }

        public Criteria andPutDataNotLike(String value) {
            addCriterion("PUT_DATA not like", value, "putData");
            return (Criteria) this;
        }

        public Criteria andPutDataIn(List<String> values) {
            addCriterion("PUT_DATA in", values, "putData");
            return (Criteria) this;
        }

        public Criteria andPutDataNotIn(List<String> values) {
            addCriterion("PUT_DATA not in", values, "putData");
            return (Criteria) this;
        }

        public Criteria andPutDataBetween(String value1, String value2) {
            addCriterion("PUT_DATA between", value1, value2, "putData");
            return (Criteria) this;
        }

        public Criteria andPutDataNotBetween(String value1, String value2) {
            addCriterion("PUT_DATA not between", value1, value2, "putData");
            return (Criteria) this;
        }

        public Criteria andGetDataIsNull() {
            addCriterion("GET_DATA is null");
            return (Criteria) this;
        }

        public Criteria andGetDataIsNotNull() {
            addCriterion("GET_DATA is not null");
            return (Criteria) this;
        }

        public Criteria andGetDataEqualTo(String value) {
            addCriterion("GET_DATA =", value, "getData");
            return (Criteria) this;
        }

        public Criteria andGetDataNotEqualTo(String value) {
            addCriterion("GET_DATA <>", value, "getData");
            return (Criteria) this;
        }

        public Criteria andGetDataGreaterThan(String value) {
            addCriterion("GET_DATA >", value, "getData");
            return (Criteria) this;
        }

        public Criteria andGetDataGreaterThanOrEqualTo(String value) {
            addCriterion("GET_DATA >=", value, "getData");
            return (Criteria) this;
        }

        public Criteria andGetDataLessThan(String value) {
            addCriterion("GET_DATA <", value, "getData");
            return (Criteria) this;
        }

        public Criteria andGetDataLessThanOrEqualTo(String value) {
            addCriterion("GET_DATA <=", value, "getData");
            return (Criteria) this;
        }

        public Criteria andGetDataLike(String value) {
            addCriterion("GET_DATA like", value, "getData");
            return (Criteria) this;
        }

        public Criteria andGetDataNotLike(String value) {
            addCriterion("GET_DATA not like", value, "getData");
            return (Criteria) this;
        }

        public Criteria andGetDataIn(List<String> values) {
            addCriterion("GET_DATA in", values, "getData");
            return (Criteria) this;
        }

        public Criteria andGetDataNotIn(List<String> values) {
            addCriterion("GET_DATA not in", values, "getData");
            return (Criteria) this;
        }

        public Criteria andGetDataBetween(String value1, String value2) {
            addCriterion("GET_DATA between", value1, value2, "getData");
            return (Criteria) this;
        }

        public Criteria andGetDataNotBetween(String value1, String value2) {
            addCriterion("GET_DATA not between", value1, value2, "getData");
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

        public Criteria andIpIsNull() {
            addCriterion("IP is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("IP is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("IP =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("IP <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("IP >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("IP >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("IP <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("IP <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("IP like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("IP not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("IP in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("IP not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("IP between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("IP not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andCol1IsNull() {
            addCriterion("COL1 is null");
            return (Criteria) this;
        }

        public Criteria andCol1IsNotNull() {
            addCriterion("COL1 is not null");
            return (Criteria) this;
        }

        public Criteria andCol1EqualTo(String value) {
            addCriterion("COL1 =", value, "col1");
            return (Criteria) this;
        }

        public Criteria andCol1NotEqualTo(String value) {
            addCriterion("COL1 <>", value, "col1");
            return (Criteria) this;
        }

        public Criteria andCol1GreaterThan(String value) {
            addCriterion("COL1 >", value, "col1");
            return (Criteria) this;
        }

        public Criteria andCol1GreaterThanOrEqualTo(String value) {
            addCriterion("COL1 >=", value, "col1");
            return (Criteria) this;
        }

        public Criteria andCol1LessThan(String value) {
            addCriterion("COL1 <", value, "col1");
            return (Criteria) this;
        }

        public Criteria andCol1LessThanOrEqualTo(String value) {
            addCriterion("COL1 <=", value, "col1");
            return (Criteria) this;
        }

        public Criteria andCol1Like(String value) {
            addCriterion("COL1 like", value, "col1");
            return (Criteria) this;
        }

        public Criteria andCol1NotLike(String value) {
            addCriterion("COL1 not like", value, "col1");
            return (Criteria) this;
        }

        public Criteria andCol1In(List<String> values) {
            addCriterion("COL1 in", values, "col1");
            return (Criteria) this;
        }

        public Criteria andCol1NotIn(List<String> values) {
            addCriterion("COL1 not in", values, "col1");
            return (Criteria) this;
        }

        public Criteria andCol1Between(String value1, String value2) {
            addCriterion("COL1 between", value1, value2, "col1");
            return (Criteria) this;
        }

        public Criteria andCol1NotBetween(String value1, String value2) {
            addCriterion("COL1 not between", value1, value2, "col1");
            return (Criteria) this;
        }

        public Criteria andCol2IsNull() {
            addCriterion("COL2 is null");
            return (Criteria) this;
        }

        public Criteria andCol2IsNotNull() {
            addCriterion("COL2 is not null");
            return (Criteria) this;
        }

        public Criteria andCol2EqualTo(String value) {
            addCriterion("COL2 =", value, "col2");
            return (Criteria) this;
        }

        public Criteria andCol2NotEqualTo(String value) {
            addCriterion("COL2 <>", value, "col2");
            return (Criteria) this;
        }

        public Criteria andCol2GreaterThan(String value) {
            addCriterion("COL2 >", value, "col2");
            return (Criteria) this;
        }

        public Criteria andCol2GreaterThanOrEqualTo(String value) {
            addCriterion("COL2 >=", value, "col2");
            return (Criteria) this;
        }

        public Criteria andCol2LessThan(String value) {
            addCriterion("COL2 <", value, "col2");
            return (Criteria) this;
        }

        public Criteria andCol2LessThanOrEqualTo(String value) {
            addCriterion("COL2 <=", value, "col2");
            return (Criteria) this;
        }

        public Criteria andCol2Like(String value) {
            addCriterion("COL2 like", value, "col2");
            return (Criteria) this;
        }

        public Criteria andCol2NotLike(String value) {
            addCriterion("COL2 not like", value, "col2");
            return (Criteria) this;
        }

        public Criteria andCol2In(List<String> values) {
            addCriterion("COL2 in", values, "col2");
            return (Criteria) this;
        }

        public Criteria andCol2NotIn(List<String> values) {
            addCriterion("COL2 not in", values, "col2");
            return (Criteria) this;
        }

        public Criteria andCol2Between(String value1, String value2) {
            addCriterion("COL2 between", value1, value2, "col2");
            return (Criteria) this;
        }

        public Criteria andCol2NotBetween(String value1, String value2) {
            addCriterion("COL2 not between", value1, value2, "col2");
            return (Criteria) this;
        }

        public Criteria andCol3IsNull() {
            addCriterion("COL3 is null");
            return (Criteria) this;
        }

        public Criteria andCol3IsNotNull() {
            addCriterion("COL3 is not null");
            return (Criteria) this;
        }

        public Criteria andCol3EqualTo(String value) {
            addCriterion("COL3 =", value, "col3");
            return (Criteria) this;
        }

        public Criteria andCol3NotEqualTo(String value) {
            addCriterion("COL3 <>", value, "col3");
            return (Criteria) this;
        }

        public Criteria andCol3GreaterThan(String value) {
            addCriterion("COL3 >", value, "col3");
            return (Criteria) this;
        }

        public Criteria andCol3GreaterThanOrEqualTo(String value) {
            addCriterion("COL3 >=", value, "col3");
            return (Criteria) this;
        }

        public Criteria andCol3LessThan(String value) {
            addCriterion("COL3 <", value, "col3");
            return (Criteria) this;
        }

        public Criteria andCol3LessThanOrEqualTo(String value) {
            addCriterion("COL3 <=", value, "col3");
            return (Criteria) this;
        }

        public Criteria andCol3Like(String value) {
            addCriterion("COL3 like", value, "col3");
            return (Criteria) this;
        }

        public Criteria andCol3NotLike(String value) {
            addCriterion("COL3 not like", value, "col3");
            return (Criteria) this;
        }

        public Criteria andCol3In(List<String> values) {
            addCriterion("COL3 in", values, "col3");
            return (Criteria) this;
        }

        public Criteria andCol3NotIn(List<String> values) {
            addCriterion("COL3 not in", values, "col3");
            return (Criteria) this;
        }

        public Criteria andCol3Between(String value1, String value2) {
            addCriterion("COL3 between", value1, value2, "col3");
            return (Criteria) this;
        }

        public Criteria andCol3NotBetween(String value1, String value2) {
            addCriterion("COL3 not between", value1, value2, "col3");
            return (Criteria) this;
        }

        public Criteria andCol4IsNull() {
            addCriterion("COL4 is null");
            return (Criteria) this;
        }

        public Criteria andCol4IsNotNull() {
            addCriterion("COL4 is not null");
            return (Criteria) this;
        }

        public Criteria andCol4EqualTo(String value) {
            addCriterion("COL4 =", value, "col4");
            return (Criteria) this;
        }

        public Criteria andCol4NotEqualTo(String value) {
            addCriterion("COL4 <>", value, "col4");
            return (Criteria) this;
        }

        public Criteria andCol4GreaterThan(String value) {
            addCriterion("COL4 >", value, "col4");
            return (Criteria) this;
        }

        public Criteria andCol4GreaterThanOrEqualTo(String value) {
            addCriterion("COL4 >=", value, "col4");
            return (Criteria) this;
        }

        public Criteria andCol4LessThan(String value) {
            addCriterion("COL4 <", value, "col4");
            return (Criteria) this;
        }

        public Criteria andCol4LessThanOrEqualTo(String value) {
            addCriterion("COL4 <=", value, "col4");
            return (Criteria) this;
        }

        public Criteria andCol4Like(String value) {
            addCriterion("COL4 like", value, "col4");
            return (Criteria) this;
        }

        public Criteria andCol4NotLike(String value) {
            addCriterion("COL4 not like", value, "col4");
            return (Criteria) this;
        }

        public Criteria andCol4In(List<String> values) {
            addCriterion("COL4 in", values, "col4");
            return (Criteria) this;
        }

        public Criteria andCol4NotIn(List<String> values) {
            addCriterion("COL4 not in", values, "col4");
            return (Criteria) this;
        }

        public Criteria andCol4Between(String value1, String value2) {
            addCriterion("COL4 between", value1, value2, "col4");
            return (Criteria) this;
        }

        public Criteria andCol4NotBetween(String value1, String value2) {
            addCriterion("COL4 not between", value1, value2, "col4");
            return (Criteria) this;
        }

        public Criteria andCol5IsNull() {
            addCriterion("COL5 is null");
            return (Criteria) this;
        }

        public Criteria andCol5IsNotNull() {
            addCriterion("COL5 is not null");
            return (Criteria) this;
        }

        public Criteria andCol5EqualTo(String value) {
            addCriterion("COL5 =", value, "col5");
            return (Criteria) this;
        }

        public Criteria andCol5NotEqualTo(String value) {
            addCriterion("COL5 <>", value, "col5");
            return (Criteria) this;
        }

        public Criteria andCol5GreaterThan(String value) {
            addCriterion("COL5 >", value, "col5");
            return (Criteria) this;
        }

        public Criteria andCol5GreaterThanOrEqualTo(String value) {
            addCriterion("COL5 >=", value, "col5");
            return (Criteria) this;
        }

        public Criteria andCol5LessThan(String value) {
            addCriterion("COL5 <", value, "col5");
            return (Criteria) this;
        }

        public Criteria andCol5LessThanOrEqualTo(String value) {
            addCriterion("COL5 <=", value, "col5");
            return (Criteria) this;
        }

        public Criteria andCol5Like(String value) {
            addCriterion("COL5 like", value, "col5");
            return (Criteria) this;
        }

        public Criteria andCol5NotLike(String value) {
            addCriterion("COL5 not like", value, "col5");
            return (Criteria) this;
        }

        public Criteria andCol5In(List<String> values) {
            addCriterion("COL5 in", values, "col5");
            return (Criteria) this;
        }

        public Criteria andCol5NotIn(List<String> values) {
            addCriterion("COL5 not in", values, "col5");
            return (Criteria) this;
        }

        public Criteria andCol5Between(String value1, String value2) {
            addCriterion("COL5 between", value1, value2, "col5");
            return (Criteria) this;
        }

        public Criteria andCol5NotBetween(String value1, String value2) {
            addCriterion("COL5 not between", value1, value2, "col5");
            return (Criteria) this;
        }

        public Criteria andCol6IsNull() {
            addCriterion("COL6 is null");
            return (Criteria) this;
        }

        public Criteria andCol6IsNotNull() {
            addCriterion("COL6 is not null");
            return (Criteria) this;
        }

        public Criteria andCol6EqualTo(String value) {
            addCriterion("COL6 =", value, "col6");
            return (Criteria) this;
        }

        public Criteria andCol6NotEqualTo(String value) {
            addCriterion("COL6 <>", value, "col6");
            return (Criteria) this;
        }

        public Criteria andCol6GreaterThan(String value) {
            addCriterion("COL6 >", value, "col6");
            return (Criteria) this;
        }

        public Criteria andCol6GreaterThanOrEqualTo(String value) {
            addCriterion("COL6 >=", value, "col6");
            return (Criteria) this;
        }

        public Criteria andCol6LessThan(String value) {
            addCriterion("COL6 <", value, "col6");
            return (Criteria) this;
        }

        public Criteria andCol6LessThanOrEqualTo(String value) {
            addCriterion("COL6 <=", value, "col6");
            return (Criteria) this;
        }

        public Criteria andCol6Like(String value) {
            addCriterion("COL6 like", value, "col6");
            return (Criteria) this;
        }

        public Criteria andCol6NotLike(String value) {
            addCriterion("COL6 not like", value, "col6");
            return (Criteria) this;
        }

        public Criteria andCol6In(List<String> values) {
            addCriterion("COL6 in", values, "col6");
            return (Criteria) this;
        }

        public Criteria andCol6NotIn(List<String> values) {
            addCriterion("COL6 not in", values, "col6");
            return (Criteria) this;
        }

        public Criteria andCol6Between(String value1, String value2) {
            addCriterion("COL6 between", value1, value2, "col6");
            return (Criteria) this;
        }

        public Criteria andCol6NotBetween(String value1, String value2) {
            addCriterion("COL6 not between", value1, value2, "col6");
            return (Criteria) this;
        }

        public Criteria andRetcodeIsNull() {
            addCriterion("RETCODE is null");
            return (Criteria) this;
        }

        public Criteria andRetcodeIsNotNull() {
            addCriterion("RETCODE is not null");
            return (Criteria) this;
        }

        public Criteria andRetcodeEqualTo(String value) {
            addCriterion("RETCODE =", value, "retcode");
            return (Criteria) this;
        }

        public Criteria andRetcodeNotEqualTo(String value) {
            addCriterion("RETCODE <>", value, "retcode");
            return (Criteria) this;
        }

        public Criteria andRetcodeGreaterThan(String value) {
            addCriterion("RETCODE >", value, "retcode");
            return (Criteria) this;
        }

        public Criteria andRetcodeGreaterThanOrEqualTo(String value) {
            addCriterion("RETCODE >=", value, "retcode");
            return (Criteria) this;
        }

        public Criteria andRetcodeLessThan(String value) {
            addCriterion("RETCODE <", value, "retcode");
            return (Criteria) this;
        }

        public Criteria andRetcodeLessThanOrEqualTo(String value) {
            addCriterion("RETCODE <=", value, "retcode");
            return (Criteria) this;
        }

        public Criteria andRetcodeLike(String value) {
            addCriterion("RETCODE like", value, "retcode");
            return (Criteria) this;
        }

        public Criteria andRetcodeNotLike(String value) {
            addCriterion("RETCODE not like", value, "retcode");
            return (Criteria) this;
        }

        public Criteria andRetcodeIn(List<String> values) {
            addCriterion("RETCODE in", values, "retcode");
            return (Criteria) this;
        }

        public Criteria andRetcodeNotIn(List<String> values) {
            addCriterion("RETCODE not in", values, "retcode");
            return (Criteria) this;
        }

        public Criteria andRetcodeBetween(String value1, String value2) {
            addCriterion("RETCODE between", value1, value2, "retcode");
            return (Criteria) this;
        }

        public Criteria andRetcodeNotBetween(String value1, String value2) {
            addCriterion("RETCODE not between", value1, value2, "retcode");
            return (Criteria) this;
        }

        public Criteria andRetmsgIsNull() {
            addCriterion("RETMSG is null");
            return (Criteria) this;
        }

        public Criteria andRetmsgIsNotNull() {
            addCriterion("RETMSG is not null");
            return (Criteria) this;
        }

        public Criteria andRetmsgEqualTo(String value) {
            addCriterion("RETMSG =", value, "retmsg");
            return (Criteria) this;
        }

        public Criteria andRetmsgNotEqualTo(String value) {
            addCriterion("RETMSG <>", value, "retmsg");
            return (Criteria) this;
        }

        public Criteria andRetmsgGreaterThan(String value) {
            addCriterion("RETMSG >", value, "retmsg");
            return (Criteria) this;
        }

        public Criteria andRetmsgGreaterThanOrEqualTo(String value) {
            addCriterion("RETMSG >=", value, "retmsg");
            return (Criteria) this;
        }

        public Criteria andRetmsgLessThan(String value) {
            addCriterion("RETMSG <", value, "retmsg");
            return (Criteria) this;
        }

        public Criteria andRetmsgLessThanOrEqualTo(String value) {
            addCriterion("RETMSG <=", value, "retmsg");
            return (Criteria) this;
        }

        public Criteria andRetmsgLike(String value) {
            addCriterion("RETMSG like", value, "retmsg");
            return (Criteria) this;
        }

        public Criteria andRetmsgNotLike(String value) {
            addCriterion("RETMSG not like", value, "retmsg");
            return (Criteria) this;
        }

        public Criteria andRetmsgIn(List<String> values) {
            addCriterion("RETMSG in", values, "retmsg");
            return (Criteria) this;
        }

        public Criteria andRetmsgNotIn(List<String> values) {
            addCriterion("RETMSG not in", values, "retmsg");
            return (Criteria) this;
        }

        public Criteria andRetmsgBetween(String value1, String value2) {
            addCriterion("RETMSG between", value1, value2, "retmsg");
            return (Criteria) this;
        }

        public Criteria andRetmsgNotBetween(String value1, String value2) {
            addCriterion("RETMSG not between", value1, value2, "retmsg");
            return (Criteria) this;
        }

        public Criteria andPayMethodIsNull() {
            addCriterion("PAY_METHOD is null");
            return (Criteria) this;
        }

        public Criteria andPayMethodIsNotNull() {
            addCriterion("PAY_METHOD is not null");
            return (Criteria) this;
        }

        public Criteria andPayMethodEqualTo(String value) {
            addCriterion("PAY_METHOD =", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotEqualTo(String value) {
            addCriterion("PAY_METHOD <>", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodGreaterThan(String value) {
            addCriterion("PAY_METHOD >", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_METHOD >=", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodLessThan(String value) {
            addCriterion("PAY_METHOD <", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodLessThanOrEqualTo(String value) {
            addCriterion("PAY_METHOD <=", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodLike(String value) {
            addCriterion("PAY_METHOD like", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotLike(String value) {
            addCriterion("PAY_METHOD not like", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodIn(List<String> values) {
            addCriterion("PAY_METHOD in", values, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotIn(List<String> values) {
            addCriterion("PAY_METHOD not in", values, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodBetween(String value1, String value2) {
            addCriterion("PAY_METHOD between", value1, value2, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotBetween(String value1, String value2) {
            addCriterion("PAY_METHOD not between", value1, value2, "payMethod");
            return (Criteria) this;
        }

        public Criteria andChannelIsNull() {
            addCriterion("CHANNEL is null");
            return (Criteria) this;
        }

        public Criteria andChannelIsNotNull() {
            addCriterion("CHANNEL is not null");
            return (Criteria) this;
        }

        public Criteria andChannelEqualTo(String value) {
            addCriterion("CHANNEL =", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotEqualTo(String value) {
            addCriterion("CHANNEL <>", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThan(String value) {
            addCriterion("CHANNEL >", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThanOrEqualTo(String value) {
            addCriterion("CHANNEL >=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThan(String value) {
            addCriterion("CHANNEL <", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThanOrEqualTo(String value) {
            addCriterion("CHANNEL <=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLike(String value) {
            addCriterion("CHANNEL like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotLike(String value) {
            addCriterion("CHANNEL not like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelIn(List<String> values) {
            addCriterion("CHANNEL in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotIn(List<String> values) {
            addCriterion("CHANNEL not in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelBetween(String value1, String value2) {
            addCriterion("CHANNEL between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotBetween(String value1, String value2) {
            addCriterion("CHANNEL not between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andApiNameIsNull() {
            addCriterion("API_NAME is null");
            return (Criteria) this;
        }

        public Criteria andApiNameIsNotNull() {
            addCriterion("API_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andApiNameEqualTo(String value) {
            addCriterion("API_NAME =", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameNotEqualTo(String value) {
            addCriterion("API_NAME <>", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameGreaterThan(String value) {
            addCriterion("API_NAME >", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameGreaterThanOrEqualTo(String value) {
            addCriterion("API_NAME >=", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameLessThan(String value) {
            addCriterion("API_NAME <", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameLessThanOrEqualTo(String value) {
            addCriterion("API_NAME <=", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameLike(String value) {
            addCriterion("API_NAME like", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameNotLike(String value) {
            addCriterion("API_NAME not like", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameIn(List<String> values) {
            addCriterion("API_NAME in", values, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameNotIn(List<String> values) {
            addCriterion("API_NAME not in", values, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameBetween(String value1, String value2) {
            addCriterion("API_NAME between", value1, value2, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameNotBetween(String value1, String value2) {
            addCriterion("API_NAME not between", value1, value2, "apiName");
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