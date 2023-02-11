package com.project.content.mapper.project;

import com.project.content.entity.ProjectEntity;
import com.project.content.model.project.ProjectData;
import com.project.content.model.project.ProjectListResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.project.content.utils.ContentUtils.getTags;

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
        projectData.setProject(projectEntity.getName());
        projectData.setStatus(projectEntity.getStatus().getName());
        projectData.setTags(Objects.nonNull(projectEntity.getTags()) ? getTags(projectEntity.getTags()) : null);
        return projectData;
    }
}