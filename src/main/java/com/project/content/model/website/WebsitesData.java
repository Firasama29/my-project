package com.project.content.model.website;

import java.util.List;

public class WebsitesData {
    private Long id;

    private String title;

    private String url;

    private String description;

    private List<String> tags;

    public WebsitesData() {}

    public WebsitesData(Long id, String title, String url, String description, List<String> tags) {
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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public static WebsitesDataBuilder builder() {
        return new WebsitesDataBuilder();
    }

    public static class WebsitesDataBuilder {
        private Long id;
        private String title;
        private String url;
        private String description;
        private List<String> tags;

        public WebsitesDataBuilder(){}

        public WebsitesDataBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public WebsitesDataBuilder title(String title) {
            this.title = title;
            return this;
        }

        public WebsitesDataBuilder url(String url) {
            this.url = url;
            return this;
        }

        public WebsitesDataBuilder description(String description) {
            this.description = description;
            return this;
        }

        public WebsitesDataBuilder tags(List<String> tags) {
            this.tags = tags;
            return this;
        }

        public WebsitesData build() {
            return new WebsitesData(id, title, url, description, tags);
        }
    }


}