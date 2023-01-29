package com.project.content.service;

import com.project.content.entity.TopicsEntity;
import com.project.content.mapper.topic.TopicsResponseMapper;
import com.project.content.model.topics.TopicsData;
import com.project.content.model.topics.TopicsResponse;
import com.project.content.repository.TopicsRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.project.content.constants.ProjectConstants.MISSING_TOPIC_ERROR_MESSAGE;

@Service
public class TopicsService {

    private final TopicsRepository topicsRepository;
    private final TopicsResponseMapper topicsResponseMapper;

    public TopicsService(TopicsRepository topicsRepository, TopicsResponseMapper topicsResponseMapper) {
        this.topicsRepository = topicsRepository;
        this.topicsResponseMapper = topicsResponseMapper;
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

    public TopicsResponse getTopicsByTags(String tags) {
        List<TopicsEntity> topicsEntities = topicsRepository.findByTags(tags);
        TopicsResponse topicsResponse = new TopicsResponse();
        return topicsResponseMapper.mapByTags(topicsEntities);
    }
}