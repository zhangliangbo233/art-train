package com.suning.arttrain.persistent;


import java.util.Date;

/**
 * 课程信息实体
 * @author zhanglb
 *
 */
public class CourseInfo {

	private long id;

    private String  courseName;

	/**
	 * 开课时间
	 */
	private Date beginTime;

    /**
     * 课程天数
     */
    private int totalDays;

    /**
     * 结束时间
     */
    private Date endTime;

	/**
	 * 授课老师id
	 */
	private Long teacherId;

	/**
	 * 授课老师姓名
	 */
	private String teacherName;

	/**
	 * 课程价格
	 */
	private int price;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Date getBeginTime(){
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
