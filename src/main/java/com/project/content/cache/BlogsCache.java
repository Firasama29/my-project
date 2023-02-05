package com.project.content.cache;

import com.project.content.entity.BlogsEntity;
import com.project.content.exception.ResourceNotFoundException;
import com.project.content.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.project.content.constants.ProjectConstants.MISSING_BLOG_ERROR;
import static com.project.content.utils.ContentUtils.getTags;

@Service
@RequiredArgsConstructor
public class BlogsCache {

    private final BlogRepository blogRepository;

    private List<BlogsEntity> blogsEntities = new ArrayList<>();

    @PostConstruct
    @Transactional(readOnly = true)
    public void init() {
        blogsEntities = blogRepository.findByOrderByTitle();
    }

    public List<BlogsEntity> getAllBlogs() {
        return blogsEntities;
    }

    public BlogsEntity filterBlogsById(Long blogId) {
        return blogsEntities.stream().filter(blog -> blog.getId().equals(blogId)).findFirst().orElseThrow(() -> new ResourceNotFoundException(MISSING_BLOG_ERROR));
    }

    public BlogsEntity filterBlogsByTitle(String title) {
        return blogsEntities.stream().filter(blog -> blog.getTitle().equals(title)).findFirst().orElseThrow(() -> new ResourceNotFoundException(MISSING_BLOG_ERROR));
    }

    public BlogsEntity filterBlogsByUrl(String url) {
        return blogsEntities.stream().filter(blog -> blog.getUrl().equals(url)).findFirst().orElseThrow(() -> new ResourceNotFoundException(MISSING_BLOG_ERROR));
    }

    public List<BlogsEntity> filterBlogsByAuthor(String author) {
        return blogsEntities.stream().filter(blog -> blog.getAuthor().equals(author)).collect(Collectors.toList());
    }

    public List<BlogsEntity> filterBlogsByTags(String tags) {
        return blogsEntities.stream().filter(blog -> getTags(blog.getTags()).contains(tags)).collect(Collectors.toList());
    }
}