package com.cindata.housekeeper.wx.dao;


import com.cindata.housekeeper.wx.model.WxPaymentLog;
import com.cindata.housekeeper.wx.model.WxPaymentLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxPaymentLogMapper {
    long countByExample(WxPaymentLogExample example);

    int deleteByExample(WxPaymentLogExample example);

    int insert(WxPaymentLog record);

    int insertSelective(WxPaymentLog record);

    List<WxPaymentLog> selectByExample(WxPaymentLogExample example);

    int updateByExampleSelective(@Param("record") WxPaymentLog record, @Param("example") WxPaymentLogExample example);

    int updateByExample(@Param("record") WxPaymentLog record, @Param("example") WxPaymentLogExample example);
}