package com.cindata.housekeeper.web.controller;

import com.cindata.housekeeper.core.common.tools.CtrlerUtil;
import com.cindata.housekeeper.core.common.tools.OpenapiPoster;
import com.cindata.housekeeper.core.common.tools.StringUtil;
import com.cindata.housekeeper.core.entity.JSONResult;
import com.cindata.housekeeper.core.entity.Parameter;
import com.cindata.housekeeper.web.model.DistrictInfo;
import com.cindata.housekeeper.web.service.DistrictService;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("district")
public class DistrictInfoController {

	@Autowired
	private DistrictService districtService;
	
	
	/**
	 * 城市行政区接口
	 */
	@RequestMapping(value="/getCityDistrictByCityId", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getCityDistrictByCityId(HttpServletRequest request, HttpServletResponse response){
		
		Long cityId = StringUtil.parseLong(request.getParameter("cityId"), null);
		JSONResult<List<DistrictInfo>> res = new JSONResult<>();
		List<DistrictInfo> list = new ArrayList<DistrictInfo>();
		try {
			if(cityId!=null) {
				Parameter param = new Parameter();
				param.setCityId(cityId);
				String resBody = OpenapiPoster.post(param, "district/getCityDistrictByCityId");
				JSONResult<List<DistrictInfo>> bean = (JSONResult<List<DistrictInfo>>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<List<DistrictInfo>>>(){}.getType());
				list = bean.getData();
				res.setData(list);
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
	 * 行政区详情与行情
	 */
	@RequestMapping(value="/getDistrictMarketByCityId", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getDistrictMarketByCityId(HttpServletRequest request, HttpServletResponse response){

		Long cityId = StringUtil.parseLong(request.getParameter("cityId"), null);
		JSONResult<List<DistrictInfo>> res = new JSONResult<>();
		List<DistrictInfo> list = new ArrayList<DistrictInfo>();
		try {
			if(cityId!=null) {

				//当前时间
				//Date month = new Date(System.currentTimeMillis());
				//month = StringUtil.parseDate(StringUtil.getDate(StringUtil.getFirsDay(StringUtil.formatDateString(month,"yyyy-MM-dd"))),null);
				//TODO:默认时间，为了数据，测试用，
				Date month = StringUtil.parseDate(StringUtil.getDate(StringUtil.getFirsDay("2017-09-01")),null);
				Parameter param = new Parameter();
				param.setCityId(cityId);
				param.setStartDate(month);
				param.setEndDate(month);
				String resBody = OpenapiPoster.post(param, "analysis/getDistrictMarketListByCityId");
				JSONResult<List<DistrictInfo>> bean = (JSONResult<List<DistrictInfo>>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<List<DistrictInfo>>>(){}.getType());
				if(bean.getData()!=null){
					list = bean.getData();
					res.setData(list);
				}
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
}
