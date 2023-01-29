package com.project.content.utils;

import java.util.Arrays;
import java.util.List;

import static com.project.content.constants.ProjectConstants.COMMA;

public class ContentUtils {

    public static List<String> getTags(String tagString) {
        String[] tagsArray = tagString.split(COMMA);
        return Arrays.asList(tagsArray);
    }
}