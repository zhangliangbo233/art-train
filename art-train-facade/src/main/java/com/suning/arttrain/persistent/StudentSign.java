package com.suning.arttrain.persistent;

import java.util.Date;

/**
 * 学员报名信息
 * @author zhanglb
 *
 */
public class StudentSign {

	private long id;
	
	private long  studentId;
	
	private String studentName;
	
	/**
	 * 报名时间
	 */
	private Date signTime;
	
	/**
	 * 报名费用
	 */
	private int signExpense;
	
	/**
	 * 报名课程id
	 */
	private Long signCourseId;
	
	/**
	 * 报名课程名称
	 */
	private String signCourseName;
	
	/**
	 * 是否删除 0:否 1：是
	 */
	private int isDelete;

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

	public Date getSignTime(){
		return signTime;
	}

	public void setSignTime(Date signTime) {
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

	public Long getSignCourseId() {
		return signCourseId;
	}

	public void setSignCourseId(Long signCourseId) {
		this.signCourseId = signCourseId;
	}

	public String getSignCourseName() {
		return signCourseName;
	}

	public void setSignCourseName(String signCourseName) {
		this.signCourseName = signCourseName;
	}


}
