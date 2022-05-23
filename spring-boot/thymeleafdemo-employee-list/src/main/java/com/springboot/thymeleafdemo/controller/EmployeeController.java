package com.springboot.thymeleafdemo.controller;

import com.springboot.thymeleafdemo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private List<Employee> employeeList;
    @PostConstruct
    private void loadData(){
        employeeList=new ArrayList<Employee>();
        Employee employee=new Employee(1,"Ganesh","Dende","ganesh.dende@zemosolabs.com");
        Employee employee1=new Employee(2,"Emma","Watson","emma.watson@zemosolabs.com");
        Employee employee2=new Employee(3,"Leslie","Andrews","leslie.andrews@zemosolabs.com");
        employeeList.add(employee);
        employeeList.add(employee1);
        employeeList.add(employee2);

    }
    @RequestMapping("/list")
    public String getEmployees(Model theModel){
        theModel.addAttribute("employees",employeeList);
        return "employee-list";
    }
}
