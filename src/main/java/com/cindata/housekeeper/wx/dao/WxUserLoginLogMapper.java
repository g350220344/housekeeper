package com.cindata.housekeeper.wx.dao;


import com.cindata.housekeeper.wx.model.WxUserLoginLog;
import com.cindata.housekeeper.wx.model.WxUserLoginLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxUserLoginLogMapper {
    long countByExample(WxUserLoginLogExample example);

    int deleteByExample(WxUserLoginLogExample example);

    int deleteByPrimaryKey(String id);

    int insert(WxUserLoginLog record);

    int insertSelective(WxUserLoginLog record);

    List<WxUserLoginLog> selectByExample(WxUserLoginLogExample example);

    WxUserLoginLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WxUserLoginLog record, @Param("example") WxUserLoginLogExample example);

    int updateByExample(@Param("record") WxUserLoginLog record, @Param("example") WxUserLoginLogExample example);

    int updateByPrimaryKeySelective(WxUserLoginLog record);

    int updateByPrimaryKey(WxUserLoginLog record);
}