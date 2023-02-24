package com.project.content.mapper.websites;

import com.project.content.entity.WebsitesEntity;
import com.project.content.model.website.WebsitesRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class WebsitesRequestMapper {

    public WebsitesEntity mapRequest(WebsitesRequest websitesRequest) {
        return WebsitesEntity.builder()
                .id(websitesRequest.getId())
                .title(websitesRequest.getTitle())
                .url(websitesRequest.getUrl())
                .description(StringUtils.abbreviate(websitesRequest.getDescription(), 40))
                .tags(websitesRequest.getTags())
                .build();
    }
}