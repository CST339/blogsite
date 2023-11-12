package com.cst339.blogsite.models;

import javax.validation.constraints.NotNull;

/**
 * This is the model for a blog post that captures the title, date, author, and
 * actual content of the blog post
 */
public class BlogPost {

    private Integer id;

    @NotNull
    private String title;

    private String date;
    private String author;

    @NotNull
    private String content;

    public BlogPost(Integer id, String title, String date, String author, String content) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.author = author;
        this.content = content;
    }

    // getters and setters

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDate() {
        return this.date;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getContent() {
        return this.content;
    }
}
