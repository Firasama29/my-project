package com.project.content.repository;

import com.project.content.entity.topic.TopicsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicsRepository extends JpaRepository<TopicsEntity, Long> {

    List<TopicsEntity> findByOrderByName();

}
