package com.springrest.demo.controller;

import com.springrest.demo.entity.Student;
import com.springrest.demo.exception.StudentNotFoundException;
import com.springrest.demo.rest.StudentErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> students;
    @PostConstruct
    public void loadData(){
        students=new ArrayList<>();
        students.add(new Student("ganesh","dende"));
        students.add(new Student("suresh","Patel"));
        students.add(new Student("Mary","Smith"));
    }



    @RequestMapping("/students")
    public List<Student> studentList(){

        return students;
    }
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        if(studentId>=students.size()||studentId<0)
            throw new StudentNotFoundException("Student not Found "+studentId);
        return students.get(studentId);
    }
}
