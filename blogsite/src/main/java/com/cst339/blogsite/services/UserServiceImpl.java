package com.cst339.blogsite.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.cst339.blogsite.data.UserDataService;
import com.cst339.blogsite.entity.UserEntity;
import com.cst339.blogsite.models.UserModel;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService{

    @Autowired
    private UserDataService service;

    public UserModel getUserById(int id){
        UserEntity userEntity = service.findById(id);
        
        UserModel user = new UserModel(userEntity.getUserName(), 
                             userEntity.getPassword(), 
                             userEntity.getFirstName(), 
                             userEntity.getLastName(), 
                             userEntity.getPhoneNumber(), 
                             userEntity.getEmailAddress());

        user.setId(userEntity.getId().intValue());

        return user;
    }
    
    public UserModel getUser(String username){

        UserEntity userEntity = service.findByUsername(username);
        
        UserModel user = new UserModel(userEntity.getUserName(), 
                             userEntity.getPassword(), 
                             userEntity.getFirstName(), 
                             userEntity.getLastName(), 
                             userEntity.getPhoneNumber(), 
                             userEntity.getEmailAddress());

        user.setId(userEntity.getId().intValue());

        return user;

    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{

        UserEntity user = service.findByUsername(username);

        if(user != null){
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("USER"));
            return new User(user.getUserName(), user.getPassword(), authorities);

        }else{
            throw new UsernameNotFoundException("username not found");
        }
    }
}
