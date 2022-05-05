package com.springdemo.mvc;

import org.springframework.stereotype.Controller;

import java.util.LinkedHashMap;

public class Student {
    private String firstName;
    private String lastName;

    public String[] getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(String[] operatingSystems) {
        this.operatingSystems = operatingSystems;
    }

    private String[] operatingSystems;

    public String getFavouriteLanguage() {
        return favouriteLanguage;
    }

    public void setFavouriteLanguage(String favouriteLanguage) {
        this.favouriteLanguage = favouriteLanguage;
    }

    private String favouriteLanguage;


    public LinkedHashMap<String, String> getCountries() {
        return countries;
    }

    private LinkedHashMap<String,String> countries;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private String country;
    public Student(){
        countries=new LinkedHashMap<>();
        countries.put("IND","India");
        countries.put("GER","Germany");
        countries.put("UK","United Kingdom");

    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
