package com.suning.arttrain.param;




/**
 * 课程信息参数
 * @author zhanglb
 *
 */
public class CourseListParam extends AbstractParam{
	
	private String courseName;
	
	private String startCourseTime;
	
	private String endCourseTime;
	
	private String teacherName;
	
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

    public String getStartCourseTime() {
        return startCourseTime;
    }

    public void setStartCourseTime(String startCourseTime) {
        this.startCourseTime = startCourseTime;
    }

    public String getEndCourseTime() {
        return endCourseTime;
    }

    public void setEndCourseTime(String endCourseTime) {
        this.endCourseTime = endCourseTime;
    }
}
