package com.project.content.model.project;

import com.project.content.model.project.ProjectData;
import org.springframework.stereotype.Component;

@Component
public class UpdateProjectResponse {

    private String message;

    private ProjectData projectData;

    public UpdateProjectResponse() {}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ProjectData getProjectData() {
        return projectData;
    }

    public void setProjectData(ProjectData projectData) {
        this.projectData = projectData;
    }
}
