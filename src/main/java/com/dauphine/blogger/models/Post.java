package com.dauphine.blogger.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="post")
public class Post {

    @Id
    @Column(name="id")
    private UUID id;

    @Column(name="title")
    private String title;

    @Column(name="content")
    private String content;

    @Column(name="created_date")
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    public Post(String title, String content){
        this.id =UUID.randomUUID();
        this.content = content;
        this.title = title;
        this.createdDate = new Date();
    }

    public UUID getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
