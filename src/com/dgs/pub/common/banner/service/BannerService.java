package com.dgs.pub.common.banner.service;

import com.dgs.dao.DGException;
import com.dgs.object.OBean;
import com.dgs.object.ResponseObj;
import com.dgs.pub.common.banner.dao.DBanner;
import com.dgs.pub.common.banner.object.BannerPrmObject;
import com.dgs.pub.inf.IKeyProcess;
import com.dgs.service.BaseService;

public class BannerService extends BaseService {
	@Override
	public ResponseObj process(OBean bean) throws DGException {
		DBanner dao = new DBanner();
		ResponseObj responseObj = new ResponseObj();
		try {
			startTransaction();
			if (bean.getProcessId() == IKeyProcess.GET_LIST_BEANS) {
				responseObj.setListResponse(dao.getListBanner(this.connection, (BannerPrmObject)bean));
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
