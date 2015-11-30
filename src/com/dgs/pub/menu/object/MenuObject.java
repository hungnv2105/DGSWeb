package com.dgs.pub.menu.object;

import com.dgs.object.OBean;

public class MenuObject extends OBean {
	private int screenId;
	private String screenName;
	private String link;
	
	public int getScreenId() {
		return screenId;
	}
	public String getScreenName() {
		return screenName;
	}
	public String getLink() {
		return link;
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
}
