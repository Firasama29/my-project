package com.project.content.controller;

import com.project.content.model.MetaResponse;
import com.project.content.model.project.ProjectRequest;
import com.project.content.model.project.UpdateProjectResponse;
import com.project.content.model.project.ProjectData;
import com.project.content.model.project.ProjectListResponse;
import com.project.content.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    /** get all projects */
    @GetMapping
    public ResponseEntity<ProjectListResponse> getProjects() {
        return ResponseEntity.ok(projectService.findProjects());
    }

    /** get a project by id */
    @GetMapping(path = "/id/{id}")
    public ResponseEntity<ProjectData> getProjectById(@PathVariable(name = "id") Long projectId) {
        return ResponseEntity.ok(projectService.findProjectById(projectId));
    }

    /** get a project by name */
    @GetMapping(path = "/name/{name}")
    public ResponseEntity<ProjectData> getProjectByName(@PathVariable(name = "name") String projectName) {
        return ResponseEntity.ok(projectService.findProjectByName(projectName));
    }

    /** get all projects by status */
    @GetMapping(path = "/status/{status}")
    public ResponseEntity<ProjectListResponse> getProjectsByStatus(@PathVariable(name = "status") String status) {
        return ResponseEntity.ok(projectService.findProjectsByStatus(status));
    }

    /** get all projects by tags */
    @GetMapping(path = "tags/{tagName}")
    public ResponseEntity<ProjectListResponse> getProjectsByTags(@PathVariable(name = "tagName") String tagName) {
        return ResponseEntity.ok(projectService.findProjectsByTags(tagName));
    }

    /** add new projects */
    @PostMapping
    public ResponseEntity<MetaResponse> postProject(@Validated @RequestBody ProjectRequest projectRequest) {
        return ResponseEntity.ok(projectService.addProject(projectRequest));
    }

    /** update a project */
    @PutMapping
    public ResponseEntity<UpdateProjectResponse> putProjectDetails(@RequestBody ProjectRequest projectRequest) {
        return ResponseEntity.ok(projectService.updateProjectDetails(projectRequest));
    }

    /** update project's status */
    @PutMapping(path = "/status")
    public ResponseEntity<UpdateProjectResponse> putProjectStatus(@RequestBody ProjectRequest projectRequest) {
        return ResponseEntity.ok(projectService.updateProjectStatus(projectRequest));
    }

    /** delete a project by id */
    @DeleteMapping
    public ResponseEntity<MetaResponse> removeProject(@RequestParam(name = "id") Long projectId) {
        return ResponseEntity.ok(projectService.deleteProject(projectId));
    }
}