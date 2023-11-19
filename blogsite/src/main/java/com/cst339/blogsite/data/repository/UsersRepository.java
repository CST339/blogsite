package com.cst339.blogsite.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cst339.blogsite.entity.UserEntity;

@Repository
public interface UsersRepository extends CrudRepository<UserEntity, Long> {
    
}
