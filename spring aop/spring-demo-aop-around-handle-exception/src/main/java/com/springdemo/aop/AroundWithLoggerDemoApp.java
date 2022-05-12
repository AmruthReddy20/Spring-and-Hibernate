package com.springdemo.aop;

import com.springdemo.aop.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;


class AroundWithLoggerDemoApp {
    private static Logger myLogger= Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
        myLogger.info("Calling getFortune");
        String data =theFortuneService.getFortune(true);
        myLogger.info("My fortune is :"+data);

        context.close();
    }
}
