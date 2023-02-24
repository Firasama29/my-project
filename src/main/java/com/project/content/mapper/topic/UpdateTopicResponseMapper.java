package com.project.content.mapper.topic;

import com.project.content.entity.TopicsEntity;
import com.project.content.model.topics.TopicsData;
import com.project.content.model.topics.UpdateTopicResponse;
import org.springframework.stereotype.Component;

import static com.project.content.constants.ProjectConstants.UPDATE_TOPIC_SUCCESS_MESSAGE;
import static com.project.content.utils.ContentUtils.getTags;

@Component
public class UpdateTopicResponseMapper {

    public UpdateTopicResponse map(TopicsEntity topicsEntity) {
        return UpdateTopicResponse.builder()
            .message(UPDATE_TOPIC_SUCCESS_MESSAGE)
            .topicsData(this.mapData(topicsEntity))
            .build();
    }

    private TopicsData mapData(TopicsEntity topicsEntity) {
        return TopicsData.builder()
            .id(topicsEntity.getId())
            .topic(topicsEntity.getName())
            .tags(getTags(topicsEntity.getTags()))
            .build();
    }
}
