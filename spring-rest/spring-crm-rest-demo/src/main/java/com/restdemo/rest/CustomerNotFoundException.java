package com.restdemo.rest;

public class CustomerNotFoundException extends  RuntimeException{
    public CustomerNotFoundException(String message){
        super(message);
    }

    public CustomerNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public CustomerNotFoundException(Throwable throwable) {
        super(throwable);
    }


}
