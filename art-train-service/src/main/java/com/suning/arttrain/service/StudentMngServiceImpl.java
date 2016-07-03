package com.suning.arttrain.service;

import com.suning.arttrain.common.util.DateUtil;
import com.suning.arttrain.constant.StudentStatusEnum;
import com.suning.arttrain.dto.StudentSignView;
import com.suning.arttrain.exception.ParamValidateException;
import com.suning.arttrain.param.StudentListParam;
import com.suning.arttrain.param.StudentSignCreateParam;
import com.suning.arttrain.persistent.StudentInfo;
import com.suning.arttrain.persistent.StudentSign;
import com.suning.arttrain.repository.StudentInfoRepository;
import com.suning.arttrain.repository.StudentSignMsgRepository;
import com.suning.arttrain.util.OvalUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("studentMngService")
public class StudentMngServiceImpl implements StudentMngService {

    @Resource(name="studentInfoRepository")
    private StudentInfoRepository studentInfoRepository;

    @Autowired
    private StudentSignMsgRepository studentSignMsgRepository;


    @Override
	public int countStudentSignInfos(String startTime, String endTime, String studentName) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("isDelete", 1);
		if(StringUtils.isNotBlank(startTime)){
			param.put("startTime", startTime);
		}
		if(StringUtils.isNotBlank(endTime)){
			param.put("endTime", endTime);
		}
		if(StringUtils.isNotBlank(studentName)){
			param.put("studentName", studentName);
		}
		return studentSignMsgRepository.countStudentSignInfos(param);
	}
	

	@Override
	public long addStudentInfo(StudentInfo studentInfo) {
		return studentInfoRepository.addStudentInfo(studentInfo);
	}
	
	@Override
	public List<StudentInfo> listStudentInfos(StudentListParam listParam) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("isDelete", StudentStatusEnum.NORMAL.getCode());
		if(StringUtils.isNotBlank(listParam.getStartTime())){
			param.put("startTime", listParam.getStartTime());
		}
		if(StringUtils.isNotBlank(listParam.getEndTime())){
			param.put("endTime", listParam.getEndTime());
		}
		if(StringUtils.isNotBlank(listParam.getStudentName())){
			param.put("studentName", listParam.getStudentName());
		}
		return studentInfoRepository.listStudentInfos(param);
	}
	
	@Override
	public void saveStudentSign(StudentSignCreateParam signParam) {
		
		OvalUtil.validate(signParam);
		
		StudentSign signOld = studentSignMsgRepository.loadStudentSignById(signParam.getSignId());
		
		if(signOld != null){
			updateStudentSign(signParam,signOld);
		}else{
			createStudentSign(signParam);
		}
	}
	
	/**
	 * update操作
	 * @param signParam
	 */
	private void updateStudentSign(StudentSignCreateParam signParam,StudentSign signOld){
		BeanUtils.copyProperties(signParam, signOld);
		signOld.setStudentName(signParam.getName());
		
		StudentInfo studentInfo = studentInfoRepository.loadStudentInfo(signParam.getStudentId());
		BeanUtils.copyProperties(signParam, studentInfo);
		
		//update 学生sign信息
        studentSignMsgRepository.updateStudentSign(signOld);
		//update 学生信息
        studentInfoRepository.updateStudentInfo(studentInfo);
	}
	
	/**
	 * create操作
	 * @param signParam
	 */
	private void createStudentSign(StudentSignCreateParam signParam){
		StudentInfo studentInfo = new StudentInfo();
		BeanUtils.copyProperties(signParam, studentInfo);
		
		StudentSign sign = new StudentSign();
		BeanUtils.copyProperties(signParam, sign);
		sign.setSignTime(DateUtil.now());
		sign.setStudentId(studentInfoRepository.addStudentInfo(studentInfo));
		sign.setStudentName(signParam.getName());
        studentSignMsgRepository.addStudentSign(sign);
	}
	
	@Override
	public void deleteStudentSign(Long id) {
		StudentSign sign = studentSignMsgRepository.loadStudentSignById(id);
        if(null == sign){
            return;
        }
		sign.setIsDelete(StudentStatusEnum.DELETED.getCode());
        studentSignMsgRepository.updateStudentSign(sign);
	}
	
	@Override
	public StudentSignView loadSignWithStuInfoById(Long id) throws ParamValidateException {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("isDelete", StudentStatusEnum.NORMAL.getCode());
		param.put("id", id);
		StudentSignView view = studentSignMsgRepository.loadSignWithStuInfoById(param);
		if(null == view){
			throw new ParamValidateException("信息不存在，请稍后重试！");
		}
		return view;
	}

    @Override
    public List<StudentSignView> listExpireStudentsInfos() {

        List<StudentSignView> expireStudentsInfos = studentSignMsgRepository.listExpireStudentsInfos();

        return expireStudentsInfos;
    }

}
