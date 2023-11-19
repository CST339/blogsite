package com.cst339.blogsite.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name="USERS")
public class UserEntity {
    
    @Id
    Long id;

    @Column("USERNAME")
    String userName;

    @Column("PASSWORD")
    String password;

    @Column("FIRST_NAME")
    String firstName;

    @Column("LAST_NAME")
    String lastName;

    @Column("PHONE_NUMBER")
    String phoneNumber;

    @Column("EMAIL_ADDRESS")
    String emailAddress;

    public UserEntity(Long id, String userName, String password, String firstName, String lastName, String phoneNumber, String emailAddress){

        this.id = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;

    }

    // getters and setters

    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getUserName(){
        return this.userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return this.firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

     public String getPhoneNumber(){
        return this.phoneNumber;
     }

     public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
     }

     public String getEmailAddress(){
        return this.emailAddress;
     }

     public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
     }
    



}

