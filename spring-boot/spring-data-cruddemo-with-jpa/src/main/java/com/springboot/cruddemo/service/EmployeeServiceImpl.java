package com.springboot.cruddemo.service;


import com.springboot.cruddemo.dao.EmployeeRespository;
import com.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRespository employeeRepository;

    @Override

    public List<Employee> showAll() {
        return employeeRepository.findAll();

    }

    @Override

    public Employee findByID(int theId) {
        Employee theEmployee=null;
        Optional<Employee> result=employeeRepository.findById(theId);
        if(result.isPresent()){
            theEmployee=result.get();
        }
        else{
            throw new RuntimeException("Did not find employee id "+theId);
        }

        return theEmployee;
    }


    @Override

    public void save(Employee theEmployee) {
        employeeRepository.save(theEmployee);

    }

    @Override
    public void delete(int theId) {
        employeeRepository.deleteById(theId);


    }
}
