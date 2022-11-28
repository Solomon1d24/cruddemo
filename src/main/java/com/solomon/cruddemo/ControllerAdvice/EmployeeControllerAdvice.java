package com.solomon.cruddemo.ControllerAdvice;

import com.solomon.cruddemo.Exception.EmployeeNotFoundException;
import com.solomon.cruddemo.Response.EmployeeErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(Exception exception) {

        EmployeeErrorResponse employeeErrorResponse = new EmployeeErrorResponse();
        employeeErrorResponse.setMessage(exception.getMessage());
        employeeErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        employeeErrorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(employeeErrorResponse, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException employeeNotFoundException) {

        EmployeeErrorResponse employeeErrorResponse = new EmployeeErrorResponse();
        employeeErrorResponse.setTimestamp(System.currentTimeMillis());
        employeeErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        employeeErrorResponse.setMessage(employeeNotFoundException.getMessage());
        return new ResponseEntity<>(employeeErrorResponse, HttpStatus.NOT_FOUND);

    }

}
