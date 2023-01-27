package com.project.content.model;

public class ProjectData {

    private Long projectId;
    private String projectName;

    private String tags;

    private String projectType;

    private String status;

    public ProjectData() {}

    public ProjectData(Long projectId, String projectName, String tags, String projectType, String status) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.tags = tags;
        this.projectType = projectType;
        this.status = status;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
