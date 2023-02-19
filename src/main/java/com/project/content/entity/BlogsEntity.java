package com.project.content.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.content.model.common.WebEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "blogs")
public class BlogsEntity extends WebEntity {

    private String author;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "blogsEntity", fetch = FetchType.EAGER)
    private List<TopicsEntity> topicsEntities;

    public BlogsEntity() {}

    public BlogsEntity(String author, List<TopicsEntity> topicsEntities) {
        this.author = author;
        this.topicsEntities = topicsEntities;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return this.getAuthor();
    }

    public List<TopicsEntity> getTopicsEntities() {
        return topicsEntities;
    }

    public void setTopicsEntities(List<TopicsEntity> topicsEntities) {
        this.topicsEntities = topicsEntities;
    }
}