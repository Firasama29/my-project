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
        return ProjectEntity.builder()
                .id(existingProjectEntity.getId())
                .name(StringUtils.isNotBlank(projectRequest.getProjectName()) ? projectRequest.getProjectName() : existingProjectEntity.getName())
                .description(StringUtils.isNotBlank(projectRequest.getDescription()) ? projectRequest.getDescription() : existingProjectEntity.getDescription())
                .status(existingProjectEntity.getStatus())
                .startDate(existingProjectEntity.getStartDate())
                .updatedDate(LocalDate.now())
                .endDate(existingProjectEntity.getEndDate())
                .tags(StringUtils.isNotBlank(projectRequest.getTags()) ? projectRequest.getTags() : existingProjectEntity.getTags())
                .build();
    }

    public ProjectEntity mapUpdateStatus(ProjectEntity existingProjectEntity, ProjectStatusEntity projectStatusEntity) {
        return ProjectEntity.builder()
                .id(existingProjectEntity.getId())
                .status(projectStatusEntity)
                .name(existingProjectEntity.getName())
                .description(existingProjectEntity.getDescription())
                .startDate(existingProjectEntity.getStartDate())
                .updatedDate(existingProjectEntity.getUpdatedDate())
                .endDate(existingProjectEntity.getEndDate())
                .tags(existingProjectEntity.getTags())
                .build();
    }
}