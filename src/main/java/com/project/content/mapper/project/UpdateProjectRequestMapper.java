package com.project.content.mapper.project;

import com.project.content.entity.ProjectEntity;
import com.project.content.model.project.ProjectRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UpdateProjectRequestMapper {

    public ProjectEntity map(ProjectRequest projectRequest, ProjectEntity existingProjectEntity) {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId(existingProjectEntity.getId());
        projectEntity.setName(projectRequest.getProjectName());
        projectEntity.setDescription(projectRequest.getDescription());
        projectEntity.setStatus(existingProjectEntity.getStatus());
        projectEntity.setStartDate(existingProjectEntity.getStartDate());
        projectEntity.setUpdatedDate(LocalDate.now());
        projectEntity.setEndDate(existingProjectEntity.getEndDate());
        projectEntity.setTags(projectRequest.getTags());
        return projectEntity;
    }

    public ProjectEntity mapStatus(String status, ProjectEntity existingProjectEntity) {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId(existingProjectEntity.getId());
        projectEntity.setStatus(status);
        return projectEntity;
    }

    public ProjectEntity mapEndDate(LocalDate endDate, ProjectEntity existingProjectEntity) {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId(existingProjectEntity.getId());
        projectEntity.setEndDate(endDate);
        return projectEntity;
    }
}