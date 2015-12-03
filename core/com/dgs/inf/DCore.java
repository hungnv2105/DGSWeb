package com.dgs.inf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.dgs.dao.DGException;
import com.dgs.object.ListBeans;

public interface DCore {
	
	public PreparedStatement preparedStatement(Connection conn, String query, List<Object> prstmParams) throws DGException;
	public int executeUpdate(Connection conn, String query) throws DGException;
	public int executeUpdate(Connection conn, String query, List<Object> prstmParams) throws DGException;
	public ResultSet executeQuery(PreparedStatement prstm) throws DGException;
	public ResultSet executeQuery(Connection conn, String query, List<Object> prstmParams) throws DGException;
	public ResultSet executeSP(Connection conn, String callableStatement, List<Object> prstmParams) throws DGException;
	public ListBeans getObjectInfo(ResultSet rs) throws DGException;
	public void releaseResultSet(ResultSet rs);
}
