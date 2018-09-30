package com.cindata.housekeeper.web.controller.system;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cindata.housekeeper.core.common.tools.CtrlerUtil;
import com.cindata.housekeeper.core.common.tools.StringUtil;
import com.cindata.housekeeper.core.entity.JSONResult;
import com.cindata.housekeeper.core.entity.Parameter;
import com.cindata.housekeeper.web.filter.LoginFilter;
import com.cindata.housekeeper.web.model.LoanInfo;
import com.cindata.housekeeper.web.model.UserInfo;
import com.cindata.housekeeper.web.service.SysLaonInfoService;
import com.cindata.housekeeper.web.service.SysUserInfoService;
import com.cindata.housekeeper.web.service.UserInfoService;

/**
 * @Describe 通用服务
 * @Author  gaoy
 * @Time  2018/01/31 09:33:02
 * @param
 **/
@Controller
@RequestMapping(value = "/sys/loan")
public class SysLoanApplyInfo {

	
	@Autowired
	private SysLaonInfoService sysUserInfoService;

	/**
	 * 查询贷款申请人员列表
	 */
	@RequestMapping(value="/loanList", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String loanList(HttpServletRequest request, HttpServletResponse response){
		
		JSONResult res = new JSONResult();
		String status = request.getParameter("status");
		Date startDate = StringUtil.parseDate(request.getParameter("startDate"),null);
		Date endDate = StringUtil.parseDate(request.getParameter("endDate"),null);
		endDate = StringUtil.parseDate(StringUtil.getDayDate(endDate,1),null);
		Integer page = StringUtil.parseInt(request.getParameter("page"),null);
		Integer rows = StringUtil.parseInt(request.getParameter("rows"),null);
		
		Parameter params = new Parameter();
		String groupId = LoginFilter.userInfo.getGroupId();
		List<Map> list = null;
		List<LoanInfo> listData = null;
		
		
		
		try {
			params.setStartDate(startDate);
			params.setEndDate(endDate);
			params.setGroupId(groupId);
			params.setPage(page);
			params.setRows(rows);
            params.setStatus(status);
			listData = sysUserInfoService.loanapply(params);
			
			res.setData(listData);
			res.setMessage("ok");
			res.setStatusCode(1);
			res.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();;
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
	
	
	/**
	 * 查询贷款申请人员列表
	 */
	/*@RequestMapping(value="/loanList", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String loanList(HttpServletRequest request, HttpServletResponse response){
		
		JSONResult<List<LoanInfo>> res = new JSONResult<List<LoanInfo>>();
		 List<LoanInfo> list = new ArrayList<LoanInfo>();
		try {
			
           list = sysUserInfoService.loanList();
			
			res.setData(list);
			res.setMessage("ok");
			res.setStatusCode(1);
			res.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();;
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
		
	}*/
}
