package com.dgs.admin.user.action;

import com.dgs.action.ACore;
import com.dgs.admin.user.object.UserObject;

public class AUser extends ACore {
	
	private static final long serialVersionUID = 8679269603044190079L;
	
	private UserObject bean = new UserObject();

	public String addUser() throws Exception {
		return SUCCESS;
	}
	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	@Override
	public UserObject getModel() {
		// TODO Auto-generated method stub
		return bean;
	}

	

}
