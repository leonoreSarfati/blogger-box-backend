package com.dauphine.blogger.exceptions;

public class CategoryNameAlreadyExistsException extends Exception{

    public CategoryNameAlreadyExistsException(String name){
        super("Category name "+ name +" already exists");
    }
}
