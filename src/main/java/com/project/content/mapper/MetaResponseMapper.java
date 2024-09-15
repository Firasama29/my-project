package com.project.content.mapper;

import com.project.content.model.MetaResponse;
import org.springframework.stereotype.Component;

import static com.project.content.constants.ProjectConstants.POST_PROJECT_SUCCESS_MESSAGE;

@Component
public class MetaResponseMapper {

    public MetaResponse map(String message) {
        MetaResponse metaResponse = new MetaResponse();
        metaResponse.setMessage(message);
        return metaResponse;
    }
}