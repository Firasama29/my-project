package com.project.content.repository;

import com.project.content.entity.BlogsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<BlogsEntity, Long> {
}
