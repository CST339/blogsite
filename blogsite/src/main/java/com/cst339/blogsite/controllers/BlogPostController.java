package com.cst339.blogsite.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import java.time.LocalDate;

import com.cst339.blogsite.models.BlogPost;
import com.cst339.blogsite.services.BlogService;

/*
 * Used to create posts
 */
@Controller
public class BlogPostController {

    @Autowired
    public BlogService blogService;

    @GetMapping("/createPost")
    public String createPost(Model model, HttpServletRequest request) {

        model.addAttribute("title", "Create a Post");

        // Get the request's cookies
        Cookie[] cookies = request.getCookies();

        boolean sessionExists = false;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("sess".equals(cookie.getName())) {
                    sessionExists = true;
                }
            }
        }

        // Take unregistered user to login to page
        if (!sessionExists) {
            return "redirect:/";
        }

        return "blogPostForm";
    }

    @PostMapping("/savePost")
    public String savePost(@Valid BlogPost blogPost, BindingResult bindingResult, HttpServletRequest request) {


        // Get the request's cookies
        Cookie[] cookies = request.getCookies();

        boolean sessionExists = false;
        String username = null;
    

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("sess".equals(cookie.getName())) {
                    username = cookie.getValue();
                    sessionExists = true;
                }
            }
        }

        if(sessionExists){

            blogPost.setAuthor(username); // TODO - FIX 

            LocalDate currentDate = LocalDate.now();
            blogPost.setDate(currentDate.toString());

            boolean result = blogService.saveBlog(blogPost);

            // TODO: if result is 0 redirect to an error page
            if (result == false || bindingResult.hasErrors()) {
                System.out.println("bindingResult.hasErrors(): " + bindingResult.hasErrors());
                System.out.println(bindingResult);
                return "redirect:/createPost";
            }
        }

        // TODO: Eventually change this to view post just created "/blog/<id>"
        return "redirect:/";

    }

    @GetMapping("/blog/{id}")
    public String Blog(Model model, HttpServletRequest request, @PathVariable int id) {

        model.addAttribute("title", "Blog Post");

        System.out.println("\nblog post id: " + id);

        // Get the request's cookies
        Cookie[] cookies = request.getCookies();

        boolean sessionExists = false;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("sess".equals(cookie.getName())) {
                    sessionExists = true;
                }
            }
        }

        if (sessionExists) {

            // TODO: Put data here to retrieve blog post data based on id.
            BlogPost blogPost = blogService.getBlogPostById(id);


            // For now we will use dummy data
            // BlogPost blogPost = new BlogPost(id, "Blog Post Title " + id, "??/??/????", "Person " + id,
            //         "Blog Post content" + id);

            model.addAttribute("blogPost", blogPost);

            return "blogPost";
        }

        return "redirect:/";

    }
}
