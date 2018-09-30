package com.cindata.housekeeper.wx.common.tools;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cindata.housekeeper.core.common.tools.StringUtil;
import com.cindata.housekeeper.core.entity.JSONResult;
import com.cindata.housekeeper.wx.model.HouseAvmInfo;
import com.cindata.housekeeper.wx.model.WxHouseAvmLog;
import com.cindata.housekeeper.wx.model.WxHouseInfo;
import com.cindata.housekeeper.wx.model.WxLoanInfo;

public class HouseLoan {

	  /**
     * 微信资产曲线使用
     */
	
	public static Map houseLoan( BigDecimal assessSalePrice,BigDecimal buildingsquare,List<WxLoanInfo> LoanInfo,java.util.Date dateChange ){
		
		Calendar nowResult = Calendar.getInstance(); 
		nowResult.setTime(dateChange);
		Map map = new HashMap();
		
	        List resultList = new ArrayList();
	        HouseAvmInfo houseAvmInfo = new HouseAvmInfo();
	        BigDecimal totalLoan = new BigDecimal(0);
	        BigDecimal LoanLiabilities = new BigDecimal(0);
	        BigDecimal netValue = new BigDecimal(0);
	        if(LoanInfo != null){
	        	
	        	for(WxLoanInfo wxLoanInfo : LoanInfo){
	        		
	        	
	        		 BigDecimal LoanMoney = new BigDecimal(0);
		   LoanMoney =LoanMoney.add(wxLoanInfo.getMoney().multiply(new BigDecimal(10000)));
		  
		  
		  
		  
		 // BigDecimal assessSalePrice = StringUtil.parseBigDecimal(wxHouseInfo.getAssessSalePrice(),new BigDecimal(0));
         // BigDecimal buildingsquare = StringUtil.parseBigDecimal(wxHouseInfo.getBuildingsquare(),new BigDecimal(0));
          //房产估值
          BigDecimal assessSaleTotalPrice = assessSalePrice.multiply(buildingsquare);
          //房净值
          netValue = assessSaleTotalPrice.subtract(LoanMoney);
          
          
        //贷款金额
      	BigDecimal money = wxLoanInfo.getMoney().multiply(new BigDecimal(10000));
      	//还款方式
      	String repayment = wxLoanInfo.getRepayment();
      	//年利率
      	BigDecimal rate = wxLoanInfo.getRate();
      	//还款月数
      	Double repatMonthNum = wxLoanInfo.getTerm().multiply(new BigDecimal(12)).doubleValue();
      	//月利率
      	BigDecimal monthly = rate.divide(new BigDecimal(12), 2,BigDecimal.ROUND_HALF_UP).divide(new BigDecimal(100));
      	BigDecimal monthlySupply = new BigDecimal(0);
      	
      	if("等额本息".equals(repayment)){
      		//每月月供额=〔贷款本金×月利率×(1＋月利率)＾还款月数〕÷〔(1＋月利率)＾还款月数〕-1
      		
      		BigDecimal first = money.multiply(monthly).multiply(new BigDecimal(Math.pow(new BigDecimal(1).add(monthly).doubleValue(), repatMonthNum)));
      		BigDecimal two = new BigDecimal(Math.pow(new BigDecimal(1).add(monthly).doubleValue(),repatMonthNum));
      		
      		totalLoan = totalLoan.add(first.divide(two,2,BigDecimal.ROUND_HALF_UP).subtract(new BigDecimal(1)));
      	
      	
      		java.util.Date dateLoan = wxLoanInfo.getLoanTime();
      		Calendar calendar = Calendar.getInstance();
      		calendar.setTime(dateLoan);
      		int date = calendar.get(Calendar.DATE);
      		
      		//租约开始的下个月
      		/*calendar.add(Calendar.MONTH, 1); 
      		java.util.Date date = calendar.getTime();
      		Date nextMonth=new Date(date.getTime());*/
      		
      		//当前时间
      		java.util.Date dateNow = new java.util.Date();
      		//Calendar now = Calendar.getInstance();

      		int year = nowResult.get(Calendar.YEAR);
      		int month1 = nowResult.get(Calendar.MONTH);
      		nowResult.set(year, month1,date);
      		nowResult.add(Calendar.MONTH, 1);
      		
      		Date dateResult = new Date(nowResult.getTime().getTime());
      		nowResult.add(Calendar.MONTH, -1);
      		//贷款的月份个数
      		 int resultyear = (nowResult.get(Calendar.YEAR) - calendar.get(Calendar.YEAR)) * 12;
      	     int resultmonth = nowResult.get(Calendar.MONTH) - calendar.get(Calendar.MONTH);
      	     //已经还款月份数
      	     int resultFactdiff = resultyear + resultmonth;
      	     //已还款数
      	     BigDecimal alreadyRepayMoney = totalLoan.multiply(new BigDecimal(resultFactdiff));
      	     //总还款额(本金加利息)
      	     BigDecimal repayTotalMoney = totalLoan.multiply(new BigDecimal(repatMonthNum));
      	     //未还款额本息
      	     BigDecimal nonRepayMoney = repayTotalMoney.subtract(alreadyRepayMoney);
      	     //贷款负债
      	     LoanLiabilities = LoanLiabilities.add(assessSaleTotalPrice.subtract(nonRepayMoney));
      		
      	}
      	if("等金本息".equals(repayment)){
      		//每月月供额=(贷款本金÷还款月数)+(贷款本金-已归还本金累计额)×月利率
      		BigDecimal first = money.divide(new BigDecimal(repatMonthNum),2,BigDecimal.ROUND_HALF_UP);
      		//每月应还本金
      		BigDecimal monthRepayMoney = money.divide(new BigDecimal(repatMonthNum),2,BigDecimal.ROUND_HALF_UP);
     
      		
      		java.util.Date dateLoan = wxLoanInfo.getLoanTime();
      		Calendar calendar = Calendar.getInstance();
      		calendar.setTime(dateLoan);
      		int date = calendar.get(Calendar.DATE);
      		
      		//租约开始的下个月
      		/*calendar.add(Calendar.MONTH, 1); 
      		java.util.Date date = calendar.getTime();
      		Date nextMonth=new Date(date.getTime());*/
      		
      		//当前时间
      		java.util.Date dateNow = new java.util.Date();
      		Calendar now = Calendar.getInstance();

      		int year = nowResult.get(Calendar.YEAR);
      		int month1 = nowResult.get(Calendar.MONTH);
      		nowResult.set(year, month1,date);
      		nowResult.add(Calendar.MONTH, 1);
      		
      		Date dateResult = new Date(nowResult.getTime().getTime());
      		nowResult.add(Calendar.MONTH, -1);
      		//贷款的月份个数
      		 int resultyear = (nowResult.get(Calendar.YEAR) - calendar.get(Calendar.YEAR)) * 12;
      	     int resultmonth = nowResult.get(Calendar.MONTH) - calendar.get(Calendar.MONTH);
      	     //已经还款月份数
      	     int resultFactdiff = resultyear + resultmonth;
      	     //已归还本金累计额
      	     BigDecimal alreadyRepayMoney = monthRepayMoney.multiply(new BigDecimal(resultFactdiff));
      	     
      	     BigDecimal two = monthly.multiply(money.subtract(alreadyRepayMoney));
      	     BigDecimal three =  first.add(two);
      	     totalLoan = totalLoan.add(three);
      	     
      	     
      	     
      	     //总利息=还款月数×(总贷款额×月利率-月利率×(总贷款额÷还款月数)*(还款月数-1)÷2+总贷款额÷还款月数)
      	     
        BigDecimal one1 = money.multiply(monthly);
   		BigDecimal two1 = monthly.multiply(money.divide(new BigDecimal(repatMonthNum), 2, BigDecimal.ROUND_HALF_UP));
   		BigDecimal	three1 = new BigDecimal(repatMonthNum).subtract(new BigDecimal(1));
   		BigDecimal two2three = two1.multiply(three1).divide(new BigDecimal(2), 2, BigDecimal.ROUND_HALF_UP);
   		BigDecimal four = money.divide(new BigDecimal(repatMonthNum),2,BigDecimal.ROUND_HALF_UP);
   		BigDecimal inside = one1.subtract(two2three).add(four);
   		BigDecimal accrualTotal = new BigDecimal(repatMonthNum).multiply(inside).setScale(2, BigDecimal.ROUND_HALF_UP);
      	    
      	     //每月应还利息=剩余本金×月利率=(贷款本金-已归还本金累计额)×月利率
      	     BigDecimal alreadyaccrualMonth = (money.subtract(alreadyRepayMoney)).multiply(monthly);
      	     //已还利息
      	     BigDecimal alreadyaccrualTotal = alreadyaccrualMonth.multiply(new BigDecimal(resultFactdiff));
      	     //未还贷款额本息
      	     BigDecimal nonRepayMoney = accrualTotal.add(money).subtract(alreadyaccrualTotal.add(alreadyRepayMoney));
      	     //贷款负债
      	     LoanLiabilities = LoanLiabilities.add(assessSaleTotalPrice.subtract(nonRepayMoney));
      	     
      	}
	        	}
    	
      	map.put("netValue", netValue);
      	map.put("LoanLiability", LoanLiabilities);
      	
      	List<Map> list = new ArrayList<>();
      	list.add(map);
	        }else{
	        	
	        	  BigDecimal assessSaleTotalPrice = assessSalePrice.multiply(buildingsquare);
	              //房净值
	              netValue = assessSaleTotalPrice;
	              map.put("netValue", netValue);
	        	
	        }
      
      	return map;
      	
	}
	
	
	public static void main(String[] args){
		
		WxHouseInfo wxHouseInfo = new WxHouseInfo();
		wxHouseInfo.setAssessSalePrice(new BigDecimal(5000));
		wxHouseInfo.setBuildingsquare(new BigDecimal(100));
		
		WxLoanInfo wxLoanInfo = new WxLoanInfo();
		wxLoanInfo.setMoney(new BigDecimal(100));
		wxLoanInfo.setRepayment("等额本息");
		wxLoanInfo.setRate(new BigDecimal(5));
		wxLoanInfo.setTerm(new BigDecimal(20));
		wxLoanInfo.setLoanTime(new Date(2018-06-06));
		//wxLoanInfo.setLoanTime(new java.sql.Date(new Date(2018-06-06).getTime()));
		//还款方式
      	String repayment = wxLoanInfo.getRepayment();
      	//年利率
      	BigDecimal rate = wxLoanInfo.getRate();
      	//还款月数
      	Double repatMonthNum = wxLoanInfo.getTerm().multiply(new BigDecimal(12)).doubleValue();
		Calendar now1 = Calendar.getInstance();
		StringBuffer dataArray=new StringBuffer("[");
    	StringBuffer date=new StringBuffer("[");
		StringBuffer data=new StringBuffer("[");
		
		StringBuffer LoanLiability=new StringBuffer("[");
		  for (int i=0;i<6;i++){
			  now1.add(Calendar.MONTH, -1);
			  int month = now1.get(Calendar.MONTH) + 1;
			  
			  
			  if(month <= 0){
				  month = month + 12;
			  }
			  
			// Map map = houseLoan(wxHouseInfo,wxLoanInfo,now1);
			// BigDecimal LoanLiabilities = (BigDecimal) map.get("LoanLiability");
			// BigDecimal netValue = (BigDecimal) map.get("netValue");
			
			    date.insert(1,"\""+month+"\",");
				//data.insert(1,"\""+netValue+"\",");
				//LoanLiability.insert(1,"\""+LoanLiabilities+"\",");
				
			}
			
			
		data.deleteCharAt(data.length()-1);
		date.deleteCharAt(date.length()-1);
		dataArray.append(data+"],"+LoanLiability+"],"+date+"]]");
		System.out.print(dataArray);
	}
}
