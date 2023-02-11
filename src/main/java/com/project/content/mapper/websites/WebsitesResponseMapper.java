package com.project.content.mapper.websites;

import com.project.content.entity.WebsitesEntity;
import com.project.content.model.website.WebsitesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class WebsitesResponseMapper {
    private final WebsitesDataMapper websitesDataMapper;

    public WebsitesResponse mapResponse(List<WebsitesEntity> websitesEntities) {
        WebsitesResponse websitesResponse = new WebsitesResponse();
        websitesResponse.setWebsitesData(websitesDataMapper.mapData(websitesEntities));
        return websitesResponse;
    }
}