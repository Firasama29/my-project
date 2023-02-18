package com.project.content.entity;

import com.project.content.model.common.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "project_status")
public class ProjectStatusEntity extends BaseEntity {

    private String name;

    @OneToMany
    private List<ProjectEntity> projectEntity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProjectEntity> getProjectEntity() {
        return projectEntity;
    }

    public void setProjectEntity(List<ProjectEntity> projectEntity) {
        this.projectEntity = projectEntity;
    }
}