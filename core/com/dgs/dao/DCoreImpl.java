/**
 * 
 */
package com.dgs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.apache.log4j.Logger;

import com.dgs.inf.DCore;

/**
 * @author hungnv
 *
 */
public class DCoreImpl implements DCore {
	
	final static Logger LOGGER = Logger.getLogger(DCoreImpl.class);

	@Override
	public PreparedStatement preparedStatement(Connection conn, String query, List<?> prstmParams) throws DGException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int executeUpdate(Connection conn, String query) throws DGException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int executeUpdate(Connection conn, String query, List<?> prstmParams) throws DGException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultSet executeQuery(PreparedStatement prstm) throws DGException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet executeQuery(Connection conn, String query, List<?> prstmParams) throws DGException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
