package com.cindata.housekeeper.wx.controller;

import com.cindata.housekeeper.core.common.tools.CtrlerUtil;
import com.cindata.housekeeper.core.common.tools.EmojiUtil;
import com.cindata.housekeeper.core.common.tools.StringUtil;
import com.cindata.housekeeper.core.entity.JSONResult;
import com.cindata.housekeeper.web.bean.WxUserInfo;
import com.cindata.housekeeper.web.controller.WeixinServer;
import com.cindata.housekeeper.wx.model.WxReport;
import com.cindata.housekeeper.wx.model.WxUserLoginLog;
import com.cindata.housekeeper.wx.service.WxReportService;
import com.cindata.housekeeper.wx.service.WxUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping(value = "/WxReport")
public class WxReportController {

	
	private static Logger log = LoggerFactory.getLogger(WxReportController.class);
	@Autowired
	private WxReportService wxReportService;
	
	/**
	 * 查询报告
	 */
	@RequestMapping(value="/getReportInfo", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getReportInfo(HttpServletRequest request, HttpServletResponse response){
		String reportId = request.getParameter("reportId");
		JSONResult<WxReport> res = new JSONResult<WxReport>();

		try {
			WxReport wxReport = wxReportService.selectReportById(reportId);
			//储存用户
			if(wxReport != null){
				res.setData(wxReport);
				res.setSuccess(true);
				res.setStatusCode(1);
				res.setMessage("ok");
			}else{
				res.setSuccess(false);
				res.setStatusCode(2);
				res.setMessage("no ok");
			}
		}catch (Exception e){
			e.printStackTrace();
			res.setSuccess(false);
			res.setStatusCode(2);
			res.setMessage("no ok");
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}

	/**
	 * 小区报告订阅总数
	 */
	@RequestMapping(value="/getReportCont", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getReportCont(HttpServletRequest request, HttpServletResponse response){
		String communityId = request.getParameter("communityId");
		JSONResult<List<WxReport>> res = new JSONResult<List<WxReport>>();

		try {
			List<WxReport> list= wxReportService.getReportCont(communityId);
			//储存用户
			if(!list.isEmpty()){
				res.setData(list);
				res.setDataCount((long) list.size());
				res.setSuccess(true);
				res.setStatusCode(1);
				res.setMessage("ok");
			}else{
				res.setDataCount(0l);
				res.setSuccess(true);
				res.setStatusCode(1);
				res.setMessage("ok");
			}
		}catch (Exception e){
			e.printStackTrace();
			res.setSuccess(false);
			res.setStatusCode(2);
			res.setMessage("no ok");
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}/**
	 * 小区报告未读更新成已读
	 */
	@RequestMapping(value="/updateReportRead", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String updateReportRead(HttpServletRequest request, HttpServletResponse response){
		String communityId = request.getParameter("communityId");
		String userId = request.getParameter("userId");
		JSONResult res = new JSONResult();

		try {
			int i= wxReportService.updateReporReadByUserIdAndCommunityId(userId,communityId);
			res.setSuccess(true);
			res.setStatusCode(1);
			res.setMessage("ok");
		}catch (Exception e){
			e.printStackTrace();
			res.setSuccess(false);
			res.setStatusCode(2);
			res.setMessage("no ok");
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
}
