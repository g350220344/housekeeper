package com.cindata.housekeeper.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cindata.housekeeper.core.common.tools.CommonHelper;
import com.cindata.housekeeper.core.common.tools.CtrlerUtil;
import com.cindata.housekeeper.core.common.tools.ServletRequestHelper;
import com.cindata.housekeeper.core.common.tools.StringUtil;
import com.cindata.housekeeper.core.entity.JSONResult;
import com.cindata.housekeeper.core.entity.Parameter;
import com.cindata.housekeeper.web.model.ApplyCommunityInfo;

/**
 * 通用服务
 * @author yangss
 * @date   2018.01.30 10:57
 */
@Controller
@RequestMapping(value = "/sys")
public class SystemServer {
	
	/**
	 * 小区搜索接口
	 */
	@RequestMapping(value="/getTime", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getTime(HttpServletRequest request, HttpServletResponse response){
		JSONResult<String> res = new JSONResult<>(StringUtil.dateFormat(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss", null), "ok", true);
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
	
}
