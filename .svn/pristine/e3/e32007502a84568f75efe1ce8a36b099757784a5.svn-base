package com.cindata.housekeeper.wx.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Date;

public class WxLoanInfo {
    private String id;
    @NotBlank(message = "houseId不能为空")
    private String houseId;
    @NotBlank(message = "userId不能为空")
    private String userId;
    @NotNull(message = "loanTime(贷款时间)不能为空")
    private Date loanTime;
    @NotNull(message = "term(期限)不能为空")
    private BigDecimal term;
    @NotNull(message = "type(贷款类型)不能为空")
    private BigDecimal type;
    @NotBlank(message = "typeName(贷款名称)不能为空")
    private String typeName;
    @NotBlank(message = "channel(贷款渠道)不能为空")
    private String channel;
    @NotBlank(message = "channelName(渠道名称)不能为空")
    private String channelName;
    @NotNull(message = "money(贷款金额)不能为空")
    private BigDecimal money;
    @NotNull(message = "rate(年利率)不能为空")
    @Range(min = 1, max = 36, message = "年利率1~36")
    private BigDecimal rate;
    @NotBlank(message = "repayment(还款方式)不能为空")
    private String repayment;

    private BigDecimal state;

    private java.util.Date nextDate;// 下次还款日期

    private double nextMoney;// 下次还款金额

    private int currTerm;// 当前已还期数

    private String currPercent;// 还款进度

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId == null ? null : houseId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(Date loanTime) {
        this.loanTime = loanTime;
    }

    public BigDecimal getTerm() {
        return term;
    }

    public void setTerm(BigDecimal term) {
        this.term = term;
    }

    public BigDecimal getType() {
        return type;
    }

    public void setType(BigDecimal type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getRepayment() {
        return repayment;
    }

    public void setRepayment(String repayment) {
        this.repayment = repayment == null ? null : repayment.trim();
    }

    public BigDecimal getState() {
        return state;
    }

    public void setState(BigDecimal state) {
        this.state = state;
    }

    public java.util.Date getNextDate() {
        return nextDate;
    }

    public void setNextDate(java.util.Date nextDate) {
        this.nextDate = nextDate;
    }

    public double getNextMoney() {
        return nextMoney;
    }

    public void setNextMoney(double nextMoney) {
        this.nextMoney = nextMoney;
    }

    public int getCurrTerm() {
        return currTerm;
    }

    public void setCurrTerm(int currTerm) {
        this.currTerm = currTerm;
    }

    public String getCurrPercent() {
        return currPercent;
    }

    public void setCurrPercent(String currPercent) {
        this.currPercent = currPercent;
    }
}