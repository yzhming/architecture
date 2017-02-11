package com.sishuok.util.format;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateFormatHelper {

	private final static String Format_STR = "yyyy-MM-dd HH:mm:ss";

	private DateFormatHelper() {
	}

	public static String long2str(long time) {
		Date date = new Date(time);
		DateFormat df = new SimpleDateFormat(Format_STR);
		return df.format(date);
	}

	// public static long str2long(String str){
	// DateFormat df = new SimpleDateFormat(Format_STR);
	// return df.parse(str).getTime();
	// }
}
