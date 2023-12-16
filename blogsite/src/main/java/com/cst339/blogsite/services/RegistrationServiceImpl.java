package com.cst339.blogsite.services;

import com.cst339.blogsite.entity.UserEntity;
import com.cst339.blogsite.models.UserModel;
import com.cst339.blogsite.data.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Class to register user
 */
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private UserDataService service;
    
    /**
     * 
     * Method to register user by communicating with Database service
     * @param user The user to be registered entered by user
     */
    @Override
    public boolean registerUser(UserModel user) {
        
        // Logic to register the user, interacting with repositories or databases
        UserEntity userEntity = new UserEntity(null, user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getPhoneNumber(), user.getEmailAddress());
        boolean registered = service.create(userEntity);

        if(registered == true){
            return true; // Return success
        }

        return false; // Return failure
    }
}
