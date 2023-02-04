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
}