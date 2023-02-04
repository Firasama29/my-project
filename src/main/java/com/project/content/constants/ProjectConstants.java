package com.project.content.constants;

import java.util.Arrays;
import java.util.List;

public class ProjectConstants {

    public static final String POST_PROJECT_SUCCESS_MESSAGE = "Project has been saved successfully!";
    public static final String UPDATE_PROJECT_SUCCESS_MESSAGE = "Project details have been updated successfully!";
    public static final String DELETE_PROJECT_SUCCESS_MESSAGE = "Project has been deleted successfully!";

    public static final String POST_BLOG_SUCCESS_MESSAGE = "Your blog has been saved successfully!";
    public static final String UPDATE_BLOG_STATUS_SUCCESS_MESSAGE = "Blog details have been updated successfully!";
    public static final String DELETE_BLOG_SUCCESS_MESSAGE = "Blog has been deleted successfully!";

    public static final String POST_TOPIC_SUCCESS_MESSAGE = "Topic has been saved successfully!";
    public static final String UPDATE_TOPIC_SUCCESS_MESSAGE = "Topic details have been updated successfully!";
    public static final String DELETE_TOPIC_SUCCESS_MESSAGE = "Topic has been deleted successfully!";

    public static final String POST_WEBSITE_SUCCESS_MESSAGE = "Website details has been saved successfully!";
    public static final String UPDATE_WEBSITE_SUCCESS_MESSAGE = "Website details have been updated successfully!";
    public static final String DELETE_WEBSITE_SUCCESS_MESSAGE = "Website has been deleted successfully!";

    public static final String COMMA = ", ";
    public static final String DASH_SYMBOL = "-";

    public static final String MISSING_PROJECT_ERROR = "Requested project does not exists";
    public static final String EXISTING_PROJECT_ERROR = "Requested project already exists";

    public static final String MISSING_TOPIC_ERROR = "Requested topic does not exists";
    public static final String EXISTING_TOPIC_ERROR = "Requested topic already exists";

    public static final String MISSING_BLOG_ERROR = "Requested blog does not exists";
    public static final String EXISTING_BLOG_ERROR = "Requested blog already exists";

    public static final String MISSING_WEBSITE_ERROR = "Requested website does not exists";
    public static final String EXISTING_WEBSITE_ERROR = "Requested website already exists";

    public static final String INVALID_STATUS = "Status does not exist!";

    public static final String PROJECT_PENDING_STATUS = "pending";
    public static final String PROJECT_IN_PROGRESS_STATUS = "in-progress";
    public static final List<String> COMPLETED_PROJECT_STATUSES = Arrays.asList("completed", "cancelled");
    public static final String URL_STRING = "https://localhost:8080/api/";
}