package com.project.content.mapper.topic;

import com.project.content.entity.TopicsEntity;
import com.project.content.model.topics.TopicRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class UpdateTopicRequestMapper {

    public TopicsEntity mapRequest(TopicRequest topicRequest, TopicsEntity existingTopicsEntity) {
        return TopicsEntity.builder()
            .id(existingTopicsEntity.getId())
            .name(StringUtils.isNotBlank(topicRequest.getTopic()) ? topicRequest.getTopic() : existingTopicsEntity.getName())
            .tags(StringUtils.isNotBlank(topicRequest.getTags()) ? topicRequest.getTags() : existingTopicsEntity.getTags())
            .build();
    }
}