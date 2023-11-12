package com.cst339.blogsite.services;

import com.cst339.blogsite.models.BlogPost;

public interface BlogService {

    // Used to save blog to database
    public int saveBlog(BlogPost post);

    // Used to delete blog from database
    public boolean deleteBlog(BlogPost post);
}
