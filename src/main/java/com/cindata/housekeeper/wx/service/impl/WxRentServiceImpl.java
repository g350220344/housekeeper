package com.cindata.housekeeper.wx.service.impl;

import com.cindata.housekeeper.core.common.tools.StringUtil;
import com.cindata.housekeeper.wx.dao.WxRentInfoMapper;
import com.cindata.housekeeper.wx.model.WxRentInfo;
import com.cindata.housekeeper.wx.model.WxRentInfoExample;
import com.cindata.housekeeper.wx.model.WxRentInfoExample.Criteria;
import com.cindata.housekeeper.wx.model.WxSelectLease;
import com.cindata.housekeeper.wx.model.WxSelectLeaseList;
import com.cindata.housekeeper.wx.service.WxRentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Service
public class WxRentServiceImpl implements WxRentService {

	
	@Resource
	private WxRentInfoMapper rentInfoMapper;
	
	/**
	 * @author TakZhang
	 * 
	 * */
	@Override
	public void insertRent(WxRentInfo rentInfo) throws Exception{
		rentInfoMapper.insertSelective(rentInfo);
	}
	
	/**
	 * @author TakZhang
	 * 
	 **/
	@Override
	public void updateRent(WxRentInfo rentInfo) throws Exception {
		WxRentInfoExample wxRentInfoExample = new WxRentInfoExample();
		Criteria criteria = wxRentInfoExample.createCriteria();
		criteria.andIdEqualTo(rentInfo.getId());
		rentInfoMapper.updateByExampleSelective(rentInfo, wxRentInfoExample);
	}
	
	/**
	 * @author TakZhang
	 *
	 **/
	@Override
	public void deleteRent(WxRentInfo rentInfo) throws Exception {
		WxRentInfo r = new WxRentInfo();
		r.setState(new BigDecimal(2));
		
		WxRentInfoExample wxRentInfoExample = new WxRentInfoExample();
		Criteria criteria = wxRentInfoExample.createCriteria();
		criteria.andIdEqualTo(rentInfo.getId());
		rentInfoMapper.updateByExampleSelective(r, wxRentInfoExample);
	}
	
	@Override
	public WxSelectLease selectNextRent(String houseId) {
		return rentInfoMapper.selectNextRent(houseId);
	}


	@Override
	public List<WxSelectLeaseList> selectNextRentList(String houseId) {
		return rentInfoMapper.selectNextRentList(houseId);
	}
/*-------------------------------------------takZhang↑-----------------------------------------*/
	@Override
	public int addRent(WxRentInfo loanInfo) {
		
		int i = rentInfoMapper.insertSelective(loanInfo);
		return i;
	}
	@Override
	public List<WxRentInfo> selectRentByUserAndHouseId(WxRentInfo wxRentInfo) {
		
		WxRentInfoExample wxRentInfoExample = new WxRentInfoExample();
		Criteria criteria = wxRentInfoExample.createCriteria();
		criteria.andUserIdEqualTo(wxRentInfo.getUserId()).andHouseIdEqualTo(wxRentInfo.getHouseId());
		List<WxRentInfo> list = rentInfoMapper.selectByExample(wxRentInfoExample);
		return list;
	}
	@Override
	public int updateRentInfo(WxRentInfo loanInfo) {
		int i = 0;
		WxRentInfoExample wxRentInfoExample = new WxRentInfoExample();
		Criteria criteria = wxRentInfoExample.createCriteria();
		criteria.andIdEqualTo(loanInfo.getId());
		i = rentInfoMapper.updateByExampleSelective(loanInfo, wxRentInfoExample);
		return i;
	}
	@Override
	public int deleteRentInfo(WxRentInfo loanInfo) {
		int i = 0;
		/*loanInfo.setState(new BigDecimal(2));
		WxRentInfoExample wxRentInfoExample = new WxRentInfoExample();
		Criteria criteria = wxRentInfoExample.createCriteria();
		criteria.andIdEqualTo(loanInfo.getId());
		i = rentInfoMapper.updateByExampleSelective(loanInfo, wxRentInfoExample);*/
		i = rentInfoMapper.deleteByPrimaryKey(loanInfo.getId());
		return i;
		
	}
	@SuppressWarnings("deprecation")
	@Override
	public WxRentInfo periodRent(WxRentInfo loanInfo) {
		String cycleName = "";
		java.util.Date dateRent = loanInfo.getLeaseTime();
		int term = loanInfo.getTerm().intValue();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateRent);
		calendar.add(Calendar.MONTH, term);
		
		Calendar calendarRentDate = Calendar.getInstance();
		calendarRentDate.setTime(dateRent);
		java.util.Date dateRentNew = calendar.getTime();
		int date = calendar.get(Calendar.DATE);
		String rentStatus = "";
		//租约开始的下个月
		/*calendar.add(Calendar.MONTH, 1); 
		java.util.Date date = calendar.getTime();
		Date nextMonth=new Date(date.getTime());*/
		
		//当前时间
		java.util.Date dateNow = new java.util.Date();
		Calendar now = Calendar.getInstance();

		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);
		
		now.set(year, month,date);
		now.add(Calendar.MONTH, 1);
		
		Date dateResult = new Date(now.getTime().getTime());
		//租的月份个数
		 int resultyear = (now.get(Calendar.YEAR) - calendarRentDate.get(Calendar.YEAR)) * 12;
	     int resultmonth = now.get(Calendar.MONTH) - calendarRentDate.get(Calendar.MONTH);
	     int resultFactdiff = resultyear + resultmonth;
		
		BigDecimal rentPrice = loanInfo.getMoney();
		//累计收租
		BigDecimal grandToal = rentPrice.multiply(new BigDecimal(resultFactdiff));
		loanInfo.setGrandToal(grandToal);
		loanInfo.setNextMonth(dateResult);
		loanInfo.setResultFactdiff(resultFactdiff);
		
		BigDecimal cycle = loanInfo.getCycle();
		if(cycle.compareTo(new BigDecimal(1)) == 0){
			cycleName ="按月";
		}
		if(cycle.compareTo(new BigDecimal(2)) == 0){
			cycleName ="按季";
		}
		if(cycle.compareTo(new BigDecimal(3)) == 0){
			cycleName ="按年";
		}
		loanInfo.setCycleName(cycleName);
		
		if(dateRentNew.after(dateNow)){
			rentStatus = "租约未到期";
		}else{
			rentStatus = "租约已到期";
		}
		loanInfo.setRentStatus(rentStatus);
		return loanInfo;
	}
	@Override
	public List<WxRentInfo> selectRentByHouseId(WxRentInfo loanInfo) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public WxRentInfo selectRentByRentId(String id) {
		
		
		return rentInfoMapper.selectByPrimaryKey(id);
	}
	@Override
	public List<WxRentInfo> selectRentByUserId(String userId) {
	
		WxRentInfoExample wxRentInfoExample = new WxRentInfoExample();
		Criteria criteria = wxRentInfoExample.createCriteria();
		criteria.andUserIdEqualTo(userId);
		return rentInfoMapper.selectByExample(wxRentInfoExample);
		
	}

	@Override
	public List<WxRentInfo> selectRentByUserIdAndStatus(String userId, int status) {
		WxRentInfoExample wxRentInfoExample = new WxRentInfoExample();
		Criteria criteria = wxRentInfoExample.createCriteria();
		criteria.andUserIdEqualTo(userId).andStateEqualTo(new BigDecimal(status));
		List<WxRentInfo> list = rentInfoMapper.selectByExample(wxRentInfoExample);
		return list;
	}

	@Override
	public BigDecimal getRentPrice(List<WxRentInfo> wxRentInfoList, java.util.Date date) {
		BigDecimal rentPrice = new BigDecimal(0);
		for(int i=0;i<wxRentInfoList.size();i++){
			WxRentInfo wxRentInfo= wxRentInfoList.get(i);
			java.sql.Date leaseDate =  wxRentInfo.getLeaseTime();
			int term = StringUtil.parseInt(wxRentInfo.getTerm(),0);
			for(int j=0;j<term;) {
				//根据收租形式作相应处理
				if (wxRentInfo.getCycle().equals(new BigDecimal(1))) {
					//按月
					j++;
				}
				if (wxRentInfo.getCycle().equals(new BigDecimal(2))) {
					//按季度
					j = j + 3;
				}
				if (wxRentInfo.getCycle().equals(new BigDecimal(3))) {
					//按年
					j = j + 12;
				}
				String nowDate = StringUtil.formatDateString(date,"yyyy-MM");
				if(nowDate.equals(StringUtil.dateFormat(StringUtil.getMonth(leaseDate,j),"yyyy-MM","",2))){
					rentPrice = rentPrice.add(wxRentInfo.getMoney());
					break;
				}
			}
		}
		return rentPrice;
	}

	@Override
	public List<WxRentInfo> selectRentByHouseIdAndStatus(String houseId, int status) {
		WxRentInfoExample wxRentInfoExample = new WxRentInfoExample();
		Criteria criteria = wxRentInfoExample.createCriteria();
		criteria.andHouseIdEqualTo(houseId).andStateEqualTo(new BigDecimal(status));
		List<WxRentInfo> list = rentInfoMapper.selectByExample(wxRentInfoExample);
		return list;
	}

	@Override
	public int updateRentStatus() {
		return rentInfoMapper.updateRentStatus();
	}
}
