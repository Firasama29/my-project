package com.project.content.service;

import com.project.content.model.MetaResponse;
import com.project.content.model.topics.TopicRequest;
import com.project.content.model.topics.TopicsData;
import com.project.content.model.topics.TopicsResponse;
import com.project.content.model.topics.UpdateTopicResponse;

public interface TopicsService {

    TopicsResponse getTopics();

    TopicsData getTopicById(Long topicId);

    TopicsData getTopicByName(String topicName);

    TopicsResponse getTopicsByTags(String tags);

    MetaResponse addNewTopic(TopicRequest topicRequest);

    UpdateTopicResponse updateTopicDetails(TopicRequest topicRequest);

    MetaResponse deleteTopic(Long topicId);
}