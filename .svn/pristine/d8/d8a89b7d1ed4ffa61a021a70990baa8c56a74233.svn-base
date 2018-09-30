package com.cindata.housekeeper.web.service.impl;



import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cindata.housekeeper.core.common.tools.StringUtil;
import com.cindata.housekeeper.web.dao.CityInfoMapper;
import com.cindata.housekeeper.web.dao.GroupInfoMapper;
import com.cindata.housekeeper.web.dao.LoanInfoMapper;
import com.cindata.housekeeper.web.dao.LoanInfoMapper;
import com.cindata.housekeeper.web.filter.LoginFilter;
import com.cindata.housekeeper.web.model.GroupInfo;
import com.cindata.housekeeper.web.model.LoanInfo;
import com.cindata.housekeeper.web.model.LoanInfoExample;
import com.cindata.housekeeper.web.model.LoanInfo;
import com.cindata.housekeeper.web.model.LoanInfoExample;
import com.cindata.housekeeper.web.model.LoanInfoExample.Criteria;
import com.cindata.housekeeper.web.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService {

	@Resource
	private LoanInfoMapper loanInfoMapper;
	@Resource
	private GroupInfoMapper groupInfoMapper;
	@Resource
	private LoanInfoMapper loanApplyInfoMapper;
	
	@Override
	public int loanApply(LoanInfo loanInfo) {
		
		loanInfo.setGroupid("bank_123");	
		loanInfo.setLoanApplyTime(new Date(System.currentTimeMillis()));
		loanInfo.setStatus("1");
		loanInfo.setProductname("test浜у搧");
		
		int i = loanInfoMapper.insertSelective(loanInfo);
		return i;
	}

	@Override
	public int addLoan(LoanInfo loanApplyInfo) {
		
		loanApplyInfo.setStatus("1");
		
		return loanApplyInfoMapper.insertSelective(loanApplyInfo);
	}

	@Override
	public LoanInfo selectLoan(String userId) {
		
		
		LoanInfoExample loanApplyInfoExample = new LoanInfoExample();

		 com.cindata.housekeeper.web.model.LoanInfoExample.Criteria criteria =  loanApplyInfoExample.createCriteria();
		 //criteria.andUseridEqualTo(userId);
		 List<LoanInfo> loanApplyInfo = loanApplyInfoMapper.selectByExample(loanApplyInfoExample);
		return loanApplyInfo.get(0) == null ? null : loanApplyInfo.get(0);
	}
	
	@Override
	public List<LoanInfo> selectLoan() {
		String groupid = LoginFilter.userInfo.getGroupId();
		LoanInfoExample loan = new LoanInfoExample();
		Criteria criteria = loan.createCriteria();
		criteria.andGroupidEqualTo(groupid);
		return loanInfoMapper.selectByExample(loan);
		
	}


	@Override
	public int updateLoan(LoanInfo loanApplyInfo) {
		
		LoanInfoExample loanApplyInfoExample = new LoanInfoExample();
		 com.cindata.housekeeper.web.model.LoanInfoExample.Criteria criteria = loanApplyInfoExample.createCriteria();
		 criteria.andLoanidEqualTo(loanApplyInfo.getLoanid());
		 int i = loanApplyInfoMapper.updateByExampleSelective(loanApplyInfo,loanApplyInfoExample);
		return i;
	}

	@Override
	public int deleteLoan(LoanInfo loanApplyInfo) {
		
		LoanInfoExample loanApplyInfoExample = new LoanInfoExample();
		 com.cindata.housekeeper.web.model.LoanInfoExample.Criteria criteria = loanApplyInfoExample.createCriteria();
		 criteria.andLoanidEqualTo(loanApplyInfo.getLoanid());
		int i = loanApplyInfoMapper.updateByExampleSelective(loanApplyInfo, loanApplyInfoExample);
		return i;
	}

	

}
