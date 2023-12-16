package com.cst339.blogsite.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Email;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

/**
 * This is the model for a User who registers on the site
 */
public class UserModel {

    // User ID
    // Not set until service generates a new ID
    Integer id;
    

    // Username
    @NotNull(message = "Username is required")
    private String username;

    // Password
    @NotNull(message = "Password is required")
    @Size(min = 6, max = 20, message = "Password must be between 6 and 20 characters")
    private String password;

    // First Name
    @NotNull(message = "First name is required")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    // Last Name
    @NotNull(message = "Last name is required")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    // Phone Number
    @Digits(integer = 10, fraction = 0, message = "Phone number must be a 10-digit number")
    private String phoneNumber;

    // Email Address
    @NotNull(message = "Email address is required")
    @Email(message = "Invalid email address format")
    private String emailAddress;

    // A list of Usernames
    // private List<String> subscriptions;

    public UserModel() {

    }

    /**
     * Constructor for User Model
     * @param username username of user
     * @param password password for user
     * @param firstName first name of user
     * @param lastName last name of user
     * @param phoneNumber phone number of user
     * @param emailAddress the email address of the user
     */
    public UserModel(String username, String password, String firstName, String lastName, String phoneNumber,
            String emailAddress) {
                
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    // getters and setters


    /**
     * Return id of user
     * @return
     */
    public Integer getId(){
        return this.id;
    }

    /**
     * Set id of user
     * @param id
     */
    public void setId(Integer id){
        this.id = id;
    }

    /**
     * return username of user
     * @return
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Return password of user
     * @return
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Return first name of user
     * @return
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Return last name of user
     * @return
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Return phone number of user
     * @return
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Return email address of user
     * @return
     */
    public String getEmailAddress() {
        return this.emailAddress;
    }

    /**
     * Set password of user
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * set username of user
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Set first name of user
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Set last name of user
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Set phone number of user
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Set email address of user
     * @param emailAddress
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}