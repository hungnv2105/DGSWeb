package com.dgs.admin.menu.action;

import org.apache.log4j.Logger;

import com.dgs.action.ACore;
import com.dgs.admin.menu.object.ScreenObject;
import com.dgs.admin.menu.service.MenuService;
import com.dgs.object.ListBeans;
import com.dgs.object.OBean;

public class AMenu extends ACore{

	/**
	 * author     : hungnv
	 * created on : 06/10/2015
	 */
	private static final long serialVersionUID = -5736939767190021553L;
	
	private OBean bean = new ScreenObject();
	private MenuService service = new MenuService();
	final static Logger LOGGER = Logger.getLogger(AMenu.class);
	
	private ListBeans listGScreen;
	private ListBeans listScreen;
	
	public ListBeans getListGScreen() {
		return listGScreen;
	}

	public void setListGScreen(ListBeans listGScreen) {
		this.listGScreen = listGScreen;
	}

	public ListBeans getListScreen() {
		return listScreen;
	}

	public void setListScreen(ListBeans listScreen) {
		this.listScreen = listScreen;
	}

	@Override
	public String execute() throws Exception {
		listGScreen = service.getListGroupScreen();
		listScreen = service.getListScreen();
		return SUCCESS;
	}
	
	public String viewUserPage() {
		return SUCCESS;
	}

	@Override
	public OBean getModel() {
		// TODO Auto-generated method stub
		return bean;
	}

}
