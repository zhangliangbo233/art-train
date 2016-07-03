package com.suning.arttrain.repository;

import com.suning.arttrain.persistent.CourseInfo;

import java.util.List;
import java.util.Map;

@MyBatisRepository("courseInfoRepository")
public interface CourseInfoRepository {

	CourseInfo loadCourseInfo(Long id);
	
	void addCourseInfo(CourseInfo courseInfo);
	
	void updateCourseInfo(CourseInfo courseInfo);

	List<CourseInfo> listCourseInfos(Map<String, Object> param);

	int countCourseInfos(Map<String, Object> param);

	void deleteCourseInfoById(long id);

    List<CourseInfo> queryCourseInfos();
}
