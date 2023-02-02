package com.project.content.exception;

public class ResourceAlreadyExistsException extends RuntimeException {

    private String message;

    public ResourceAlreadyExistsException(){}

    public ResourceAlreadyExistsException(String message){ this.message = message; }

    public String getMessage() {
        return this.message = message;
    }
}