package com.dgs.pub.menu.action;

import com.dgs.dao.DGException;
import com.dgs.object.ListBeans;
import com.dgs.pub.inf.IKeyProcess;
import com.dgs.pub.menu.object.MenuObject;
import com.dgs.pub.menu.service.MenuService;

public class AMenu {
	private ListBeans listBiean;

	public ListBeans getListBiean() {
		MenuService menuService = new MenuService();
		MenuObject bean = new MenuObject();
		bean.setProcessId(IKeyProcess.GET_LIST_BEANS);
		try {
			listBiean = menuService.process(bean).getListResponse();
		} catch (DGException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listBiean;
	}
	
}
