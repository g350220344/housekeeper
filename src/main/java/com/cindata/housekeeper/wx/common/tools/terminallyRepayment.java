package com.cindata.housekeeper.wx.common.tools;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cindata.housekeeper.core.common.tools.ServletRequestHelper;
import com.cindata.housekeeper.core.entity.JSONResult;
import com.cindata.housekeeper.wx.model.HouseAvmInfo;
import com.cindata.housekeeper.wx.model.WxLoanInfo;
import com.cindata.housekeeper.wx.model.periodRepaymentInfo;

public class terminallyRepayment {

	public static periodRepaymentInfo houseLoan(WxLoanInfo wxLoanInfo){
		
		String typeResult = "";
		java.util.Date dateTime = new java.util.Date();
    	java.util.Date nowTime = new java.util.Date();
    	Date dateResult = null;
    	periodRepaymentInfo periodRepaymentinfo = new periodRepaymentInfo();
    	int resultFactdiff = 0;
    	 String rentStatus = "";
        String repaymentSchedule = "";
        JSONResult<List<periodRepaymentInfo>> res = new JSONResult<List<periodRepaymentInfo>>();
        List resultList = new ArrayList();
        BigDecimal totalLoan = new BigDecimal(0);
		  //到期时间
        Calendar expireTime = Calendar.getInstance();
		Calendar nowResult = Calendar.getInstance(); 
		BigDecimal LoanMoney = wxLoanInfo.getMoney().multiply(new BigDecimal(10000));
  	  //贷款金额
    	BigDecimal money = wxLoanInfo.getMoney().multiply(new BigDecimal(10000));
    	//还款方式
    	String repayment = wxLoanInfo.getRepayment();
    	//年利率
    	BigDecimal rate = wxLoanInfo.getRate();
    	//贷款渠道
    	String channel = wxLoanInfo.getChannel();
    	//贷款时间
    	java.util.Date dateLoan = wxLoanInfo.getLoanTime();
    	//贷款类型
    	BigDecimal type = wxLoanInfo.getType();
    	
    	if(type.compareTo(new BigDecimal(1)) == 0){
    		typeResult = "商业按揭贷款";
    	}
  	if(type.compareTo(new BigDecimal(2)) == 0){
    		typeResult = "公积金贷款";
    	}
  	if(type.compareTo(new BigDecimal(3)) == 0){
    		typeResult = "信用贷";
    	}
  	if(type.compareTo(new BigDecimal(4)) == 0){
    		typeResult = "房抵贷";
    	}
    	//还款月数
    	Double repatMonthNum = wxLoanInfo.getTerm().multiply(new BigDecimal(12)).doubleValue();
    	int termLoan = wxLoanInfo.getTerm().intValue();
    	
    	expireTime.setTime(dateLoan);
    	expireTime.add(Calendar.YEAR, termLoan);
    	dateTime = expireTime.getTime();
    	if(dateTime.after(nowTime)){
    		rentStatus = "贷款未结清";
    	}else{
    		rentStatus = "贷款已结清";
    	}
    	
    	
    	
    	
    	
    	
    	//月利率
    	BigDecimal monthly = rate.divide(new BigDecimal(12), 2,BigDecimal.ROUND_HALF_UP).divide(new BigDecimal(100));
    	BigDecimal monthlySupply = new BigDecimal(0);
    	Calendar calendar = Calendar.getInstance();
		
		calendar.setTime(dateLoan);
		Calendar now = Calendar.getInstance();
    	if("等额本息".equals(repayment)){
    		//每月月供额=〔贷款本金×月利率×(1＋月利率)＾还款月数〕÷〔(1＋月利率)＾还款月数〕-1
    		
    		BigDecimal first = money.multiply(monthly).multiply(new BigDecimal(Math.pow(new BigDecimal(1).add(monthly).doubleValue(), repatMonthNum)));
    		BigDecimal two = new BigDecimal(Math.pow(new BigDecimal(1).add(monthly).doubleValue(),repatMonthNum));
    		
    		totalLoan = totalLoan.add(first.divide(two,2,BigDecimal.ROUND_HALF_UP).subtract(new BigDecimal(1)));
    		
    		
    		int date = calendar.get(Calendar.DATE);
    		
    		//租约开始的下个月
    		
    		
    		//当前时间
    		java.util.Date dateNow = new java.util.Date();
    		//Calendar now = Calendar.getInstance();
    		//贷款年份和月份
    		int year = now.get(Calendar.YEAR);
    		//当前月份
    		int month2 = now.get(Calendar.MONTH);
    		now.set(year, month2,date);
    		now.add(Calendar.MONTH, 1);
    		
    		 dateResult = new Date(now.getTime().getTime());
    		now.add(Calendar.MONTH, -1);
    	//贷款的月份个数
   		 int resultyear = (now.get(Calendar.YEAR) - calendar.get(Calendar.YEAR)) * 12;
   	     int resultmonth = now.get(Calendar.MONTH) - calendar.get(Calendar.MONTH);
   	     //已经还款月份数
   	      resultFactdiff = resultyear + resultmonth;
   	     
   	    repaymentSchedule = new BigDecimal(resultFactdiff).divide(new BigDecimal(repatMonthNum),2,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).toString() + "%";
    	}
  	if("等金本息".equals(repayment)){
    		//每月月供额=(贷款本金÷还款月数)+(贷款本金-已归还本金累计额)×月利率
    		BigDecimal first = money.divide(new BigDecimal(repatMonthNum),2,BigDecimal.ROUND_HALF_UP);
    		//每月应还本金
    		BigDecimal monthRepayMoney = money.divide(new BigDecimal(repatMonthNum),2,BigDecimal.ROUND_HALF_UP);
   
    		int date = calendar.get(Calendar.DATE);
    		
    		//租约开始的下个月
    	
    		
    		//当前时间
    		java.util.Date dateNow = new java.util.Date();
    		

    		int year = now.get(Calendar.YEAR);
    		int month1 = calendar.get(Calendar.MONTH);
    		int month2 = now.get(Calendar.MONTH);
    		now.set(year, month2,date);
    		now.add(Calendar.MONTH, 1);
    		
    		
    		 dateResult = new Date(now.getTime().getTime());
    		now.add(Calendar.MONTH, -1);
    		//贷款的月份个数
    		 int resultyear = (now.get(Calendar.YEAR) - calendar.get(Calendar.YEAR)) * 12;
    	     int resultmonth = now.get(Calendar.MONTH) - calendar.get(Calendar.MONTH);
    	     //已经还款月份数
    	      resultFactdiff = resultyear + resultmonth;
    	     //已归还本金累计额
    	     BigDecimal alreadyRepayMoney = monthRepayMoney.multiply(new BigDecimal(resultFactdiff));
    	     
    	     BigDecimal two = monthly.multiply(money.subtract(alreadyRepayMoney));
    	     BigDecimal three =  first.add(two);
    	     totalLoan = totalLoan.add(three);
    	   repaymentSchedule = new BigDecimal(resultFactdiff).divide(new BigDecimal(repatMonthNum),2,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).toString() + "%";
    	}
  	
  	periodRepaymentinfo.setRentStatus(rentStatus);
  	periodRepaymentinfo.setRepaymentDate(dateResult);
  	periodRepaymentinfo.setRepaymentChannel(channel);
  	periodRepaymentinfo.setRepaymentSchedule(repaymentSchedule);
  	periodRepaymentinfo.setRepaymentDateAlready(new Integer(resultFactdiff));
  	periodRepaymentinfo.setRepaymentDateTotal(new Integer(repatMonthNum.intValue()));
  	periodRepaymentinfo.setRepaymentPrice(totalLoan);
  	periodRepaymentinfo.setRepaymentType(typeResult);
  	
  	return periodRepaymentinfo;
      	
	}
	
	

}
