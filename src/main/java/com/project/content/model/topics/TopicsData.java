package com.project.content.model.topics;

import com.project.content.model.common.CommonEntity;

import java.util.List;

public class TopicsData extends CommonEntity {

    private List<String> tagList;

    public List<String> getTagList() {
        return tagList;
    }

    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }
}