package com.suning.arttrain.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.suning.arttrain.common.util.AjaxResult;
import com.suning.arttrain.common.util.Page;
import com.suning.arttrain.common.util.PageData;
import com.suning.arttrain.dto.StudentSignView;
import com.suning.arttrain.exception.ParamValidateException;
import com.suning.arttrain.param.StudentListParam;
import com.suning.arttrain.param.StudentSignCreateParam;
import com.suning.arttrain.persistent.StudentInfo;
import com.suning.arttrain.service.StudentMngService;
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
public class StudentMngController extends BaseController{

	private final static Logger logger =  LoggerFactory.getLogger(StudentMngController.class);
	
	@Autowired
	private StudentMngService studentMngService;

	@RequestMapping(value="showStudentSignInfos")
	public ModelAndView showStudentSignInfos(){
		ModelAndView mav = new ModelAndView("studentMsg/studentSignInfos");
		return mav;
	}

	@RequestMapping(value="studentsInfos")
	public ModelAndView studentsInfos(StudentListParam studentListParam){
		ModelAndView view = new ModelAndView("studentMng/studentInfos");

		List<StudentInfo> studentsInfos = studentMngService.listStudentInfos(studentListParam);
		view.addObject("studentsInfos",studentsInfos);

		return view;
	}

	@RequestMapping(value="addStudentInfo")
	public ModelAndView addStudentInfo(){
		ModelAndView view = new ModelAndView("studentMng/addStudentInfo");
		return view;
	}
	
	@RequestMapping(value="listStudentSignInfos")
	public PageData<StudentInfo> listStudentSignInfos(@RequestParam("rows") int rows,@RequestParam("page") int page,
			@RequestParam(value="startTime",defaultValue ="", required=false) String startTime,
            @RequestParam(value="endTime",defaultValue = "",required=false) String endTime,
			@RequestParam(value="studentName",defaultValue = "",required=false) String studentName){
		PageData<StudentInfo> data = null;
		try{
            StudentListParam listParam = new StudentListParam();

			Page pg = new Page(rows, page);
			data = new PageData<StudentInfo>();
			listParam.setPageIndex(page);
			listParam.setPageSize(rows);
            listParam.setStartTime(startTime);
            listParam.setEndTime(endTime);
            listParam.setStudentName(studentName);

			List<StudentInfo> studentSignInfoseInfos = studentMngService.listStudentInfos(listParam);
			int countStudentSingInfos = studentMngService.countStudentSignInfos(startTime, endTime, studentName);
			data.setTotal(countStudentSingInfos);
			data.setRows(studentSignInfoseInfos);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
		}
		return data;
	}
	
	@RequestMapping(value = "/saveStudentSign", method = RequestMethod.POST)
	public AjaxResult saveStudentSign(@RequestParam("paramJson") String paramJson) {
		try{
			StudentSignCreateParam signParam = JSONObject.parseObject(paramJson, StudentSignCreateParam.class);
			studentMngService.saveStudentSign(signParam);
			return AjaxResult.success(null,"恭喜，操作成功");
		}catch(ParamValidateException e){
			logger.error(e.getMessage(),e);
			return AjaxResult.failed(e.getMessage());
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			return AjaxResult.failed("操作失败，请稍后重试");
		} catch (Throwable e) {
			logger.error(e.getMessage(),e);
			return AjaxResult.failed("操作失败，请稍后重试");
		}
	}
	
	@RequestMapping(value = "/deleteStudentSign", method = RequestMethod.POST)
	public AjaxResult deleteStudentSign(@RequestParam("id") Long id) {
		try {
			studentMngService.deleteStudentSign(id);
			return AjaxResult.success("操作成功");
		} catch (Throwable e) {
			logger.error(e.getMessage(),e);
			return AjaxResult.failed("操作失败，请稍后重试");
		}
	}
	
	@RequestMapping(value = "/loadStudentSign", method = RequestMethod.POST)
	public AjaxResult loadStudentSign(@RequestParam("id") Long id) {
		try {
			StudentSignView view =studentMngService.loadSignWithStuInfoById(id);
			return AjaxResult.success(view);
		} catch (ParamValidateException e) {
			logger.error(e.getMessage(),e);
			return AjaxResult.failed(e.getMessage());
		} catch (Throwable e) {
			logger.error(e.getMessage(),e);
			return AjaxResult.failed("操作失败，请稍后重试");
		}
	}

    /**
     * 提前三天提醒即将到期的学员信息
     * @return
     */
    @RequestMapping("listExpireStudentsInfos")
    public AjaxResult listExpireStudentsInfos(){

        try {
            List<StudentSignView> expireStudentsInfos = studentMngService.listExpireStudentsInfos();
            return AjaxResult.success(expireStudentsInfos);
        } catch (Throwable e) {
            logger.error(e.getMessage(),e);
            return AjaxResult.failed("操作失败，请稍后重试");
        }

    }
	
}