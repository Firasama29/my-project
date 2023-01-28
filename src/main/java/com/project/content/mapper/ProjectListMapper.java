package com.project.content.mapper;

import com.project.content.model.project.ProjectData;
import com.project.content.entity.ProjectEntity;
import com.project.content.model.project.ProjectListResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.project.content.constants.ProjectConstants.COMMA;

@Component
public class ProjectListMapper {

    //private TagsMapper tagsMapper;

    /** mapping data here */
    public ProjectListResponse map(List<ProjectEntity> projectEntities) {
        ProjectListResponse projectListResponse = new ProjectListResponse();
        projectListResponse.setProjectData(this.mapData(projectEntities));
        return projectListResponse;
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
        projectData.setStartDate(projectEntity.getStartDate());
        projectData.setEndDate(projectEntity.getEndDate());
        projectData.setTags(Objects.nonNull(projectEntity.getTags()) ? projectEntity.getTags().split(COMMA) : null);
        return projectData;
    }

    /** map Data object to entity to display an object by id in response */
    public ProjectData mapDataById(ProjectEntity projectEntity) {
        ProjectData projectData = new ProjectData();
        projectData.setProjectId(projectEntity.getId());
        projectData.setProjectName(projectEntity.getName());
        projectData.setProjectType(projectEntity.getDescription());
        projectData.setStatus(projectEntity.getStatus());
        projectData.setStartDate(projectEntity.getStartDate());
        projectData.setEndDate(projectEntity.getEndDate());
        projectData.setTags(Objects.nonNull(projectEntity.getTags()) ? projectEntity.getTags().split(COMMA) : null);
        return projectData;
    }

    /** map Data object to entity to display an object by name in response */
    public ProjectData mapDataByName(ProjectEntity projectEntity) {
        ProjectData projectData = new ProjectData();
        projectData.setProjectId(projectEntity.getId());
        projectData.setProjectName(projectEntity.getName());
        projectData.setProjectType(projectEntity.getDescription());
        projectData.setStatus(projectEntity.getStatus());
        projectData.setStartDate(projectEntity.getStartDate());
        projectData.setEndDate(projectEntity.getEndDate());
        projectData.setTags(Objects.nonNull(projectEntity.getTags()) ? projectEntity.getTags().split(COMMA) : null);
        return projectData;
    }

    /** map Data object to entity to display an object by id in response */
    public ProjectListResponse mapTagsResponse(List<ProjectEntity> projectEntities) {
        ProjectListResponse projectResponse = new ProjectListResponse();
        projectResponse.setProjectData(this.mapDataByStatus(projectEntities));
        return projectResponse;
    }
//
    private List<ProjectData> mapDataByStatus(List<ProjectEntity> projectEntities) {
        return projectEntities.stream().map(this::mapProjectsByTags).collect(Collectors.toList());
    }

    private ProjectData mapProjectsByTags(ProjectEntity projectEntity) {
        ProjectData projectData = new ProjectData();
        projectData.setProjectId(projectEntity.getId());
        projectData.setProjectName(projectEntity.getName());
        projectData.setDescription(projectEntity.getDescription());
        projectData.setProjectType(projectEntity.getType());
        projectData.setStatus(projectEntity.getStatus());
        projectData.setStartDate(projectEntity.getStartDate());
        projectData.setUpdatedDate(projectEntity.getUpdatedDate());
        projectData.setEndDate(projectEntity.getEndDate());
        projectData.setTags(Objects.nonNull(projectEntity.getTags()) ? projectEntity.getTags().split(COMMA) : null);
        return projectData;
    }
}
