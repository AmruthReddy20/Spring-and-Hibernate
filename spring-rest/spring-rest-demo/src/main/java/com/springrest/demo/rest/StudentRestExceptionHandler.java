package com.springrest.demo.rest;

import com.springrest.demo.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException s){
        StudentErrorResponse studentErrorResponse=new StudentErrorResponse();
        studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        studentErrorResponse.setMessage(s.getMessage());
        studentErrorResponse.setTimeStamp(System.currentTimeMillis());
        ResponseEntity<StudentErrorResponse> responseEntity=new ResponseEntity(studentErrorResponse,HttpStatus.NOT_FOUND);
        return responseEntity;
    }
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleGenericException(Exception e){
        StudentErrorResponse studentErrorResponse=new StudentErrorResponse();
        studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        studentErrorResponse.setMessage(e.getMessage());
        studentErrorResponse.setTimeStamp(System.currentTimeMillis());
        ResponseEntity<StudentErrorResponse> responseEntity=new ResponseEntity(studentErrorResponse,HttpStatus.BAD_REQUEST);
        return responseEntity;
    }
}
