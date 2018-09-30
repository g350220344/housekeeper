package com.cindata.housekeeper.wx.dao;


import com.cindata.housekeeper.wx.model.SmsCode;
import com.cindata.housekeeper.wx.model.SmsCodeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmsCodeMapper {
    long countByExample(SmsCodeExample example);

    int deleteByExample(SmsCodeExample example);

    int insert(SmsCode record);

    int insertSelective(SmsCode record);

    List<SmsCode> selectByExample(SmsCodeExample example);

    int updateByExampleSelective(@Param("record") SmsCode record, @Param("example") SmsCodeExample example);

    int updateByExample(@Param("record") SmsCode record, @Param("example") SmsCodeExample example);
}