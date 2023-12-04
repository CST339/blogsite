package com.cst339.blogsite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import com.cst339.blogsite.models.BlogPost;
import com.cst339.blogsite.models.UserModel;
import com.cst339.blogsite.services.UserService;
import com.cst339.blogsite.services.BlogService;
import com.cst339.blogsite.services.AuthenticationService;

// Contains mappings for the "", and "/about" webpages
@Controller
@RequestMapping("")
public class HomeController {


    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private AuthenticationService authService;

    // Creates view for the Home page (index page)
    @GetMapping("")
    public String index(Model model, HttpServletRequest request) {

        // Get the request's cookies
        //Cookie[] cookies = request.getCookies();

        boolean sessionExists = false;

        sessionExists = authService.isAuthenticated();

        if (sessionExists) {
            model.addAttribute("authenticated", true); // Set authenticated equal to true

            List<BlogPost> blogposts = blogService.findAllBlogPosts(); // Create list of blogposts from returned value of serivce
            model.addAttribute("blogposts", blogposts); // Add list of blog post objects to model

        } else {
            model.addAttribute("authenticated", false); // Set authenticated equal to false
        }

        model.addAttribute("title", "DevDiscourse"); // Modify title of webpage
        return "index";
    }


    @GetMapping("/profile/{username}")
    public String Profile(Model model, HttpServletRequest request, @PathVariable String username) {

        model.addAttribute("title", "User Profile");

        System.out.println("\nAccessing user's profile. id: " + username);

        // Get the request's cookies
        Cookie[] cookies = request.getCookies();

        boolean sessionExists = false;

        sessionExists = authService.isAuthenticated();
        
        if (sessionExists) {

            model.addAttribute("authenticated", true);

            UserModel user = userService.getUser(username); // Retrieve user
            model.addAttribute("user", user); // 

            return "profile";
        }else{
            model.addAttribute("authenticated", false);
        }

        return "redirect:/";
    }

    // Creates a vew for the about page
    @GetMapping("/about")
    public String about(Model model, HttpServletRequest request) {

        boolean sessionExists = false;
        sessionExists = authService.isAuthenticated();
        

        if(sessionExists){
            model.addAttribute("title", "About"); // Modify title of webpage
            model.addAttribute("authenticated", true);
            return "about";
        }else{
            model.addAttribute("authenticated", false);
        }

        return "redirect:/";
    }
}
