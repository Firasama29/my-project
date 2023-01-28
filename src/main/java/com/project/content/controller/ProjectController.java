package com.project.content.controller;

import com.project.content.model.project.ProjectResponse;
import com.project.content.model.project.ProjectRequest;
import com.project.content.model.project.UpdateProjectResponse;
import com.project.content.model.project.ProjectData;
import com.project.content.model.project.ProjectListResponse;
import com.project.content.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<ProjectListResponse> getProjects() {
        return ResponseEntity.ok(projectService.findProjects());
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<ProjectData> getProjectById(@PathVariable(name = "id") Long projectId) {
        return ResponseEntity.ok(projectService.findProjectById(projectId));
    }

    @GetMapping(path = "/name/{name}")
    public ResponseEntity<ProjectData> getProjectByName(@PathVariable(name = "name") String projectName) {
        return ResponseEntity.ok(projectService.findProjectByName(projectName));
    }

    @GetMapping(path = "/status/{status}")
    public ResponseEntity<ProjectListResponse> getProjectsByStatus(@PathVariable(name = "status") String status) {
        return ResponseEntity.ok(projectService.findProjectsByStatus(status));
    }

    @GetMapping(path = "tags/{tagName}")
    public ResponseEntity<ProjectListResponse> getProjectsByTags(@PathVariable(name = "tagName") String tagName) {
        return ResponseEntity.ok(projectService.findProjectsByTags(tagName));
    }

    @PostMapping
    public ResponseEntity<ProjectResponse> addNewProject(@RequestBody ProjectRequest projectRequest) {
        return ResponseEntity.ok(projectService.addProject(projectRequest));
    }

    @PutMapping
    public ResponseEntity<UpdateProjectResponse> updateProjectDetails(@RequestBody ProjectRequest projectRequest, @RequestParam(name = "id") Long id) {
        return ResponseEntity.ok(projectService.updateProjectDetails(projectRequest, id));
    }

    @DeleteMapping
    public ResponseEntity<ProjectResponse> removeProject(@RequestParam(name = "id") Long projectId) {
        return ResponseEntity.ok(projectService.deleteProject(projectId));
    }
}
