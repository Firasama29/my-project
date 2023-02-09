package com.project.content.model.topics;

public class UpdateTopicResponse {

    private String message;

    private TopicsData topicsData;

    public UpdateTopicResponse() {}

    public UpdateTopicResponse(String message, TopicsData topicsData) {
        this.message = message;
        this.topicsData = topicsData;
    }

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

    public static UpdateTopicResponseBuilder builder() {
        return new UpdateTopicResponseBuilder();
    }

    public static class UpdateTopicResponseBuilder {
        private String message;
        private TopicsData topicsData;

        public UpdateTopicResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public UpdateTopicResponseBuilder topicsData(TopicsData topicsData) {
            this.topicsData = topicsData;
            return this;
        }

        public UpdateTopicResponse build() {
            return new UpdateTopicResponse(message, topicsData);
        }
    }
}