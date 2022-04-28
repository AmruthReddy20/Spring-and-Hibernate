package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
//        Coach theCoach=context.getBean("myTennisCoach",Coach.class);
        Coach theCoach=context.getBean("tennisCoach",Coach.class);
        System.out.println(theCoach.getDailyWorkOut());
        System.out.println(theCoach.getDailyFortune());
        Coach coach=context.getBean("footBallCoach",Coach.class);
        System.out.println(coach.getDailyWorkOut());
        System.out.println(coach.getDailyFortune());
        context.close();

    }
}
