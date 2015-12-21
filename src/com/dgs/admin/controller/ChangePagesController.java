package com.dgs.admin.controller;

import org.apache.log4j.Logger;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.dgs.admin.inf.IMenuKey;
import com.dgs.admin.menu.object.ScreenObject;
import com.dgs.admin.menu.service.MenuService;
import com.dgs.controller.BaseController;
import com.dgs.dao.DGException;
import com.dgs.object.RespJSON;
import com.dgs.service.BaseService;
import com.opensymphony.xwork2.ModelDriven;

public class ChangePagesController implements ModelDriven<Object>, IMenuKey {

	/**
	 * author : hungnv 
	 * created on : 06/10/2015
	 */
	final static Logger LOGGER = Logger.getLogger(ChangePagesController.class);
	
	private ScreenObject bean = new ScreenObject();
	private Object model;
	private BaseService service = null;

//	@Override
//	public String execute() {
//		service = new MenuService();
//		Map<String, Object> respone = new HashMap<String, Object>();
//		try {
//			bean.setProcessId(GET_LIST_GROUP);
//			respone.put("listGMenu", service.process(bean).getListResponse());
//			bean.setProcessId(GET_LIST_BEANS);
//			respone.put("listMenu", service.process(bean).getListResponse());
//			resp.setJsonObject(respone);
//		} catch (DGException e) {
//			e.printStackTrace();
//			LOGGER.error(e);
//		}
//		return SUCCESS;
//	}
	
	public HttpHeaders index() {
		service = new MenuService();
		try {
			model = service.process(bean).getListResponse();
		} catch (DGException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new DefaultHttpHeaders("index").disableCaching();
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return model;
	}

}
