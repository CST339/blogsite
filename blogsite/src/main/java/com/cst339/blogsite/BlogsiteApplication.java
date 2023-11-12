package com.cst339.blogsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// import org.springframework.context.annotation.ComponentScan;
// @ComponentScan(basePackages = "com.cst339.blogsite.controllers, com.cst339.blogsite")

@SpringBootApplication
public class BlogsiteApplication {
	public static void main(String[] args) {
		SpringApplication.run(BlogsiteApplication.class, args);
	}
}
