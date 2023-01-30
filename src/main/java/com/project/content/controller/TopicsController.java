package com.project.content.controller;

import com.project.content.model.MetaResponse;
import com.project.content.model.TopicRequest;
import com.project.content.model.topics.TopicsData;
import com.project.content.model.topics.TopicsResponse;
import com.project.content.model.topics.UpdateTopicResponse;
import com.project.content.service.TopicsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/topics")
public class TopicsController {

    private final TopicsService topicsService;

    public TopicsController(TopicsService topicsService) {
        this.topicsService = topicsService;
    }

    /** get list of topics */
    @GetMapping
    public ResponseEntity<TopicsResponse> getTopicsList() {
        return ResponseEntity.ok(topicsService.getTags());
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

    /** add a new topic */
    @PostMapping
    public ResponseEntity<MetaResponse> postTopic(@RequestBody TopicRequest topicRequest) {
        return ResponseEntity.ok(topicsService.addNewTopic(topicRequest));
    }

    /** update a topic */
    @PutMapping
    public ResponseEntity<UpdateTopicResponse> putTopicDetails(@RequestBody TopicRequest topicRequest) {
        return ResponseEntity.ok(topicsService.updateTopicDetails(topicRequest));
    }

    /** delete a topic */
    @DeleteMapping
    public ResponseEntity<MetaResponse> deleteTopic(@RequestParam(name = "id") Long topicId) {
        return ResponseEntity.ok(topicsService.deleteTopic(topicId));
    }
}