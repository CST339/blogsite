package com.cst339.blogsite.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name="BLOGPOSTS")
public class BlogPostEntity {
    
    @Id
    Long id;

    @Column("TITLE")
    String title;

    @Column("DATE")
    String date;

    @Column("AUTHOR")
    String author;

    @Column("CONTENT")
    String content;

    public BlogPostEntity(Long id, String title, String date, String author, String content){
        this.id = id;
        this.title = title;
        this.date = date;
        this.author = author;
        this.content = content;
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDate(){
        return this.date;
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getAuthor(){
        return this.author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getContent(){
        return this.content;
    }

    public void setContent(String content){
        this.content = content;
    }

}
