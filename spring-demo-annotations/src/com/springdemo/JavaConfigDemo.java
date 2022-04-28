package com.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SportConfig.class);
        Coach theCoach=context.getBean("tennisCoach",Coach.class);
        System.out.println(theCoach.getDailyFortune());
    }
}
