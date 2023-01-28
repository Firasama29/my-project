package com.project.content.mapper;

import com.project.content.entity.ProjectEntity;
import com.project.content.model.project.ProjectData;
import com.project.content.model.project.ProjectListResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.project.content.constants.ProjectConstants.COMMA;

@Component
public class ProjectStatusMapper {

    public ProjectListResponse map(List<ProjectEntity> projectEntities) {
        ProjectListResponse projectListResponse = new ProjectListResponse();
        projectListResponse.setProjectData(this.mapData(projectEntities));
        return projectListResponse;
    }


    public List<ProjectData> mapData(List<ProjectEntity> projectEntities) {
        return projectEntities.stream().map(this::mapByStatus).collect(Collectors.toList());
    }

    public ProjectData mapByStatus(ProjectEntity projectEntity) {
        ProjectData projectData = new ProjectData();
        projectData.setProjectId(projectEntity.getId());
        projectData.setProjectName(projectEntity.getName());
        projectData.setProjectType(projectEntity.getType());
        projectData.setStatus(projectEntity.getStatus());
        projectData.setStartDate(projectEntity.getStartDate());
        projectData.setEndDate(projectEntity.getEndDate());
        projectData.setTags(Objects.nonNull(projectEntity.getTags()) ? projectEntity.getTags().split(COMMA) : null);
        return projectData;
    }
}
