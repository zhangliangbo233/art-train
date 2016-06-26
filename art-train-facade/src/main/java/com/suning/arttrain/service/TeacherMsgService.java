package com.suning.arttrain.service;

import com.googlecode.jsonrpc4j.JsonRpcService;
import com.suning.arttrain.common.exception.ParamsValidatorException;
import com.suning.arttrain.param.TeacherInfoCreateParam;
import com.suning.arttrain.param.TeacherInfoListParam;
import com.suning.arttrain.persistent.TeacherInfo;

import java.util.List;

@JsonRpcService("TeacherMsgService.json")
public interface TeacherMsgService {

	public int countTeacherInfos(TeacherInfoListParam listParam);

	public void addTeacherInfo(TeacherInfo course);

	public List<TeacherInfo> listTeacherInfos(TeacherInfoListParam listParam);

    public List<TeacherInfo> queryTeacherInfos();

	public void saveTeacherInfo(TeacherInfoCreateParam createParam) throws ParamsValidatorException;

	public void deleteTeacherInfo(Long id) throws ParamsValidatorException;

	public TeacherInfo loadTeacherInfoById(Long id) throws ParamsValidatorException;

}
