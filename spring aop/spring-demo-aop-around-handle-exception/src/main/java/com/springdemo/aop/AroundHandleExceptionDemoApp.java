package com.springdemo.aop;

import com.springdemo.aop.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;


class AroundHandleExceptionDemoApp {
    private static Logger myLogger= Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
        myLogger.info("Calling getFortune");
        boolean tripWire=true;
        String data = theFortuneService.getFortune(true);


        myLogger.info("My fortune is :"+data);

        context.close();
    }
}
