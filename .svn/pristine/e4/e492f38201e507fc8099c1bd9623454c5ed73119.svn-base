package com.cindata.housekeeper.web.service;

import com.cindata.housekeeper.core.entity.Parameter;
import com.cindata.housekeeper.web.model.GroupInfo;
import com.cindata.housekeeper.web.model.UserInfo;
import com.cindata.housekeeper.web.model.UserLoginLog;

import java.util.List;
import java.util.Map;

public interface UserInfoService {
    int addUserInfo(UserInfo userInfo);

    UserInfo getUserInfoByMobile(String mobile);

    Long getUserCount();

    Long userAddYesterday();

    Long userLoginYesterday();

    Long userLoginCount();

    List<UserInfo> getUserInfoList(Parameter params);

    List<Map> getUserInfoListCount(Parameter params);

    int addUserLoginInfo(UserLoginLog userLoginLog);

    int updateLastLoginTime(UserInfo user);

	List<UserInfo> selectUserBank();

	String selectUserGroupIdByUid(String userid);

	GroupInfo getGroupInfoByMobile(String mobile);

    int addWxUserInfo(UserInfo userInfo);
}
