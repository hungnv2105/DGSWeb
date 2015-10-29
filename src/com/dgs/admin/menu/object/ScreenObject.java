package com.dgs.admin.menu.object;

public class ScreenObject {
	private int ScreenId;
	private String ScreenCode;
	private String ScreenName;
	private int GroupId;
	private int Type;
	private String Action;
	private String Link;
	private int Order;
	private int Status;
	
	public int getScreenId() {
		return ScreenId;
	}
	public String getScreenCode() {
		return ScreenCode;
	}
	public String getScreenName() {
		return ScreenName;
	}
	public int getGroupId() {
		return GroupId;
	}
	public int getType() {
		return Type;
	}
	public String getAction() {
		return Action;
	}
	public String getLink() {
		return Link;
	}
	public int getOrder() {
		return Order;
	}
	public int getStatus() {
		return Status;
	}
	
	public void setScreenId(int screenId) {
		ScreenId = screenId;
	}
	public void setScreenCode(String screenCode) {
		ScreenCode = screenCode;
	}
	public void setScreenName(String screenName) {
		ScreenName = screenName;
	}
	public void setGroupId(int groupId) {
		GroupId = groupId;
	}
	public void setType(int type) {
		Type = type;
	}
	public void setAction(String action) {
		Action = action;
	}
	public void setLink(String link) {
		Link = link;
	}
	public void setOrder(int order) {
		Order = order;
	}
	public void setStatus(int status) {
		Status = status;
	}
}
