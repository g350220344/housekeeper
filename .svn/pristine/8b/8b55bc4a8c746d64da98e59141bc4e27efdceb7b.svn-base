package com.cindata.housekeeper.web.controller;


import com.cindata.housekeeper.core.common.tools.*;
import com.cindata.housekeeper.core.entity.JSONResult;
import com.cindata.housekeeper.core.entity.PayParameter;
import com.cindata.housekeeper.web.model.ApplyCommunityInfo;
import com.cindata.housekeeper.web.model.CityInfo;
import com.cindata.housekeeper.web.service.CityService;
import com.google.common.reflect.TypeToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;

/**
 * 小区信息接口
 * @author yangss
 * @date   2017.02.07 09:47
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
@Controller
@RequestMapping(value = "/test")
public class TestController {
	
	@Resource
	private CityService cityService;

	
	/**
	 * 查询城市信息
	 */
	@RequestMapping(value="/getCityList", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getApplyCommunityInfo(HttpServletRequest request, HttpServletResponse response){
		JSONResult<List<CityInfo>> res = new JSONResult<>();

		List<CityInfo> list = null;
		try {
			list = cityService.getCityInfoList();
			res.setData(list);
			res.setMessage("ok");
			res.setStatusCode(1);
			res.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			res.setData(list);
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
	/**
	 * 查询城市信息
	 */
	@RequestMapping(value="/searchCommunity", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String searchCommunity(HttpServletRequest request, HttpServletResponse response){
		String cityId = ServletRequestHelper.getParameter(request, "cityId", null);
		String districtId = ServletRequestHelper.getParameter(request, "districtId", null);
		String communityId = ServletRequestHelper.getParameter(request, "communityId", null);
		String communityName = ServletRequestHelper.getParameter(request, "communityName", null);
		String lng = ServletRequestHelper.getParameter(request, "lng", null);
		String lat = ServletRequestHelper.getParameter(request, "lat", null);
		Integer range = StringUtil.parseInt(ServletRequestHelper.getParameter(request, "range", null), null);
		JSONResult<List<ApplyCommunityInfo>> res = new JSONResult<>();
		String str = null;
		try {
            str = cityService.getCommunityList(cityId, districtId, communityId, communityName, lng, lat, range);
			//res.setData(list);
			res.setMessage("ok");
			res.setStatusCode(1);
			res.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			//res.setData(list);
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return str;
	}
	/**
	 * 微信h5支付
	 */
	@RequestMapping(value="/weixinPayH5", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String weixinPayH5(HttpServletRequest request, HttpServletResponse response){
		JSONResult<List<ApplyCommunityInfo>> res = new JSONResult<>();
		String orderId = ServletRequestHelper.getParameter(request, "orderId", null);

		String str = null;
		PayParameter param = new PayParameter();
		param.setMoney(new BigDecimal(1));
		param.setOrderId(orderId);
		param.setOrderName("信达泰和");
		param.setSceneInfo("房产管家测试");
		//获取ip
		String ip = PayWxCommonUtil.getClientIp(request);
		param.setIp(ip);
		String resBody = null;
		String data = null;
		try {
			resBody = OpenapiPoster.post(param, "payWx/weixinPayH5");
			JSONResult bean = (JSONResult) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult>(){}.getType());
			data = bean.getData().toString();
			res.setMessage("ok");
			res.setStatusCode(1);
			res.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			//res.setData(list);
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return data;
	}
	/**
	 * 微信回调
	 */
	@RequestMapping(value="/weixinCallBack", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String weixinCallBack(HttpServletRequest request, HttpServletResponse response){
		PayParameter param = ServletRequestHelper.getPayRequestBody(request);
		JSONResult<PayParameter> res = new JSONResult<>();

		System.out.println("测试回调orderId:"+param.getOrderId());
		try {
			res.setData(param);
			res.setMessage("ok");
			res.setStatusCode(1);
			res.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			//res.setData(list);
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
	/**
	 * des解密
	 */
	@RequestMapping(value="/des", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String des(HttpServletRequest request, HttpServletResponse response){
		JSONResult<List<ApplyCommunityInfo>> res = new JSONResult<>();
		String str = ServletRequestHelper.getParameter(request, "str", null);
		String decryptData = null;
		String key = "Avj!@#853PoIuds&";
		try {

			decryptData = DESUtil.decode(str, key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return decryptData;
	}
	
	@RequestMapping(value="/test", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String test(HttpServletRequest request, HttpServletResponse response){
		JSONResult<List<ApplyCommunityInfo>> res = new JSONResult<>();
		String str = "";
		String decryptData = null;
		String key = "Avj!@#853PoIuds&";
		String str1 = ServletRequestHelper.getParameter(request, "str", null);
		try {
        str = TestTool.hzsz(str1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	@RequestMapping(value="/testDain", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String testDain(HttpServletRequest request, HttpServletResponse response){
		String str = request.getParameter("str");
		String StringQian = "";
		String StringHou = "";
		int resultIndex = 0;
		boolean flag = str.contains("点");
		boolean f = false;
		boolean fl = true;
		int z = 0;
		int index = 0;
		String c = "";
		String shuZi = "一,二,三,四,五,六,七,八,九,十,零,百,千";
		String[] shuZiS = shuZi.split(",");
		if(flag){
			
			for(int j=0;j<str.length();j++){
				
				String s = str.charAt(j) + "";
				if("点".equals(s)){
					// index = str.indexOf("点");
					 for(int i =0;i<shuZiS.length;i++){
							
								c = str.charAt(j - 1) + "";
								if(shuZiS[i].equals(c)){
									f = true;
									z = j;
									break;
								}
					 }
				}else{
					continue;
				}
				
				
			}
		}						if(f){
										//int zLength = str.split("点")[0].length();
										for(int q=z-1;q>=0;q--){
											String ds = str.charAt(q) + "";
											for(int w=0;w<shuZiS.length;w++){
												if(ds.equals(shuZiS[w])){
													resultIndex = q;
													break;
												}else{
													continue;
												}
											}
											/*while(shuZiS[j].equals(str.charAt(q))){
												 resultIndex = q;
												
											}*/
										}
										
										StringQian = str.substring(0, resultIndex);
										StringHou = str.substring(resultIndex,str.length());
										fl = false;
									}	
			
			String resultHou =  TestTool.hzsz(StringHou);
		
		try {
       // str = TestTool.hzsz("算法i七千零七十三点五四色规划不");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultHou;
	}
	
}
