package com.cindata.housekeeper.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cindata.housekeeper.web.dao.BackstagePermissionMapper;
import com.cindata.housekeeper.web.dao.BackstageUserInfoMapper;
import com.cindata.housekeeper.web.model.BackstagePermission;
import com.cindata.housekeeper.web.model.BackstagePermissionExample;
import com.cindata.housekeeper.web.model.BackstagePermissionExample.Criteria;

import com.cindata.housekeeper.web.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Resource
	 private BackstagePermissionMapper backstagePermissionMapper;
	
	@Override
	public BackstagePermission selectPermission(String p) {
		
		return backstagePermissionMapper.selectByPrimaryKey(p);
	}
	@Override
	public List<BackstagePermission> queryPermission() {
		
		BackstagePermissionExample backstagePermission = new BackstagePermissionExample();
		Criteria criteria = backstagePermission.createCriteria();
		return backstagePermissionMapper.selectByExample(backstagePermission);
	}
}
