package com.asop.jf.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.asop.jf.util.JsonUtil;



public class BaseController {

	protected HttpServletRequest request; 
	 protected HttpServletResponse response;  
     protected HttpSession session;  
     
 	
       
     @ModelAttribute  
     public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){  
         this.request = request;  
         this.response = response;  
         this.session = request.getSession();  
     }  
	
	protected void calculateMsg(Object msg) {
		
		String content=JsonUtil.objectToJson(msg);
		response.setContentType("text/html; charset=utf-8");
    	ServletOutputStream sos=null;
		try {
			sos = response.getOutputStream();
    		sos.write(content.getBytes("utf-8"));
    	} catch (IOException ee){
    	}finally{
    		if(sos!=null)
				try {
					sos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
    		
    	}
		
	}
	
protected void calculateMsg2(Object msg) {
		
		String content=JsonUtil.objectToJson2(msg);
		response.setContentType("text/html; charset=utf-8");
    	ServletOutputStream sos=null;
		try {
			sos = response.getOutputStream();
    		sos.write(content.getBytes("utf-8"));
    	} catch (IOException ee){
    	}finally{
    		if(sos!=null)
				try {
					sos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
    		
    	}
		
	}
	
	protected void calculateMsg(String content) {
		
		response.setContentType("text/html; charset=utf-8");
    	ServletOutputStream sos=null;
		try {
			sos = response.getOutputStream();
    		sos.write(content.getBytes("utf-8"));
    	} catch (IOException ee){
    	}finally{
    		if(sos!=null)
				try {
					sos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
    		
    	}
		
	}
	
	protected void calculateMg_1(String msg) {
		
		//String content=JsonUtil.objectToJson(msg);
		response.setContentType("text/html; charset=utf-8");
    	ServletOutputStream sos=null;
		try {
			sos = response.getOutputStream();
    		sos.write(msg.getBytes("utf-8"));
    	} catch (IOException ee){
    	}finally{
    		if(sos!=null)
				try {
					sos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
    		
    	}
		
	}
	
	private void buildJsonpResult(String msg){
		try {
			String jsonpResponse = request.getParameter("jsonpCallback")+"("+msg+")";
			response.setContentType("text/plain;charset=utf-8");
			response.getWriter().println(jsonpResponse);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void buildReonseNumResult(String msg){
		try {
			System.out.println("httpcliet请求");
			response.getWriter().print(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
