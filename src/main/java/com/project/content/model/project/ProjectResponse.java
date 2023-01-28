package com.project.content.model.project;

import org.springframework.stereotype.Component;

@Component
public class ProjectResponse {

    private String message;

    public ProjectResponse() {}


    public String getMessage() { return this.message; }

    public void setMessage(String message) { this.message = message; }

}
