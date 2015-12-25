package com.dgs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.dgs.object.RespMesg;
import com.dgs.service.BaseService;

public abstract class BaseController {
	/**
	 * author     : hungnv
	 * created on : 18/12/2015
	 */
	protected RespMesg resp = new RespMesg();
	protected BaseService service = null;
	protected HttpServletRequest request = ServletActionContext.getRequest();
	protected HttpServletResponse response = ServletActionContext.getResponse();
	
}
