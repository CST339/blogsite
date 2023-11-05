package com.gcu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute User user, Model model) {

        if ("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())) {
            return "home"; // redirect to home on success
        }
        model.addAttribute("error", "Invalid username or password");
        return "login"; // return to login page on failure
    }
}