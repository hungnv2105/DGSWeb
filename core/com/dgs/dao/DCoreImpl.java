/**
 * 
 */
package com.dgs.dao;

import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map.Entry;

import com.dgs.inf.DCore;
import com.dgs.inf.IErrorCode;

/**
 * @author hungnv
 *
 */
public abstract class DCoreImpl implements DCore {

	private final String location = this.getClass().getName();

	@Override
	public PreparedStatement preparedStatement(Connection conn, String query, HashMap<Integer, Object> prstmParams)
			throws DGException {
		return preparedStatement(conn, query, prstmParams, true);
	}

	public PreparedStatement preparedStatement(Connection conn, String query, HashMap<Integer, Object> prstmParams,
			boolean srcollResultSet) throws DGException {
		String errorInf = this.location + "->preparedStatement";
		PreparedStatement prstm = null;
		try {
			if (conn != null && !conn.isClosed()) {
				if (srcollResultSet) {
					prstm = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
				} else {
					prstm = conn.prepareStatement(query);
				}
				setPraramsForSQLStatement(prstm, prstmParams);
			}
		} catch (SQLException sqlEx) {
			throw new DGException(sqlEx, errorInf);
		}
		return prstm;
	}

	@Override
	public int executeUpdate(Connection conn, String query) throws DGException {
		return executeUpdate(conn, query, null);
	}

	@Override
	public int executeUpdate(Connection conn, String query, HashMap<Integer, Object> prstmParams) throws DGException {
		String errorInf = this.location + "->executeUpdate";
		int result = 0;
		PreparedStatement prstm = preparedStatement(conn, query, prstmParams);
		try {
			result = prstm.executeUpdate();
		} catch (SQLException sqlEx) {
			throw new DGException(sqlEx, errorInf);
		}
		return result;
	}

	@Override
	public ResultSet executeQuery(PreparedStatement prstm) throws DGException {
		String errorInf = this.location + "->executeQuery";
		ResultSet rs = null;
		if (prstm != null) {
			try {
				rs = prstm.executeQuery();
			} catch (SQLException sqlEx) {
				throw new DGException(sqlEx, errorInf);
			}
		}
		return rs;
	}

	@Override
	public ResultSet executeQuery(Connection conn, String query, HashMap<Integer, Object> prstmParams)
			throws DGException {
		String errorInf = this.location + "->executeQuery";
		ResultSet rs = null;
		PreparedStatement prstm = preparedStatement(conn, query, prstmParams);
		try {
			rs = prstm.executeQuery();
		} catch (SQLException sqlEx) {
			throw new DGException(sqlEx, errorInf);
		}
		return rs;
	}

	@Override
	public ResultSet executeSP(Connection conn, String callableStatement, HashMap<Integer, Object> prstmParams)
			throws DGException {
		String errorInf = this.location + " -> executeSP";
		ResultSet rs = null; 
		try {
			if (conn != null && !conn.isClosed()) {
				if (callableStatement != null && callableStatement.length() > 0) {
					String stmCall = " ? {" + callableStatement + "}";
					CallableStatement cs = conn.prepareCall(stmCall);
					setPraramsForSQLStatement(cs, prstmParams);
					if (cs != null) {
						rs = cs.executeQuery();
					} else {
						throw new DGException(errorInf + " : " + IErrorCode.NULL_CALLABLE_CODE
								+ IErrorCode.NULL_CALLABLE_DESC);
					}
				} else {
					throw new DGException(errorInf + " : " + IErrorCode.FAIL_CONNECTION_CODE
							+ IErrorCode.FAIL_CONNECTION_DESC);
				}
			} else {
				throw new DGException(errorInf + " Connection is null or closed!");
			}
		} catch (SQLException sqlEx) {
			throw new DGException(sqlEx, errorInf);
		}
		return rs;
	}
	
	private void setPraramsForSQLStatement(PreparedStatement prstm, HashMap<Integer, Object> prstmParams) throws DGException, SQLException {
		String errorInf = this.location + " -> setPraramsForSQLStatement";
		if (prstm != null) {
			if (prstmParams != null && prstmParams.size() > 0) {
				int i = 0;
				for (Entry<Integer, Object> e : prstmParams.entrySet()) {
					if (e.getKey() == Types.INTEGER) {
						prstm.setInt(++i, (int) e.getValue());
					} else if (e.getKey() == Types.BIGINT) {
						prstm.setLong(++i, (long) e.getValue());
					} else if (e.getKey() == Types.FLOAT) {
						prstm.setFloat(++i, (float) e.getValue());
					} else if (e.getKey() == Types.DOUBLE) {
						prstm.setDouble(++i, (double) e.getValue());
					} else if (e.getKey() == Types.VARCHAR || e.getKey() == Types.NVARCHAR
							|| e.getKey() == Types.LONGVARCHAR || e.getKey() == Types.LONGNVARCHAR) {
						prstm.setString(++i, (String) e.getValue());
					} else if (e.getKey() == Types.DATE) {
						prstm.setDate(++i, (Date) e.getValue());
					} else if (e.getKey() == Types.BOOLEAN) {
						prstm.setFloat(++i, (float) e.getValue());
					} else if (e.getKey() == Types.CLOB) {
						prstm.setClob(++i, (Clob) e.getValue());
					} else if (e.getKey() == Types.BLOB) {
						prstm.setBlob(++i, (Blob) e.getValue());
					} else if (e.getKey() == Types.NCLOB) {
						prstm.setClob(++i, (Clob) e.getValue());
					} else {
						throw new DGException(errorInf + " : " + IErrorCode.ERROR_PARAMS_TYPE_CODE
								+ IErrorCode.ERROR_PARAMS_TYPE_DESC);
					}

				}
			}
		}
	}
	
	@Override
	public void releaseResultSet(ResultSet rs) {
		if (rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				rs = null;
			}
		}
	}
}
