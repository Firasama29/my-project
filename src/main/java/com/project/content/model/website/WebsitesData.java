package com.project.content.model.website;

import com.project.content.model.common.WebEntity;

import java.util.List;

public class WebsitesData extends WebEntity {

    private List<String> tagList;

    public WebsitesData() {}

    public List<String> getTagList() {
        return tagList;
    }

    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }
}