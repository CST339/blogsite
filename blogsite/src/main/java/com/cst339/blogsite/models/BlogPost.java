package com.cst339.blogsite.models;

/**
 * This is the model for a blog post that captures the title, date, author, and
 * actual content of the blog post
 */
public class BlogPost {

    private String title;
    private String date;
    private String author;
    private String content;

    public BlogPost(String title, String date, String author, String content) {
        this.title = title;
        this.date = date;
        this.author = author;
        this.content = content;
    }

    // getters and setters

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
