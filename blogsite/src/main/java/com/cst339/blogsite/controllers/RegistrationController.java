package com.cst339.blogsite.controllers;

import com.cst339.blogsite.models.User;
import com.cst339.blogsite.services.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    // Creates view for registration page
    @GetMapping("/register")
    public String registerForm(Model model, User user) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "Register"); // Modify title of webpage
        model.addAttribute("user", user);
        return "register";
    }

    // Registers user and returns them to the registration page or the home page
    @PostMapping("/doRegister")
    public String registerSubmit(@Valid User user, BindingResult bindingResult, Model model,
                                HttpServletResponse response) {

        if (bindingResult.hasErrors()) {
            System.out.println("There are form errors");
            model.addAttribute("userModel", user);
            model.addAttribute("title", "Login Form"); // Modify title of webpage
            return "register";
        }
        // Here, use the injected service to handle user registration
        boolean isUserRegistered = registrationService.registerUser(user);

        if (isUserRegistered) {
            // Add session logic or cookies here upon successful registration
            Cookie cookie = new Cookie("sess", "0x123");
            response.addCookie(cookie);

            return "redirect:/"; // Redirect to the home page
        } else {
            // Handle registration failure
            return "redirect:/register"; // Redirect to the registration page again
        }
    }
}
