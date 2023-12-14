package com.cst339.blogsite.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import com.cst339.blogsite.data.mapper.BlogRowMapper;
import com.cst339.blogsite.entity.BlogPostEntity;
import com.cst339.blogsite.data.repository.BlogPostRepository;

@Service
public class BlogDataService implements DataAccessInterface<BlogPostEntity>{
    
    @Autowired
    private BlogPostRepository blogPostRepository;
    private BlogRowMapper blogRowMapper = new BlogRowMapper();
    @SuppressWarnings("unused")
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public BlogDataService(BlogPostRepository blogPostRepository, DataSource dataSource){
        this.blogPostRepository = blogPostRepository;
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public BlogPostEntity findById(int id){

        try{

            Optional<BlogPostEntity> blogs = blogPostRepository.findById((long) id);

            // Get the first item if the list is present
            if(blogs.isEmpty() != true){
                BlogPostEntity blog = blogs.get();
                return blog;
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        
        return null;
    }

    // Custom Query method
    public BlogPostEntity findByTitle(String title){

        String sql = String.format("SELECT * FROM BLOGPOSTS WHERE TITLE = '%s'", title);
        
        try{
            List<BlogPostEntity> blogs = jdbcTemplateObject.query(sql, blogRowMapper);

            // Get the first item if the list is present
            if(blogs.isEmpty() != true){
                BlogPostEntity blog = blogs.get(0);
                return blog;
            }else{
                System.out.println("Blogs is empty");
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    // Custom Query method
    public List<BlogPostEntity> findByAuthor(String author){

        String sql = String.format("SELECT * FROM BLOGPOSTS WHERE AUTHOR = '%s'", author);
        
        try{
            List<BlogPostEntity> blogs = jdbcTemplateObject.query(sql, blogRowMapper);

            // Get the first item if the list is present
            if(blogs.isEmpty() != true){
                return blogs;
            }else{
                System.out.println("Blogs is empty");
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public List<BlogPostEntity> findAll(){
         
        List<BlogPostEntity> blogs = new ArrayList<BlogPostEntity>();

        try{
            Iterable<BlogPostEntity> blogsIterable = blogPostRepository.findAll();

            blogs = new ArrayList<BlogPostEntity>();
            blogsIterable.forEach(blogs::add);

        }catch(Exception e){
            e.printStackTrace();
        }

         return blogs;
    }

    public boolean create(BlogPostEntity blog){
        try{
            this.blogPostRepository.save(blog);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

     public boolean update(BlogPostEntity blog){

        try{
            this.blogPostRepository.save(blog);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }   

    @Override
    public boolean delete(BlogPostEntity blog){
        try{
            this.blogPostRepository.deleteById(blog.getId());
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

}

