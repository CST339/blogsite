package com.cst339.blogsite.services;

import com.cst339.blogsite.models.SubscriptionModel;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Interace to enforce methods to return, add, and remove subscriptions
 */
@Service
public interface SubscriptionSerivce {
    /**
     * Return subscriptions based on user Id
     * @param id The id of the subscription
     * @return
     */
    public List<SubscriptionModel> getSubscriptionsByUserId(int id);

    /**
     * add Subscription 
     * @param subscription The subscription object to add
     * @return
     */
    public boolean addSubscriptoin(SubscriptionModel subscription);

    /**
     * 
     * @param subscription The subscriptions object to remove
     * @return
     */
    public boolean removeSubscription(SubscriptionModel subscription);
}
