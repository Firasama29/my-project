package com.project.content.model.project;

import com.project.content.model.common.CommonEntity;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class ProjectRequest extends CommonEntity {

    private String startDate;

    private String updatedDate;

    private String status;

    public ProjectRequest() {}

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
