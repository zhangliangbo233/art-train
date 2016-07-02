package com.suning.arttrain.dto;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.text.ParseException;
import java.util.Date;


/**
 * 学员报名信息
 * @author zhanglb
 *
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class StudentSignView {

	private long id;
	
	private long  studentId;
	
	private int age;
	
	private String birthday;
	
	private String address;
	
	private String studentName;
	
	/**
	 * 报名时间
	 */
	private String signTime;
	
	/**
	 * 报名费用
	 */
	private int signExpense;
	
	/**
	 * 报名课程id
	 */
	private long signCourseId;
	
	/**
	 * 报名课程名称
	 */
	private String signCourseName;
	
	private String school;
	
	private String level;
	
	/**
	 * 联系人
	 */
	private String contactPerson;
	
	private String contactMobile;
	
	/**
	 * 是否删除 0:否 1：是
	 */
	private int isDelete;

    /**
     * 到期日期
     */
    private Date endTime;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getSignTime() throws ParseException{
		return signTime;
	}

	public void setSignTime(String signTime) {
		this.signTime = signTime;
	}

	public int getSignExpense() {
		return signExpense;
	}

	public void setSignExpense(int signExpense) {
		this.signExpense = signExpense;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public long getSignCourseId() {
		return signCourseId;
	}

	public void setSignCourseId(long signCourseId) {
		this.signCourseId = signCourseId;
	}

	public String getSignCourseName() {
		return signCourseName;
	}

	public void setSignCourseName(String signCourseName) {
		this.signCourseName = signCourseName;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactMobile() {
		return contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBirthday() throws ParseException {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
