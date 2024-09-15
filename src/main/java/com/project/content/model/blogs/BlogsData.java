package com.project.content.model.blogs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogsData {

    private Long id;

    private String title;

    private String url;

    private String description;

    private String author;

    private List<String> tags;
}