package com.dgs.dao;

import java.sql.SQLException;

public class DGException extends Exception {

	/**
	 * Author : hungnv
	 */
	private static final long serialVersionUID = 278461720984878629L;
	String location = this.getClass().getName();
	
	public DGException() {
		super();
	}
	
	public DGException(String message) {
		super(message);
	}
	
	public DGException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public DGException(SQLException sqlEx) {
		super(sqlEx.getMessage());
	}
	
	public DGException(SQLException sqlEx, String message) {
		super(message + " : " + sqlEx.getMessage());
	}
	
	public DGException(DGException dgEx) {
		super(dgEx.getMessage());
	}
	
	public DGException(DGException dgEx, String message) {
		super(message + " : " + dgEx.getMessage());
	}
	
	public DGException(ClassNotFoundException cnfEx) {
		super(cnfEx.getMessage());
	}
	
	public DGException(ClassNotFoundException cnfEx, String message) {
		super(cnfEx.getMessage() + " : " + message);
	}
	
	public DGException(Exception ex) {
		super(ex.getMessage());
	}
	
	public DGException(Exception ex, String message) {
		super(ex.getMessage() + " : " + message);
	}
}
