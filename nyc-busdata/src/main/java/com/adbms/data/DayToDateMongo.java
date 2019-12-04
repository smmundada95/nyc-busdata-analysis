package com.adbms.data;

import java.util.ArrayList;
import java.util.List;

public class DayToDateMongo {
	
	//Returns a String of all dates corresponding to particular day
	public static List<String> getDateFromDay(String day){
		List<String> dates = new ArrayList<String>();
		
		if(day.equalsIgnoreCase("Thursday")) {
			dates.add("6/1/2017");
			dates.add("6/8/2017");
			dates.add("6/15/2017");
			dates.add("6/22/2017");
		}
		else if(day.equalsIgnoreCase("Friday")) {
			dates.add("6/2/2017");
			dates.add("6/9/2017");
			dates.add("6/16/2017");
			dates.add("6/23/2017");
		}
		else if(day.equalsIgnoreCase("Saturday")) {
			dates.add("6/3/2017");
			dates.add("6/10/2017");
			dates.add("6/17/2017");
			dates.add("6/24/2017");
		}
		else if(day.equalsIgnoreCase("Sunday")) {
			dates.add("6/4/2017");
			dates.add("6/11/2017");
			dates.add("6/18/2017");
			dates.add("6/25/2017");
		}
		else if(day.equalsIgnoreCase("Monday")) {
			dates.add("6/5/2017");
			dates.add("6/12/2017");
			dates.add("6/19/2017");
			dates.add("6/26/2017");
		}
		else if(day.equalsIgnoreCase("Tuesday")) {
			dates.add("6/6/2017");
			dates.add("6/13/2017");
			dates.add("6/20/2017");
			dates.add("6/27/2017");
		}	
		else if(day.equalsIgnoreCase("Wednesday")) {
			dates.add("2017-06-07");
			dates.add("2017-06-14");
			dates.add("2017-06-21");
			dates.add("2017-06-28");
		}
		
		
		return dates;
	}

}
