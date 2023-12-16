package com.cst339.blogsite.services;
import com.cst339.blogsite.models.BlogPostModel;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * This interface is used to enforce the methods required for the BlogService implementation
 */
@Service
public interface BlogService {

    /**
     * Used to return all blog posts
     * @return
     */
    public List<BlogPostModel> findAllBlogPosts();

    /**
     * Used to return blogpost based on author name
     * @param author
     * @return
     */
    public List<BlogPostModel> findByAuthor(String author);

    /**
     * Used to save created blog into the database
     *  
     * @param post
     * @return
     */
    public boolean saveBlog(BlogPostModel post);

    /**
     * 
     * Used to return a blog post based on the ID
     * 
     * @param id
     * @return
     */
    public BlogPostModel getBlogPostById(int id);

    /**
     * 
     * Used to delete blogs
     * 
     * @param post
     * @return
     */
    public boolean deleteBlog(BlogPostModel post);

    /**
     * Used to update a specific blog post
     * @param post 
     * @return
     */
    public boolean updateBlog(BlogPostModel post);    
}
