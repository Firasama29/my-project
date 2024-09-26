package com.project.content.entity.topic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "topics")
@IdClass(TopicIdentity.class)
public class TopicsEntity {

    /** to define a composite key */
    @Id
    private Long id;
    @Id
    private String name;

    private String tags;
}