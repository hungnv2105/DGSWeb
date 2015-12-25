package com.dgs.admin.controllers;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;

import com.dgs.admin.inf.IKeyProcess;
import com.dgs.admin.object.ScreenObj;
import com.dgs.admin.service.HomeService;
import com.dgs.controller.BaseController;
import com.dgs.dao.DGException;
import com.dgs.object.OBean;

@Path("/home")
public class HomeController extends BaseController implements IKeyProcess {
	
	OBean bean = new ScreenObj();
	ObjectMapper mapper = new ObjectMapper();
	
	@GET
	@Path("/getAllMenus")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllMenus() {
		service = new HomeService();
		bean.setProcessId(GET_LIST_BEANS);
		try {
			resp = service.process(bean);
			return mapper.writeValueAsString(resp);
		} catch (DGException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
