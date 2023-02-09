package com.project.content.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "project")
public class ProjectEntity implements Serializable {

    @Id
    private Long id;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private ProjectStatusEntity status;

    private String tags;

    private LocalDate startDate;

    private LocalDate updatedDate;

    private LocalDate endDate;

    public ProjectEntity(){}

    public ProjectEntity(Long id, String name, String description, ProjectStatusEntity status, String tags, LocalDate startDate, LocalDate updatedDate, LocalDate endDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.tags = tags;
        this.startDate = startDate;
        this.updatedDate = updatedDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProjectStatusEntity getStatus() {
        return status;
    }

    public void setStatus(ProjectStatusEntity status) {
        this.status = status;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public static ProjectEntityBuilder builder() {
        return new ProjectEntityBuilder();
    }

    public static class ProjectEntityBuilder {
        private Long id;

        private String name;

        private String description;

        private ProjectStatusEntity status;

        private String tags;

        private LocalDate startDate;

        private LocalDate updatedDate;

        private LocalDate endDate;

        public ProjectEntityBuilder() {}

        public ProjectEntityBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ProjectEntityBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProjectEntityBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ProjectEntityBuilder status(ProjectStatusEntity status) {
            this.status = status;
            return this;
        }

        public ProjectEntityBuilder tags(String tags) {
            this.tags = tags;
            return this;
        }

        public ProjectEntityBuilder startDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public ProjectEntityBuilder updatedDate(LocalDate updatedDate) {
            this.updatedDate = updatedDate;
            return this;
        }

        public ProjectEntityBuilder endDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public ProjectEntity build() {
            return new ProjectEntity(id, name, description, status, tags, startDate, updatedDate, endDate);
        }

        @Override
        public String toString() {
            return "ProjectEntityBuilder{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    ", status=" + status +
                    ", tags='" + tags + '\'' +
                    ", startDate=" + startDate +
                    ", updatedDate=" + updatedDate +
                    ", endDate=" + endDate +
                    '}';
        }
    }
}