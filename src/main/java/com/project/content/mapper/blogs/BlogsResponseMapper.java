package com.project.content.mapper.blogs;

import com.project.content.entity.BlogsEntity;
import com.project.content.model.blogs.BlogsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BlogsResponseMapper {

    private final BlogsDataMapper blogsDataMapper;

    public BlogsResponse map(List<BlogsEntity> blogsEntities) {
        BlogsResponse blogsResponse = new BlogsResponse();
        blogsResponse.setBlogsData(blogsDataMapper.mapData(blogsEntities));
        return blogsResponse;
    }
}