package com.cindata.housekeeper.wx.dao;

import com.cindata.housekeeper.wx.model.WxSuggestInfo;
import com.cindata.housekeeper.wx.model.WxSuggestInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxSuggestInfoMapper {
    int countByExample(WxSuggestInfoExample example);

    int deleteByExample(WxSuggestInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(WxSuggestInfo record);

    int insertSelective(WxSuggestInfo record);

    List<WxSuggestInfo> selectByExampleWithBLOBs(WxSuggestInfoExample example);

    List<WxSuggestInfo> selectByExample(WxSuggestInfoExample example);

    WxSuggestInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WxSuggestInfo record, @Param("example") WxSuggestInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") WxSuggestInfo record, @Param("example") WxSuggestInfoExample example);

    int updateByExample(@Param("record") WxSuggestInfo record, @Param("example") WxSuggestInfoExample example);

    int updateByPrimaryKeySelective(WxSuggestInfo record);

    int updateByPrimaryKeyWithBLOBs(WxSuggestInfo record);

    int updateByPrimaryKey(WxSuggestInfo record);
}