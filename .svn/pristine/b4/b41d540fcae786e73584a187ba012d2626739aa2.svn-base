package com.cindata.housekeeper.web.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cindata.housekeeper.web.dao.UserBehaviorLogMapper;
import com.cindata.housekeeper.web.model.UserBehaviorLog;
import com.cindata.housekeeper.web.service.IUserBehaviorLogService;

@Service
public class UserBehaviorLogService implements IUserBehaviorLogService {
	
	@Resource
	private UserBehaviorLogMapper userBehaviorLogMapper;
	
	@Override
	public int log(UserBehaviorLog log) {
		int ret  = 0;
		try {
			ret  = userBehaviorLogMapper.insertSelective(log);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

}
