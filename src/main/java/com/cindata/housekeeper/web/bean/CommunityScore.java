package com.cindata.housekeeper.web.bean;


/**
 * 小区评分
 * @author yangss
 * @since  2017-05-04 09:10
 */
public class CommunityScore implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer busLineScore;//周边交通条件
	private Integer matingCountScore;//周边配套设施
	private Integer returnOnInvestment;//投资回报率
	private Integer hotScore;//小区活跃度
	private Integer makeMoneyScore;//小区变现能力
	private Integer scoreAll;//总分


	public Integer getBusLineScore() {
		if(busLineScore == null || busLineScore <= 0){
			busLineScore = 1;
		}
		if(busLineScore > 10){
			busLineScore = 10;
		}
		return busLineScore;
	}

	public void setBusLineScore(Integer busLineScore) {
		this.busLineScore = busLineScore;
	}

	public Integer getMatingCountScore() {
		if(matingCountScore == null || matingCountScore <= 0){
			matingCountScore = 1;
		}
		if(matingCountScore > 10){
			matingCountScore = 10;
		}
		return matingCountScore;
	}

	public void setMatingCountScore(Integer matingCountScore) {
		this.matingCountScore = matingCountScore;
	}

	public Integer getReturnOnInvestment() {
		if(returnOnInvestment == null || returnOnInvestment <= 0){
			returnOnInvestment = 1;
		}
		if(returnOnInvestment > 10){
			returnOnInvestment = 10;
		}
		return returnOnInvestment;
	}

	public void setReturnOnInvestment(Integer returnOnInvestment) {
		this.returnOnInvestment = returnOnInvestment;
	}

	public Integer getHotScore() {
		if(hotScore == null || hotScore <= 0){
			hotScore = 1;
		}
		if(hotScore > 10){
			hotScore = 10;
		}
		return hotScore;
	}

	public void setHotScore(Integer hotScore) {
		this.hotScore = hotScore;
	}

	public Integer getMakeMoneyScore() {
		if(makeMoneyScore == null || makeMoneyScore <= 0){
			makeMoneyScore = 1;
		}
		if(makeMoneyScore > 10){
			makeMoneyScore = 10;
		}
		return makeMoneyScore;
	}

	public void setMakeMoneyScore(Integer makeMoneyScore) {
		this.makeMoneyScore = makeMoneyScore;
	}

	public Integer getScoreAll() {
		scoreAll = (this.getBusLineScore() 
				+ this.getHotScore() 
				+ this.getMakeMoneyScore() 
				+ this.getMatingCountScore() 
				+ this.getReturnOnInvestment()) / 5;
		if(scoreAll == null || scoreAll <= 0){
			scoreAll = 1;
		}
		if(scoreAll > 10){
			scoreAll = 10;
		}
		return scoreAll;
	}

	public void setScoreAll(Integer scoreAll) {
		this.scoreAll = scoreAll;
	}
	
	
	
	

}
