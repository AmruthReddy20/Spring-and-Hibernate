package com.springboot.cruddemo.service;

import com.springboot.cruddemo.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public List<Employee> showAll();
    public Employee findByID(int theId);
    public void save(Employee theEmployee);
    public void delete(int theId);
}
