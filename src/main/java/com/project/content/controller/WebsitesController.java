package com.project.content.controller;

import com.project.content.model.MetaResponse;
import com.project.content.model.website.WebsitesData;
import com.project.content.model.website.WebsitesRequest;
import com.project.content.model.website.WebsitesResponse;
import com.project.content.service.WebsiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/websites")
@RequiredArgsConstructor
public class WebsitesController {

    private final WebsiteService websiteService;

    @GetMapping
    public ResponseEntity<WebsitesResponse> getWebsites() {
        return ResponseEntity.ok(websiteService.getListOfWebsites());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<WebsitesData> getWebsiteById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(websiteService.getWebsiteById(id));
    }

    @GetMapping(path = "/keyword")
    public ResponseEntity<WebsitesResponse> getWebsiteByKeyword(@RequestParam(name = "keyword") String keyword) {
        return ResponseEntity.ok(websiteService.searchWebsitesByKeyword(keyword));
    }

    @GetMapping(path = "/tags")
    public ResponseEntity<WebsitesResponse> getWebsitesByTags(@RequestParam(name = "tags") String tags) {
        return ResponseEntity.ok(websiteService.getWebsitesByTags(tags));
    }

    @PostMapping
    public ResponseEntity<MetaResponse> postWebsites(@RequestBody @Validated WebsitesRequest websitesRequest) {
        return ResponseEntity.ok(websiteService.addNewWebsites(websitesRequest));
    }

    @PutMapping
    public ResponseEntity<WebsitesData> putWebsiteDetails(@RequestBody @Validated WebsitesRequest websitesRequest) {
        return ResponseEntity.ok(websiteService.updateWebsitesDetails(websitesRequest));
    }

    @DeleteMapping
    public ResponseEntity<MetaResponse> deleteWebsite(@RequestParam(name = "id") Long id) {
        return ResponseEntity.ok(websiteService.deleteWebsites(id));
    }
}