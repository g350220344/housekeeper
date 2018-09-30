package com.cindata.housekeeper.web.controller;

import com.cindata.housekeeper.core.common.tools.*;
import com.cindata.housekeeper.core.entity.JSONResult;
import com.cindata.housekeeper.core.entity.Parameter;
import com.cindata.housekeeper.job.ant.SendJPushThread;
import com.cindata.housekeeper.web.bean.CommunityScore;
import com.cindata.housekeeper.web.model.*;
import com.google.common.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.*;

/**
 * 通用服务
 * @author yangss
 * @date   2018.01.30 10:57
 */
@Controller
@RequestMapping(value = "/community")
public class CommunityInfoController {

	private static Logger log = LoggerFactory.getLogger(CommunityInfoController.class);
	//public static final String lpbUrl = "http://avmapi.cindata.cn/api/";
	//public static final String KEY = "5CBC470DBAFEBCC5E0532901A8C0CD5B";

	public static final String lpbUrl = "http://a27.cindata.cn/api/";
	public static final String KEY = "5CBC470DBAFEBCC5E0532901A8C0CD5B";
	/**
	 * 小区搜索接口
	 */
	@RequestMapping(value="/searchCommunity", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getCityList(HttpServletRequest request, HttpServletResponse response){
		String communityName = ServletRequestHelper.getParameter(request, "communityName", null);
		Long cityId = StringUtil.parseLong(request.getParameter("cityId"), null);
		JSONResult<List<ApplyCommunityInfo>> res = null;
		String msg = "params is null";
		boolean success = false;
		List<ApplyCommunityInfo> data = null;
		if(StringUtil.isNotNullOrEmpty(communityName) && StringUtil.isNotNullOrEmpty(cityId)){
			Parameter param = new Parameter();
			param.setCommunityName(communityName);
			param.setCityId(cityId);
			JSONResult<List<ApplyCommunityInfo>> bean = null;
			String resBody = null;
			try {
				resBody = OpenapiPoster.post(param, "community/searchCommunity");
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e.getMessage() + "__request openapi error.");
			}
			try {
				bean = (JSONResult<List<ApplyCommunityInfo>>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<List<ApplyCommunityInfo>>>(){}.getType());
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e.getMessage() + "__openapi response gson to bean error.");
			}
			if(bean == null){
				msg = "request api error";
			}else{
				data = bean.getData();
				if(data == null || data.isEmpty()){
					msg = "no data";
				}else{
					msg = "ok";
					success = true;
				}
			}

		}

		res = new JSONResult<List<ApplyCommunityInfo>>(data, msg, success);
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
	/**
	 * 小区详情接口
	 */
	@RequestMapping(value="/getApplyCommunityInfo", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getApplyCommunityInfo(HttpServletRequest request, HttpServletResponse response){
		Long communityId = StringUtil.parseLong(request.getParameter("communityId"),null);
		JSONResult<ApplyCommunityInfo> res = new JSONResult<ApplyCommunityInfo>();

		ApplyCommunityInfo data = null;
		if(StringUtil.isNotNullOrEmpty(communityId) ){
			Parameter param = new Parameter();
			param.setCommunityId(communityId);
			try {
				String resBody = OpenapiPoster.post(param, "community/getApplyCommunityInfo");
				JSONResult<ApplyCommunityInfo> bean = (JSONResult<ApplyCommunityInfo>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<ApplyCommunityInfo>>() {
				}.getType());
				data = bean.getData();
				//获取评分
				String resBody1 = OpenapiPoster.post(param, "community/getCommunityScore");
				JSONResult<CommunityScore> bean1 = (JSONResult<CommunityScore>) CtrlerUtil.json2bean(resBody1, new TypeToken<JSONResult<CommunityScore>>() {
				}.getType());
				if (bean1.isSuccess() && bean1.getData() != null) {
					CommunityScore communityScore = bean1.getData();
					//评分需求0-5
					data.setCommunityScore(StringUtil.parseBigDecimal(communityScore.getScoreAll() / 2, null));
				}
				//当前时间
				Date month = new Date(System.currentTimeMillis());
				//TODO:默认时间，为了数据，测试用，
				//Date month = StringUtil.getDate("2018-04-01");
				//获取行情
				if(StringUtil.isNotNullOrEmpty(month) && StringUtil.isNotNullOrEmpty(communityId)) {

					param.setMonth(month);

					String resBody2 = OpenapiPoster.post(param, "analysis/getCommunityMarket");
					JSONResult<CommunityMarket> bean2= (JSONResult<CommunityMarket>) CtrlerUtil.json2bean(resBody2, new TypeToken<JSONResult<CommunityMarket>>(){}.getType());
					if (bean2.isSuccess() && bean2.getData() != null) {
						CommunityMarket communityMarket = bean2.getData();
						data.setSalesqmprice(communityMarket.getSalesqmprice());
						data.setSaleSqmPriceLinkRelativeRatio(StringUtil.parseBigDecimal(communityMarket.getSaleSqmPriceLinkRelativeRatio(),null));
						data.setDayId(StringUtil.formatDateString(communityMarket.getDayId(),"yyyy-MM-dd"));
					}
					res.setData(data);
				}

				res.setData(data);
				res.setMessage("ok");
				res.setStatusCode(1);
				res.setSuccess(true);
			}catch (Exception e) {
				e.printStackTrace();
				res.setMessage("no ok");
				res.setStatusCode(2);
				res.setSuccess(false);
			}
		}else{
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}

		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
	/**
	 * 小区行情接口
	 */
	@RequestMapping(value="/getCommunityMarket", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getCommunityMarket(HttpServletRequest request, HttpServletResponse response){
		JSONResult res = new JSONResult();
		Long communityId = StringUtil.parseLong(request.getParameter("communityId"),null);
		//Date month = Date.valueOf(request.getParameter("month"));
		//当前时间
		Date month = new Date(System.currentTimeMillis());
		//TODO:默认时间，为了数据，测试用，
		//Date month = StringUtil.getDate("2018-04-01");
		CommunityMarket data = null;
		try {
			if(StringUtil.isNotNullOrEmpty(month) && StringUtil.isNotNullOrEmpty(communityId)) {
				Parameter param = new Parameter();
				param.setMonth(month);
				param.setCommunityId(communityId);
				String resBody = OpenapiPoster.post(param, "analysis/getCommunityMarket");
				JSONResult<CommunityMarket> bean= (JSONResult<CommunityMarket>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<CommunityMarket>>(){}.getType());
				data = bean.getData();
                if(data.getCityId()!=null) {
                    param.setCityId(data.getCityId());
                    String resBody1 = OpenapiPoster.post(param, "common/getCityById");
                    JSONResult<CityInfo> bean1 = (JSONResult<CityInfo>) CtrlerUtil.json2bean(resBody1, new TypeToken<JSONResult<CityInfo>>() {
                    }.getType());
                    CityInfo cityInfo = bean1.getData();
                    data.setCityName(cityInfo.getCityName());
                }
				res.setData(data);
			}
			res.setMessage("ok");
			res.setStatusCode(1);
			res.setSuccess(true);

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
	 * 出售相似案例列表接口（当前小区）
	 */
	@RequestMapping(value="/getSameSaleListing", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getSameSaleListing(HttpServletRequest request, HttpServletResponse response){
		JSONResult res = new JSONResult();
		Long communityId = StringUtil.parseLong(request.getParameter("communityId"),null);
		BigDecimal square = StringUtil.parseBigDecimal(request.getParameter("square"), null);
		Long cityId = StringUtil.parseLong(request.getParameter("cityId"),null);
		List<AvmCaseData> data = new ArrayList<AvmCaseData>();
		try {
			if(StringUtil.isNotNullOrEmpty(square) && StringUtil.isNotNullOrEmpty(communityId)&& StringUtil.isNotNullOrEmpty(cityId)) {
				Parameter param = new Parameter();
				param.setSquare(square);
				param.setCityId(cityId);
				param.setCommunityId(communityId);
				String resBody = OpenapiPoster.post(param, "avm/getSameSaleListing");
				JSONResult<List<AvmCaseData>> bean= (JSONResult<List<AvmCaseData>>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<List<AvmCaseData>>>(){}.getType());
				data = bean.getData();

			}
			res.setData(data);
			res.setMessage("ok");
			res.setStatusCode(1);
			res.setSuccess(true);

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
	 * 出售相似案例列表接口（附近小区）
	 */
	@RequestMapping(value="/getSameSaleListingNearbyCommunity", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getSameSaleListingNearbyCommunity(HttpServletRequest request, HttpServletResponse response){
		JSONResult res = new JSONResult();
		BigDecimal square = StringUtil.parseBigDecimal(request.getParameter("square"), null);
		Double lng = StringUtil.parseDouble(request.getParameter("lng"),null);
		Double lat = StringUtil.parseDouble(request.getParameter("lat"),null);
		Integer range = StringUtil.parseInt(request.getParameter("range"),null);

		List<AvmCaseData> data = new ArrayList<AvmCaseData>();
		try {
			//查找附近小区
			if(StringUtil.isNotNullOrEmpty(square) && StringUtil.isNotNullOrEmpty(lng)&& StringUtil.isNotNullOrEmpty(lat)&& StringUtil.isNotNullOrEmpty(range)) {
				Parameter param = new Parameter();
				param.setLng(lng);
				param.setLat(lat);
				param.setRange(range);
				String resBody = OpenapiPoster.post(param, "community/getNearbyCommunity");
				JSONResult<List<ApplyCommunityInfo>> bean = (JSONResult<List<ApplyCommunityInfo>>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<List<ApplyCommunityInfo>>>() {
				}.getType());
				List<ApplyCommunityInfo> communityList = bean.getData();
				if (communityList != null && !communityList.isEmpty()) {
					for (int i=1;i<communityList.size();i++) {
						int dataSize = communityList.size();
						dataSize = dataSize > 5 ? 5 : dataSize;
						communityList = communityList.subList(0, dataSize);
						ApplyCommunityInfo community = communityList.get(i);
						Parameter communityParam = new Parameter();
						communityParam.setSquare(square);
						communityParam.setCityId(community.getCityId());
						communityParam.setCommunityId(community.getCommunityId());
						String body = OpenapiPoster.post(communityParam, "avm/getSameSaleListing");
						JSONResult<List<AvmCaseData>> dataResult = (JSONResult<List<AvmCaseData>>) CtrlerUtil.json2bean(body, new TypeToken<JSONResult<List<AvmCaseData>>>() {
						}.getType());
						if (dataResult.isSuccess()) {

							data.add(dataResult.getData().get(0));
							if (communityList.size() < 5 && i == communityList.size()) {
								for (int j = 1; j < i; j++) {
									data.add(dataResult.getData().get(j));
								}
							}

						}

					}
				}

			}
			res.setData(data);
			res.setMessage("ok");
			res.setStatusCode(1);
			res.setSuccess(true);

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
	 * 成交相似案例列表接口（当前小区）
	 */
	@RequestMapping(value="/getSameDealListing", produces="text/html;charset=UTF-8" )
	@ResponseBody
	public String getSameDealListing(HttpServletRequest request, HttpServletResponse response){
		JSONResult res = new JSONResult();
		Long communityId = StringUtil.parseLong(request.getParameter("communityId"),null);
		Long cityId = StringUtil.parseLong(request.getParameter("cityId"),null);

		List<DealCommunity> list = new ArrayList<DealCommunity>();
		try {
			if( StringUtil.isNotNullOrEmpty(communityId)&& StringUtil.isNotNullOrEmpty(cityId)) {
				list = getDealCommunity(communityId,cityId,"");

			}
			res.setData(list);
			res.setMessage("ok");
			res.setStatusCode(1);
			res.setSuccess(true);

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
	 * 成交相似案例列表接口（附近小区）
	 */
	@RequestMapping(value="/getSameDealListingNearbyCommunity", produces="text/html;charset=UTF-8" )
	@ResponseBody
	public String getSameDealListingNearbyCommunity(HttpServletRequest request, HttpServletResponse response){
		JSONResult res = new JSONResult();
		BigDecimal square = StringUtil.parseBigDecimal(request.getParameter("square"), null);


		Double lng = StringUtil.parseDouble(request.getParameter("lng"),null);
		Double lat = StringUtil.parseDouble(request.getParameter("lat"),null);
		Integer range = StringUtil.parseInt(request.getParameter("range"),null);

		List<AvmCaseData> data = new ArrayList<AvmCaseData>();
		List<DealCommunity> list = new ArrayList<DealCommunity>();
		try {
			//查找附近小区
			if(StringUtil.isNotNullOrEmpty(square) && StringUtil.isNotNullOrEmpty(lng)&& StringUtil.isNotNullOrEmpty(lat)&& StringUtil.isNotNullOrEmpty(range)) {
				Parameter param = new Parameter();
				param.setLng(lng);
				param.setLat(lat);
				param.setRange(range);
				String resBody = OpenapiPoster.post(param, "community/getNearbyCommunity");
				JSONResult<List<ApplyCommunityInfo>> bean = (JSONResult<List<ApplyCommunityInfo>>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<List<ApplyCommunityInfo>>>() {
				}.getType());
				List<ApplyCommunityInfo> communityList = bean.getData();

				if (communityList != null && !communityList.isEmpty()) {
					int dataSize = communityList.size();
					dataSize = dataSize > 5 ? 5 : dataSize;
					communityList = communityList.subList(0, dataSize);
					List<SendJPushThread> tList = new ArrayList<>();
					for (int i=1;i<communityList.size();i++) {

						ApplyCommunityInfo community=communityList.get(i);
						Long cityId = community.getCityId();
						Long communityId = community.getCommunityId();
						String communityName = community.getCommunityname();
						int tpye=0;
						SendJPushThread thread = new SendJPushThread(cityId,communityId,communityName,list,tpye);
						tList.add(thread);

						/*List<DealCommunity> dealCommunityList = getDealCommunity(communityId,cityId);
						if(dealCommunityList!=null&&!dealCommunityList.isEmpty()){
							list.add(dealCommunityList.get(0));
						}*/
					}
					if(tList != null && !tList.isEmpty()){
						for (SendJPushThread sendJPushThread : tList) {
							sendJPushThread.start();
						}
						boolean hasRunning = true;
						while(hasRunning){
							hasRunning = false;
							for (SendJPushThread sendJPushThread : tList) {
								if(sendJPushThread.isAlive()){
									hasRunning = true;
									continue;
								}
							}
						}
						for (SendJPushThread sendJPushThread : tList) {
							if(!sendJPushThread.getDealCommunityList().isEmpty()){
								list.add(sendJPushThread.getDealCommunityList().get(0));
							}
						}
					}

				}
			}
			res.setData(list);
			res.setMessage("ok");
			res.setStatusCode(1);
			res.setSuccess(true);

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
	 * 出租相似案例列表接口（当前小区）
	 */
	@RequestMapping(value="/getSameRentListing", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getSameRentListing(HttpServletRequest request, HttpServletResponse response){
		JSONResult res = new JSONResult();
		Long communityId = StringUtil.parseLong(request.getParameter("communityId"),null);
		BigDecimal square = StringUtil.parseBigDecimal(request.getParameter("square"), null);
		Long cityId = StringUtil.parseLong(request.getParameter("cityId"),null);
		List<AvmCaseData> data = new ArrayList<AvmCaseData>();
		try {
			if(StringUtil.isNotNullOrEmpty(square) && StringUtil.isNotNullOrEmpty(communityId)&& StringUtil.isNotNullOrEmpty(cityId)) {
				Parameter param = new Parameter();
				param.setSquare(square);
				param.setCityId(cityId);
				param.setCommunityId(communityId);
				String resBody = OpenapiPoster.post(param, "avm/getSameRentListing");
				JSONResult<List<AvmCaseData>> bean= (JSONResult<List<AvmCaseData>>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<List<AvmCaseData>>>(){}.getType());
				data = bean.getData();

			}
			res.setData(data);
			res.setMessage("ok");
			res.setStatusCode(1);
			res.setSuccess(true);

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
	 * 出租相似案例列表接口（附近小区）
	 */
	@RequestMapping(value="/getSameRentListingNearbyCommunity", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getSameRentListingNearbyCommunity(HttpServletRequest request, HttpServletResponse response){
		JSONResult res = new JSONResult();
		BigDecimal square = StringUtil.parseBigDecimal(request.getParameter("square"), null);
		Double lng = StringUtil.parseDouble(request.getParameter("lng"),null);
		Double lat = StringUtil.parseDouble(request.getParameter("lat"),null);
		Integer range = StringUtil.parseInt(request.getParameter("range"),null);

		List<AvmCaseData> data = new ArrayList<AvmCaseData>();
		try {
			//查找附近小区
			if(StringUtil.isNotNullOrEmpty(square) && StringUtil.isNotNullOrEmpty(lng)&& StringUtil.isNotNullOrEmpty(lat)&& StringUtil.isNotNullOrEmpty(range)) {
				Parameter param = new Parameter();
				param.setLng(lng);
				param.setLat(lat);
				param.setRange(range);
				String resBody = OpenapiPoster.post(param, "community/getNearbyCommunity");
				JSONResult<List<ApplyCommunityInfo>> bean = (JSONResult<List<ApplyCommunityInfo>>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<List<ApplyCommunityInfo>>>() {
				}.getType());
				List<ApplyCommunityInfo> communityList = bean.getData();
				if (communityList != null && !communityList.isEmpty()) {
					for (int i=1;i<communityList.size();i++) {
						int dataSize = communityList.size();
						dataSize = dataSize > 5 ? 5 : dataSize;
						communityList = communityList.subList(0, dataSize);
						ApplyCommunityInfo community = communityList.get(i);
						Parameter communityParam = new Parameter();
						communityParam.setSquare(square);
						communityParam.setCityId(community.getCityId());
						communityParam.setCommunityId(community.getCommunityId());
						String body = OpenapiPoster.post(communityParam, "avm/getSameRentListing");
						JSONResult<List<AvmCaseData>> dataResult = (JSONResult<List<AvmCaseData>>) CtrlerUtil.json2bean(body, new TypeToken<JSONResult<List<AvmCaseData>>>() {
						}.getType());
						if (dataResult.isSuccess()) {

							data.add(dataResult.getData().get(0));
							if (communityList.size() < 5 && i == communityList.size()) {
								for (int j = 1; j < i; j++) {
									data.add(dataResult.getData().get(j));
								}
							}

						}

					}
				}

			}
			res.setData(data);
			res.setMessage("ok");
			res.setStatusCode(1);
			res.setSuccess(true);

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
	 * 租金走势
	 */
	@RequestMapping(value="/getCommunityRent", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getCommunityRent(HttpServletRequest request, HttpServletResponse response){
		String purpose = ServletRequestHelper.getParameter(request, "purpose", null);
		Long communityId = StringUtil.parseLong(request.getParameter("communityId"),null);
		JSONResult<Map<String,List<RentTrend>>> res = null;
		String msg = "params is null";
		boolean success = false;
		Map<String,List<RentTrend>> data = null;
		if(StringUtil.isNotNullOrEmpty(communityId)){
			Parameter param = new Parameter();
			param.setCommunityId(communityId);
			param.setPurpose(purpose);
			JSONResult<Map<String,List<RentTrend>>> bean = null;
			String resBody = null;
			try {
				resBody = OpenapiPoster.post(param, "community/getCommunityRent");
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e.getMessage() + "__request openapi error.");
			}
			try {
				bean = (JSONResult<Map<String,List<RentTrend>>>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<Map<String,List<RentTrend>>>>(){}.getType());
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e.getMessage() + "__openapi response gson to bean error.");
			}
			if(bean == null){
				msg = "request api error";
			}else{
				data = bean.getData();
				if(data == null || data.isEmpty()){
					msg = "no data";
				}else{
					msg = "ok";
					success = true;
				}
			}

		}
		res = new JSONResult<Map<String,List<RentTrend>>>(data, msg, success);
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
	/**
	 * 交易数据
	 */
	@RequestMapping(value="/getDealCommunityList", produces="text/html;charset=UTF-8" )
	@ResponseBody
	public String getDealCommunityList(HttpServletRequest request, HttpServletResponse response){
		JSONResult res = new JSONResult();
		Long communityId = StringUtil.parseLong(request.getParameter("communityId"),null);
		Long cityId = StringUtil.parseLong(request.getParameter("cityId"),null);
		Long limit = StringUtil.parseLong(request.getParameter("limit"),null);

		List<DealCommunity> list = new ArrayList<DealCommunity>();
		try {
			LpbCommunity data = null;
			if( StringUtil.isNotNullOrEmpty(communityId)&& StringUtil.isNotNullOrEmpty(cityId)) {
				Parameter param = new Parameter();
				param.setCityId(cityId);
				param.setCommunityId(communityId);
				String resBody = OpenapiPoster.post(param, "community/getGrCommunityList");
				JSONResult<LpbCommunity> bean = (JSONResult<LpbCommunity>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<LpbCommunity>>() {
				}.getType());
				data = bean.getData();
				if (data != null) {
					Long cityCode = Long.parseLong(cityId + "00");
					String grCommunityId = data.getCommunityId();
					Map parmMap = new HashMap<String, Object>();
					//parmMap.put("limit", limit);
					if (cityCode != null && !cityCode.equals("")) {
						parmMap.put("cityCode", cityCode);
					}
					if (grCommunityId != null && !grCommunityId.equals("")) {
						parmMap.put("communityId", grCommunityId);
					}
					parmMap.put("pageNo",1);
					parmMap.put("pageSize",5);

					//String mothed = "sale.do";
					String mothed = "saleForPage";
					String url = lpbUrl + mothed + "?key=" + KEY;
					String jsonParam = StringUtil.toString(CommonHelper.getJsonObject(parmMap), null);
					String result = HttpRequest.httpPostWithJson(url, jsonParam);
					JSONResult<List<DealCommunity>> dataBean = (JSONResult<List<DealCommunity>>) CtrlerUtil.json2bean(result, new TypeToken<JSONResult<List<DealCommunity>>>() {
					}.getType());
					list = dataBean.getData();
				}
				if(list != null && !list.isEmpty()){
				    for(DealCommunity dealCommunity : list){
                        dealCommunity.setCommunityName(data.getCommunityName());
                        String date = dealCommunity.getContractdate().substring(0,7).replaceAll("-","年")+"月";
                        dealCommunity.setContractdate(date);
                    }
                }
				res.setData(list);
				res.setMessage("ok");
				res.setStatusCode(1);
				res.setSuccess(true);
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
	public List<DealCommunity> getDealCommunity(Long communityId,Long cityId,String communityName) {
		LpbCommunity data = null;
		List<DealCommunity> list = new ArrayList<DealCommunity>();
		Parameter param = new Parameter();
		param.setCityId(cityId);
		param.setCommunityId(communityId);
		String resBody = OpenapiPoster.post(param, "community/getGrCommunityList");
		JSONResult<LpbCommunity> bean= (JSONResult<LpbCommunity>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<LpbCommunity>>(){}.getType());
		data = bean.getData();
		if(data!=null) {
			Long cityCode = Long.parseLong(cityId + "00");
			String grCommunityId = data.getCommunityId();
			Map parmMap = new HashMap<String, Object>();
			//parmMap.put("limit", limit);
			if (cityCode != null && !cityCode.equals("")) {
				parmMap.put("cityCode", cityCode);
			}
			if (grCommunityId != null && !grCommunityId.equals("")) {
				parmMap.put("communityId", grCommunityId);
			}
			parmMap.put("pageNo",1);
			parmMap.put("pageSize",5);

			//String mothed = "sale.do";
			String mothed = "saleForPage";
			String url = lpbUrl + mothed + "?key=" + KEY;
			String jsonParam = StringUtil.toString(CommonHelper.getJsonObject(parmMap), null);
			String result = HttpRequest.httpPostWithJson(url, jsonParam);
			JSONResult<List<DealCommunity>> dataBean = (JSONResult<List<DealCommunity>>) CtrlerUtil.json2bean(result, new TypeToken<JSONResult<List<DealCommunity>>>() {
			}.getType());
			list = dataBean.getData();
			if (list.size() > 4) {
				list = list.subList(0, 4);
			}
			for (int i = 0; i < list.size(); i++) {
				if(!StringUtil.isNotNullOrEmpty(communityName)){
					list.get(i).setCommunityName(data.getCommunityName());
				}else{
					list.get(i).setCommunityName(communityName);
				}
				list.get(i).setCommunityId(communityId);
				list.get(i).setContractdate(new Date(StringUtil.parseLong(list.get(i).getContractdate(),null)).toString());
				list.get(i).setTotalprice(list.get(i).getTotalprice() / 10000);
				if (i > 2) {
					break;
				}
			}
		}
		return list;
	}


	/**
	 * 附近小区搜索接口
	 */
	@RequestMapping(value="/searchNearCommunity", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String searchNearCommunity(HttpServletRequest request, HttpServletResponse response){
		Double lng = StringUtil.parseDouble(request.getParameter("lng"),null);
		Double lat = StringUtil.parseDouble(request.getParameter("lat"),null);
		Integer range = StringUtil.parseInt(request.getParameter("range"),null);
		JSONResult<List<ApplyCommunityInfo>> res = new JSONResult<List<ApplyCommunityInfo>>();
		List<ApplyCommunityInfo> communityList = new ArrayList<ApplyCommunityInfo>();
		List<ApplyCommunityInfo> list = new ArrayList<ApplyCommunityInfo>();
		try {
			if (StringUtil.isNotNullOrEmpty(lng) && StringUtil.isNotNullOrEmpty(lat) && StringUtil.isNotNullOrEmpty(range)) {
				Parameter param = new Parameter();
				param.setLng(lng);
				param.setLat(lat);
				param.setRange(range);
				//当前时间
				Date startDate = new Date(System.currentTimeMillis());
				Date endDate = StringUtil.parseDate(StringUtil.getFirsDay(StringUtil.getMonth(-13)),null);

				param.setStartDate(startDate);
				param.setEndDate(endDate);
				String resBody = OpenapiPoster.post(param, "community/getNearbyCommunity");
				JSONResult<List<ApplyCommunityInfo>> bean = (JSONResult<List<ApplyCommunityInfo>>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<List<ApplyCommunityInfo>>>() {
				}.getType());
				communityList = bean.getData();
			/*	List<SendJPushThread> tList = new ArrayList<>();
				if(communityList!=null&&!communityList.isEmpty()) {
					for(ApplyCommunityInfo applyCommunityInfo : communityList) {
						Date month = new java.sql.Date(System.currentTimeMillis());
						*//*Parameter marketParam = new Parameter();
						marketParam.setMonth(month);
						marketParam.setCommunityId(applyCommunityInfo.getCommunityId());*//*
						int type=1;
						SendJPushThread thread = new SendJPushThread(applyCommunityInfo.getCommunityId(),month,applyCommunityInfo,new CommunityMarket(),type);
						tList.add(thread);
					}
					if(tList != null && !tList.isEmpty()){
						for (SendJPushThread sendJPushThread : tList) {
							sendJPushThread.start();
						}
						boolean hasRunning = true;
						while(hasRunning){
							hasRunning = false;
							for (SendJPushThread sendJPushThread : tList) {
								if(sendJPushThread.isAlive()){
									hasRunning = true;
									continue;
								}
							}
						}
						for (SendJPushThread sendJPushThread : tList) {
							if(sendJPushThread.getCommunityMarket()!=null){
								list.add(sendJPushThread.getApplyCommunityInfo());
							}
						}
					}
				}*/
			}
			res.setData(communityList);
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
	public CommunityMarket getCommunityMarket(Date month,Long communityId) {
		Parameter marketParam = new Parameter();
		marketParam.setMonth(month);
		marketParam.setCommunityId(communityId);
		String resBody1 = OpenapiPoster.post(marketParam, "analysis/getCommunityMarket");
		JSONResult<CommunityMarket> CommunityMarketBean = (JSONResult<CommunityMarket>) CtrlerUtil.json2bean(resBody1, new TypeToken<JSONResult<CommunityMarket>>() {
		}.getType());
		CommunityMarket data = CommunityMarketBean.getData();
		if(data!=null) {
			return data;
		}else{
			return null;
		}

	}


	/**
	 * 获取意向小区带分页
	 */
	@RequestMapping(value="/suggestionCommunityList", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String suggestionCommunityList(HttpServletRequest request, HttpServletResponse response){
		JSONResult<List<CommunityMarket>> res = new JSONResult<List<CommunityMarket>>();
		List<CommunityMarket> communityList=new ArrayList<CommunityMarket>();
		String[] districtId = request.getParameter("districtId").split(",");
		BigDecimal price = StringUtil.parseBigDecimal(request.getParameter("price"),null);
		BigDecimal minSquare = StringUtil.parseBigDecimal(request.getParameter("minSquare"),null);
		BigDecimal maxSquare = StringUtil.parseBigDecimal(request.getParameter("maxSquare"),null);
		Integer page = StringUtil.parseInt(request.getParameter("page"),null);
		Integer rows = StringUtil.parseInt(request.getParameter("rows"),null);
		String orderByClause = request.getParameter("orderByClause");

		Parameter param = new Parameter();

		if(districtId!=null&&districtId.length>0&&price!=null&&minSquare!=null&&maxSquare!=null) {
			param.setDistrictId(1l);
			param.setDistrictIdList(Arrays.asList(districtId));
			BigDecimal maxSalePrice = price.divide(minSquare ,2, BigDecimal.ROUND_HALF_UP);
			BigDecimal minSalePrice = price.divide(maxSquare ,2, BigDecimal.ROUND_HALF_UP);

			param.setMaxSalePrice(maxSalePrice);
			param.setMinSalePrice(minSalePrice);
			param.setPage(page);
			param.setRows(rows);
			param.setOrderByClause(orderByClause);
			try {
				String resBody = OpenapiPoster.post(param, "community/suggestionCommunityList");
				JSONResult<List<CommunityMarket>> bean = (JSONResult<List<CommunityMarket>>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<List<CommunityMarket>>>() {
				}.getType());
				communityList = bean.getData();
			} catch (Exception e) {
				e.printStackTrace();
				res.setMessage("no ok");
				res.setStatusCode(2);
				res.setSuccess(false);
			}
			res.setData(communityList);
			res.setMessage("ok");
			res.setStatusCode(1);
			res.setSuccess(true);
		}else{
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}

		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}

	/**
	 * 按行政区获取意向小区
	 */
	@RequestMapping(value="/suggestionCommunityListByDistrict", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String suggestionCommunityListByDistrict(HttpServletRequest request, HttpServletResponse response){
		JSONResult<List<CommunityMarket>> res = new JSONResult<List<CommunityMarket>>();
		List<CommunityMarket> communityList=new ArrayList<CommunityMarket>();
		Long districtId = StringUtil.parseLong(request.getParameter("districtId"),null);
		BigDecimal price = StringUtil.parseBigDecimal(request.getParameter("price"),null);
		BigDecimal minSquare = StringUtil.parseBigDecimal(request.getParameter("minSquare"),null);
		BigDecimal maxSquare = StringUtil.parseBigDecimal(request.getParameter("maxSquare"),null);
		Integer page = StringUtil.parseInt(request.getParameter("page"),null);
		Integer rows = StringUtil.parseInt(request.getParameter("rows"),null);
		Parameter param = new Parameter();

		if(districtId!=null&&price!=null&&minSquare!=null&&maxSquare!=null) {
			param.setDistrictId(districtId);
			//param.setDistrictIdList(Arrays.asList(districtId));
			BigDecimal maxSalePrice = price.divide(minSquare ,2, BigDecimal.ROUND_HALF_UP);
			BigDecimal minSalePrice = price.divide(maxSquare ,2, BigDecimal.ROUND_HALF_UP);

			param.setMaxSalePrice(maxSalePrice);
			param.setMinSalePrice(minSalePrice);
			param.setPage(page);
			param.setRows(rows);
			try {
				String resBody = OpenapiPoster.post(param, "community/suggestionCommunityListByDistrict");
				JSONResult<List<CommunityMarket>> bean = (JSONResult<List<CommunityMarket>>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<List<CommunityMarket>>>() {
				}.getType());
				communityList = bean.getData();
			} catch (Exception e) {
				e.printStackTrace();
				res.setMessage("no ok");
				res.setStatusCode(2);
				res.setSuccess(false);
			}
			res.setData(communityList);
			res.setMessage("ok");
			res.setStatusCode(1);
			res.setSuccess(true);
		}else{
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}

		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}



	/**
	 * 周边小区房价对比
	 */
	@RequestMapping(value="/aroundCommunityPriceCompare", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String aroundCommunityPriceCompare(HttpServletRequest request, HttpServletResponse response){
		AroundCommunityPrice aroundCommunityPrice = new AroundCommunityPrice();
		JSONResult<List<AroundCommunityInfo>> res = new JSONResult<List<AroundCommunityInfo>>();
		Double lng = StringUtil.parseDouble(request.getParameter("lng"),null);
		Double lat = StringUtil.parseDouble(request.getParameter("lat"),null);
		Integer range = StringUtil.parseInt(request.getParameter("range"),null);
		int cs = 0;
		List<AvmCaseData> data = new ArrayList<AvmCaseData>();
		List<DealCommunity> list = new ArrayList<DealCommunity>();
		List<CommunityMarket> CommunityMarketList = new ArrayList<CommunityMarket>();
		List<ApplyCommunityInfo> communityList = null;
		List<AroundCommunityInfo> resultCommunityList = new ArrayList<AroundCommunityInfo>();
		try {
			//查找附近小区
			if(StringUtil.isNotNullOrEmpty(lng)&& StringUtil.isNotNullOrEmpty(lat)&& StringUtil.isNotNullOrEmpty(range)) {
				Parameter param = new Parameter();
				param.setLng(lng);
				param.setLat(lat);
				param.setRange(range);
				String resBody = OpenapiPoster.post(param, "community/getNearbyCommunity");
				JSONResult<List<ApplyCommunityInfo>> bean = (JSONResult<List<ApplyCommunityInfo>>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<List<ApplyCommunityInfo>>>() {
				}.getType());
				communityList = bean.getData();
				
				
				for(ApplyCommunityInfo applyCommunityInfo : communityList){
					cs++;
					AroundCommunityInfo aroundCommunityInfo = new AroundCommunityInfo();
					String communityName1 = applyCommunityInfo.getCommunityname();
					String Detailaddress =applyCommunityInfo.getDetailaddress();
					Timestamp CreatedDt = applyCommunityInfo.getCreatedDt();
					String buildYear = applyCommunityInfo.getBuildyear();
					Double latitude = applyCommunityInfo.getLatitude().doubleValue();
					Double longitude = applyCommunityInfo.getLongitude().doubleValue();
					aroundCommunityInfo.setCommunityName(communityName1);
					aroundCommunityInfo.setDetailaddress(Detailaddress);
					//aroundCommunityInfo.setCreatedDt(CreatedDt);
					aroundCommunityInfo.setBuildYear(buildYear);
					//double[] xyRange = LatLonUtil.GetAround(lat.doubleValue(), lng.doubleValue(), range_);
					double distance = LatLonUtil.GetDistance(lng, lat, longitude, latitude);
					double position = LatLonUtil.getAngle1(lng, lat, longitude, latitude);
					String direction =  LatLonUtil.getDirection(position);
					aroundCommunityInfo.setDistance(distance);
					aroundCommunityInfo.setDirection(direction);
					List<SendJPushThread> tList = new ArrayList<>();

                       
					//ApplyCommunityInfo community=communityList.get(i);
					Long cityId = applyCommunityInfo.getCityId();
					Long communityId = applyCommunityInfo.getCommunityId();
					String communityName = applyCommunityInfo.getCommunityname();
					int tpye=0;
					SendJPushThread thread = new SendJPushThread(cityId,communityId,communityName,list,tpye);
					tList.add(thread);

						/*List<DealCommunity> dealCommunityList = getDealCommunity(communityId,cityId);
						if(dealCommunityList!=null&&!dealCommunityList.isEmpty()){
							list.add(dealCommunityList.get(0));
						}*/


					//Date month = Date.valueOf(request.getParameter("month"));
					//当前时间
					Date month = new Date(System.currentTimeMillis());
					//TODO:默认时间，为了数据，测试用，
					//Date month = StringUtil.getDate("2018-04-01");
					//CommunityMarket data = null;
					CommunityMarket Communitydata = null;
					try {
						if(StringUtil.isNotNullOrEmpty(month) && StringUtil.isNotNullOrEmpty(communityId)) {
							//Parameter param = new Parameter();
							Parameter Communityparam = new Parameter();
							Communityparam.setMonth(month);
							Communityparam.setCommunityId(communityId);
							String CommunityresBody = OpenapiPoster.post(Communityparam, "analysis/getCommunityMarket");
							JSONResult<CommunityMarket> Communitybean= (JSONResult<CommunityMarket>) CtrlerUtil.json2bean(CommunityresBody, new TypeToken<JSONResult<CommunityMarket>>(){}.getType());
							Communitydata = Communitybean.getData();
							BigDecimal Salesqmprice = Communitydata.getSalesqmprice();
							aroundCommunityInfo.setSalesqmprice(Salesqmprice);
							//CommunityMarketList.add(Communitydata);
							resultCommunityList.add(aroundCommunityInfo);
							//res.setData(data);
						}
					} catch (Exception e) {
						e.printStackTrace();
						res.setMessage("no ok");
						res.setStatusCode(2);
						res.setSuccess(false);
					}

					
					if(cs >= 7){
						break;
					}
				}

			}
			
			if(cs >= 7){
				resultCommunityList = resultCommunityList.subList(0, 7);	
			}
			
			
			/*  Collections.sort(resultCommunityList, new Comparator<AroundCommunityInfo>() {
		            @Override
		            public int compare(AroundCommunityInfo o1, AroundCommunityInfo o2) {
		                Collator collator = Collator.getInstance(Locale.CHINA);
		                return collator.compare(o1.getDistance(), o2.getDistance());
		            }
		        });*/
			 // aroundCommunityPrice.setResultCommunityList(resultCommunityList);
			//aroundCommunityPrice.setCommunityMarketList(CommunityMarketList);
			res.setData(resultCommunityList);
			res.setMessage("ok");
			res.setStatusCode(1);
			res.setSuccess(true);

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
	 * 挂牌数据
	 */
	@RequestMapping(value="/getSaleDateCount", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getSaleDateCount(HttpServletRequest request, HttpServletResponse response){
		Long communityId = StringUtil.parseLong(request.getParameter("communityId"),null);
		Long cityId = StringUtil.parseLong(request.getParameter("cityId"),null);
		JSONResult<Map> res = new JSONResult<Map>();
		Map map = new HashMap();
		List<ApplyCommunityInfo> list = new ArrayList<ApplyCommunityInfo>();
		try {
			if (StringUtil.isNotNullOrEmpty(cityId) && StringUtil.isNotNullOrEmpty(communityId)) {
				Parameter param = new Parameter();
				param.setCityId(cityId);
				param.setCommunityId(communityId);
				Date endDate = new Date(System.currentTimeMillis());
				param.setEndDate(endDate);
				Date startDate = StringUtil.getDate(StringUtil.getMonth(-12));
				param.setStartDate(startDate);
				String resBody = OpenapiPoster.post(param, "avm/getSaleDateCount");
				JSONResult<Map> bean = (JSONResult<Map>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<Map>>() {
				}.getType());
				map = bean.getData();
				List<SendJPushThread> tList = new ArrayList<>();
				res.setData(map);
				res.setMessage("ok");
				res.setStatusCode(1);
				res.setSuccess(true);
			}else{
				res.setMessage("no ok");
				res.setStatusCode(2);
				res.setSuccess(false);
			}

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
     * 近几月小区最新行情
     */
    @RequestMapping(value="/getCommunityMarketByDate", produces="text/html;charset=UTF-8")
    @ResponseBody
    public String getCommunityMarketByDate(HttpServletRequest request, HttpServletResponse response){
        JSONResult<CommunityMarket> res = new JSONResult<CommunityMarket>();
        Long communityId = StringUtil.parseLong(request.getParameter("communityId"),null);
        Integer month = StringUtil.parseInt(request.getParameter("month"),null);

        Parameter param = new Parameter();

        if(communityId!=null&&month!=null) {
            param.setCommunityId(communityId);
            //当前时间
            Date endDate = new Date(System.currentTimeMillis());
            Date startDate = StringUtil.parseDate(StringUtil.getFirsDay(StringUtil.getMonth(0-month)),null);
            param.setStartDate(startDate);
            param.setEndDate(endDate);
            CommunityMarket communityMarket = null;
            try {
                String resBody = OpenapiPoster.post(param, "community/getCommunityMarketByDate");
                JSONResult<CommunityMarket> bean = (JSONResult<CommunityMarket>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<CommunityMarket>>() {
                }.getType());
               communityMarket = bean.getData();
            } catch (Exception e) {
                e.printStackTrace();
                res.setMessage("no ok");
                res.setStatusCode(2);
                res.setSuccess(false);
            }
            res.setData(communityMarket);
            res.setMessage("ok");
            res.setStatusCode(1);
            res.setSuccess(true);
        }else{
            res.setMessage("no ok");
            res.setStatusCode(2);
            res.setSuccess(false);
        }

        String resultStr = CtrlerUtil.getRetBody(request, res);
        return resultStr;
    }
}
