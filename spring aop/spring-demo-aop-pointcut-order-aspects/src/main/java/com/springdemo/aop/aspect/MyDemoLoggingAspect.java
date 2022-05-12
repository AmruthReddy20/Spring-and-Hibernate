package com.springdemo.aop.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {


@Before("com.springdemo.aop.aspect.AopExpressions.noGetterSetterAdvice()")
public void beforeAddAccountAdvice() {
    System.out.println("==============>Executing @Before Advice on Account");
}



}
