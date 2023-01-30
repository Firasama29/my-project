package com.project.content.service;

import com.project.content.entity.TopicsEntity;
import com.project.content.mapper.MetaResponseMapper;
import com.project.content.mapper.topic.TopicRequestMapper;
import com.project.content.mapper.topic.TopicsResponseMapper;
import com.project.content.mapper.topic.UpdateTopicResponseMapper;
import com.project.content.model.TopicRequest;
import com.project.content.model.MetaResponse;
import com.project.content.model.topics.TopicsData;
import com.project.content.model.topics.TopicsResponse;
import com.project.content.model.topics.UpdateTopicResponse;
import com.project.content.repository.TopicsRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.project.content.constants.ProjectConstants.DELETE_TOPIC_SUCCESS_MESSAGE;
import static com.project.content.constants.ProjectConstants.EXISTING_TOPIC_ERROR_MESSAGE;
import static com.project.content.constants.ProjectConstants.MISSING_TOPIC_ERROR_MESSAGE;
import static com.project.content.constants.ProjectConstants.POST_TOPIC_SUCCESS_MESSAGE;

@Service
public class TopicsService {

    private final TopicsRepository topicsRepository;
    private final TopicsResponseMapper topicsResponseMapper;
    private final TopicRequestMapper topicRequestMapper;
    private final MetaResponseMapper metaResponseMapper;
    private final UpdateTopicResponseMapper updateTopicResponseMapper;

    public TopicsService(TopicsRepository topicsRepository, TopicsResponseMapper topicsResponseMapper, TopicRequestMapper topicRequestMapper, MetaResponseMapper metaResponseMapper, UpdateTopicResponseMapper updateTopicResponseMapper) {
        this.topicsRepository = topicsRepository;
        this.topicsResponseMapper = topicsResponseMapper;
        this.topicRequestMapper = topicRequestMapper;
        this.metaResponseMapper = metaResponseMapper;
        this.updateTopicResponseMapper = updateTopicResponseMapper;
    }

    /** list all topics */
    public TopicsResponse getTags() {
        return topicsResponseMapper.map(topicsRepository.findAll());
    }

    /** get a topic by id */
    public TopicsData getTopicById(Long topicId) {
        Optional<TopicsEntity> topicsEntity = topicsRepository.findById(topicId);
        if(!topicsEntity.isPresent()) {
            throw new ServiceException(MISSING_TOPIC_ERROR_MESSAGE);
        }
        return topicsResponseMapper.mapDataById(topicsEntity.get());
    }

    /** get a topic by name */
    public TopicsData getTopicByName(String topicName) {
        Optional<TopicsEntity> topicsEntity = topicsRepository.findByName(topicName);
        if(!topicsEntity.isPresent()) {
            throw new ServiceException(MISSING_TOPIC_ERROR_MESSAGE);
        }
        return topicsResponseMapper.mapByName(topicsEntity.get());
    }

    /** get topics by tags */
    public TopicsResponse getTopicsByTags(String tags) {
        List<TopicsEntity> topicsEntities = topicsRepository.findByTags(tags);
        return topicsResponseMapper.mapByTags(topicsEntities);
    }

    /** add a new topic */
    public MetaResponse addNewTopic(TopicRequest topicRequest) {
        Optional<TopicsEntity> topicsEntity = topicsRepository.findById(topicRequest.getId());
        if(topicsEntity.isPresent()) {
            throw new ServiceException(EXISTING_TOPIC_ERROR_MESSAGE);
        }
        topicsRepository.save(topicRequestMapper.map(topicRequest));
        return metaResponseMapper.map(POST_TOPIC_SUCCESS_MESSAGE);
    }

    /** update a topic */
    public UpdateTopicResponse updateTopicDetails(TopicRequest topicRequest) {
        Optional<TopicsEntity> topicsEntity = topicsRepository.findById(topicRequest.getId());
        if(topicsEntity.isPresent()) {
            topicsRepository.save(topicRequestMapper.map(topicRequest));
        } else {
            throw new ServiceException(MISSING_TOPIC_ERROR_MESSAGE);
        }
        return updateTopicResponseMapper.map(topicsEntity.get());
    }

    /** delete a topic */
    public MetaResponse deleteTopic(Long topicId) {
        Optional<TopicsEntity> topicsEntity = topicsRepository.findById(topicId);
        if(!topicsEntity.isPresent()) {
            throw new ServiceException(MISSING_TOPIC_ERROR_MESSAGE);
        }
        topicsRepository.deleteById(topicId);
        return metaResponseMapper.map(DELETE_TOPIC_SUCCESS_MESSAGE);
    }
}