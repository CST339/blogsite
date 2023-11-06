package com.cst339.blogsite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMethod;

import com.cst339.blogsite.models.User;

// For saving cookies
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "Login");
        return "login"; // Return login template
    }

    @PostMapping("/doLogin")
    public String loginSubmit(User user, Model model, HttpServletResponse response) {

        Cookie cookie = new Cookie("sess", "0x123");
        response.addCookie(cookie);

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(Model model, HttpServletResponse response) {

        // Remove cookie
        Cookie cookie = new Cookie("sess", "");
        cookie.setMaxAge(0); // Set the maximum age to 0 to immediately expire the cookie
        response.addCookie(cookie); // Add the modified cookie to the response

        return "redirect:/";
    }
}