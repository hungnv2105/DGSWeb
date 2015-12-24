package com.dgs.admin.controllers;

import org.apache.log4j.Logger;


import com.dgs.admin.inf.IMenuKey;
import com.dgs.service.BaseService;
import com.opensymphony.xwork2.ModelDriven;

public class ChangePages implements ModelDriven<Object>, IMenuKey {

	/**
	 * author : hungnv 
	 * created on : 06/10/2015
	 */
	final static Logger LOGGER = Logger.getLogger(ChangePages.class);
	
	private Object model;
	private BaseService service = null;
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
