package com.project.content.repository;

import com.project.content.entity.Blogs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blogs, Long> {
}
