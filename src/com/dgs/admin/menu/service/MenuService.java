package com.dgs.admin.menu.service;

import com.dgs.admin.inf.IKeyProcess;
import com.dgs.admin.menu.dao.DMenu;
import com.dgs.dao.DGException;
import com.dgs.object.OBean;
import com.dgs.object.ResponseObj;
import com.dgs.service.BaseService;

public class MenuService extends BaseService {
	private DMenu dao = new DMenu();
	private ResponseObj responseObj = new ResponseObj();
	
	@Override
	public ResponseObj process(OBean bean) throws DGException {
		try {
			startTransaction();
			if (bean.getProcessId() == IKeyProcess.GET_LIST_BEANS) {
				responseObj.setListResponse(dao.getListScreen(this.connection));
			} else if (bean.getProcessId() == IKeyProcess.GET_LIST_GROUP) {
				responseObj.setListResponse(dao.getListGroupScreen(this.connection));
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
