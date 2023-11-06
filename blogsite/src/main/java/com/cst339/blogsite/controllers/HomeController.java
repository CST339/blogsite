package com.cst339.blogsite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import com.cst339.blogsite.models.BlogPost;

@Controller
@RequestMapping("")
public class HomeController {

    // Home page
    @GetMapping("")
    public String index(Model model, HttpServletRequest request) {

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
            model.addAttribute("authenticated", true); // Set authenticated equal to true
            // Create list of blog posts (dummy data)
            List<BlogPost> blogposts = new ArrayList<BlogPost>();
            blogposts.add(new BlogPost("Blog Post Title 1", "01/01/2001", "Person 1", "~~"));
            blogposts.add(new BlogPost("Blog Post Title 2", "01/01/2001", "Person 2", "~~"));
            blogposts.add(new BlogPost("Blog Post Title 3", "01/01/2001", "Person 3", "~~"));
            blogposts.add(new BlogPost("Blog Post Title 4", "01/01/2001", "Person 4", "~~"));
            blogposts.add(new BlogPost("Blog Post Title 5", "01/01/2001", "Person 5", "~~"));
            blogposts.add(new BlogPost("Blog Post Title 6", "01/01/2001", "Person 6", "~~"));
            blogposts.add(new BlogPost("Blog Post Title 7", "01/01/2001", "Person 7", "~~"));
            blogposts.add(new BlogPost("Blog Post Title 8", "01/01/2001", "Person 8", "~~"));

            model.addAttribute("blogposts", blogposts); // Add list of blog post objects to model

        } else {
            model.addAttribute("authenticated", false); // Set authenticated equal to false
        }

        model.addAttribute("title", "DevDiscourse");
        return "index";
    }

    // About page
    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "About");
        return "about";
    }
}
