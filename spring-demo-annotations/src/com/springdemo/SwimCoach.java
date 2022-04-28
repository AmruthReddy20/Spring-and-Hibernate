package com.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {


    @Value("${f.email}")
    private String email;
    @Value("${f.team}")
    private String team;
    private FortuneService fortuneService;
    public SwimCoach(FortuneService fortuneService){
        this.fortuneService=fortuneService;
    }
    @Override
    public String getDailyWorkOut() {
        return "Swim 1000m as a warm up";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }

}
