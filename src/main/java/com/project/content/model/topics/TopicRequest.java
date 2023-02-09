package com.project.content.model.topics;

import java.util.List;

public class TopicRequest {
    private Long id;
    private String topic;
    private String tags;
    public TopicRequest(){}
    public TopicRequest(Long id, String topic, String tags){
        this.id = id;
        this.topic = topic;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTopic() {
        return topic;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }
    public String getTags() {
        return tags;
    }
    public void setTags(String tags) {
        this.tags = tags;
    }

    public static TopicRequestBuilder builder() {
        return new TopicRequestBuilder();
    }

    public static class TopicRequestBuilder {
        private Long id;
        private String topic;
        private String tags;

        public TopicRequestBuilder(){}
        public TopicRequestBuilder id(Long id) {
            this.id = id;
            return this;
        }
        public TopicRequestBuilder topic(String topic) {
            this.topic = topic;
            return this;
        }
        public TopicRequestBuilder tags(String tags) {
            this.tags = tags;
            return this;
        }
        public TopicRequest build() {
            return new TopicRequest(id, topic, tags);
        }
    }
}