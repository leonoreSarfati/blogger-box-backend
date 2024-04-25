package com.dauphine.blogger.services.impl;

import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.services.PostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {

    private final List<Post> temporaryPosts;

    public PostServiceImpl(){
        this.temporaryPosts = new ArrayList<>();
        temporaryPosts.add(new Post("Title 1", "My first content"));
        temporaryPosts.add(new Post("Title 2", "My second content"));
        temporaryPosts.add(new Post("Title 3", "My third content"));
    }
  /*  @Override
    public List<Post> getAllByCategoryId(UUID categoryId) {
        return temporaryPosts.stream()
                .filter(post -> categoryId.equals(post.getCategoryId()))
                .toList();
    }*/

    @Override
    public List<Post> getAllByCategoryId(UUID categoryId) {
        return null;
    }

    @Override
    public List<Post> getAll() {
        return temporaryPosts;
    }

    @Override
    public Post getById(UUID id) {
        return temporaryPosts.stream()
                .filter(post -> id.equals(post.getId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Post create(String title, String content, UUID categoryId) {
        Post post = new Post(title, content);
        temporaryPosts.add(post);
        return post;
    }

    @Override
    public Post update(UUID id, String title, String content) {
        Post post = temporaryPosts.stream()
                .filter(c -> id.equals(c.getId()))
                .findFirst()
                .orElse(null);
        if(post!=null){
            post.setTitle(title);
            post.setContent(content);
        }
        return post;
    }

    @Override
    public void deleteById(UUID id) {
        temporaryPosts.removeIf(post -> id.equals(post.getId()));
    }
}
