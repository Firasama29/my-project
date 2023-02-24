package com.project.content.model.blogs;

import java.util.List;

public class BlogsData {

    private Long id;

    private String title;

    private String url;

    private String description;

    private String author;

    private List<String> tags;

    public BlogsData(){}

    public BlogsData(Long id, String title, String url, String description, String author, List<String> tags) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.description = description;
        this.author = author;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public static BlogsDataBuilder builder() {
        return new BlogsDataBuilder();
    }

    public static class BlogsDataBuilder {
        private Long id;
        private String title;
        private String url;
        private String description;
        private String author;
        private List<String> tags;

        public BlogsDataBuilder(){}

        public BlogsDataBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public BlogsDataBuilder title(String title) {
            this.title = title;
            return this;
        }

        public BlogsDataBuilder url(String url) {
            this.url = url;
            return this;
        }

        public BlogsDataBuilder description(String description) {
            this.description = description;
            return this;
        }

        public BlogsDataBuilder author(String author) {
            this.author = author;
            return this;
        }

        public BlogsDataBuilder tags(List<String> tags) {
            this.tags = tags;
            return this;
        }

        public BlogsData build() {
            return new BlogsData(id, title, url, description, author, tags);
        }
    }
}