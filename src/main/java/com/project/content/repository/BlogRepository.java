package com.project.content.repository;

import com.project.content.entity.BlogsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<BlogsEntity, Long> {

    List<BlogsEntity> findByOrderByTitle();
}