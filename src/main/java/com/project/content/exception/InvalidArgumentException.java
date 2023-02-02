package com.project.content.exception;

public class InvalidArgumentException extends RuntimeException {

    private String message;

    public InvalidArgumentException(){}
    public InvalidArgumentException(String message){ this.message = message; }

    public String getMessage() {
        return message;
    }
}