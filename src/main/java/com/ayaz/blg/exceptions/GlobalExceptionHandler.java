package com.ayaz.blg.exceptions;

  import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ayaz.blg.payloads.ResponseHandler;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	 public ResponseEntity<ResponseHandler> resourceNotFound(ResourceNotFoundException exception){
		String message = exception.getMessage();
		return new ResponseEntity<ResponseHandler>(new ResponseHandler(message , false), HttpStatus.NOT_FOUND);
         
}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	  public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException excepeion){
		     
		       Map<String , String> errrorMessage =new HashMap<>();
		 
		        excepeion.getBindingResult().getAllErrors().forEach((error)-> {
		        	  String fieldName  = ((FieldError)error).getField();
		        	  String message = error.getDefaultMessage();
		        	 
		        	errrorMessage.put(fieldName, message);
		        });
		        return new ResponseEntity<Map<String , String >>(errrorMessage , HttpStatus.BAD_REQUEST);
	  }
}