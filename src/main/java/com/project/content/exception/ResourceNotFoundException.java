package com.project.content.exception;

public class ResourceNotFoundException extends RuntimeException {

    private String message;

    public ResourceNotFoundException(){}

    public ResourceNotFoundException(String message){ this.message = message; }

    public String getMessage() {
        return this.message = message;
    }
}