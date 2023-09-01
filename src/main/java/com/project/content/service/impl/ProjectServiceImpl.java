package com.project.content.service.impl;

import com.project.content.entity.ProjectEntity;
import com.project.content.entity.ProjectStatusEntity;
import com.project.content.exception.InvalidArgumentException;
import com.project.content.exception.ResourceAlreadyExistsException;
import com.project.content.exception.ResourceNotFoundException;
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
import com.project.content.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.project.content.repository.ProjectsRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.project.content.constants.ProjectConstants.COMPLETED_PROJECT_STATUSES;
import static com.project.content.constants.ProjectConstants.DELETE_PROJECT_SUCCESS_MESSAGE;
import static com.project.content.constants.ProjectConstants.EXISTING_PROJECT_ERROR;
import static com.project.content.constants.ProjectConstants.INVALID_STATUS;
import static com.project.content.constants.ProjectConstants.MISSING_PROJECT_ERROR;
import static com.project.content.constants.ProjectConstants.POST_PROJECT_SUCCESS_MESSAGE;
import static com.project.content.constants.ProjectConstants.PROJECT_IN_PROGRESS_STATUS;
import static com.project.content.constants.ProjectConstants.PROJECT_PENDING_STATUS;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectsRepository projectsRepository;
    private final ProjectStatusRepository projectStatusRepository;
    private final ProjectListMapper projectListMapper;
    private final MetaResponseMapper metaResponseMapper;
    private final PostProjectRequestMapper postProjectRequestMapper;
    private final UpdateProjectRequestMapper updateProjectRequestMapper;
    private final UpdateProjectResponseMapper updateProjectResponseMapper;

    Logger log = LoggerFactory.getLogger(ProjectServiceImpl.class);

    /** find projects */
    @Override
    public ProjectListResponse findProjects() {
        return projectListMapper.mapResponse(projectsRepository.findByOrderByName());
    }

    /** find a project by id  */
    @Override
    public ProjectData findProjectById(Long id) {
        ProjectEntity projectEntity = projectsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MISSING_PROJECT_ERROR));
        return projectListMapper.mapProject(projectEntity);
    }

    /** find a project by name  */
    @Override
    public ProjectData findProjectByName(String name) {
        ProjectEntity projectEntityByName = projectsRepository.findByName(name).orElseThrow(() -> new ResourceNotFoundException(MISSING_PROJECT_ERROR));
        return projectListMapper.mapProject(projectEntityByName);
    }

    /** find by status  */
    @Override
    public ProjectListResponse findProjectsByStatus(String status) {
        List<ProjectEntity> projectEntitiesByStatus = projectsRepository.findByStatusName(status);
        return Objects.nonNull(projectEntitiesByStatus) ? projectListMapper.mapResponse(projectEntitiesByStatus) : new ProjectListResponse();
    }

    /** find by tags  */
    @Override
    public ProjectListResponse findProjectsByTags(String tag) {
        List<ProjectEntity> projectsByTags = projectsRepository.findByTags(tag);
        if(projectsByTags.isEmpty()) {
            throw new ResourceNotFoundException(MISSING_PROJECT_ERROR);
        }
        return projectListMapper.mapResponse(projectsByTags);
    }

    /** add a new project  */
    @Override
    public MetaResponse addProject(ProjectRequest projectRequest) {
        Optional<ProjectEntity> projectEntity = projectsRepository.findById(projectRequest.getProjectId());
        ProjectStatusEntity projectStatusEntity = projectStatusRepository.findByName(PROJECT_PENDING_STATUS).orElseThrow(() -> new InvalidArgumentException(INVALID_STATUS));
        if(!projectEntity.isPresent()) {
            projectsRepository.save(postProjectRequestMapper.mapRequest(projectRequest, projectStatusEntity));
        } else {
            throw new ResourceAlreadyExistsException(EXISTING_PROJECT_ERROR);
        }
        return metaResponseMapper.map(POST_PROJECT_SUCCESS_MESSAGE);
    }

    /** update project */
    @Override
    public UpdateProjectResponse updateProjectDetails(ProjectRequest projectRequest, Long projectId) {
        ProjectEntity projectEntity = projectsRepository.findById(projectId).orElseThrow(() -> new ResourceNotFoundException(MISSING_PROJECT_ERROR));
        ProjectStatusEntity projectStatusEntity = projectStatusRepository.findByName(PROJECT_IN_PROGRESS_STATUS).orElseThrow(() -> new InvalidArgumentException(INVALID_STATUS));
        projectEntity.setStatus(projectStatusEntity);
        try {
            projectEntity = projectsRepository.save(updateProjectRequestMapper.mapUpdate(projectRequest, projectEntity));
        } catch(DataIntegrityViolationException e) {
            throw new ServiceException("Error updating project details: " + e.getMessage(), e);
        }
        return updateProjectResponseMapper.mapUpdateResponse(projectEntity);
    }

    /** update project status */
    @Override
    public UpdateProjectResponse updateProjectStatus(ProjectRequest projectRequest, Long projectId) {
        ProjectEntity projectEntity = projectsRepository.findById(projectId).orElseThrow(() -> new ResourceAlreadyExistsException(MISSING_PROJECT_ERROR));
        ProjectStatusEntity projectStatusEntity = projectStatusRepository.findByName(projectRequest.getStatus()).orElseThrow(() -> new InvalidArgumentException(INVALID_STATUS));
        if(COMPLETED_PROJECT_STATUSES.contains(projectRequest.getStatus())) {
            projectEntity.setEndDate(LocalDate.now());
        }
        projectsRepository.save(updateProjectRequestMapper.mapUpdateStatus(projectEntity, projectStatusEntity));
        return updateProjectResponseMapper.mapUpdateResponse(projectEntity);
    }

    /** delete a project */
    @Override
    public MetaResponse deleteProject(Long projectId) {
        ProjectEntity projectEntity = projectsRepository.findById(projectId).orElseThrow(() -> new ResourceNotFoundException(MISSING_PROJECT_ERROR));
        projectsRepository.delete(projectEntity);
        return metaResponseMapper.map(DELETE_PROJECT_SUCCESS_MESSAGE);
    }
}