package com.dgs.admin.menu.action;

import org.apache.log4j.Logger;

import com.dgs.action.ACore;
import com.dgs.admin.menu.object.ScreenObject;
import com.dgs.admin.menu.service.MenuService;
import com.dgs.dao.DGException;
import com.dgs.object.ListBeans;
import com.dgs.object.OBean;

public class AMenu extends ACore implements IMenuKey {

	/**
	 * author : hungnv 
	 * created on : 06/10/2015
	 */
	private static final long serialVersionUID = -5736939767190021553L;

	private OBean bean = new ScreenObject();
	private MenuService service = new MenuService();
	final static Logger LOGGER = Logger.getLogger(AMenu.class);

	private ListBeans listGroup;
	private ListBeans listBeans;
	private String pageForward;

	public String getPageForward() {
		return pageForward;
	}
	public void setPageForward(String pageForward) {
		this.pageForward = pageForward;
	}

	@Override
	public String execute() {
		try {
			listGroup = service.getListGroupScreen();
			listBeans = service.getListScreen();
		} catch (DGException e) {
			e.printStackTrace();
			LOGGER.error(e);
		}
		return SUCCESS;
	}

	public String changePage() {
		try {
			if (this.pageForward.equals(VIEW_USER_PAGE)) {
				listBeans = service.getListUsers();
			} else if (this.pageForward.equals(VIEW_ROLE_PAGE)) {
				listBeans = new ListBeans();
			}
		} catch (DGException e) {
			e.printStackTrace();
			LOGGER.error(e);
		}
		return this.pageForward;
	}

	@Override
	public OBean getModel() {
		// TODO Auto-generated method stub
		return bean;
	}

	public ListBeans getListBeans() {
		return listBeans;
	}

	public void setListBeans(ListBeans listBeans) {
		this.listBeans = listBeans;
	}

	public ListBeans getListGroup() {
		return listGroup;
	}

	public void setListGroup(ListBeans listGroup) {
		this.listGroup = listGroup;
	}
}
