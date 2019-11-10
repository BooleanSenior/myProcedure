package com.asop.jf.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarUtil {

	public static String gainWeekDayName(Calendar cal){
		String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
		 int w = cal.get(Calendar.DAY_OF_WEEK)-1;
		 int year=cal.get(Calendar.YEAR);
		 int mon=cal.get(Calendar.MONTH)+1;
		 int day=cal.get(Calendar.DATE);
		 String name=weekDays[w];
		 //String name=weekDays[w]+":"+year+"-"+mon+"-"+day;
		
		 return name;
	}
	
	public static String gainDayName(Calendar cal){
		String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
		 int w = cal.get(Calendar.DAY_OF_WEEK)-1;
		 int year=cal.get(Calendar.YEAR);
		 int mon=cal.get(Calendar.MONTH)+1;
		 int day=cal.get(Calendar.DATE);
		
		String name=year+"-"+mon+"-"+day;
		
		 return name;
	}
	
	 /**
     * 计算2个日期相差多少年
     * 列：2011-02-02  ~  2017-03-02 大约相差 6.1 年
     * @param fromDate
     * @param toDate
     * @return
     */
    public static double yearCompare(String DATE1, String DATE2,String formatStr){
    	 double dif =0;
    	  DateFormat df = new SimpleDateFormat(formatStr);
    	  try{
	    	  Date fromDate = df.parse(DATE1);
	          Date toDate = df.parse(DATE2);
	          
	    	 Calendar  from  =  Calendar.getInstance();
	         from.setTime(fromDate);
	         Calendar  to  =  Calendar.getInstance();
	         to.setTime(toDate);
	
	         int fromYear = from.get(Calendar.YEAR);
	         int fromMonth = from.get(Calendar.MONTH);
	         int fromDay = from.get(Calendar.DAY_OF_MONTH);
	
	         int toYear = to.get(Calendar.YEAR);
	         int toMonth = to.get(Calendar.MONTH);
	         int toDay = to.get(Calendar.DAY_OF_MONTH);
	         int year = toYear  -  fromYear;
	         int month = toMonth  - fromMonth;
	         int day = toDay  - fromDay;
	         
	        double monthd = month;
	        double yeard =year;
	        //返回2位小数，并且四舍五入
	         dif=yeard + monthd / 12;
    	  }catch(Exception e){
    		  e.printStackTrace();
    	  }
        return dif;
    }
	
}

