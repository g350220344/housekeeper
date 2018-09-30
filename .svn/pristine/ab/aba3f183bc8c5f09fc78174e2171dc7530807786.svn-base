package com.cindata.housekeeper.wx.dao;

import com.cindata.housekeeper.wx.model.WxUserInfo;
import com.cindata.housekeeper.wx.model.WxUserInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxUserInfoMapper {
    int countByExample(WxUserInfoExample example);

    int deleteByExample(WxUserInfoExample example);

    int deleteByPrimaryKey(String userId);

    int insert(WxUserInfo record);

    int insertSelective(WxUserInfo record);

    List<WxUserInfo> selectByExample(WxUserInfoExample example);

    WxUserInfo selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") WxUserInfo record, @Param("example") WxUserInfoExample example);

    int updateByExample(@Param("record") WxUserInfo record, @Param("example") WxUserInfoExample example);

    int updateByPrimaryKeySelective(WxUserInfo record);

    int updateByPrimaryKey(WxUserInfo record);
}