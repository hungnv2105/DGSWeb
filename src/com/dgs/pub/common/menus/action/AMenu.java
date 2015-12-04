package com.dgs.pub.common.menus.action;

import com.dgs.dao.DGException;
import com.dgs.object.ListBeans;
import com.dgs.pub.common.menus.object.MenuPrmObject;
import com.dgs.pub.common.menus.service.MenuService;
import com.dgs.pub.inf.IMenu;

public class AMenu {
	private ListBeans listBiean;
	
	public ListBeans getListMenuTopByLeve(int level) {
		return getListMenu(level, IMenu.PUBLIC_TOP_TYPE);
	}
	
	public ListBeans getListMenuTopByLevel(int group, int level) {
		return getListMenu(group, level, IMenu.PUBLIC_TOP_TYPE);
	}
	
	public ListBeans getListMenu(int level, int type) {
		MenuPrmObject bean = new MenuPrmObject();
		bean.setProcessId(IMenu.GET_LIST_LEVEL);
		bean.setLevel(level);
		bean.setType(type);
		return getListMenu(bean);
	}

	public ListBeans getListMenu(int group, int level, int type) {
		MenuPrmObject bean = new MenuPrmObject();
		bean.setProcessId(IMenu.GET_LIST_BEANS);
		bean.setGroup(group);
		bean.setLevel(level);
		bean.setType(type);
		return getListMenu(bean);
	}
	
	private ListBeans getListMenu(MenuPrmObject bean) {
		MenuService menuService = new MenuService();
		try {
			listBiean = menuService.process(bean).getListResponse();
		} catch (DGException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listBiean;
	}
	
}
