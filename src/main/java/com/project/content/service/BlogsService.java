package com.project.content.service;

import com.project.content.model.MetaResponse;
import com.project.content.model.blogs.BlogsData;
import com.project.content.model.blogs.BlogsRequest;
import com.project.content.model.blogs.BlogsResponse;

public interface BlogsService {

    BlogsResponse findListOfBlogs();

    BlogsData findBlogById(Long blogId);

    BlogsData findBlogByTitle(String blogTitle);

    BlogsData findBlogsByUrl(String url);

    BlogsResponse findBlogsByAuthor(String author);

    BlogsResponse findBlogsByTags(String tags);

    MetaResponse addNewBlog(BlogsRequest blogsRequest);

    BlogsData updateBlogDetails(BlogsRequest blogsRequest);

    MetaResponse deleteBlogsById(Long id);
}