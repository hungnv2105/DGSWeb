package com.dgs.service;

import java.sql.Connection;

import com.dgs.dao.DBHelperImpl;
import com.dgs.dao.DGException;
import com.dgs.inf.DBHelper;
import com.dgs.object.ListBeans;
import com.dgs.object.OBean;

public abstract class BaseService {
	protected Connection connection;
	private DBHelper dbHelper = new DBHelperImpl();

	protected void startTransaction() throws DGException {
		connection = dbHelper.getConnection();
		dbHelper.startTransaction(connection);
	}

	protected void endTransaction() throws DGException {
		dbHelper.endTransaction(connection);
	}

	protected void rollBackTransaction() throws DGException {
		dbHelper.rollbackTransaction(connection);
	}

	protected void releaseConnection() throws DGException {
		dbHelper.pushConnection(connection);
	}

	protected void releasePool() throws DGException {
		dbHelper.release();
	}
	
	public abstract ListBeans getListBeans(OBean bean) throws DGException;
	
	public abstract OBean getBeanInfo(OBean bean) throws DGException;
	
	public abstract void doProcess(OBean bean) throws DGException;

}
