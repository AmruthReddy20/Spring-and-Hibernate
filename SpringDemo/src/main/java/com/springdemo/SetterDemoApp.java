package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        CricketCoach theCoach=context.getBean("CricketCoach",CricketCoach.class);
        System.out.println("injecting dependency using setter method");
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());
        System.out.println("Coach Email: "+theCoach.getEmailAddress());
        System.out.println("Coach Team: "+theCoach.getTeam());
        context.close();
    }
}
