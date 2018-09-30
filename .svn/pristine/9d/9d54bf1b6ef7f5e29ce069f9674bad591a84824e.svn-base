package com.cindata.housekeeper.web.service.impl;

import com.cindata.housekeeper.web.dao.SystemUserInfoMapper;
import com.cindata.housekeeper.web.model.SystemUserInfo;
import com.cindata.housekeeper.web.model.SystemUserInfoExample;
import com.cindata.housekeeper.web.service.SysUserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class SysUserInfoServiceImpl implements SysUserInfoService {
    @Resource
    private SystemUserInfoMapper systemUserInfoMapper;



	@Override
	public SystemUserInfo getUserInfoByUserName(String userName) {
		List<SystemUserInfo> list = new ArrayList<SystemUserInfo>();
		SystemUserInfo systemUserInfo = null;
		SystemUserInfoExample systemUserInfoExample = new SystemUserInfoExample();
		systemUserInfoExample.createCriteria().andUsernameEqualTo(userName);
		list = systemUserInfoMapper.selectByExample(systemUserInfoExample);
		if(!list.isEmpty()){
			systemUserInfo = list.get(0);
		}
		return systemUserInfo;
	}
}
