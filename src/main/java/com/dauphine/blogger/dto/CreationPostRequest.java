package com.dauphine.blogger.dto;

import java.util.UUID;

public class CreationPostRequest {

    private String title;
    private String content;
    private UUID categoryId;

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public UUID getCategoryId() {
        return categoryId;
    }

}
