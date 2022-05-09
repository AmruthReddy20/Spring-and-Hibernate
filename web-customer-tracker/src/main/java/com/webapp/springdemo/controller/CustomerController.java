package com.webapp.springdemo.controller;


import com.webapp.springdemo.dao.CustomerDAO;
import com.webapp.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerDAO customerDAO;
    @RequestMapping("/list")
    public String listCustomer(Model theModel){
        List<Customer> customerList=customerDAO.getCustomers();
        theModel.addAttribute("customers",customerList);
        return "list-customers";
    }
}
