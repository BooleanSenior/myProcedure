package com.asop.jf.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil1 {

	/**
	 * 
	 * @param posturl(http://localhost:8287/qjweb/zb/zbSaveAction.action)
	 * @param postparam 参数是以key:value
	 */
	public static String post(String posturl,String postparam){
		String msg=null;
		
		 try {
			DefaultHttpClient httpclient = new DefaultHttpClient();
			 HttpPost httpPost = new HttpPost(posturl);
			    List <NameValuePair> nvps = new ArrayList <NameValuePair>();
			    
			   String[] params=postparam.split(",");
			   for(String s:params){
				   String[] kvs=s.split(":");
				   String val="";
				   if(kvs.length==2){
					   val=kvs[1];
				   }
				   nvps.add(new BasicNameValuePair(kvs[0], val));
			   }
			    
			    httpPost.setEntity(new UrlEncodedFormEntity(nvps));
			    HttpResponse response2 = httpclient.execute(httpPost);

			    try {
			        System.out.println(response2.getStatusLine());
			        HttpEntity entity2 = response2.getEntity();
			        msg= EntityUtils.toString(entity2);
			        EntityUtils.consume(entity2);
			    } finally {
			        httpPost.releaseConnection();
			        httpclient.getConnectionManager().shutdown();
			    }
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}
	
	/**
	 * get请求
	 * @param url
	 * @return
	 */
	public static String httpGet(String url){
		 String msg=null;
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpGet get=new HttpGet(url);
		try {
			HttpResponse  response=httpclient.execute(get);
			int state=response.getStatusLine().getStatusCode();
			if(state>=200&&state<=300){
				HttpEntity entity = response.getEntity();
		        msg= EntityUtils.toString(entity,"utf-8");
		        EntityUtils.consume(entity);
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}
	
	/**
	 * 发送json请求
	 * @param url
	 * @param jsonMsg
	 * @return
	 */
	public static String httpPostJson(String url,String jsonMsg){
		 String rspMsg=null;
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		httpPost.addHeader("Content_Type","application/json");
		StringEntity entity=new StringEntity(jsonMsg, ContentType.create("application/json", "utf-8"));
		httpPost.setEntity(entity);
		try {
			HttpResponse response=	httpclient.execute(httpPost);
			int state=response.getStatusLine().getStatusCode();
			if(state>=200&&state<=300){
				HttpEntity responseEntity = response.getEntity();
			    rspMsg= EntityUtils.toString(responseEntity);
			    EntityUtils.consume(responseEntity);
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rspMsg;
	}
	
	public static String receivePost(HttpServletRequest request) throws IOException, UnsupportedEncodingException {
        
        // 读取请求内容
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(),"utf-8"));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while((line = br.readLine())!=null){
            sb.append(line);
            System.out.println(sb+"原本");
        }

        // 将资料解码
        String reqBody = sb.toString();
        System.out.println(reqBody+"解码");
        System.out.println(URLDecoder.decode(reqBody, HTTP.UTF_8)+"转码");
        return URLDecoder.decode(reqBody, HTTP.UTF_8);
    }
	
}
