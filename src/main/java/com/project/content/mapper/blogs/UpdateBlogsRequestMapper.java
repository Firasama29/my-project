package com.project.content.mapper.blogs;

import com.project.content.entity.BlogsEntity;
import com.project.content.model.blogs.BlogsRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import static com.project.content.utils.ContentUtils.setUrl;

@Component
public class UpdateBlogsRequestMapper {

    public BlogsEntity mapRequest(BlogsRequest blogsRequest, BlogsEntity existingBlogsEntity) {
        BlogsEntity blogsEntity = new BlogsEntity();
        blogsEntity.setId(existingBlogsEntity.getId());
        blogsEntity.setTitle(StringUtils.isNoneBlank(blogsRequest.getTitle()) ? blogsRequest.getTitle() : existingBlogsEntity.getTitle());
        blogsEntity.setUrl(StringUtils.isNoneBlank(blogsRequest.getTitle()) ? setUrl(blogsRequest.getTitle()) : existingBlogsEntity.getUrl());
        blogsEntity.setAuthor(StringUtils.isNoneBlank(blogsRequest.getAuthor()) ? setUrl(blogsRequest.getAuthor()) : existingBlogsEntity.getAuthor());
        blogsEntity.setDescription(StringUtils.isNoneBlank(blogsRequest.getDescription()) ? blogsRequest.getDescription() : existingBlogsEntity.getDescription());
        blogsEntity.setTags(StringUtils.isNoneBlank(blogsRequest.getTags()) ? blogsRequest.getTags() : existingBlogsEntity.getTags());
        return blogsEntity;
    }
}