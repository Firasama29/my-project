package com.project.content.mapper.topic;

import com.project.content.entity.TopicsEntity;
import com.project.content.model.topics.TopicRequest;
import org.springframework.stereotype.Component;

@Component
public class TopicRequestMapper {

    public TopicsEntity map(TopicRequest topicRequest) {
        return TopicsEntity.builder()
                .id(topicRequest.getId())
                .name(topicRequest.getTopic())
                .tags(topicRequest.getTags())
                .build();
    }
}