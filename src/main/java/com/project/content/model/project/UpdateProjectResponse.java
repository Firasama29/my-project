package com.project.content.model.project;

import com.project.content.model.project.ProjectData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProjectResponse {

    private String message;

    private ProjectData projectData;
}
