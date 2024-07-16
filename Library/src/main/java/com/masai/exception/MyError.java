package com.masai.exception;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MyError {
    private LocalDate localDate;
    private String message;
    private String details;

}
