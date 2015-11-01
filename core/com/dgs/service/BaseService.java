package com.dgs.service;

import java.sql.Connection;

import org.apache.log4j.Logger;

import com.dgs.dao.DBHelperImpl;
import com.dgs.dao.DGException;
import com.dgs.inf.DBHelper;

public abstract class BaseService {
	protected Connection connection;
	protected Logger logger = Logger.getLogger(BaseService.class);
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

}
