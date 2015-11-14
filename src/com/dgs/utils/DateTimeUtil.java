package com.dgs.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
	public static String dateToString(Date date) {
		return dateToString(date, "dd/mm/yyyy");
	}

	public static Date stringToDate(String date) {
		return stringToDate(date, "dd/mm/yyyy");
	}

	public static java.sql.Date stringToSqlDate(String date) {
		return null;

	}

	public static java.sql.Date toSqlDate(Date date) {
		return null;

	}

	public static String dateToString(Date date, String pattern) {
		String result = "";
		if (date != null) {
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			result = df.format(date);
		}
		return result;
	}

	public static Date stringToDate(String date, String pattern) {
		Date result = null;
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		try {
			result = df.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		finally {}
		return result;
	}
}
