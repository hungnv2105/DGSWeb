package com.dgs.admin.user.service;

import com.dgs.admin.inf.IKeyProcess;
import com.dgs.admin.user.dao.DUser;
import com.dgs.dao.DGException;
import com.dgs.object.OBean;
import com.dgs.object.ResponseObj;
import com.dgs.service.BaseService;

public class UserService extends BaseService {
	private DUser dao = new DUser();
	private ResponseObj responseObj = new ResponseObj();
	
	@Override
	public ResponseObj process(OBean bean) throws DGException {
		try {
			startTransaction();
			if(bean.getProcessId() == IKeyProcess.GET_LIST_BEANS) {
				responseObj.setListResponse(dao.getListUsers(this.connection, bean));
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
