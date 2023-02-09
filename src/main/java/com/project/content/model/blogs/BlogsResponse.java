package com.project.content.model.blogs;

import java.util.List;

public class BlogsResponse {

    private List<BlogsData> blogsData;

    public BlogsResponse(){}

    public BlogsResponse(List<BlogsData> blogsData){
        this.blogsData = blogsData;
    }

    public List<BlogsData> getBlogsData() {
        return this.blogsData;
    }

    public void setBlogsData(List<BlogsData> blogsData) {
        this.blogsData = blogsData;
    }

    public static BlogsResponseBuilder builder() {
        return new BlogsResponseBuilder();
    }

    public static class BlogsResponseBuilder {
        private List<BlogsData> blogsData;

        public BlogsResponseBuilder() {}

        public BlogsResponseBuilder blogsData(List<BlogsData> blogsData) {
            this.blogsData = blogsData;
            return this;
        }

        public BlogsResponse build() {
            return new BlogsResponse(blogsData);
        }
    }
}