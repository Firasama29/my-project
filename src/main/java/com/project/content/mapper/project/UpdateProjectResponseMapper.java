package com.project.content.mapper.project;

import com.project.content.entity.ProjectEntity;
import com.project.content.model.project.UpdateProjectResponse;
import com.project.content.model.project.ProjectData;
import org.springframework.stereotype.Component;

import static com.project.content.constants.ProjectConstants.UPDATE_PROJECT_SUCCESS_MESSAGE;
import static com.project.content.utils.ContentUtils.getTags;

@Component
public class UpdateProjectResponseMapper {

    public UpdateProjectResponse mapUpdateResponse(ProjectEntity existingEntity) {
        UpdateProjectResponse updateProjectResponse = new UpdateProjectResponse();
        updateProjectResponse.setMessage(UPDATE_PROJECT_SUCCESS_MESSAGE);
        updateProjectResponse.setProjectData(this.mapData(existingEntity));
        return updateProjectResponse;
    }

    private ProjectData mapData(ProjectEntity existingEntity) {
        ProjectData projectData = new ProjectData();
        projectData.setProjectId(existingEntity.getId());
        projectData.setProject(existingEntity.getName());
        projectData.setDescription(existingEntity.getDescription());
        projectData.setStatus(existingEntity.getStatus().getName());
        projectData.setStartDate(existingEntity.getStartDate());
        projectData.setUpdatedDate(existingEntity.getUpdatedDate());
        projectData.setTags(getTags(existingEntity.getTags()));
        return projectData;
    }
}