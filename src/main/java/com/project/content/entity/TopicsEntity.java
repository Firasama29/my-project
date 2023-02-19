package com.project.content.entity;

import com.project.content.model.common.CommonEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "topics")
public class TopicsEntity extends CommonEntity {

    @ManyToOne
    @JoinColumn(name = "website_id")
    private WebsitesEntity websitesEntity;

    @ManyToOne
    @JoinColumn(name = "blog_id")
    private BlogsEntity blogsEntity;

    public WebsitesEntity getWebsitesEntity() {
        return websitesEntity;
    }

    public void setWebsitesEntity(WebsitesEntity websitesEntity) {
        this.websitesEntity = websitesEntity;
    }

    public BlogsEntity getBlogsEntity() {
        return blogsEntity;
    }

    public void setBlogsEntity(BlogsEntity blogsEntity) {
        this.blogsEntity = blogsEntity;
    }
}