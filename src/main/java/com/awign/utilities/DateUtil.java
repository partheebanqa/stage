package com.awign.utilities;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class DateUtil {

	
	
	public String getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy_HH_mm_ss");
	    Calendar cal =  Calendar.getInstance();
	    cal.add( Calendar.DATE, -0);
	    return sdf.format(cal.getTime());
	   
	}
	
	public String getcurrentTime() {
		LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
       return current.format(formatter);

	}
	
			
}

//Cmd:    mvn clean verify -Dtags="one" serenity:aggregate