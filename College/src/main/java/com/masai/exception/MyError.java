package com.masai.exception;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class MyError {
    private LocalDateTime dateTime;
    private String message;
    private String details;
}
