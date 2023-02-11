package com.project.content.cache;

import com.project.content.entity.topic.TopicsEntity;
import com.project.content.exception.ResourceNotFoundException;
import com.project.content.repository.TopicsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.project.content.constants.ProjectConstants.MISSING_PROJECT_ERROR;
import static com.project.content.constants.ProjectConstants.MISSING_TOPIC_ERROR;
import static com.project.content.utils.ContentUtils.getTags;

@Service
@RequiredArgsConstructor
public class TopicsCache {

    private final TopicsRepository topicsRepository;

    List<TopicsEntity> topicsEntities = new ArrayList<>();

    @PostConstruct
    public void init() {
        topicsEntities = topicsRepository.findByOrderByName();
    }

    public List<TopicsEntity> getAllTopics() {
        return topicsEntities;
    }

    public TopicsEntity filterTopicsById(Long topicId) {
        return topicsEntities.stream().filter(topic -> topic.getId().equals(topicId)).findFirst().orElseThrow(() -> new ResourceNotFoundException(MISSING_PROJECT_ERROR));
    }

    public TopicsEntity filterTopicByName(String topicName) {
        return topicsEntities.stream().filter(topic -> topic.getName().equals(topicName)).findFirst().orElseThrow(() -> new ResourceNotFoundException(MISSING_TOPIC_ERROR));
    }

    public List<TopicsEntity> filterByTags(String tags) {
        return topicsEntities.stream().filter(topic -> getTags(topic.getTags()).contains(tags)).collect(Collectors.toList());
    }
}