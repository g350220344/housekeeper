package com.cindata.housekeeper.wx.controller;

import com.cindata.housekeeper.core.common.tools.*;
import com.cindata.housekeeper.core.entity.JSONResult;
import com.cindata.housekeeper.core.entity.Parameter;
import com.cindata.housekeeper.wx.model.WxReport;
import com.cindata.housekeeper.wx.model.WxSuggestInfo;
import com.cindata.housekeeper.wx.model.WxUserInfo;
import com.cindata.housekeeper.wx.service.WxAttentionService;
import com.cindata.housekeeper.wx.service.WxReportService;
import com.cindata.housekeeper.wx.service.WxUserService;
import com.google.common.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/WxUser")
public class WxUserController {

	
	private static Logger log = LoggerFactory.getLogger(WxUserController.class);
	
	
	@Autowired
    private WxUserService wxUserService;
	
	@Autowired
    private WxAttentionService wxAttentionService;
	
	@Autowired
    private WxReportService wxReportService;
	
	/**
	 * 添加用户
	 */
	@RequestMapping(value="/addUser", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String addUser(WxUserInfo wxUserInfo,HttpServletRequest request, HttpServletResponse response){
		
		String ip = PayWxCommonUtil.getClientIp(request);
		wxUserInfo.setRegIp(ip);
		int i = 0;
		JSONResult res = new JSONResult();
		
				try {
				i =	wxUserService.addUser(wxUserInfo);
				 res.setData(i);
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
	 * 查询用户信息
	 */
	@RequestMapping(value="/selectUserInfo", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectUserInfo(HttpServletRequest request, HttpServletResponse response){
		
		/*String WxOpenId = request.getParameter("WxOpenId");
		String UserId = wxUserService.selectUserIdByOpenId(WxOpenId);*/
		String id = request.getParameter("userId");
		
		int i = 0;
		JSONResult res = new JSONResult();
		if(!StringUtil.isNotNullOrEmpty(id)){
			res.setMessage("用户编码不能为空");
			res.setStatusCode(2);
			res.setSuccess(false);
			return CtrlerUtil.getRetBody(request, res);
		}
				try {
				WxUserInfo  wxUserInfo=	wxUserService.selectUserInfo(id);
				if(StringUtil.isNotNullOrEmpty(wxUserInfo) && StringUtil.isNotNullOrEmpty(wxUserInfo.getMobile())){
					String phoneNumber = wxUserInfo.getMobile().toString().substring(0, 3) + "****" + wxUserInfo.getMobile().toString().substring(7, wxUserInfo.getMobile().toString().length());
					wxUserInfo.setPwdMobile(phoneNumber);
				}
				 res.setData(wxUserInfo);
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
	 * 修改用户信息
	 */
	@RequestMapping(value="/updateUserInfo", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String updateUserInfo(WxUserInfo  wxUserInfo,HttpServletRequest request, HttpServletResponse response){
		
		
		/*String WxOpenId = request.getParameter("WxOpenId");
		String UserId = wxUserService.selectUserIdByOpenId(WxOpenId);
		wxUserInfo.setUserId(UserId);*/
		int i = 0;
		JSONResult res = new JSONResult();
		if(!StringUtil.isNotNullOrEmpty(wxUserInfo.getUserId())){
			res.setMessage("用户编码不能为空");
			res.setStatusCode(2);
			res.setSuccess(false);
			return CtrlerUtil.getRetBody(request, res);
		}
//		if(!StringUtil.isNotNullOrEmpty(wxUserInfo.getMobile())){
//			res.setMessage("修改的手机号不能为空");
//			res.setStatusCode(2);
//			res.setSuccess(false);
//			return CtrlerUtil.getRetBody(request, res);
//		}
		try {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					wxUserInfo.setUpdateTime(dateFormat.parse(dateFormat.format(new Date())));
				i=	wxUserService.updateUserInfo(wxUserInfo);
				 res.setData(i);
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
	 * 查询用户信息
	 */
	@RequestMapping(value="/selectUserIdByOpenId", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectUserIdByOpenId(HttpServletRequest request, HttpServletResponse response){
		
		
		String WxOpenId = request.getParameter("WxOpenId");
		int i = 0;
		JSONResult res = new JSONResult();
		
				try {
					String UserId = wxUserService.selectUserIdByOpenId(WxOpenId);
			
				 res.setData(UserId);
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
	 * 修改用户头像
	 */
	@RequestMapping(value="/updateUserHead", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String updateUserHead(HttpServletRequest request,
								 @RequestParam(value = "file", required = false) MultipartFile[] files,
								 HttpServletResponse response, String userId){
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/plain");
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers", "x-requested-with");
		JSONResult<WxUserInfo> res = new JSONResult<WxUserInfo>();
		try {
			WxUserInfo wxUserInfo = wxUserService.selectUserInfo(userId);
			List<String> pathList = ImageServerUtil.uploadAllByImageServer(request, files);
			if(!pathList.isEmpty()){
				wxUserInfo.setHeadUrl(pathList.get(0));
				int i=	wxUserService.updateUserInfo(wxUserInfo);
				if(i>0){
					res.setData(wxUserInfo);
					res.setMessage("ok");
					res.setStatusCode(1);
					res.setSuccess(true);
				}else{
					res.setStatusCode(2);
					res.setMessage("no ok");
					res.setSuccess(false);
				}
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
	 * 用户反馈
	 */
	@RequestMapping(value="/userSuggestion", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String userSuggestion(WxSuggestInfo wxSuggestInfo,HttpServletRequest request, HttpServletResponse response){
		
		
		int i = 0;
		JSONResult res = new JSONResult();
		
		int contentLength = wxSuggestInfo.getContent().length();
		if(!StringUtil.isNotNullOrEmpty(wxSuggestInfo.getUserId())){
			res.setMessage("用户编码不能为空");
			res.setStatusCode(2);
			res.setSuccess(false);
			return CtrlerUtil.getRetBody(request, res);
		}
	      if(contentLength < 6){
			 res.setMessage("至少输入6个字");
			 res.setStatusCode(2);
			 res.setSuccess(false);
	      }
	      
	      if(contentLength > 200){
			 res.setMessage("最多可输入200个字");
			 res.setStatusCode(2);
			 res.setSuccess(false); 
	      }
	      if(contentLength>=6 && contentLength<=200){
	    	  try {
					i = wxUserService.userSuggestion(wxSuggestInfo);
				
					 res.setData(i);
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
	      }
				
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
	
	/**
	 * 查询用户关注列表
	 */
	@RequestMapping(value="/selectUserAttention", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectUserAttention(HttpServletRequest request, HttpServletResponse response){
		
		Map<String, Object> bean = CommonHelper.setParam(request);
		
		JSONResult res = new JSONResult();
		if(!StringUtil.isNotNullOrEmpty(bean.get("userId"))){
			res.setMessage("用户编码不能为空");
			res.setStatusCode(2);
			res.setSuccess(false);
			return CtrlerUtil.getRetBody(request, res);
		}
		try {
			List<Map>  list=	wxAttentionService.selectUserAttentionByPage(bean);
			if(StringUtil.isNotNullOrEmpty(list) && list.size() > 0){
				res.setData(list);
				res.setDataCount((long)wxAttentionService.selectUserAttentionByPageCount(bean));
				res.setMessage("ok");
				res.setStatusCode(1);
				res.setSuccess(true);
			}else{
				res.setData(new ArrayList<Map>());
				res.setDataCount(0l);
				res.setMessage("ok");
				res.setStatusCode(1);
				res.setSuccess(true);
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
	 * 查询用户订阅列表
	 */
	@RequestMapping(value="/selectUserSubscribe", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectUserSubscribe(HttpServletRequest request, HttpServletResponse response){
		
		Map<String, Object> bean = CommonHelper.setParam(request);
		
		JSONResult res = new JSONResult();
		if(!StringUtil.isNotNullOrEmpty(bean.get("userId"))){
			res.setMessage("用户编码不能为空");
			res.setStatusCode(2);
			res.setSuccess(false);
			return CtrlerUtil.getRetBody(request, res);
		}
		try {
			List<Map>  list=	wxReportService.selectUserReportByPage(bean);
			if(StringUtil.isNotNullOrEmpty(list) && list.size() > 0){
				res.setData(list);
				res.setDataCount((long)wxReportService.selectUserReportByPageCount(bean));
				res.setMessage("ok");
				res.setStatusCode(1);
				res.setSuccess(true);
			}else{
				res.setData(new ArrayList<Map>());
				res.setDataCount(0l);
				res.setMessage("ok");
				res.setStatusCode(1);
				res.setSuccess(true);
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
	 * 查询用户订阅列表明细（包含出售均价、本月出售成交、租金收益率）
	 */
	@RequestMapping(value="/selectUserSubscribeDetail", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectUserSubscribeDetail(HttpServletRequest request, HttpServletResponse response){
		
		Map<String, Object> bean = CommonHelper.setParam(request);
		
		JSONResult res = new JSONResult();
		if(!StringUtil.isNotNullOrEmpty(bean.get("userId"))){
			res.setMessage("用户编码不能为空");
			res.setStatusCode(2);
			res.setSuccess(false);
			return CtrlerUtil.getRetBody(request, res);
		}
		try {
			List<Map>  list=	wxReportService.selectUserReportDetailByPage(bean);
			if(StringUtil.isNotNullOrEmpty(list) && list.size() > 0){
				res.setData(list);
				res.setDataCount((long)wxReportService.selectUserReportDetailByPageCount(bean));
				res.setMessage("ok");
				res.setStatusCode(1);
				res.setSuccess(true);
			}else{
				res.setData(new ArrayList<Map>());
				res.setDataCount(0l);
				res.setMessage("ok");
				res.setStatusCode(1);
				res.setSuccess(true);
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
     * @description: 订阅小区均价走势对比
     * @author: liangqs
     * @create: 2018/8/16
     **/
    @RequestMapping(value="/getUserSubscribeRatio", produces="text/html;charset=UTF-8")
    @ResponseBody
    public String getUserSubscribeRatio(HttpServletRequest request, HttpServletResponse response){
    	Map<String, Object> bean = CommonHelper.setParam(request);
        JSONResult<List> res = new JSONResult<>();
        
        if(!StringUtil.isNotNullOrEmpty(bean.get("userId"))){
			res.setMessage("用户编码不能为空");
			res.setStatusCode(2);
			res.setSuccess(false);
			return CtrlerUtil.getRetBody(request, res);
		}
        try {
        	List<WxReport>  list = wxReportService.selectAllUserReportByUserId(bean);
        	if(list.size() > 0){
        		StringBuffer communityIds = new StringBuffer();
        		for(WxReport wxReportInfo : list){
        			if(!communityIds.toString().contains(wxReportInfo.getCommunityId().toString())){
        				communityIds.append("," + wxReportInfo.getCommunityId());
        			}
        		}
        		String communityIdStr = communityIds.toString().substring(1);
//        		String communityIdStr = "600182454,";
        		
        		Parameter param = new Parameter();
        		if (StringUtil.isNotNullOrEmpty(communityIdStr)) {
        			param.setCommunityIds(communityIdStr);
        			String resBody = OpenapiPoster.post(param, "analysis/getMarketYearListByCommunityIds");
					JSONResult<List> beans = (JSONResult<List>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<List>>() {
					}.getType());
        			if(!beans.getData().isEmpty()){
						res.setData(beans.getData());
						res.setMessage("ok");
						res.setStatusCode(1);
						res.setSuccess(true);
        				//return resBody;
        			}else{
						res.setMessage("ok");
						res.setStatusCode(2);
						res.setSuccess(false);
					}
        		}else{
					res.setMessage("ok");
					res.setStatusCode(2);
					res.setSuccess(false);
				}
        		

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
	 * @description: 根据userId和communityId查询用户报告列表
	 * @author: liuyanming
	 * @create: 2018/8/16 15:19
	 **/
    @RequestMapping(value="/selectReportByUserIdAndCommunityId", produces="application/json;charset=UTF-8")
    @ResponseBody
    public String selectReportByUserIdAndCommunityId(WxReport reportInfo, HttpServletRequest request, HttpServletResponse response){
        JSONResult jsonResult = new JSONResult();
        if(StringUtil.isNull(reportInfo.getUserId()) || StringUtil.isNull(reportInfo.getCommunityId())){
            jsonResult.setSuccess(false);
			jsonResult.setStatusCode(2);
            jsonResult.setMessage("userId or communityId is null");
            return CtrlerUtil.getRetBody(request, jsonResult);
        }
        List<WxReport> list = wxReportService.selectReport(reportInfo);
		jsonResult.setMessage("ok");
		jsonResult.setStatusCode(1);
        jsonResult.setSuccess(true);
        jsonResult.setData(list);
        return CtrlerUtil.getRetBody(request, jsonResult);
    }
}
