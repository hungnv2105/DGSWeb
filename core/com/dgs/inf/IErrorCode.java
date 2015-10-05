package com.dgs.inf;

public interface IErrorCode {
	// Errors Code
	public static final String ERROR_FILE_NOT_FOUND_CODE = "ERDGS-404";
	public static final String ERROR_PARAM_NULL_CODE = "ERDGS-000";
	public static final String ERROR_PARAMS_TYPE_CODE = "ERDGS-001";
	
	// Errors Description
	public static final String ERROR_FILE_NOT_FOUND_DESC = "Sorry, unable to find";
	public static final String ERROR_PARAM_NULL_DESC = "param is null";
	public static final String ERROR_PARAMS_TYPE_DESC = "Wrong type set prarams for PrepareStatement";
}
