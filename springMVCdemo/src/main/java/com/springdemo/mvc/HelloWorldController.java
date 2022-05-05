package com.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
    @RequestMapping("/form")
    public String showForm(){
        return "helloworld-form";
    }

    @RequestMapping("/display")
    public String displayForm(){
        return "display-form";
    }
    @RequestMapping("/displayUpper")
    public  String displayUpperCase(HttpServletRequest request, Model model){
        String studentName=request.getParameter("studentName");
        studentName=studentName.toUpperCase();
        String result="Hello, " +studentName;
        model.addAttribute("message",result);
        return "display-form";
    }
    @RequestMapping("/displayUpper2")
    public  String displayUpperCasetwo( @RequestParam("studentName") String studentName, Model model){
        studentName=studentName.toUpperCase();
        String result="Hello Friend " +studentName;
        model.addAttribute("message",result);
        return "display-form";
    }
}