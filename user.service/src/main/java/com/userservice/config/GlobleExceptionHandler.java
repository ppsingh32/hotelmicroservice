package com.userservice.config;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobleExceptionHandler {

//    @ExceptionHandler(DataNotFoundException.class)
//    public ResponseEntity<ErrorMessage> dataNotFoundException(DataNotFoundException ex) {
//        ErrorMessage error = new ErrorMessage();
//        error.setStatus(HttpStatus.NOT_FOUND.value());
//        error.setMessage(ex.getMessage());
//        error.setTimestamp(System.currentTimeMillis());
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorMessage> handleGenericException(Exception ex) {
//        ErrorMessage error = new ErrorMessage();
//        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
//        error.setMessage(ex.getMessage());
//        error.setTimestamp(System.currentTimeMillis());
//        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
