package com.project.content.mapper.websites;

import com.project.content.entity.WebsitesEntity;
import com.project.content.model.website.WebsitesResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WebsitesResponseMapper {
    private final WebsitesDataMapper websitesDataMapper;

    public WebsitesResponseMapper(WebsitesDataMapper websitesDataMapper) {
        this.websitesDataMapper = websitesDataMapper;
    }

    public WebsitesResponse mapResponse(List<WebsitesEntity> websitesEntities) {
        return WebsitesResponse.builder()
                .websitesData(websitesDataMapper.mapData(websitesEntities))
                .build();
    }
}