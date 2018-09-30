package com.cindata.housekeeper.web.controller.system;

import com.cindata.housekeeper.core.common.tools.CtrlerUtil;
import com.cindata.housekeeper.core.common.tools.StringUtil;
import com.cindata.housekeeper.core.entity.JSONResult;
import com.cindata.housekeeper.core.entity.Parameter;
import com.cindata.housekeeper.web.filter.LoginFilter;
import com.cindata.housekeeper.web.model.SystemUserInfo;
import com.cindata.housekeeper.web.model.UserInfo;
import com.cindata.housekeeper.web.service.SysUserInfoService;
import com.cindata.housekeeper.web.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通用服务
 * @author yangss
 * @date   2018.01.30 10:57
 */
@Controller
@RequestMapping(value = "/sys/user")
public class SysUserInfoControllor {
	@Autowired
	private SysUserInfoService sysUserInfoService;

	@Autowired
	private UserInfoService userInfoService;
	/**
	 * 登录接口
	 */
	@RequestMapping(value="/login", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String login(HttpServletRequest request, HttpServletResponse response){
		JSONResult res = new JSONResult();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		SystemUserInfo userInfo =null;
		String message = "";
		int status = 1;


		try {
			if(StringUtil.isNotNullOrEmpty(username)){
				userInfo = sysUserInfoService.getUserInfoByUserName(username);
				if(userInfo==null){
					message = "用户名不存在";
					status = 2;
				}else{
					if(password.equals(userInfo.getPassword())){
						message = "ok";
						status = 1;
						res.setData(userInfo);
						//使用request对象的getSession()获取session，如果session不存在则创建一个
						HttpSession session = request.getSession();
						//将数据存储到session中
						session.setAttribute("userInfo", userInfo);
						//更新最后登录时间
						userInfo.setLastLoginDate(new Date(System.currentTimeMillis()));
					}else{
						message = "密码错误";
						status = 2;
					}
				}
			}
			res.setMessage(message);
			res.setStatusCode(status);
			res.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			//res.setData(cityInfoList);
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
	/**
	 * 业务用户列表
	 */
	@RequestMapping(value="/getUserInfoList", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getUserInfoList(HttpServletRequest request, HttpServletResponse response){
		JSONResult res = new JSONResult();
		String groupId = LoginFilter.userInfo.getGroupId();
		List<UserInfo> listData = new ArrayList<UserInfo>();
		List<Map> list = new ArrayList<Map>();

		Parameter params = new Parameter();
		String userId = request.getParameter("userId");
		Date startDate = StringUtil.parseDate(request.getParameter("startDate"),null);
		Date endDate = StringUtil.parseDate(request.getParameter("endDate"),null);
		endDate = StringUtil.parseDate(StringUtil.getDayDate(endDate,1),null);
		Integer page = StringUtil.parseInt(request.getParameter("page"),null);
		Integer rows = StringUtil.parseInt(request.getParameter("rows"),null);
		String orderByClause = request.getParameter("orderByClause");

		try {
			params.setStartDate(startDate);
			params.setEndDate(endDate);
			params.setUserId(userId);
			params.setGroupId(groupId);
			params.setPage(page);
			params.setRows(rows);
			params.setOrderByClause(orderByClause);

			listData = userInfoService.getUserInfoList(params);
			list = userInfoService.getUserInfoListCount(params);
			/*Page<UserInfo> pages = new Page<UserInfo>();
			pages.setList(list);*/
			Map map =new HashMap();
			if(!list.isEmpty()){
				map = list.get(0);
				map.put("data",listData);
			}


			res.setData(map);
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
	
}
