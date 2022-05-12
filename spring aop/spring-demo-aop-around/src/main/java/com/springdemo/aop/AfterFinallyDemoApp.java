package com.springdemo.aop;

import com.springdemo.aop.dao.AccountDAO;
import com.springdemo.aop.dao.MemberShipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

class AfterFinallyDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO=context.getBean("accountDAO",AccountDAO.class);
        List<Account> theAccounts=null;
        try{
            boolean tripWire=false;
            theAccounts =accountDAO.findAccount(tripWire);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        System.out.println("Main Progaram:After Throwing  DemoApp");
        System.out.println("--------------------");
        System.out.println(theAccounts);
        context.close();
    }
}
