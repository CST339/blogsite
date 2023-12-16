package com.cst339.blogsite.config;

import com.cst339.blogsite.services.RegistrationService;
import com.cst339.blogsite.services.RegistrationServiceImpl;
import com.cst339.blogsite.services.LoginService;
import com.cst339.blogsite.services.LoginServiceImpl;
import com.cst339.blogsite.services.BlogService;
import com.cst339.blogsite.services.BlogServiceImpl;
import com.cst339.blogsite.services.UserService;
import com.cst339.blogsite.services.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for services
 */
@Configuration
@ComponentScan(basePackages = "com.cst339.blogsite")
public class AppConfig {

    @Bean
    RegistrationService registrationService() {
        return new RegistrationServiceImpl();
    }

    @Bean
    LoginService loginService() {
        return new LoginServiceImpl();
    }

    @Bean
    BlogService blogService() {
        return new BlogServiceImpl();
    }

    @Bean
    UserService userService(){
        return new UserServiceImpl();
    }
}
