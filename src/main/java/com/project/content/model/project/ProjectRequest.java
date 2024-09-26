package com.project.content.model.project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectRequest {

    private Long projectId;

    @NotNull(message = "project name is required")
    private String projectName;

    private String description;

    private String startDate;

    private String updatedDate;

    private String status;

    private String tags;
}
