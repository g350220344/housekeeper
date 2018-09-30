package com.cindata.housekeeper.web.service;

import java.util.List;

import com.cindata.housekeeper.core.entity.Parameter;
import com.cindata.housekeeper.web.model.BackstageUserInfo;
import com.cindata.housekeeper.web.model.GroupInfo;
import com.cindata.housekeeper.web.model.GroupList;
import com.cindata.housekeeper.web.model.SystemUserInfo;

public interface BackstageUserInfoService {

	BackstageUserInfo getBackstageUserInfoByUserName(String username);

	int updateLastLoginTime(BackstageUserInfo BackstageUserInfo);

	int updatepassword(BackstageUserInfo BackstageUserInfo);

	List<BackstageUserInfo> selectBackstageUser(Parameter param);

	int createGroup(GroupInfo groupInfo);

	List<GroupList> groupList(Parameter param);

	GroupInfo selectBank(String groupName);

	int insertBankadministrator(SystemUserInfo systemUserInfo);

	List<SystemUserInfo> selectAdministratorList(Parameter params);

	int updateAdministratorList(SystemUserInfo updatesystemUserInfo);

	int deleteAdministratorList(SystemUserInfo systemUserInfo);

	SystemUserInfo selectAdministrator(String id);

	int updateBackStageList(BackstageUserInfo updateBackstageUserInfo);

	int addBackStageUser(BackstageUserInfo backstageUserInfo);

	SystemUserInfo selectUserName(String username);

	String selectpasswordByUsername(String username);

	int updategroupList(GroupInfo groupInfo);

	int countbackstageUserList(Parameter params);

	int countgroupList(Parameter params);

	int selectAdministratorListCountNoPage(Parameter params);

	GroupInfo querygroup(String groupId);

	SystemUserInfo querySystemUser(String id);

	BackstageUserInfo queryBackstageUser(String id);
}
