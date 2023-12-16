package com.cst339.blogsite.data;

import java.util.List;

/**
 * Interface to enforce method implementation to communicate to database
 */
public interface DataAccessInterface <T> {
    
    /**
     * Find all of object in databse
     * @return
     */
    public List<T> findAll();

    /**
     * Find object based on ID
     * @param id
     * @return
     */
    public T findById(int id);

    /**
     * Create object 
     * @param t
     * @return
     */
    public boolean create(T t);

    /**
     * Update object
     * @param t
     * @return
     */
    public boolean update(T t);

    /**
     * Delete object
     * @param t
     * @return
     */
    public boolean delete(T t);
}