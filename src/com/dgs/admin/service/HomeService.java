package com.dgs.admin.service;

import com.dgs.admin.dao.HomeDAO;
import com.dgs.dao.DGException;
import com.dgs.object.OBean;
import com.dgs.object.RespMesg;
import com.dgs.service.BaseService;

public class HomeService extends BaseService {
	
	HomeDAO dao = new HomeDAO();
	
	@Override
	public RespMesg process(OBean bean) throws DGException {
		RespMesg resp = new RespMesg();
		startTransaction();
		try {
			if (bean.getProcessId() == GET_LIST_BEANS) {
				resp.setJsonObject(dao.getAllMenus(bean, this.connection));
			}
		} catch (Exception ex) {
			rollBackTransaction();
		}
		endTransaction();
		return resp;
	}

}
