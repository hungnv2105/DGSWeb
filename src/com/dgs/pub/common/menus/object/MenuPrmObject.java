package com.dgs.pub.common.menus.object;

import com.dgs.object.OBean;

public class MenuPrmObject extends OBean{
	private int group;
	private int level;
	private int type;
	
	public int getGroup() {
		return group;
	}
	public int getLevel() {
		return level;
	}
	public int getType() {
		return type;
	}
	public void setGroup(int group) {
		this.group = group;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public void setType(int type) {
		this.type = type;
	}
	
}
