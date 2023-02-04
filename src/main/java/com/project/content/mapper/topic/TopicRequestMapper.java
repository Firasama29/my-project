package com.project.content.mapper.topic;

import com.project.content.entity.TopicsEntity;
import com.project.content.model.topics.TopicRequest;
import org.springframework.stereotype.Component;

@Component
public class TopicRequestMapper {

    public TopicsEntity map(TopicRequest topicRequest) {
        TopicsEntity topicsEntity = new TopicsEntity();
        topicsEntity.setId(topicRequest.getId());
        topicsEntity.setName(topicRequest.getTopic());
        topicsEntity.setTags(topicRequest.getTags());
        return topicsEntity;
    }
}