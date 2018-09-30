package com.cindata.housekeeper.wx.service;

import com.cindata.housekeeper.core.entity.Parameter;
import com.cindata.housekeeper.wx.model.HouseAvmInfo;
import com.cindata.housekeeper.wx.model.WxHouseAvmLog;
import com.cindata.housekeeper.wx.model.WxHouseInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface WxHouseInfoService {

	int addHouse(WxHouseInfo houseInfo);

	int addHouseAvm(WxHouseAvmLog houseAvmLog);

	//WxHouseInfo selectHouseInfoByHouseId(Integer houseId);

	int updateHouseAvm();

	List<WxHouseAvmLog> getHouseAvmLogByHouseId(BigDecimal bigDecimal);

	WxHouseInfo selectHouseInfoByHouseId(BigDecimal houseId);

	int updateHouse(WxHouseInfo houseInfo);

	int deleteHouse(WxHouseInfo houseInfo);

	List<WxHouseInfo> getHouseByuserId(String userId);

	HouseAvmInfo getHouseInfo(WxHouseInfo houseInfo);

	List<WxHouseInfo> getHouseTop();

	WxHouseAvmLog selectHouseInfoByHouseIdAndUpdate(Parameter param);

	HouseAvmInfo getWxHouseInfo(WxHouseInfo houseInfo);

	int getCHD(String string);
	
	int getCCD(String string);

	Map getHouseInfo(String userId);

	List<WxHouseInfo> getcity(String userId);

	Map getRankByUserId(String userId);

	List<WxHouseAvmLog> getHouseAvmLogByHouseIdAndMonath(BigDecimal houseId, String startMonth, String endMonth);

    List<WxHouseInfo> getWxHouseInfoByUserIdAndCommunityId(String userId, String communityId);
}
