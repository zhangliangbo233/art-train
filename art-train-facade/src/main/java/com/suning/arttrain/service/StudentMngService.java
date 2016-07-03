package com.suning.arttrain.service;

import com.googlecode.jsonrpc4j.JsonRpcService;
import com.suning.arttrain.dto.StudentSignView;
import com.suning.arttrain.param.StudentListParam;
import com.suning.arttrain.param.StudentSignCreateParam;
import com.suning.arttrain.persistent.StudentInfo;

import java.util.List;

@JsonRpcService("StudentMngService.json")
public interface StudentMngService {

	int countStudentSignInfos(String startTime, String endTime, String studentName);

    /**
     * 返回插入的主键
     * @param studentInfo
     * @return
     */
	long addStudentInfo(StudentInfo studentInfo);

	List<StudentInfo> listStudentInfos(StudentListParam listParam);

	void saveStudentSign(StudentSignCreateParam signParam);

	void deleteStudentSign(Long id);

	StudentSignView loadSignWithStuInfoById(Long id);

    /**
     * 查询即将过期的学员信息
     * @return
     */
    List<StudentSignView> listExpireStudentsInfos();

}
