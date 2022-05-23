package com.springrest.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.RestController;

@Data
@AllArgsConstructor
public class Student {
    private String firstName;
    private String lastName;


}
