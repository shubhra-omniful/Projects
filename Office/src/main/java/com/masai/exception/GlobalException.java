package com.masai.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler
    public ResponseEntity<MyError> employeeExceptionHandler(EmployeeException employeeException, WebRequest webRequest){
        MyError myError = new MyError();
        myError.setLocalDate(LocalDate.now());
        myError.setMessage(employeeException.getMessage());
        myError.setDescription(webRequest.getDescription(false));
        return new ResponseEntity<>(myError,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<MyError> managerExceptionHandler(ManagerException managerException, WebRequest webRequest){
        MyError myError = new MyError();
        myError.setLocalDate(LocalDate.now());
        myError.setMessage(managerException.getMessage());
        myError.setDescription(webRequest.getDescription(false));
        return new ResponseEntity<>(myError,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<MyError> officeExceptionHandler(OfficeException officeException, WebRequest webRequest){
        MyError myError = new MyError();
        myError.setLocalDate(LocalDate.now());
        myError.setMessage(officeException.getMessage());
        myError.setDescription(webRequest.getDescription(false));
        return new ResponseEntity<>(myError,HttpStatus.BAD_REQUEST);
    }

}
