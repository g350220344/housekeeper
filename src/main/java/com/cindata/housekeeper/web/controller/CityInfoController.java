package com.cindata.housekeeper.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.cindata.housekeeper.core.common.tools.CtrlerUtil;
import com.cindata.housekeeper.core.common.tools.OpenapiPoster;
import com.cindata.housekeeper.core.common.tools.StringUtil;
import com.cindata.housekeeper.core.entity.JSONResult;
import com.cindata.housekeeper.core.entity.Parameter;
import com.cindata.housekeeper.web.model.BaiduCityCode;
import com.cindata.housekeeper.web.model.CityInfo;
import com.cindata.housekeeper.web.model.CityMarket;
import com.cindata.housekeeper.web.model.CityTotleMarket;
import com.cindata.housekeeper.web.service.CityService;
import com.google.common.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.List;

/**
 * @Describe 城市信息接口
 * @Author  gaoy
 * @Time  2018/01/31 09:33:02
 * @param
 **/
@Controller
@RequestMapping(value = "/city")
public class CityInfoController {
	@Autowired
	private CityService cityService;

	
	private static Logger log = LoggerFactory.getLogger(CityInfoController.class);
	
	/**
	 * 城市行情接口
	 */
	@RequestMapping(value="/getCityMarket", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getCityMarket(HttpServletRequest request, HttpServletResponse response){
		Long cityId = StringUtil.parseLong(request.getParameter("cityId"), null);
		Date month = StringUtil.parseDate(request.getParameter("month"),null);
		JSONResult<CityMarket> res = null;
		String msg = "params is null";
		boolean success = false;
		CityMarket data = null;
		if(!StringUtil.isNotNullOrEmpty(month)){
			month = new Date(System.currentTimeMillis());
		}
		if(  StringUtil.isNotNullOrEmpty(cityId)){
			Parameter param = new Parameter();
			param.setMonth(month);
			param.setCityId(cityId);
			JSONResult<CityMarket> bean = null;
			String resBody = null;
			try {
				resBody = OpenapiPoster.post(param, "analysis/getCityMarket");
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e.getMessage() + "__request openapi error.");
			}
			try {
				bean = (JSONResult<CityMarket>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<CityMarket>>(){}.getType());
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e.getMessage() + "__openapi response gson to bean error.");
			}
			if(bean == null){
				msg = "request api error";
			}else{
				data = bean.getData();
				if(data == null){
					msg = "no data";
					success = true;
				}else{
					msg = "ok";
					success = true;
				}
			}
			
		}
		
		res = new JSONResult<CityMarket>(data, msg, success);
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}

	/**
	 * 百度地图映射接口
	 */
	@RequestMapping(value="/getCityCode", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getCityCode(HttpServletRequest request, HttpServletResponse response){
		Long cityId = StringUtil.parseLong(request.getParameter("areaId"), null);
		JSONResult<BaiduCityCode> res = null;
		String msg = "params is null";
		boolean success = false;
		BaiduCityCode data = null;
		int statusCode = 2;
		if( StringUtil.isNotNullOrEmpty(cityId)){
			Parameter param = new Parameter();
			param.setCityId(cityId);
			JSONResult<BaiduCityCode> bean = null;
			String resBody = null;
			try {
				resBody = OpenapiPoster.post(param, "common/getBaiduCityById");
				log.error(resBody);
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e.getMessage() + "__request openapi error.");
			}
			try {
				bean = (JSONResult<BaiduCityCode>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<BaiduCityCode>>(){}.getType());
				log.error(JSONObject.toJSONString(bean));
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e.getMessage() + "__openapi response gson to bean error.");
			}
			if(bean == null){
				msg = "request api error";
			}else{
				data = bean.getData();
				if(data == null){
					msg = "no data";
				}else{
					msg = "ok";
					success = true;
					statusCode = 1;
				}
			}

		}

		res = new JSONResult<BaiduCityCode>(data, msg, success);
		res.setStatusCode(statusCode);
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
	
	
	/**
	 * 城市搜索接口(根据城市名称和字母查询)
	 */
	@RequestMapping(value="/getCityInfoListBycityName", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getCityInfoListBycityName(HttpServletRequest request, HttpServletResponse response){
		String cityName = request.getParameter("cityName");
		String cityPy = request.getParameter("cityPy");
		List<CityInfo> cityInfoList = null;
		JSONResult<List<CityInfo>> res = new JSONResult<List<CityInfo>>();
		CityInfo cityInfo = new CityInfo();
		cityInfo.setCityName(cityName);
		cityInfo.setCityPy(cityPy);
		try {
		 cityInfoList = cityService.getCityInfoListBycityName(cityInfo);
		 res.setData(cityInfoList);
		 res.setMessage("ok");
		 res.setStatusCode(1);
		 res.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			res.setData(cityInfoList);
		    res.setMessage("no ok");
			res.setStatusCode(2);
		    res.setSuccess(false);
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}

	/**
	 * 获取热门城市
	 */
	@RequestMapping(value="/getCityInfoListHoT", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getCityInfoListHoT(HttpServletRequest request, HttpServletResponse response){
		List<CityInfo> cityInfoList = null;
		JSONResult<List<CityInfo>> res = new JSONResult<List<CityInfo>>();
		try {
			cityInfoList = cityService.getCityInfoListHoT();
			res.setData(cityInfoList);
			res.setMessage("ok");
			res.setStatusCode(1);
			res.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			res.setData(cityInfoList);
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
	
	/**
	 * 热门城市搜索(根据拼音默认为A)
	 */
	@RequestMapping(value="/getCityInfoListByCityNameAndPinyin", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getCityInfoListBycityPy(HttpServletRequest request, HttpServletResponse response){
		String cityName = request.getParameter("cityName");
		String cityPy = request.getParameter("cityPy");
		List<CityInfo> cityInfoList = null;
		CityInfo cityInfo = new CityInfo();
		cityInfo.setCityName(cityName);
		cityInfo.setCityPy(cityPy);
		JSONResult<List<CityInfo>> res = new JSONResult<>();
		try {
		 cityInfoList = cityService.getCityInfoListByCityNameAndPinyin(cityInfo);
		 res.setData(cityInfoList);
		 res.setMessage("ok");
		 res.setStatusCode(1);
		 res.setSuccess(true);
		} catch (Exception e) {
		res.setData(cityInfoList);
	    res.setMessage("no ok");
		res.setStatusCode(2);
	    res.setSuccess(false);
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
	/**
	 * 获取城市信息
	 */
	@RequestMapping(value="/getCityInfo", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getCityInfo(HttpServletRequest request, HttpServletResponse response){
		Long cityId = StringUtil.parseLong(request.getParameter("cityId"),null);

		JSONResult<CityInfo> res = new JSONResult<CityInfo>();
		try {

			Parameter paramCityId = new Parameter();
			if(StringUtil.isNotNullOrEmpty(cityId)){
				paramCityId.setCityId(cityId);
				String resBodycity = OpenapiPoster.post(paramCityId, "common/getCityByCityId");
				CityInfo citydata = new CityInfo();
				JSONResult<CityInfo> beancity= (JSONResult<CityInfo>) CtrlerUtil.json2bean(resBodycity, new TypeToken<JSONResult<CityInfo>>(){}.getType());
				if(beancity.getData()!=null){
					citydata = beancity.getData();
				}
				res.setData(citydata);
				res.setMessage("ok");
				res.setStatusCode(1);
				res.setSuccess(true);
			}else{
				res.setMessage("no ok");
				res.setStatusCode(2);
				res.setSuccess(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
	
	
	
	/**
	 * 全国城市行情接口
	 */
	@RequestMapping(value="/getCityMarketAnalysis", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getCityMarketAnalysis(HttpServletRequest request, HttpServletResponse response){
		JSONResult<CityTotleMarket> res = null;
		String msg = "params is null";
		boolean success = false;
		CityTotleMarket data = null;
		
			Date month = new Date(System.currentTimeMillis());
		
			JSONResult<CityTotleMarket> bean = null;
			String resBody = null;
			try {
				resBody = OpenapiPoster.post(null, "analysis/getCityMarketAnalysis");
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e.getMessage() + "__request openapi error.");
			}
			try {
				bean = (JSONResult<CityTotleMarket>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<CityTotleMarket>>(){}.getType());
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e.getMessage() + "__openapi response gson to bean error.");
			}
			if(bean == null){
				msg = "request api error";
			}else{
				data = bean.getData();
				if(data == null){
					msg = "no data";
					success = true;
				}else{
					msg = "ok";
					success = true;
				}
			}
			
		
		
		res = new JSONResult<CityTotleMarket>(data, msg, success);
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
}
