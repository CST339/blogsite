package com.cst339.blogsite.services;

import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Service used for checking authentication of current user
 */
@Service
public class AuthenticationService {
    
    /**
     * Used to check if the user is logged in
     * @return
     */
    public boolean isAuthenticated(){

        // Access the authenticated user details
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            
            return true;
        }

        return false;
    }

    /**
     * Used to get the username of the logged in user
     * @return
     */
    public String getUsername(){

        // Access the authenticated user details
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();

            return username;
        }else{
            return "";
        }
    }

}
