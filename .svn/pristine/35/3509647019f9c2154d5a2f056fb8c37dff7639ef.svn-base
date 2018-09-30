package com.cindata.housekeeper.web.service.impl;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cindata.housekeeper.core.common.tools.CommonHelper;
import com.cindata.housekeeper.core.common.tools.StringUtil;
import com.cindata.housekeeper.core.entity.Parameter;
import com.cindata.housekeeper.web.dao.BackstageUserInfoMapper;
import com.cindata.housekeeper.web.dao.GroupInfoMapper;
import com.cindata.housekeeper.web.dao.HouseInfoMapper;
import com.cindata.housekeeper.web.dao.PvUvInfoMapper;
import com.cindata.housekeeper.web.dao.SystemUserInfoMapper;
import com.cindata.housekeeper.web.dao.UserInfoMapper;
import com.cindata.housekeeper.web.model.BackstageUserInfo;
import com.cindata.housekeeper.web.model.BackstageUserInfoExample;
import com.cindata.housekeeper.web.model.BackstageUserInfoExample.Criteria;
import com.cindata.housekeeper.web.model.GroupInfo;
import com.cindata.housekeeper.web.model.GroupInfoExample;
import com.cindata.housekeeper.web.model.GroupList;
import com.cindata.housekeeper.web.model.HouseInfo;
import com.cindata.housekeeper.web.model.HouseInfoExample;
import com.cindata.housekeeper.web.model.PvUvInfoExample;
import com.cindata.housekeeper.web.model.SystemUserInfo;
import com.cindata.housekeeper.web.model.SystemUserInfoExample;
import com.cindata.housekeeper.web.model.UserInfo;
import com.cindata.housekeeper.web.model.UserInfoExample;
import com.cindata.housekeeper.web.service.BackstageUserInfoService;
import com.cindata.housekeeper.web.service.PvUvService;

@Service
public class BackstageUserInfoServiceImpl implements BackstageUserInfoService {

	 @Resource
	 private BackstageUserInfoMapper backstageUserInfoMapper;
	 @Resource
	 private HouseInfoMapper houseMapper;
	 @Resource
	 private GroupInfoMapper groupInfoMapper;
	 @Resource
	 private UserInfoMapper userInfoMapper;
	 @Resource
	 private SystemUserInfoMapper systemUserInfoMapper;
	 @Resource
	 private PvUvInfoMapper pvUvInfoMapper;
	@Override
	public BackstageUserInfo getBackstageUserInfoByUserName(String username) {
		BackstageUserInfoExample BackstageUserInfoExample = new BackstageUserInfoExample();
		Criteria criteria = BackstageUserInfoExample.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<BackstageUserInfo> list = backstageUserInfoMapper.selectByExample(BackstageUserInfoExample);
		 return list.isEmpty()?null:list.get(0);
	}

	@Override
	public int updateLastLoginTime(BackstageUserInfo BackstageUserInfo) {
		BackstageUserInfoExample BackstageUserInfoExample = new BackstageUserInfoExample();
		Criteria cri = BackstageUserInfoExample.createCriteria();
		
		cri.andIdEqualTo(BackstageUserInfo.getId());
		int i = backstageUserInfoMapper.updateByExampleSelective(BackstageUserInfo,BackstageUserInfoExample);
		return i;
	}

	@Override
	public int updatepassword(BackstageUserInfo BackstageUserInfo) {
		BackstageUserInfoExample BackstageUserInfoExample = new BackstageUserInfoExample();
		Criteria cri = BackstageUserInfoExample.createCriteria();
		cri.andIdEqualTo(BackstageUserInfo.getId());
		int i = backstageUserInfoMapper.updateByExampleSelective(BackstageUserInfo,BackstageUserInfoExample);
		return i;
	}

	@Override
	public List<BackstageUserInfo> selectBackstageUser(Parameter param) {
		BackstageUserInfoExample BackstageUserInfoExample = new BackstageUserInfoExample();
		Criteria cri = BackstageUserInfoExample.createCriteria();
		CommonHelper.setPage(param, 1,12);
		BackstageUserInfoExample.setOrderByClause("UPDATE_TIME DESC");
		List<BackstageUserInfo> list = backstageUserInfoMapper.selectBackStageUser(param);
		//List<BackstageUserInfo> list = BackstageUserInfoMapper.selectByExample(BackstageUserInfoExample);
		return list;
	}

	@Override
	public int createGroup(GroupInfo groupInfo) {
		
		BigDecimal b = new BigDecimal("1");
		groupInfo.setDateType(b);
		return groupInfoMapper.insertSelective(groupInfo);
		
	}

	@Override
	public List<GroupList> groupList(Parameter param) {
		List<GroupList> resultList = new ArrayList<GroupList>();
		
		HouseInfo houseInfo = new HouseInfo();
		
		UserInfo userInfo = new UserInfo();
		
		List list = new ArrayList();
		GroupInfoExample example = new GroupInfoExample();
		com.cindata.housekeeper.web.model.GroupInfoExample.Criteria Criteria = example.createCriteria();
		CommonHelper.setPage(param, 1,12);
		example.setOrderByClause("UPDATE_DATE DESC");
		List<GroupInfo> grouplist = groupInfoMapper.getGroupList(param);
		Date yesterday =StringUtil.getDate(StringUtil.getDay(-1));
		Date now = new Date(System.currentTimeMillis());
		for(GroupInfo groupInfo : grouplist){
			HouseInfoExample houseInfoExample = new HouseInfoExample();
			UserInfoExample userExample = new UserInfoExample();
			PvUvInfoExample pvUvInfoExample = new PvUvInfoExample();
			GroupInfoExample selectgroupcreatetimeExample = new GroupInfoExample();
			
			GroupList groupList = new GroupList();
			//企业id
			String groupId = groupInfo.getGroupId();
			//企业房产总数
			com.cindata.housekeeper.web.model.HouseInfoExample.Criteria houseInfocriteria = houseInfoExample.createCriteria();
			houseInfocriteria.andReserve1EqualTo(groupId);
			Long houseCount = houseMapper.countByExample(houseInfoExample);
			
			//用户数
			com.cindata.housekeeper.web.model.UserInfoExample.Criteria UserInfocriteria = userExample.createCriteria();
			UserInfocriteria.andGroupIdEqualTo(groupId);
			Long userCount = userInfoMapper.countByExample(userExample);
			
			//昨日首页访问量uv
			
			com.cindata.housekeeper.web.model.PvUvInfoExample.Criteria Uvcriteria = pvUvInfoExample.createCriteria();
			Uvcriteria.andGroupidEqualTo(groupId).andTypeEqualTo("index").andPuvdateLessThanOrEqualTo(now).andPuvdateGreaterThanOrEqualTo(yesterday);
			Long yesterdayUvCount = pvUvInfoMapper.dayUvCount(pvUvInfoExample);
			//首页访问量查询结果uv	
			com.cindata.housekeeper.web.model.GroupInfoExample.Criteria historyUvcriteria = selectgroupcreatetimeExample.createCriteria();
			historyUvcriteria.andGroupIdEqualTo(groupId);
			Date createDateUv = groupInfoMapper.selectByExample(selectgroupcreatetimeExample).get(0).getCreateDate();
			Uvcriteria.andGroupidEqualTo(groupId).andPuvdateLessThanOrEqualTo(yesterday).andPuvdateGreaterThanOrEqualTo(createDateUv);
			Long historyUvCount = pvUvInfoMapper.dayUvCount(pvUvInfoExample);
			
			//昨日首页访问量pv
			com.cindata.housekeeper.web.model.PvUvInfoExample.Criteria Pvcriteria = pvUvInfoExample.createCriteria();
			Pvcriteria.andGroupidEqualTo(groupId).andTypeEqualTo("index").andPuvdateLessThanOrEqualTo(now).andPuvdateGreaterThanOrEqualTo(yesterday);
			Long yesterdayPvCount = pvUvInfoMapper.historyPvCount(pvUvInfoExample);
			
			//首页访问量查询结果pv
			com.cindata.housekeeper.web.model.GroupInfoExample.Criteria historyPvcriteria = selectgroupcreatetimeExample.createCriteria();
			historyPvcriteria.andGroupIdEqualTo(groupId);
			Date createDatePv = groupInfoMapper.selectByExample(selectgroupcreatetimeExample).get(0).getCreateDate();
			Uvcriteria.andGroupidEqualTo(groupId).andPuvdateLessThanOrEqualTo(yesterday).andPuvdateGreaterThanOrEqualTo(createDatePv);
			Long historyPvCount = pvUvInfoMapper.historyPvCount(pvUvInfoExample);
			
			
			pvUvInfoMapper.countByExample(pvUvInfoExample);
			groupList.setGroupInfo(groupInfo);
			groupList.setHouseCount(houseCount);
			groupList.setUserCount(userCount);
			groupList.setYesterdayUvCount(yesterdayUvCount);
			groupList.setHistoryUvCount(historyUvCount);
			groupList.setYesterdayPvCount(yesterdayPvCount);
			groupList.setHistoryPvCount(historyPvCount);
			resultList.add(groupList);
		}
		return resultList;
	}

	@Override
	public GroupInfo selectBank(String groupName) {
		GroupInfoExample example = new GroupInfoExample();
		com.cindata.housekeeper.web.model.GroupInfoExample.Criteria criteria = example.createCriteria();
		criteria.andGroupNameEqualTo(groupName);
		List<GroupInfo> list = groupInfoMapper.selectByExample(example);
		 return list.isEmpty()?null:list.get(0);
	}

	@Override
	public int insertBankadministrator(SystemUserInfo systemUserInfo) {
		
		int i = systemUserInfoMapper.insertSelective(systemUserInfo);
		return i;
	}

	@Override
	public List<SystemUserInfo> selectAdministratorList(Parameter params) {
		
		SystemUserInfoExample systemUserInfoExample = new SystemUserInfoExample();
		com.cindata.housekeeper.web.model.SystemUserInfoExample.Criteria criteria = systemUserInfoExample.createCriteria();
		CommonHelper.setPage(params, 1,12);
		systemUserInfoExample.setOrderByClause("UPDATE_DATE DESC");
		List<SystemUserInfo> list = systemUserInfoMapper.selectAdministratorList(params);
		return list;
	}

	@Override
	public int updateAdministratorList(SystemUserInfo updatesystemUserInfo) {
		
		SystemUserInfoExample systemUserInfoExample = new SystemUserInfoExample();
		com.cindata.housekeeper.web.model.SystemUserInfoExample.Criteria criteria = systemUserInfoExample.createCriteria();
		criteria.andIdEqualTo(updatesystemUserInfo.getId());
		//criteria.andGroupIdEqualTo(updatesystemUserInfo.getGroupId());
		updatesystemUserInfo.setUpdateDate(new Date(System.currentTimeMillis()));
		int i=systemUserInfoMapper.updateByExampleSelective(updatesystemUserInfo, systemUserInfoExample);
		return i;
	}

	@Override
	public int deleteAdministratorList(SystemUserInfo systemUserInfo) {
		
		SystemUserInfoExample systemUserInfoExample = new SystemUserInfoExample();
		com.cindata.housekeeper.web.model.SystemUserInfoExample.Criteria criteria = systemUserInfoExample.createCriteria();
		criteria.andIdEqualTo(systemUserInfo.getId());
		int i = systemUserInfoMapper.updateByExampleSelective(systemUserInfo, systemUserInfoExample);
		return i;
	}

	@Override
	public SystemUserInfo selectAdministrator(String id) {
		
		return systemUserInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateBackStageList(BackstageUserInfo updateBackstageUserInfo) {
		
		BackstageUserInfoExample example = new BackstageUserInfoExample();
		Criteria criteria = example.createCriteria();	
		criteria.andIdEqualTo(updateBackstageUserInfo.getId());
		updateBackstageUserInfo.setUpdateTime(new Date(System.currentTimeMillis()));
		int i=backstageUserInfoMapper.updateByExampleSelective(updateBackstageUserInfo, example);
		return i;
	}

	@Override
	public int addBackStageUser(BackstageUserInfo backstageUserInfo) {
	
		int i = backstageUserInfoMapper.insertSelective(backstageUserInfo);
		
		return i;
	}

	@Override
	public SystemUserInfo selectUserName(String userName) {
		SystemUserInfoExample systemUserInfoExample = new SystemUserInfoExample();
		com.cindata.housekeeper.web.model.SystemUserInfoExample.Criteria criteria = systemUserInfoExample.createCriteria();
		criteria.andUsernameEqualTo(userName);
		List<SystemUserInfo> list = systemUserInfoMapper.selectByExample(systemUserInfoExample);
		 return list.isEmpty()?null:list.get(0);
	}

	@Override
	public String selectpasswordByUsername(String username) {
		
		BackstageUserInfoExample example = new BackstageUserInfoExample();
		Criteria criteria = example.createCriteria();	
		criteria.andUsernameEqualTo(username);
		return backstageUserInfoMapper.selectByExample(example).get(0).getPassword();
		
	}

	@Override
	public int updategroupList(GroupInfo groupInfo) {
	
		GroupInfoExample groupInfoExample = new GroupInfoExample();
		com.cindata.housekeeper.web.model.GroupInfoExample.Criteria criteria = groupInfoExample.createCriteria();
		criteria.andGroupIdEqualTo(groupInfo.getGroupId());
		return groupInfoMapper.updateByExampleSelective(groupInfo, groupInfoExample);
		
	}

	@Override
	public int countbackstageUserList(Parameter params) {
		BackstageUserInfoExample example = new BackstageUserInfoExample();
		Criteria criteria = example.createCriteria();
		//CommonHelper.setPage(params, 1,12);
		example.setOrderByClause("UPDATE_TIME DESC");
		List<BackstageUserInfo> list = backstageUserInfoMapper.selectCountBackStageUserNoPage(params);
		int count = list.size();
		return count;
		
	}

	@Override
	public int countgroupList(Parameter params) {
       List<GroupList> resultList = new ArrayList<GroupList>();
		
		HouseInfo houseInfo = new HouseInfo();
		
		UserInfo userInfo = new UserInfo();
		
		List list = new ArrayList();
		GroupInfoExample example = new GroupInfoExample();
		com.cindata.housekeeper.web.model.GroupInfoExample.Criteria Criteria = example.createCriteria();
		//CommonHelper.setPage(params, 1,12);
		example.setOrderByClause("UPDATE_DATE DESC");
		List<GroupInfo> grouplist = groupInfoMapper.getCountGroupListNoPage(params);
		Date yesterday =StringUtil.getDate(StringUtil.getDay(-1));
		Date now = new Date(System.currentTimeMillis());
		for(GroupInfo groupInfo : grouplist){
			HouseInfoExample houseInfoExample = new HouseInfoExample();
			UserInfoExample userExample = new UserInfoExample();
			PvUvInfoExample pvUvInfoExample = new PvUvInfoExample();
			GroupInfoExample selectgroupcreatetimeExample = new GroupInfoExample();
			
			GroupList groupList = new GroupList();
			//企业id
			String groupId = groupInfo.getGroupId();
			//企业房产总数
			com.cindata.housekeeper.web.model.HouseInfoExample.Criteria houseInfocriteria = houseInfoExample.createCriteria();
			houseInfocriteria.andReserve1EqualTo(groupId);
			Long houseCount = houseMapper.countByExample(houseInfoExample);
			
			//用户数
			com.cindata.housekeeper.web.model.UserInfoExample.Criteria UserInfocriteria = userExample.createCriteria();
			UserInfocriteria.andGroupIdEqualTo(groupId);
			Long userCount = userInfoMapper.countByExample(userExample);
			
			//昨日首页访问量uv
			
			com.cindata.housekeeper.web.model.PvUvInfoExample.Criteria Uvcriteria = pvUvInfoExample.createCriteria();
			Uvcriteria.andGroupidEqualTo(groupId).andTypeEqualTo("index").andPuvdateLessThanOrEqualTo(now).andPuvdateGreaterThanOrEqualTo(yesterday);
			Long yesterdayUvCount = pvUvInfoMapper.dayUvCount(pvUvInfoExample);
			//首页访问量查询结果uv	
			com.cindata.housekeeper.web.model.GroupInfoExample.Criteria historyUvcriteria = selectgroupcreatetimeExample.createCriteria();
			historyUvcriteria.andGroupIdEqualTo(groupId);
			Date createDateUv = groupInfoMapper.selectByExample(selectgroupcreatetimeExample).get(0).getCreateDate();
			Uvcriteria.andGroupidEqualTo(groupId).andPuvdateLessThanOrEqualTo(yesterday).andPuvdateGreaterThanOrEqualTo(createDateUv);
			Long historyUvCount = pvUvInfoMapper.dayUvCount(pvUvInfoExample);
			
			//昨日首页访问量pv
			com.cindata.housekeeper.web.model.PvUvInfoExample.Criteria Pvcriteria = pvUvInfoExample.createCriteria();
			Pvcriteria.andGroupidEqualTo(groupId).andTypeEqualTo("index").andPuvdateLessThanOrEqualTo(now).andPuvdateGreaterThanOrEqualTo(yesterday);
			Long yesterdayPvCount = pvUvInfoMapper.historyPvCount(pvUvInfoExample);
			
			//首页访问量查询结果pv
			com.cindata.housekeeper.web.model.GroupInfoExample.Criteria historyPvcriteria = selectgroupcreatetimeExample.createCriteria();
			historyPvcriteria.andGroupIdEqualTo(groupId);
			Date createDatePv = groupInfoMapper.selectByExample(selectgroupcreatetimeExample).get(0).getCreateDate();
			Uvcriteria.andGroupidEqualTo(groupId).andPuvdateLessThanOrEqualTo(yesterday).andPuvdateGreaterThanOrEqualTo(createDatePv);
			Long historyPvCount = pvUvInfoMapper.historyPvCount(pvUvInfoExample);
			
			
			pvUvInfoMapper.countByExample(pvUvInfoExample);
			groupList.setGroupInfo(groupInfo);
			groupList.setHouseCount(houseCount);
			groupList.setUserCount(userCount);
			groupList.setYesterdayUvCount(yesterdayUvCount);
			groupList.setHistoryUvCount(historyUvCount);
			groupList.setYesterdayPvCount(yesterdayPvCount);
			groupList.setHistoryPvCount(historyPvCount);
			resultList.add(groupList);
		}
		int i = resultList.size();
		return i;
		
		
	}

	@Override
	public int selectAdministratorListCountNoPage(Parameter params) {
		SystemUserInfoExample systemUserInfoExample = new SystemUserInfoExample();
		com.cindata.housekeeper.web.model.SystemUserInfoExample.Criteria criteria = systemUserInfoExample.createCriteria();
		//CommonHelper.setPage(params, 1,12);
		systemUserInfoExample.setOrderByClause("UPDATE_DATE DESC");
		List<SystemUserInfo> list =  systemUserInfoMapper.selectAdministratorListCountNoPage(params);
	    int i = list.size();
	    return i;
	}

	@Override
	public GroupInfo querygroup(String groupId) {
	
		return groupInfoMapper.selectByPrimaryKey(groupId);
	}

	@Override
	public SystemUserInfo querySystemUser(String id) {
		
		
		return systemUserInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public BackstageUserInfo queryBackstageUser(String id) {
		
		return backstageUserInfoMapper.selectByPrimaryKey(id);
	}

}
