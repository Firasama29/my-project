package com.project.content.exception;

public class ContentErrorResponse {

    private int status;

    private String errorMessage;

    public ContentErrorResponse(){}

    public ContentErrorResponse(int status, String errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
    }

    public int getStatus() {
        return status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}