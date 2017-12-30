package cn.et.lesson05.xml;

import java.io.Serializable;


public class Student implements Serializable{
	private int sid;
	private String sname;
	private Integer sex;
	private Integer age;
	private String address;
	
	

	public Integer getAge() {
		return age;
	}

	

	public Integer getSex() {
		return sex;
	}



	public void setSex(Integer sex) {
		this.sex = sex;
	}



	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	
}
