package com.cst339.blogsite.services;

import com.cst339.blogsite.models.BlogPost;

public class BlogServiceImpl implements BlogService {

    // Saves blog to database
    public int saveBlog(BlogPost post) {

        // TODO: Create unique ID for blogpost
        int id = 1;

        // TODO: add blogpost object to database

        // TODO: set id equal to 0 if not able to save blogpost

        return id; // Return id if blog post is saved. id should be 0 if not able to save blog post
    }

    // Deletes blog from database
    public boolean deleteBlog(BlogPost post) {

        // TODO: add logic delete blog post from database

        return true; // Return true if deleted blog post
    }
}
