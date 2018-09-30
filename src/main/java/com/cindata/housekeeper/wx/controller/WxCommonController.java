package com.cindata.housekeeper.wx.controller;

import com.alibaba.fastjson.JSONObject;
import com.cindata.housekeeper.core.common.tools.*;
import com.cindata.housekeeper.core.entity.JSONResult;
import com.cindata.housekeeper.core.entity.Parameter;
import com.cindata.housekeeper.web.bean.SplitAddress;
import com.cindata.housekeeper.web.bean.SplitAddressInfo;
import com.cindata.housekeeper.web.model.*;
import com.cindata.housekeeper.web.service.CityService;
import com.cindata.housekeeper.web.service.DistrictService;
import com.google.common.collect.Maps;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/WxCommon")
public class WxCommonController {

	
	private static Logger log = LoggerFactory.getLogger(WxCommonController.class);

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
		if(cityName.indexOf("市")<0){
			cityName = cityName+"市";
		}
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
					if(!list.isEmpty()){
						for(int i=0;i<list.size();i++){
							if(list.get(i).getCiytName().indexOf(addressComponent.getString("city"))>=0){
								res.setData(list.get(i));
							}
						}

					}

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
		List cityMarketList = new ArrayList();
		List districtMarketList = new ArrayList();
		List communityMarketList = new ArrayList();
		Market market = new Market();

		try {
			Date lastYearDate = StringUtil.getDate(StringUtil.getMonth(-12));
			Parameter param = new Parameter();
			param.setStartDate(new Date(System.currentTimeMillis()));
			param.setEndDate(lastYearDate);
			int month = 6;
			String priceName = "getSalesqmprice";
			if (StringUtil.isNotNullOrEmpty(cityId) ) {
				param.setCityId(cityId);
				String resBody = OpenapiPoster.post(param, "analysis/getCityMarketList");
				JSONResult<List<CityMarket>> bean = (JSONResult<List<CityMarket>>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<List<CityMarket>>>() {
				}.getType());
				List<CityMarket> list = bean.getData();
				if(!list.isEmpty()) {
					cityMarketList = StringUtil.dateFormat(list, month,priceName);
				}
			}
			if(StringUtil.isNotNullOrEmpty(communityId)){
				param.setCommunityId(communityId);
				String resBody = OpenapiPoster.post(param, "analysis/getCommunityMarketList");
				JSONResult<List<CommunityMarket>> bean = (JSONResult<List<CommunityMarket>>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<List<CommunityMarket>>>() {
				}.getType());
				List<CommunityMarket> list = bean.getData();
				if(!list.isEmpty()) {
					communityMarketList = StringUtil.dateFormat(list, month,priceName);
				}
			}
			if(StringUtil.isNotNullOrEmpty(districtId)){
				param.setDistrictId(districtId);
				String resBody = OpenapiPoster.post(param, "analysis/getDistrictMarketList");
				JSONResult<List<DistrictMarket>> bean = (JSONResult<List<DistrictMarket>>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<List<DistrictMarket>>>() {
				}.getType());
				List<DistrictMarket> list = bean.getData();
				if(!list.isEmpty()) {
					districtMarketList = StringUtil.dateFormat(list, month,priceName);
				}
			}
			/*Double maxPrice = 0d;
			Double minPrice = 0d;
			Double nowMonthPrice = 0.0;
			Double lastMonthPrice = 0.0;
			Double saleSqmPriceLinkRelativeRatio = null;
			String month = StringUtil.getFirsDay(StringUtil.getMonth(0));
			String lastMonth = StringUtil.getLastMM()+"01";
			//测试用
			//month = "2018-07-01";
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
*/
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
	 * 行情接口（城市、行政区、小区）12月
	 */
	@RequestMapping(value="/getMarketYear", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getMarketYear(HttpServletRequest request, HttpServletResponse response){
		Long cityId = StringUtil.parseLong(request.getParameter("cityId"),null);
		Long communityId = StringUtil.parseLong(request.getParameter("communityId"),null);
		Long districtId = StringUtil.parseLong(request.getParameter("districtId"),null);

		JSONResult<Market> res = new JSONResult<Market>();
		List cityMarketList = new ArrayList();
		List districtMarketList = new ArrayList();
		List communityMarketList = new ArrayList();
		Market market = new Market();

		try {
			Date lastYearDate = StringUtil.getDate(StringUtil.getMonth(-12));
			Parameter param = new Parameter();
			param.setStartDate(new Date(System.currentTimeMillis()));
			param.setEndDate(lastYearDate);
			int month = 12;
			String priceName = "getSalesqmprice";
			if (StringUtil.isNotNullOrEmpty(cityId) ) {
				param.setCityId(cityId);
				String resBody = OpenapiPoster.post(param, "analysis/getCityMarketList");
				JSONResult<List<CityMarket>> bean = (JSONResult<List<CityMarket>>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<List<CityMarket>>>() {
				}.getType());
				List<CityMarket> list = bean.getData();
				if(!list.isEmpty()){
					market.setCityName(list.get(0).getCityName());
					cityMarketList = StringUtil.dateFormat(list,month,priceName);
				}
			}
			if(StringUtil.isNotNullOrEmpty(communityId)){
				param.setCommunityId(communityId);
				String resBody = OpenapiPoster.post(param, "analysis/getCommunityMarketList");
				JSONResult<List<CommunityMarket>> bean = (JSONResult<List<CommunityMarket>>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<List<CommunityMarket>>>() {
				}.getType());
				List<CommunityMarket> list = bean.getData();
				if(!list.isEmpty()) {
					market.setCommunityName(list.get(0).getCommunityName());
					communityMarketList = StringUtil.dateFormat(list, month,priceName);
				}
			}
			if(StringUtil.isNotNullOrEmpty(districtId)){
				param.setDistrictId(districtId);
				String resBody = OpenapiPoster.post(param, "analysis/getDistrictMarketList");
				JSONResult<List<DistrictMarket>> bean = (JSONResult<List<DistrictMarket>>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<List<DistrictMarket>>>() {
				}.getType());
				List<DistrictMarket> list = bean.getData();
				if(!list.isEmpty()) {
					market.setDistrictName(list.get(0).getDistrictName());
					districtMarketList = StringUtil.dateFormat(list, month,priceName);
				}
			}
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
	 * 租金走势
	 */
	@RequestMapping(value="/getCommunityRent", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getCommunityRent(HttpServletRequest request, HttpServletResponse response){
		Long communityId = StringUtil.parseLong(request.getParameter("communityId"),null);
		JSONResult<Map> res = new JSONResult<>();

		if(StringUtil.isNotNullOrEmpty(communityId)){
			try {
				Parameter param = new Parameter();
				param.setCommunityId(communityId);
				String resBody = OpenapiPoster.post(param, "community/getCommunityRent");
				JSONResult<Map<String,List<RentTrend>>> bean = (JSONResult<Map<String,List<RentTrend>>>) CtrlerUtil.json2bean(resBody, new com.google.common.reflect.TypeToken<JSONResult<Map<String,List<RentTrend>>>>(){}.getType());
				Map<String,List<RentTrend>> data = bean.getData();
				int month = 12;
				String priceName = "getRentsqmprice";
				List oneRoom = new ArrayList();
				List twoRoom = new ArrayList();
				List threeRoom = new ArrayList();
				Map map = new HashMap();

				if(!data.isEmpty()){
					if(data.containsKey("oneRoom")){
						List<RentTrend> list = data.get("oneRoom");
						oneRoom = StringUtil.dateFormat(list,month,priceName);
						//map.put("onrRoomlist",list);
					}
					if(data.containsKey("twoRoom")){
						List<RentTrend> list = data.get("twoRoom");
						twoRoom = StringUtil.dateFormat(list,month,priceName);
						//map.put("onrRoomlist",list);
					}
					if(data.containsKey("threeRoom")){
						List<RentTrend> list = data.get("threeRoom");
						threeRoom = StringUtil.dateFormat(list,month,priceName);
						//map.put("onrRoomlist",list);
					}
				}
				map.put("oneRoom",oneRoom);
				map.put("twoRoom",twoRoom);
				map.put("threeRoom",threeRoom);
				res.setData(map);
				res.setStatusCode(1);
				res.setMessage("ok");
				res.setSuccess(true);
			} catch (Exception e) {
				e.printStackTrace();
				res.setStatusCode(2);
				res.setMessage("no ok");
				res.setSuccess(false);
			}
		}else{
			res.setStatusCode(2);
			res.setMessage("no ok");
			res.setSuccess(false);
		}

		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
	/**
	 * 税费计算
	 */
	@RequestMapping(value="/getTax", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getTax(HttpServletRequest request, HttpServletResponse response){
		double Square = StringUtil.parseDouble(request.getParameter("square"),null);
		double totalPrice = StringUtil.parseDouble(request.getParameter("totalPrice"),null);
		int isOnlyOne = StringUtil.parseInt(request.getParameter("isOnlyOne"),null);;
		int houseOld = StringUtil.parseInt(request.getParameter("houseOld"),null);
		int floor = StringUtil.parseInt(request.getParameter("floor"),null);
		JSONResult res = new JSONResult();

		try {
			//double totalPrice = unitPrice * Square;// 房屋总价
			double sumFee;// 税费合计
			double deedTax = 0;// 契税--
			double salesTax = 0;// 营业税
			double incomeTax = 0;//所得税
			double agencyFee = Square * 6;// 交易手续费
			double maintenanceFund = 0;// 维修基金
			double printing = 5;// 印花税
			double work = 80;// 工本费

			if (Square <= 90) {
				deedTax = totalPrice*0.01;
			}else {
				if (isOnlyOne == 1) {
					deedTax = totalPrice*0.015;
				}else {
					deedTax = totalPrice*0.02;
				}
			}

			if (houseOld<2) {
				salesTax = totalPrice * 0.056;
				incomeTax = totalPrice * 0.01;
			}else {
				salesTax = 0;
				if (isOnlyOne == 1) {
					incomeTax = 0;
				}else {
					incomeTax = totalPrice * 0.01;
				}
			}

			if (floor < 9) {
				maintenanceFund = Square * 20;
			}else {
				maintenanceFund = Square * 32;
			}

			sumFee = deedTax + salesTax + incomeTax;// 税费合计
			Map map = new HashMap();
			map.put("sumFee",sumFee);
			map.put("deedTax",deedTax);
			map.put("salesTax",salesTax);
			map.put("incomeTax",incomeTax);
			map.put("agencyFee",agencyFee);
			map.put("maintenanceFund",maintenanceFund);
			map.put("printing",printing);
			map.put("work",work);
			res.setData(map);
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
	 * 税费计算
	 */
	@RequestMapping(value="/getHouseLoans", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getHouseLoans(HttpServletRequest request, HttpServletResponse response){
		Map map = new HashMap();
		int year = StringUtil.parseInt(request.getParameter("year"),null);
		double totalPrice = StringUtil.parseDouble(request.getParameter("totalPrice"),null);
		int firstPay = StringUtil.parseInt(request.getParameter("firstPay"),null);
		double rate = StringUtil.parseDouble(request.getParameter("rate"),null) / 100;
		JSONResult res = new JSONResult();
		double loanPrice = totalPrice - totalPrice * firstPay / 10;
		map.put("totalPrice",new BigDecimal(totalPrice/10000).setScale(2, RoundingMode.UP)+"万");
		map.put("firstPrice",new BigDecimal(totalPrice * firstPay / 10 /10000).setScale(2, RoundingMode.UP)+"万");
		map.put("loanPrice",new BigDecimal(loanPrice/10000).setScale(2, RoundingMode.UP)+"万");
		try {

			//等额本息
			double invest = loanPrice; // 本金
			int month = 12*year;
			double yearRate = rate; // 年利率
			double perMonthPrincipalInterest = EqualAmountOfInterestUtils.getPerMonthPrincipalInterest(invest, yearRate, month);
			System.out.println("等额本息---每月还款本息：" + perMonthPrincipalInterest);
			Map<Integer, BigDecimal> mapInterest =  EqualAmountOfInterestUtils.getPerMonthInterest(invest, yearRate, month);
			System.out.println("等额本息---每月还款利息：" + mapInterest);
			Map<Integer, BigDecimal> mapPrincipal =  EqualAmountOfInterestUtils.getPerMonthPrincipal(invest, yearRate, month);
			System.out.println("等额本息---每月还款本金：" + mapPrincipal);
			double count =  EqualAmountOfInterestUtils.getInterestCount(invest, yearRate, month);
			System.out.println("等额本息---总利息：" + count);
			double principalInterestCount =  EqualAmountOfInterestUtils.getPrincipalInterestCount(invest, yearRate, month);
			System.out.println("等额本息---应还本息总和：" + principalInterestCount);
			Map debxmap =new HashMap();
			debxmap.put("monthPrice",Math.round(perMonthPrincipalInterest)+"元");
			debxmap.put("interest",new BigDecimal(count/10000).setScale(2, RoundingMode.UP)+"万");
			debxmap.put("year",year+"年");
			map.put("debx",debxmap);
			//等额本金

			Map<Integer, Double> getPerMonthPrincipalInterest = EqualAmountOfPrincipalUtils.getPerMonthPrincipalInterest(invest, yearRate, month);
			System.out.println("等额本金---每月本息：" + getPerMonthPrincipalInterest);
			double benjin = EqualAmountOfPrincipalUtils.getPerMonthPrincipal(invest, month);
			System.out.println("等额本金---每月本金:" + benjin);
			Map<Integer, Double> mapInterest1 = EqualAmountOfPrincipalUtils.getPerMonthInterest(invest, yearRate, month);
			System.out.println("等额本金---每月利息:" + mapInterest1);

			count = EqualAmountOfPrincipalUtils.getInterestCount(invest, yearRate, month);
			System.out.println("等额本金---总利息：" + count);
			System.out.println("等额本金---应还本息总和：" + (invest + count));
			Map debjmap =new HashMap();
			debjmap.put("firstMonthPrice",Math.round(getPerMonthPrincipalInterest.get(1))+"元");
			debjmap.put("monthMin","￥"+(Math.round(getPerMonthPrincipalInterest.get(1))-Math.round(getPerMonthPrincipalInterest.get(2))));
			debjmap.put("interest",new BigDecimal(count/10000).setScale(2, RoundingMode.UP)+"万");
			debjmap.put("year",year+"年");
			map.put("debj",debjmap);
			res.setData(map);
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
     * @description: 租金收益率(城市、行政区、小区)
     * @author: liuyanming
     * @create: 2018/8/15 14:33
     **/
    @RequestMapping(value="/getRentalPriceRatio", produces="text/html;charset=UTF-8")
    @ResponseBody
    public String getRentalPriceRatio(HttpServletRequest request, HttpServletResponse response){
        Long cityId = StringUtil.parseLong(request.getParameter("cityId"),null);
        Long communityId = StringUtil.parseLong(request.getParameter("communityId"),null);
        Long districtId = StringUtil.parseLong(request.getParameter("districtId"),null);
        JSONResult<Map<String, Object>> res = new JSONResult();
        try {
            Map<String, Object> resMap = Maps.newHashMap();
            Parameter param = new Parameter();
            param.setMonth(new Date(System.currentTimeMillis()));
            if (StringUtil.isNotNullOrEmpty(cityId) ) {
                param.setCityId(cityId);
                String resBody = OpenapiPoster.post(param, "analysis/getCityMarket");
                JSONResult<CityMarket> bean = (JSONResult<CityMarket>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<CityMarket>>() {
                }.getType());
                if(StringUtil.isNotNullOrEmpty(bean)) {
                    CityMarket cityMarket = (CityMarket) bean.getData();
                    resMap.put("cityName", cityMarket.getCityName());
                    resMap.put("cityRatio", cityMarket.getRentalPriceRatio());
                }
            }
            if(StringUtil.isNotNullOrEmpty(districtId)){
                param.setDistrictId(districtId);
                String resBody = OpenapiPoster.post(param, "analysis/getDistrictMarket");
                JSONResult<DistrictMarket> bean = (JSONResult<DistrictMarket>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<DistrictMarket>>() {
                }.getType());
                if(StringUtil.isNotNullOrEmpty(bean)) {
                    DistrictMarket districtMarket = bean.getData();
                    resMap.put("districtName", districtMarket.getDistrictName());
                    resMap.put("districtRatio", districtMarket.getRentalPriceRatio());
                }
            }
            if(StringUtil.isNotNullOrEmpty(communityId)){
                param.setCommunityId(communityId);
                String resBody = OpenapiPoster.post(param, "analysis/getCommunityMarket");
                JSONResult<CommunityMarket> bean = (JSONResult<CommunityMarket>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<CommunityMarket>>() {
                }.getType());
                if(StringUtil.isNotNullOrEmpty(bean)) {
                    CommunityMarket communityMarket = bean.getData();
                    resMap.put("communityName", communityMarket.getCommunityName());
                    resMap.put("communityRatio", communityMarket.getRentalPriceRatio());
                }
            }
            res.setData(resMap);
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
}
