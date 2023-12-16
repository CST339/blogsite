package com.cst339.blogsite.services;

import com.cst339.blogsite.models.UserModel;

/**
 * An interface to force the implemtnation of the registerUser method
 */
public interface RegistrationService {

    /**
     * A method to register a user with a database
     * @param user
     * @return
     */
    boolean registerUser(UserModel user);
}
