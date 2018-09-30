package com.cindata.housekeeper.wx.controller;

import com.cindata.housekeeper.core.common.tools.CtrlerUtil;
import com.cindata.housekeeper.core.common.tools.EmojiUtil;
import com.cindata.housekeeper.core.common.tools.StringUtil;
import com.cindata.housekeeper.core.entity.JSONResult;
import com.cindata.housekeeper.web.bean.WxUserInfo;
import com.cindata.housekeeper.web.controller.WeixinServer;
import com.cindata.housekeeper.wx.model.WxUserLoginLog;
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

@Controller
@RequestMapping(value = "/WxLogin")
public class WxLoginController {

	
	private static Logger log = LoggerFactory.getLogger(WxLoginController.class);
	@Autowired
	private WxUserService wxUserService;
	
	/**
	 * 微信登录
	 */
	@RequestMapping(value="/login", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String login(HttpServletRequest request, HttpServletResponse response){
		String code = request.getParameter("code");
		JSONResult<com.cindata.housekeeper.wx.model.WxUserInfo> res = new JSONResult<com.cindata.housekeeper.wx.model.WxUserInfo>();

		try {
			WxUserInfo bean = WeixinServer.getWxUserInfo(request,code);
			HttpSession session = request.getSession();
			//储存用户
			if(bean != null){
				String openid = bean.getOpenid();
				String headimgurl = bean.getHeadimgurl();
				if(StringUtil.isNotNullOrEmpty(headimgurl)) {
					headimgurl = headimgurl.substring(0, headimgurl.lastIndexOf("/")) + "/132";
					bean.setHeadimgurl(headimgurl);
				}

				if(StringUtil.isNotNullOrEmpty(openid)){
					com.cindata.housekeeper.wx.model.WxUserInfo userInfo = wxUserService.selectUserInfoByWxOpenid(openid);

					//System.out.println("!!!!!!!!!!!!!!!!!!!!!!"+ auth(userInfo.getBusinessCard(),userInfo.getWxOpenid()));
					if(userInfo==null){
						userInfo = new com.cindata.housekeeper.wx.model.WxUserInfo();
						userInfo.setLastLoginTime(new java.sql.Date(System.currentTimeMillis()));
						userInfo.setWxOpenid(bean.getOpenid());
						userInfo.setCityName(bean.getCity());
						userInfo.setCountryName(bean.getCountry());
						userInfo.setProvinceName(bean.getProvince());
						userInfo.setSex(StringUtil.parseBigDecimal(bean.getSex(),new BigDecimal(1)));
						String nickName = bean.getNickname();
						nickName = EmojiUtil.strParseToHtmlDecimal(nickName);
						userInfo.setNickname(nickName);
						nickName = EmojiUtil.strParseToEmoji(nickName);

						userInfo.setHeadUrl(bean.getHeadimgurl());
						wxUserService.addUser(userInfo);
					}else{
						//保存登录信息
						WxUserLoginLog userLoginLog = new WxUserLoginLog();
						userLoginLog.setUserId(userInfo.getUserId());
						userLoginLog.setGroupId(userInfo.getWxOpenid());
						wxUserService.addUserLoginInfo(userLoginLog);
						com.cindata.housekeeper.wx.model.WxUserInfo user = new com.cindata.housekeeper.wx.model.WxUserInfo();
						user.setUserId(userInfo.getUserId());
						user.setLastLoginTime(new java.util.Date(System.currentTimeMillis()));

						//更新最后登录时间
						wxUserService.updateLastLoginTime(user);
					}

					//将数据存储到session中
					session.setAttribute("WxUserInfo", userInfo);
					res.setData(userInfo);
				}


				res.setSuccess(true);
				res.setStatusCode(1);
				res.setMessage("ok");
			}else{
				res.setSuccess(false);
				res.setStatusCode(99);
				res.setMessage("no ok");
			}
		}catch (Exception e){
			e.printStackTrace();
			res.setSuccess(false);
			res.setStatusCode(99);
			res.setMessage("no ok");
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
}
