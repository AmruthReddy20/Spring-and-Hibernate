package com.springrest.demo.exception;

public class StudentNotFoundException extends  RuntimeException{
    public StudentNotFoundException(String message){
        super(message);
    }

    public StudentNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public StudentNotFoundException(Throwable throwable) {
        super(throwable);
    }


}
