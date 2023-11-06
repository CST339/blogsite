package com.cst339.blogsite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

// Models
import com.cst339.blogsite.models.User;

// For saving cookies
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

// For validation
import javax.validation.Valid;
import org.springframework.validation.BindingResult;

// Contains mappings for /login, /doLogin, and /logout
@Controller
public class LoginController {

    // Creates view for login page
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "Login"); // Modify page title
        return "login"; // Return login template
    }

    // Signs in user and creates a session
    @PostMapping("/doLogin")
    public String loginSubmit(User user, Model model, BindingResult bindingResult,
            HttpServletResponse response) {

        validateLoginFields(user, bindingResult);

        if (bindingResult.hasErrors()) {

            System.out.println("There are form errors");
            model.addAttribute("title", "Login"); // Modify page title
            model.addAttribute("userModel", user);
            return "login";
        }

        Cookie cookie = new Cookie("sess", "0x123");
        response.addCookie(cookie);

        return "redirect:/";
    }

    // removes session and returns user to home page
    @GetMapping("/logout")
    public String logout(Model model, HttpServletResponse response) {

        // Remove cookie
        Cookie cookie = new Cookie("sess", "");
        cookie.setMaxAge(0); // Set the maximum age to 0 to immediately expire the cookie
        response.addCookie(cookie); // Add the modified cookie to the response

        return "redirect:/";
    }

    // Used to manuall validate login
    private void validateLoginFields(User user, BindingResult bindingResult) {
        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            bindingResult.rejectValue("username", "error.username", "Username is required");
        }

        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            bindingResult.rejectValue("password", "error.password", "Password is required");
        }
    }
}