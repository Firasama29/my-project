package com.project.content.mapper;

import com.project.content.entity.ProjectEntity;
import com.project.content.model.project.ProjectRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ProjectRequestMapper {

    public ProjectEntity map(ProjectRequest projectRequest) {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId(projectRequest.getProjectId());
        projectEntity.setName(projectRequest.getProjectName());
        projectEntity.setDescription(projectRequest.getDescription());
        projectEntity.setType(projectRequest.getType());
        projectEntity.setStatus(projectRequest.getStatus());
        projectEntity.setStartDate(LocalDate.parse(projectRequest.getStartDate()));
        projectEntity.setTags(projectRequest.getTags());
        return projectEntity;
    }

}
