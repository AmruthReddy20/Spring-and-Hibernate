package com.springdemo.aop.dao;

import com.springdemo.aop.Account;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component

public class AccountDAO {
    private String name;
    private String serviceCode;
    @Transactional
    public void  addAccount(Account account,boolean vipConfig){
        System.out.println(getClass()+":Doing My db work to add account");

    }
    public boolean doWork(){
        System.out.println(getClass()+":do work");
        return true;
    }

    public String getName() {
        System.out.println(getClass()+":in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+":in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+":in getServiceCode()");

        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+":in setServiceCode()");
        this.serviceCode = serviceCode;
    }
    public List<Account> findAccount(boolean tripWire){
        if(tripWire){
            throw new RuntimeException("No you!!!!!!");
        }
        List<Account> myAccount=new ArrayList<Account>();
        Account account=new Account("John","silver");
        Account account1=new Account("Madhu","Platinumr");
        Account account2=new Account("Luca","Gold");
        myAccount.add(account1);
        myAccount.add(account);
        myAccount.add(account2);

        return myAccount;

    }
}
