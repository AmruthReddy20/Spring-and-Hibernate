package com.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component("myTennisCoach")
@Component
//@Scope("prototype")
public class TennisCoach implements Coach
{
    private final FortuneService fortuneService;
    @PostConstruct
    public void doMyStartUpStuff(){
        System.out.println("inside of do my startup function");
    }
    @PreDestroy
    public void doMyCleanUpStuff(){
        System.out.println("Inside of do my claen up stuff");
    }


//    @Autowired
    public TennisCoach( @Qualifier("randomFortuneService") FortuneService fortuneService){
        this.fortuneService=fortuneService;
    }

    @Override
    public String getDailyWorkOut() {
        return "Practise backhand volley";
    }

    public String getDailyFortune(){
        return fortuneService.getFortune();
    }

}
