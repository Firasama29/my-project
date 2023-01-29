package com.project.content.mapper.project;

import com.project.content.model.project.ProjectResponse;
import org.springframework.stereotype.Component;

import static com.project.content.constants.ProjectConstants.POST_PROJECT_SUCCESS_MESSAGE;

@Component
public class PostProjectResponseMapper {

    public ProjectResponse map() {
        ProjectResponse projectResponse = new ProjectResponse();
        projectResponse.setMessage(POST_PROJECT_SUCCESS_MESSAGE);
        return projectResponse;
    }
}