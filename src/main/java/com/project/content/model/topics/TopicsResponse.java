package com.project.content.model.topics;

import java.util.List;

public class TopicsResponse {

    private List<TopicsData> topicsData;

    public TopicsResponse(){}

    public TopicsResponse(List<TopicsData> topicsData){
        this.topicsData = topicsData;
    }

    public List<TopicsData> getTopicsData() {
        return topicsData;
    }

    public void setTopicsData(List<TopicsData> topicsData) {
        this.topicsData = topicsData;
    }

    public static TopicsResponseBuilder builder() {
        return new TopicsResponseBuilder();
    }

    public static class TopicsResponseBuilder {
        private List<TopicsData> topicsData;

        public TopicsResponseBuilder topicsData(List<TopicsData> topicsData) {
            this.topicsData = topicsData;
            return this;
        }

        public TopicsResponse build() {
            return new TopicsResponse(topicsData);
        }
    }
}