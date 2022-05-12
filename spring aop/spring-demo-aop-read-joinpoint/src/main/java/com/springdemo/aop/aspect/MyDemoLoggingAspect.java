package com.springdemo.aop.aspect;


import com.springdemo.aop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {


@Before("com.springdemo.aop.aspect.AopExpressions.noGetterSetterAdvice()")
public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
    MethodSignature mehtodSignature= (MethodSignature) theJoinPoint.getSignature();
    System.out.println("Method: "+mehtodSignature);
    Object[] args=theJoinPoint.getArgs();
    for(Object tempArg:args){
        System.out.println(tempArg);
        if(tempArg instanceof Account){
            Account theAccount=(Account) tempArg;
            System.out.println("Account name: "+theAccount.getName());
            System.out.println("Account level: "+theAccount.getLevel());
        }

    }


    System.out.println("==============>Executing @Before Advice on Account");
}



}
