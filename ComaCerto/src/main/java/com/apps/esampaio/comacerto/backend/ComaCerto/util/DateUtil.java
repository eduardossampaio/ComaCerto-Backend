package com.apps.esampaio.comacerto.backend.ComaCerto.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static Date hourForFormat(String date) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
		return dateFormat.parse(date);
	}
	
	public static Date dateForFormat(String date) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.parse(date);
	}
}
