/**
 * 
 */
package com.dgs.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import com.dgs.inf.DBHelper;

/**
 * @author hungnv
 *
 */
public class DBHelperImpl extends LoadingDBConfig implements DBHelper {

	final static Logger LOGGER = Logger.getLogger(DBHelperImpl.class);
	private static LinkedList<Connection> pool = new LinkedList<Connection>();
	private final static String CONFIG_FILE_NAME = DBHelper.CONFIG_FILE_NAME;
	private final String location = this.getClass().toString();

	public DBHelperImpl() {
		loadDBConfig(CONFIG_FILE_NAME);
		try {
			build(INI_CONNECTIONS);
		} catch (DGException e) {
			LOGGER.info(e.getMessage());
		}
	}

	@Override
	public Connection getConnection() throws DGException {
		Connection conn = null;
		String errorInf = this.location + "-> Error at getConnection";
		try {
			if (!pool.isEmpty()) {
				synchronized (pool) {
					conn = pool.removeFirst();
					LOGGER.info("Get connection from pool");
				}
			}
			if (conn == null) {
				conn = makeConnection();
				LOGGER.info("Make new connection");
			}

		} catch (DGException e) {
			throw new DGException(e, errorInf);
		}
		return conn;
	}

	@Override
	public void pushConnection(Connection conn) throws DGException {
		String errorInf = this.location + "-> Error at pushConnection";
		try {
			if (conn == null || conn.isClosed()) {
				LOGGER.info("Push connection: connection is null or closed");
				return;
			}
			if (pool.size() >= MAX_CONNECTIONS) {
				LOGGER.info("Push connection: pool is full");
				conn.close();
				return;
			}
		} catch (SQLException e) {
			throw new DGException(e, errorInf);
		}

		synchronized (pool) {
			pool.addLast(conn);
			pool.notify();
		}
	}

	@Override
	public void release() throws DGException {
		String errorInf = this.location + "->Error at release connection";
		LOGGER.info("Closing connections in pool...");
		synchronized (pool) {
			for (Iterator<Connection> iterator = pool.iterator(); iterator.hasNext();) {
				Connection conn = (Connection) iterator.next();
				try {
					conn.close();
				} catch (SQLException e) {
					throw new DGException(e, errorInf);
				}
			}
			pool.clear();
		}

		LOGGER.info("Release connection OK");

	}

	@Override
	public void releaseConnection(Connection conn, PreparedStatement prstm) throws DGException {
		String errorInf = this.location + "->Error at releaseConnection";
		try {
			if (prstm != null) {
				prstm.close();
			}
			pushConnection(conn);
		} catch (SQLException e) {
			throw new DGException(e, errorInf);
		}

	}

	@Override
	public void releaseConnection(Connection conn, PreparedStatement prstm, ResultSet rs) throws DGException {
		String errorInf = this.location + "->Error at releaseConnection";
		try {
			if (rs != null) {
				rs.close();
			}
			releaseConnection(conn, prstm);
		} catch (SQLException e) {
			throw new DGException(e, errorInf);
		}
	}

	@Override
	public void releaseConnection(Connection conn, CallableStatement cs, ResultSet rs) throws DGException {
		String errorInf = this.location + "->Error at releaseConnection";
		try {
			if (rs != null) {
				rs.close();
			}
			if (cs != null) {
				cs.close();
			}
			pushConnection(conn);
		} catch (SQLException e) {
			throw new DGException(e, errorInf);
		}

	}

	private void build(int number) throws DGException {
		LOGGER.info("Establishing " + number + " connections...");
		Connection conn = null;
		release();
		for (int i = 0; i < number; i++) {
			conn = makeConnection();
			pool.addLast(conn);
		}
		LOGGER.info("Number of connections have been init : " + pool.size());
	}

	private Connection makeConnection() throws DGException {
		String errorInf = this.location + "->Error at makeConnection";
		Connection conn = null;
		try {
			Class.forName(this.driver);
			StringBuilder sb = new StringBuilder();
			sb.append(this.dbType);
			sb.append("://");
			sb.append(this.host);
			sb.append("/");
			sb.append(this.dbName);
			sb.append("?user=");
			sb.append(this.dbUser);
			sb.append("&password=");
			sb.append(this.dbPass);
			conn = DriverManager.getConnection(sb.toString());
		} catch (ClassNotFoundException e) {
			throw new DGException(e, errorInf);
		} catch (Exception e) {
			throw new DGException(e, errorInf);
		}
		return conn;
	}

	@Override
	public synchronized void startTransaction(Connection conn) throws DGException {
		String errorInf = this.location + "->Error startTransaction";
		try {
			if (conn != null && conn.getAutoCommit()) {
				conn.setAutoCommit(false);
			}
		} catch (SQLException e) {
			throw new DGException(e, errorInf);
		}
	}

	@Override
	public synchronized void endTransaction(Connection conn) throws DGException {
		String errorInf = this.location + "->Error endTransaction";
		if (conn != null) {
			try {
				conn.commit();
			} catch (SQLException e) {
				throw new DGException(e, errorInf);
			}
		}
	}

	@Override
	public void rollbackTransaction(Connection conn) throws DGException {
		String errorInf = this.location + "->Error rollbackTransaction";
		try {
			if (conn != null && !conn.getAutoCommit()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			throw new DGException(e, errorInf);
		}

	}
}
