package com.cst339.blogsite.models;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;

public class SubscriptionModel {

    // Unique ID for Subscription
    private Long id;

    // The user who is subscribed to someone
    private Long subscribedUserId;


    // The somone they are subscribed to
    @NotNull
    private Long userId;

    public SubscriptionModel(Long subscribedUserId, Long userId){
        this.subscribedUserId = subscribedUserId;
        this.userId = userId;
    }

    public Long getId(){
        return this.id;
    }

    public Long getUserId(){
        return this.userId;
    }

    public Long getSubscribedUserId(){
        return this.subscribedUserId;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setUserId(Long userId){
        this.userId = userId;
    }

    public void setSubscribedUserId(Long subscribedUserId){
        this.subscribedUserId = subscribedUserId;
    }

}
