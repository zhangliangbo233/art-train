package com.suning.arttrain.param;




/**
 * 老师列表信息参数
 * @author zhanglb
 *
 */
public class TeacherInfoListParam extends AbstractParam{
	
	private String startTime;
	
	private String endTime;
	
	private String teacherName;
	
	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
