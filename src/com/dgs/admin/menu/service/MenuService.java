package com.dgs.admin.menu.service;

import java.util.List;

import com.dgs.admin.menu.dao.DMenu;
import com.dgs.admin.menu.object.MenuObject;
import com.dgs.dao.DGException;
import com.dgs.service.BaseService;

public class MenuService extends BaseService {
	private DMenu dao = new DMenu();
	public List<MenuObject> getListMenu() throws DGException {
		List<MenuObject> listMenu = null;
		try {
			this.startTransaction();
			listMenu = dao.getListMenu(connection);
			this.endTransaction();
		} catch (DGException e) {
			this.rollBackTransaction();
		} finally {
			this.releaseConnection();
		}
		return listMenu;
	}

}
