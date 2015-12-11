package com.dgs.pub.common.slider.object;

import com.dgs.object.OBean;

public class SliderRstObject extends OBean{
	private int advertiseId;
	private String advertiseName;
	private String link;
	private int fileId;
	
	public int getAdvertiseId() {
		return advertiseId;
	}
	public String getAdvertiseName() {
		return advertiseName;
	}
	public String getLink() {
		return link;
	}
	public int getFileId() {
		return fileId;
	}
	
	public void setAdvertiseId(int advertiseId) {
		this.advertiseId = advertiseId;
	}
	public void setAdvertiseName(String advertiseName) {
		this.advertiseName = advertiseName;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
}
