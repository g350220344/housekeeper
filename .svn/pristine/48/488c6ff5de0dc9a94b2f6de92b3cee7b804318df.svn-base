package com.cindata.housekeeper.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.cindata.housekeeper.core.common.tools.*;
import com.cindata.housekeeper.core.entity.JSONResult;
import com.cindata.housekeeper.core.entity.Parameter;
import com.cindata.housekeeper.web.bean.SplitAddress;
import com.cindata.housekeeper.web.bean.SplitAddressInfo;
import com.cindata.housekeeper.web.model.*;
import com.cindata.housekeeper.web.service.CityService;
import com.cindata.housekeeper.web.service.DistrictService;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * 通用服务
 * @author yangss
 * @date   2017.06.20 09:47
 */
@Controller
@RequestMapping(value = "/common")
public class CommonController {
	private static Logger log = LoggerFactory.getLogger(CommunityInfoController.class);
	//调用北京接口
	public static final String lpbUrl = "http://a27.cindata.cn/api/";
	public static final String KEY = "6A082D664D3B4433E0534C0AA8C0202B";

	@Autowired
	private CityService cityService;
	@Autowired
	private DistrictService districtService;
	/**
	 * 查询城市列表
	 */
	@RequestMapping(value="/getCityList", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getCityList(HttpServletRequest request, HttpServletResponse response){
		String reqBody = ServletRequestHelper.getParameter(request, "cityId", "");
		StringUtil.isNotNullOrEmpty(reqBody);
		Map map = new HashMap();
		map.put("name", "123");
		map.put("age", 18);
		String a = (String) CommonHelper.mapGet(map, "haha");
		JSONResult<Map> res = new JSONResult<Map>(map, "成功", true);
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
	/**
	 * 字典加载
	 */
	@RequestMapping(value="/getPubList", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getPubList(HttpServletRequest request, HttpServletResponse response){
		JSONResult res = new JSONResult();

		String resBody = null;
		try {
			resBody = OpenapiPoster.post(null, "common/getPubList");
			res = (JSONResult) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult>(){}.getType());
			//res.setData(resBody);
			res.setMessage("ok");
			res.setStatusCode(1);
			res.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage() + "__request openapi error.");
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
	/**
	 * 行情接口（城市、行政区、小区）
	 */
	@RequestMapping(value="/getMarket", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getMarket(HttpServletRequest request, HttpServletResponse response){
		Long cityId = StringUtil.parseLong(request.getParameter("cityId"),null);
		Long communityId = StringUtil.parseLong(request.getParameter("communityId"),null);
		Long districtId = StringUtil.parseLong(request.getParameter("districtId"),null);

		JSONResult<Market> res = new JSONResult<Market>();
		List<CityMarket> cityMarketList = new ArrayList<CityMarket>();
		List<DistrictMarket> districtMarketList = new ArrayList<DistrictMarket>();
		List<CommunityMarket> communityMarketList = new ArrayList<CommunityMarket>();
		Market market = new Market();
		try {
			if (StringUtil.isNotNullOrEmpty(cityId) && StringUtil.isNotNullOrEmpty(communityId) && StringUtil.isNotNullOrEmpty(districtId)) {
				Date lastYearDate = StringUtil.getDate(StringUtil.getMonth(-12));
				Date date = new Date(System.currentTimeMillis());
				Parameter param = new Parameter();
				param.setCityId(cityId);
				param.setCommunityId(communityId);
				param.setDistrictId(districtId);
				param.setStartDate(date);
				param.setEndDate(lastYearDate);
				/*param.setLng(lng);
				param.setLat(lat);
				param.setRange(range);*/
				String resBody = OpenapiPoster.post(param, "analysis/getCityMarketList");
				JSONResult<List<CityMarket>> bean = (JSONResult<List<CityMarket>>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<List<CityMarket>>>() {
				}.getType());
				cityMarketList = bean.getData();
				resBody = OpenapiPoster.post(param, "analysis/getDistrictMarketList");
				JSONResult<List<DistrictMarket>> bean1 = (JSONResult<List<DistrictMarket>>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<List<DistrictMarket>>>() {
				}.getType());
				districtMarketList = bean1.getData();
				resBody = OpenapiPoster.post(param, "analysis/getCommunityMarketList");
				JSONResult<List<CommunityMarket>> bean2 = (JSONResult<List<CommunityMarket>>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<List<CommunityMarket>>>() {
				}.getType());
				communityMarketList = bean2.getData();
			}
			Double maxPrice = 0d;
			Double minPrice = 0d;
			Double nowMonthPrice = 0.0;
			Double lastMonthPrice = 0.0;
			Double saleSqmPriceLinkRelativeRatio = null;
			String month = StringUtil.getFirsDay(StringUtil.getMonth(0));
			String lastMonth = StringUtil.getLastMM()+"-01";
			//测试用
			//month = "2018-02-01";
			//lastMonth = "2017-08-01";
			if(communityMarketList!=null&&!communityMarketList.isEmpty()){
				for(int i=0;i<communityMarketList.size();i++){
					CommunityMarket communityMarket = communityMarketList.get(i);
					String date = StringUtil.dateFormat(communityMarket.getDayId(),"yyyy-MM-dd",null);
					Double price = StringUtil.parseDouble(communityMarket.getSalesqmprice(),0d);
					if(i==0){
						maxPrice = price;
						minPrice = price;
					}
					if(maxPrice<price){
						maxPrice = price;
					}
					if(minPrice>price){
						minPrice = price;
					}
					if(month.equals(date)){
						nowMonthPrice = price;
					}
					if(lastMonth.equals(date)){
						lastMonthPrice = price;
					}
				}
			}
			if(lastMonthPrice!=0.0&&nowMonthPrice!=0.0){
				saleSqmPriceLinkRelativeRatio = CommonHelper.getRisePercentDouble(nowMonthPrice, lastMonthPrice);

			}else{
				saleSqmPriceLinkRelativeRatio = 0.0;
			}
			market.setDate(month);
			market.setMaxPrice(maxPrice);
			market.setMinPrice(minPrice);
			market.setNowPercent(nowMonthPrice);
			market.setRisePercent(saleSqmPriceLinkRelativeRatio);

			market.setCityMarketList(cityMarketList);
			market.setCommunityMarketList(communityMarketList);
			market.setDistrictMarketList(districtMarketList);
			res.setData(market);
			res.setMessage("ok");
			res.setStatusCode(1);
			res.setSuccess(true);
		}
		catch (Exception e) {
			e.printStackTrace();
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}

	/**
	 * 省市区县接口
	 */
	@RequestMapping(value="/ProvinceCityDistrict", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String ProvinceCityDistrict(HttpServletRequest request, HttpServletResponse response){

		JSONResult<List<Map>> res = new JSONResult<List<Map>>();
		List<Map> list = new ArrayList<Map>();
		Long provinceId = StringUtil.parseLong(request.getParameter("provinceId"),null);
		Long cityId = StringUtil.parseLong(request.getParameter("cityId"),null);
		Integer type = StringUtil.parseInt(request.getParameter("type"),null);
		Parameter param = new Parameter();

		param.setProvinceId(provinceId);
		param.setCityId(cityId);
		param.setType(type);
		String resBody = OpenapiPoster.post(param, "common/ProvinceCityDistrict");
		JSONResult<List<Map>> bean = (JSONResult<List<Map>>) CtrlerUtil.json2bean(resBody, new com.google.common.reflect.TypeToken<JSONResult<List<Map>>>() {
		}.getType());

		list = bean.getData();
		try {
			//i = houseInfoService.updateHouseAvm();
			res.setData(list);
			res.setMessage("ok");
			res.setStatusCode(1);
			res.setSuccess(true);
		} catch (Exception e) {

			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}

		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}

	/**
	 * 房产信息拆分 （通过数据库匹配）
	 */
	@RequestMapping(value="/splitHousse", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String splitHousse(HttpServletRequest request, HttpServletResponse response){

		JSONResult<HouseInfo> res = new JSONResult<HouseInfo>();

		String cityName =request.getParameter("cityName");
		String info =request.getParameter("info");
		Map parmMap = new HashMap<String, Object>();
		String str = NumAndChineseUtil.hzsz(info);
		String buildingarea = SplitSquareUtil.zzcf(str);
		parmMap.put("address", info);
		if (cityName != null && !cityName.equals("")) {
			parmMap.put("city", cityName);
		}

		String mothed = "splitAddress";
		String url = lpbUrl + mothed + "?key=" + KEY;
		String jsonParam = StringUtil.toString(CommonHelper.getJsonObject(parmMap), null);
		String result = HttpRequest.httpPostWithJson(url, jsonParam);
		JSONResult<SplitAddress> dataBean = (JSONResult<SplitAddress>) CtrlerUtil.json2bean(result, new com.google.common.reflect.TypeToken<JSONResult<SplitAddress>>() {
		}.getType());
		//list = dataBean.getData();
		try {
			//i = houseInfoService.updateHouseAvm();
			if(dataBean.getData() != null) {
				SplitAddress splitAddress = dataBean.getData();
				HouseInfo houseInfo = new HouseInfo();
				houseInfo.setBuildingsquare(StringUtil.parseBigDecimal(buildingarea, null));

				if (StringUtil.isNotNullOrEmpty(splitAddress.getMatchBuildingName())) {
					String buildingName = splitAddress.getMatchBuildingName().split("栋")[0];
					if(StringUtil.parseInt(buildingName,null) ==null){
						buildingName = "";
					}
					houseInfo.setBuildingName(buildingName);

				}
				if (StringUtil.isNotNullOrEmpty(splitAddress.getMatchUnitName())) {
					String matchUnitName = splitAddress.getMatchUnitName().split("单元")[0];
					houseInfo.setUnitName(matchUnitName);
				}
				if (StringUtil.isNotNullOrEmpty(splitAddress.getMatchHouseName())) {
					houseInfo.setDoorNum(splitAddress.getMatchHouseName());
				}

				if (StringUtil.isNotNullOrEmpty(splitAddress.getMatchCommunityName())) {
					houseInfo.setCommunityName(splitAddress.getMatchCommunityName());
				}
				res.setData(houseInfo);
			}
			res.setMessage("ok");
			res.setStatusCode(1);
			res.setSuccess(true);
		} catch (Exception e) {

			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}

		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
	/**
	 * 房产信息拆分 （不通过数据库匹配）
	 */
	@RequestMapping(value="/splitHousseInfo", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String splitHousseInfo(HttpServletRequest request, HttpServletResponse response){

		JSONResult<HouseInfo> res = new JSONResult<HouseInfo>();

		String cityName =request.getParameter("cityName");
		String info =request.getParameter("info");

		Map parmMap = new HashMap<String, Object>();
		String str = SplitDianUtil.testDain(info);


		String buildingarea = SplitSquareUtil.zzcf(str);

		//String str = NumAndChineseUtil.hzsz(info);CITYMAPSERVER

		parmMap.put("address", str);
		if (cityName != null && !cityName.equals("")) {
			parmMap.put("city", cityName);
		}

		String mothed = "onlySplitAddress";
		String url = lpbUrl + mothed + "?key=" + KEY;
		String jsonParam = StringUtil.toString(CommonHelper.getJsonObject(parmMap), null);
		String result = HttpRequest.httpPostWithJson(url, jsonParam);
		JSONResult<SplitAddressInfo> dataBean = (JSONResult<SplitAddressInfo>) CtrlerUtil.json2bean(result, new com.google.common.reflect.TypeToken<JSONResult<SplitAddressInfo>>() {
		}.getType());
		//list = dataBean.getData();
		try {
			//i = houseInfoService.updateHouseAvm();
			if(dataBean.getData() != null) {
				SplitAddressInfo splitAddress = dataBean.getData();
				HouseInfo houseInfo = new HouseInfo();
				houseInfo.setBuildingsquare(StringUtil.parseBigDecimal(buildingarea, null));
				String s = "";
				if (StringUtil.isNotNullOrEmpty(splitAddress.getSpBuildingName())) {
					String buildingName = splitAddress.getSpBuildingName().split("栋")[0];
					if(StringUtil.parseInt(buildingName,null) ==null){
						buildingName = splitAddress.getSpRoadNo().split("号")[0];
						if(buildingName.indexOf("弄")>0){
							s = buildingName;
							buildingName = splitAddress.getSpBuildingName().split("号")[0];
						}else{
							buildingName = "";
						}
					}
					houseInfo.setBuildingName(buildingName);

				}else if(StringUtil.isNotNullOrEmpty(splitAddress.getSpRoadNo())){
					String buildingName = splitAddress.getSpRoadNo().split("号")[0];
					if(StringUtil.parseInt(buildingName,null) ==null){
						if(buildingName.indexOf("弄")>0){
							s = buildingName;
							buildingName = splitAddress.getSpBuildingName().split("号")[0];
						}else{
							buildingName = "";
						}

					}
					houseInfo.setBuildingName(buildingName);
				}

				if (StringUtil.isNotNullOrEmpty(splitAddress.getSpUnitName())) {
					String matchUnitName = splitAddress.getSpUnitName().split("单元")[0];

					houseInfo.setUnitName(matchUnitName);
				}

				if (StringUtil.isNotNullOrEmpty(splitAddress.getSpHouseName())) {
					String spHouseName = splitAddress.getSpHouseName().split("室")[0];
					if(StringUtil.parseInt(spHouseName,null) ==null){
						if(spHouseName.indexOf("弄")>0){
							s = spHouseName;
							spHouseName="";
						}
					}
					houseInfo.setDoorNum(spHouseName);
				}

				if (StringUtil.isNotNullOrEmpty(splitAddress.getSpCommunityName())) {
					houseInfo.setCommunityName(splitAddress.getSpCommunityName());
				}else if(StringUtil.isNotNullOrEmpty(splitAddress.getSpRoadName())){
					houseInfo.setCommunityName(splitAddress.getSpRoadName()+s);
				}
				res.setData(houseInfo);
			}
			res.setMessage("ok");
			res.setStatusCode(1);
			res.setSuccess(true);
		} catch (Exception e) {

			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}

		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
	/**
	 * 坐标转换接口
	 */
	@RequestMapping(value="/getMctXY", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getMctXY(HttpServletRequest request, HttpServletResponse response){

		JSONResult res = new JSONResult();

		Double lat = StringUtil.parseDouble(request.getParameter("lat"),null);
		Double lng = StringUtil.parseDouble(request.getParameter("lng"),null);
		try{

			res.setData(GisToolsUtil.BDtoMCT(lng,lat));
			res.setMessage("ok");
			res.setStatusCode(1);
			res.setSuccess(true);
		} catch (Exception e) {

			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}

		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
	/**
	 * 通过微信的经纬度 转换为地址信息
	 */
	@RequestMapping(value="/getLocationByWx", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getLocationByWx(HttpServletRequest request, HttpServletResponse response){

		JSONResult res = new JSONResult();

		String lat = request.getParameter("lat");
		String lon = request.getParameter("lon");
		try{
			if(StringUtil.isNotNullOrEmpty(lat)&&StringUtil.isNotNullOrEmpty(lon)){
				String url = "http://api.map.baidu.com/geocoder/v2/";
				String jwd = lat + "," + lon;
				//String json = "{'communityName':'x'}";
				//String str = HttpRequest.httpPostWithJson(url,json);
				String str = HttpRequest.sendGet(url,"location="+jwd+"&output=json&pois=1&ak=ISaVGtroCIszpRS455cYuZMuR8cNvaNt");
				JSONObject json = JSONObject.parseObject(str);
				if(json.getString("status").equals("0")){
					JSONObject result = JSONObject.parseObject(json.getString("result"));
					JSONObject addressComponent = JSONObject.parseObject(result.getString("addressComponent"));

					log.debug(addressComponent.getString("country"));
					log.debug(addressComponent.getString("city"));
					log.debug(addressComponent.getString("district"));

                    Parameter param = new Parameter();

                    param.setDistrictName(addressComponent.getString("district"));

                    String resBody = OpenapiPoster.post(param, "common/getDistrictListByDistrictName");
                    JSONResult<List<DistrictInfo>> bean = (JSONResult<List<DistrictInfo>>) CtrlerUtil.json2bean(resBody, new com.google.common.reflect.TypeToken<JSONResult<List<DistrictInfo>>>() {
                    }.getType());

                    List<DistrictInfo> list = bean.getData();
					//List<DistrictInfo> list = districtService.getDistrictInfoListByDistrictName(addressComponent.getString("district"));
					res.setData(list);
				}

			}
			res.setMessage("ok");
			res.setStatusCode(1);
			res.setSuccess(true);
		} catch (Exception e) {

			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}

		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
	/**
	 * arcgis 城市地图服务
	 */
	@RequestMapping(value="/getArcgisCityMapServer", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getArcgisCityMapServer(HttpServletRequest request, HttpServletResponse response){

		JSONResult res = new JSONResult();

		String cityName = request.getParameter("cityName");
		try{
			CityMapServer cityMapServer = cityService.getArcgisCityMapServer(cityName);
			res.setData(cityMapServer);
			res.setMessage("ok");
			res.setStatusCode(1);
			res.setSuccess(true);
		} catch (Exception e) {

			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}

		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
}
