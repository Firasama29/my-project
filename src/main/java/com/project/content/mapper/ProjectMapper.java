package com.project.content.mapper;

import com.project.content.model.ProjectData;
import com.project.content.entity.ProjectEntity;
import com.project.content.model.ProjectResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectMapper {

    //private TagsMapper tagsMapper;

    /** mapping data here */
    public ProjectResponse map(List<ProjectEntity> projectEntities) {
        ProjectResponse projectResponse = new ProjectResponse();
        projectResponse.setProjectData(this.mapData(projectEntities));
        return projectResponse;

    }

    /** mapping data list to list of entities */
    private List<ProjectData> mapData(List<ProjectEntity> projectEntities) {
        return projectEntities.stream().map(this::mapProject).collect(Collectors.toList());
    }

    /** actual mapping between data object and entity  */
    private ProjectData mapProject(ProjectEntity projectEntity) {
        ProjectData projectData = new ProjectData();
        projectData.setProjectId(projectEntity.getId());
        projectData.setProjectName(projectEntity.getName());
        projectData.setProjectType(projectEntity.getDescription());
        projectData.setStatus(projectEntity.getStatus());
        return projectData;
    }
}
