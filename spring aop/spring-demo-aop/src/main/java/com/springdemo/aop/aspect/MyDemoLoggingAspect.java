package com.springdemo.aop.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
//    @Before("execution( void com.springdemo.aop.dao.AccountDAO.addAccount())")
//@Before("execution(void add*())")
//@Before("execution( * add*(com.springdemo.aop.Account))")
//@Before("execution( * add*(com.springdemo.aop.Account,..))")
//@Before("execution( * add*(..))"
@Before("execution(* com.springdemo.aop.dao.* .*(..))")
public void beforeAddAccountAdvice(){
        System.out.println("==============>Executing @Before Advice on Account");

    }

}
