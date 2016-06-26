package com.suning.arttrain.common.util;

import java.lang.reflect.Method;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;

/**
 * jsonrpc 调用service封装
 * 
 * @author zhanglb
 * 
 */
@Component("jsonRpcClientUtil")
public class JsonRpcClientUtil {

	@Value("${jsconrpc.arttrain.url}")
	private String arttrainServicePrefix;

	@Value("${jsonrpc.serviceSuffix}")
	private String serviceSuffix;

	@SuppressWarnings("all")
	public Object doService(Class cls, String methodName, int serviceType,
			Object... args) throws Throwable {

		StringBuffer serviceUrl = new StringBuffer();

		Class classObject[] = null;

		if (args != null) {
			int len = args.length;

			classObject = new Class[args.length];

			for (int i = 0; i < len; i++) {
				classObject[i] = args[i].getClass();
			}
		}

		Method method = cls.getMethod(methodName, classObject);

		serviceUrl.append(getServiceUrlPrefix(serviceType)).append("/")
				.append(getServiceName(method)).append(".")
				.append(serviceSuffix);

		JsonRpcHttpClient client = new JsonRpcHttpClient(new URL(
				serviceUrl.toString()));

		Object result = client.invoke(method.getName(), args,
				method.getGenericReturnType());

		return result;
	}
	
	/**
	 * 默认是艺术培训service
	 * @param cls
	 * @param methodName
	 * @param args
	 * @return
	 * @throws Throwable
	 */
	@SuppressWarnings("all")
	public Object doService(Class cls, String methodName,
			Object... args) throws Throwable {
		
		StringBuffer serviceUrl = new StringBuffer();
		
		Class classObject[] = null;
		
		if (args != null) {
			int len = args.length;
			
			classObject = new Class[args.length];
			
			for (int i = 0; i < len; i++) {
                /*if(null == args[i]){
                    continue;
                }*/
				classObject[i] = args[i].getClass();
			}
		}
		
		Method method = cls.getMethod(methodName, classObject);
		
		serviceUrl.append(getServiceUrlPrefix(ServiceTypeEnum.ARTTRAIN_SERVICE.ordinal())).append("/")
		.append(getServiceName(method)).append(".")
		.append(serviceSuffix);
		
		JsonRpcHttpClient client = new JsonRpcHttpClient(new URL(
				serviceUrl.toString()));
		
		Object result = client.invoke(method.getName(), args,
				method.getGenericReturnType());
		
		return result;
	}

	/**
	 * 获取服务的类名
	 * 
	 * @param method
	 * @return
	 */
	private static String getServiceName(Method method) {

		String serviceName = method.getDeclaringClass().getName();

		serviceName = serviceName.substring(serviceName.lastIndexOf(".") + 1);

		return serviceName;
	}

	/**
	 * 获取service前缀
	 * 
	 * @param serviceType
	 * @return
	 */
	private String getServiceUrlPrefix(int serviceType) {
		if (serviceType == ServiceTypeEnum.ARTTRAIN_SERVICE.ordinal()) {
			return arttrainServicePrefix;
		}

		return arttrainServicePrefix;
	}

}
