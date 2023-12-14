package com.cst339.blogsite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import com.cst339.blogsite.models.BlogPostModel;
import com.cst339.blogsite.models.UserModel;
import com.cst339.blogsite.models.SubscriptionModel;
import com.cst339.blogsite.services.UserService;
import com.cst339.blogsite.services.BlogService;
import com.cst339.blogsite.services.AuthenticationService;
import com.cst339.blogsite.services.SubscriptionSerivce;

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

    @Autowired
    private SubscriptionSerivce subscriptionService;

    // Creates view for the Home page (index page)
    @GetMapping("")
    public String index(Model model, HttpServletRequest request) {

        boolean sessionExists = false;

        sessionExists = authService.isAuthenticated();
        String username = authService.getUsername();
        model.addAttribute("username", username);

        if (sessionExists) {
            model.addAttribute("authenticated", true); // Set authenticated equal to true

            List<BlogPostModel> blogposts = blogService.findAllBlogPosts(); // Create list of blogposts from returned value of serivce
            model.addAttribute("blogposts", blogposts); // Add list of blog post objects to model

        } else {
            model.addAttribute("authenticated", false); // Set authenticated equal to false
        }

        model.addAttribute("title", "DevDiscourse"); // Modify title of webpage
        return "index";
    }


    @GetMapping("/subscriptions")
    public String subscription(Model model, HttpServletRequest request) {

        boolean sessionExists = false;

        sessionExists = authService.isAuthenticated();

        if (sessionExists) {
            model.addAttribute("authenticated", true); // Set authenticated equal to true

            String username = authService.getUsername();
            UserModel user = userService.getUser(username);

            model.addAttribute("username", username);

            List<SubscriptionModel> subscriptions = subscriptionService.getSubscriptionsByUserId(user.getId());

            List<BlogPostModel> blogPosts = new ArrayList<BlogPostModel>();

            for(SubscriptionModel sub: subscriptions){
                
                String author = userService.getUserById(sub.getUserId().intValue()).getUsername();
                List<BlogPostModel> blogs = blogService.findByAuthor(author);
                blogPosts.addAll(blogs);
            }
            if(blogPosts.isEmpty() == false){
                 model.addAttribute("blogposts", blogPosts); // Add list of blog post objects to model
            }
           

        } else {
            model.addAttribute("authenticated", false); // Set authenticated equal to false
        }

        model.addAttribute("title", "DevDiscourse"); // Modify title of webpage
        return "subscriptions";
    }


    @GetMapping("/profile/{username}")
    public String Profile(Model model, HttpServletRequest request, @PathVariable String username) {

        model.addAttribute("title", "User Profile");

        System.out.println("\nAccessing user's profile. id: " + username);

        boolean sessionExists = false;

        sessionExists = authService.isAuthenticated();
        
        if (sessionExists) {

            model.addAttribute("authenticated", true);

            UserModel user = userService.getUser(username); // Retrieve user
            model.addAttribute("user", user); // 

            String signedInUser = authService.getUsername();
            model.addAttribute("username", signedInUser);

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

            String signedInUser = authService.getUsername();
            model.addAttribute("username", signedInUser);
            
            return "about";
        }else{
            model.addAttribute("authenticated", false);
        }

        return "redirect:/";
    }
}
