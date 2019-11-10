package com.asop.jf.util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AgeUtil {

	
	public static int calAge(String dataOfBirth,String format){
		int  age=0;
		try {
            //此处是获得的年龄
            age = getAge(parse(dataOfBirth,format));           //由出生日期获得年龄***
        } catch (Exception e) {
            e.printStackTrace();
        }

		return  age;
	}
	  public static int getAgeByIdCard(String idCard) {
	        int iAge = 0;
	        Calendar cal = Calendar.getInstance();
	        String year = idCard.substring(6, 10);
	        String mm1 = idCard.substring(10,12);       //出生的月份
	        String dd1 = idCard.substring(12,14);         //出生的日期
	        iAge=calAge(year+mm1+dd1, "yyyyMMdd");
//	        int iCurrYear = cal.get(Calendar.YEAR);
//	        iAge = iCurrYear - Integer.valueOf(year);
	        return iAge;
	    }

	//dd-MM-yyyy
	   public  static Date parse(String strDate,String format) throws ParseException{
	        SimpleDateFormat sdf = new SimpleDateFormat(format);
	        return sdf.parse(strDate);
	    }

	    //由出生日期获得年龄
	    public static int getAge(Date birthDay) throws Exception {
	        Calendar cal = Calendar.getInstance();

	        if (cal.before(birthDay)) {
	            throw new IllegalArgumentException(
	                    "The birthDay is before Now.It's unbelievable!");
	        }
	        int yearNow = cal.get(Calendar.YEAR);
	        int monthNow = cal.get(Calendar.MONTH);
	        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
	        cal.setTime(birthDay);

	        int yearBirth = cal.get(Calendar.YEAR);
	        int monthBirth = cal.get(Calendar.MONTH);
	        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

	        int age = yearNow - yearBirth;

	        if (monthNow <= monthBirth) {
	            if (monthNow == monthBirth) {
	                if (dayOfMonthNow < dayOfMonthBirth) age--;
	            }else{
	                age--;
	            }
	        }
	        return age;
	    }
//	    public static void main(String[] args) {
//	    	int age=calAge("1986-05-30");
//	    	System.out.println(age);
//		}
	    
	    
    public static String calPercent(long num1,long num2){
        // 创建一个数值格式化对象  
		  if(num1==0&&num2==0){
			 return "0%";
		  }
        NumberFormat numberFormat = NumberFormat.getInstance();  
        // 设置精确到小数点后2位  
        numberFormat.setMaximumFractionDigits(2);  
        String result = numberFormat.format((float) num1 / (float) num2 * 100);  
        return result+"%";
    }
    
    public static void main(String[] args) {
    	int age=getAgeByIdCard("130121198602301042");
    	System.out.println(age);
	}
}
