package com.project.repository;

import com.project.entity.Websites;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebsitesRepository extends JpaRepository<Websites, Long> {
}
