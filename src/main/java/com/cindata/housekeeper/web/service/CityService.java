package com.cindata.housekeeper.web.service;

import com.cindata.housekeeper.web.model.CityInfo;
import com.cindata.housekeeper.web.model.CityMapServer;

import java.util.List;


@SuppressWarnings("rawtypes")
public interface CityService {
	
	/**
	 * 查询城市列表
	 */
	List<CityInfo> getCityInfoList();


	String getCommunityList(String cityId, String districtId, String communityId, String communityName, String lng, String lat, Integer range);
	
	 List<CityInfo>getCityInfoListBycityName(CityInfo cityInfo);

	List<CityInfo>getCityInfoListBycityPy(String cityPy);
	List<CityInfo>getCityInfoListByCityNameAndPinyin(CityInfo cityInfo);

    List<CityInfo> getCityInfoListHoT();

    CityMapServer getArcgisCityMapServer(String cityName);
}
