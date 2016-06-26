package com.suning.arttrain.persistent;


import java.util.Date;

/**
 * 老师基本信息实体
 * @author zhanglb
 *
 */
public class TeacherInfo {

	private long id;
	
	private String  name;
	
	private Integer age;
	
	/**
	 * 联系手机
	 */
	private String contactMobile;
	
	/**
	 * 入职时间
	 */
	private Date assumeTime;
	
	
	/**
	 * 工资
	 */
	private int salary;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public String getContactMobile() {
		return contactMobile;
	}


	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}


	public Date getAssumeTime() {
		return assumeTime;
	}


	public void setAssumeTime(Date assumeTime) {
		this.assumeTime = assumeTime;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}
