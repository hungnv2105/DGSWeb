package com.dgs.admin.object;

import com.dgs.object.OBean;

public class ScreenObj extends OBean {
	private int screenId;
	private String screenName;
	
	public int getScreenId() {
		return screenId;
	}
	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
}
