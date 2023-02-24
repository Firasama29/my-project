package com.project.content.mapper.blogs;

import com.project.content.entity.BlogsEntity;
import com.project.content.model.blogs.BlogsData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import static com.project.content.utils.ContentUtils.getTags;

@Component
public class UpdateBlogsResponseMapper {

    public BlogsData mapResponse(BlogsEntity blogsEntity) {
        return BlogsData.builder()
            .id(blogsEntity.getId())
            .title(blogsEntity.getTitle())
            .url(blogsEntity.getUrl())
            .description(StringUtils.abbreviate(blogsEntity.getDescription(), 40))
            .author(blogsEntity.getAuthor())
            .tags(getTags(blogsEntity.getTags()))
            .build();
    }
}