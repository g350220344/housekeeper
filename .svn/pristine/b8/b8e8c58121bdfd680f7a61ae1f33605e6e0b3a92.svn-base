package com.cindata.housekeeper.wx.controller;

import com.cindata.housekeeper.core.common.tools.CtrlerUtil;
import com.cindata.housekeeper.core.common.tools.StringUtil;
import com.cindata.housekeeper.core.entity.JSONResult;
import com.cindata.housekeeper.core.entity.Parameter;
import com.cindata.housekeeper.wx.model.WxMessage;
import com.cindata.housekeeper.wx.service.WxMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
@RequestMapping(value = "/WxMessage")
public class WxMessageController {

	
	private static Logger log = LoggerFactory.getLogger(WxMessageController.class);
	
	
	
	@Autowired
	private WxMessageService wxMessageService;

	/**
	 * 获取用户消息列表
	 */
	@RequestMapping(value="/getMessageListByUserId", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getMessageListByUserId(HttpServletRequest request, HttpServletResponse response){

		String userId = request.getParameter("userId");
		int page = StringUtil.parseInt(request.getParameter("page"),null);
		int rows =StringUtil.parseInt(request.getParameter("rows"),null);
		Parameter parameter = new Parameter();
		parameter.setUserId(userId);
		parameter.setPage(page);
		parameter.setRows(rows);
        JSONResult<List<WxMessage>> result = new JSONResult<List<WxMessage>>();

        try {
			long count = wxMessageService.getCount(userId);
			List<WxMessage> list = wxMessageService.getMessageListByUserId(parameter);
			result.setDataCount(count);
			result.setData(list);
            result.setStatusCode(1);
            result.setSuccess(true);
            result.setMessage("成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatusCode(2);
            result.setSuccess(false);
        }
        String resultStr = CtrlerUtil.getRetBody(request, result);
		return resultStr;
	}
	/**
	 * 获取用户未读消息列表
	 */
	@RequestMapping(value="/getNoReadMessageListByUserId", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getNoReadMessageListByUserId(HttpServletRequest request, HttpServletResponse response){

		String userId = request.getParameter("userId");

		JSONResult<List<WxMessage>> result = new JSONResult<List<WxMessage>>();

		try {
			long count = wxMessageService.getNoReadCount(userId);
			List<WxMessage> list = wxMessageService.getNoReadMessageListByUserId(userId);
			result.setDataCount(count);
			result.setData(list);
			result.setStatusCode(1);
			result.setSuccess(true);
			result.setMessage("成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatusCode(2);
			result.setSuccess(false);
		}
		String resultStr = CtrlerUtil.getRetBody(request, result);
		return resultStr;
	}

	/**
	 * 将未读消息更新成已读
	 */
	@RequestMapping(value="/updateReadStatus", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String updateReadStatus(HttpServletRequest request, HttpServletResponse response){

		String messageId = request.getParameter("messageId");

		JSONResult result = new JSONResult();

		try {
			long count = wxMessageService.updateReadStatus(messageId);
			result.setDataCount(count);
			result.setStatusCode(1);
			result.setSuccess(true);
			result.setMessage("成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatusCode(2);
			result.setSuccess(false);
		}
		String resultStr = CtrlerUtil.getRetBody(request, result);
		return resultStr;
	}

}
