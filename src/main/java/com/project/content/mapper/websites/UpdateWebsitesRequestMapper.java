package com.project.content.mapper.websites;

import com.project.content.entity.WebsitesEntity;
import com.project.content.model.website.WebsitesRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class UpdateWebsitesRequestMapper {

    public WebsitesEntity mapUpdate(WebsitesRequest websitesRequest, WebsitesEntity existingWebsiteEntity) {
        WebsitesEntity websitesEntity = new WebsitesEntity();
        websitesEntity.setId(existingWebsiteEntity.getId());
        websitesEntity.setTitle(StringUtils.isNotBlank(websitesRequest.getTitle()) ? websitesRequest.getTitle() : existingWebsiteEntity.getTitle());
        websitesEntity.setDescription(StringUtils.isNotBlank(websitesRequest.getDescription()) ? websitesRequest.getDescription() : existingWebsiteEntity.getDescription());
        websitesEntity.setUrl(StringUtils.isNotBlank(websitesRequest.getUrl()) ? websitesRequest.getUrl() : existingWebsiteEntity.getUrl());
        websitesEntity.setTags(StringUtils.isNotBlank(websitesRequest.getTags()) ? websitesRequest.getTags() : existingWebsiteEntity.getTags());
        return websitesEntity;
    }
}