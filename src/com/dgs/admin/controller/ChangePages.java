package com.dgs.admin.controller;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.dgs.admin.menu.object.ScreenObject;
import com.dgs.admin.menu.service.MenuService;
import com.dgs.controller.BaseController;
import com.dgs.dao.DGException;

import com.dgs.service.BaseService;

@Path("/changePage")
public class ChangePages extends BaseController implements IMenuKey {

	/**
	 * author : hungnv 
	 * created on : 06/10/2015
	 */
	private ScreenObject bean = new ScreenObject();
	private BaseService service = null;
	final static Logger LOGGER = Logger.getLogger(ChangePages.class);
	
	@GET
	@Path("/listMenu")
	@Produces(MediaType.APPLICATION_JSON)
	public String getListMenu() {
		service = new MenuService();
		Map<String, Object> respone = new HashMap<String, Object>();
		try {
			bean.setProcessId(GET_LIST_BEANS);
			respone.put("listMenu", service.process(bean).getListResponse());
			respJSON.setRespJson(respone);
			return parseJSON(respJSON);
		} catch (DGException e) {
			e.printStackTrace();
			LOGGER.error(e);
		} 
		return null;
	}

}
