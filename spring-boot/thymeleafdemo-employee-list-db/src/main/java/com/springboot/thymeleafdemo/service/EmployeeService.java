package com.springboot.thymeleafdemo.service;



import com.springboot.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> showAll();
    public Employee findByID(int theId);
    public void save(Employee theEmployee);
    public void delete(int theId);
}
