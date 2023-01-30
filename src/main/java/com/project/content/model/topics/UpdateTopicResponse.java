package com.project.content.model.topics;

public class UpdateTopicResponse {

    private String message;

    private TopicsData topicsData;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TopicsData getTopicsData() {
        return topicsData;
    }

    public void setTopicsData(TopicsData topicsData) {
        this.topicsData = topicsData;
    }
}