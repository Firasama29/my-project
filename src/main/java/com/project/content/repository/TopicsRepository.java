package com.project.content.repository;

import com.project.content.entity.TopicsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicsRepository extends JpaRepository<TopicsEntity, Long> {
}
