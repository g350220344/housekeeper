package com.cindata.housekeeper.wx.service.impl;

import com.cindata.housekeeper.web.dao.CommonMapper;
import com.cindata.housekeeper.wx.dao.WxSuggestInfoMapper;
import com.cindata.housekeeper.wx.dao.WxUserInfoMapper;
import com.cindata.housekeeper.wx.dao.WxUserLoginLogMapper;
import com.cindata.housekeeper.wx.model.WxSuggestInfo;
import com.cindata.housekeeper.wx.model.WxUserInfo;
import com.cindata.housekeeper.wx.model.WxUserInfoExample;
import com.cindata.housekeeper.wx.model.WxUserInfoExample.Criteria;
import com.cindata.housekeeper.wx.model.WxUserLoginLog;
import com.cindata.housekeeper.wx.service.WxUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.sql.Date;
import java.util.List;

@Service
public class WxUserServiceImpl implements WxUserService {

	
	@Resource
    private WxUserInfoMapper wxUserInfoMapper;
	@Resource
	private WxUserLoginLogMapper wxUserLoginLogMapper;
	@Resource
	private WxSuggestInfoMapper wxSuggestInfoMapper;
	@Resource
	private CommonMapper commonMapper;
	@Override
	public int addUser(WxUserInfo wxUserInfo) {
		wxUserInfo.setUserId(commonMapper.getUuid());
		int i = 0;
		
		i = wxUserInfoMapper.insertSelective(wxUserInfo);
		return i;
	}
	@Override
	public WxUserInfo selectUserInfo(String id) {
		
		WxUserInfoExample wxUserInfoExample = new WxUserInfoExample();
		Criteria criteria = wxUserInfoExample.createCriteria();
		criteria.andUserIdEqualTo(id);
		WxUserInfo wxUserInfo = wxUserInfoMapper.selectByPrimaryKey(id);
		return wxUserInfo;
	}
	@Override
	public int updateUserInfo(WxUserInfo wxUserInfo) {
		int i = 0;
		WxUserInfoExample wxUserInfoExample = new WxUserInfoExample();
		Criteria criteria = wxUserInfoExample.createCriteria();
		criteria.andUserIdEqualTo(wxUserInfo.getUserId());
		i = wxUserInfoMapper.updateByExampleSelective(wxUserInfo, wxUserInfoExample);
		return i;
	}
	@Override
	public String selectUserIdByOpenId(String wxOpenId) {
		String UserId = "";
		WxUserInfoExample wxUserInfoExample = new WxUserInfoExample();
		Criteria criteria = wxUserInfoExample.createCriteria();
		 criteria.andWxOpenidEqualTo(wxOpenId);
		List<WxUserInfo> list = wxUserInfoMapper.selectByExample(wxUserInfoExample);
		if(list != null){
			UserId = list.get(0).getUserId();
		}
		return UserId;
	}

	@Override
	public List<WxUserInfo> getAllUser() {
		WxUserInfoExample wxUserInfoExample = new WxUserInfoExample();
		List<WxUserInfo> list = wxUserInfoMapper.selectByExample(wxUserInfoExample);
		return list;
	}

	@Override
	public WxUserInfo selectUserInfoByWxOpenid(String openId) {
		WxUserInfoExample wxUserInfoExample = new WxUserInfoExample();
		Criteria criteria = wxUserInfoExample.createCriteria();
		criteria.andWxOpenidEqualTo(openId);
		List<WxUserInfo> list = wxUserInfoMapper.selectByExample(wxUserInfoExample);
		WxUserInfo wxUserInfo = null;
		if(!list.isEmpty()){
			wxUserInfo = list.get(0);
		}
		return wxUserInfo;
	}

	@Override
	public int addUserLoginInfo(WxUserLoginLog userLoginLog) {
		return wxUserLoginLogMapper.insertSelective(userLoginLog);
	}

	@Override
	public int updateLastLoginTime(WxUserInfo user) {

		WxUserInfoExample wxUserInfoExample = new WxUserInfoExample();
		Criteria criteria = wxUserInfoExample.createCriteria();
		criteria.andUserIdEqualTo(user.getUserId());

		return wxUserInfoMapper.updateByExampleSelective(user, wxUserInfoExample);
	}
	@Override
	public int userSuggestion(WxSuggestInfo wxSuggestInfo) {
		
		wxSuggestInfo.setCreateDate(new java.sql.Date(new java.util.Date().getTime()));
		int i = wxSuggestInfoMapper.insertSelective(wxSuggestInfo);
		return i;
	}

}
