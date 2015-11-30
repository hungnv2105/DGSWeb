package com.dgs.admin.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import com.dgs.admin.menu.object.ScreenObject;
import com.dgs.admin.menu.service.MenuService;
import com.dgs.controller.BaseController;
import com.dgs.dao.DGException;
import com.dgs.object.RespJson;
import com.dgs.service.BaseService;

public class AMenu extends BaseController implements IMenuKey {

	/**
	 * author : hungnv 
	 * created on : 06/10/2015
	 */
	private static final long serialVersionUID = -5736939767190021553L;

	private ScreenObject bean = new ScreenObject();
	private RespJson resp = new RespJson();
	private BaseService service = null;
	final static Logger LOGGER = Logger.getLogger(AMenu.class);

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
			respone.put("listMenu", service.process(bean).getListResponse());
			resp.setRespJson(respone);
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
	public RespJson getModel() {
		// TODO Auto-generated method stub
		return resp;
	}
}
