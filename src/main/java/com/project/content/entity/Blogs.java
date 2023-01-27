package com.project.content.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "blogs")
public class Blogs implements Serializable {

    @Id
    private Long id;

    private String url;

    private String description;

    private String author;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    private List<Tags> tags;

    public Blogs() {}

    public Blogs(Long id, String url, String description, String author, List<Tags> tags) {
        this.id = id;
        this.url = url;
        this.description = description;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Blogs{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", tags=" + tags +
                '}';
    }
}
