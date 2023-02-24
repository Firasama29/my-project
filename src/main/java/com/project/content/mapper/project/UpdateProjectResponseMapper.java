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
        return UpdateProjectResponse.build()
                .message(UPDATE_PROJECT_SUCCESS_MESSAGE)
                .projectData(this.mapData(existingEntity))
                .build();
    }

    private ProjectData mapData(ProjectEntity existingEntity) {
        return ProjectData.builder()
                .projectId(existingEntity.getId())
                .project(existingEntity.getName())
                .description(existingEntity.getDescription())
                .status(existingEntity.getStatus().getName())
                .startDate(existingEntity.getStartDate())
                .updatedDate(existingEntity.getUpdatedDate())
                .tags(getTags(existingEntity.getTags()))
                .build();
    }
}