package com.project.content.model;

import org.springframework.stereotype.Component;

@Component
public class MetaResponse {

    private String message;

    public MetaResponse() {}

    public MetaResponse(String message) {
        this.message = message;
    }

    public String getMessage() { return this.message; }

    public void setMessage(String message) { this.message = message; }

    public static MetaResponseBuilder build() {
        return new MetaResponseBuilder();
    }

    public static class MetaResponseBuilder {
        private String message;

        public MetaResponseBuilder(){}

        public MetaResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public MetaResponse build() {
            return new MetaResponse();
        }
    }
}
