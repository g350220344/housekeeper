package com.cindata.housekeeper.web.service.impl;

import java.sql.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cindata.housekeeper.core.common.tools.StringUtil;
import com.cindata.housekeeper.web.dao.BackstageUserInfoMapper;
import com.cindata.housekeeper.web.dao.PvUvInfoMapper;
import com.cindata.housekeeper.web.model.PvUvInfo;
import com.cindata.housekeeper.web.model.PvUvInfoExample;
import com.cindata.housekeeper.web.model.PvUvInfoExample.Criteria;
import com.cindata.housekeeper.web.service.PvUvService;

@Service
public class PvUvServiceImpl implements PvUvService {

	 @Resource
	 private PvUvInfoMapper pvUvInfoMapper;
	 
	 
	@Override
	public int insertPvUv(PvUvInfo pvuvInfo) {
		pvuvInfo.setPuvdate(StringUtil.getDate(StringUtil.getDay(-2)));
		//pvuvInfo.setPuvdate(new Date(System.currentTimeMillis()));
		int i = pvUvInfoMapper.insertSelective(pvuvInfo);
		return i;
	}


	@Override
	public PvUvInfo selectByUserip(String ip) {
	
		PvUvInfoExample example = new PvUvInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andIpEqualTo(ip);
		return pvUvInfoMapper.selectByExample(example).get(0);
		 
	}

}
