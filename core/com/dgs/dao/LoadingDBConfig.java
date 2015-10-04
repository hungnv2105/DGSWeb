package com.dgs.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.dgs.inf.IConstants;
import com.dgs.inf.IErrorCode;

public class LoadingDBConfig {

	protected String driver;
	protected String dbType;
	protected String host;
	protected String port;
	protected String dbName;
	protected String dbUser;
	protected String dbPass;
	protected int MAX_CONNECTIONS;
	protected int INI_CONNECTIONS;
	protected int CONNECTION_TIME_OUT;

	static final Logger LOGGER = Logger.getLogger(LoadingDBConfig.class);

	public void loadDBConfig(String filename) {

		Properties prop = new Properties();
		InputStream inStream = null;
		if (filename != null) {
			inStream = getClass().getClassLoader()
					.getResourceAsStream(filename);

			if (inStream == null) {
				LOGGER.info(IErrorCode.ERROR_FILE_NOT_FOUND_CODE + " : "
						+ IErrorCode.ERROR_FILE_NOT_FOUND_DESC + " " + filename);
				return;
			}
		} else {
			LOGGER.info(IErrorCode.ERROR_PARAM_NULL_CODE + " : filename "
					+ IErrorCode.ERROR_PARAM_NULL_DESC);
			return;
		}

		// load file
		try {
			prop.load(inStream);
			Enumeration<?> e = prop.propertyNames();
			while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				if (key.equals(IConstants.DATABASE_TYPE)) {
					this.dbType = prop.getProperty(key);
				}
				if (key.equals(IConstants.DATABASE_NAME)) {
					this.dbName = prop.getProperty(key);
				}
				if (key.equals(IConstants.DATABASE_HOST)) {
					this.host = prop.getProperty(key);
				}
				if (key.equals(IConstants.DATABASE_PORT)) {
					this.port = prop.getProperty(key);
				}
				if (key.equals(IConstants.DATABASE_USER)) {
					this.dbUser = prop.getProperty(key);
				}
				if (key.equals(IConstants.DATABASE_PASS)) {
					this.dbPass = prop.getProperty(key);
				}
				if (key.equals(IConstants.DRIVER)) {
					this.driver = prop.getProperty(key);
				}
				if (key.equals(IConstants.MAX_CONNECTIONS)) {
					this.driver = prop.getProperty(key);
				}
				if (key.equals(IConstants.INI_CONNECTIONS)) {
					this.driver = prop.getProperty(key);
				}
				if (key.equals(IConstants.CONNECTION_TIME_OUT)) {
					this.driver = prop.getProperty(key);
				}
			}
			
			System.out.println("load success: driver = " + this.driver);

		} catch (IOException e) {
			LOGGER.error(e.toString());
		}

	}

}
