package com.dgs.admin.menu.object;

import com.dgs.object.OBean;

public class GroupScreenObject extends OBean {
	private int groupId;
	private String groupName;
	private int order;
	
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
}
