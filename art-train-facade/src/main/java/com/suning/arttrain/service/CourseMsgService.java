package com.suning.arttrain.service;

import com.googlecode.jsonrpc4j.JsonRpcService;
import com.suning.arttrain.exception.ParamValidateException;
import com.suning.arttrain.param.CourseCreateParam;
import com.suning.arttrain.param.CourseListParam;
import com.suning.arttrain.persistent.CourseInfo;

import java.util.List;

@JsonRpcService("/CourseMsgService.json")
public interface CourseMsgService {

	public int countCourseInfos(CourseListParam listParam);

	public void addCourseInfo(CourseInfo course);

	public List<CourseInfo> listCourseInfos(CourseListParam listParam);

	public void saveCourseInfo(CourseCreateParam courseParam) throws ParamValidateException;

	public void deleteCourseInfo(Long id) throws ParamValidateException;

	public CourseInfo loadCourseInfoById(Long id) throws ParamValidateException;

    public List<CourseInfo> queryCourseInfos();

}
