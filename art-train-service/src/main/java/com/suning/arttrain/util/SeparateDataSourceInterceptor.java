package com.suning.arttrain.util;

import java.lang.reflect.Method;

import com.suning.arttrain.constant.DataSourceReadAndWriteEnum;
import com.suning.arttrain.constant.ServiceMethodStartTypeEnum;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 读写分离拦截器
 * 
 * @author zhanglb
 */
@Component
@Aspect
@Order(1)
public class SeparateDataSourceInterceptor{

    private static Logger logger = LoggerFactory.getLogger(SeparateDataSourceInterceptor.class);

    @Before("dtSourcePointcut()")
    public void doBefore(){
        logger.info(">>>>>>>>>>before change dataSource<<<<<<<<<<<<<");
    }

    // 定义切入点
    @Pointcut("execution(public * com.suning.arttrain.*.service.*.*(..))")
    public void dtSourcePointcut(){}

    @Around("dtSourcePointcut()")
    public Object doAround(ProceedingJoinPoint call){
        Object rs = null;
        try{
            Signature signature = call.getSignature();
            MethodSignature methodSignature = (MethodSignature) signature;
            Method method = methodSignature.getMethod();
            String methodName = method.getName();
            if (methodName.startsWith(ServiceMethodStartTypeEnum.SAVE.msg)
                    || methodName.startsWith(ServiceMethodStartTypeEnum.DELETE.msg)
                    || methodName.startsWith(ServiceMethodStartTypeEnum.UPDATE.msg)){
                this.setMasterDataSource();
            }else{
                this.setSlaveDataSource();
            }
            rs = call.proceed();
        }catch (Throwable e){
            logger.error(e.getMessage(), e);
        }
        return rs;
    }

    private void setMasterDataSource(){
        DynamicDataSourceHolder.setDataSourceName(DataSourceReadAndWriteEnum.DATA_SOURCE_MASTER.dataSource);
        logger.info("DataSource=====>master");

    }

    private void setSlaveDataSource(){
        DynamicDataSourceHolder.setDataSourceName(DataSourceReadAndWriteEnum.DATA_SOURCE_SLAVE.dataSource);
        logger.info("DataSource=====>slave");
    }

}
