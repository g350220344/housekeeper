package com.cindata.housekeeper.web.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class AroundCommunityInfo implements Comparable{

	private String communityName;
	private Long communityId;
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

	public Long getCommunityId() {
		return communityId;
	}

	public void setCommunityId(Long communityId) {
		this.communityId = communityId;
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
		AroundCommunityInfo aroundCommunityInfo = (AroundCommunityInfo)o;
		return  (int) (this.distance - aroundCommunityInfo.distance);
	}
	
	
}
