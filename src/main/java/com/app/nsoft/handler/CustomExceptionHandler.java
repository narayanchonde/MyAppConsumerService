package com.app.nsoft.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.nsoft.exception.ConsumerNotFoundException;
import com.app.nsoft.payload.response.ErrorMesage;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(ConsumerNotFoundException.class)
	public ResponseEntity<ErrorMesage> handlerCompanyNotFoundException(ConsumerNotFoundException e){
 		
		return  ResponseEntity.internalServerError().body(
				new ErrorMesage(
						new Date().toString(), 
						e.getMessage(), 
						HttpStatus.INTERNAL_SERVER_ERROR.value(), 
						HttpStatus.INTERNAL_SERVER_ERROR.name()
						)
				
				);
	}
}
