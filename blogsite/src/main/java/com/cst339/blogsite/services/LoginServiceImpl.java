package com.cst339.blogsite.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.cst339.blogsite.data.UserDataService;
import com.cst339.blogsite.entity.UserEntity;

/**
 * Default for authentication but replaced by Security Framework
 */
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDataService service;


    /**
     * Used to verify login credentials
     * @param username The username
     * @param password The password
     */
    public boolean verifyLogin(String username, String password) {

        UserEntity user = service.findByUsername(username);
        System.out.println(user);

       if(user != null && (user.getPassword().equals(password)) ){
            return true;        
       }

        return false;
    }

}
