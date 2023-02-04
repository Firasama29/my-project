package com.project.content.mapper.blogs;

import com.project.content.entity.BlogsEntity;
import com.project.content.model.blogs.BlogsData;
import com.project.content.model.blogs.BlogsResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlogsResponseMapper {

    private final BlogsDataMapper blogsDataMapper;

    public BlogsResponseMapper(BlogsDataMapper blogsDataMapper) {
        this.blogsDataMapper = blogsDataMapper;
    }

    public BlogsResponse map(List<BlogsEntity> blogsEntities) {
        BlogsResponse blogsResponse = new BlogsResponse();
        blogsResponse.setBlogsData(blogsDataMapper.mapData(blogsEntities));
        return blogsResponse;
    }
}