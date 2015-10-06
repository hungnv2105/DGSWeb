package com.dgs.inf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import com.dgs.dao.DGException;

public interface DCore {
	
	public PreparedStatement preparedStatement(Connection conn, String query, HashMap<Integer, Object> prstmParams) throws DGException;
	public int executeUpdate(Connection conn, String query) throws DGException;
	public int executeUpdate(Connection conn, String query, HashMap<Integer, Object> prstmParams) throws DGException;
	public ResultSet executeQuery(PreparedStatement prstm) throws DGException;
	public ResultSet executeQuery(Connection conn, String query, HashMap<Integer, Object> prstmParams) throws DGException;
	public ResultSet executeSP(Connection conn, String callableStatement, HashMap<Integer, Object> prstmParams) throws DGException;
}
