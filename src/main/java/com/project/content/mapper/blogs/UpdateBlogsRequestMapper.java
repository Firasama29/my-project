package com.project.content.mapper.blogs;

import com.project.content.entity.BlogsEntity;
import com.project.content.model.blogs.BlogsRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import static com.project.content.utils.ContentUtils.setUrl;

@Component
public class UpdateBlogsRequestMapper {

    public BlogsEntity mapRequest(BlogsRequest blogsRequest, BlogsEntity existingBlogsEntity) {
        return BlogsEntity.builder()
        .id(existingBlogsEntity.getId())
        .title(StringUtils.isNoneBlank(blogsRequest.getTitle()) ? blogsRequest.getTitle() : existingBlogsEntity.getTitle())
        .url(StringUtils.isNoneBlank(blogsRequest.getTitle()) ? setUrl(blogsRequest.getTitle()) : existingBlogsEntity.getUrl())
        .author(StringUtils.isNoneBlank(blogsRequest.getAuthor()) ? setUrl(blogsRequest.getAuthor()) : existingBlogsEntity.getAuthor())
        .description(StringUtils.isNoneBlank(blogsRequest.getDescription()) ? blogsRequest.getDescription() : existingBlogsEntity.getDescription())
        .tags(StringUtils.isNoneBlank(blogsRequest.getTags()) ? blogsRequest.getTags() : existingBlogsEntity.getTags())
        .build();
    }
}