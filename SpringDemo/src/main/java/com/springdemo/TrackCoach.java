package com.springdemo;

public class TrackCoach implements Coach {
    private  FortuneService fortune;
    TrackCoach(FortuneService fortune){
        this.fortune=fortune;
    }
    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return fortune.getFortune();
    }

    public void domyStartUpStuff(){
        System.out.println("Called when bean is intiatied");
    }
    public void doMyCleanUpStuff(){
        System.out.println("Called when bean is destroyed");
    }



}
