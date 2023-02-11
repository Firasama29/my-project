package com.project.content.mapper.topic;

import com.project.content.entity.topic.TopicsEntity;
import com.project.content.model.topics.TopicsData;
import com.project.content.model.topics.TopicsResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.project.content.utils.ContentUtils.getTags;

@Component
public class TopicsResponseMapper {

    public TopicsResponse map(List<TopicsEntity> topicsEntities) {
        TopicsResponse topicsResponse = new TopicsResponse();
        topicsResponse.setTopicsData(this.mapData(topicsEntities));
        return topicsResponse;
    }

    private List<TopicsData> mapData(List<TopicsEntity> topicsEntities) {
        return topicsEntities.stream().map(this::map).collect(Collectors.toList());
    }

    private TopicsData map(TopicsEntity topicsEntity) {
        TopicsData topicsData = new TopicsData();
        topicsData.setId(topicsEntity.getId());
        topicsData.setTopic(topicsEntity.getName());
        topicsData.setTags(getTags(topicsEntity.getTags()));
        return topicsData;
    }

    public TopicsData mapDataById(TopicsEntity topicsEntity) {
        TopicsData topicsData = new TopicsData();
        topicsData.setId(topicsEntity.getId());
        topicsData.setTopic(topicsEntity.getName());
        topicsData.setTags(getTags(topicsEntity.getTags()));
        return topicsData;
    }

    public TopicsData mapByName(TopicsEntity topicsEntity) {
        TopicsData topicsData = new TopicsData();
        topicsData.setId(topicsEntity.getId());
        topicsData.setTopic(topicsEntity.getName());
        topicsData.setTags(getTags(topicsEntity.getTags()));
        return topicsData;
    }

    public TopicsResponse mapByTags(List<TopicsEntity> topicsEntities) {
        TopicsResponse topicsResponse = new TopicsResponse();
        topicsResponse.setTopicsData(this.mapDataByTags(topicsEntities));
        return topicsResponse;
    }

    public List<TopicsData> mapDataByTags(List<TopicsEntity> topicsEntities) {
        return topicsEntities.stream().map(this::mapTopicsByTags).collect(Collectors.toList());
    }

    public TopicsData mapTopicsByTags(TopicsEntity topicsEntity) {
        TopicsData topicsData = new TopicsData();
        topicsData.setId(topicsEntity.getId());
        topicsData.setTopic(topicsEntity.getName());
        topicsData.setTags(getTags(topicsEntity.getTags()));
        return topicsData;
    }
}