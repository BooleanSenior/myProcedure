package com.asop.jf.db.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name= "SMZ_BYS")

public class SmzBys {

	private String id;
	private String rdzxzqmName;
	private String syszdqm;
	private String syszdqmName;
	private String userid;
	private String firstdate;
	private String lastdate;
	private String xm;
	private String sex;
	private String birthday;
	private String idcode;
	private String cjzh;
	private String cjlb;
	private String cjdj;
	private String mz;
	private String whcd;
	private String address;
	private String tel;
	private String hkszd;
	private String jyzk;
	private String hjaddress;
	private String schk;
	private String school;
	private String telphone;
	private String subject;
	private String xljyb;
	private String state;
	private String jybname;
	private String tby;
	private String remark;
	private String delFlag;
	private String getType;
	private String imppxpkid;
	private String code;
	private String year;
	private String localid;
	
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
	
	@Column(name = "GET_TYPE")
	public String getGetType() {
		return getType;
	}
	public void setGetType(String getType) {
		this.getType = getType;
	}
	@Column(name = "rdzxzqm_name")
	public String getRdzxzqmName() {
		return rdzxzqmName;
	}
	public void setRdzxzqmName(String rdzxzqmName) {
		this.rdzxzqmName = rdzxzqmName;
	}
	public String getSyszdqm() {
		return syszdqm;
	}
	public void setSyszdqm(String syszdqm) {
		this.syszdqm = syszdqm;
	}
	
	@Column(name = "syszdqm_name")
	public String getSyszdqmName() {
		return syszdqmName;
	}
	public void setSyszdqmName(String syszdqmName) {
		this.syszdqmName = syszdqmName;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getFirstdate() {
		return firstdate;
	}
	public void setFirstdate(String firstdate) {
		this.firstdate = firstdate;
	}
	public String getLastdate() {
		return lastdate;
	}
	public void setLastdate(String lastdate) {
		this.lastdate = lastdate;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getIdcode() {
		return idcode;
	}
	public void setIdcode(String idcode) {
		this.idcode = idcode;
	}
	public String getCjzh() {
		return cjzh;
	}
	public void setCjzh(String cjzh) {
		this.cjzh = cjzh;
	}
	public String getCjlb() {
		return cjlb;
	}
	public void setCjlb(String cjlb) {
		this.cjlb = cjlb;
	}
	public String getCjdj() {
		return cjdj;
	}
	public void setCjdj(String cjdj) {
		this.cjdj = cjdj;
	}
	public String getMz() {
		return mz;
	}
	public void setMz(String mz) {
		this.mz = mz;
	}
	public String getWhcd() {
		return whcd;
	}
	public void setWhcd(String whcd) {
		this.whcd = whcd;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getHkszd() {
		return hkszd;
	}
	public void setHkszd(String hkszd) {
		this.hkszd = hkszd;
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
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getXljyb() {
		return xljyb;
	}
	public void setXljyb(String xljyb) {
		this.xljyb = xljyb;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getJybname() {
		return jybname;
	}
	public void setJybname(String jybname) {
		this.jybname = jybname;
	}
	public String getTby() {
		return tby;
	}
	public void setTby(String tby) {
		this.tby = tby;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name = "del_flag")
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getImppxpkid() {
		return imppxpkid;
	}
	public void setImppxpkid(String imppxpkid) {
		this.imppxpkid = imppxpkid;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getLocalid() {
		return localid;
	}
	public void setLocalid(String localid) {
		this.localid = localid;
	}
	
}
