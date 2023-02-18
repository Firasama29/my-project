package com.project.content.model.common;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

@MappedSuperclass
public class CommonEntity extends BaseEntity {

    @Column(name = "title")
    @NotBlank
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "tags")
    @NotBlank
    private String tags;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
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
}