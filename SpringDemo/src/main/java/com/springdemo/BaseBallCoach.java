package com.springdemo;

public class BaseBallCoach implements Coach {
    private FortuneService newFortune;
    BaseBallCoach(FortuneService newFortune){
        this.newFortune=newFortune;
    }
    @Override
    public  String getDailyWorkout(){
        return "Spend 30 minutes on batting pratice";
    }

    @Override
    public String getDailyFortune() {
        return "Just Do it: "+newFortune.getFortune();
    }
}
