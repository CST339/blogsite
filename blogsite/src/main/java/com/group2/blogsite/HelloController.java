package com.group2.blogsite;

//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/")
    public String main(Model model) {

        model.addAttribute("message", "Main Page");
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model) {

        model.addAttribute("message", "About Page");
        return "about";
    }

}
