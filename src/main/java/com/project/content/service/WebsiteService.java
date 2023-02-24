package com.project.content.service;

import com.project.content.model.MetaResponse;
import com.project.content.model.website.WebsitesData;
import com.project.content.model.website.WebsitesRequest;
import com.project.content.model.website.WebsitesResponse;

public interface WebsiteService {

    WebsitesResponse getListOfWebsites();

    WebsitesData getWebsiteById(Long id);

    WebsitesResponse searchWebsitesByKeyword(String keyword);

    WebsitesResponse getWebsitesByTags(String tags);

    MetaResponse addNewWebsites(WebsitesRequest websitesRequest);

    WebsitesData updateWebsitesDetails(WebsitesRequest websitesRequest);

    MetaResponse deleteWebsites(Long id);
}