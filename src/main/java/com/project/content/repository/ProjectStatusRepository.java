package com.project.content.repository;

import com.project.content.entity.ProjectStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProjectStatusRepository extends JpaRepository<ProjectStatusEntity, Long> {

    Optional<ProjectStatusEntity> findByName(String statusName);

}