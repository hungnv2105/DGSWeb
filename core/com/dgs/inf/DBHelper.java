package com.dgs.inf;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dgs.dao.DGException;

public interface DBHelper {
	
	public final static String CONFIG_FILE_NAME = "config/dbconfig.properties";
	
	public Connection getConnection() throws DGException;
	public void pushConnection(Connection conn) throws DGException;
	public void release() throws DGException;
	public void releaseConnection(Connection conn, PreparedStatement prstm) throws DGException;
	public void releaseConnection(Connection conn, PreparedStatement prstm, ResultSet rs) throws DGException;
	public void releaseConnection(Connection conn, CallableStatement cs, ResultSet rs) throws DGException;
	public void startTransaction(Connection conn) throws DGException;
	public void endTransaction(Connection conn) throws DGException;
	public void rollbackTransaction(Connection conn) throws DGException;
}
