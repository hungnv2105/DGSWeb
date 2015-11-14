package com.dgs.admin.product.service;

import com.dgs.admin.inf.IKeyProcess;
import com.dgs.admin.product.dao.DProduct;
import com.dgs.dao.DGException;
import com.dgs.object.OBean;
import com.dgs.object.ResponseObj;
import com.dgs.service.BaseService;

public class ProductService extends BaseService{
	private DProduct dao = new DProduct();
	private ResponseObj responseObj = new ResponseObj();
	@Override
	public ResponseObj process(OBean bean) throws DGException {
		try {
			startTransaction();
			if (bean.getProcessId() == IKeyProcess.GET_LIST_GROUP) {
				responseObj.setListResponse(dao.getListGroupProduct(this.connection));
			} else if (bean.getProcessId() == IKeyProcess.GET_LIST_STATUS) {
				responseObj.setListResponse(dao.getListProductStatus(this.connection));
			} else if (bean.getProcessId() == IKeyProcess.GET_LIST_BEANS) {
				responseObj.setListResponse(dao.getListProduct(this.connection, null));
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
