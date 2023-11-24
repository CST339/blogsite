package com.cst339.blogsite.services;
import com.cst339.blogsite.models.BlogPost;
import java.util.List;

public interface BlogService {

    public List<BlogPost> findAllBlogPosts();

    // Used to save blog to database
    public boolean saveBlog(BlogPost post);

    public BlogPost getBlogPostById(int id);

    // Used to delete blog from database
    public boolean deleteBlog(BlogPost post);

    // Used to delete blog from database
    public boolean updateBlog(BlogPost post);    
}
