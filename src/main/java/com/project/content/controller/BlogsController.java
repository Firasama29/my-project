package com.project.content.controller;

import com.project.content.model.MetaResponse;
import com.project.content.model.blogs.BlogsData;
import com.project.content.model.blogs.BlogsRequest;
import com.project.content.model.blogs.BlogsResponse;
import com.project.content.service.BlogsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/blogs")
@RequiredArgsConstructor
public class BlogsController {

    private final BlogsService blogsService;

    @GetMapping
    public ResponseEntity<BlogsResponse> getListOfBlogs() {
        return ResponseEntity.ok(blogsService.findListOfBlogs());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<BlogsData> getBlogById(@PathVariable(name = "id") Long blogId) {
        return ResponseEntity.ok(blogsService.findBlogById(blogId));
    }

    @GetMapping(path = "/title")
    public ResponseEntity<BlogsData> getBlogByTitle(@RequestParam(name = "title") String blogTitle) {
        return ResponseEntity.ok(blogsService.findBlogByTitle(blogTitle));
    }

    @GetMapping(path = "/url")
    public ResponseEntity<BlogsData> getBlogByUrl(@RequestParam(name = "url") String url) {
        return ResponseEntity.ok(blogsService.findBlogsByUrl(url));
    }

    @GetMapping(path = "/author")
    public ResponseEntity<BlogsResponse> getBlogsByAuthor(@RequestParam(name = "author") String authorName) {
        return ResponseEntity.ok(blogsService.findBlogsByAuthor(authorName));
    }

    @GetMapping(path = "/tags")
    public ResponseEntity<BlogsResponse> getBlogsByTags(@RequestParam(name = "tags") String tags) {
        return ResponseEntity.ok(blogsService.findBlogsByTags(tags));
    }

    @PostMapping
    public ResponseEntity<MetaResponse> postBlog(@RequestBody BlogsRequest blogsRequest) {
        return ResponseEntity.ok(blogsService.addNewBlog(blogsRequest));
    }

    @PutMapping
    public ResponseEntity<BlogsData> putBlogs(@RequestBody BlogsRequest blogsRequest) {
        return ResponseEntity.ok(blogsService.updateBlogDetails(blogsRequest));
    }

    @DeleteMapping
    public ResponseEntity<MetaResponse> deleteBlog(@RequestParam(name = "id") Long blogId) {
        return ResponseEntity.ok(blogsService.deleteBlogsById(blogId));
    }
}