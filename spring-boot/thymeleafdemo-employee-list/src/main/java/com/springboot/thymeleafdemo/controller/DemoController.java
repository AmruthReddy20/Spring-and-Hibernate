package com.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;


@Controller
public class DemoController {
    @RequestMapping("/hello")
    public String sayHello(Model theModel){
        theModel.addAttribute("theDate",new Date());
        return "helloworld";
    }
}
