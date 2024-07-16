package com.masai.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(StudentException.class)
    public ResponseEntity<MyError> studentExceptionHandler(StudentException studentException, WebRequest webRequest){
        MyError myError = new MyError();
        myError.setMessage(studentException.getMessage());
        myError.setDateTime(LocalDateTime.now());
        myError.setDetails(webRequest.getDescription(false));

        return new ResponseEntity<>(myError, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(CourseException.class)
    public ResponseEntity<MyError> courseExceptionHandler(CourseException courseException, WebRequest webRequest){
        MyError myError = new MyError();
        myError.setMessage(courseException.getMessage());
        myError.setDateTime(LocalDateTime.now());
        myError.setDetails(webRequest.getDescription(false));

        return new ResponseEntity<>(myError,HttpStatus.BAD_REQUEST);
    }
}
