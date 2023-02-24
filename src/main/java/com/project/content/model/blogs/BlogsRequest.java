package com.project.content.model.blogs;

public class BlogsRequest {
    private Long id;

    private String title;

    private String author;

    private String description;

    private String tags;

    public BlogsRequest() {}

    public BlogsRequest(Long id, String title, String author, String description, String tags) {
        this.id = id;
        this.title = title;
        this.author = author;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public static BlogsRequestBuilder builder() {
        return new BlogsRequestBuilder();
    }

    public static class BlogsRequestBuilder {
        private Long id;
        private String title;
        private String author;
        private String description;
        private String tags;

        public BlogsRequestBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public BlogsRequestBuilder title(String title) {
            this.title = title;
            return this;
        }

        public BlogsRequestBuilder author(String author) {
            this.author = author;
            return this;
        }

        public BlogsRequestBuilder description(String description) {
            this.description = description;
            return this;
        }

        public BlogsRequestBuilder tags(String tags) {
            this.tags = tags;
            return this;
        }

        public BlogsRequest build() {
            return new BlogsRequest(id, title, author, description, tags);
        }
    }
}