package com.example.BookManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Object> handleBookNotFoundException(BookNotFoundException ex) {
        String message = "Unable to find book";
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
}
