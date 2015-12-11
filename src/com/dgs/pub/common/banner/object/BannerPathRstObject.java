package com.dgs.pub.common.banner.object;

import com.dgs.object.OBean;

public class BannerPathRstObject extends OBean {
	private int uploadId;
	private String fileName;
	private String filePath;
	private String extendtion;
	private String title;
	private String description;
	
	public int getUploadId() {
		return uploadId;
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
	public void setUploadId(int uploadId) {
		this.uploadId = uploadId;
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
