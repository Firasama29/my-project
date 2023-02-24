package com.project.content.model.project;

import java.util.List;

public class ProjectListResponse {

    private List<ProjectData> projectData;

    public ProjectListResponse() {}

    public ProjectListResponse(List<ProjectData> projectData) {
        this.projectData = projectData;
    }

    public List<ProjectData> getProjectData() {
        return projectData;
    }

    public void setProjectData(List<ProjectData> projectData) {
        this.projectData = projectData;
    }

    public static ProjectListResponseBuilder builder() {
        return new ProjectListResponseBuilder();
    }

    public static class ProjectListResponseBuilder {
        private List<ProjectData> projectData;

        public ProjectListResponseBuilder projectData(List<ProjectData> projectData) {
            this.projectData = projectData;
            return this;
        }

        public ProjectListResponseBuilder() {}

        public ProjectListResponse build() { return new ProjectListResponse(projectData); }
    }
}
