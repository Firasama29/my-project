package com.project.content.service;

import com.project.content.model.topics.TopicsData;
import com.project.content.model.topics.TopicsResponse;

public interface TopicsService {

    TopicsResponse getTopics();

    TopicsData getTopicById(Long topicId);

    TopicsData getTopicByName(String topicName);

    TopicsResponse getTopicsByTags(String tags);

}