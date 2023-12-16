package com.cst339.blogsite.services;

import com.cst339.blogsite.models.UserModel;

/**
 * Interface to enforce methods for implementation of UserService which is used for User related functions
 */
public interface UserService {
    public UserModel getUserById(int id);
    public UserModel getUser(String username);
}
