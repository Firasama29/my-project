package com.project.content.mapper.project;

import com.project.content.model.MetaResponse;
import org.springframework.stereotype.Component;

import static com.project.content.constants.ProjectConstants.DELETE_PROJECT_SUCCESS_MESSAGE;

@Component
public class DeleteProjectResponseMapper {

    public MetaResponse map() {
        MetaResponse metaResponse = new MetaResponse();
        metaResponse.setMessage(DELETE_PROJECT_SUCCESS_MESSAGE);
        return metaResponse;
    }
}