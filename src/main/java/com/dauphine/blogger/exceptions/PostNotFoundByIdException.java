package com.dauphine.blogger.exceptions;

import java.util.UUID;

public class PostNotFoundByIdException extends Exception{

    public PostNotFoundByIdException(UUID id){
        super("Post ID "+id+" does not exist");
    }
}
