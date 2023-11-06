package com.cst339.blogsite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;

import com.cst339.blogsite.models.User;

import org.springframework.ui.Model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

// Creates mappings for "/register" and "/doRegister"
@Controller
public class RegistrationController {

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
        // TODO: Here we would process the registration and add the user to a session.
        // For now we will just add a session cookie
        Cookie cookie = new Cookie("sess", "0x123");
        response.addCookie(cookie);

        return "redirect:/";
    }
}