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
}
