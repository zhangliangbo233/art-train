package com.suning.arttrain.param;

/**
 * 学员报名列表信息参数
 * @author zhanglb
 *
 */
public class StudentListParam extends AbstractParam{

    /**
     * 查询开始时间
     */
	private String startTime;


    /**
     * 查询结束时间
     */
    private String endTime;

    /**
     * 学生姓名
     */
    private String studentName;

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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
