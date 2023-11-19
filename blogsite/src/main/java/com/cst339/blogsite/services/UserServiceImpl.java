package com.cst339.blogsite.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.cst339.blogsite.data.UserDataService;
import com.cst339.blogsite.entity.UserEntity;
import com.cst339.blogsite.models.User;

public class UserServiceImpl implements UserService{

    @Autowired
    private UserDataService service;
    
    public User getUser(String username){

        UserEntity userEntity = service.findByUsername(username);
        
        User user = new User(userEntity.getUserName(), 
                             userEntity.getPassword(), 
                             userEntity.getFirstName(), 
                             userEntity.getLastName(), 
                             userEntity.getPhoneNumber(), 
                             userEntity.getEmailAddress());

        return user;

    }
}
