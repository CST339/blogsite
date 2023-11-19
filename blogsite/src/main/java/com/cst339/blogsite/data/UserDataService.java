package com.cst339.blogsite.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;


import com.cst339.blogsite.data.mapper.UserRowMapper;
import com.cst339.blogsite.entity.UserEntity;
import com.cst339.blogsite.data.repository.UsersRepository;;

@Service
public class UserDataService implements DataAccessInterface<UserEntity>{
    
    @Autowired
    private UsersRepository usersRepository;
    private UserRowMapper userRowMapper = new UserRowMapper();
    @SuppressWarnings("unused")
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public UserDataService(UsersRepository usersRepository, DataSource dataSource){
        this.usersRepository = usersRepository;
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public UserEntity findById(int id){

        try{

            Optional<UserEntity> users = usersRepository.findById((long) id);

            // Get the first item if the list is present
            if(users.isEmpty() != true){
                UserEntity user = users.get();
                return user;
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        
        return null;
    }

    // Custom Query method for authentication
    public UserEntity findByUsername(String username){

        String sql = String.format("SELECT * FROM USERS WHERE USERNAME = '%s'", username);
        
        try{
            List<UserEntity> users = jdbcTemplateObject.query(sql, userRowMapper);

            // Get the first item if the list is present
            if(users.isEmpty() != true){
                UserEntity user = users.get(0);
                return user;
            }else{
                System.out.println("Users is empty");
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public List<UserEntity> findAll(){
         
        List<UserEntity> users = new ArrayList<UserEntity>();

        try{
            Iterable<UserEntity> usersIterable = usersRepository.findAll();

            users = new ArrayList<UserEntity>();
            usersIterable.forEach(users::add);

        }catch(Exception e){
            e.printStackTrace();
        }

         return users;
    }

    public boolean create(UserEntity user){
        try{
            this.usersRepository.save(user);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

     public boolean update(UserEntity user){
        return true;
    }   

    @Override
    public boolean delete(UserEntity user){
        return true;
    }

}
