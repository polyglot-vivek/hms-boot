package com.nareshit.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServiceUtil {

	public static Date convertStringToDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat(ServiceConstants.HMS_PRO_DATE_FORMAT);
		Date hmsProdate = null;
		try {
			hmsProdate = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hmsProdate;
	}
	
	public static String convertDateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(ServiceConstants.HMS_PRO_DATE_FORMAT);
		String formattedDate = sdf.format(date);
		return formattedDate;
	}
	
	/*public static void main(String[] args) {
		String dateInString = convertDateToString(new Date());
		System.out.println("date in string is:\t"+dateInString);
		Date date = convertStringToDate(dateInString);
		System.out.println("converted date is:\t"+date);
		
	}*/
}
