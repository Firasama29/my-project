package com.project.content.mapper.websites;

import com.project.content.entity.WebsitesEntity;
import com.project.content.model.website.WebsitesRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class WebsitesRequestMapper {

    public WebsitesEntity mapRequest(WebsitesRequest websitesRequest) {
        WebsitesEntity websitesEntity = new WebsitesEntity();
        websitesEntity.setId(websitesRequest.getId());
        websitesEntity.setTitle(websitesRequest.getTitle());
        websitesEntity.setUrl(websitesRequest.getUrl());
        websitesEntity.setDescription(StringUtils.abbreviate(websitesRequest.getDescription(), 40));
        websitesEntity.setTags(websitesRequest.getTags());
        return websitesEntity;
    }
}