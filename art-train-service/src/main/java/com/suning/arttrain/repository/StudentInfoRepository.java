package com.suning.arttrain.repository;

import java.util.List;
import java.util.Map;

import com.suning.arttrain.dto.StudentSignView;
import com.suning.arttrain.persistent.StudentInfo;
import com.suning.arttrain.persistent.StudentSign;

@MyBatisRepository("studentInfoRepository")
public interface StudentInfoRepository {

	long addStudentInfo(StudentInfo studentInfo);
	
	StudentInfo loadStudentInfo(long id);
	
	void updateStudentInfo(StudentInfo studentInfo);

	List<StudentInfo> listStudentInfos(Map<String, Object> param);
}
