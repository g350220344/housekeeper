package com.cindata.housekeeper.wx.dao;


import com.cindata.housekeeper.wx.model.SmsLog;
import com.cindata.housekeeper.wx.model.SmsLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmsLogMapper {
    long countByExample(SmsLogExample example);

    int deleteByExample(SmsLogExample example);

    int insert(SmsLog record);

    int insertSelective(SmsLog record);

    List<SmsLog> selectByExample(SmsLogExample example);

    int updateByExampleSelective(@Param("record") SmsLog record, @Param("example") SmsLogExample example);

    int updateByExample(@Param("record") SmsLog record, @Param("example") SmsLogExample example);
}