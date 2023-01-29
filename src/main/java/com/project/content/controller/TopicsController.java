package com.project.content.controller;

import com.project.content.mapper.topic.TopicsResponseMapper;
import com.project.content.model.topics.TopicsData;
import com.project.content.model.topics.TopicsResponse;
import com.project.content.service.TopicsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/topics")
public class TopicsController {

    private TopicsService topicsService;
    private TopicsResponseMapper topicsResponseMapper;

    public TopicsController(TopicsService topicsService, TopicsResponseMapper topicsResponseMapper) {
        this.topicsService = topicsService;
        this.topicsResponseMapper = topicsResponseMapper;
    }

    /** get list of topics */
    @GetMapping
    public ResponseEntity<TopicsResponse> getTopicsList() {
        return ResponseEntity.ok(topicsService.getTags());
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<TopicsData> getTopicById(@PathVariable(name = "id") Long projectId) {
        return ResponseEntity.ok(topicsService.getTopicById(projectId));
    }

    @GetMapping(path = "/name/{name}")
    public ResponseEntity<TopicsData> getTopicByName(@PathVariable(name = "name") String topicName) {
        return ResponseEntity.ok(topicsService.getTopicByName(topicName));
    }

    @GetMapping(path = "/tags")
    public ResponseEntity<TopicsResponse> getTopicsByTags(@RequestParam(name = "tags") String tags) {
        return ResponseEntity.ok(topicsService.getTopicsByTags(tags));
    }

    /** add a new topic */



    /** update a topic */


    /** delete a topic */
}