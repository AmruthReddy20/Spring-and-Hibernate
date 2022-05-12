package com.springdemo.aop.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

@Pointcut("execution(* com.springdemo.aop.dao.* .*(..))")
public void forDAOPackage(){

}
@Before("forDAOPackage()")
public void beforeAddAccountAdvice() {
    System.out.println("==============>Executing @Before Advice on Account");
}
@Before("forDAOPackage()")
public void performApiAnalytics(){
        System.out.println("===========>Performing API Analytics");
}

}
