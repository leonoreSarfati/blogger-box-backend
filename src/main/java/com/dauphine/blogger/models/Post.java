package com.dauphine.blogger.models;

import java.util.Date;
import java.util.UUID;

public class Post {

    private UUID id;
    private String title;
    private String content;
    private Date createdDate;
    private UUID categoryId;

    public Post(String title, String content, UUID categoryId){
        this.id =UUID.randomUUID();
        this.content = content;
        this.title = title;
        this.categoryId = categoryId;
        this.createdDate = new Date();
    }

    public UUID getId() {
        return id;
    }

    public UUID getCategoryId() {
        return categoryId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
