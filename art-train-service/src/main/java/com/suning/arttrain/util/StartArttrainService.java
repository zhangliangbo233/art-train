package com.suning.arttrain.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * main 方法启动service服务
 * @author zhanglb
 *
 */
public class StartArttrainService {

	public static void main(String[] args) {
		//加载配置文件
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring-datasource.xml"});
	}
}
