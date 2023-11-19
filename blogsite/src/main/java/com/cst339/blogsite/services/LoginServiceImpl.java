package com.cst339.blogsite.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.cst339.blogsite.data.UserDataService;
import com.cst339.blogsite.entity.UserEntity;

public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDataService service;

    // Verifies credentials
    public boolean verifyLogin(String username, String password) {

        // Check that the username and password match with the database
        UserEntity user = service.findByUsername(username);
        System.out.println(user);

        System.out.println("DB Password: " + user.getPassword());
        System.out.println("Entered Password: " + password);

        // TODO - Add encryption step for entered password to compare for encrypted db password
       
        if(user.getPassword().equals(password)){
            return true;
        }
        
        return false;
    }

}
