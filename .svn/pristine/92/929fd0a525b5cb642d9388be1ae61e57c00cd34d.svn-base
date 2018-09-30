package com.cindata.housekeeper.web.controller;

import com.cindata.housekeeper.core.common.tools.CtrlerUtil;
import com.cindata.housekeeper.core.common.tools.StringUtil;
import com.cindata.housekeeper.core.entity.JSONResult;
import com.cindata.housekeeper.web.model.GroupInfo;
import com.cindata.housekeeper.web.model.UserInfo;
import com.cindata.housekeeper.web.model.UserLoginLog;
import com.cindata.housekeeper.web.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.sql.Date;


/**
 * @Describe	用户信息接口
 * @Author  gaoy
 * @Time  2018/02/23 11:32:34
 * @param
 **/
@Controller
@RequestMapping(value = "/user")
public class  UserInfoController {
	@Autowired
	private UserInfoService userInfoService;
	

	/**
	 * 登录接口
	 */
	@RequestMapping(value="/login", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String login(HttpServletRequest request, HttpServletResponse response){
	    String mobile = request.getParameter("mobile");
		UserInfo userInfo =null;
		JSONResult res = new JSONResult();
		try {
			if(StringUtil.isNotNullOrEmpty(mobile)){
				userInfo = userInfoService.getUserInfoByMobile(mobile);
				UserInfo user = new UserInfo();
				user.setMobile(mobile);
				user.setGroupId("bank_123");
				user.setRegType(new BigDecimal(2));
				user.setLastLoginTime(new Date(System.currentTimeMillis()));
				if(userInfo==null){
					userInfoService.addUserInfo(user);
				}else{
					//保存登录信息
					UserLoginLog userLoginLog = new UserLoginLog();
					userLoginLog.setGroupId(userInfo.getGroupId());
					userLoginLog.setUserId(mobile);
					userInfoService.addUserLoginInfo(userLoginLog);

				}
					//更新最后登录时间
				userInfoService.updateLastLoginTime(user);
			}


			res.setData(mobile);
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
	 * 根据用户mobile获取企业信息
	 */
	@RequestMapping(value="/groupInfoByMobile", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String groupInfoByMobile(HttpServletRequest request, HttpServletResponse response){
		

		JSONResult<GroupInfo> res = new JSONResult<GroupInfo>();
		try {
            GroupInfo groupInfo = new GroupInfo();
            String mobile = request.getParameter("mobile");
            String groupId = "";
            UserInfo userInfo =null;
            if(StringUtil.isNotNullOrEmpty(mobile)){
                groupInfo = userInfoService.getGroupInfoByMobile(mobile);
            }
			res.setData(groupInfo);
			res.setMessage("ok");
			res.setStatusCode(1);
			res.setSuccess(true);
		} catch (Exception e) {
			//res.setData(cityInfoList);
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
		
		
	}
}
