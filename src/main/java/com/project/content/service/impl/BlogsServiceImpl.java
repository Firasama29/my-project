package com.project.content.service.impl;

import com.project.content.cache.BlogsCache;
import com.project.content.entity.BlogsEntity;
import com.project.content.exception.ResourceAlreadyExistsException;
import com.project.content.exception.ResourceNotFoundException;
import com.project.content.mapper.MetaResponseMapper;
import com.project.content.mapper.blogs.BlogsDataMapper;
import com.project.content.mapper.blogs.BlogsResponseMapper;
import com.project.content.mapper.blogs.UpdateBlogsRequestMapper;
import com.project.content.mapper.blogs.UpdateBlogsResponseMapper;
import com.project.content.model.MetaResponse;
import com.project.content.model.blogs.BlogsData;
import com.project.content.model.blogs.BlogsRequest;
import com.project.content.mapper.blogs.BlogsRequestMapper;
import com.project.content.model.blogs.BlogsResponse;
import com.project.content.repository.BlogRepository;
import com.project.content.service.BlogsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.project.content.constants.ProjectConstants.DELETE_TOPIC_SUCCESS_MESSAGE;
import static com.project.content.constants.ProjectConstants.EXISTING_BLOG_ERROR;
import static com.project.content.constants.ProjectConstants.MISSING_BLOG_ERROR;
import static com.project.content.constants.ProjectConstants.POST_BLOG_SUCCESS_MESSAGE;

@Service
@RequiredArgsConstructor
public class BlogsServiceImpl implements BlogsService {

    private final BlogRepository blogRepository;
    private final BlogsCache blogsCache;
    private final BlogsResponseMapper blogsResponseMapper;
    private final BlogsDataMapper blogsDataMapper;
    private final MetaResponseMapper metaResponseMapper;
    private final BlogsRequestMapper blogsRequestMapper;
    private final UpdateBlogsRequestMapper updateBlogsRequestMapper;
    private final UpdateBlogsResponseMapper updateBlogsResponseMapper;

    @Override
    public BlogsResponse findListOfBlogs() {
        List<BlogsEntity> blogsEntities = blogsCache.getAllBlogs();
        return blogsResponseMapper.map(blogsEntities);
    }

    @Override
    public BlogsData findBlogById(Long blogId) {
        BlogsEntity blogsEntity = blogsCache.filterBlogsById(blogId);
        return blogsDataMapper.mapBlogs(blogsEntity);
    }

    @Override
    public BlogsData findBlogByTitle(String blogTitle) {
        BlogsEntity blogsEntity = blogsCache.filterBlogsByTitle(blogTitle);
        return blogsDataMapper.mapBlogs(blogsEntity);
    }

    @Override
    public BlogsData findBlogsByUrl(String url) {
        BlogsEntity blogsEntity = blogsCache.filterBlogsByUrl(url);
        return blogsDataMapper.mapBlogs(blogsEntity);
    }

    @Override
    public BlogsResponse findBlogsByAuthor(String author) {
        List<BlogsEntity> blogsEntities = blogsCache.filterBlogsByAuthor(author);
        return blogsResponseMapper.map(blogsEntities);
    }

    @Override
    public BlogsResponse findBlogsByTags(String tags) {
        List<BlogsEntity> blogsEntities = blogsCache.filterBlogsByTags(tags);
        return blogsResponseMapper.map(blogsEntities);
    }

    @Override
    public MetaResponse addNewBlog(BlogsRequest blogsRequest) {
        Optional<BlogsEntity> blogsEntity = blogRepository.findById(blogsRequest.getId());
        if(blogsEntity.isPresent()) {
            throw new ResourceAlreadyExistsException(EXISTING_BLOG_ERROR);
        } else {
            blogRepository.save(blogsRequestMapper.mapRequest(blogsRequest));
        }
        return metaResponseMapper.map(POST_BLOG_SUCCESS_MESSAGE);
    }

    @Override
    public BlogsData updateBlogDetails(BlogsRequest blogsRequest) {
        BlogsEntity blogsEntity = blogRepository.findById(blogsRequest.getId()).orElseThrow(() -> new ResourceNotFoundException(MISSING_BLOG_ERROR));
        blogRepository.save(updateBlogsRequestMapper.mapRequest(blogsRequest, blogsEntity));
        return updateBlogsResponseMapper.mapResponse(blogsEntity);
    }

    @Override
    public MetaResponse deleteBlogsById(Long id) {
        BlogsEntity blogsEntity = blogRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MISSING_BLOG_ERROR));
        blogRepository.delete(blogsEntity);
        return metaResponseMapper.map(DELETE_TOPIC_SUCCESS_MESSAGE);
    }
}