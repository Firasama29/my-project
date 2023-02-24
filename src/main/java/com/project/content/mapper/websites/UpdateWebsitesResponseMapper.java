package com.project.content.mapper.websites;

import com.project.content.entity.WebsitesEntity;
import com.project.content.model.website.WebsitesData;
import org.springframework.stereotype.Component;

import static com.project.content.utils.ContentUtils.getTags;

@Component
public class UpdateWebsitesResponseMapper {

    public WebsitesData map(WebsitesEntity existingWebsiteEntity) {
        return WebsitesData.builder()
                .id(existingWebsiteEntity.getId())
                .title(existingWebsiteEntity.getTitle())
                .url(existingWebsiteEntity.getUrl())
                .description(existingWebsiteEntity.getDescription())
                .tags(getTags(existingWebsiteEntity.getTags()))
                .build();
    }
}