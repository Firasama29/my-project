package com.project.content.mapper.blogs;

import com.project.content.entity.BlogsEntity;
import com.project.content.model.blogs.BlogsRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import static com.project.content.utils.ContentUtils.setUrl;

@Component
public class BlogsRequestMapper {

    public BlogsEntity mapRequest(BlogsRequest blogsRequest) {
        BlogsEntity blogsEntity = new BlogsEntity();
        blogsEntity.setId(blogsRequest.getId());
        blogsEntity.setTitle(blogsRequest.getTitle());
        blogsEntity.setUrl(setUrl(blogsRequest.getTitle()));
        blogsEntity.setDescription(StringUtils.abbreviate(blogsRequest.getDescription(), 50));
        blogsEntity.setAuthor(blogsRequest.getAuthor());
        blogsEntity.setTags(blogsRequest.getTags());
        return blogsEntity;
    }
}