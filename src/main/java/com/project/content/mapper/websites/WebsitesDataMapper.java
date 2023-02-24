package com.project.content.mapper.websites;

import com.project.content.entity.WebsitesEntity;
import com.project.content.model.website.WebsitesData;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.project.content.utils.ContentUtils.getTags;

@Component
public class WebsitesDataMapper {

    public List<WebsitesData> mapData(List<WebsitesEntity> websitesEntities) {
        return websitesEntities.stream().map(this::mapWebsites).collect(Collectors.toList());
    }

    public WebsitesData mapWebsites(WebsitesEntity websitesEntity) {
        return WebsitesData.builder()
                .id(websitesEntity.getId())
                .title(websitesEntity.getTitle())
                .url(websitesEntity.getUrl())
                .description(websitesEntity.getDescription())
                .tags(getTags(websitesEntity.getTags()))
                .build();
    }
}