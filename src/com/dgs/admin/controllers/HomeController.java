package com.dgs.admin.controllers;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.map.ObjectMapper;

import com.dgs.admin.inf.IKeyProcess;
import com.dgs.admin.object.ScreenObj;
import com.dgs.admin.service.HomeService;
import com.dgs.controller.BaseController;
import com.dgs.dao.DGException;
import com.dgs.object.OBean;

@Provider
@Path("/home")
public class HomeController extends BaseController implements IKeyProcess, ContainerResponseFilter {
	
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

	@Override
	public void filter(ContainerRequestContext request,
            ContainerResponseContext response) throws IOException {
        response.getHeaders().add("Access-Control-Allow-Origin", "*");
        response.getHeaders().add("Access-Control-Allow-Headers",
                "origin, content-type, accept, authorization");
        response.getHeaders().add("Access-Control-Allow-Credentials", "true");
        response.getHeaders().add("Access-Control-Allow-Methods",
                "GET, POST, PUT, DELETE, OPTIONS, HEAD");
    }
}
