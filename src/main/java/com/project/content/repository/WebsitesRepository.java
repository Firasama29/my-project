package com.project.content.repository;

import com.project.content.entity.WebsitesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WebsitesRepository extends JpaRepository<WebsitesEntity, Long> {

    List<WebsitesEntity> findByOrderByTitle();

    List<WebsitesEntity> findByTitleContaining(String keyword);

    List<WebsitesEntity> findByTags(String tags);
}