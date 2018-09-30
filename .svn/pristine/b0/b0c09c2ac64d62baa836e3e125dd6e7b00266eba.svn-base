package com.cindata.housekeeper.wx.dao;


import com.cindata.housekeeper.core.entity.Parameter;
import com.cindata.housekeeper.wx.model.WxMessage;
import com.cindata.housekeeper.wx.model.WxMessageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxMessageMapper {
    long countByExample(WxMessageExample example);

    int deleteByExample(WxMessageExample example);

    int deleteByPrimaryKey(String id);

    int insert(WxMessage record);

    int insertSelective(WxMessage record);

    List<WxMessage> selectByExample(WxMessageExample example);

    WxMessage selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WxMessage record, @Param("example") WxMessageExample example);

    int updateByExample(@Param("record") WxMessage record, @Param("example") WxMessageExample example);

    int updateByPrimaryKeySelective(WxMessage record);

    int updateByPrimaryKey(WxMessage record);

    List<WxMessage> getMessageListByUserId(Parameter parameter);
}