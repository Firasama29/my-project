package com.project.content.mapper;

import com.project.content.model.project.ProjectResponse;
import org.springframework.stereotype.Component;

import static com.project.content.constants.ProjectConstants.DELETE_PROJECT_SUCCESS_MESSAGE;

@Component
public class DeleteProjectResponseMapper {

    public ProjectResponse map() {
        ProjectResponse projectResponse = new ProjectResponse();
        projectResponse.setMessage(DELETE_PROJECT_SUCCESS_MESSAGE);
        return projectResponse;
    }
}
