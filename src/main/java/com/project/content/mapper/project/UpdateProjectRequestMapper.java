package com.project.content.mapper.project;

import com.project.content.entity.ProjectEntity;
import com.project.content.entity.ProjectStatusEntity;
import com.project.content.model.project.ProjectRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UpdateProjectRequestMapper {

    public ProjectEntity mapUpdate(ProjectRequest projectRequest, ProjectEntity existingProjectEntity) {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId(existingProjectEntity.getId());
        projectEntity.setName(StringUtils.isNotBlank(projectRequest.getProjectName()) ? projectRequest.getProjectName() : existingProjectEntity.getName());
        projectEntity.setDescription(StringUtils.isNotBlank(projectRequest.getDescription()) ? projectRequest.getDescription() : existingProjectEntity.getDescription());
        projectEntity.setStatus(existingProjectEntity.getStatus());
        projectEntity.setStartDate(existingProjectEntity.getStartDate());
        projectEntity.setUpdatedDate(LocalDate.now());
        projectEntity.setEndDate(existingProjectEntity.getEndDate());
        projectEntity.setTags(StringUtils.isNotBlank(projectRequest.getTags()) ? projectRequest.getTags() : existingProjectEntity.getTags());
        return projectEntity;
    }

    public ProjectEntity mapStatus(ProjectEntity existingProjectEntity, ProjectStatusEntity projectStatusEntity) {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId(existingProjectEntity.getId());
        projectEntity.setStatus(projectStatusEntity);
        return projectEntity;
    }

    public ProjectEntity mapEndDate(LocalDate endDate, ProjectEntity existingProjectEntity) {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId(existingProjectEntity.getId());
        projectEntity.setEndDate(endDate);
        return projectEntity;
    }
}