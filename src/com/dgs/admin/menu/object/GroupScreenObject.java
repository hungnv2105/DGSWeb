package com.dgs.admin.menu.object;

public class GroupScreenObject {
	private int GroupId;
	private String GroupName;
	private int Order;
	
	public int getGroupId() {
		return GroupId;
	}
	public String getGroupName() {
		return GroupName;
	}
	public int getOrder() {
		return Order;
	}
	
	public void setGroupId(int groupId) {
		GroupId = groupId;
	}
	public void setGroupName(String groupName) {
		GroupName = groupName;
	}
	public void setOrder(int order) {
		Order = order;
	}
	
}
