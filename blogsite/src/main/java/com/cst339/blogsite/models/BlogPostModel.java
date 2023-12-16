package com.cst339.blogsite.models;

import javax.validation.constraints.NotNull;

/**
 * This is the model for a blog post that captures the title, date, author, and
 * actual content of the blog post
 */
public class BlogPostModel {

    private Integer id;

    @NotNull
    private String title;

    private String date;
    private String author;

    @NotNull
    private String content;

    /**
     * Constructor for BlogPostModel
     * 
     * @param id
     * @param title
     * @param date
     * @param author
     * @param content
     */
    public BlogPostModel(Integer id, String title, String date, String author, String content) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.author = author;
        this.content = content;
    }

    // getters and setters

    /**
     * Set id
     * @param id unique ID for blog post
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Set title
     * @param title string used as title for blog post
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Set date
     * @param date time when blogpost was posted
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Set author
     * @param author name of user who posted blog
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * set content
     * @param content content to set for blog post
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Return unique id of blogpost
     * @return
     */
    public int getId() {
        return this.id;
    }

    /**
     * Return title of blogpost
     * @return
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Return date of blogpost
     * @return
     */
    public String getDate() {
        return this.date;
    }

    /**
     * return auther or user of blogpost
     * @return
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * return content of blog post
     * @return
     */
    public String getContent() {
        return this.content;
    }
}
