package com.cindata.housekeeper.web.service.impl;

import com.cindata.housekeeper.core.common.tools.CommonHelper;
import com.cindata.housekeeper.core.common.tools.StringUtil;
import com.cindata.housekeeper.core.entity.Parameter;
import com.cindata.housekeeper.web.dao.GroupInfoMapper;
import com.cindata.housekeeper.web.dao.HouseInfoMapper;
import com.cindata.housekeeper.web.dao.UserInfoMapper;
import com.cindata.housekeeper.web.dao.UserLoginLogMapper;
import com.cindata.housekeeper.web.filter.LoginFilter;
import com.cindata.housekeeper.web.model.*;
import com.cindata.housekeeper.web.model.GroupInfoExample.Criteria;
import com.cindata.housekeeper.web.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class UserInfoServiceImpl implements UserInfoService{
    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private HouseInfoMapper houseInfoMapper;
	@Resource
	private UserLoginLogMapper userLoginLogMapper;
	@Resource
	private GroupInfoMapper groupInfoMapper;
    @Override
    public int addUserInfo(UserInfo userInfo) {
        return userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public UserInfo getUserInfoByMobile(String mobile) {
        UserInfoExample userInfoExample =new UserInfoExample();
        UserInfoExample.Criteria cri = userInfoExample.createCriteria();
        cri.andMobileEqualTo(mobile);
        List<UserInfo> list =userInfoMapper.selectByExample(userInfoExample);
        return list.isEmpty()?null:list.get(0);
    }

	@Override
	public Long getUserCount() {
		String groupId = LoginFilter.userInfo.getGroupId();

		UserInfoExample userInfoExample =new UserInfoExample();
		UserInfoExample.Criteria cri = userInfoExample.createCriteria();
		cri.andGroupIdEqualTo(groupId);

		Long i = userInfoMapper.countByExample(userInfoExample);
		
		return i;
	}

	@Override
	public Long userAddYesterday() {
		String groupId = LoginFilter.userInfo.getGroupId();

		Date yesterday =StringUtil.getDate(StringUtil.getDay(-1));
		Date now = new Date(System.currentTimeMillis());


		UserInfoExample userInfoExample =new UserInfoExample();
	     UserInfoExample.Criteria cri = userInfoExample.createCriteria();
		cri.andGroupIdEqualTo(groupId).andRegTimeLessThanOrEqualTo(now).andRegTimeGreaterThanOrEqualTo(yesterday);

	    Long i = userInfoMapper.countByExample(userInfoExample);
	     return i;
	}

	@Override
	public Long userLoginYesterday() {
		
		String groupId = LoginFilter.userInfo.getGroupId();
		Date yesterday =StringUtil.getDate(StringUtil.getDay(-1));
		Date now = new Date(System.currentTimeMillis());

	     UserLoginLogExample userInfoExample =new UserLoginLogExample();
		UserLoginLogExample.Criteria cri = userInfoExample.createCriteria();
	     cri.andGroupIdEqualTo(groupId).andCreateDateLessThanOrEqualTo(now).andCreateDateGreaterThanOrEqualTo(yesterday);
		Long i =  userLoginLogMapper.countByExample(userInfoExample);
		return i;
	}

	@Override
	public Long userLoginCount() {
		String groupId = LoginFilter.userInfo.getGroupId();
		UserLoginLogExample userInfoExample =new UserLoginLogExample();
		UserLoginLogExample.Criteria cri = userInfoExample.createCriteria();
		cri.andGroupIdEqualTo(groupId);
		Long i = userLoginLogMapper.countByExample(userInfoExample);
		//int i = userInfoMapper.userLoginCount();
		return i;
	}

	@Override
	public List<UserInfo> getUserInfoList(Parameter params) {
		CommonHelper.setPage(params, 1, 12);
		List<UserInfo> list = userInfoMapper.getUserInfoList(params);
		return list;
	}

	@Override
	public List<Map> getUserInfoListCount(Parameter params) {
		return userInfoMapper.getUserInfoListCount(params);
	}

	@Override
	public int addUserLoginInfo(UserLoginLog userLoginLog) {
		return userLoginLogMapper.insertSelective(userLoginLog);
	}

	@Override
	public int updateLastLoginTime(UserInfo user) {
		UserInfoExample userInfoExample =new UserInfoExample();
		UserInfoExample.Criteria cri = userInfoExample.createCriteria();
		cri.andMobileEqualTo(user.getMobile());
		return userInfoMapper.updateByExampleSelective(user,userInfoExample);
	}

	@Override
	public List<UserInfo> selectUserBank() {
		UserInfoExample userInfoExample =new UserInfoExample();
		UserInfoExample.Criteria cri = userInfoExample.createCriteria();
		
		return userInfoMapper.selectByExample(userInfoExample);
	}

	@Override
	public String selectUserGroupIdByUid(String userid) {
		
		UserInfoExample userInfoExample =new UserInfoExample();
		UserInfoExample.Criteria cri = userInfoExample.createCriteria();
		cri.andIdEqualTo(userid);
		List<UserInfo> list = userInfoMapper.selectByExample(userInfoExample);
		String groupId = list.get(0).getGroupId();
		return groupId;
	}

	@Override
	public GroupInfo getGroupInfoByMobile(String mobile) {
		 GroupInfo groupInfo = new GroupInfo();
		String groupId = "";
		 UserInfoExample userInfoExample =new UserInfoExample();
	        UserInfoExample.Criteria cri = userInfoExample.createCriteria();
	        cri.andMobileEqualTo(mobile);
	        List<UserInfo> list =userInfoMapper.selectByExample(userInfoExample);
	        UserInfo userInfo = list.isEmpty()?null:list.get(0);
			
	        if(userInfo != null){
	        	groupId = userInfo.getGroupId();
	        }
	        GroupInfoExample groupInfoExample = new GroupInfoExample();
	        Criteria criGroup = groupInfoExample.createCriteria();
	        criGroup.andGroupIdEqualTo(groupId);
	       List<GroupInfo> groupInfoByMobile = groupInfoMapper.selectByExample(groupInfoExample);
	       if(groupInfoByMobile != null){
	    	  groupInfo =  groupInfoByMobile.get(0);
	       }
	       return groupInfo;
	}

	@Override
	public int addWxUserInfo(UserInfo userInfo) {

		 return userInfoMapper.insertSelective(userInfo);
	}
}
