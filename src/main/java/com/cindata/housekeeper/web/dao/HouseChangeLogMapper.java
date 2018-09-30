package com.cindata.housekeeper.web.dao;

import com.cindata.housekeeper.web.model.HouseChangeLog;
import com.cindata.housekeeper.web.model.HouseChangeLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HouseChangeLogMapper {
    long countByExample(HouseChangeLogExample example);

    int deleteByExample(HouseChangeLogExample example);

    int deleteByPrimaryKey(String statementid);

    int insert(HouseChangeLog record);

    int insertSelective(HouseChangeLog record);

    List<HouseChangeLog> selectByExample(HouseChangeLogExample example);

    HouseChangeLog selectByPrimaryKey(String statementid);

    int updateByExampleSelective(@Param("record") HouseChangeLog record, @Param("example") HouseChangeLogExample example);

    int updateByExample(@Param("record") HouseChangeLog record, @Param("example") HouseChangeLogExample example);

    int updateByPrimaryKeySelective(HouseChangeLog record);

    int updateByPrimaryKey(HouseChangeLog record);
}