package com.project.content.mapper.project;

import com.project.content.model.project.ProjectData;
import com.project.content.entity.ProjectEntity;
import com.project.content.model.project.ProjectListResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.project.content.utils.ContentUtils.getTags;

@Component
public class ProjectListMapper {

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
        projectData.setProject(projectEntity.getName());
        projectData.setDescription(projectEntity.getDescription());
        projectData.setStatus(projectEntity.getStatus().getName());
        projectData.setStartDate(projectEntity.getStartDate());
        projectData.setUpdatedDate(projectEntity.getUpdatedDate());
        projectData.setTags(Objects.nonNull(projectEntity.getTags()) ? getTags(projectEntity.getTags()) : null);
        return projectData;
    }

    /** map Data object to entity to display an object by id in response */
    public ProjectData mapDataById(ProjectEntity projectEntity) {
        ProjectData projectData = new ProjectData();
        projectData.setProjectId(projectEntity.getId());
        projectData.setProject(projectEntity.getName());
        projectData.setDescription(projectEntity.getDescription());
        projectData.setStartDate(projectEntity.getStartDate());
        projectData.setUpdatedDate(projectEntity.getUpdatedDate());
        projectData.setStatus(projectEntity.getStatus().getName());
        projectData.setTags(Objects.nonNull(projectEntity.getTags()) ? getTags(projectEntity.getTags()) : null);
        return projectData;
    }

    /** map Data object to entity to display an object by name in response */
    public ProjectData mapDataByName(ProjectEntity projectEntity) {
        ProjectData projectData = new ProjectData();
        projectData.setProjectId(projectEntity.getId());
        projectData.setProject(projectEntity.getName());
        projectData.setDescription(projectEntity.getDescription());
        projectData.setStatus(projectEntity.getStatus().getName());
        projectData.setStartDate(projectEntity.getStartDate());
        projectData.setUpdatedDate(projectEntity.getUpdatedDate());
        projectData.setTags(Objects.nonNull(projectEntity.getTags()) ? getTags(projectEntity.getTags()) : null);
        return projectData;
    }

    /** map Data object to entity to display an object by id in response */
    public ProjectListResponse mapTagsResponse(List<ProjectEntity> projectEntities) {
        ProjectListResponse projectResponse = new ProjectListResponse();
        projectResponse.setProjectData(this.mapDataByTags(projectEntities));
        return projectResponse;
    }

    private List<ProjectData> mapDataByTags(List<ProjectEntity> projectEntities) {
        return projectEntities.stream().map(this::mapProjectsByTags).collect(Collectors.toList());
    }

    private ProjectData mapProjectsByTags(ProjectEntity projectEntity) {
        ProjectData projectData = new ProjectData();
        projectData.setProjectId(projectEntity.getId());
        projectData.setProject(projectEntity.getName());
        projectData.setDescription(projectEntity.getDescription());
        projectData.setStatus(projectEntity.getStatus().getName());
        projectData.setStartDate(projectEntity.getStartDate());
        projectData.setUpdatedDate(projectEntity.getUpdatedDate());
        projectData.setTags(Objects.nonNull(projectEntity.getTags()) ? getTags(projectEntity.getTags()) : null);
        return projectData;
    }
}