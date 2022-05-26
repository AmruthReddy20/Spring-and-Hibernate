package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private  String name;

    @Value("${team.name}")
    private  String team;

    @GetMapping("/details")
    public  String fun(){
        return "Coach "+name+" team : "+team;
    }

    @GetMapping("/")

    public  String sayHello(){
        return  ""+LocalDateTime.now();
    }

    @GetMapping("/test")

    public  String testing(){
        return  "Iam testing here now here";
    }
}
