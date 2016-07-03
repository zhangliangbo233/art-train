package com.suning.arttrain.repository;

import com.suning.arttrain.dto.StudentSignView;
import com.suning.arttrain.persistent.StudentInfo;
import com.suning.arttrain.persistent.StudentSign;

import java.util.List;
import java.util.Map;

@MyBatisRepository("studentSignMsgRepository")
public interface StudentSignMsgRepository {

	public StudentSign loadStudentSignById(long id);
	
	public void addStudentSign(StudentSign studentSign);
	
	public void updateStudentSign(StudentSign studentSign);

	public List<StudentSignView> listStudentSignInfos(Map<String, Object> param);

	public int countStudentSignInfos(Map<String, Object> param);

	public StudentSignView loadSignWithStuInfoById(Map<String, Object> param);

    List<StudentSignView> listExpireStudentsInfos();

}
