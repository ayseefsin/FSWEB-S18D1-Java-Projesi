package com.workintech.sp18d1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<BurgerErrorResponse> handleBurgerException(BurgerException burgerException){
        BurgerErrorResponse burgerErrorResponse = new BurgerErrorResponse(burgerException.getMessage(),burgerException.getHttpStatus(),System.currentTimeMillis());
        return new ResponseEntity<>(burgerErrorResponse,burgerErrorResponse.getStatus());
    }
    @ExceptionHandler
    public ResponseEntity<BurgerErrorResponse> handleUnknownException(Exception exception){
        BurgerErrorResponse burgerErrorResponse = new BurgerErrorResponse(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, System.currentTimeMillis());
        return  new ResponseEntity<>(burgerErrorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
