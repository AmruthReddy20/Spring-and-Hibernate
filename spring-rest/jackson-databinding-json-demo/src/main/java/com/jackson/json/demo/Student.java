package com.jackson.json.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private boolean active;
    private Address address;
    private List<String> languages;


}
