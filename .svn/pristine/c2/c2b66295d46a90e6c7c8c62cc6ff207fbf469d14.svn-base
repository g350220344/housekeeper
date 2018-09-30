package com.cindata.housekeeper.wx.service;

import com.cindata.housekeeper.wx.model.WxRentInfo;
import com.cindata.housekeeper.wx.model.WxSelectLease;
import com.cindata.housekeeper.wx.model.WxSelectLeaseList;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
public interface WxRentService {
	
	/**
	 * @author 张宇
	 **/
	void insertRent (WxRentInfo rentInfo) throws Exception;
	
	/**
	 * @author 张宇
	 **/
	void updateRent (WxRentInfo rentInfo) throws Exception;
	
	/**
	 * @author 张宇
	 **/
	void deleteRent (WxRentInfo rentInfo) throws Exception;
	
	/**
	 * @author 张宇
	 **/
	WxSelectLease selectNextRent (String houseId);
	
	

	/**
	 * @author 张宇
	 **/
	List<WxSelectLeaseList> selectNextRentList (String houseId);

	
	
	int addRent(WxRentInfo loanInfo);

	List<WxRentInfo> selectRentByUserAndHouseId(WxRentInfo wxRentInfo);

	int updateRentInfo(WxRentInfo loanInfo);

	int deleteRentInfo(WxRentInfo loanInfo);

	WxRentInfo periodRent(WxRentInfo loanInfo);

	List<WxRentInfo> selectRentByHouseId(WxRentInfo loanInfo);

	WxRentInfo selectRentByRentId(String id);

	List<WxRentInfo> selectRentByUserId(String userId);

    List<WxRentInfo> selectRentByUserIdAndStatus(String userId, int status);

    BigDecimal getRentPrice(List<WxRentInfo> wxRentInfoList, Date date);

	List<WxRentInfo> selectRentByHouseIdAndStatus(String houseId, int status);

    int updateRentStatus();
}
