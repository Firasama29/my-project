package com.project.content.service.impl;

import com.project.content.cache.TopicsCache;
import com.project.content.entity.topic.TopicsEntity;
import com.project.content.mapper.topic.TopicsResponseMapper;
import com.project.content.model.topics.TopicsData;
import com.project.content.model.topics.TopicsResponse;
import com.project.content.repository.TopicsRepository;
import com.project.content.service.TopicsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicsServiceImpl implements TopicsService {

    private final TopicsRepository topicsRepository;
    private final TopicsCache topicsCache;
    private final TopicsResponseMapper topicsResponseMapper;

    /** list all topics */
    @Override
    public TopicsResponse getTopics() {
        return topicsResponseMapper.map(topicsCache.getAllTopics());
    }

    /** get a topic by id */
    @Override
    public TopicsData getTopicById(Long topicId) {
        TopicsEntity topicsEntity = topicsCache.filterTopicsById(topicId);
        return topicsResponseMapper.mapDataById(topicsEntity);
    }

    /** get topics by tags */
    @Override
    public TopicsResponse getTopicsByTags(String tags) {
        List<TopicsEntity> topicsEntities = topicsCache.filterByTags(tags);
        return topicsResponseMapper.mapByTags(topicsEntities);
    }

    /** get a topic by name */
    @Override
    public TopicsData getTopicByName(String topicName) {
        TopicsEntity topicsEntity = topicsCache.filterTopicByName(topicName);
        return topicsResponseMapper.mapByName(topicsEntity);
    }
}