package com.cindata.housekeeper.wx.dao;

import com.cindata.housekeeper.wx.model.WxRentInfo;
import com.cindata.housekeeper.wx.model.WxRentInfoExample;
import com.cindata.housekeeper.wx.model.WxSelectLease;
import com.cindata.housekeeper.wx.model.WxSelectLeaseList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxRentInfoMapper {
    int countByExample(WxRentInfoExample example);

    int deleteByExample(WxRentInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(WxRentInfo record);

    int insertSelective(WxRentInfo record);

    List<WxRentInfo> selectByExample(WxRentInfoExample example);

    WxRentInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WxRentInfo record, @Param("example") WxRentInfoExample example);

    int updateByExample(@Param("record") WxRentInfo record, @Param("example") WxRentInfoExample example);

    int updateByPrimaryKeySelective(WxRentInfo record);

    int updateByPrimaryKey(WxRentInfo record);

    WxSelectLease selectNextRent(String houseId);
    
   	List<WxSelectLeaseList> selectNextRentList(String houseId);

    int updateRentStatus();
}