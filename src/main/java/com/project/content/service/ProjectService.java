package com.project.content.service;

import com.project.content.entity.ProjectEntity;
import com.project.content.mapper.DeleteProjectResponseMapper;
import com.project.content.mapper.ProjectRequestMapper;
import com.project.content.mapper.PostProjectResponseMapper;
import com.project.content.mapper.UpdateProjectResponseMapper;
import com.project.content.model.project.ProjectResponse;
import com.project.content.mapper.ProjectListMapper;
import com.project.content.model.project.ProjectRequest;
import com.project.content.model.project.UpdateProjectResponse;
import com.project.content.model.project.ProjectData;
import com.project.content.model.project.ProjectListResponse;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import com.project.content.repository.ProjectsRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.project.content.constants.ProjectConstants.COMMA;
import static com.project.content.constants.ProjectConstants.EXISTING_PROJECT_ERROR_MESSAGE;
import static com.project.content.constants.ProjectConstants.MISSING_PROJECT_ERROR_MESSAGE;

@Service
public class ProjectService {

    private final ProjectsRepository projectsRepository;
    private final ProjectListMapper projectListMapper;
    private final PostProjectResponseMapper postProjectResponseMapper;
    private final ProjectRequestMapper projectRequestMapper;
    private final UpdateProjectResponseMapper updateProjectResponseMapper;
    private final DeleteProjectResponseMapper deleteProjectResponseMapper;

    public ProjectService(ProjectsRepository projectsRepository, ProjectListMapper projectListMapper, PostProjectResponseMapper postProjectResponseMapper, ProjectRequestMapper projectRequestMapper,
                          UpdateProjectResponseMapper updateProjectResponseMapper, DeleteProjectResponseMapper deleteProjectResponseMapper) {
        this.projectsRepository = projectsRepository;
        this.projectListMapper = projectListMapper;
        this.postProjectResponseMapper = postProjectResponseMapper;
        this.projectRequestMapper = projectRequestMapper;
        this.updateProjectResponseMapper = updateProjectResponseMapper;
        this.deleteProjectResponseMapper = deleteProjectResponseMapper;
    }

    /** find projects */
    public ProjectListResponse findProjects() {
        List<ProjectEntity> projectEntities = projectsRepository.findAll();
        //Project project = !projects.isEmpty() ? projects.stream().findFirst().orElse(null) : new Project();
        return projectListMapper.map(projectEntities);
    }

    /** find a project by id  */
    public ProjectData findProjectById(Long id) {
        ProjectEntity projectEntityById = projectsRepository.findById(id).orElse(null);
        return Objects.nonNull(projectEntityById) ? projectListMapper.mapDataById(projectEntityById) : null;
    }

    /** find a project by name  */
    public ProjectData findProjectByName(String name) {
        ProjectEntity projectEntityByName = projectsRepository.findByName(name).orElse(null);
        return Objects.nonNull(projectEntityByName) ? projectListMapper.mapDataByName(projectEntityByName) : null;
    }

    /** find by status  */
    public ProjectListResponse findProjectsByStatus(String status) {
        List<ProjectEntity> projectEntitiesByStatus = projectsRepository.findByStatus(status);
        return Objects.nonNull(projectEntitiesByStatus) ? projectListMapper.map(projectEntitiesByStatus) : new ProjectListResponse();
    }

    public ProjectListResponse findProjectsByTags(String tag) {
        List<ProjectEntity> projectsByTags = projectsRepository.findByTags(tag);
        return !projectsByTags.isEmpty() ? projectListMapper.mapTagsResponse(projectsByTags) : new ProjectListResponse();
    }

    public ProjectResponse addProject(ProjectRequest projectRequest) {
        Optional<ProjectEntity> projectEntity = projectsRepository.findById(projectRequest.getProjectId());
        if(!projectEntity.isPresent()) {
            projectsRepository.save(projectRequestMapper.map(projectRequest));
        } else {
            throw new ServiceException(EXISTING_PROJECT_ERROR_MESSAGE);
        }
        return postProjectResponseMapper.map();
    }

    public UpdateProjectResponse updateProjectDetails(ProjectRequest projectRequest, Long projectId) {
        Optional<ProjectEntity> projectEntity = projectsRepository.findById(projectId);
        if(projectEntity.isPresent()) {
            projectsRepository.save(projectRequestMapper.map(projectRequest));
        } else {
            throw new ServiceException(MISSING_PROJECT_ERROR_MESSAGE);
        }
        return updateProjectResponseMapper.map(projectRequest);
    }

    public ProjectResponse deleteProject(Long projectId) {
        Optional<ProjectEntity> projectEntity = projectsRepository.findById(projectId);
        if(projectEntity.isPresent()) {
            projectsRepository.deleteById(projectId);
        } else {
            throw new ServiceException(MISSING_PROJECT_ERROR_MESSAGE);
        }
        return deleteProjectResponseMapper.map();
    }
}