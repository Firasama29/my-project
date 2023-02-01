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

    public ProjectEntity(Long id, String name, String description, String tags, LocalDate startDate, LocalDate updatedDate, LocalDate endDate, ProjectStatusEntity status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.tags = tags;
        this.startDate = startDate;
        this.updatedDate = updatedDate;
        this.endDate = endDate;
        this.status = status;
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

    public String getDescription() { return this.description; }

    public void setDescription(String description) { this.description = description; }

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

    public ProjectStatusEntity getStatus() {
        return status;
    }

    public void setStatus(ProjectStatusEntity status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ProjectEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", tags=" + tags +
                ", startDate=" + startDate +
                ", startDate=" + updatedDate +
                ", endDate=" + endDate +
                '}';
    }
}