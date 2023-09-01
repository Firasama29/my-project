package com.project.content.repository;

import com.project.content.entity.ProjectStatusEntity;
import com.project.content.entity.topic.TopicIdentity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectStatusRepository extends JpaRepository<ProjectStatusEntity, TopicIdentity> {

    Optional<ProjectStatusEntity> findByName(String statusName);

}