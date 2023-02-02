package com.project.content.constants;

import java.util.Arrays;
import java.util.List;

public class ProjectConstants {

    public static final String POST_PROJECT_SUCCESS_MESSAGE = "Project has been saved successfully!";
    public static final String UPDATE_PROJECT_SUCCESS_MESSAGE = "Project details have been updated successfully!";
    public static final String UPDATE_PROJECT_STATUS_SUCCESS_MESSAGE = "Project details have been updated successfully!";
    public static final String DELETE_PROJECT_SUCCESS_MESSAGE = "Project has been deleted successfully!";

    public static final String POST_TOPIC_SUCCESS_MESSAGE = "Topic has been saved successfully!";
    public static final String UPDATE_TOPIC_SUCCESS_MESSAGE = "Topic details have been updated successfully!";
    public static final String DELETE_TOPIC_SUCCESS_MESSAGE = "Topic has been deleted successfully!";

    public static final String COMMA = ", ";

    public static final String MISSING_PROJECT_ERROR_MESSAGE = "Requested project does not exists";
    public static final String EXISTING_PROJECT_ERROR_MESSAGE = "Requested project already exists";
    public static final String INVALID_STATUS = "Status does not exist!";

    public static final String MISSING_TOPIC_ERROR_MESSAGE = "Requested topic does not exists";
    public static final String EXISTING_TOPIC_ERROR_MESSAGE = "Requested topic already exists";

    public static final String PROJECT_PENDING_STATUS = "pending";
    public static final String PROJECT_IN_PROGRESS_STATUS = "in-progress";

    public static final List<String> COMPLETED_PROJECT_STATUSES = Arrays.asList("completed", "cancelled");
}