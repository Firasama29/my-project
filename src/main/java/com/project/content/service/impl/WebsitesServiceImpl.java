package com.project.content.service.impl;

import com.project.content.entity.WebsitesEntity;
import com.project.content.exception.ResourceAlreadyExistsException;
import com.project.content.exception.ResourceNotFoundException;
import com.project.content.mapper.MetaResponseMapper;
import com.project.content.mapper.websites.UpdateWebsitesRequestMapper;
import com.project.content.mapper.websites.UpdateWebsitesResponseMapper;
import com.project.content.mapper.websites.WebsitesDataMapper;
import com.project.content.mapper.websites.WebsitesRequestMapper;
import com.project.content.mapper.websites.WebsitesResponseMapper;
import com.project.content.model.MetaResponse;
import com.project.content.model.website.WebsitesData;
import com.project.content.model.website.WebsitesRequest;
import com.project.content.model.website.WebsitesResponse;
import com.project.content.repository.WebsitesRepository;
import com.project.content.service.WebsiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.project.content.constants.ProjectConstants.DELETE_WEBSITE_SUCCESS_MESSAGE;
import static com.project.content.constants.ProjectConstants.EXISTING_WEBSITE_ERROR;
import static com.project.content.constants.ProjectConstants.MISSING_WEBSITE_ERROR;
import static com.project.content.constants.ProjectConstants.POST_WEBSITE_SUCCESS_MESSAGE;

@Service
@RequiredArgsConstructor
public class WebsitesServiceImpl implements WebsiteService {

    private final WebsitesRepository websitesRepository;
    private final WebsitesResponseMapper websitesResponseMapper;
    private final WebsitesDataMapper websitesDataMapper;
    private final MetaResponseMapper metaResponseMapper;
    private final WebsitesRequestMapper websitesRequestMapper;
    private final UpdateWebsitesRequestMapper updateWebsitesRequestMapper;
    private final UpdateWebsitesResponseMapper updateWebsitesResponseMapper;

    @Override
    public WebsitesResponse getListOfWebsites() {
        List<WebsitesEntity> websitesEntities = websitesRepository.findByOrderByTitle();
        return websitesResponseMapper.mapResponse(websitesEntities);
    }

    @Override
    public WebsitesData getWebsiteById(Long id) {
        WebsitesEntity websitesEntity = websitesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MISSING_WEBSITE_ERROR));
        return websitesDataMapper.mapWebsites(websitesEntity);
    }

    @Override
    public WebsitesResponse searchWebsitesByKeyword(String keyword) {
        List<WebsitesEntity> websitesEntities = websitesRepository.findByTitleContaining(keyword);
        if(websitesEntities.isEmpty()) {
            throw new ResourceNotFoundException(MISSING_WEBSITE_ERROR);
        }
        return websitesResponseMapper.mapResponse(websitesEntities);
    }

    @Override
    public WebsitesResponse getWebsitesByTags(String tags) {
        List<WebsitesEntity> websitesEntities = websitesRepository.findByTags(tags);
        if(websitesEntities.isEmpty()) {
            throw new ResourceNotFoundException(MISSING_WEBSITE_ERROR);
        }
        return websitesResponseMapper.mapResponse(websitesEntities);
    }

    @Override
    public MetaResponse addNewWebsites(WebsitesRequest websitesRequest) {
        Optional<WebsitesEntity> websitesEntity = websitesRepository.findById(websitesRequest.getId());
        if(!websitesEntity.isPresent()) {
            websitesRepository.save(websitesRequestMapper.mapRequest(websitesRequest));
        } else {
            throw new ResourceAlreadyExistsException(EXISTING_WEBSITE_ERROR);
        }
        return metaResponseMapper.map(POST_WEBSITE_SUCCESS_MESSAGE);
    }

    @Override
    public WebsitesData updateWebsitesDetails(WebsitesRequest websitesRequest) {
        WebsitesEntity websitesEntity = websitesRepository.findById(websitesRequest.getId()).orElseThrow(() -> new ResourceNotFoundException(MISSING_WEBSITE_ERROR));
        websitesRepository.save(updateWebsitesRequestMapper.mapUpdate(websitesRequest, websitesEntity));
        return updateWebsitesResponseMapper.map(websitesEntity);
    }

    @Override
    public MetaResponse deleteWebsites(Long id) {
        WebsitesEntity websitesEntity = websitesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MISSING_WEBSITE_ERROR));
        websitesRepository.delete(websitesEntity);
        return metaResponseMapper.map(DELETE_WEBSITE_SUCCESS_MESSAGE);
    }
}