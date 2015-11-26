package com.dgs.object;

import java.util.HashMap;
import java.util.Map;

public class RespJson  {
	private int respCode;
	private int respMsg;
	private Map<String, Object> respJson = new HashMap<String, Object>();
	
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
	public Map<String, Object> getRespJson() {
		return respJson;
	}
	public void setRespJson(Map<String, Object> respJson) {
		this.respJson = respJson;
	}

}
