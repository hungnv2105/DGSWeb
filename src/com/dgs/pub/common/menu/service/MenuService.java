package com.dgs.pub.common.menu.service;

import com.dgs.dao.DGException;
import com.dgs.object.OBean;
import com.dgs.object.ResponseObj;
import com.dgs.pub.common.menu.dao.DMenu;
import com.dgs.pub.common.menu.object.MenuPrmObject;
import com.dgs.pub.inf.IKeyProcess;
import com.dgs.service.BaseService;

public class MenuService extends BaseService {

	@Override
	public ResponseObj process(OBean bean) throws DGException {
		DMenu dao = new DMenu();
		ResponseObj responseObj = new ResponseObj();
		try {
			startTransaction();
			if (bean.getProcessId() == IKeyProcess.GET_LIST_BEANS) {
				responseObj.setListResponse(dao.getListScreen(this.connection, (MenuPrmObject)bean));
			}else if (bean.getProcessId() == IKeyProcess.MENU_LIST_LEVEL) {
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
