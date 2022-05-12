package com.springdemo.aop;

import com.springdemo.aop.dao.AccountDAO;
import com.springdemo.aop.dao.MemberShipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO=context.getBean("accountDAO",AccountDAO.class);
        MemberShipDAO memberShipDAO=context.getBean("memberShipDAO",MemberShipDAO.class);
        accountDAO.addAccount(new Account(),true);
        accountDAO.doWork();
        System.out.println("MemberShip DAO");
        memberShipDAO.addAccount();
        memberShipDAO.addSillyMember();
        memberShipDAO.goToSleep();
        context.close();
    }
}
