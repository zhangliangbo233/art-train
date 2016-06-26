package com.suning.arttrain.service;

import com.googlecode.jsonrpc4j.JsonRpcService;
import com.suning.arttrain.common.exception.ParamsValidatorException;
import com.suning.arttrain.dto.StudentSignView;
import com.suning.arttrain.param.StudentSignCreateParam;
import com.suning.arttrain.param.StudentSignListParam;
import com.suning.arttrain.persistent.StudentInfo;
import com.suning.arttrain.persistent.StudentSign;

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

	public void saveStudentSign(StudentSignCreateParam signParam) throws ParamsValidatorException;

	public void deleteStudentSign(Long id);

	public StudentSignView loadSignWithStuInfoById(Long id) throws ParamsValidatorException;

    /**
     * 查询即将过期的学员信息
     * @return
     */
    List<StudentSignView> listExpireStudentsInfos();
}
