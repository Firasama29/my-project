package com.project.content.model.project;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.content.entity.ProjectStatusEntity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class ProjectData {

    @JsonProperty
    private Long projectId;

    @JsonProperty
    private String project;

    @JsonProperty
    private String description;

    @JsonProperty
    private String status;

    @JsonProperty
    private List<String> tags;

    @JsonProperty
    private LocalDate startDate;

    @JsonProperty
    private LocalDate updatedDate;

    public ProjectData() {}

    public ProjectData(Long projectId, String project, String description, String status, List<String> tags, LocalDate startDate, LocalDate updatedDate) {
        this.projectId = projectId;
        this.project = project;
        this.description = description;
        this.status = status;
        this.tags = tags;
        this.startDate = startDate;
        this.updatedDate = updatedDate;
    }

    public static ProjectDataBuilder builder() {
        return new ProjectDataBuilder();
    }

    public static class ProjectDataBuilder {
        private Long projectId;

        private String project;

        private String description;

        private String status;

        private List<String> tags;

        private LocalDate startDate;

        private LocalDate updatedDate;

        private LocalDate endDate;

        public ProjectDataBuilder() {}

        public ProjectDataBuilder projectId(Long projectId) {
            this.projectId = projectId;
            return this;
        }
        public ProjectDataBuilder project(String project) {
            this.project = project;
            return this;
        }

        public ProjectDataBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ProjectDataBuilder status(String status) {
            this.status = status;
            return this;
        }

        public ProjectDataBuilder tags(List<String> tags) {
            this.tags = tags;
            return this;
        }

        public ProjectDataBuilder startDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public ProjectDataBuilder updatedDate(LocalDate updatedDate) {
            this.updatedDate = updatedDate;
            return this;
        }

        public ProjectDataBuilder endDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public ProjectData build() {
            return new ProjectData(projectId, project, description, status, tags, startDate, updatedDate);
        }

        @Override
        public String toString() {
            return "ProjectDataBuilder{" +
                    "projectId=" + projectId +
                    ", project='" + project + '\'' +
                    ", description='" + description + '\'' +
                    ", status='" + status + '\'' +
                    ", tags=" + tags +
                    ", startDate=" + startDate +
                    ", updatedDate=" + updatedDate +
                    '}';
        }
    }
}