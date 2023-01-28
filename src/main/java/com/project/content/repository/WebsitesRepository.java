package com.project.content.repository;

import com.project.content.entity.WebsitesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebsitesRepository extends JpaRepository<WebsitesEntity, Long> {
}
