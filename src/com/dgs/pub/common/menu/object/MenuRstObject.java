package com.dgs.pub.common.menu.object;

import com.dgs.object.OBean;

public class MenuRstObject extends OBean {
	private int screenId;
	private String screenName;
	private String link;
	private int group;
	private int level;
	
	public int getScreenId() {
		return screenId;
	}
	public String getScreenName() {
		return screenName;
	}
	public String getLink() {
		return link;
	}
	public int getGroup() {
		return group;
	}
	public int getLevel() {
		return level;
	}
	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public void setGroup(int group) {
		this.group = group;
	}
	public void setLevel(int level) {
		this.level = level;
	}
}
