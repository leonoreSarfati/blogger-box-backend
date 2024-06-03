package com.dauphine.blogger.services;

import com.dauphine.blogger.exceptions.PostNotFoundByIdException;
import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;

import java.util.List;
import java.util.UUID;

public interface PostService {

    List<Post> getAllByCategoryId(UUID categoryId);
    List<Post> getAll();
    Post getById(UUID id) throws PostNotFoundByIdException;
    Post create(String title, String content, Category category);
    Post update(UUID id, String title, String content) throws PostNotFoundByIdException;
    void deleteById(UUID id);

}
