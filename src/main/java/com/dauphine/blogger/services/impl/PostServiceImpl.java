package com.dauphine.blogger.services.impl;

import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.repositories.PostRepository;
import com.dauphine.blogger.services.PostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {

    private final List<Post> temporaryPosts;

    private final PostRepository repository;

    public PostServiceImpl(PostRepository repository){
        this.repository = repository;
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
        return repository.findAll();
    }

    @Override
    public Post getById(UUID id) {
        return repository.findById(id)
                .orElse(null);
    }

    @Override
    public Post create(String title, String content, Category category) {
        Post post = new Post(title, content);
        return repository.save(post);
    }

    @Override
    public Post update(UUID id, String title, String content) {
        Post post = getById(id);
        if(post==null){
            return null;
        }
        post.setTitle(title);
        post.setContent(content);
        return repository.save(post);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
