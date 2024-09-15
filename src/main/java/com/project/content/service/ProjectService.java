package com.project.content.service;

import com.project.content.model.MetaResponse;
import com.project.content.model.project.ProjectData;
import com.project.content.model.project.ProjectListResponse;
import com.project.content.model.project.ProjectRequest;
import com.project.content.model.project.UpdateProjectResponse;

public interface ProjectService {

    ProjectListResponse findProjects();

    ProjectData findProjectById(Long id);

    ProjectData findProjectByName(String name);

    ProjectListResponse findProjectsByStatus(String status);

    ProjectListResponse findProjectsByTags(String tag);

    MetaResponse addProject(ProjectRequest projectRequest);

    UpdateProjectResponse updateProjectDetails(ProjectRequest projectRequest);

    UpdateProjectResponse updateProjectStatus(ProjectRequest projectRequest);

    MetaResponse deleteProject(Long projectId);
}