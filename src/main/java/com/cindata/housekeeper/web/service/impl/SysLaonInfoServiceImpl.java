package com.cindata.housekeeper.web.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cindata.housekeeper.core.common.tools.CommonHelper;
import com.cindata.housekeeper.core.entity.Parameter;
import com.cindata.housekeeper.web.dao.LoanInfoMapper;
import com.cindata.housekeeper.web.filter.LoginFilter;
import com.cindata.housekeeper.web.model.LoanInfo;
import com.cindata.housekeeper.web.model.LoanInfoExample;
import com.cindata.housekeeper.web.model.LoanInfoExample.Criteria;
import com.cindata.housekeeper.web.model.UserInfo;
import com.cindata.housekeeper.web.service.SysLaonInfoService;

@Service
public class SysLaonInfoServiceImpl implements SysLaonInfoService {

	@Resource
	private LoanInfoMapper loanInfoMapper;

	
	@Override
	public List<LoanInfo> loanapply(Parameter params) {
		
		CommonHelper.setPage(params, 1,12);
		
		List<LoanInfo> list = loanInfoMapper.getUserInfoList(params);
		return list;
	}


	@Override
	public List<LoanInfo> loanList() {
		
		String groupId = LoginFilter.userInfo.getGroupId();
		LoanInfoExample example = new LoanInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andGroupidEqualTo(groupId);
		List<LoanInfo> list = loanInfoMapper.selectByExample(example);
		return list;
	}
	

	
}
