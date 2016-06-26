package com.suning.arttrain.param;

import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.MatchPattern;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.constraint.Range;

import java.util.Date;


/**
 * 课程信息参数
 * @author zhanglb
 *
 */
public class CourseCreateParam extends AbstractParam{
	
	private long courseId;
	
	@NotNull(message="课程名称必须填写")
	@Length(min=1,max=6,message="课程名称长度为1-6个字符")
	@MatchPattern(message="课程名称不能包含特殊字符", pattern = "[^@#$%&(){}<>]{0,}")
	private String courseName;
	
	/**
	 *  课程价格
	 */
	@NotNull(message="课程价格必须填写")
	@MatchPattern(pattern={"^\\+?[1-9][0-9]*$"},message="课程价格必须为正整数")
	@Range(min=1,max=10000,message="课程价格必须在1-10000之间")
	private int price;
	
	/**
	 * 开课时间
	 */
	private Date beginTime;

    private Date endTime;

    @NotNull(message="课程天数必须填写")
    @MatchPattern(pattern={"^\\+?[1-9][0-9]*$"},message="课程天数必须为正整数")
    @Range(min=1,max=10000,message="课程天数必须在1-1000之间")
    private int totalDays;
	
	/**
	 * 联系人
	 */
	@NotNull(message="授课老师必须填写")
	@Length(min=1,max=6,message="授课老师长度为1-6个字符")
	@MatchPattern(message="授课老师不能包含特殊字符", pattern = "[^@#$%&(){}<>]{0,}")
	private String teacherName;

    @NotNull(message="teacherId必须填写")
    private Long teacherId;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }
}
