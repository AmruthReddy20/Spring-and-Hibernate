package com.springdemo.aop;

import com.springdemo.aop.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class AroundDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
        System.out.println("Calling getFortune");
        String data =theFortuneService.getFortune(true);
        System.out.println("My fortune is :"+data);

        context.close();
    }
}
