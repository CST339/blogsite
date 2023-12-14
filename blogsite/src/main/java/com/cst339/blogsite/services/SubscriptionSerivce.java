package com.cst339.blogsite.services;

import com.cst339.blogsite.models.SubscriptionModel;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface SubscriptionSerivce {
    public List<SubscriptionModel> getSubscriptionsByUserId(int id);
    public boolean addSubscriptoin(SubscriptionModel subscription);
    public boolean removeSubscription(SubscriptionModel subscription);
}
