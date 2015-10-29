package com.dgs.admin.user.action;

import com.dgs.action.ACore;
import com.dgs.admin.menu.object.MenuObject;
import com.dgs.object.OBean;

public class AUser extends ACore {
	
	private static final long serialVersionUID = 1L;
	
	private OBean bean = new MenuObject();
	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	@Override
	public OBean getModel() {
		// TODO Auto-generated method stub
		return bean;
	}

	

}
