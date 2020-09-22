package com.business.cybord.utils;

import java.util.Calendar;
import java.util.Date;

public final class DateHelper {
	public static Date getMidnight(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
	    c.set(Calendar.SECOND, 59);
	    c.set(Calendar.MILLISECOND, 0);
	    return c.getTime();
	}
}
