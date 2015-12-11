package com.dgs.pub.common.menu.object;

import com.dgs.object.OBean;

public class MenuRstObject extends OBean {
	private int screenId;
	private String screenName;
	private String link;
	private int screenGroup;
	private int screenLevel;
	
	public int getScreenId() {
		return screenId;
	}
	public String getScreenName() {
		return screenName;
	}
	public String getLink() {
		return link;
	}
	public int getScreenGroup() {
		return screenGroup;
	}
	public int getScreenLevel() {
		return screenLevel;
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
	public void setScreenGroup(int group) {
		this.screenGroup = group;
	}
	public void setScreenLevel(int level) {
		this.screenLevel = level;
	}
}
