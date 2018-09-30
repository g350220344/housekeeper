package com.cindata.housekeeper.web.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cindata.housekeeper.core.common.tools.CtrlerUtil;
import com.cindata.housekeeper.core.common.tools.StringUtil;
import com.cindata.housekeeper.core.entity.JSONResult;
import com.cindata.housekeeper.web.filter.LoginFilter;
import com.cindata.housekeeper.web.model.CityInfo;
import com.cindata.housekeeper.web.model.GroupInfo;

import com.cindata.housekeeper.web.model.LoanInfo;
import com.cindata.housekeeper.web.service.CityService;
import com.cindata.housekeeper.web.service.LoanService;
import com.cindata.housekeeper.web.service.UserInfoService;
import com.cindata.housekeeper.wx.model.WxLoanInfo;

/**
 * @Describe 贷款接口
 * @Author  gaoy
 * @Time  2018/01/31 09:33:02
 * @param
 **/
@Controller
@RequestMapping(value = "/loan")
public class LoanController {

	@Autowired
	private LoanService loanService;
	@Autowired
	private UserInfoService userInfoService;

	
	private static Logger log = LoggerFactory.getLogger(LoanController.class);
	
	/**
	 * @Describe 贷款申请
	 * @Author  gaoy
	 * @Time  2018/01/31 09:33:02
	 * @param
	 **/
	@RequestMapping(value="/loanApply", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String loanApply(LoanInfo loanInfo,HttpServletRequest request, HttpServletResponse response){
		
		int i = 0;
		JSONResult res = new JSONResult();
		try {
			 i = loanService.loanApply(loanInfo);
			 res.setData(i);
			 res.setMessage("ok");
			 res.setStatusCode(1);
			 res.setSuccess(true);
			} catch (Exception e) {
				e.printStackTrace();
				res.setData(i);
			    res.setMessage("no ok");
				res.setStatusCode(2);
			    res.setSuccess(false);
			}
			String resultStr = CtrlerUtil.getRetBody(request, res);
			return resultStr;
	}
	
	/**
	 * @Describe 添加贷款
	 * @Author  gaoy
	 * @Time  2018/01/31 09:33:02
	 * @param
	 **/
	@RequestMapping(value="/addLoan", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String addLoan(LoanInfo loanApplyInfo,HttpServletRequest request, HttpServletResponse response){
		
		int i = 0;
		JSONResult res = new JSONResult();
		/*String userId = loanApplyInfo.getUserid();
		GroupInfo groupInfo = userInfoService.getGroupInfoByMobile(userId);
		String groupId = groupInfo.getGroupId();
		loanApplyInfo.setGroupid(groupId);*/
		try {
			 i = loanService.addLoan(loanApplyInfo);
			 res.setData(i);
			 res.setMessage("ok");
			 res.setStatusCode(1);
			 res.setSuccess(true);
			} catch (Exception e) {
				e.printStackTrace();
				res.setData(i);
			    res.setMessage("no ok");
				res.setStatusCode(2);
			    res.setSuccess(false);
			}
			String resultStr = CtrlerUtil.getRetBody(request, res);
			return resultStr;
	}
	
	
	/**
	 * @Describe 查询贷款
	 * @Author  gaoy
	 * @Time  2018/01/31 09:33:02
	 * @param
	 **/
	@RequestMapping(value="/selectLoan", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectLoan(HttpServletRequest request, HttpServletResponse response){
		
	    String userId = request.getParameter("userid");
		JSONResult res = new JSONResult();
		
		try {
			LoanInfo loanApplyInfo = loanService.selectLoan(userId);
			 res.setData(loanApplyInfo);
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
	 * @Describe 修改贷款
	 * @Author  gaoy
	 * @Time  2018/01/31 09:33:02
	 * @param
	 **/
	@RequestMapping(value="/updateLoan", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String updateLoan(LoanInfo loanApplyInfo,HttpServletRequest request, HttpServletResponse response){
		
	   
		JSONResult res = new JSONResult();
		
		try {
			int i = loanService.updateLoan(loanApplyInfo);
			 res.setData(i);
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
	 * @Describe 删除贷款
	 * @Author  gaoy
	 * @Time  2018/01/31 09:33:02
	 * @param
	 **/
	@RequestMapping(value="/deleteLoan", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String deleteLoan(LoanInfo loanApplyInfo,HttpServletRequest request, HttpServletResponse response){
		
	   
		JSONResult res = new JSONResult();
		
		try {
			int i = loanService.deleteLoan(loanApplyInfo);
			 res.setData(i);
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
	
	
}
