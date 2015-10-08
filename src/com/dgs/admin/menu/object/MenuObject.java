package com.dgs.admin.menu.object;

import com.dgs.object.OBeen;

public class MenuObject extends OBeen {
	private int menuId;
	private int appId;
	private int parentId;
	private int groupMenu;
	private String menuName;
	private String filePath;
	private int order;
	private int isParent;
	
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getGroupMenu() {
		return groupMenu;
	}
	public void setGroupMenu(int groupMenu) {
		this.groupMenu = groupMenu;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public int getIsParent() {
		return isParent;
	}
	public void setIsParent(int isParent) {
		this.isParent = isParent;
	}
}
