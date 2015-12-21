package com.dgs.object;

import java.util.HashMap;
import java.util.Map;

public class RespJSON {
	private int respCode;
	private int respMsg;
	private Map<String, Object> jsonObject = new HashMap<String, Object>();
	
	public int getRespCode() {
		return respCode;
	}
	public void setRespCode(int respCode) {
		this.respCode = respCode;
	}
	public int getRespMsg() {
		return respMsg;
	}
	public void setRespMsg(int respMsg) {
		this.respMsg = respMsg;
	}
	public Map<String, Object> getJsonObject() {
		return jsonObject;
	}
	public void setJsonObject(Map<String, Object> jsonObject) {
		this.jsonObject = jsonObject;
	}

}
