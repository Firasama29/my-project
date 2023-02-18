package com.project.content.model.common;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class WebEntity extends CommonEntity {

    @Column(name = "url")
    @NotBlank
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}