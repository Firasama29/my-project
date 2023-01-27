package com.project.content.repository;

import com.project.content.entity.Topics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicsRepository extends JpaRepository<Topics, Long> {
}
