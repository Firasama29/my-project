package com.project.content.model.project;

import org.springframework.stereotype.Component;

@Component
public class ProjectRequest {

    private Long projectId;

    private String projectName;

    private String description;

    private String startDate;

    private String updatedDate;

    private String type;

    private String status;

    private String tags;

    public ProjectRequest() {}

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getUpdateDate() {
        return updatedDate;
    }

    public void setUpdateDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
