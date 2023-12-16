package com.cst339.blogsite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.ArrayList;
import com.cst339.blogsite.models.BlogPostModel;
import com.cst339.blogsite.models.UserModel;
import com.cst339.blogsite.models.SubscriptionModel;
import com.cst339.blogsite.services.UserService;
import com.cst339.blogsite.services.BlogService;
import com.cst339.blogsite.services.AuthenticationService;
import com.cst339.blogsite.services.SubscriptionSerivce;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * Controller for main pages (Blog post display, profiles, and subscriptions)
 */
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

    /**
     * Show all blog posts
     * @param model
     * @return
     */
    @GetMapping("")
    public String index(Model model) {

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


    /**
     * Show subscriptions
     * @param model
     * @return
     */
    @GetMapping("/subscriptions")
    public String subscription(Model model) {

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

    /**
     * Subscribe user
     * @param subscription
     * @return
     */
    @PostMapping("/doSubscribe")
    public String subscribe(@Validated SubscriptionModel subscription) {
        System.out.println("sub");

        System.out.println("\n\nsubscription.getUserId(): " + subscription.getUserId());

        int userId = userService.getUser(authService.getUsername()).getId();
        subscription.setSubscribedUserId((long)userId);
        boolean subscribed = subscriptionService.addSubscriptoin(subscription);

        return "redirect:/profile/" + userService.getUserById(subscription.getUserId().intValue()).getUsername();
    }

    /**
     * Unsubscribe user
     * @param subscription
     * @return
     */
    @PostMapping("/doUnsubscribe")
    public String unsubscribe(SubscriptionModel subscription) {
        System.out.println("unsub");

        int userId = userService.getUser(authService.getUsername()).getId();
        subscription.setSubscribedUserId((long)userId);
        boolean unsubscribed = subscriptionService.removeSubscription(subscription);

        return "redirect:/profile/" + userService.getUserById(subscription.getUserId().intValue()).getUsername();
    }
    


    /**
     * View profile
     * @param model
     * @param username
     * @return
     */
    @GetMapping("/profile/{username}")
    public String Profile(Model model, @PathVariable String username) {

        model.addAttribute("title", "User Profile");

        boolean sessionExists = false;
        sessionExists = authService.isAuthenticated();
        
        if (sessionExists) {

            model.addAttribute("authenticated", true);

            UserModel user = userService.getUser(username); // Retrieve user (to view profile)
            model.addAttribute("user", user); // Add user of profile to model

            if(username.equals(authService.getUsername())){
                System.out.println("OWNER TRUE");
                model.addAttribute("owner", true);
            }else{
                 model.addAttribute("owner", false);
                // Check if authenticated user is subscribed to user
                boolean foundSub = false;
                List<SubscriptionModel> subList = subscriptionService.getSubscriptionsByUserId(userService.getUser(authService.getUsername()).getId());
                for(SubscriptionModel sub: subList){
                    if(sub.getUserId().intValue() == user.getId()){
                        foundSub = true;
                        break;
                    }
                }

                // Check if authenticated user is subscribed to user
                if(foundSub == true){
                    model.addAttribute("subscribed", true);
                }else{
                    model.addAttribute("subscribed", false);
                }
            }

            // Used for navbar item
            String signedInUser = authService.getUsername();
            model.addAttribute("username", signedInUser);

            return "profile";
        }else{
            model.addAttribute("authenticated", false);
        }

        return "redirect:/";
    }

   /**
    * About page
    * @param model
    * @return
    */
    @GetMapping("/about")
    public String about(Model model) {

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
