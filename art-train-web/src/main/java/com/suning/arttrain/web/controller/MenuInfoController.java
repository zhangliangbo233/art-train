package com.suning.arttrain.web.controller;

import com.suning.arttrain.persistent.MenuInfo;
import com.suning.arttrain.service.MenuInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("menu")
public class MenuInfoController extends BaseController{

    private final static Logger logger =  LoggerFactory.getLogger(MenuInfoController.class);


    @Autowired
    private MenuInfoService menuInfoService;

	/**
	 * 加载菜单信息
	 * @return
	 */
	@RequestMapping("/listMenuInfos")
	public List<MenuInfo> listMenuInfos(@RequestParam(required = false) Long id){

        try {
            id = id != null?id:0;
            List<MenuInfo> menuInfos = menuInfoService.listMenuInfos(id);

            return menuInfos;

        } catch (Throwable e) {
            logger.error(e.getMessage(),e);
        }

        return null;
	}
	
}
