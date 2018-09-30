package com.cindata.housekeeper.web.model;

import java.util.List;

public class GroupListInfo {

	private List<GroupList> groupList;

	private int count;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<GroupList> getGroupList() {
		return groupList;
	}
	public void setGroupList(List<GroupList> groupList) {
		this.groupList = groupList;
	}

	
	
}
