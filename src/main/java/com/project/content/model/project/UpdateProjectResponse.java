package com.project.content.model.project;

import com.project.content.model.project.ProjectData;
import org.springframework.stereotype.Component;

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

    public static UpdateProjectResponseBuilder build() {
        return new UpdateProjectResponseBuilder();
    }

    public static class UpdateProjectResponseBuilder {
        private String message;
        private ProjectData projectData;

        public UpdateProjectResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public UpdateProjectResponseBuilder projectData(ProjectData projectData) {
            this.projectData = projectData;
            return this;
        }

        public UpdateProjectResponse build() {
            return new UpdateProjectResponse();
        }
    }
}
