package com.dauphine.blogger.models;

import java.util.UUID;

public class Category {

    private UUID id;
    private String name;


    public Category(UUID uuid, String name){
        this.id = uuid;
        this.name=name;
    }
}
