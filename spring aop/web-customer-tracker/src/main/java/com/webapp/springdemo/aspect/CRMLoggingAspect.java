package com.webapp.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;
@Component
@Aspect
public class CRMLoggingAspect {
    private Logger myLogger= Logger.getLogger(CRMLoggingAspect.class.getName());
    @Pointcut("execution(* com.webapp.springdemo.controller.*.*(..))")
    private void forControllerPackage(){

    }    @Pointcut("execution(* com.webapp.springdemo.service.*.*(..))")
    private void forServicePackage(){

    }    @Pointcut("execution(* com.webapp.springdemo.dao.*.*(..))")
    private void forDAOPackage(){

    }
    @Pointcut("forControllerPackage()||forServicePackage()||forDAOPackage()")
    private void forAppFlow(){}
    @Before("forAppFlow()")
    public void before(JoinPoint thejoinpoint){
        String theMethod=thejoinpoint.getSignature().toString();
        myLogger.info("============>in @before:calling method: "+theMethod);

    }


}
