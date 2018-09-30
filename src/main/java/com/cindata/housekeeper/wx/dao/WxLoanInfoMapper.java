package com.cindata.housekeeper.wx.dao;

import com.cindata.housekeeper.wx.model.WxLoanInfo;
import com.cindata.housekeeper.wx.model.WxLoanInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxLoanInfoMapper {
    int countByExample(WxLoanInfoExample example);

    int deleteByExample(WxLoanInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(WxLoanInfo record);

    int insertSelective(WxLoanInfo record);

    List<WxLoanInfo> selectByExample(WxLoanInfoExample example);

    WxLoanInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WxLoanInfo record, @Param("example") WxLoanInfoExample example);

    int updateByExample(@Param("record") WxLoanInfo record, @Param("example") WxLoanInfoExample example);

    int updateByPrimaryKeySelective(WxLoanInfo record);

    int updateByPrimaryKey(WxLoanInfo record);

    int updateLoanStatus();
}