package com.project.content.repository;

import com.project.content.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProjectsRepository extends JpaRepository<ProjectEntity, Long> {

    public Optional<ProjectEntity> findByName(String name);

    @Query(name = "SELECT p FROM project p INNER JOIN project_status ps ON p.status_id = ps.id WHERE ps.name = :status", nativeQuery = true)
    public List<ProjectEntity> findByStatusName(String status);

    public List<ProjectEntity> findByTags(String tagName);

}
