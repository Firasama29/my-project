package com.project.content.mapper.project;

import com.project.content.entity.ProjectEntity;
import com.project.content.entity.ProjectStatusEntity;
import com.project.content.model.project.ProjectRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PostProjectRequestMapper {

    public ProjectEntity mapRequest(ProjectRequest projectRequest, ProjectStatusEntity existingProjectStatusEntity) {
        return ProjectEntity.builder()
                        .id(projectRequest.getProjectId())
                        .name(projectRequest.getProjectName())
                        .description(projectRequest.getDescription())
                        .status(existingProjectStatusEntity)
                        .startDate(LocalDate.now())
                        .tags(projectRequest.getTags())
                        .build();
    }
}