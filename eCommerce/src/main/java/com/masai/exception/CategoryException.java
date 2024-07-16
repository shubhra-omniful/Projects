package com.masai.exception;

import org.springframework.http.HttpStatus;

public class CategoryException extends Exception{
    public CategoryException(String message){
        super(message);
    }

}
