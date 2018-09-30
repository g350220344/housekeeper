package com.cindata.housekeeper.wx.dao;


import com.cindata.housekeeper.wx.model.WxReport;
import com.cindata.housekeeper.wx.model.WxReportExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface WxReportMapper {
    long countByExample(WxReportExample example);

    int deleteByExample(WxReportExample example);

    int deleteByPrimaryKey(String id);

    int insert(WxReport record);

    int insertSelective(WxReport record);

    List<WxReport> selectByExample(WxReportExample example);

    WxReport selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WxReport record, @Param("example") WxReportExample example);

    int updateByExample(@Param("record") WxReport record, @Param("example") WxReportExample example);

    int updateByPrimaryKeySelective(WxReport record);

    int updateByPrimaryKey(WxReport record);

    /**
     * 查询用户订阅列表
     */
    List<Map> selectUserReportByPage(Map param);
    /**
     * 查询用户订阅列表总数
     */
    Integer selectUserReportByPageCount(Map param);

    int updateReporStatus();
}