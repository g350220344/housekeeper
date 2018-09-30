package com.cindata.housekeeper.web.dao;

import com.cindata.housekeeper.core.entity.Parameter;
import com.cindata.housekeeper.web.model.HouseInfo;
import com.cindata.housekeeper.web.model.HouseInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface HouseInfoMapper {
    Long countByExample(HouseInfoExample example);

    int deleteByExample(HouseInfoExample example);

    int insert(HouseInfo record);

    int insertSelective(HouseInfo record);

    List<HouseInfo> selectByExample(HouseInfoExample example);

    int updateByExampleSelective(@Param("record") HouseInfo record, @Param("example") HouseInfoExample example);

    int updateByExample(@Param("record") HouseInfo record, @Param("example") HouseInfoExample example);
    
    HouseInfo selectHouseInfoByHouseId(Integer houseId);

    List<Map> getHouseTop(Parameter params);

    List<Map> getHousePriceTop(@Param("groupId")String groupId);

    List<HouseInfo> getHouseList(Parameter params);

    List<Map> getHouseListCount(Parameter params);

    Map houseCountAndPrice(Parameter parameter);

    Map userAvgHouse(Parameter parameter);

	int houseAvmDayLimit(Parameter param);

	int houseAvmMonthLimit(Parameter param);

	List<HouseInfo> getHouseTopPx();
}