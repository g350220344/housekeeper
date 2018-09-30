package com.cindata.housekeeper.wx.service;

import com.cindata.housekeeper.wx.model.WxLoanInfo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface WxLoanService {

	int addLoan(WxLoanInfo loanInfo);

	List<WxLoanInfo> selectLoanByUserId(String userId);

	int updateLoanByLoanId(WxLoanInfo wxLoanInfo);

	int deleteLoan(WxLoanInfo loanInfo);

	List<WxLoanInfo> selectLoanByHouseId(String houseId);

    List<WxLoanInfo> selectLoan(WxLoanInfo wxLoanInfo);

	List<WxLoanInfo> selectLoanByUserIdAndStatus(String userId,int status);

	BigDecimal getLoanPrice(List<WxLoanInfo> wxLoanInfoList, Date date);

	List<WxLoanInfo> selectLoanByHouseIdAndStatus(String houseId, int status);

	Map<String,BigDecimal> getLoanTotalPrice(List<WxLoanInfo> wxLoanInfoList, Date date) ;

	int getLoanCountByHouseId(BigDecimal houseId);

    int updateLoanStatus();
}
