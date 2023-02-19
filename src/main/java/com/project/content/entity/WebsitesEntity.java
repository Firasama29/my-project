package com.project.content.entity;

import com.project.content.model.common.WebEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "websites")
public class WebsitesEntity extends WebEntity {
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "websitesEntity")
    private List<TopicsEntity> topicsEntities;

    public List<TopicsEntity> getTopicsEntities() {
        return topicsEntities;
    }

    public void setTopicsEntities(List<TopicsEntity> topicsEntities) {
        this.topicsEntities = topicsEntities;
    }
}