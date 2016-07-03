package com.suning.arttrain.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController extends BaseController{

	/**
	 * 显示首页
	 * @return
	 */
	@RequestMapping("/dashboard")
	public ModelAndView dashboard(){
		ModelAndView view = new ModelAndView("dashboard");
		return view;
	}

}
