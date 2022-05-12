package com.springdemo.aop.dao;

import com.springdemo.aop.Account;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AccountDAO {
    @Transactional
    public void  addAccount(Account account,boolean vipConfig){
        System.out.println(getClass()+":Doing My db work to add account");

    }
    public boolean doWork(){
        System.out.println(getClass()+":do work");
        return true;
    }

}
