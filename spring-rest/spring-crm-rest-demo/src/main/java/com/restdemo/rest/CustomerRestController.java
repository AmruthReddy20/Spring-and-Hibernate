package com.restdemo.rest;

import com.restdemo.entity.Customer;
import com.restdemo.service.CustomerService;
import com.restdemo.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
    @Autowired
    CustomerService theCustomerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return theCustomerService.getCustomers();
    }
    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){
        Customer theCustomer=theCustomerService.getCustomer(customerId);
        if(theCustomer==null){
            throw new CustomerNotFoundException("Customer id not found- "+customerId);
        }
        return theCustomer;
    }
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer theCustomer){
        boolean validEmail = Pattern.matches("^(.+)@(\\S+)\\.(.+)$",theCustomer.getEmail());
        if(!validEmail){
            throw new InvalidEmailException("Email not valid!");
        }
        theCustomer.setId(0);
        theCustomerService.saveCustomer(theCustomer);
        return theCustomer;
    }
    @PutMapping("/customers")
    public void updateCustomer(@RequestBody Customer theCustomer){
        theCustomerService.saveCustomer(theCustomer);
    }
    @DeleteMapping("/customers/{customerId}")
    public Customer deleteCustomer(@PathVariable int customerId){
        Customer tempCustomer=theCustomerService.getCustomer(customerId);
        if(tempCustomer==null){
            throw new CustomerNotFoundException("Customer is not found"+customerId);
        }
        theCustomerService.deleteCustomer(customerId);
        return tempCustomer;
    }

}
