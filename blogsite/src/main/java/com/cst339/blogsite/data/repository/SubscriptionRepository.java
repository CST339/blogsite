package com.cst339.blogsite.data.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.cst339.blogsite.entity.SubscriptionEntity;

/**
 * Repostiory to extend Crud repository for Subscriptions
 */
@Repository
public interface SubscriptionRepository extends CrudRepository<SubscriptionEntity, Long>{
    
}