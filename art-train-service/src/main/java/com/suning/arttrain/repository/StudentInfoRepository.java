package com.suning.arttrain.repository;

import java.util.List;
import java.util.Map;

import com.suning.arttrain.dto.StudentSignView;
import com.suning.arttrain.persistent.StudentInfo;
import com.suning.arttrain.persistent.StudentSign;

@MyBatisRepository("studentInfoRepository")
public interface StudentInfoRepository {

	public long addStudentInfo(StudentInfo studentInfo);
	
	public StudentInfo loadStudentInfo(long id);
	
	public void updateStudentInfo(StudentInfo studentInfo);
}
