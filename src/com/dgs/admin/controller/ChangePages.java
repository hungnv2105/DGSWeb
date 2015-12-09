package com.dgs.admin.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.dgs.action.ACore;
import com.dgs.admin.menu.object.ScreenObject;
import com.dgs.admin.menu.service.MenuService;
import com.dgs.dao.DGException;
import com.dgs.object.RespJSON;
import com.dgs.service.BaseService;

public class ChangePages extends ACore implements IMenuKey {

	/**
	 * author : hungnv 
	 * created on : 06/10/2015
	 */
	private static final long serialVersionUID = -5736939767190021553L;

	private ScreenObject bean = new ScreenObject();
	private RespJSON resp = new RespJSON();
	private BaseService service = null;
	final static Logger LOGGER = Logger.getLogger(ChangePages.class);

	private String pageForward;

	public String getPageForward() {
		return pageForward;
	}
	public void setPageForward(String pageForward) {
		this.pageForward = pageForward;
	}

	@Override
	public String execute() {
		service = new MenuService();
		Map<String, Object> respone = new HashMap<String, Object>();
		try {
			bean.setProcessId(GET_LIST_GROUP);
			respone.put("listGMenu", service.process(bean).getListResponse());
			bean.setProcessId(GET_LIST_BEANS);
			respone.put("listMenu", service.process(bean).getListResponse());
			resp.setJsonObject(respone);
		} catch (DGException e) {
			e.printStackTrace();
			LOGGER.error(e);
		}
		return SUCCESS;
	}

	public String changePage() {
		return this.pageForward;
	}

	@Override
	public RespJSON getModel() {
		// TODO Auto-generated method stub
		return resp;
	}
}
