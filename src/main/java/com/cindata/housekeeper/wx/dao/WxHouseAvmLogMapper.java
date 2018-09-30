package com.cindata.housekeeper.wx.dao;

import com.cindata.housekeeper.wx.model.WxHouseAvmLog;
import com.cindata.housekeeper.wx.model.WxHouseAvmLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxHouseAvmLogMapper {
    int countByExample(WxHouseAvmLogExample example);

    int deleteByExample(WxHouseAvmLogExample example);

    int insert(WxHouseAvmLog record);

    int insertSelective(WxHouseAvmLog record);

    List<WxHouseAvmLog> selectByExample(WxHouseAvmLogExample example);

    int updateByExampleSelective(@Param("record") WxHouseAvmLog record, @Param("example") WxHouseAvmLogExample example);

    int updateByExample(@Param("record") WxHouseAvmLog record, @Param("example") WxHouseAvmLogExample example);
}