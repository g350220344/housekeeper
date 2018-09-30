package com.cindata.housekeeper.web.service;

import com.cindata.housekeeper.web.model.UserBehaviorLog;

/**
 * 用户行为日志
 * @author xdth-yangss
 *
 */
public interface IUserBehaviorLogService {
	
	int log(UserBehaviorLog log);

}
