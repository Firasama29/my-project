package com.project.content.mapper.blogs;

import com.project.content.entity.BlogsEntity;
import com.project.content.model.blogs.BlogsRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import static com.project.content.utils.ContentUtils.setUrl;

@Component
public class BlogsRequestMapper {

    public BlogsEntity mapRequest(BlogsRequest blogsRequest) {
        return BlogsEntity.builder()
                .id(blogsRequest.getId())
                .title(blogsRequest.getTitle())
                .url(setUrl(blogsRequest.getTitle()))
                .description(StringUtils.abbreviate(blogsRequest.getDescription(), 50))
                .author(blogsRequest.getAuthor())
                .tags(blogsRequest.getTags())
                .build();
    }
}