package com.cst339.blogsite.models;

public class SubscriptionModel {

    private Long id;

    // The user who is subscribed to someone
    private Long subscribedUserId;


    // The somone they are subscribed to
    private Long userId;

    public SubscriptionModel(Long id, Long subscribedUserId, Long userId){
        this.id = id;
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
