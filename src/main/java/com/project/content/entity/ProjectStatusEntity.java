package com.project.content.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "project_status")
public class ProjectStatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_STATUS")
    @SequenceGenerator(name = "SEQUENCE_STATUS", sequenceName = "sequence_status")
    private Long id;

    private String name;

    @OneToMany
    private List<ProjectEntity> projectEntity;

    public ProjectStatusEntity() {}

    public ProjectStatusEntity(Long id, String name) {
        this.id = id;
        this.name = name;
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

    public static ProjectStatusEntityBuilder builder() {
        return new ProjectStatusEntityBuilder();
    }

    public static class ProjectStatusEntityBuilder {
        private Long id;

        private String name;

        public ProjectStatusEntityBuilder() {}

        public ProjectStatusEntityBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ProjectStatusEntityBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProjectStatusEntity build() {
            return new ProjectStatusEntity();
        }
    }
}