package com.asop.jf.util;

import org.apache.log4j.Logger;

import com.asop.jf.init.SpringContextServlet;
import com.asop.jf.init.SpringLocal;

public class Log4jUtil {

    private static Logger logger=Logger.getLogger(Log4jUtil.class);  
    
    public static void info(Object message){
    	SpringLocal springLocal=(SpringLocal)SpringContextServlet.getWc().getBean("springLocal");
    	String logMark=springLocal.getLogMark();
    	if(logMark.equals("1")){
    		logger.info(message);
    	}
    }
    
    public static void debug(Object message){
    	SpringLocal springLocal=(SpringLocal)SpringContextServlet.getWc().getBean("springLocal");
    	String logMark=springLocal.getLogMark();
    	if(logMark.equals("1")){
    		logger.debug(message);
    	}
    }
    
    public static void error(Object message){
    	SpringLocal springLocal=(SpringLocal)SpringContextServlet.getWc().getBean("springLocal");
    	String logMark=springLocal.getLogMark();
    	if(logMark.equals("1")){
    		logger.error(message);
    	}
    }
}
