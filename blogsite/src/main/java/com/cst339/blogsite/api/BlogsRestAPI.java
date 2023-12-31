package com.cst339.blogsite.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cst339.blogsite.models.BlogPostModel;
import com.cst339.blogsite.services.BlogService;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller for API to return blog posts
 */
@RestController
@RequestMapping("/service")
public class BlogsRestAPI {

    @Autowired
    BlogService service;
    
    /**
     *  Method to get all blog posts
     * @return
     */
    @GetMapping(path="/blogposts")
    public ResponseEntity<?> getAllBlogs(){
        try{

            List<BlogPostModel> blogPosts = service.findAllBlogPosts();
            if(blogPosts.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else{
                return new ResponseEntity<>(blogPosts, HttpStatus.OK);
            }

        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Method to get one blog post (based on ID)
     * @param param
     * @return
     */
    @GetMapping(path="/blogpost")
    public ResponseEntity<?> getBlogPost(@RequestParam String param){

        int id;

        try {
            id = Integer.parseInt(param);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Invalid: Parameter NaN", HttpStatus.OK);
        }


        try{
            BlogPostModel blogPost = service.getBlogPostById(id);
            if(blogPost == null){
                return new ResponseEntity<>("Error: Result Not Found", HttpStatus.OK);
            }else{
                return new ResponseEntity<>(blogPost, HttpStatus.OK);
            }

        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
