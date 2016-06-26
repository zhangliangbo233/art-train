package com.suning.arttrain.service;

import com.suning.arttrain.common.exception.ParamsValidatorException;
import com.suning.arttrain.common.util.OvalUtil;
import com.suning.arttrain.param.CourseCreateParam;
import com.suning.arttrain.param.CourseListParam;
import com.suning.arttrain.persistent.CourseInfo;
import com.suning.arttrain.repository.CourseInfoRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("courseMsgService")
public class CourseMsgServiceImpl implements CourseMsgService {

	@Resource(name="courseInfoRepository")
	private CourseInfoRepository courseInfoRepository;
	
	@Override
	public int countCourseInfos(CourseListParam listParam) {
		Map<String,Object> param = getParam(listParam);
		
		return courseInfoRepository.countCourseInfos(param);
	}
	
	@Override
	public void addCourseInfo(CourseInfo courseInfo) {
        courseInfoRepository.addCourseInfo(courseInfo);
	}
	
	@Override
	public List<CourseInfo> listCourseInfos(CourseListParam listParam) {
		Map<String,Object> param = getParam(listParam);
		param.put("pageSize", listParam.getPg().getPageSize());
		param.put("pageIndex", listParam.getPg().getPageIndex());
		
		return courseInfoRepository.listCourseInfos(param);
	}
	
	/**
	 * 拼接查询参数
	 * @param listParam
	 * @return
	 */
	private Map<String,Object> getParam(CourseListParam listParam){
		Map<String,Object> param = new HashMap<String, Object>();
		if(null == listParam){
			return param;
		}
		if(StringUtils.isNotBlank(listParam.getStartCourseTime())){
			param.put("startCourseTime", listParam.getStartCourseTime());
		}
		if(StringUtils.isNotBlank(listParam.getEndCourseTime())){
			param.put("endCourseTime", listParam.getEndCourseTime());
		}
		if(StringUtils.isNotBlank(listParam.getCourseName())){
			param.put("courseName", listParam.getCourseName());
		}
		if(StringUtils.isNotBlank(listParam.getTeacherName())){
			param.put("teacherName", listParam.getTeacherName());
		}
		return param;
	}
	
	@Override
	@Transactional(rollbackFor=Throwable.class)
	public void saveCourseInfo(CourseCreateParam courseParam) throws ParamsValidatorException {
		
		OvalUtil.validate(courseParam);
		
		 CourseInfo courseOld = courseInfoRepository.loadCourseInfo(courseParam.getCourseId());
		
		if(courseOld != null){
            updateCourseInfo(courseParam,courseOld);
		}else{
            createCourseInfo(courseParam);
		}
	}
	
	/**
	 * update操作
	 */
	private void updateCourseInfo(CourseCreateParam courseParam,CourseInfo courseOld){
        Calendar cal = Calendar.getInstance();
        cal.setTime(courseParam.getBeginTime());
        cal.add(Calendar.DAY_OF_MONTH,courseParam.getTotalDays());
        courseParam.setEndTime(cal.getTime());

		BeanUtils.copyProperties(courseParam, courseOld);
		//update 学生信息
        courseInfoRepository.updateCourseInfo(courseOld);
	}
	
	/**
	 * create操作
	 */
	private void createCourseInfo(CourseCreateParam courseParam){
		CourseInfo course = new CourseInfo();

        Calendar cal = Calendar.getInstance();
        cal.setTime(courseParam.getBeginTime());
        cal.add(Calendar.DAY_OF_MONTH,courseParam.getTotalDays());
        courseParam.setEndTime(cal.getTime());
		BeanUtils.copyProperties(courseParam, course);

        courseInfoRepository.addCourseInfo(course);
	}
	
	@Override
	@Transactional(rollbackFor=Throwable.class)
	public void deleteCourseInfo(Long id) throws ParamsValidatorException {
		CourseInfo course = courseInfoRepository.loadCourseInfo(id);
		if(null == course){
			throw new ParamsValidatorException("信息不存在，请稍后重试！");
		}
        courseInfoRepository.deleteCourseInfoById(id);
	}
	
	@Override
	public CourseInfo loadCourseInfoById(Long id) throws ParamsValidatorException {
		CourseInfo view = courseInfoRepository.loadCourseInfo(id);
		if(null == view){
			throw new ParamsValidatorException("信息不存在，请稍后重试！");
		}
		return view;
	}

    @Override
    public List<CourseInfo> queryCourseInfos() {
        return courseInfoRepository.queryCourseInfos();
    }
}
