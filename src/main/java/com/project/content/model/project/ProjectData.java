package com.project.content.model.project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectData {

    private Long projectId;

    private String project;

    private String description;

    private List<String> tags;

    private LocalDate startDate;

    private LocalDate updatedDate;

    private String status;
}