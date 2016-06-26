package com.suning.arttrain.service;

import com.googlecode.jsonrpc4j.JsonRpcService;
import com.suning.arttrain.common.exception.ParamsValidatorException;
import com.suning.arttrain.param.CourseCreateParam;
import com.suning.arttrain.param.CourseListParam;
import com.suning.arttrain.persistent.CourseInfo;

import java.util.List;

@JsonRpcService("/CourseMsgService.json")
public interface CourseMsgService {

	public int countCourseInfos(CourseListParam listParam);

	public void addCourseInfo(CourseInfo course);

	public List<CourseInfo> listCourseInfos(CourseListParam listParam);

	public void saveCourseInfo(CourseCreateParam courseParam) throws ParamsValidatorException;

	public void deleteCourseInfo(Long id) throws ParamsValidatorException;

	public CourseInfo loadCourseInfoById(Long id) throws ParamsValidatorException;

    public List<CourseInfo> queryCourseInfos();

}
