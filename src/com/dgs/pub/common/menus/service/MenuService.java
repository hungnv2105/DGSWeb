package com.dgs.pub.common.menus.service;

import com.dgs.dao.DGException;
import com.dgs.object.OBean;
import com.dgs.object.ResponseObj;
import com.dgs.pub.common.menus.dao.DMenu;
import com.dgs.pub.common.menus.object.MenuPrmObject;
import com.dgs.pub.inf.IMenu;
import com.dgs.service.BaseService;

public class MenuService extends BaseService {

	@Override
	public ResponseObj process(OBean bean) throws DGException {
		DMenu dao = new DMenu();
		ResponseObj responseObj = new ResponseObj();
		try {
			startTransaction();
			if (bean.getProcessId() == IMenu.GET_LIST_BEANS) {
				responseObj.setListResponse(dao.getListScreen(this.connection, (MenuPrmObject)bean));
			}else if (bean.getProcessId() == IMenu.GET_LIST_LEVEL) {
				responseObj.setListResponse(dao.getListScreenByLevel(this.connection, (MenuPrmObject)bean));
			}
			endTransaction();
		} catch (DGException e) {
			rollBackTransaction();
			logger.info(e);
		} finally {
			releaseConnection();
		}
		return responseObj;
	}

}
