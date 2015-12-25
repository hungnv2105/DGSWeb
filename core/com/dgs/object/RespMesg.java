package com.dgs.object;

import java.util.List;

public class RespMesg {
	private int respCode;
	private int respDesc;
	private List<Object> jsonObject;
	
	public int getRespCode() {
		return respCode;
	}
	public void setRespCode(int respCode) {
		this.respCode = respCode;
	}
	public int getRespDesc() {
		return respDesc;
	}
	public void setRespDesc(int respDesc) {
		this.respDesc = respDesc;
	}
	public List<Object> getJsonObject() {
		return jsonObject;
	}
	public void setJsonObject(List<Object> jsonObject) {
		this.jsonObject = jsonObject;
	}
	
	public void addJsonObject(Object obj) {
		this.jsonObject.add(obj);
	}

}
