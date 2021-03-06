package com.springdemo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {
    @Before("com.springdemo.aop.aspect.AopExpressions.noGetterSetterAdvice()")
    public void performApiAnalytics(){
        System.out.println("===========>Performing API Analytics");
    }

}
