package com.cindata.housekeeper.wx.dao;

import com.cindata.housekeeper.wx.model.WxHouseInfo;
import com.cindata.housekeeper.wx.model.WxHouseInfoExample;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface WxHouseInfoMapper {
    int countByExample(WxHouseInfoExample example);

    int deleteByExample(WxHouseInfoExample example);

    int deleteByPrimaryKey(BigDecimal houseId);

    int insert(WxHouseInfo record);

    int insertSelective(WxHouseInfo record);

    List<WxHouseInfo> selectByExample(WxHouseInfoExample example);

    WxHouseInfo selectByPrimaryKey(BigDecimal houseId);

    int updateByExampleSelective(@Param("record") WxHouseInfo record, @Param("example") WxHouseInfoExample example);

    int updateByExample(@Param("record") WxHouseInfo record, @Param("example") WxHouseInfoExample example);

    int updateByPrimaryKeySelective(WxHouseInfo record);

    int updateByPrimaryKey(WxHouseInfo record);
    
    List<WxHouseInfo> getHouseTopPx();

	int getCHD(String userId);
	
	int getCCD(String userId);

	Map getInfo(String userId);

	List<WxHouseInfo> getcity(String userId);


    Map getRankByUserId(String userId);
}