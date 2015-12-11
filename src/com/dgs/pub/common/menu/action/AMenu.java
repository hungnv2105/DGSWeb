package com.dgs.pub.common.menu.action;

import com.dgs.dao.DGException;
import com.dgs.object.ListBeans;
import com.dgs.pub.common.menu.object.MenuPrmObject;
import com.dgs.pub.common.menu.service.MenuService;
import com.dgs.pub.inf.IKeyProcess;

public class AMenu {
	private MenuService menuService = new MenuService();
	
	public ListBeans getListMenuSideBarByLeve(int level) {
		return getListMenu(level, IKeyProcess.MENU_PUBLIC_SIDEBAR_TYPE);
	}
	
	public ListBeans getListMenuSideBarByLeve(int group, int level) {
		return getListMenu(group, level, IKeyProcess.MENU_PUBLIC_SIDEBAR_TYPE);
	}
	
	public ListBeans getListMenuTopByLeve(int level) {
		return getListMenu(level, IKeyProcess.MENU_PUBLIC_TOP_TYPE);
	}
	
	public ListBeans getListMenuTopByLevel(int group, int level) {
		return getListMenu(group, level, IKeyProcess.MENU_PUBLIC_TOP_TYPE);
	}
	
	public ListBeans getListMenu(int level, int type) {
		MenuPrmObject bean = new MenuPrmObject();
		bean.setProcessId(IKeyProcess.MENU_LIST_LEVEL);
		bean.setLevel(level);
		bean.setType(type);
		return getListMenu(bean);
	}

	public ListBeans getListMenu(int group, int level, int type) {
		MenuPrmObject bean = new MenuPrmObject();
		bean.setProcessId(IKeyProcess.GET_LIST_BEANS);
		bean.setGroup(group);
		bean.setLevel(level);
		bean.setType(type);
		return getListMenu(bean);
	}
	
	private ListBeans getListMenu(MenuPrmObject bean) {
		ListBeans listBiean = null;
		try {
			listBiean = menuService.process(bean).getListResponse();
		} catch (DGException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listBiean;
	}
	
}
