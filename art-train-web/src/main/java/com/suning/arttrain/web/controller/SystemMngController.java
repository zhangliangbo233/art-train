package com.suning.arttrain.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SystemMngController extends BaseController{

	/**
	 * 显示首页
	 * @return
	 */
	@RequestMapping("/systemMng")
	public ModelAndView systemMng(){
		ModelAndView view = new ModelAndView("systemMng");
		return view;
	}

}
