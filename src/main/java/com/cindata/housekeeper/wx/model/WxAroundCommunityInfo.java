package com.cindata.housekeeper.wx.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.cindata.housekeeper.web.model.AroundCommunityInfo;

public class WxAroundCommunityInfo implements Comparable{

	private String communityName;
	private String Detailaddress;
	private Timestamp CreatedDt;
	private BigDecimal Salesqmprice;
	private double distance;
	private String direction;
	private String buildYear;
	
	
	public String getBuildYear() {
		return buildYear;
	}
	public void setBuildYear(String buildYear) {
		this.buildYear = buildYear;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public String getCommunityName() {
		return communityName;
	}
	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
	public String getDetailaddress() {
		return Detailaddress;
	}
	public void setDetailaddress(String detailaddress) {
		Detailaddress = detailaddress;
	}
	public Timestamp getCreatedDt() {
		return CreatedDt;
	}
	public void setCreatedDt(Timestamp createdDt) {
		CreatedDt = createdDt;
	}
	public BigDecimal getSalesqmprice() {
		return Salesqmprice;
	}
	public void setSalesqmprice(BigDecimal salesqmprice) {
		Salesqmprice = salesqmprice;
	}
	@Override
	public String toString() {
		return "AroundCommunityInfo [communityName=" + communityName + ", Detailaddress=" + Detailaddress
				+ ", CreatedDt=" + CreatedDt + ", Salesqmprice=" + Salesqmprice + ", distance=" + distance
				+ ", direction=" + direction + "]";
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		WxAroundCommunityInfo wxAroundCommunityInfo = (WxAroundCommunityInfo)o;
		return  (int) (this.distance - wxAroundCommunityInfo.distance);
	}
}
