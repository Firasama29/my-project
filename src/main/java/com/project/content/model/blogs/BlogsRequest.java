package com.project.content.model.blogs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogsRequest {

    private Long id;

    private String title;

    private String author;

    private String description;

    private String tags;
}