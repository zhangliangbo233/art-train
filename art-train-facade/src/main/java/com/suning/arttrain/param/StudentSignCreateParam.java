package com.suning.arttrain.param;

import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.MatchPattern;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.constraint.Range;



/**
 * 学员报名信息参数
 * @author zhanglb
 *
 */
public class StudentSignCreateParam extends AbstractParam{
	
	private long signId;
	
	private long studentId;
	
	@NotNull(message="姓名必须填写")
	@Length(min=1,max=6,message="姓名长度为1-6个字符")
	@MatchPattern(message="姓名不能包含特殊字符", pattern = "[^@#$%&(){}<>]{0,}")
	private String name;
	
	@NotNull(message="年龄必须填写")
	@Range(min=1,max=100,message="年龄为1-100的整数")
	@MatchPattern(pattern="^\\+?[1-9][0-9]*$",message="年龄为1-100的整数")
	private int age;
	
	/**
	 * 出生日期
	 */
	@NotNull(message="出生年月必须填写")
	private String birthday;
	
	private String address;
	
	/**
	 * 联系人
	 */
	@NotNull(message="联系人必须填写")
	@Length(min=1,max=6,message="联系人长度为1-6个字符")
	@MatchPattern(message="联系人不能包含特殊字符", pattern = "[^@#$%&(){}<>]{0,}")
	private String contactPerson;
	
	@NotNull(message="联系人电话必须填写")
	@Length(min=11,max=11,message="联系人电话为11位的手机号码")
	@MatchPattern(pattern="^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$",message="联系人手机号码填写不正确")
	private String contactMobile;
	
	/**
	 * 就读学校
	 */
	private String school;
	
	/**
	 * 年级
	 */
	private String grade;
	
	/**
	 * 报名费用
	 */
	@NotNull(message="报名费用必须填写")
	@MatchPattern(pattern={"^\\+?[1-9][0-9]*$"},message="报名费用必须为正整数")
	private int signExpense;

    /**
     * 报名课程id
     */
    private Long signCourseId;
	
	/**
	 * 报名课程名称
	 */
	@NotNull(message="报名课程必须填写")
	private String signCourseName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBirthday() {
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getSignExpense() {
		return signExpense;
	}

	public void setSignExpense(int signExpense) {
		this.signExpense = signExpense;
	}

	public String getSignCourseName() {
		return signCourseName;
	}

	public void setSignCourseName(String signCourseName) {
		this.signCourseName = signCourseName;
	}

	public long getSignId() {
		return signId;
	}

	public void setSignId(long signId) {
		this.signId = signId;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

    public Long getSignCourseId() {
        return signCourseId;
    }

    public void setSignCourseId(Long signCourseId) {
        this.signCourseId = signCourseId;
    }
}
