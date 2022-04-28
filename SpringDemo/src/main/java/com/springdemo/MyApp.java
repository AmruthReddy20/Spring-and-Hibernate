package com.springdemo;


public class MyApp {
    public static void main(String[] args) {
        Coach theCoach =new BaseBallCoach(new HappyFortuneService());
        System.out.println(theCoach.getDailyWorkout());
        Coach trackCoach=new TrackCoach(new HappyFortuneService());
        System.out.println(trackCoach.getDailyWorkout());
    }
}
