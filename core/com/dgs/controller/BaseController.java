package com.dgs.controller;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import com.dgs.object.RespJSON;

public abstract class BaseController {
	/**
	 * 
	 */
	
	protected ObjectMapper mapper = new ObjectMapper();
	protected RespJSON respJSON = new RespJSON();
	
	protected String parseJSON(RespJSON resp) {
		try {
			return mapper.writeValueAsString(resp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
