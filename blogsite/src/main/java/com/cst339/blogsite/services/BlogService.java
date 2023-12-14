package com.cst339.blogsite.services;
import com.cst339.blogsite.models.BlogPostModel;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface BlogService {

    // Used to get all blog posts
    public List<BlogPostModel> findAllBlogPosts();

    // Get all blogPosts from specific Author
    public List<BlogPostModel> findByAuthor(String author);

    // Used to save blog to database
    public boolean saveBlog(BlogPostModel post);

    // Used to get specific blog post
    public BlogPostModel getBlogPostById(int id);

    // Used to delete blog from database
    public boolean deleteBlog(BlogPostModel post);

    // Used to delete blog from database
    public boolean updateBlog(BlogPostModel post);    
}
