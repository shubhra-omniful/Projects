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
    public ResponseEntity<MyError> categoryExceptionHandler(CategoryException categoryException, WebRequest webRequest){

        MyError myError = new MyError();
        myError.setLocalDate(LocalDate.now());
        myError.setMessage(categoryException.getMessage());
        myError.setDetails(webRequest.getDescription(false));

        return new ResponseEntity<>(myError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<MyError> productExceptionHandler(ProductException productException, WebRequest webRequest){

        MyError myError = new MyError();
        myError.setLocalDate(LocalDate.now());
        myError.setMessage(productException.getMessage());
        myError.setDetails(webRequest.getDescription(false));

        return new ResponseEntity<>(myError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<MyError> imageExceptionHandler(ImageException imageException, WebRequest webRequest){

        MyError myError = new MyError();
        myError.setLocalDate(LocalDate.now());
        myError.setMessage(imageException.getMessage());
        myError.setDetails(webRequest.getDescription(false));

        return new ResponseEntity<>(myError, HttpStatus.BAD_REQUEST);
    }

}
