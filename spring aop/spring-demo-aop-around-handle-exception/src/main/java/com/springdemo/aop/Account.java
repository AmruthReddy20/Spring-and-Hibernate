package com.springdemo.aop;

import lombok.Data;

@Data
public class Account {
    public String name;
    public String level;
    public Account(){}
    public Account(String name,String level){
        this.name=name;
        this.level=level;
    }
    public String toString(){
        return "Account [name="+name+", level="+level+"]";
    }

}
