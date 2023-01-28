package com.project.content.model.project;

import java.util.List;

public class ProjectListResponse {

    private List<ProjectData> projectData;

    public List<ProjectData> getProjectData() {
        return projectData;
    }

    public void setProjectData(List<ProjectData> projectData) {
        this.projectData = projectData;
    }
}
