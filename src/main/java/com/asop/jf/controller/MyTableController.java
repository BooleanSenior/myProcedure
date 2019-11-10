package com.asop.jf.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.asop.jf.db.pojo.MyTable;
import com.asop.jf.db.service.MyTableService;


@Controller	
//@Scope("prototype")
@RequestMapping(value ="/test")
public class MyTableController extends BaseController{
@Autowired
private MyTableService myTableService;
	
	@RequestMapping(value="/saveMytable")
	public String  saveMytable() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String msg="1";
		MyTable data = new MyTable();
		data.setName("张三");
		data.setAge("22");
		data.setSex("1");
		data.setFirstdate(df.format(new Date()));
	//	myTableService.saveMytable(data);
		 calculateMsg(msg);
			return null;	
	}
	
	@RequestMapping(value="/test")
	public String  test() {
		
		 calculateMsg("111");
			return null;	
	}
}
