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
        return ProjectListResponse.builder()
                .projectData(this.mapData(projectEntities))
                .build();
    }


    public List<ProjectData> mapData(List<ProjectEntity> projectEntities) {
        return projectEntities.stream().map(this::mapByStatus).collect(Collectors.toList());
    }

    public ProjectData mapByStatus(ProjectEntity projectEntity) {
        return ProjectData.builder()
                .projectId(projectEntity.getId())
                .project(projectEntity.getName())
                .description(projectEntity.getDescription())
                .status(projectEntity.getStatus().getName())
                .tags(getTags(projectEntity.getTags()))
                .build();
    }
}