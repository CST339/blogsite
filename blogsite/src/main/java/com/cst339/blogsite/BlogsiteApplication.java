package com.cst339.blogsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BlogsiteApplication {
	public static void main(String[] args) {
		SpringApplication.run(BlogsiteApplication.class, args);
		
		// Used to generate encrypted password to store in DB for testing purposes
		// String encoded = new BCryptPasswordEncoder().encode("password");
		// System.out.print("\n\npassword: " + encoded + "\n\n");
	}
}
