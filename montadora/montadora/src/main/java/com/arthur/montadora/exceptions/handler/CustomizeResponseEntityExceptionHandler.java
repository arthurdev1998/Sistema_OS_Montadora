package com.arthur.montadora.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.arthur.montadora.exceptions.ExceptionResponse;
import com.arthur.montadora.exceptions.ResourcesNotFoundException;



@ControllerAdvice
@RestController
	public class CustomizeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ResourcesNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleNotFoundExceptions(Exception ex, WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false) );
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);		
	}
	
	
	// Exceções para argumentos inválidos:
	
	public final ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request){
	String message = "";
	for(ObjectError error: ex.getBindingResult().getAllErrors()) {
	message = message + error.getDefaultMessage()+  "\n";	
	}
	
	return handleExceptionInternal(ex,message,headers,status,request);
		
	}
	
	

	
	
	
	

}
