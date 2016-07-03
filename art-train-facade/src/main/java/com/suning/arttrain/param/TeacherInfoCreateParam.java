package com.suning.arttrain.param;

import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.MatchPattern;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.constraint.Range;

import java.util.Date;


/**
 * 老师信息参数
 * @author zhanglb
 *
 */
public class TeacherInfoCreateParam extends AbstractParam{
	
	private long teacherInfoId;
	
	@NotNull(message="姓名必须填写")
	@Length(min=1,max=6,message="姓名长度为1-6个字符")
	@MatchPattern(message="姓名不能包含特殊字符", pattern = "[^@#$%&(){}<>]{0,}")
	private String name;
	
	@Range(min=1,max=100,message="年龄为1-100的整数")
	@MatchPattern(pattern="^\\+?[1-9][0-9]*$",message="年龄为1-100的整数")
	private Integer age;
	
	@NotNull(message="联系电话必须填写")
	@Length(min=11,max=11,message="联系电话为11位的手机号码")
	@MatchPattern(pattern="^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$",message="请输入正确的手机号码")
	private String contactMobile;
	
	/**
	 * 入职时间
	 */
	private Date assumeTime;
	
	/**
	 *  工资
	 */
	@NotNull(message="工资必须填写")
	@MatchPattern(pattern={"^\\+?[1-9][0-9]*$"},message="工资必须为正整数")
	@Range(min=1,max=10000,message="工资必须在1-10000之间")
	private int salary;

	public long getTeacherInfoId() {
		return teacherInfoId;
	}

	public void setTeacherInfoId(long teacherInfoId) {
		this.teacherInfoId = teacherInfoId;
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
