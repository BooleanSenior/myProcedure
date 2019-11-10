package com.asop.jf.db.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.asop.dao.BaseDao;
import com.asop.jf.db.pojo.MyTable;

@Repository("MyTableDao")
public class MyTableDao extends BaseDao<MyTable>{
	Logger loger=Logger.getLogger(MyTableDao.class);
	

	public void saveMytable(MyTable myTable){
		this.saveOrUpdateEntity(myTable);
	}
}
