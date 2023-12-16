package com.cst339.blogsite.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Entity used by database for Subscriptions table
 */
@Table(name="SUBSCRIPTIONS")
public class SubscriptionEntity {

    @Id
    private Long id;

    // The user who is subscribed to someone
    @Column("SUBSCRIBED_USER_ID")
    private Long subscribedUserId;


    // The somone they are subscribed to
    @Column("USER_ID")
    private Long userId;


    public SubscriptionEntity(Long id, Long subscribedUserId, Long userId){
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
