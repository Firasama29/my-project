package com.project.content.controller;

import com.project.content.model.topics.TopicsData;
import com.project.content.model.topics.TopicsResponse;
import com.project.content.service.TopicsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/topics")
@RequiredArgsConstructor
public class TopicsController {

    private final TopicsService topicsService;

    /** get list of topics */
    @GetMapping
    public ResponseEntity<TopicsResponse> getTopicsList() {
        return ResponseEntity.ok(topicsService.getTopics());
    }

    /** get a topic by id */
    @GetMapping(path = "/id/{id}")
    public ResponseEntity<TopicsData> getTopicById(@PathVariable(name = "id") Long projectId) {
        return ResponseEntity.ok(topicsService.getTopicById(projectId));
    }

    /** get a topic by name */
    @GetMapping(path = "/name/{name}")
    public ResponseEntity<TopicsData> getTopicByName(@PathVariable(name = "name") String topicName) {
        return ResponseEntity.ok(topicsService.getTopicByName(topicName));
    }

    /** get topics by tags */
    @GetMapping(path = "/tags")
    public ResponseEntity<TopicsResponse> getTopicsByTags(@RequestParam(name = "tags") String tags) {
        return ResponseEntity.ok(topicsService.getTopicsByTags(tags));
    }

}