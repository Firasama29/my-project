package com.project.content.mapper.blogs;

import com.project.content.entity.BlogsEntity;
import com.project.content.model.blogs.BlogsData;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.project.content.utils.ContentUtils.getTags;

@Component
public class BlogsDataMapper {

    public List<BlogsData> mapData(List<BlogsEntity> blogsEntities) {
        return blogsEntities.stream().map(this::mapBlogs).collect(Collectors.toList());
    }

    public BlogsData mapBlogs(BlogsEntity blogsEntity) {
        BlogsData blogsData = new BlogsData();
        blogsData.setId(blogsEntity.getId());
        blogsData.setTitle(blogsEntity.getTitle());
        blogsData.setUrl(blogsEntity.getUrl());
        blogsData.setAuthor(blogsEntity.getAuthor());
        blogsData.setDescription(blogsEntity.getDescription());
        blogsData.setTags(getTags(blogsEntity.getTags()));
        return blogsData;
    }
}