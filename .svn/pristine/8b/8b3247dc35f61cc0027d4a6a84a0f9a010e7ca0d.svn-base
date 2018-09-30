package com.cindata.housekeeper.web.service;

import com.cindata.housekeeper.core.entity.Parameter;
import com.cindata.housekeeper.web.model.ChangeHomeInfo;

import com.cindata.housekeeper.web.model.HouseAvmLog;
import com.cindata.housekeeper.web.model.HouseChangeLog;
import com.cindata.housekeeper.web.model.HouseInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface HouseInfoService {
    int addHouse(HouseInfo houseInfo);

    List<HouseInfo> getHouseByuserId(String userId);

    int updateHouse(HouseInfo houseInfo);
      
    HouseInfo selectHouseInfoByHouseId(Integer houseId);

    /**
     * @Describe 每月评估所有房产，更新数据
     * @Author  gaoy
     * @Time  2018/02/05 02:29:01
     * @param null
     **/
    int updateHouseAvm();

    int addHouseAvm(HouseAvmLog houseAvmLog);

    List<HouseAvmLog> getHouseAvmLogByHouseId(BigDecimal houseId);

	HouseInfo lastInsertHouse(String userId);

	int replaceSuggestion(HouseChangeLog param);

    List<Map> getHouseTop(Parameter params);

    List<Map> getHousePriceTop(String groupId);

    List<HouseInfo> getHouseList(Parameter params);

    List<Map> getHouseListCount(Parameter params);

    Map houseCountAndPrice();

    Map houseCountAndPriceYesterday();

    Map userAvgHouse();

	int houseAvmDayLimit(Parameter param);

	int houseAvmMonthLimit(Parameter param);

	List<HouseInfo> getHouseTop();
}
