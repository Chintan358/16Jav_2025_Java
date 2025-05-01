package com.example.demo.exception;

public class ResourceNotFoundException extends RuntimeException {
		
	String resourceName;
	String fieldName;
	int id;
	public ResourceNotFoundException(String resourceName, String fieldName, int id) {
		super(String.format("%s with %s  : %s is not found ", resourceName,fieldName,id));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.id = id;
	}
	
	
	
}
