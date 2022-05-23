package com.springboot.demo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.LocalTime;

@RestController
public class FunRestController {
    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;
    @GetMapping("/teaminfo")
    public String getTeaminfo(){
        return "<h1> Coach: "+coachName+" Team Name: "+teamName+"</h1>";
    }
    @GetMapping("/")
    public String getHomePage(){
        return "Hello World! Time on Server is "+ LocalDateTime.now();
    }
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "run a hard 5k run";
    }
    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is your lucky day";
    }
}
