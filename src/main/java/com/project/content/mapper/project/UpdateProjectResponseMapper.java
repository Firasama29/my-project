package com.project.content.mapper.project;

import com.project.content.model.project.ProjectRequest;
import com.project.content.model.project.UpdateProjectResponse;
import com.project.content.model.project.ProjectData;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static com.project.content.constants.ProjectConstants.UPDATE_PROJECT_SUCCESS_MESSAGE;

@Component
public class UpdateProjectResponseMapper {

    public UpdateProjectResponse map(ProjectRequest projectRequest) {
        UpdateProjectResponse updateProjectResponse = new UpdateProjectResponse();
        updateProjectResponse.setMessage(UPDATE_PROJECT_SUCCESS_MESSAGE);
        updateProjectResponse.setProjectData(this.mapData(projectRequest));
        return updateProjectResponse;
    }


    private ProjectData mapData(ProjectRequest projectRequest) {
        ProjectData projectData = new ProjectData();
        projectData.setProjectName(projectRequest.getProjectName());
        projectData.setDescription(projectRequest.getDescription());
        projectData.setProjectType(projectRequest.getType());
        projectData.setStatus(projectRequest.getStatus());
        projectData.setUpdatedDate(LocalDate.parse(projectRequest.getUpdateDate()));
        return projectData;
    }
}