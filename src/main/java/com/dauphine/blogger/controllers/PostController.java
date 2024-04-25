package com.dauphine.blogger.controllers;

import com.dauphine.blogger.dto.CreationPostRequest;
import com.dauphine.blogger.dto.UpdatePostRequest;
import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.services.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/posts")
@Tag(
        name="Posts",
        description = "All endpoints regarding posts"
)
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("")
    @Operation(
            summary = "Get all categories"
    )
    public List<Post> getAllPosts(){
        return postService.getAll();
    }

    @PostMapping("")
    @Operation(
            summary = "Create new post"
    )
    public Post createPost(
            @Parameter(description = "Object with the necessary parameters to create a new post")
            @RequestBody CreationPostRequest body){
        return postService.create(body.getTitle(), body.getContent(), body.getCategoryId());
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update post"
    )
    public Post updatePost(
            @Parameter(description = "Id of the post to update")
            @PathVariable UUID id,
            @Parameter(description = "Object with the necessary parameters to update a new post")
            @RequestBody UpdatePostRequest body){
        return postService.update(id, body.getTitle(), body.getContent());
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete a post"
    )
    public void deletePost(
            @Parameter(description = "Id of the post to delete")
            @PathVariable UUID id){
        postService.deleteById(id);
    }

    @GetMapping("")
    @Operation(
            summary = "Posts ordered by creation date"
    )
    public List<Post> getAllPostsOrderedByDate(){
        return new ArrayList<>();
    }

}
