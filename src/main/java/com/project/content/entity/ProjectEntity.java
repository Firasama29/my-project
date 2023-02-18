package com.project.content.entity;

import com.project.content.model.common.CommonEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "project")
public class ProjectEntity extends CommonEntity {

    @ManyToOne
    @JoinColumn(name = "status_id")
    private ProjectStatusEntity status;

    private LocalDate startDate;

    private LocalDate updatedDate;

    private LocalDate endDate;

    public ProjectEntity(){}

    public ProjectEntity(ProjectStatusEntity status, LocalDate startDate, LocalDate updatedDate, LocalDate endDate) {
        this.status = status;
        this.startDate = startDate;
        this.updatedDate = updatedDate;
        this.endDate = endDate;
    }

    public ProjectStatusEntity getStatus() {
        return status;
    }

    public void setStatus(ProjectStatusEntity status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "ProjectEntity{" +
                ", status='" + status + '\'' +
                ", startDate=" + startDate +
                ", startDate=" + updatedDate +
                ", endDate=" + endDate +
                '}';
    }
}