package com.cst339.blogsite.controllers;

import com.cst339.blogsite.models.UserModel;
import com.cst339.blogsite.services.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.validation.Valid;

/**
 * Controller to add user 
 */
@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    /**
     * Shows registration page
     * @param model
     * @param user
     * @return
     */
    @GetMapping("/register")
    public String registerForm(Model model, UserModel user) {
        model.addAttribute("user", new UserModel());
        model.addAttribute("title", "Register"); // Modify title of webpage
        model.addAttribute("user", user);
        model.addAttribute("authenticated", false);
        return "register";
    }

    /**
     * Registers user and returns them to the registration page or the home page
     * @param user
     * @param bindingResult
     * @param model
     * @return
     */
    @PostMapping("/doRegister")
    public String registerSubmit(@Valid UserModel user, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            System.out.println("There are form errors");
            model.addAttribute("userModel", user);
            model.addAttribute("title", "Login Form"); // Modify title of webpage
            return "register";
        }

        // Encrypt password
        String encoded = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encoded);

        // Here, use the injected service to handle user registration
        boolean isUserRegistered = registrationService.registerUser(user);

        if (isUserRegistered) {
            return "redirect:/"; // Redirect to the home page
        } else {
            // Handle registration failure
            return "redirect:/register"; // Redirect to the registration page again
        }
    }
}