package com.suning.arttrain.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class SystemManageController extends BaseController{

	/**
	 * 显示首页
	 * @return
	 */
	@RequestMapping("/dashboard")
	public ModelAndView index(){
		ModelAndView view = new ModelAndView("dashboard");
		return view;
	}

}
