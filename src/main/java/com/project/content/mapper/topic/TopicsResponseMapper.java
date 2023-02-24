package com.project.content.mapper.topic;

import com.project.content.entity.TopicsEntity;
import com.project.content.model.topics.TopicsData;
import com.project.content.model.topics.TopicsResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.project.content.utils.ContentUtils.getTags;

@Component
public class TopicsResponseMapper {

    public TopicsResponse map(List<TopicsEntity> topicsEntities) {
        return TopicsResponse.builder()
                .topicsData(this.mapData(topicsEntities))
                .build();
    }

    private List<TopicsData> mapData(List<TopicsEntity> topicsEntities) {
        return topicsEntities.stream().map(this::map).collect(Collectors.toList());
    }

    private TopicsData map(TopicsEntity topicsEntity) {
        return TopicsData.builder()
                .id(topicsEntity.getId())
                .topic(topicsEntity.getName())
                .tags(getTags(topicsEntity.getTags()))
                .build();
    }

    public TopicsData mapDataById(TopicsEntity topicsEntity) {
        return TopicsData.builder()
                .id(topicsEntity.getId())
                .topic(topicsEntity.getName())
                .tags(getTags(topicsEntity.getTags()))
                .build();
    }

    public TopicsData mapByName(TopicsEntity topicsEntity) {
        return TopicsData.builder()
                .id(topicsEntity.getId())
                .topic(topicsEntity.getName())
                .tags(getTags(topicsEntity.getTags()))
                .build();
    }

    public TopicsResponse mapByTags(List<TopicsEntity> topicsEntities) {
        return TopicsResponse.builder()
                .topicsData(this.mapDataByTags(topicsEntities))
                .build();
    }

    public List<TopicsData> mapDataByTags(List<TopicsEntity> topicsEntities) {
        return topicsEntities.stream().map(this::mapTopicsByTags).collect(Collectors.toList());
    }

    public TopicsData mapTopicsByTags(TopicsEntity topicsEntity) {
        return TopicsData.builder()
                .id(topicsEntity.getId())
                .topic(topicsEntity.getName())
                .tags(getTags(topicsEntity.getTags()))
                .build();
    }
}