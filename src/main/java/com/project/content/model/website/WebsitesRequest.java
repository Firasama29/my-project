package com.project.content.model.website;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WebsitesRequest {

    private Long id;

    private String title;

    private String url;

    private String description;

    private String tags;

}