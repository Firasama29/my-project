package com.project.content.mapper.project;

import com.project.content.entity.ProjectEntity;
import com.project.content.model.project.ProjectRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Objects;

import static com.project.content.constants.ProjectConstants.PROJECT_PENDING_STATUS;

@Component
public class PostProjectRequestMapper {

    public ProjectEntity map(ProjectRequest projectRequest) {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId(projectRequest.getProjectId());
        projectEntity.setName(projectRequest.getProjectName());
        projectEntity.setDescription(projectRequest.getDescription());
        projectEntity.setStatus(PROJECT_PENDING_STATUS);
        projectEntity.setStartDate(Objects.nonNull(projectRequest.getStartDate()) ? LocalDate.parse(projectRequest.getStartDate()) : null);
        projectEntity.setTags(projectRequest.getTags());
        return projectEntity;
    }
}