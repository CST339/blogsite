package com.cst339.blogsite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cst339.blogsite.data.SubscriptionDataService;
import com.cst339.blogsite.entity.SubscriptionEntity;
import com.cst339.blogsite.models.SubscriptionModel;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionSerivce{

    @Autowired
    SubscriptionDataService subscriptionDataService;

    public List<SubscriptionModel> getSubscriptionsByUserId(int id) {
        List<SubscriptionEntity> subscriptionsEntities = subscriptionDataService.findByUserId(id);

        List<SubscriptionModel> subscriptions = new ArrayList<SubscriptionModel>();

        if(subscriptionsEntities == null){
            return subscriptions;
        }

        for(SubscriptionEntity entity: subscriptionsEntities){
            subscriptions.add(new SubscriptionModel(entity.getId(), entity.getSubscribedUserId(), entity.getUserId() ));
        }

        return subscriptions;
    }


    public boolean addSubscriptoin(SubscriptionModel subscription) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addSubscriptoin'");
    }

    public boolean removeSubscription(SubscriptionModel subscription) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeSubscription'");
    }
    
}
