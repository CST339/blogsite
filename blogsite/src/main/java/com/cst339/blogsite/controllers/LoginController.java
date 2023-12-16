package com.cst339.blogsite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.cst339.blogsite.models.UserModel;
import org.springframework.ui.Model;
import com.cst339.blogsite.services.AuthenticationService;

/**
 * Controller used for authentication
 */
@Controller
public class LoginController {

    // @Autowired
    // private LoginService loginService;

    @Autowired
    private AuthenticationService authService;

    /**
     * Show login page
     * @param model
     * @param user
     * @return
     */
    @GetMapping("/login")
    public String login(Model model, UserModel user) {
        model.addAttribute("user", new UserModel());
        model.addAttribute("title", "Login");
        model.addAttribute("user", user);
        model.addAttribute("err", "");

        if(authService.isAuthenticated()){
            model.addAttribute("authenticated", true);
        }else{
            model.addAttribute("authenticated", false);
        }

        return "login"; // Return login template
    }

    /**
     * Mapped to log out user via Security Framework
     * @param model
     * @return
     */
    @GetMapping("/logout")
    public String logout(Model model) {

        return "redirect:/login";
    }
}