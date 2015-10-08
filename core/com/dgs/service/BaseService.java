package com.dgs.service;

import java.sql.Connection;

import com.dgs.dao.DBHelperImpl;
import com.dgs.dao.DGException;
import com.dgs.inf.DBHelper;

public class BaseService {
	protected Connection connection;
	private DBHelper dbHelper = new DBHelperImpl();

	public void startTransaction() throws DGException {
		connection = dbHelper.getConnection();
		dbHelper.startTransaction(connection);
	}

	public void endTransaction() throws DGException {
		dbHelper.endTransaction(connection);
	}

	public void rollBackTransaction() throws DGException {
		dbHelper.rollbackTransaction(connection);
	}

	public void releaseConnection() throws DGException {
		dbHelper.pushConnection(connection);
	}

	public void releasePool() throws DGException {
		dbHelper.release();
	}

}
