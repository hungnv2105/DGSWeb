package com.dgs.inf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.dgs.dao.DGException;

public interface DCore {
	
	public PreparedStatement preparedStatement(Connection conn, String query, List<?> prstmParams) throws DGException;
	public int executeUpdate(Connection conn, String query) throws DGException;
	public int executeUpdate(Connection conn, String query, List<?> prstmParams) throws DGException;
	public ResultSet executeQuery(PreparedStatement prstm) throws DGException;
	public ResultSet executeQuery(Connection conn, String query, List<?> prstmParams) throws DGException;
}
