package com.aps.docustream.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;

import com.aps.docustream.responses.ErrorResponse;

@RestControllerAdvice
public class DocustreamGlobalExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorResponse> handleIllegalArgument(IllegalArgumentException e){
		
		ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),"Invalid Arguments", e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		
	}
	
	@ExceptionHandler(IllegalStateException.class)
	public ResponseEntity<ErrorResponse> handleIllegalState(IllegalStateException e){
		
		ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(),"Invalid State", e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGenericState(Exception e){
		
		ErrorResponse error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Invalid State", e.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		
	}
	
	@ExceptionHandler(PayloadSerializationException.class)
	public ResponseEntity<ErrorResponse> handleGenericState(PayloadSerializationException e){
		
		ErrorResponse error = new ErrorResponse(HttpStatus.UNPROCESSABLE_CONTENT.value(),"Payload Serialization failed", e.getMessage());
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(error);
		
	}
	
	
	
	
}
