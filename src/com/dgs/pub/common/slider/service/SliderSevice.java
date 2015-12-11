package com.dgs.pub.common.slider.service;

import com.dgs.dao.DGException;
import com.dgs.object.OBean;
import com.dgs.object.ResponseObj;
import com.dgs.pub.common.slider.dao.DSlider;
import com.dgs.pub.common.slider.object.SliderPrmObject;
import com.dgs.pub.inf.IKeyProcess;
import com.dgs.service.BaseService;

public class SliderSevice extends BaseService {

	@Override
	public ResponseObj process(OBean bean) throws DGException {
		DSlider dao = new DSlider();
		ResponseObj responseObj = new ResponseObj();
		try {
			startTransaction();
			if (bean.getProcessId() == IKeyProcess.GET_LIST_BEANS) {
				responseObj.setListResponse(dao.getListSlider(this.connection));
			}else if (bean.getProcessId() == IKeyProcess.GET_PATH_ADVERTISE) {
				responseObj.setListResponse(dao.getPathSlider(this.connection, (SliderPrmObject)bean));
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
