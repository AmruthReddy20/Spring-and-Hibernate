package com.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FootBallCoach implements  Coach{
    @Autowired
    @Qualifier("happyFortuneService")
    private FortuneService fortune;
//@Autowired
//    public void doSetFortune(FortuneService fortune) {
//        this.fortune = fortune;
//    }




    @Override
    public String getDailyWorkOut() {
        return "Run 2 km daily";
    }

    @Override
    public String getDailyFortune() {
        return fortune.getFortune();
    }
}
