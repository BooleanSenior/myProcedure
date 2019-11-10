package com.asop.jf.job.dyupdate;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;




import com.asop.jf.db.service.MyTableService;

import com.asop.jf.init.SpringContextServlet;


public class IndexCountJob implements Runnable{
	 Logger logger=Logger.getLogger(IndexCountJob.class);
	volatile boolean   flag=true;
	
	public void run() {

			  long curTime=new Date().getTime();
			  logger.info("开始首页残疾人统计开始"+curTime);
			  execTop3Job();

	}
	/**
	 * 
	 * @return
	 */
	
	
/*	private synchronized ZyDept getLevel4One(){
		 Iterator<ZyDept> iter = depts4.iterator();
		 ZyDept zyDept=null;
	        if (iter.hasNext()) {
	        	zyDept = iter.next();
	            iter.remove();
	        }
	        logger.info("获取"+zyDept.getId());
	        return zyDept;
	}*/
	
	
	
	public void springQuzeJob(){ 
		  execTop3Job();
	}
	
	private void execTop3Job(){
		ExecutorService fixedThreadPool=Executors.newFixedThreadPool(2); 
	    Thread t2 = new Top3Thread();  
	    Thread t3=new Top3Thread();
		fixedThreadPool.execute(t2);
		fixedThreadPool.execute(t3);

	}
	
	class Top3Thread extends Thread {  
		  @Override  
		  public void run() {  
			  logger.info("定时任务开始标识"+flag);
			  MyTableService myTableService=(MyTableService)SpringContextServlet.getWc().getBean("myTableService");
			  myTableService.saveMytable();
		  }  
		} 

}



