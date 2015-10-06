package com.dgs.inf;

public interface IErrorCode {
	// Errors Code
	public static final String ERROR_FILE_NOT_FOUND_CODE = "ERDGS-404";
	public static final String ERROR_PARAM_NULL_CODE = "ERDGS-000";
	public static final String ERROR_PARAMS_TYPE_CODE = "ERDGS-001";
	public static final String FAIL_CONNECTION_CODE = "ERDGS-002";
	public static final String NULL_CALLABLE_CODE = "ERDGS-003";
	
	// Errors Description
	public static final String ERROR_FILE_NOT_FOUND_DESC = "-> Sorry, unable to find";
	public static final String ERROR_PARAM_NULL_DESC = "-> Param is null";
	public static final String ERROR_PARAMS_TYPE_DESC = "-> Wrong type set prarams for PrepareStatement";
	public static final String FAIL_CONNECTION_DESC = "-> Connection is null or closed";
	public static final String NULL_CALLABLE_DESC = "-> CallableStatement is null";
}
