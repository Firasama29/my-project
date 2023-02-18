package com.project.content.model.blogs;

import com.project.content.model.common.WebEntity;

import java.util.List;

public class BlogsData extends WebEntity {

    private String author;

    private List<String> tagList;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getTagList() {
        return tagList;
    }

    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }
}