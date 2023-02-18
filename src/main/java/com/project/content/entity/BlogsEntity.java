package com.project.content.entity;

import com.project.content.model.common.WebEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "blogs")
public class BlogsEntity extends WebEntity {

    private String author;

    public BlogsEntity() {}

    public BlogsEntity(String author) {
        this.author = author;
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
}