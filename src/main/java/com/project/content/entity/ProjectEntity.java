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
@Table(name = "project")
public class ProjectEntity implements Serializable {

    @Id
    private Long id;

    private String name;

    private String description;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    private List<Tags> tags;

    private String type;

    private String status;

    public ProjectEntity(){}

    public ProjectEntity(Long id, String name, String description, List<Tags> tags, String type, String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.tags = tags;
        this.type = type;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() { return this.description; }

    public void setDescription(String description) { this.description = description; }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Projects{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description'" + description + '\'' +
                ", tags=" + tags +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
