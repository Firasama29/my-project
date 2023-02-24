package com.project.content.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "websites")
public class WebsitesEntity implements Serializable {

    @Id
    private Long id;

    private String title;

    private String url;

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

    public static WebsitesEntityBuilder builder() {
        return new WebsitesEntityBuilder();
    }

    public static class WebsitesEntityBuilder {
        private Long id;
        private String title;
        private String url;
        private String description;
        private String tags;

        public WebsitesEntityBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public WebsitesEntityBuilder title(String title) {
            this.title = title;
            return this;
        }

        public WebsitesEntityBuilder url(String url) {
            this.url = url;
            return this;
        }

        public WebsitesEntityBuilder description(String description) {
            this.description = description;
            return this;
        }

        public WebsitesEntityBuilder tags(String tags) {
            this.tags = tags;
            return this;
        }

        public WebsitesEntity build() {
            return new WebsitesEntity();
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
}