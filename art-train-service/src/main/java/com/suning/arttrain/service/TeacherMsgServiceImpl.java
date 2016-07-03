package com.suning.arttrain.service;

import com.suning.arttrain.exception.ParamValidateException;
import com.suning.arttrain.param.TeacherInfoCreateParam;
import com.suning.arttrain.param.TeacherInfoListParam;
import com.suning.arttrain.persistent.TeacherInfo;
import com.suning.arttrain.repository.TeacherInfoRepository;
import com.suning.arttrain.util.OvalUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("teacherMsgService")
public class TeacherMsgServiceImpl implements TeacherMsgService {

    @Resource(name = "teacherInfoRepository")
    private TeacherInfoRepository teacherInfoRepository;

    @Override
    public int countTeacherInfos(TeacherInfoListParam listParam) {
        Map<String, Object> param = getParam(listParam);

        return teacherInfoRepository.countTeacherInfos(param);
    }

    @Override
    public void addTeacherInfo(TeacherInfo teacherInfo) {
        teacherInfoRepository.addTeacherInfo(teacherInfo);
    }

    @Override
    public List<TeacherInfo> listTeacherInfos(TeacherInfoListParam listParam) {
        Map<String, Object> param = getParam(listParam);
        param.put("pageSize", listParam.getPageSize());
        param.put("pageIndex", listParam.getPageIndex());

        return teacherInfoRepository.listTeacherInfos(param);
    }

    @Override
    public List<TeacherInfo> queryTeacherInfos() {
        return teacherInfoRepository.queryTeacherInfos();
    }

    /**
     * 拼接查询参数
     *
     * @param listParam
     * @return
     */
    private Map<String, Object> getParam(TeacherInfoListParam listParam) {
        Map<String, Object> param = new HashMap<String, Object>();
        if (null == listParam) {
            return param;
        }
        if (StringUtils.isNotBlank(listParam.getStartTime())) {
            param.put("startTime", listParam.getStartTime());
        }
        if (StringUtils.isNotBlank(listParam.getEndTime())) {
            param.put("endTime", listParam.getEndTime());
        }
        if (StringUtils.isNotBlank(listParam.getTeacherName())) {
            param.put("teacherName", listParam.getTeacherName());
        }
        return param;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void saveTeacherInfo(TeacherInfoCreateParam createParam) throws ParamValidateException {

        OvalUtil.validate(createParam);

        TeacherInfo teacherInfoOld = teacherInfoRepository.loadTeacherInfo(createParam.getTeacherInfoId());

        if (teacherInfoOld != null) {
            updateTeacherInfo(createParam, teacherInfoOld);
        } else {
            createTeacherInfo(createParam);
        }
    }

    /**
     * update操作
     */
    private void updateTeacherInfo(TeacherInfoCreateParam teacherInfoParam, TeacherInfo teacherInfoOld) {
        BeanUtils.copyProperties(teacherInfoParam, teacherInfoOld);
        teacherInfoRepository.updateTeacherInfo(teacherInfoOld);
    }

    /**
     * create操作
     */
    private void createTeacherInfo(TeacherInfoCreateParam courseParam) {
        TeacherInfo teacherInfo = new TeacherInfo();
        BeanUtils.copyProperties(courseParam, teacherInfo);

        teacherInfoRepository.addTeacherInfo(teacherInfo);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void deleteTeacherInfo(Long id) throws ParamValidateException {
        TeacherInfo teacherInfo = teacherInfoRepository.loadTeacherInfo(id);
        if (null == teacherInfo) {
            throw new ParamValidateException("信息不存在，请稍后重试！");
        }
        teacherInfoRepository.deleteTeacherInfoById(id);
    }

    @Override
    public TeacherInfo loadTeacherInfoById(Long id) throws ParamValidateException {
        TeacherInfo teacherInfo = teacherInfoRepository.loadTeacherInfo(id);
        if (null == teacherInfo) {
            throw new ParamValidateException("信息不存在，请稍后重试！");
        }
        return teacherInfo;
    }

}
