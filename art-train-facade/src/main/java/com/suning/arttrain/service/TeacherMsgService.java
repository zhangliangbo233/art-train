package com.suning.arttrain.service;

import com.googlecode.jsonrpc4j.JsonRpcService;
import com.suning.arttrain.param.TeacherInfoCreateParam;
import com.suning.arttrain.param.TeacherInfoListParam;
import com.suning.arttrain.persistent.TeacherInfo;

import java.util.List;

@JsonRpcService("TeacherMsgService.json")
public interface TeacherMsgService {

	int countTeacherInfos(TeacherInfoListParam listParam);

	void addTeacherInfo(TeacherInfo course);

	List<TeacherInfo> listTeacherInfos(TeacherInfoListParam listParam);

    List<TeacherInfo> queryTeacherInfos();

	void saveTeacherInfo(TeacherInfoCreateParam createParam);

	void deleteTeacherInfo(Long id);

	TeacherInfo loadTeacherInfoById(Long id);

}
