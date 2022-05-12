package com.springdemo.aop.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
@Component
public class MemberShipDAO {
    @Transactional
    public void addAccount(){
        System.out.println(getClass()+"Doing stuff:adding a membership account");
    }
    @Transactional
    public boolean addSillyMember(){
        System.out.println(getClass()+": Adding a silly memeber");
        return false;
    }
    public void goToSleep(){
        System.out.println(getClass()+":go to sleep");
    }

}
