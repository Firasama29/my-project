package com.project.content.mapper.websites;

import com.project.content.entity.WebsitesEntity;
import com.project.content.model.website.WebsitesData;
import org.springframework.stereotype.Component;

import static com.project.content.utils.ContentUtils.getTags;

@Component
public class UpdateWebsitesResponseMapper {

    public WebsitesData map(WebsitesEntity existingWebsiteEntity) {
        WebsitesData websitesData = new WebsitesData();
        websitesData.setId(existingWebsiteEntity.getId());
        websitesData.setTitle(existingWebsiteEntity.getTitle());
        websitesData.setUrl(existingWebsiteEntity.getUrl());
        websitesData.setDescription(existingWebsiteEntity.getDescription());
        websitesData.setTags(getTags(existingWebsiteEntity.getTags()));
        return websitesData;
    }
}