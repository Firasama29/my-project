package com.project.content.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "project")
public class ProjectEntity implements Serializable {

    @Id
    private Long id;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private ProjectStatusEntity status;

    private String tags;

    private LocalDate startDate;

    private LocalDate updatedDate;

    private LocalDate endDate;

}