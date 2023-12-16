package com.cst339.blogsite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cst339.blogsite.data.SubscriptionDataService;
import com.cst339.blogsite.entity.SubscriptionEntity;
import com.cst339.blogsite.models.SubscriptionModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Subscription service to return, add, and remove subscription items in database
 */
@Service
public class SubscriptionServiceImpl implements SubscriptionSerivce{

    @Autowired
    SubscriptionDataService subscriptionDataService;

    /**
     * Get subscription by ID
     * 
     * @param id Used to return id
     */
    public List<SubscriptionModel> getSubscriptionsByUserId(int id) {
        List<SubscriptionEntity> subscriptionsEntities = subscriptionDataService.findByUserId(id);

        List<SubscriptionModel> subscriptions = new ArrayList<SubscriptionModel>();

        if(subscriptionsEntities == null){
            return subscriptions;
        }

        for(SubscriptionEntity entity: subscriptionsEntities){
            SubscriptionModel sub = new SubscriptionModel(entity.getSubscribedUserId(), entity.getUserId());
            sub.setId(entity.getId());
            subscriptions.add(sub);
        }

        return subscriptions;
    }


    /**
     * Used to add a new subscription
     * @param subscription The subscription object
     */
    public boolean addSubscriptoin(SubscriptionModel subscription) {
        boolean subscribed = subscriptionDataService.create(new SubscriptionEntity(null, subscription.getSubscribedUserId(), subscription.getUserId()));
        return subscribed;
    }

    /**
     * Used to remove an existing subscription
     * @param subscription The subscription object
     */
    public boolean removeSubscription(SubscriptionModel subscription) {
        boolean unsubscribed = subscriptionDataService.delete(new SubscriptionEntity(null, subscription.getSubscribedUserId(), subscription.getUserId()));
        return unsubscribed;
    }
    
}
