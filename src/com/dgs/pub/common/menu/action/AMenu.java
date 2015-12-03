package com.dgs.pub.common.menu.action;

import com.dgs.dao.DGException;
import com.dgs.object.ListBeans;
import com.dgs.pub.common.menu.object.MenuPrmObject;
import com.dgs.pub.common.menu.service.MenuService;
import com.dgs.pub.inf.IMenu;

public class AMenu {
	private ListBeans listBiean;
	
	public ListBeans getListMenuTop(int group, int level) {
		return getListMenu(group, level, IMenu.PUBLIC_TOP_TYPE);
	}

	public ListBeans getListMenu(int group, int level, int type) {
		MenuService menuService = new MenuService();
		MenuPrmObject bean = new MenuPrmObject();
		bean.setProcessId(IMenu.GET_LIST_BEANS);
		bean.setGroup(group);
		bean.setLevel(level);
		bean.setType(type);
		try {
			listBiean = menuService.process(bean).getListResponse();
		} catch (DGException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listBiean;
	}
	
}
