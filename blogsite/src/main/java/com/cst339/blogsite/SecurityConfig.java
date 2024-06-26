package com.cst339.blogsite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cst339.blogsite.services.UserServiceImpl;


/**
 * This secures the site by requiring authentication through the database
 */
@Configuration
@EnableWebSecurity
@SuppressWarnings("deprecation")
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    UserServiceImpl service;

    BCryptPasswordEncoder passwordEncoder =  new BCryptPasswordEncoder();

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable()
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/_ah/start").permitAll()
                .antMatchers("/service/**").authenticated()
                .and()
            .authorizeRequests()
                .antMatchers( "/images/**", "/register", "/doRegister").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
                //.defaultSuccessUrl("/", true)
                .and()
            .logout()
                .logoutUrl("/logout")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .permitAll()
                .logoutSuccessUrl("/login");
    }

    /**
     * @param auth Authentication manager
     */
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception{

        auth
        .userDetailsService(service)
        .passwordEncoder(passwordEncoder);
    }
}

