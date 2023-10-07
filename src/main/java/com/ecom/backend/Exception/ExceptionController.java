package com.ecom.backend.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorInfo> exceptionHandler(ResourceNotFoundException ex){
		ErrorInfo e=new ErrorInfo();
    	e.setErrorCode(HttpStatus.BAD_REQUEST.value());
    	e.setErrorMessage(ex.getMessage());
    	return new ResponseEntity<>(e,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(Exception.class)
	public String globalExceptionHandler(Exception ex) {
		return ex.getMessage();
	}

}
