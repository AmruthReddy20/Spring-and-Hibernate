package com.jackson.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {
    public static void main(String[] args) {
        try{
            ObjectMapper mapper =new ObjectMapper();
            Student theStudent=mapper.readValue(new File("data/sample-full.json"),Student.class);
            System.out.println(theStudent.getFirstName()+" "+theStudent.getLastName());
            System.out.println(theStudent.getAddress());
            System.out.println(theStudent.getLanguages());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
