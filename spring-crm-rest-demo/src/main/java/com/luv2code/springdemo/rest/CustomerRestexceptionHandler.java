package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestexceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> hendlerException(CustomerNotFoundException exception){
		CustomerErrorResponse response= new CustomerErrorResponse(HttpStatus.NOT_FOUND.value()
				,exception.getMessage(),System.currentTimeMillis());
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> hendlerException(Exception exception){
		CustomerErrorResponse response= new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value()
				,"enter integer value",System.currentTimeMillis());
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		
	}
	
	
	

}
