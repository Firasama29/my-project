package com.project.content.mapper.project;

import com.project.content.model.project.ProjectData;
import com.project.content.entity.ProjectEntity;
import com.project.content.model.project.ProjectListResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.project.content.utils.ContentUtils.getTags;

@Component
public class ProjectListMapper {

    /** mapping data here */
    public ProjectListResponse mapResponse(List<ProjectEntity> projectEntities) {
        return ProjectListResponse.builder()
                .projectData(this.mapData(projectEntities))
                .build();
    }

    /** mapping data list to list of entities */
    private List<ProjectData> mapData(List<ProjectEntity> projectEntities) {
        return projectEntities.stream().map(this::mapProject).collect(Collectors.toList());
    }

    /** actual mapping between data object and entity  */
    public ProjectData mapProject(ProjectEntity projectEntity) {
        return ProjectData.builder()
                .projectId(projectEntity.getId())
                .project(projectEntity.getName())
                .description(projectEntity.getDescription())
                .status(projectEntity.getStatus().getName())
                .startDate(projectEntity.getStartDate())
                .updatedDate(projectEntity.getUpdatedDate())
                .endDate(projectEntity.getEndDate())
                .tags(getTags(projectEntity.getTags()))
                .build();
    }
}