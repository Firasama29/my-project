package com.project.content.service;

import com.project.content.entity.ProjectEntity;
import com.project.content.mapper.ProjectMapper;
import com.project.content.model.ProjectResponse;
import org.springframework.stereotype.Service;
import com.project.content.repository.ProjectsRepository;

import java.util.List;

@Service
public class ProjectService {

    private ProjectsRepository projectsRepository;
    private ProjectMapper projectMapper;

    public ProjectService(ProjectsRepository projectsRepository, ProjectMapper projectMapper) {
        this.projectsRepository = projectsRepository;
        this.projectMapper = projectMapper;
    }

    //find projects
    public ProjectResponse findProjects() {
        List<ProjectEntity> projectEntities = projectsRepository.findAll();
        //Project project = !projects.isEmpty() ? projects.stream().findFirst().orElse(null) : new Project();
        return projectMapper.map(projectEntities);
    }

    //find a project by id
    public ProjectEntity findProjectById(Long id) {
        return projectsRepository.findById(id).orElse(null);
    }

    //find a project by name
    public ProjectEntity findProjectByName(String name) {
        return projectsRepository.findByName(name).orElse(null);
    }

    //find by status
    public List<ProjectEntity> findProjectsByStatus(String status) {
        return projectsRepository.findByStatus(status);
    }

    public List<ProjectEntity> findProjectsByTags(String tag) {
        return projectsRepository.findByTags(tag);
    }
}
