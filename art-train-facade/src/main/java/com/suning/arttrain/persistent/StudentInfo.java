package com.suning.arttrain.persistent;


/**
 * 学员基本信息实体
 * @author zhanglb
 *
 */
public class StudentInfo {

	private long id;
	
	private String  name;
	
	private int age;
	
	/**
	 * 出生年月
	 */
	private String birthday;
	
	private String address;
	
	private String contactPerson;
	
	/**
	 * 联系人手机
	 */
	private String contactMobile;
	
	/**
	 * 就读学校
	 */
	private String school;
	
	/**
	 * 就读年级
	 */
	private String grade;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
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
}
