package com.cst339.blogsite.data;

import com.cst339.blogsite.entity.SubscriptionEntity;
import com.cst339.blogsite.data.mapper.SubscriptionRowMapper;
import com.cst339.blogsite.data.repository.SubscriptionsRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionDataService implements DataAccessInterface<SubscriptionEntity>{

    @Autowired
    private SubscriptionsRepository subscriptionsRepository;
    private SubscriptionRowMapper subscriptionRowMapper = new SubscriptionRowMapper();
    @SuppressWarnings("unused")
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public SubscriptionDataService(SubscriptionsRepository subscriptionsRepository, DataSource dataSource){
        this.subscriptionsRepository = subscriptionsRepository;
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

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

    // Custom Query method for authentication
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

    public boolean create(SubscriptionEntity subscription){
        try{
            this.subscriptionsRepository.save(subscription);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

     public boolean update(SubscriptionEntity subscriptionEntity){
        return true;
    }   

    @Override
    public boolean delete(SubscriptionEntity subscriptionEntity){
        return true;
    }

}
