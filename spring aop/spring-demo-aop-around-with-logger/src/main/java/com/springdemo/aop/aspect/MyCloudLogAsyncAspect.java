package com.springdemo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {
    @Before("com.springdemo.aop.aspect.AopExpressions.noGetterSetterAdvice()")
    public void logToCloudAsync(){
        System.out.println("===========>Logging to Cloud in async fashion");
    }

}
