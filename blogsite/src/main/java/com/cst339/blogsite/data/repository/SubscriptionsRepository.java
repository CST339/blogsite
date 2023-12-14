package com.cst339.blogsite.data.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.cst339.blogsite.entity.SubscriptionEntity;

@Repository
public interface SubscriptionsRepository extends CrudRepository<SubscriptionEntity, Long>{
    
}