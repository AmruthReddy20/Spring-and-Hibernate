package com.springdemo.aop.aspect;


import com.springdemo.aop.Account;
import com.springdemo.aop.dao.AccountDAO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    @Around("execution(* com.springdemo.aop.service.*.getFortune(..))")
    public  Object aroundGetFortune(ProceedingJoinPoint theProceddingJoinPoint) throws  Throwable{
        String method=theProceddingJoinPoint.getSignature().toShortString();
        System.out.println("Executing @Around On Method:"+method);
        long begin=System.currentTimeMillis();
        Object result=theProceddingJoinPoint.proceed();
        long end=System.currentTimeMillis();
        long duaration=end-begin;
        System.out.println("n=====>Duaration:"+duaration/1000.0+"seconds");
        return result;
    }
    @After("execution(* com.springdemo.aop.dao.AccountDAO.findAccount(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint thejoinPoint) {
        System.out.println("Executed @After(finally) on method:  "+thejoinPoint.toShortString());
    }

    @AfterThrowing(pointcut = "execution(* com.springdemo.aop.dao.AccountDAO.findAccount(..))",throwing="theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint thejoinpoint,Throwable theExc){

        System.out.println("After throwing on mehod:"+thejoinpoint.getSignature().toShortString());
        System.out.println(getClass()+":"+theExc);
    }

    @AfterReturning(pointcut = "execution(* com.springdemo.aop.dao.AccountDAO.findAccount(..))",returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint thejointpoint, List<Account> result){
        System.out.println(result);
        String method =thejointpoint.getSignature().toShortString();
        System.out.println("=====>Executing @Afterreturning on method:"+method);
        System.out.println("====>result is"+result);
        convertAccountNamesToUpperCase(result);
        System.out.println("Upper case REsult is"+result);
    }

    private   void convertAccountNamesToUpperCase(List<Account> result) {
        for(Account account:result){
            String theUpperName=account.getName().toUpperCase();
            account.setName(theUpperName);
        }

    }


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
