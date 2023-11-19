package com.cst339.blogsite.services;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;

import com.cst339.blogsite.entity.UserEntity;
import com.cst339.blogsite.models.User;
import com.cst339.blogsite.data.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;

public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private UserDataService service;
    
    @Override
    public boolean registerUser(User user) {
        
        
        // Logic to register the user, interacting with repositories or databases
        UserEntity userEntity = new UserEntity(null, user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getPhoneNumber(), user.getEmailAddress());
        boolean registered = service.create(userEntity);

        if(registered == true){
            return true; // Return success
        }

        return false; // Return failure
    }
}
