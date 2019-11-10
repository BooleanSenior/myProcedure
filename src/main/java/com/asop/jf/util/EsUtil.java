package com.asop.jf.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.commons.lang.StringUtils;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

public class EsUtil {

	public static TransportClient getClient() throws UnknownHostException{
		Settings settings = Settings.builder()
				.put("cluster.name", PropertiUtil.getProperty("escluster.name"))
				.put("client.transport.sniff", true)//自动嗅探
				.build();
		
		TransportClient client = new PreBuiltTransportClient(settings);
		String eshost=PropertiUtil.getProperty("eshost");
		if(!StringUtils.isEmpty(eshost)){
			String[] eshosts=eshost.split(",");
			for(String host:eshosts){
				client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), 9300));
			}
		}else{
			client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
		}
				
		return client;
	}
}
