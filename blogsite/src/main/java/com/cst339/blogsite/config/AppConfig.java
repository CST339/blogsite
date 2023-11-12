package com.cst339.blogsite.config;

import com.cst339.blogsite.services.RegistrationService;
import com.cst339.blogsite.services.RegistrationServiceImpl;
import com.cst339.blogsite.services.LoginService;
import com.cst339.blogsite.services.LoginServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

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
}
