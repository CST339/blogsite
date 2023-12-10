package com.cst339.blogsite.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.cst339.blogsite.data.BlogDataService;
import com.cst339.blogsite.models.BlogPost;
import com.cst339.blogsite.entity.BlogPostEntity;

import java.util.ArrayList;
import java.util.List;


public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDataService blogDataService;


    public List<BlogPost> findAllBlogPosts(){

        List<BlogPostEntity> blogPostEntities = blogDataService.findAll();

        List<BlogPost> blogPosts = new ArrayList<BlogPost>();

        for(BlogPostEntity entity: blogPostEntities){
            blogPosts.add(new BlogPost(entity.getId().intValue(), entity.getTitle(), entity.getDate(), entity.getAuthor(), entity.getContent()));
        }
        
        return blogPosts;

    }

    public BlogPost getBlogPostById(int id){
        
        BlogPostEntity blogEntity = blogDataService.findById(id);

        if(blogEntity != null){
            BlogPost blogPost = new BlogPost(id, blogEntity.getTitle(), blogEntity.getDate(), blogEntity.getAuthor(), blogEntity.getContent());

            return blogPost;
        
        }else{
            return null;
        }
    }

    // Saves blog to database
    public boolean saveBlog(BlogPost post) {

        // Add blogpost object to database

        BlogPostEntity blogPostEntity = new BlogPostEntity(null, post.getTitle(), post.getDate(), post.getAuthor(), post.getContent());

        boolean result = blogDataService.create(blogPostEntity);

        return result; // Return id if blog post is saved. id should be 0 if not able to save blog post
    }

    // Deletes blog from database
    public boolean deleteBlog(BlogPost post) {

        // cast Id to LONG
        Long longId = (long) post.getId();

        BlogPostEntity blogPostEntity = new BlogPostEntity(longId, post.getTitle(), post.getDate(), post.getAuthor(), post.getContent());
        boolean result = blogDataService.delete(blogPostEntity);

        return result; // Return true if deleted blog post
    }

    // Deletes blog from database
    public boolean updateBlog(BlogPost post) {

        // cast Id to LONG
        Long longId = (long) post.getId();

        BlogPostEntity blogPostEntity = new BlogPostEntity(longId, post.getTitle(), post.getDate(), post.getAuthor(), post.getContent());
        boolean result = blogDataService.update(blogPostEntity);

        return result; // Return true if deleted blog post
    }

}
