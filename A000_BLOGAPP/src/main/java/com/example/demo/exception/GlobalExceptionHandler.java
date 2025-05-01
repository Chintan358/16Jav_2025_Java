package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.payload.APIResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(exception = ResourceNotFoundException.class)
	public ResponseEntity<APIResponse> ResourceNotFoundExceptionHandler(ResourceNotFoundException e)
	{
		String message = e.getMessage();
		String success = "false";
		APIResponse response = new APIResponse(message,success);
		
		return new ResponseEntity<APIResponse>(response,HttpStatus.NOT_FOUND);
	}
}
