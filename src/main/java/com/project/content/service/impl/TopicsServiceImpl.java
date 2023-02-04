package com.project.content.service.impl;

import com.project.content.cache.TopicsCache;
import com.project.content.entity.TopicsEntity;
import com.project.content.mapper.MetaResponseMapper;
import com.project.content.mapper.topic.TopicRequestMapper;
import com.project.content.mapper.topic.TopicsResponseMapper;
import com.project.content.mapper.topic.UpdateTopicResponseMapper;
import com.project.content.model.topics.TopicRequest;
import com.project.content.model.MetaResponse;
import com.project.content.model.topics.TopicsData;
import com.project.content.model.topics.TopicsResponse;
import com.project.content.model.topics.UpdateTopicResponse;
import com.project.content.repository.TopicsRepository;
import com.project.content.service.TopicsService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.project.content.constants.ProjectConstants.DELETE_TOPIC_SUCCESS_MESSAGE;
import static com.project.content.constants.ProjectConstants.EXISTING_TOPIC_ERROR;
import static com.project.content.constants.ProjectConstants.MISSING_TOPIC_ERROR;
import static com.project.content.constants.ProjectConstants.POST_TOPIC_SUCCESS_MESSAGE;

@Service
public class TopicsServiceImpl implements TopicsService {

    private final TopicsRepository topicsRepository;
    private final TopicsCache topicsCache;
    private final TopicsResponseMapper topicsResponseMapper;
    private final TopicRequestMapper topicRequestMapper;
    private final MetaResponseMapper metaResponseMapper;
    private final UpdateTopicResponseMapper updateTopicResponseMapper;

    public TopicsServiceImpl(TopicsRepository topicsRepository, TopicsCache topicsCache, TopicsResponseMapper topicsResponseMapper, TopicRequestMapper topicRequestMapper, MetaResponseMapper metaResponseMapper,
                             UpdateTopicResponseMapper updateTopicResponseMapper) {
        this.topicsRepository = topicsRepository;
        this.topicsCache = topicsCache;
        this.topicsResponseMapper = topicsResponseMapper;
        this.topicRequestMapper = topicRequestMapper;
        this.metaResponseMapper = metaResponseMapper;
        this.updateTopicResponseMapper = updateTopicResponseMapper;
    }

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

    /** add a new topic */
    @Override
    public MetaResponse addNewTopic(TopicRequest topicRequest) {
        Optional<TopicsEntity> topicsEntity = topicsRepository.findById(topicRequest.getId());
        if(topicsEntity.isPresent()) {
            throw new ServiceException(EXISTING_TOPIC_ERROR);
        }
        topicsRepository.save(topicRequestMapper.map(topicRequest));
        return metaResponseMapper.map(POST_TOPIC_SUCCESS_MESSAGE);
    }

    /** update a topic */
    @Override
    public UpdateTopicResponse updateTopicDetails(TopicRequest topicRequest) {
        Optional<TopicsEntity> topicsEntity = topicsRepository.findById(topicRequest.getId());
        if(topicsEntity.isPresent()) {
            topicsRepository.save(topicRequestMapper.map(topicRequest));
        } else {
            throw new ServiceException(MISSING_TOPIC_ERROR);
        }
        return updateTopicResponseMapper.map(topicsEntity.get());
    }

    /** delete a topic */
    @Override
    public MetaResponse deleteTopic(Long topicId) {
        Optional<TopicsEntity> topicsEntity = topicsRepository.findById(topicId);
        if(!topicsEntity.isPresent()) {
            throw new ServiceException(MISSING_TOPIC_ERROR);
        }
        topicsRepository.deleteById(topicId);
        return metaResponseMapper.map(DELETE_TOPIC_SUCCESS_MESSAGE);
    }
}