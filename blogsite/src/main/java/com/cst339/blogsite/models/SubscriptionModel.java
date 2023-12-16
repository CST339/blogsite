package com.cst339.blogsite.models;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;

/**
 * Model used for subscriptions
 */
public class SubscriptionModel {

    // Unique ID for Subscription
    private Long id;

    // The user who is subscribed to someone
    private Long subscribedUserId;


    // The somone they are subscribed to
    @NotNull
    private Long userId;

    /**
     * Constructor for SubscriptionModel
     * @param subscribedUserId id of user that is subscribing
     * @param userId id of user that is being subscribed to
     */
    public SubscriptionModel(Long subscribedUserId, Long userId){
        this.subscribedUserId = subscribedUserId;
        this.userId = userId;
    }

    /**
     * Return unique id of subscription
     * @return
     */
    public Long getId(){
        return this.id;
    }

    /**
     * return id of user subscribed to
     * @return
     */
    public Long getUserId(){
        return this.userId;
    }

    /**
     * return id of user subscribing
     * @return
     */
    public Long getSubscribedUserId(){
        return this.subscribedUserId;
    }

    /**
     * Set id of Subscription
     * @param id unique id of subscription
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * Set Id of subscribed user
     * @param userId  user subscribed to
     */
    public void setUserId(Long userId){
        this.userId = userId;
    }

    /**
     * Set Subscribed User ID
     * @param subscribedUserId subscribed user
     */
    public void setSubscribedUserId(Long subscribedUserId){
        this.subscribedUserId = subscribedUserId;
    }

}
