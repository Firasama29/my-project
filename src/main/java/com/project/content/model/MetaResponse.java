package com.project.content.model;

import org.springframework.stereotype.Component;

@Component
public class MetaResponse {

    private String message;

    public MetaResponse() {}

    public String getMessage() { return this.message; }

    public void setMessage(String message) { this.message = message; }
}
