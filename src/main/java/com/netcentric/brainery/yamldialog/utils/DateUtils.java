package com.netcentric.brainery.yamldialog.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

	public static boolean isDate(String str, String format) {
		if (!Utils.isEmpty(str)) {
			try {
				SimpleDateFormat formatter = new SimpleDateFormat(format);
				formatter.setLenient(false);
				formatter.parse(str);
				return true;
			} catch (ParseException e) {
			}
		}
		return false;
	}

	public static Date toDate(String str, String format) throws ParseException {
		return new SimpleDateFormat(format).parse(str);
	}

	public static boolean greaterThan(String mindate, String maxdate, String format) {
		if (!Utils.isEmpty(mindate) && !Utils.isEmpty(maxdate)) {
			try {
				Date min = toDate(mindate, format);
				Date max = toDate(maxdate, format);
				return min.after(max);
			} catch (ParseException e) {
			}
		}
		return false;
	}

	public static boolean isDateFormat(String format) {
		try {
			new SimpleDateFormat(format);
			return true;
		} catch (IllegalArgumentException e) {
		}
		return false;
	}
}
