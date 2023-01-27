package com.project.content.controller;

import com.project.content.model.ProjectResponse;
import com.project.content.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }


    //get all projects
    @GetMapping
    public ResponseEntity<ProjectResponse> getProjects() {
        return ResponseEntity.ok(projectService.findProjects());
    }
}
