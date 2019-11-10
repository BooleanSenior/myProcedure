package com.asop.jf.db.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name= "Test_Make_Date")
public class MyTable {

	private String id;
	private String name;
	private String age;
	private String sex;
	private String whcd;
	private String jyzk;
	private String hjaddress;
	private String schk;
	private String firstdate;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "uuid")    
	@GenericGenerator(name = "uuid", strategy = "uuid") 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getWhcd() {
		return whcd;
	}
	public void setWhcd(String whcd) {
		this.whcd = whcd;
	}
	public String getJyzk() {
		return jyzk;
	}
	public void setJyzk(String jyzk) {
		this.jyzk = jyzk;
	}
	public String getHjaddress() {
		return hjaddress;
	}
	public void setHjaddress(String hjaddress) {
		this.hjaddress = hjaddress;
	}
	public String getSchk() {
		return schk;
	}
	public void setSchk(String schk) {
		this.schk = schk;
	}
	public String getFirstdate() {
		return firstdate;
	}
	public void setFirstdate(String firstdate) {
		this.firstdate = firstdate;
	}
	
	
}
