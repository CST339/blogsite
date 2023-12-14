package com.cst339.blogsite.services;

import com.cst339.blogsite.models.UserModel;

public interface UserService {
    public UserModel getUserById(int id);
    public UserModel getUser(String username);
}
