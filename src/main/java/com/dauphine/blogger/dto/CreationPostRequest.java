package com.dauphine.blogger.dto;

import com.dauphine.blogger.models.Category;

import java.util.UUID;

public class CreationPostRequest {

    private String title;
    private String content;
    private Category category;

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public Category getCategory() {
        return category;
    }

}
