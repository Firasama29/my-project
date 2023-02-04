package com.project.content.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "blogs")
public class BlogsEntity implements Serializable {

    @Id
    private Long id;

    private String title;

    private String url;

    private String description;

    private String author;

    private String tags;

    public BlogsEntity() {}

    public BlogsEntity(Long id, String title, String url, String description, String author, String tags) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.description = description;
        this.author = author;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Blogs{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", tags=" + tags +
                '}';
    }
}
