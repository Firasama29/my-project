package com.project.content.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "websites")
public class WebsitesEntity implements Serializable {

    @Id
    private Long id;

    private String url;

    private String title;

    private String description;

    private String tags;

    public WebsitesEntity() {}

    public WebsitesEntity(Long id, String url, String title, String description, String tags) {
        this.id = id;
        this.url = url;
        this.title = title;
        this.description = description;
        this.tags = tags;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id =id;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
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

    @Override
    public String toString() {
        return "Websites{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", description='" + tags + '\'' +
                '}';
    }
}
