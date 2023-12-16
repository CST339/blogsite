package com.cst339.blogsite.data.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.cst339.blogsite.entity.BlogPostEntity;

/**
 * Repostiory to extend Crud repository for BlogPosts
 */
@Repository
public interface BlogPostRepository extends CrudRepository<BlogPostEntity, Long> {
    
}
