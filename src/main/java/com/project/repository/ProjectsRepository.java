package com.project.repository;

import com.project.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectsRepository extends JpaRepository<ProjectEntity, Long> {

    public Optional<ProjectEntity> findByName(String name);

    public List<ProjectEntity> findByStatus(String status);

    public List<ProjectEntity> findByTags(String tagName);

}
