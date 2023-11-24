package com.cst339.blogsite.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.Cookie;
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

        // TODO - THIS IS NOT SECURE
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
    
        // TODO - THIS IS NOT SECURE
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("sess".equals(cookie.getName())) {
                    username = cookie.getValue();
                    sessionExists = true;
                }
            }
        }

        if(sessionExists){

            blogPost.setAuthor(username); // TODO - THIS IS NOT SECURE

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
    public String blog(Model model, HttpServletRequest request, @PathVariable int id) {

        model.addAttribute("title", "Blog Post");

        System.out.println("\nblog post id: " + id);

        // Get the request's cookies
        String username = null;
        Cookie[] cookies = request.getCookies();
        boolean sessionExists = false;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("sess".equals(cookie.getName())) {
                    sessionExists = true;
                    username = cookie.getValue();
                }
            }
        }

        if (sessionExists) {

            // Retrieve blog post data based on id.
            BlogPost blogPost = blogService.getBlogPostById(id);
            model.addAttribute("blogPost", blogPost); // Add for content on webpage

            System.out.println("Session val: " +  username);
            System.out.println("Blog author val: " +  blogPost.getAuthor());
            System.out.println(blogPost.getId());

            if(username != null && username.equals(blogPost.getAuthor())){
                model.addAttribute("isAuthor", true);
                System.out.println("Is author = true");
            }else{
                model.addAttribute("isAuthor", false);
                System.out.println("Is not Authior");
            }

            return "blogPost";
        }

        return "redirect:/";
    }

    @PostMapping("/updatePost")
    public String updateBlog(@Valid BlogPost blogPost, BindingResult bindingResult, HttpServletRequest request){

        // Get the request's cookies
        Cookie[] cookies = request.getCookies();

        boolean sessionExists = false;
        String username = null;
    
        // TODO - THIS IS NOT SECURE
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("sess".equals(cookie.getName())) {
                    username = cookie.getValue();
                    sessionExists = true;
                }
            }
        }

        if(sessionExists){

            blogPost.setAuthor(username); // TODO - THIS IS NOT SECURE

            LocalDate currentDate = LocalDate.now();
            blogPost.setDate(currentDate.toString());

            boolean result = blogService.updateBlog(blogPost);

            // TODO: if result is 0 redirect to an error page
            if (result == false || bindingResult.hasErrors()) {
                System.out.println("bindingResult.hasErrors(): " + bindingResult.hasErrors());
                System.out.println(bindingResult);
            }
  
            return "redirect:/blog/" + blogPost.getId();
        }

        return "redirect:/";
    }


    @PostMapping("/deletePost")
    public String deleteBlog(@Valid BlogPost blogPost, BindingResult bindingResult, HttpServletRequest request){

        // Get the request's cookies
        Cookie[] cookies = request.getCookies();

        boolean sessionExists = false;
        String username = null;
    
        // TODO - THIS IS NOT SECURE
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("sess".equals(cookie.getName())) {
                    username = cookie.getValue();
                    sessionExists = true;
                }
            }
        }

        if(sessionExists){

            blogPost.setAuthor(username); // TODO - THIS IS NOT SECURE

            boolean result = blogService.deleteBlog(blogPost);

            // TODO: if result is 0 redirect to an error page
            if (result == false || bindingResult.hasErrors()) {
                System.out.println("bindingResult.hasErrors(): " + bindingResult.hasErrors());
                System.out.println(bindingResult);
                return "redirect:/" + blogPost.getId();
            }
        }

        return "redirect:/";
    }   


}
