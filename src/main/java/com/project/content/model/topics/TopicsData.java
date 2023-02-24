package com.project.content.model.topics;

import java.util.List;

public class TopicsData {

    private Long id;
    private String topic;
    private List<String> tags;

    public TopicsData() {}

    public TopicsData(Long id, String topic, List<String> tags) {
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
    public List<String> getTags() {
        return tags;
    }
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public static TopicsDataBuilder builder() {
        return new TopicsDataBuilder();
    }

    public static class TopicsDataBuilder {
        private Long id;
        private String topic;
        private List<String> tags;

        public TopicsDataBuilder(){}

        public TopicsDataBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public TopicsDataBuilder topic(String topic) {
            this.topic = topic;
            return this;
        }

        public TopicsDataBuilder tags(List<String> tags) {
            this.tags = tags;
            return this;
        }

        public TopicsData build() {
            return new TopicsData(id, topic, tags);
        }
    }
}