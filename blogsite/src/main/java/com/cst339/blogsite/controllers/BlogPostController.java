package com.cst339.blogsite.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import java.time.LocalDate;
import com.cst339.blogsite.models.BlogPostModel;
import com.cst339.blogsite.services.BlogService;
import com.cst339.blogsite.services.AuthenticationService;

/*
 * Controller for blog posts
 */
@Controller
public class BlogPostController {

    @Autowired
    public BlogService blogService;

    @Autowired
    AuthenticationService authService;

    /**
     * Method to create post
     * @param model
     * @return
     */
    @GetMapping("/createPost")
    public String createPost(Model model) {

        model.addAttribute("title", "Create a Post");

        boolean sessionExists = false;

        sessionExists = authService.isAuthenticated();

        model.addAttribute("authenticated", true);

        // Take unregistered user to login to page
        if (!sessionExists) {
            return "redirect:/";
        }

        String username = authService.getUsername();
        model.addAttribute("username", username);

        return "blogPostForm";
    }

    /**
     * Method to save post
     * @param model
     * @param blogPost
     * @param bindingResult
     * @return
     */
    @PostMapping("/savePost")
    public String savePost(Model model, @Valid BlogPostModel blogPost, BindingResult bindingResult) {


        boolean sessionExists = false;
        String username = null;

        sessionExists = authService.isAuthenticated();
        username = authService.getUsername();

        if(sessionExists){

            model.addAttribute("authenticated", true);

            blogPost.setAuthor(username);

            LocalDate currentDate = LocalDate.now();
            blogPost.setDate(currentDate.toString());

            boolean result = blogService.saveBlog(blogPost);
            System.out.println("result " + result);

            if (result == false || bindingResult.hasErrors()) {
                System.out.println("bindingResult.hasErrors(): " + bindingResult.hasErrors());
                System.out.println(bindingResult);
                return "redirect:/createPost";
            }
        }
        return "redirect:/";

    }

    /**
     * View Blog post 
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/blog/{id}")
    public String blog(Model model, @PathVariable int id) {

        model.addAttribute("title", "Blog Post");

        System.out.println("\nblog post id: " + id);

        // Get the request's cookies
        String username = null;
        boolean sessionExists = false;

        sessionExists = authService.isAuthenticated();

        if (sessionExists) {

            model.addAttribute("authenticated", true);

            username = authService.getUsername();
            model.addAttribute("username", username);

            // Retrieve blog post data based on id.
            BlogPostModel blogPost = blogService.getBlogPostById(id);
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

    /**
     * Update blog post
     * @param model
     * @param blogPost
     * @param bindingResult
     * @return
     */
    @PostMapping("/updatePost")
    public String updateBlog(Model model, @Valid BlogPostModel blogPost, BindingResult bindingResult){

        boolean sessionExists = false;
        String username = null;

        sessionExists = authService.isAuthenticated();
        username = authService.getUsername();

        BlogPostModel blog = blogService.getBlogPostById(blogPost.getId());
        if(sessionExists && username.equals(blog.getAuthor()) ){

            model.addAttribute("authenticated", true);

            blogPost.setAuthor(username);

            LocalDate currentDate = LocalDate.now();
            blogPost.setDate(currentDate.toString());

            boolean result = blogService.updateBlog(blogPost);

            if (result == false || bindingResult.hasErrors()) {
                System.out.println("bindingResult.hasErrors(): " + bindingResult.hasErrors());
                System.out.println(bindingResult);
            }
  
            return "redirect:/blog/" + blogPost.getId();
        }

        return "redirect:/";
    }


    /**
     * Remove blog post
     * @param model
     * @param blogPost
     * @param bindingResult
     * @return
     */
    @PostMapping("/deletePost")
    public String deleteBlog(Model model, @Valid BlogPostModel blogPost, BindingResult bindingResult){

        boolean sessionExists = false;
        String username = null;
        
        sessionExists = authService.isAuthenticated();
        username = authService.getUsername();

        BlogPostModel blog = blogService.getBlogPostById(blogPost.getId());
        if(sessionExists && username.equals(blog.getAuthor()) ){

            model.addAttribute("authenticated", true);

            blogPost.setAuthor(username);

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
