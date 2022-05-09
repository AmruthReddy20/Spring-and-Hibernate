package com.webapp.springdemo.dao;

import com.webapp.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> getCustomers();
}
