package com.project.content.mapper.topic;

import com.project.content.entity.topic.TopicsEntity;
import com.project.content.model.topics.TopicRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class UpdateTopicRequestMapper {

    public TopicsEntity mapRequest(TopicRequest topicRequest, TopicsEntity existingTopicsEntity) {
        TopicsEntity topicsEntity = new TopicsEntity();
        topicsEntity.setId(existingTopicsEntity.getId());
        topicsEntity.setName(StringUtils.isNotBlank(topicRequest.getTopic()) ? topicRequest.getTopic() : existingTopicsEntity.getName());
        topicsEntity.setTags(StringUtils.isNotBlank(topicRequest.getTags()) ? topicRequest.getTags() : existingTopicsEntity.getTags());
        return topicsEntity;
    }
}