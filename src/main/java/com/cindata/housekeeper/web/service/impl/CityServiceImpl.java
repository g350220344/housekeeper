package com.cindata.housekeeper.web.service.impl;

import com.cindata.housekeeper.core.common.tools.HttpRequest;
import com.cindata.housekeeper.core.common.tools.StringUtil;
import com.cindata.housekeeper.web.dao.CityInfoMapper;
import com.cindata.housekeeper.web.dao.CityMapServerMapper;
import com.cindata.housekeeper.web.model.CityInfo;
import com.cindata.housekeeper.web.model.CityMapServer;
import com.cindata.housekeeper.web.model.CityMapServerExample;
import com.cindata.housekeeper.web.service.CityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class CityServiceImpl implements CityService {
	
	@Resource
	private CityInfoMapper cityInfoMapper;
	@Resource
	private CityMapServerMapper cityMapServerMapper;

	@Override
	public List<CityInfo> getCityInfoList() {

		return cityInfoMapper.getCityInfoList();
	}

	@Override
	public String getCommunityList(String cityId, String districtId, String communityId, String communityName, String lng, String lat, Integer range) {
		String url = "http://localhost:8088/openapi/rest/community/searchCommunity";
		//String json = "{'communityName':'x'}";
		//String str = HttpRequest.httpPostWithJson(url,json);
        String str = HttpRequest.sendPost(url,"communityName=x","UTF-8");
		return str;
	}


	@Override
	public List<CityInfo> getCityInfoListBycityPy(String cityPy) {

		return cityInfoMapper.getCityInfoListBycityPy(cityPy);
	}
	@Override
	public List<CityInfo> getCityInfoListByCityNameAndPinyin(CityInfo cityInfo) {
		//param.put("pinyin", StringUtil.getPingYin(communityName));
		if(StringUtil.isNotNullOrEmpty(cityInfo.getCityName())) {
			cityInfo.setCityShortPy(StringUtil.getPingYin(cityInfo.getCityName().toUpperCase()));
		}
		return cityInfoMapper.getCityInfoListByCityNameAndPinyin(cityInfo);
	}

	@Override
	public List<CityInfo> getCityInfoListHoT() {
		return cityInfoMapper.getCityInfoListHoT();
	}

	@Override
	public CityMapServer getArcgisCityMapServer(String cityName) {
		CityMapServerExample cityMapServerExample =new CityMapServerExample();
		CityMapServerExample.Criteria cri = cityMapServerExample.createCriteria();
		cri.andCityNameEqualTo(cityName);
		List<CityMapServer> list = cityMapServerMapper.selectByExample(cityMapServerExample);
		if(!list.isEmpty()){
			return list.get(0);
		}else{
			return null;
		}

	}

	@Override
	public List<CityInfo> getCityInfoListBycityName(CityInfo cityInfo) {
		//param.put("pinyin", StringUtil.getPingYin(communityName));
		if(StringUtil.isNotNullOrEmpty(cityInfo.getCityName())) {
			cityInfo.setCityShortPy(StringUtil.getPingYin(cityInfo.getCityName()));
		}
		return cityInfoMapper.getCityInfoListByCityNameAndPinyin(cityInfo);
	}
}
