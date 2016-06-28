package com.suning.arttrain.service;

import com.googlecode.jsonrpc4j.JsonRpcService;
import com.suning.arttrain.dto.StudentSignView;
import com.suning.arttrain.exception.ParamValidateException;
import com.suning.arttrain.param.StudentSignCreateParam;
import com.suning.arttrain.param.StudentSignListParam;
import com.suning.arttrain.persistent.StudentInfo;

import java.util.List;

@JsonRpcService("StudentMsgService.json")
public interface StudentMsgService {

	public int countStudentSignInfos(String startTime, String endTime, String studentName);

    /**
     * 返回插入的主键
     * @param studentInfo
     * @return
     */
	public long addStudentInfo(StudentInfo studentInfo);

	public List<StudentSignView> listStudentSignInfos(StudentSignListParam listParam);

	public void saveStudentSign(StudentSignCreateParam signParam);

	public void deleteStudentSign(Long id);

	public StudentSignView loadSignWithStuInfoById(Long id);

    /**
     * 查询即将过期的学员信息
     * @return
     */
    List<StudentSignView> listExpireStudentsInfos();
}
