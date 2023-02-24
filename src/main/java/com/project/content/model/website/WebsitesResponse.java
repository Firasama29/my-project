package com.project.content.model.website;

import java.util.List;

public class WebsitesResponse {

    private List<WebsitesData> websitesData;

    public WebsitesResponse(List<WebsitesData> websitesData) {
        this.websitesData = websitesData;
    }

    public List<WebsitesData> getWebsitesData() {
        return websitesData;
    }

    public void setWebsitesData(List<WebsitesData> websitesData) {
        this.websitesData = websitesData;
    }

    public static WebsitesResponseBuilder builder() {
        return new WebsitesResponseBuilder();
    }

    public static class WebsitesResponseBuilder {
        private List<WebsitesData> websitesData;

        public WebsitesResponseBuilder(){}

        public WebsitesResponseBuilder websitesData(List<WebsitesData> websitesData) {
            this.websitesData = websitesData;
            return this;
        }

        public WebsitesResponse build() {
            return new WebsitesResponse(websitesData);
        }
    }
}