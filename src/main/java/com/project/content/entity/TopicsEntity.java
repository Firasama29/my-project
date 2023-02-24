package com.project.content.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "topics")
public class TopicsEntity implements Serializable {

    @Id
    private Long id;

    private String name;

    private String tags;

    public TopicsEntity() {}

    public TopicsEntity(Long id, String name, String tags) {
        this.id = id;
        this.name = name;
        this.tags = tags;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTags() {
        return this.tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public static TopicsEntityBuilder builder() {
        return new TopicsEntityBuilder();
    }

    public static class TopicsEntityBuilder {
        private Long id;
        private String name;
        private String tags;

        public TopicsEntityBuilder() {}

        public TopicsEntityBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public TopicsEntityBuilder name(String name) {
            this.name = name;
            return this;
        }

        public TopicsEntityBuilder tags(String tags) {
            this.tags = tags;
            return this;
        }

        public TopicsEntity build() {
            return new TopicsEntity();
        }

        @Override
        public String toString() {
            return "TopicsEntityBuilder{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", tags='" + tags + '\'' +
                    '}';
        }
    }
}