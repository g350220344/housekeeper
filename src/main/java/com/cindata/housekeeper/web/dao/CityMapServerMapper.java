package com.cindata.housekeeper.web.dao;


import com.cindata.housekeeper.web.model.CityMapServer;
import com.cindata.housekeeper.web.model.CityMapServerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CityMapServerMapper {
    long countByExample(CityMapServerExample example);

    int deleteByExample(CityMapServerExample example);

    int insert(CityMapServer record);

    int insertSelective(CityMapServer record);

    List<CityMapServer> selectByExample(CityMapServerExample example);

    int updateByExampleSelective(@Param("record") CityMapServer record, @Param("example") CityMapServerExample example);

    int updateByExample(@Param("record") CityMapServer record, @Param("example") CityMapServerExample example);
}