package com.project.content.mapper.topic;

import com.project.content.entity.topic.TopicsEntity;
import com.project.content.model.topics.TopicsData;
import com.project.content.model.topics.UpdateTopicResponse;
import org.springframework.stereotype.Component;

import static com.project.content.constants.ProjectConstants.UPDATE_TOPIC_SUCCESS_MESSAGE;
import static com.project.content.utils.ContentUtils.getTags;

@Component
public class UpdateTopicResponseMapper {

    public UpdateTopicResponse map(TopicsEntity topicsEntity) {
        UpdateTopicResponse updateTopicResponse = new UpdateTopicResponse();
        updateTopicResponse.setMessage(UPDATE_TOPIC_SUCCESS_MESSAGE);
        updateTopicResponse.setTopicsData(this.mapData(topicsEntity));
        return updateTopicResponse;
    }

    private TopicsData mapData(TopicsEntity topicsEntity) {
        TopicsData topicsData = new TopicsData();
        topicsData.setId(topicsEntity.getId());
        topicsData.setTopic(topicsEntity.getName());
        topicsData.setTags(getTags(topicsEntity.getTags()));
        return topicsData;
    }
}
