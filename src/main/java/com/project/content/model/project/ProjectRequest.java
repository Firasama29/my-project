package com.project.content.model.project;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class ProjectRequest {

    @JsonProperty
    private Long projectId;

    @JsonProperty
    @NotNull(message = "project name is required")
    private String projectName;

    @JsonProperty
    private String description;

    @JsonProperty
    private String startDate;

    @JsonProperty
    private String updatedDate;

    @JsonProperty
    private String status;

    @JsonProperty
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

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
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

    public static ProjectRequestBuilder builder() {
        return new ProjectRequestBuilder();
    }

    public static class ProjectRequestBuilder {
        private Long projectId;
        private String projectName;
        private String description;
        private String startDate;
        private String updatedDate;
        private String status;
        private String tags;

        public ProjectRequestBuilder() {}
    }
}
