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

    /**
     * Construcotr of blog post entity
     * @param id
     * @param title
     * @param date
     * @param author
     * @param content
     */
    public BlogPostEntity(Long id, String title, String date, String author, String content){
        this.id = id;
        this.title = title;
        this.date = date;
        this.author = author;
        this.content = content;
    }

    /**
     * Return blog post id
     * @return
     */
    public Long getId(){
        return this.id;
    }

    /**
     * Set blog post id
     * @param id
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * Set title of blog post
     * @return
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * Set title of blog post
     * @param title
     */
    public void setTitle(String title){
        this.title = title;
    }

    /**
     * Return date of blog post
     * @return
     */
    public String getDate(){
        return this.date;
    }

    /**
     * Set dat of blog post
     * @param date
     */
    public void setDate(String date){
        this.date = date;
    }

    /**
     * Return blog post author
     * @return
     */
    public String getAuthor(){
        return this.author;
    }

    /**
     * Set author for blog post
     * @param author
     */
    public void setAuthor(String author){
        this.author = author;
    }

    /**
     * Return blog post content
     * @return
     */
    public String getContent(){
        return this.content;
    }

    /**
     * Set content for blog post
     * @param content
     */
    public void setContent(String content){
        this.content = content;
    }

}
