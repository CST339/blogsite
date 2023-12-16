package com.cst339.blogsite.data;

import com.cst339.blogsite.entity.SubscriptionEntity;
import com.cst339.blogsite.data.mapper.SubscriptionRowMapper;
import com.cst339.blogsite.data.repository.SubscriptionRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Subscription Service to add edit and remove subscriptions
 */
@Service
public class SubscriptionDataService implements DataAccessInterface<SubscriptionEntity>{

    @Autowired
    private SubscriptionRepository subscriptionsRepository;
    private SubscriptionRowMapper subscriptionRowMapper = new SubscriptionRowMapper();
    @SuppressWarnings("unused")
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    /**
     * Constructor for SubscriptionDataServices
     * @param subscriptionsRepository repository for subscriptions
     * @param dataSource source of data for Subscriptions
     */
    public SubscriptionDataService(SubscriptionRepository subscriptionsRepository, DataSource dataSource){
        this.subscriptionsRepository = subscriptionsRepository;
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    /**
     * Return subscription based on ID
     * @param id unique ID of subscription
     */
    public SubscriptionEntity findById(int id){

        try{

            Optional<SubscriptionEntity> subscriptions = subscriptionsRepository.findById((long) id);

            // Get the first item if the list is present
            if(subscriptions.isEmpty() != true){
                SubscriptionEntity subscription = subscriptions.get();
                return subscription;
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        
        return null;
    }


    /**
     * Return user by id
     * @param id Return the subscriptions based on ID
     * @return
     */
    public List<SubscriptionEntity> findByUserId(int id){

        String sql = String.format("SELECT * FROM SUBSCRIPTIONS WHERE SUBSCRIBED_USER_ID = '%s'", (long) id);
        
        try{
            List<SubscriptionEntity> subscriptions = jdbcTemplateObject.query(sql, subscriptionRowMapper);

            // Get the first item if the list is present
            if(subscriptions.isEmpty() != true){
                return subscriptions;
            }else{
                System.out.println("No subscriptions found");
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Return all subscriptions
     */
    public List<SubscriptionEntity> findAll(){
         
        List<SubscriptionEntity> subscriptions = new ArrayList<SubscriptionEntity>();

        try{
            Iterable<SubscriptionEntity> subscriptionsIterable = subscriptionsRepository.findAll();

            subscriptions = new ArrayList<SubscriptionEntity>();
            subscriptionsIterable.forEach(subscriptions::add);

        }catch(Exception e){
            e.printStackTrace();
        }

         return subscriptions;
    }


    /**
     * 
     * Create subscription object in database
     * @param subscription object to enter into database
     */
    public boolean create(SubscriptionEntity subscription){
        try{
            this.subscriptionsRepository.save(subscription);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * Update Subscription
     * @param subscriptionEntity object to update
     */
     public boolean update(SubscriptionEntity subscriptionEntity){
        return true;
    }   

    /**
     * Delete subscription
     * @param subscriptionEntity subscription to delete
     */
    @Override
    public boolean delete(SubscriptionEntity subscriptionEntity){
        String sql = String.format("DELETE FROM SUBSCRIPTIONS WHERE SUBSCRIBED_USER_ID ='%s' AND USER_ID='%s';", subscriptionEntity.getSubscribedUserId(), subscriptionEntity.getUserId());
        
        try{
            jdbcTemplateObject.execute(sql);

        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
