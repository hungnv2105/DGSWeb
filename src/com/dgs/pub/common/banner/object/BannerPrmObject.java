package com.dgs.pub.common.banner.object;

import com.dgs.object.OBean;

public class BannerPrmObject extends OBean {
	private int type;
	private int uploadId;
	
	public int getType() {
		return type;
	}
	public int getUploadId() {
		return uploadId;
	}
	public void setType(int type) {
		this.type = type;
	}
	public void setUploadId(int uploadId) {
		this.uploadId = uploadId;
	}
}
