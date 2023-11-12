package com.cst339.blogsite.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.cst339.blogsite.models.BlogPost;

/*
 * Used to create posts
 */
@Controller
public class BlogPostController {

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
    public String savePost(@ModelAttribute BlogPost blogPost, HttpServletRequest request) {

        // Save the blog post using your logic (e.g., via service)
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

            // For now we will use dummy data
            BlogPost blogPost = new BlogPost(id, "Blog Post Title " + id, "??/??/????", "Person " + id,
                    "Blog Post content" + id);

            model.addAttribute("blogPost", blogPost);

            return "blogPost";
        }

        return "redirect:/";

    }
}
