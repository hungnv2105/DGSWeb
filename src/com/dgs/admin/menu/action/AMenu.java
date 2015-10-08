package com.dgs.admin.menu.action;

import java.util.ArrayList;
import java.util.List;

import com.dgs.action.ACoreImpl;
import com.dgs.admin.menu.object.MenuObject;
import com.dgs.admin.menu.service.MenuService;

public class AMenu extends ACoreImpl{

	/**
	 * author     : hungnv
	 * created on : 06/10/2015
	 */
	private static final long serialVersionUID = -5736939767190021553L;
	
	MenuService service = new MenuService();
	
	@Override
	public String execute() throws Exception {
		List<MenuObject> listMenu = new ArrayList<>();
		listMenu = service.getListMenu();
		return SUCCESS;
	}

}
