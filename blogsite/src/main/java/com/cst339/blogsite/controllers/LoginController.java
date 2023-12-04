package com.cst339.blogsite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.validation.BindingResult;
// import org.springframework.web.bind.annotation.PostMapping;
import com.cst339.blogsite.models.UserModel;
// import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;
// import com.cst339.blogsite.services.LoginService;
import com.cst339.blogsite.services.AuthenticationService;

// Contains mappings for /login, /doLogin, and /logout
@Controller
public class LoginController {

    // @Autowired
    // private LoginService loginService;

    @Autowired
    private AuthenticationService authService;

    // Creates view for login page
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

    // Signs in user and creates a session
    // @PostMapping("/doLogin")
    // public String loginSubmit(UserModel user, Model model, BindingResult bindingResult, HttpServletResponse response) {

    //     // Check credentials - Set cookie if verifyLogin returns true
    //     if (loginService.verifyLogin(user.getUsername(), user.getPassword())) {
    //         Cookie cookie = new Cookie("sess", user.getUsername());
    //         response.addCookie(cookie);

    //         return "redirect:/";
    //     }

    //     model.addAttribute("err", "Username or Password Incorrect");

    //     return "login";
    // }

    // removes session and returns user to home page
    @GetMapping("/logout")
    public String logout(Model model, HttpServletResponse response) {

        return "redirect:/login";
    }
}