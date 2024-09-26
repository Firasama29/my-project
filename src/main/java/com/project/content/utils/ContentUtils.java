package com.project.content.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

import static com.project.content.constants.ProjectConstants.COMMA;
import static com.project.content.constants.ProjectConstants.DASH_SYMBOL;
import static com.project.content.constants.ProjectConstants.URL_STRING;

public class ContentUtils {

    public static List<String> getTags(String tagString) {
        String[] tagsArray = tagString.split(COMMA);
        return Arrays.asList(tagsArray);
    }

    public static String setUrl(String title) {
        return StringUtils.join(URL_STRING, title).replaceAll("\\s", DASH_SYMBOL);
    }
}