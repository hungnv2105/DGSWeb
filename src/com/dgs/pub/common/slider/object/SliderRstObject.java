package com.dgs.pub.common.slider.object;

import com.dgs.object.OBean;

public class SliderRstObject extends OBean{
	private int advertiseId;
	private String advertiseName;
	private String link;
	private String fileName;
	private String filePath;
	private String extendtion;
	private String title;
	private String description;
	public int getAdvertiseId() {
		return advertiseId;
	}
	public String getAdvertiseName() {
		return advertiseName;
	}
	public String getLink() {
		return link;
	}
	public String getFileName() {
		return fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public String getExtendtion() {
		return extendtion;
	}
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
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
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public void setExtendtion(String extendtion) {
		this.extendtion = extendtion;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
