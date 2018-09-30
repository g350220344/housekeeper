package com.cindata.housekeeper.wx.service;

import com.cindata.housekeeper.wx.model.WxSuggestInfo;
import com.cindata.housekeeper.wx.model.WxUserInfo;
import com.cindata.housekeeper.wx.model.WxUserLoginLog;

import java.util.List;

public interface WxUserService {

	int addUser(WxUserInfo wxUserInfo);

	WxUserInfo selectUserInfo(String id);

	int updateUserInfo(WxUserInfo wxUserInfo);

	WxUserInfo selectUserInfoByWxOpenid(String openId);

    int addUserLoginInfo(WxUserLoginLog userLoginLog);

	int updateLastLoginTime(WxUserInfo user);

	String selectUserIdByOpenId(String wxOpenId);

	List<WxUserInfo> getAllUser();

	int userSuggestion(WxSuggestInfo wxSuggestInfo);

}
