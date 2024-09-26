package com.project.content.mapper.blogs;

import com.project.content.entity.BlogsEntity;
import com.project.content.model.blogs.BlogsData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import static com.project.content.utils.ContentUtils.getTags;

@Component
public class UpdateBlogsResponseMapper {

    public BlogsData mapResponse(BlogsEntity blogsEntity) {
        BlogsData blogsData = new BlogsData();
        blogsData.setId(blogsEntity.getId());
        blogsData.setTitle(blogsEntity.getTitle());
        blogsData.setUrl(blogsEntity.getUrl());
        blogsData.setDescription(StringUtils.abbreviate(blogsEntity.getDescription(), 40));
        blogsData.setAuthor(blogsEntity.getAuthor());
        blogsData.setTags(getTags(blogsEntity.getTags()));
        return blogsData;
    }
}