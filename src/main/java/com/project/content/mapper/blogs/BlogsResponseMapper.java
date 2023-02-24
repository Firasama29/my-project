package com.project.content.mapper.blogs;

import com.project.content.entity.BlogsEntity;
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
        return BlogsResponse.builder()
                .blogsData(blogsDataMapper.mapData(blogsEntities)).build();
    }
}