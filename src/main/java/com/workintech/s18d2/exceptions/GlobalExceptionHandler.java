package com.workintech.s18d2.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<GreenGrocerErrorResponse> exceptionHandler(PlantException exception){
        GreenGrocerErrorResponse response = new GreenGrocerErrorResponse(exception.getMessage(),exception.getStatus(),System.currentTimeMillis());

        return new ResponseEntity<>(response , exception.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<GreenGrocerErrorResponse> exceptionHandler(Exception exception){
        GreenGrocerErrorResponse response = new GreenGrocerErrorResponse(exception.getMessage(),HttpStatus.BAD_REQUEST,System.currentTimeMillis());

        return new ResponseEntity<>(response , HttpStatus.BAD_REQUEST);
    }


}
