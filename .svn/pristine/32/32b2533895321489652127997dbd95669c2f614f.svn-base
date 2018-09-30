package com.cindata.housekeeper.web.dao;

import com.cindata.housekeeper.web.model.HouseAvmLog;
import com.cindata.housekeeper.web.model.HouseAvmLogExample;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface HouseAvmLogMapper {
    long countByExample(HouseAvmLogExample example);

    int deleteByExample(HouseAvmLogExample example);

    int deleteByPrimaryKey(BigDecimal houseId);

    int insert(HouseAvmLog record);

    int insertSelective(HouseAvmLog record);

    List<HouseAvmLog> selectByExample(HouseAvmLogExample example);

    HouseAvmLog selectByPrimaryKey(BigDecimal houseId);

    int updateByExampleSelective(@Param("record") HouseAvmLog record, @Param("example") HouseAvmLogExample example);

    int updateByExample(@Param("record") HouseAvmLog record, @Param("example") HouseAvmLogExample example);

    int updateByPrimaryKeySelective(HouseAvmLog record);

    int updateByPrimaryKey(HouseAvmLog record);
}