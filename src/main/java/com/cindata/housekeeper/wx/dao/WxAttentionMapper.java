package com.cindata.housekeeper.wx.dao;

import com.cindata.housekeeper.wx.model.WxAttention;
import com.cindata.housekeeper.wx.model.WxAttentionExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface WxAttentionMapper {
    int countByExample(WxAttentionExample example);

    int deleteByExample(WxAttentionExample example);

    int deleteByPrimaryKey(String id);

    int insert(WxAttention record);

    int insertSelective(WxAttention record);

    List<WxAttention> selectByExample(WxAttentionExample example);

    WxAttention selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WxAttention record, @Param("example") WxAttentionExample example);

    int updateByExample(@Param("record") WxAttention record, @Param("example") WxAttentionExample example);

    int updateByPrimaryKeySelective(WxAttention record);

    int updateByPrimaryKey(WxAttention record);
    
    /**
     * 查询用户关注列表
     */
    List<Map> selectUserAttentionByPage(Map param);
    /**
     * 查询用户关注列表总数
     */
    Integer selectUserAttentionByPageCount(Map param);
}