package com.project.content.model.project;

import com.project.content.model.common.CommonEntity;

import java.time.LocalDate;
import java.util.List;

public class ProjectData extends CommonEntity {

    private List<String> tagList;

    private LocalDate startDate;

    private LocalDate updatedDate;

    private String status;

    public ProjectData() {}


    public List<String> getTagList() {
        return tagList;
    }

    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}