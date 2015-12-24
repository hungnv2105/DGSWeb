package com.dgs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.dgs.object.RespJSON;
import com.dgs.service.BaseService;
import com.opensymphony.xwork2.ModelDriven;

public abstract class BaseController implements ModelDriven<RespJSON>{
	/**
	 * author     : hungnv
	 * created on : 18/12/2015
	 */
	protected RespJSON resp = new RespJSON();
	protected BaseService service = null;
	protected HttpServletRequest request = ServletActionContext.getRequest();
	protected HttpServletResponse response = ServletActionContext.getResponse();
	
	public abstract String doProcess();
	
	
	public abstract String add();
	
}
