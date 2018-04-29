package com.surgeon.eye.exceptions;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandling {
	
	@ExceptionHandler(value =  NotFoundException.class)
    public ResponseEntity<Object> handleNoUserFound(NotFoundException ex) {
        String bodyOfResponse = "No User Found";
        return new ResponseEntity<Object>(bodyOfResponse, HttpStatus.NOT_FOUND);
        
        
        /*( bodyOfResponse, 
          new HttpHeaders(), HttpStatus.NOT_FOUND, request);*/
    }
	
	@ExceptionHandler(value =  IllegalArgumentException.class)
    public ResponseEntity<Object> illegalArgument(IllegalArgumentException ex) {
        String bodyOfResponse = "Illegal Argument";
        return new ResponseEntity<Object>(bodyOfResponse, HttpStatus.BAD_REQUEST);
    }

}
