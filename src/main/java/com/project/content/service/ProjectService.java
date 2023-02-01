package com.project.content.service;

import com.project.content.entity.ProjectEntity;
import com.project.content.entity.ProjectStatusEntity;
import com.project.content.mapper.project.PostProjectRequestMapper;
import com.project.content.mapper.MetaResponseMapper;
import com.project.content.mapper.project.UpdateProjectRequestMapper;
import com.project.content.mapper.project.UpdateProjectResponseMapper;
import com.project.content.model.MetaResponse;
import com.project.content.mapper.project.ProjectListMapper;
import com.project.content.model.project.ProjectRequest;
import com.project.content.model.project.UpdateProjectResponse;
import com.project.content.model.project.ProjectData;
import com.project.content.model.project.ProjectListResponse;
import com.project.content.repository.ProjectStatusRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.project.content.repository.ProjectsRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.project.content.constants.ProjectConstants.DELETE_PROJECT_SUCCESS_MESSAGE;
import static com.project.content.constants.ProjectConstants.EXISTING_PROJECT_ERROR_MESSAGE;
import static com.project.content.constants.ProjectConstants.INVALID_STATUS;
import static com.project.content.constants.ProjectConstants.MISSING_PROJECT_ERROR_MESSAGE;
import static com.project.content.constants.ProjectConstants.POST_PROJECT_SUCCESS_MESSAGE;
import static com.project.content.constants.ProjectConstants.PROJECT_IN_PROGRESS_STATUS;
import static com.project.content.constants.ProjectConstants.PROJECT_PENDING_STATUS;

@Service
public class ProjectService {

    private final ProjectsRepository projectsRepository;
    private final ProjectStatusRepository projectStatusRepository;
    private final ProjectListMapper projectListMapper;
    private final MetaResponseMapper metaResponseMapper;
    private final PostProjectRequestMapper postProjectRequestMapper;
    private final UpdateProjectRequestMapper updateProjectRequestMapper;
    private final UpdateProjectResponseMapper updateProjectResponseMapper;

    public ProjectService(ProjectsRepository projectsRepository, ProjectStatusRepository projectStatusRepository, ProjectListMapper projectListMapper, MetaResponseMapper metaResponseMapper, PostProjectRequestMapper postProjectRequestMapper,
                          UpdateProjectResponseMapper updateProjectResponseMapper, UpdateProjectRequestMapper updateProjectRequestMapper) {
        this.projectsRepository = projectsRepository;
        this.projectStatusRepository = projectStatusRepository;
        this.projectListMapper = projectListMapper;
        this.metaResponseMapper = metaResponseMapper;
        this.postProjectRequestMapper = postProjectRequestMapper;
        this.updateProjectRequestMapper = updateProjectRequestMapper;
        this.updateProjectResponseMapper = updateProjectResponseMapper;
    }

    /** find projects */
    public ProjectListResponse findProjects() {
        return projectListMapper.map(projectsRepository.findAll());
    }

    /** find a project by id  */
    public ProjectData findProjectById(Long id) {
        Optional<ProjectEntity> projectEntityById = projectsRepository.findById(id);
        if(!projectEntityById.isPresent()) {
            throw new ServiceException(MISSING_PROJECT_ERROR_MESSAGE);
        }
        return projectListMapper.mapDataById(projectEntityById.get());
    }

    /** find a project by name  */
    public ProjectData findProjectByName(String name) {
        ProjectEntity projectEntityByName = projectsRepository.findByName(name).orElse(null);
        return Objects.nonNull(projectEntityByName) ? projectListMapper.mapDataByName(projectEntityByName) : null;
    }

    /** find by status  */
    public ProjectListResponse findProjectsByStatus(String status) {
        List<ProjectEntity> projectEntitiesByStatus = projectsRepository.findByStatusName(status);
        return Objects.nonNull(projectEntitiesByStatus) ? projectListMapper.map(projectEntitiesByStatus) : new ProjectListResponse();
    }

    public ProjectListResponse findProjectsByTags(String tag) {
        List<ProjectEntity> projectsByTags = projectsRepository.findByTags(tag);
        return !projectsByTags.isEmpty() ? projectListMapper.mapTagsResponse(projectsByTags) : new ProjectListResponse();
    }

    public MetaResponse addProject(ProjectRequest projectRequest) {
        Optional<ProjectEntity> projectEntity = projectsRepository.findById(projectRequest.getProjectId());
        Optional<ProjectStatusEntity> projectStatusEntity = projectStatusRepository.findByName(PROJECT_PENDING_STATUS);
        if(!projectStatusEntity.isPresent()) {
            throw new ServiceException(INVALID_STATUS);
        }
        if(!projectEntity.isPresent()) {
            projectsRepository.save(postProjectRequestMapper.map(projectRequest, projectStatusEntity.get()));
        } else {
            throw new ServiceException(EXISTING_PROJECT_ERROR_MESSAGE);
        }
        return metaResponseMapper.map(POST_PROJECT_SUCCESS_MESSAGE);
    }

    public UpdateProjectResponse updateProjectDetails(ProjectRequest projectRequest) {
        ProjectEntity projectEntity = projectsRepository.findById(projectRequest.getProjectId()).orElseThrow(() -> new ServiceException(MISSING_PROJECT_ERROR_MESSAGE));
        ProjectStatusEntity projectStatusEntity = projectStatusRepository.findByName(PROJECT_IN_PROGRESS_STATUS).orElseThrow(() -> new ServiceException(INVALID_STATUS));
        projectEntity.setStatus(projectStatusEntity);
        try {
            projectEntity = projectsRepository.save(updateProjectRequestMapper.mapUpdate(projectRequest, projectEntity));
        } catch(DataIntegrityViolationException e) {
            throw new ServiceException("Error updating project details: " + e.getMessage(), e);
        }
        return updateProjectResponseMapper.mapUpdateResponse(projectRequest, projectEntity);
    }

    public MetaResponse deleteProject(Long projectId) {
        Optional<ProjectEntity> projectEntity = projectsRepository.findById(projectId);
        if(projectEntity.isPresent()) {
            projectsRepository.deleteById(projectId);
        } else {
            throw new ServiceException(MISSING_PROJECT_ERROR_MESSAGE);
        }
        return metaResponseMapper.map(DELETE_PROJECT_SUCCESS_MESSAGE);
    }

    /** update project status */
    public UpdateProjectResponse updateProjectStatus(ProjectRequest projectRequest) {
        UpdateProjectResponse updateProjectResponse = new UpdateProjectResponse();
        Optional<ProjectEntity> projectEntity = projectsRepository.findById(projectRequest.getProjectId());
        Optional<ProjectStatusEntity> projectStatusEntity = projectStatusRepository.findByName(projectRequest.getStatus());
        if(!projectStatusEntity.isPresent()) {
            throw new ServiceException(INVALID_STATUS);
        }
        if(projectEntity.isPresent()) {
            projectsRepository.save(updateProjectRequestMapper.mapStatus(projectEntity.get(), projectStatusEntity.get()));
        } else {
            throw new ServiceException(MISSING_PROJECT_ERROR_MESSAGE);
        }
        return updateProjectResponse;
    }

    /** update project end date */
    public UpdateProjectResponse updateProjectEndDate(String endDate, Long projectId) {
        UpdateProjectResponse updateProjectResponse = new UpdateProjectResponse();
        Optional<ProjectEntity> projectEntity = projectsRepository.findById(projectId);
        if(projectEntity.isPresent()) {
            projectsRepository.save(updateProjectRequestMapper.mapEndDate(LocalDate.parse(endDate), projectEntity.get()));
        } else {
            throw new ServiceException(MISSING_PROJECT_ERROR_MESSAGE);
        }
        return updateProjectResponse;
    }
}