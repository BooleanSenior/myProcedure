package com.asop.jf.db.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asop.jf.db.dao.MyTableDao;
import com.asop.jf.db.pojo.MyTable;


@Service
@Transactional
public class MyTableService {
	 Logger logger=Logger.getLogger(MyTableService.class);
		@Autowired
		private MyTableDao myTableDao;
		
		public void saveMytable(){
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		
			MyTable myTable = new MyTable();
			myTable.setName("张三");
			myTable.setAge("22");
			myTable.setSex("1");
			myTable.setFirstdate(df.format(new Date()));
			myTableDao.saveMytable(myTable);
		}
}
