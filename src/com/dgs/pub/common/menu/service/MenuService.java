package com.dgs.pub.common.menu.service;

import com.dgs.pub.common.menu.dao.DMenu;
import com.dgs.pub.inf.IKeyProcess;
import com.dgs.dao.DGException;
import com.dgs.object.OBean;
import com.dgs.object.ResponseObj;
import com.dgs.service.BaseService;

public class MenuService extends BaseService {

	@Override
	public ResponseObj process(OBean bean) throws DGException {
		DMenu dao = new DMenu();
		ResponseObj responseObj = new ResponseObj();
		try {
			startTransaction();
			if (bean.getProcessId() == IKeyProcess.GET_LIST_BEANS) {
				responseObj.setListResponse(dao.getListScreen(this.connection));
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
