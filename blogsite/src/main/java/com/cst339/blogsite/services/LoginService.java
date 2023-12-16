package com.cst339.blogsite.services;

/**
 * An interface to enforce the method implementation for verifyLogin
 */
public interface LoginService {

    /**
     * @param username The username
     * @param password The password
     */
    public boolean verifyLogin(String username, String password);

}
