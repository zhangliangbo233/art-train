package com.suning.arttrain.repository;

import java.util.List;
import java.util.Map;

import com.suning.arttrain.persistent.TeacherInfo;

@MyBatisRepository("teacherInfoRepository")
public interface TeacherInfoRepository {

	public TeacherInfo loadTeacherInfo(long id);
	
	public void addTeacherInfo(TeacherInfo teacherInfo);
	
	public void updateTeacherInfo(TeacherInfo teacherInfo);

	public List<TeacherInfo> listTeacherInfos(Map<String, Object> param);

	public int countTeacherInfos(Map<String, Object> param);

	public void deleteTeacherInfoById(long id);

    public List<TeacherInfo> queryTeacherInfos();
}
