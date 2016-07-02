package com.suning.arttrain.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.suning.arttrain.common.util.AjaxResult;
import com.suning.arttrain.common.util.PageData;
import com.suning.arttrain.exception.ParamValidateException;
import com.suning.arttrain.param.TeacherInfoCreateParam;
import com.suning.arttrain.param.TeacherInfoListParam;
import com.suning.arttrain.persistent.TeacherInfo;
import com.suning.arttrain.service.TeacherMsgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("teacher")
public class TeacherMsgController extends BaseController{

	private final static Logger logger =  LoggerFactory.getLogger(TeacherMsgController.class);
	
	@Autowired
	private TeacherMsgService teacherMsgService;
	/**
	 * 显示老师管理页面
	 * @return
	 */
	@RequestMapping("/showTeacherInfos")
	public ModelAndView index(){
		ModelAndView mav = new ModelAndView("teacherMsg/teacherInfos");
		return mav;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="listTeacherInfos")
	public PageData<TeacherInfo> listTeacherInfos(@RequestParam("rows") int rows,@RequestParam("page") int page,
			@RequestParam(value="teacherInfoListParam",required=false) String teacherInfoListParam){
		PageData<TeacherInfo> data = null;
		try{
			TeacherInfoListParam listParam = JSONObject.parseObject(teacherInfoListParam, TeacherInfoListParam.class);
            listParam.setPageIndex(rows);
            listParam.setPageSize(page);
			List<TeacherInfo> teacherInfos = teacherMsgService.listTeacherInfos(listParam);
			int countTeacherInfo = teacherMsgService.countTeacherInfos(listParam);
			data = new PageData<TeacherInfo>();
			data.setTotal(countTeacherInfo);
			data.setRows(teacherInfos);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
		} catch (Throwable e) {
			logger.error(e.getMessage(),e);
		}
		return data;
	}

    @RequestMapping("queryTeacherInfos")
    public PageData queryTeacherInfos(){
        PageData data = new PageData();
        try {
            List<TeacherInfo> teacherInfos = teacherMsgService.queryTeacherInfos();
            if (null == teacherInfos){
                return data;
            }
            data.setRows(teacherInfos);
            data.setTotal(teacherInfos.size());
            return  data;
        } catch (Throwable e) {
            logger.error(e.getMessage(), e);
        }
        return data;
    }
	
	@RequestMapping(value = "/saveTeacherInfo", method = RequestMethod.POST)
	public AjaxResult saveTeacherInfo(@RequestParam("paramJson") String paramJson) {
		try{
			TeacherInfoCreateParam teacherInfoParam = JSONObject.parseObject(paramJson, TeacherInfoCreateParam.class);
			teacherMsgService.saveTeacherInfo(teacherInfoParam);
			return AjaxResult.success(null,"恭喜，操作成功");
		}catch(ParamValidateException e){
			logger.error(e.getMessage(),e);
			return AjaxResult.failed(e.getMessage());
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			return AjaxResult.failed("操作失败，请稍后重试");
		}
	}
	
	@RequestMapping(value = "/loadTeacherInfo", method = RequestMethod.POST)
	public AjaxResult loadTeacherInfo(@RequestParam("id") long id) {
		try {
			TeacherInfo teacherInfo = teacherMsgService.loadTeacherInfoById(id);
			return AjaxResult.success(teacherInfo);
		} catch (ParamValidateException e) {
			logger.error(e.getMessage(),e);
			return AjaxResult.failed(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/deleteTeacherInfo", method = RequestMethod.POST)
	public AjaxResult deleteTeacherInfo(@RequestParam("id") Long id) {
		try {
			teacherMsgService.deleteTeacherInfo(id);
			return AjaxResult.success(null,"恭喜，操作成功");
		} catch (ParamValidateException e) {
			logger.error(e.getMessage(),e);
			return AjaxResult.failed(e.getMessage());
		}
	}
}
