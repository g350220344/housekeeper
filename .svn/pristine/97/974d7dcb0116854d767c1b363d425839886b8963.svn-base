package com.cindata.housekeeper.job.ant;


import com.cindata.housekeeper.web.controller.CommunityInfoController;
import com.cindata.housekeeper.web.model.ApplyCommunityInfo;
import com.cindata.housekeeper.web.model.CommunityMarket;
import com.cindata.housekeeper.web.model.DealCommunity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * 极光推送线程
 * 
 * @author yangss
 * @since 2017-11-15 14:46
 */
public class SendJPushThread extends Thread {
	
	private static Logger log = LoggerFactory.getLogger(SendJPushThread.class);



	public SendJPushThread() {

		
	}
	public SendJPushThread(Long communityId, Date month,ApplyCommunityInfo applyCommunityInfo, CommunityMarket communityMarket, int type) {
		this.month = month;
		this.communityId = communityId;
		this.type = type;
		this.communityMarket = communityMarket;
		this.applyCommunityInfo = applyCommunityInfo;
	}
	public SendJPushThread(Long cityId, Long communityId,String communityName,List<DealCommunity> dealCommunityList,int type) {
		this.cityId = cityId;
		this.communityId = communityId;
		this.communityName = communityName;
		this.dealCommunityList = dealCommunityList;
		this.type = type;
	}
	public SendJPushThread(Long communityId, Date month, Map result, CommunityMarket communityMarket, int type) {
		this.month = month;
		this.communityId = communityId;
		this.type = type;
		this.communityMarket = communityMarket;
		this.result = result;
	}
	private Long cityId;
	private Long communityId ;
	private String communityName;
	private List<DealCommunity> dealCommunityList ;
	private int type;
	private Map result;
	private Date month;
	private CommunityMarket communityMarket;
	private ApplyCommunityInfo applyCommunityInfo;



    public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getCommunityId() {
		return communityId;
	}

	public void setCommunityId(Long communityId) {
		this.communityId = communityId;
	}

	public List<DealCommunity> getDealCommunityList() {
		return dealCommunityList;
	}

	public void setDealCommunityList(List<DealCommunity> dealCommunityList) {
		this.dealCommunityList = dealCommunityList;
	}

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public Date getMonth() {
		return month;
	}

	public void setMonth(Date month) {
		this.month = month;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public CommunityMarket getCommunityMarket() {
		return communityMarket;
	}

	public void setCommunityMarket(CommunityMarket communityMarket) {
		this.communityMarket = communityMarket;
	}

	public ApplyCommunityInfo getApplyCommunityInfo() {
		return applyCommunityInfo;
	}

	public void setApplyCommunityInfo(ApplyCommunityInfo applyCommunityInfo) {
		this.applyCommunityInfo = applyCommunityInfo;
	}

	public Map getResult() {
		return result;
	}

	public void setResult(Map result) {
		this.result = result;
	}

	@Override
	public void run() {
		switch (this.type){
			case 0:
				dealCommunityList = new CommunityInfoController().getDealCommunity(communityId,cityId,communityName);
					break;
			case 1:
				communityMarket = new CommunityInfoController().getCommunityMarket(month,communityId);
				/*applyCommunityInfo.setSalesqmprice(communityMarket.getSalesqmprice());
				applyCommunityInfo.setRenttotalprice(communityMarket.getRentsqmprice());*/
					break;
		}



	}


}