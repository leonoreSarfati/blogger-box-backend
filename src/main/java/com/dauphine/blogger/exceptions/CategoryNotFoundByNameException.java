package com.dauphine.blogger.exceptions;

import java.util.UUID;

public class CategoryNotFoundByNameException extends Exception{

    public CategoryNotFoundByNameException(String name){
        super("Category name "+name+" does not exist");
    }
}
