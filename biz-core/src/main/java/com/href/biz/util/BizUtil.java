package com.href.biz.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BizUtil {
	
	final static Logger logger = LoggerFactory.getLogger(BizUtil.class);
	
	/****
	 * Util Fn: to convert string in date format to @link Date
	 * @param dateInString
	 * @return
	 */
	public static Date convertStringToDate(String dateInString){
		logger.info("Util fn: 'convertStringToDate' invoked . ");
		 DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		 Date date=null;
		 try {
		        date = df.parse(dateInString);
		    } catch (ParseException e) {
		        logger.error("Error in date conversion", e);
		    }
		 logger.info("Exit fn:.");
		 return date;
		
	}

	
}
