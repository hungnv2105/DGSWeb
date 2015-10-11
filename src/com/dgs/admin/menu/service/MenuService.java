package com.dgs.admin.menu.service;

import java.util.List;

import com.dgs.admin.menu.dao.DMenu;
import com.dgs.dao.DGException;
import com.dgs.object.ListBeans;
import com.dgs.object.OBean;
import com.dgs.service.BaseService;

public class MenuService extends BaseService {
	private DMenu dao = new DMenu();
	@Override
	public ListBeans getListBeans(OBean bean) throws DGException {
		ListBeans listBeans = null;
		try {
			this.startTransaction();
			if (bean.getProcessId() == 1) {
				listBeans = dao.getListMenu(connection, bean);
			}
			this.endTransaction();
		} catch (DGException e) {
			this.rollBackTransaction();
		} finally {
			this.releaseConnection();
		}
		return listBeans;
	}
	
	@Override
	public OBean getBeanInfo(OBean bean) throws DGException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void doProcess(OBean bean) throws DGException {
		// TODO Auto-generated method stub
		
	}

	public ListBeans getListMenu(OBean bean) {
		// TODO Auto-generated method stub
		return null;
	}

}
