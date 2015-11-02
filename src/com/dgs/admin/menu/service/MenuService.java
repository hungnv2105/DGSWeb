package com.dgs.admin.menu.service;

import com.dgs.admin.menu.dao.DMenu;
import com.dgs.dao.DGException;
import com.dgs.object.ListBeans;
import com.dgs.service.BaseService;

public class MenuService extends BaseService {
	private DMenu dao = new DMenu();

	public ListBeans getListGroupScreen() throws DGException{
		ListBeans list = new ListBeans();
		try {
			startTransaction();
			list = dao.getListGroupScreen(this.connection);
			endTransaction();
		} catch (DGException e) {
			rollBackTransaction();
			logger.info(e);
		} finally {
			releaseConnection();
		}
		return list;
	}

	public ListBeans getListScreen() throws DGException {
		ListBeans list = new ListBeans();
		try {
			startTransaction();
			list = dao.getListScreen(this.connection);
			endTransaction();
		} catch (DGException e) {
			rollBackTransaction();
			logger.info(e);
		} finally {
			releaseConnection();
		}
		return list;
	}

	public ListBeans getListUsers() throws DGException {
		ListBeans list = new ListBeans();
		try {
			startTransaction();
			list = dao.getListUsers(this.connection);
			endTransaction();
		} catch (DGException e) {
			rollBackTransaction();
			logger.info(e);
		} finally {
			releaseConnection();
		}
		return list;
	}

}
