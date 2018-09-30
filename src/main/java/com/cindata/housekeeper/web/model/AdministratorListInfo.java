package com.cindata.housekeeper.web.model;

import java.util.List;

public class AdministratorListInfo {

	private List<SystemUserInfo> systemUserInfo;
	
	private int count;
	
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<SystemUserInfo> getSystemUserInfo() {
		return systemUserInfo;
	}
	public void setSystemUserInfo(List<SystemUserInfo> systemUserInfo) {
		this.systemUserInfo = systemUserInfo;
	}
	
	
	
}
