package com.suning.arttrain.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("")
public class IndexController extends BaseController{

	/**
	 * 显示首页
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(){
		ModelAndView mav = new ModelAndView("layout/index");
		return mav;
	}

}
