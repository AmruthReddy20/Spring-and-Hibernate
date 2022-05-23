package com.springboot.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.LocalTime;

@RestController
public class FunRestController {
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
