package com.abu.MovieBookingApp.Exception;/*
 *Created by Abuthair
 * Date:18/09/2023
 * time:19:15
 *projectName:MovieBookingApp

 */


import com.abu.MovieBookingApp.payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {


    //Handle Global Exception
    //Handle Specific Exception

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobleException(Exception exception , WebRequest webRequest ){
        ErrorDetails details = new ErrorDetails(new Date(), exception.getMessage(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(details ,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
