package com.business.cybord.utils;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DateHelper {

	public Date setMidNigthDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}
	
	public Date addOneDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 1);
		return cal.getTime();
	}
}
