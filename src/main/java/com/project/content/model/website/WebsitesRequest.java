package com.project.content.model.website;

public class WebsitesRequest {
    private Long id;

    private String title;

    private String url;

    private String description;

    private String tags;

    public WebsitesRequest(Long id, String title, String url, String description, String tags) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.description = description;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public static WebsitesRequestBuilder builder() {
        return new WebsitesRequestBuilder();
    }

    public static class WebsitesRequestBuilder {
        private Long id;
        private String title;
        private String url;
        private String description;
        private String tags;

        public WebsitesRequestBuilder() {}

        public WebsitesRequestBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public WebsitesRequestBuilder title(String title) {
            this.title = title;
            return this;
        }

        public WebsitesRequestBuilder url(String url) {
            this.url = url;
            return this;
        }

        public WebsitesRequestBuilder description(String description) {
            this.description = description;
            return this;
        }

        public WebsitesRequestBuilder tags(String tags) {
            this.tags = tags;
            return this;
        }

        public WebsitesRequest build() {
            return new WebsitesRequest(id, title, url, description, tags);
        }
    }
}