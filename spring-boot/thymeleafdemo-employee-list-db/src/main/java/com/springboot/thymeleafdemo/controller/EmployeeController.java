package com.springboot.thymeleafdemo.controller;

import com.springboot.thymeleafdemo.entity.Employee;
import com.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping("/list")
    public String getEmployees(Model theModel){
        List<Employee> employeeList=employeeService.showAll();
        theModel.addAttribute("employees",employeeList);
        return "employees/employee-list";
    }
    @GetMapping("/addEmployee")
    public String showFormForAdd(Model theModel) {

        Employee theEmployee = new Employee();

        theModel.addAttribute("employee", theEmployee);

        return "employees/employee-form";
    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {

        employeeService.save(theEmployee);

        return "redirect:/employees/list";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId,Model theModel){
        Employee employee=employeeService.findByID(theId);
        theModel.addAttribute("employee",employee);
        return "employees/employee-form";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId){
        employeeService.delete(theId);
        return "redirect:/employees/list";
    }
}
