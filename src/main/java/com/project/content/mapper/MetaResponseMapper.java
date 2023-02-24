package com.project.content.mapper;

import com.project.content.model.MetaResponse;
import org.springframework.stereotype.Component;

@Component
public class MetaResponseMapper {

    public MetaResponse map(String message) {
        return MetaResponse.build()
                .message(message)
                .build();
    }
}