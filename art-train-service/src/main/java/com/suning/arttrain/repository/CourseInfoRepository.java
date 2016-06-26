package com.suning.arttrain.repository;

import com.suning.arttrain.persistent.CourseInfo;

import java.util.List;
import java.util.Map;

@MyBatisRepository("courseInfoRepository")
public interface CourseInfoRepository {

	public CourseInfo loadCourseInfo(Long id);
	
	public void addCourseInfo(CourseInfo courseInfo);
	
	public void updateCourseInfo(CourseInfo courseInfo);

	public List<CourseInfo> listCourseInfos(Map<String, Object> param);

	public int countCourseInfos(Map<String, Object> param);

	public void deleteCourseInfoById(long id);

    List<CourseInfo> queryCourseInfos();
}
